package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author NikcQ
 */
@Entity
@Table(name = "Clients")

public class Client {

    private String Fname;
    private String Lname;
    private LocalDate birthDate;
    private String ic;
    private int scoreBalance;
    private String phone;
    private String email;
    private String address;
    private String category;
    //private int idType;   pendiente de revisar si lo incluimos en el panel o no.
    private int totalScore;//Este se puede agregar para saber cuando debe ascender el cliente de categoria 
    //private boolean activity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client() {
    }

    public Client(String name, String lastName, LocalDate birthDate,String ic,  String phone, String mail, String address) {
        this.Fname = name;
        this.Lname = lastName;
        this.ic = ic;
        this.birthDate = birthDate;
        this.email = mail;
        this.phone = phone;
        this.address = address;
        this.category = "Basic";
        this.scoreBalance = 0;
        this.totalScore = 0;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public int getScoreBalance() {
        return scoreBalance;
    }

    public void setScoreBalance(int scoreBalance) {
        this.scoreBalance = scoreBalance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Client{" + "Fname=" + Fname + ", Lname=" + Lname + ", birthDate=" + birthDate + ", ic=" + ic + ", scoreBalance=" + scoreBalance + ", phone=" + phone + ", email=" + email + ", address=" + address + ", category=" + category + ", totalScore=" + totalScore + ", id=" + id + '}';
    }

}
