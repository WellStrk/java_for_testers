package ru.stqa.addressbook.model;

public record PhoneNumber(String id, String firstname, String lastname,String middlename, String title, String nickname, String company, String address, String email, String mobile, String photo) {

    public PhoneNumber() {
        this("", "", "", "", "", "", "", "", "", "", "");
    }

    public PhoneNumber withId(String id) {
        return new PhoneNumber(id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo);
    }

    public PhoneNumber withFirstName(String firstname) {
        return new PhoneNumber(this.id, firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo);
    }

    public PhoneNumber withLastName(String lastname) {
        return new PhoneNumber(this.id, this.firstname, lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo);
    }

    public PhoneNumber withAddress(String address) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, address, this.email, this.mobile, this.photo);
    }
    public PhoneNumber withEmail(String email) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, email, this.mobile, this.photo);
    }
    public PhoneNumber withMobile(String mobile) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, mobile, this.photo);
    }
    public PhoneNumber withPhoto(String photo) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, photo);
    }
    public PhoneNumber withMiddleName(String middlename) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo);
    }
    public PhoneNumber withNickname(String nickname) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo);
    }
    public PhoneNumber withCompany(String company) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, company, this.title, this.address, this.email, this.mobile, this.photo);
    }
    public PhoneNumber withTitle(String title) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, title, this.address, this.email, this.mobile, this.photo);
    }
}