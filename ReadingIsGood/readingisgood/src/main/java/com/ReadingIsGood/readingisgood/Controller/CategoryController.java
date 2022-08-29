package com.ReadingIsGood.readingisgood.Controller;

import com.ReadingIsGood.readingisgood.Entity.CategoryEntity;
import com.ReadingIsGood.readingisgood.Service.ICategoryService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/category")
@ComponentScan
@EnableAutoConfiguration
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value ="/addCategory", method = RequestMethod.POST, consumes = "Application/json", produces = "Application/json")
    public CategoryEntity addCategory(@RequestBody CategoryEntity category){
        return categoryService.save(category);
    }

}
