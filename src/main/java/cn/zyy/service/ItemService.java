package cn.zyy.service;

import cn.zyy.domain.Item;

import java.util.List;

/**
 * @Author: Zz
 * @Date: 2023/11/16/17:53
 * @Description: 致敬
 */
public interface ItemService {

    /**
     * 添加物品
     * @param item
     * @return
     */
    public boolean save(Item item);

    /**
     * 删除物品
     * @param id
     * @return
     */
    public boolean delete(Long id);

    /**
     * 修改物品
     */
    public boolean update(Item item);

    /**
     * 根据id查询商品物品
     * @param id
     * @return
     */
    public Item getById(Long id);

    /**
     * 查询所有的物品
     * @return
     * @param name
     */
    public List<Item> lists(String name);


}
