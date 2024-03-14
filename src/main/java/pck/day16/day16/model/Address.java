package pck.day16.day16.model;

public class Address {
    private String line1;
    private String line2;
    private String postal;
    
    public Address(String line1, String line2, String postal) {
        this.line1 = line1;
        this.line2 = line2;
        this.postal = postal;
    }
    
    public String getLine1() {
        return line1;
    }
    public void setLine1(String line1) {
        this.line1 = line1;
    }
    public String getLine2() {
        return line2;
    }
    public void setLine2(String line2) {
        this.line2 = line2;
    }
    public String getPostal() {
        return postal;
    }
    public void setPostal(String postal) {
        this.postal = postal;
    }
}
