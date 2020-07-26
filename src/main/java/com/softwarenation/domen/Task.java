package com.softwarenation.domen;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate datum;
    private Integer utrosenoVreme;
    private String opis;
    @ManyToOne(fetch = FetchType.LAZY)
    private Advokat advokat;
    @ManyToOne(fetch = FetchType.LAZY)
    private Podpredmet podpredmet;
}
