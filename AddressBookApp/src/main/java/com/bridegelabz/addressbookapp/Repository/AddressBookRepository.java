package com.bridegelabz.addressbookapp.Repository;

import com.bridegelabz.addressbookapp.Model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData,Long> {

    List<AddressBookData> sortByCity(String city);

}
