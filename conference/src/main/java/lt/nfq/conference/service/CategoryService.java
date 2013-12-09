package lt.nfq.conference.service;

import lt.nfq.conference.domain.Category;
import lt.nfq.conference.service.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 12/4/13
 * Time: 10:29 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public LinkedList<Category> getCategories(){
        return categoryMapper.getCategories();
    }
}
