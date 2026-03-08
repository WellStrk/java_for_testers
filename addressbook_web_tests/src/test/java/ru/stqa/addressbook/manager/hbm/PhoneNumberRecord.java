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
    public String middlename;
    public String nickname;
    public String company;
    public String title;
    public String mobile;
    public String home;
    public String work;
  //  public String email;
 //   public String photo;



    public PhoneNumberRecord() {
    }

    public PhoneNumberRecord(int id, String firstname, String lastname, String address, String middlename, String nickname,  String company, String title) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.middlename = middlename;
        this.nickname = nickname;
        this.company = company;
        this.title = title;
        this.mobile = mobile;
        this.home = home;
        this.work = work;
      //  this.email = email;
      //  this.photo = photo;
    }
}



