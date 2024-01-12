package cn.zyy.service.impl;

import cn.zyy.domain.Item;
import cn.zyy.mapper.ItemMapper;
import cn.zyy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Zz
 * @Date: 2023/11/16/17:56
 * @Description: 致敬
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper mapper;

    @Override
    public boolean save(Item item) {
        return mapper.save(item) > 0;
    }

    @Override
    public boolean delete(Long id) {
         return  mapper.delete(id) > 0;
    }

    @Override
    public boolean update(Item item) {
         return mapper.update(item) > 0;
    }

    @Override
    public Item getById(Long id) {
       return  mapper.getById(id);
    }

    @Override
    public List<Item> lists(String name) {

        if(name != null &&  !"".equals(name.trim())){
           return  mapper.list(name);
        }
        return mapper.listNull();
    }
}
