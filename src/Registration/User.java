package Registration;

import java.util.Date;

public class User {
    private long id;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String address;
    private Date dob;
    private double income;
    private String occupation;

    public User(long id, String password, String name, String surname, String email, String phoneNumber, String address, Date dob, double income, String occupation) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dob = dob;
        this.income = income;
        this.occupation = occupation;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Date getDob() {
        return dob;
    }

    public double getIncome() {
        return income;
    }

    public String getOccupation() {
        return occupation;
    }
}
