package com.dbms.telemedicine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "System_Admin")
public class SystemAdmin {
    @Id
    @Column(name = "admin_id")
    String adminId;

    @Column(name = "admin_name")
    String adminName;

    @Column(name = "email_id")
    String emailId;

    @Column(name = "password")
    String password;
}
