package com.softwarenation.domen;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Podpredmet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv_podpredmeta;
    private String sifra_podpredmeta;
    @ManyToOne(fetch = FetchType.LAZY)
    private Predmet predmet;
    @OneToMany(mappedBy = "podpredmet",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Task> taskovi = new HashSet<>();

}
