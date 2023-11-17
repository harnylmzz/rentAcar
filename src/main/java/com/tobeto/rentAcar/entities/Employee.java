package com.tobeto.rentAcar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "email")
        private String email;

        @Column(name = "password")
        private String password;

        @Column(name = "nationality_id")
        private String nationalityId;

        @Column(name = "phone")
        private String phone;

        @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
        private List<Address> addresses;

}
