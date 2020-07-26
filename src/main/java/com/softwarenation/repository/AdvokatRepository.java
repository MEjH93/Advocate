package com.softwarenation.repository;

import com.softwarenation.domen.Advokat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvokatRepository extends JpaRepository<Advokat, Long> {
   // Advokat deleteById(Advokat advokat);

   /* @Test
    @Transactional
    public void whenDeleteFromDerivedQuery_thenDeletingShouldBeSuccessful() {
        long deletedRecords = repository.deleteByTitle("The Hobbit");
        assertThat(deletedRecords).isEqualTo(1);
    }*/
}
