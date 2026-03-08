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
                          String work
) {

    public PhoneNumber() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public PhoneNumber withId(String id) {
        return new PhoneNumber(id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work);
    }

    public PhoneNumber withFirstName(String firstname) {
        return new PhoneNumber(this.id, firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work);
    }

    public PhoneNumber withLastName(String lastname) {
        return new PhoneNumber(this.id, this.firstname, lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work);
    }

    public PhoneNumber withAddress(String address) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, address, this.email, this.mobile, this.photo, this.home, this.work);
    }
    public PhoneNumber withEmail(String email) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, email, this.mobile, this.photo, this.home, this.work);
    }
    public PhoneNumber withMobile(String mobile) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, mobile, this.photo, this.home, this.work);
    }
    public PhoneNumber withPhoto(String photo) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, photo, this.home, this.work);
    }
    public PhoneNumber withMiddleName(String middlename) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work);
    }
    public PhoneNumber withNickname(String nickname) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work);
    }
    public PhoneNumber withCompany(String company) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work);
    }
    public PhoneNumber withTitle(String title) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, title, this.address, this.email, this.mobile, this.photo, this.home, this.work);
    }
    public PhoneNumber withHome(String title) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, home, this.work);
    }
    public PhoneNumber withWork(String work) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, work);
    }
    public PhoneNumber withPhone2(String phone2) {
        return new PhoneNumber(this.id, this.firstname, this.lastname, this.middlename, this.nickname, this.company, this.title, this.address, this.email, this.mobile, this.photo, this.home, this.work);
    }
}