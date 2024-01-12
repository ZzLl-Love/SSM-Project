package cn.zyy.mapper;

import cn.zyy.domain.Item;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Zz
 * @Date: 2023/11/16/17:46
 * @Description: 致敬
 */
@Repository
public interface ItemMapper {

    @Insert("insert into item(name, type, remark) value (#{name}, #{type}, #{remark})")
    public int save(Item item);

    @Delete("delete from item where id = #{id}")
    public int delete(Long id);

    @Update("update item set name = #{name}, type=#{type}, remark=#{remark} where id =#{id}")
    public int update(Item item);

    @Select("select * from item where id =#{id}")
    public Item getById(Long id);

    @Select("select * from item where name like concat('%', #{name}, '%')")
    public List<Item> list(String name);

    @Select("select * from item ")
    public List<Item> listNull();
}
