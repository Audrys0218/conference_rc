package lt.nfq.conference.service.dao;

import lt.nfq.conference.domain.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 12/4/13
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryMapperTest extends DaoTestBase {
    private CategoryMapper mapper;

    @Before
    public void setup() {
        mapper = sqlSession.getMapper(CategoryMapper.class);
    }

    @Test
    public void testGetCategories(){
        LinkedList<Category> list = mapper.getCategories();
        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0).getId());

        assertEquals("Informacines technologijos", list.get(0).getTitle());
        assertEquals(Integer.valueOf(2), list.get(1).getId());
        assertEquals("Marketingas", list.get(1).getTitle());

        assertEquals(Integer.valueOf(3), list.get(2).getId());
        assertEquals("Mokymai", list.get(2).getTitle());
    }

    @Test
    public void testGetCategory(){
        Category expected = new Category();
        expected.setId(Integer.valueOf(2));
        expected.setTitle("Marketingas");
        Category actual = mapper.getCategory(2);
        assertEquals(expected, actual);
    }
}
