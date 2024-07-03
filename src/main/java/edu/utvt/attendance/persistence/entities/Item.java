package edu.utvt.attendance.persistence.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "item")
public class Item {

    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private Date createdOn;

    @ManyToOne
    private Persona persona;


}


