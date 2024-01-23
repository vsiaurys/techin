package lt.techin.demo.models;

import java.util.Date;

public class Actor {

    private long id;
    private String name;
    private char sex;
    private Date dateOfBirth;
    private short height;
    private float rating;
    private double salaryPerDay;
    private String linkToPicture;

    public Actor(long id, String name, char sex, Date dateOfBirth, short height, float rating, double salaryPerDay, String linkToPicture) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.rating = rating;
        this.salaryPerDay = salaryPerDay;
        this.linkToPicture = linkToPicture;
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

    public Date getDateOfBirth() {
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
}


