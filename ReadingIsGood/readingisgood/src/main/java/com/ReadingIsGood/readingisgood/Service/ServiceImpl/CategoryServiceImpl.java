package com.ReadingIsGood.readingisgood.Service.ServiceImpl;

import com.ReadingIsGood.readingisgood.Entity.CategoryEntity;
import com.ReadingIsGood.readingisgood.Entity.CategoryType;
import com.ReadingIsGood.readingisgood.Repository.CategoryRepository;
import com.ReadingIsGood.readingisgood.Service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryEntity save(CategoryEntity category) {
        category.setCreatedAt();
        switch (category.getName().toString().toUpperCase()) {
            case "ROMANTIC":
                category.setName(CategoryType.ROMANTIC);
                break;
            case "MYSTERY":
                category.setName(CategoryType.MYSTERY);
                break;
            case "FANTASY":
                category.setName(CategoryType.FANTASY);
                break;
            case "HORROR":
                category.setName(CategoryType.HORROR);
                break;
            case "ACTION":
                category.setName(CategoryType.ACTION);
        }
        return categoryRepository.save(category);
    }
}
