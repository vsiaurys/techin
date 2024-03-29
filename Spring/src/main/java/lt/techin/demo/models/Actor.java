package lt.techin.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private char sex;
    private LocalDate dateOfBirth;
    private short height;
    private float rating;
    private double salaryPerDay;
    private String linkToPicture;

    public Actor(String name, char sex, LocalDate dateOfBirth, short height, float rating, double salaryPerDay, String linkToPicture) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.rating = rating;
        this.salaryPerDay = salaryPerDay;
        this.linkToPicture = linkToPicture;
    }

    public Actor() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public short getHeight() {
        return height;
    }

    public float getRating() {
        return rating;
    }

    public double getSalaryPerDay() {
        return salaryPerDay;
    }

    public String getLinkToPicture() {
        return linkToPicture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setHeight(short height) {
        this.height = height;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setSalaryPerDay(double salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

    public void setLinkToPicture(String linkToPicture) {
        this.linkToPicture = linkToPicture;
    }
}



