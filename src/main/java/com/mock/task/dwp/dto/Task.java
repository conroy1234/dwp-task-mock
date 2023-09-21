package com.mock.task.dwp.dto;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="TASK")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String organisationUnitName;
    private String templateName;
    private int completedBy;



}