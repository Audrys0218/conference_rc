package lt.nfq.conference.service.dao;

import lt.nfq.conference.domain.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 12/4/13
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryMapper {

    @Select("SELECT id, category_title as title FROM Categories")
    public LinkedList<Category> getCategories();

    @Select("SELECT id, category_title as title FROM Categories WHERE id=#{id}")
    public Category getCategory(@Param("id") int id);
}
