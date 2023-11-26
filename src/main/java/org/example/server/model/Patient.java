package org.example.server.model;

public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private String DOB;
    private String sex;
    private int age;
    private int phone;
    private String address;

    public Patient(int id, String firstName, String lastName, String DOB, String sex, int age, int phone, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
