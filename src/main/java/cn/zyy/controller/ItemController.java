package cn.zyy.controller;

import cn.zyy.common.BaseResponse;
import cn.zyy.common.ErrorCode;
import cn.zyy.common.ResultUtils;
import cn.zyy.domain.Item;
import cn.zyy.exception.BusinessException;
import cn.zyy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author: Zz
 * @Date: 2023/11/16/18:00
 * @Description
 *
 *定义通用返回类，来让用户返回的类型都是BaseResponse
 *
 *使用全局异常处理器(GlobalExceptionHandler)处理器来处理自定义的异常 BusinessException + 打印日志
 *
 * ==result==
 *
 * 可以将系统中的异常统一起来处理   可以将日志统一进行打印
 *
 *
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    //定义通用返回类型
    BaseResponse baseResponse;

    /**
     * 保存商品
     * @param item
     * @return
     */
    @PostMapping
    public BaseResponse save(@RequestBody Item item){

        //判断数据合法性
        if(item == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        //处理保存操作
        boolean save = itemService.save(item);
        //判断保存结果并返回给前端
        if(save){
            //添加成功
            baseResponse = ResultUtils.success("添加成功");
        }else{
            baseResponse =  ResultUtils.error(ErrorCode.ADD_ERROR);
        }

        return baseResponse;
    }

    /**
     * 修改商品
     * @param item
     * @return
     */
    @PutMapping
    public BaseResponse update(@RequestBody Item item){

        System.out.println("修改商品信息。。。。");

        //判断数据合法性
        if(item == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        boolean updateFlag = itemService.update(item);
        return  updateFlag ? ResultUtils.success("修改成功"):ResultUtils.error(ErrorCode.UPDATE_ERROR);
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public BaseResponse delete(@PathVariable Long id){

        if(id ==null || id < 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "id为null或者小于0");
        }
        boolean deleteFlag = itemService.delete(id);
        return deleteFlag ? ResultUtils.success("删除成功") : ResultUtils.error(ErrorCode.DEL_ERROR);
    }

    /**
     * 根据id查询商品信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public BaseResponse getById(@PathVariable Long id){

        //检验数据合法性，并用全局异常处理器打印日志&返回前端信息
        if(id == null || id<0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"参数为空或者小于0");
        }

        Item item = itemService.getById(id);
        return (item !=null) ? ResultUtils.success(item) : ResultUtils.error(ErrorCode.PARAMS_NULL_ERROR);
    }

    /**
     * 查询所有商品信息
     * @return
     */
    @GetMapping
    public BaseResponse list(@RequestParam(value ="name", required = false) String name){

        List<Item> lists = itemService.lists(name);
        return (lists !=null) ? ResultUtils.success(lists) : ResultUtils.error(ErrorCode.PARAMS_NULL_ERROR);
    }



}
