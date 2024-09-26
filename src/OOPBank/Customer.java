package OOPBank;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static int idCounter = 1;
    private int id;
    private String fullName;
    private String nickname;
    private String address;
    private String birthday;
    private String email;
    private List<Account> accounts;

    public Customer(String fullName, String nickname, String address, String phoneNumber, String birthday) {
        this.id = idCounter++;
        this.fullName = fullName;
        this.nickname = nickname;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.accounts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}