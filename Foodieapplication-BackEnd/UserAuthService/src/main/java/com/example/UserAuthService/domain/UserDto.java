package com.example.UserAuthService.domain;

public class UserDto {
    private String email;
    private String password;
    private String name;
    private String role;
    private String address;
    private long phoneNo;

    public UserDto() {
    }

    public UserDto(String email, String password, String name, String role, String address, long phoneNo) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
