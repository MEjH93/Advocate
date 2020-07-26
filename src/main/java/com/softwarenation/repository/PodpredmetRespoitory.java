package com.softwarenation.repository;

import com.softwarenation.domen.Podpredmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodpredmetRespoitory extends JpaRepository<Podpredmet, Long> {
}
