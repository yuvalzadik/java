package org.example;

public class User {
    private byte id;
    private String name;
    private String username;
    private String email;
    Address AddressObject;
    private String phone;
    private String website;
    Company CompanyObject;
    Geo GeoObject;

    public Geo getGeoObject() {
        return GeoObject;
    }

    public void setGeoObject(Geo geoObject) {
        GeoObject = geoObject;
    }
// Getter Methods

    public byte getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return AddressObject;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return CompanyObject;
    }

    // Setter Methods

    public void setId(byte id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address addressObject) {
        this.AddressObject = addressObject;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setCompany(Company companyObject) {
        this.CompanyObject = companyObject;
    }
}



