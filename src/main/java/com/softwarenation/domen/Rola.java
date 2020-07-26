package com.softwarenation.domen;

import lombok.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Rola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    @ManyToMany(mappedBy = "rolas")
    private Set<Korisnik> korisnici = new HashSet<>();
}
