package edu.utvt.attendance.persistence.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "persona")
public class Persona {

    @Id
    @Column(length = 10)
    private UUID id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer edad;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false, columnDefinition = "DATE")
    private Date birthDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private Date createdOn;

    @OneToMany(mappedBy = "persona")
    private List<Item> items;
}
