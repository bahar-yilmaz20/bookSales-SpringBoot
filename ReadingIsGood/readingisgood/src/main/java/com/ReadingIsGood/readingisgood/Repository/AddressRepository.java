package com.ReadingIsGood.readingisgood.Repository;

import com.ReadingIsGood.readingisgood.Entity.AddressEntity;
import com.ReadingIsGood.readingisgood.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
    public List<AddressEntity> getAllBy();

    public List <AddressEntity> findAddressEntitiesByCustomer(CustomerEntity customer);

    //@Modifying
    //@Query(value = "update address u set u.status=:newAdress where u.id < :id",nativeQuery = true)
    //public AddressEntity findByIdAndUpdate(@Param("newAddress") AddressEntity newAddress, @Param("id") Long id);
}
