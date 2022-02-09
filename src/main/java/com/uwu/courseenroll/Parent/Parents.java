package com.uwu.courseenroll.Parent;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Parents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String MotherName;
    private String FartherName;
    private String Address;
    private String TP;

    public Parents(String motherName, String fartherName, String address, String TP) {
        MotherName = motherName;
        FartherName = fartherName;
        Address = address;
        this.TP = TP;
    }

    public Parents() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public String getFartherName() {
        return FartherName;
    }

    public void setFartherName(String fartherName) {
        FartherName = fartherName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTP() {
        return TP;
    }

    public void setTP(String TP) {
        this.TP = TP;
    }
}



