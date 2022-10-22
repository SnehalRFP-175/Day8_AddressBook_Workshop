package com.bridegelabz.addressbookapp.DTO;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AddressBookDTO {

    @NotEmpty(message = "First Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "First Name is Invalid.....")
    public String firstName;

    @NotEmpty(message = "Last Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Last Name  is Invalid....!")
    private String lastName;

    @NotEmpty(message = "Contact Number cannot be empty")
    @Size(min = 10,max = 10, message = "Contacts Number Must Have 10 Digits")
    private String contactNo;

    @Email(message = "Enter Valid Email Address....")
    private String email;

    @NotEmpty(message = "Address cannot be empty....")
    private String address;

    @NotEmpty(message = "City cannot be empty...")
    private String city;

    @NotEmpty(message = "State cannot be empty...")
    private String state;

    @Size(min = 6,max = 6, message = "Enter 6 digit Pin Code")
    @NotEmpty(message = "State cannot be empty......")
    private String pinCode;

}
