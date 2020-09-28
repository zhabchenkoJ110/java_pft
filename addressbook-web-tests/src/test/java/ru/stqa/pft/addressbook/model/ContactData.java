package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String name;
    private final String lastname;
    private final String nickname;
    private final String company;
    private final String address;
    private final String homephone;
    private final String workphone;
    private final String email;
    private final String bday;
    private final String bmonth;
    private final String byear;

    public ContactData(String name, String lastname, String nickname, String company, String address, String homephone, String workphone, String email, String bday, String bmonth, String byear) {
        this.name = name;
        this.lastname = lastname;
        this.nickname = nickname;
        this.company = company;
        this.address = address;
        this.homephone = homephone;
        this.workphone = workphone;
        this.email = email;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public String getEmail() {
        return email;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }
}
