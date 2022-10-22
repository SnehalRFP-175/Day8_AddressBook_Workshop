package com.bridegelabz.addressbookapp.Service;

import com.bridegelabz.addressbookapp.DTO.AddressBookDTO;
import com.bridegelabz.addressbookapp.Exception.AddressBookException;
import com.bridegelabz.addressbookapp.Model.AddressBookData;
import com.bridegelabz.addressbookapp.Repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{

    @Autowired
    private AddressBookRepository addressBookRepository;


    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookDataByID(Long id) {
        return addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookException("Contact Not Present......!"));

    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData updateAddressBookData(Long id, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataByID(id);
        addressBookData.updateAddressBook(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public void deleteAddressBookData(Long id) {
        AddressBookData addressBookData = this.getAddressBookDataByID(id);
        addressBookRepository.delete(addressBookData);
    }

}
