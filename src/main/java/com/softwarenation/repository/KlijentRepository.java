package com.softwarenation.repository;

import com.softwarenation.domen.Klijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KlijentRepository extends JpaRepository<Klijent,Long> {
    @Query(value = "SELECT * from klijent inner join predmet ON klijent.id = predmet.klijent_id\n" +
            "INNER JOIN podpredmet ON predmet.id = podpredmet.predmet_id\n" +
            "inner join task on task.id = podpredmet.id\n" +
            "INNER JOIN advokat on advokat.id = task.advokat_id\n" +
            "WHERE\n" +
            "klijent.id = ?1 ", nativeQuery = true)
     Klijent findByIdKlijnet(Long id);

}
