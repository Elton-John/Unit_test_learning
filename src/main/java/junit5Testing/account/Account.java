package junit5Testing.account;

import junit5Testing.Address;

public class Account {
    private boolean active;
    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public Account(){
        this.active=false;
    }

    public void activate(){
        this.active = true;
    }

    public boolean isActive(){
        return this.active;
    }
}
