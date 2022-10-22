package com.bridegelabz.addressbookapp.Model;

import com.bridegelabz.addressbookapp.DTO.AddressBookDTO;

import com.bridegelabz.addressbookapp.Repository.AddressBookRepository;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addressBook")
public class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String email;
    private String address;
    private String city;
    private String state;
    private String pinCode;

    public AddressBookData( AddressBookDTO addressBookDTO) {
        this.updateAddressBook(addressBookDTO);
    }


    public void updateAddressBook(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO. getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.contactNo = addressBookDTO.getContactNo();
        this.email = addressBookDTO.getEmail();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.pinCode = addressBookDTO.getPinCode();

    }
}
