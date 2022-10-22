package com.bridegelabz.addressbookapp.Controller;
import com.bridegelabz.addressbookapp.DTO.AddressBookDTO;
import com.bridegelabz.addressbookapp.DTO.ResponseDTO;
import com.bridegelabz.addressbookapp.Model.AddressBookData;
import com.bridegelabz.addressbookapp.Repository.AddressBookRepository;
import com.bridegelabz.addressbookapp.Service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    @Autowired
    IAddressBookService addressBookService;


    @GetMapping("/Data")
    public ResponseEntity<ResponseDTO> getAddressBookData()
    {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressBookData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", addressBookDataList);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("id") Long id)
    {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.getAddressBookDataByID(id);
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", addressBookData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Address Book Data ", addressBookData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }


    @PutMapping(path = "/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("id") Long id,
                                                                @Valid @RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.updateAddressBookData(id,addressBookDTO);;
        ResponseDTO respDTO = new ResponseDTO("Updated Address Book Data: ", addressBookData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("id") Long id)
    {
        addressBookService.deleteAddressBookData(id);
        ResponseDTO respDTO = new ResponseDTO("Deleted  Data ", id);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }
}