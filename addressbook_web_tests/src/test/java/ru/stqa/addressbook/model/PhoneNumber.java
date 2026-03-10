package ru.stqa.addressbook.model;

public record PhoneNumber(String id,
                          String firstname,
                          String lastname,
                          String middlename,
                          String title,
                          String nickname,
                          String company,
                          String address,
                          String email,
                          String mobile,
                          String photo,
                          String home,
                          String work,
                          String email2, String email3) {

    public PhoneNumber() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public PhoneNumber withId(String id) {
        return new PhoneNumber(id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work, this.email2, this.email3);
    }

    public PhoneNumber withFirstName(String firstname) {
        return new PhoneNumber(this.id, firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work, this.email2, this.email3);
    }

    public PhoneNumber withLastName(String lastname) {
        return new PhoneNumber(this.id, this.firstname, lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work, this.email2, this.email3);
    }

    public PhoneNumber withAddress(String address) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, address, this.email, this.mobile, this.photo, this.home, this.work, this.email2, this.email3);
    }
    public PhoneNumber withEmail(String email) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, email, this.mobile, this.photo, this.home, this.work, this.email2, this.email3);
    }
    public PhoneNumber withMobile(String mobile) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, mobile, this.photo, this.home, this.work, this.email2, this.email3);
    }
    public PhoneNumber withPhoto(String photo) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, photo, this.home, this.work, this.email2, this.email3);
    }
    public PhoneNumber withMiddleName(String middlename) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work, this.email2, this.email3);
    }
    public PhoneNumber withNickname(String nickname) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work, this.email2, this.email3);
    }
    public PhoneNumber withCompany(String company) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work, this.email2, this.email3);
    }
    public PhoneNumber withTitle(String title) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, title, this.address, this.email, this.mobile, this.photo, this.home, this.work, this.email2, this.email3);
    }
    public PhoneNumber withHome(String home) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, home, this.work, this.email2, this.email3);
    }
    public PhoneNumber withWork(String work) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, work, this.email2, this.email3);
    }

    public PhoneNumber withEmail2(String email2) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work, email2, this.email3);
    }
    public PhoneNumber withEmail3(String email3) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work, this.email2, email3);
    }
}