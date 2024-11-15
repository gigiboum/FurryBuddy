package ch.unil.furrybuddy.domain;

public class Location {
    private String town;
    private String postalCode;
    private String address;


    public Location(){}

    public Location(String town, String postalCode, String address) {

        this.town = town;
        this.postalCode = postalCode;
        this.address = address;
    }

    // getters and setters

    public String getTown() {
        return town;
    }
    public void setTown(String town) {
        this.town = town;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}