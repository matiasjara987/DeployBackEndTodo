package com.matiasjara.dev.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter @Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    public enum Priority {
        ALTA, 
        MEDIA,
        BAJA;
    }
    
    public enum Urgency {
        URGENTE,
        NO_URGENTE
    }
    public enum Importance {
        IMPORTANTE, 
        NO_IMPORTANTE
    }
    public enum Status {
        NO_INICIADO,
        EN_PROGRESO,
        PENDIENTE,
        COMPLETADA
    }
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @Enumerated(EnumType.STRING)
    private Importance importance;

    @Enumerated(EnumType.STRING)
    private Status status;
}
