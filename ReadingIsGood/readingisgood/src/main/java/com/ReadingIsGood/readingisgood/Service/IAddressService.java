package com.ReadingIsGood.readingisgood.Service;

import com.ReadingIsGood.readingisgood.Entity.AddressEntity;
import com.ReadingIsGood.readingisgood.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddressService {

    public List<AddressEntity> addressListWithCustomerId(Long id);

    public AddressEntity save(AddressEntity addressEntity);

    public AddressEntity updateAddress(AddressEntity address);

    public void deleteAddress(Long id);

}
