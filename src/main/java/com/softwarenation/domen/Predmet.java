package com.softwarenation.domen;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Builder
public class Predmet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv_predmeta;
    private String sifra_predmeta;
    @ManyToOne(fetch = FetchType.LAZY)
    private Klijent klijent;
    @OneToMany(mappedBy = "predmet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Podpredmet> podpredmeti = new HashSet<>();
}
