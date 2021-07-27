package com.learing.Spring_jwt_jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @Column(name = "ID",insertable = false,nullable = false,updatable = false)
    private UUID id;
    @Column(name = "username", nullable = false,unique = true)
    private String userName;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    @Column(name = "EMAIL", nullable = false, unique = false)
    private String email;
    @Column(name = "MOBILE", nullable = false,unique = true)
    private String mobile;
    @Column(name = "CREATED_DATE")
    private Timestamp createDt;
    @Column(name = "UPDATED_DATE")
    private Timestamp updatedDt;
}
