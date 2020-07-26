package com.softwarenation.repository;

import com.softwarenation.domen.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "select * from task where advokat_id = ?", nativeQuery = true)
    List<Task> findByAdvokaId(Long idAdvokat);
}
