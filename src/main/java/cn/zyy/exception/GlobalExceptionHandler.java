package cn.zyy.exception;

import cn.zyy.common.BaseResponse;
import cn.zyy.common.ErrorCode;
import cn.zyy.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: Zz
 * @Date: 2023/11/21/22:55
 * @Description: 致敬
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 该方法只去捕获我们自定义的异常
     *
     * 使用自定义异常是为了扩展异常信息的字段
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandler(BusinessException e){
        log.error("businessException" + e.getMessage());
        return ResultUtils.error(e.getCode(),e.getMessage(),e.getDescription());
    }

    /**
     * 将系统异常 内部消化，并返回给前端提示
     * @param e
     * @return
     */
    @ExceptionHandler
    public BaseResponse runtimeExceptionHandler(RuntimeException e){

        log.error("runtimeException",e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR,e.getMessage(),"");
    }


}
