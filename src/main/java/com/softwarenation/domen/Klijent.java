package com.softwarenation.domen;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@Entity
public class Klijent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    @OneToMany(mappedBy = "klijent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Predmet> predmeti = new HashSet<>();
}
