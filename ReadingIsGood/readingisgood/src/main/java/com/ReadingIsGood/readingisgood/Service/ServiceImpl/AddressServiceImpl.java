package com.ReadingIsGood.readingisgood.Service.ServiceImpl;

import com.ReadingIsGood.readingisgood.Entity.AddressEntity;
import com.ReadingIsGood.readingisgood.Entity.CustomerEntity;
import com.ReadingIsGood.readingisgood.Repository.AddressRepository;
import com.ReadingIsGood.readingisgood.Service.IAddressService;
import com.ReadingIsGood.readingisgood.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ICustomerService customerService;

    @Override
    public List<AddressEntity> addressListWithCustomerId(Long id) {
        CustomerEntity customerEntity = customerService.getCustomer(id);
        return  addressRepository.findAddressEntitiesByCustomer(customerEntity);

    }

    @Override
    public AddressEntity save(AddressEntity addressEntity) {
        CustomerEntity customer = customerService.getCustomer(addressEntity.getCustomer().getId());
        addressEntity.setCustomer(customer);
        return addressRepository.save(addressEntity);
    }

    @Override
    public AddressEntity updateAddress(AddressEntity newAddress) {
        AddressEntity updatedAddress= addressRepository.findById(newAddress.getId()).get();
        updatedAddress.setCity(newAddress.getCity());
        updatedAddress.setDetails(newAddress.getCity());
        updatedAddress.setDistrict(newAddress.getDistrict());
        updatedAddress.setPost_code(newAddress.getPost_code());
        updatedAddress.setStreet(newAddress.getStreet());
        updatedAddress.setUpdated_at(Date.from(Instant.now()));
        return addressRepository.save(updatedAddress);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
