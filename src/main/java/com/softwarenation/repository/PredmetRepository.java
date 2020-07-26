package com.softwarenation.repository;

import com.softwarenation.domen.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredmetRepository extends JpaRepository<Predmet,Long> {
}
