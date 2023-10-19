package se.lexicon.jpaworkshop.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;
    @Column(nullable = false, unique = true)
    private String userName;
    private String password;
    private LocalDate regDate;
    @OneToOne
    @JoinColumn(name = "details_id")
    private Details details;

    public AppUser() {
    }

    public AppUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.regDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                ", details=" + details +
                '}';
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

}