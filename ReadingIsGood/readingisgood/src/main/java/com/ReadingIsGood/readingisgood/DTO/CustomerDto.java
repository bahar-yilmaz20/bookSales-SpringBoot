package com.ReadingIsGood.readingisgood.DTO;

import com.ReadingIsGood.readingisgood.Entity.CustomerEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CustomerDto {

    public List<CustomerEntity> customerEntities;
    public int countOfCustomer;

}

