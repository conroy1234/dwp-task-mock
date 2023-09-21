package com.mock.task.dwp.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="TASK_TEMPLATE")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskTemplate {
    @Id
    private int id;
    private String organisationUnitName;
    private String templateName;
    private String executionUrl;
    private int completedBy;

}