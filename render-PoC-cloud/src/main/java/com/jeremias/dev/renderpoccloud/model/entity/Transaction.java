package com.jeremias.dev.renderpoccloud.model.entity;


import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id

    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "date_time",nullable = false)
    private LocalDateTime createdAt;

    @Column(name ="amount",nullable = false)
    private double amount;

    @Column(name = "description", nullable = false)
    private String description;

}
