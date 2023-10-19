package se.lexicon.jpaworkshop.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailsId;

    @Override
    public String toString() {
        return "Details{" +
                "detailsId=" + detailsId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public Details(String email, String name, LocalDate birthDate) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Details() {
    }

    public int getDetailsId() {
        return detailsId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Column(nullable = false, unique = true)
    private String email;
    private String name;
    private LocalDate birthDate;

}