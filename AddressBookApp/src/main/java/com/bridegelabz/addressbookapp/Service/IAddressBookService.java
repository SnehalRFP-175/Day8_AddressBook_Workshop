package com.bridegelabz.addressbookapp.Service;

;

import com.bridegelabz.addressbookapp.DTO.AddressBookDTO;
import com.bridegelabz.addressbookapp.Model.AddressBookData;

import java.util.List;

public interface IAddressBookService
{
    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataByID(Long id);

    AddressBookData createAddressBookData (AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData (Long id,AddressBookDTO addressBookDTO);

    void deleteAddressBookData(Long empId);

}
