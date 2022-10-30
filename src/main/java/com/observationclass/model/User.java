package com.observationclass.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name="account",uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Getter
@Setter


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "user_name")
    private String userName;
    @Email
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Column(name="password")
    private String password;

    @Column(name= "address")
    private String address;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;


    @Column(name="campus_id")
    private Integer campusId ;

    @Column(name="deleted_flag")
    private Integer deletedFlag;

    @Column(name="department_id")
    private Integer departmentId;

}
