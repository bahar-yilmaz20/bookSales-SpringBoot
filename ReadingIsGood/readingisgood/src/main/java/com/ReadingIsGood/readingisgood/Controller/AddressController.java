package com.ReadingIsGood.readingisgood.Controller;

import com.ReadingIsGood.readingisgood.Entity.AddressEntity;
import com.ReadingIsGood.readingisgood.Entity.CustomerEntity;
import com.ReadingIsGood.readingisgood.Repository.AddressRepository;
import com.ReadingIsGood.readingisgood.Service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/api/addresses")
@ComponentScan
@EnableAutoConfiguration
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @RequestMapping(value = "/getAdresses/{id}",method = RequestMethod.GET, produces = "application/json")
    public List<AddressEntity> getAddress(@PathVariable Long id)  {
        return addressService.addressListWithCustomerId(id);
    }

    @RequestMapping(
            value = "/addAddress", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<AddressEntity> addAddress(@RequestBody AddressEntity address) {

        addressService.save(address);
        return new ResponseEntity<AddressEntity>( HttpStatus.OK);
    }
    @RequestMapping(value = "/updateAdresss",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public @ResponseBody AddressEntity updateAddress(@RequestBody AddressEntity address){
        return addressService.updateAddress(address);

    }
    @RequestMapping(value="/deleteAddress",method=RequestMethod.DELETE ,produces = "application/json")
    public Boolean deleteAddress(Long id){
        try {
            addressService.deleteAddress(id);
            return new Boolean(true);
        }
        catch (Exception e){
            return new Boolean(false);
        }
    }
}
