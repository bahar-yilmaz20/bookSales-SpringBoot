package com.ReadingIsGood.readingisgood.Repository;

import com.ReadingIsGood.readingisgood.Entity.AddressEntity;
import com.ReadingIsGood.readingisgood.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<CategoryEntity,Long> {

}
