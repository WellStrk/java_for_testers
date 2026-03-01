package ru.stqa.addressbook.manager.hbm;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "addressbook")
public class PhoneNumberRecord {

    @Id

    public int id;
    public String firstname;
    public String lastname;
    public String address;
    //public String mobile;
  //  public String email;
 //   public String photo;



    public PhoneNumberRecord() {
    }

    public PhoneNumberRecord(int id, String firstname, String lastname, String address) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        //  this.mobile = mobile;
      //  this.email = email;
      //  this.photo = photo;
    }
}



