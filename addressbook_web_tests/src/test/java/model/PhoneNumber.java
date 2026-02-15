package model;

public record PhoneNumber(String id, String firstname, String lastname, String address, String email, String mobile) {

    public PhoneNumber() {
        this("", "", "", "", "", "");
    }

    public PhoneNumber withId(String id) {
        return new PhoneNumber(id, this.firstname, this.lastname, this.address, this.email, this.mobile);
    }

    public PhoneNumber withFirstName(String firstname) {
        return new PhoneNumber(this.id, firstname, this.lastname, this.address, this.email, this.mobile);
    }

    public PhoneNumber withLastName(String lastname) {
        return new PhoneNumber(this.id, this.firstname, lastname, this.address, this.email, this.mobile);
    }

    public PhoneNumber withAddress(String address) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, address, this.email, this.mobile);
    }
    public PhoneNumber withEmail(String email) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.address, email, this.mobile);
    }
    public PhoneNumber withMobile(String mobile) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.address, this.email, mobile);
    }
}