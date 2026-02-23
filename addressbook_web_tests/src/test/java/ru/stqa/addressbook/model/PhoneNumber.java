package ru.stqa.addressbook.model;

public record PhoneNumber(String id, String firstname, String lastname, String address, String email, String mobile, String photo) {

    public PhoneNumber() {
        this("", "", "", "", "", "", "");
    }

    public PhoneNumber withId(String id) {
        return new PhoneNumber(id, this.firstname, this.lastname, this.address, this.email, this.mobile, this.photo);
    }

    public PhoneNumber withFirstName(String firstname) {
        return new PhoneNumber(this.id, firstname, this.lastname, this.address, this.email, this.mobile, this.photo);
    }

    public PhoneNumber withLastName(String lastname) {
        return new PhoneNumber(this.id, this.firstname, lastname, this.address, this.email, this.mobile, this.photo);
    }

    public PhoneNumber withAddress(String address) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, address, this.email, this.mobile, this.photo);
    }
    public PhoneNumber withEmail(String email) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.address, email, this.mobile, this.photo);
    }
    public PhoneNumber withMobile(String mobile) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.address, this.email, mobile, this.photo);
    }
    public PhoneNumber withPhoto(String photo) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.address, this.email, this.mobile, photo);
    }
}