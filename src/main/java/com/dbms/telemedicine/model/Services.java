package com.dbms.telemedicine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Services")
public class Services {
    @Id
    @Column(name = "service_id")
    String serviceId;

    @Column(name = "service_name")
    String serviceName;

    @Column(name = "description")
    String description;
}
