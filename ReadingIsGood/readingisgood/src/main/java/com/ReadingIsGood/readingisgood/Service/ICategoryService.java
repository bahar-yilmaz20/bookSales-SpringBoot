package com.ReadingIsGood.readingisgood.Service;

import com.ReadingIsGood.readingisgood.Entity.CategoryEntity;
import org.springframework.stereotype.Service;

@Service
public interface ICategoryService {
    public CategoryEntity save(CategoryEntity categoryEntity);
}
