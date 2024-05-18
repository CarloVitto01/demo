package com.example.demo.repository;

import com.example.demo.entity.Segnalazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SegnalazioneRepository extends JpaRepository<Segnalazione, Long> {

    @Query("SELECT s FROM Segnalazione s WHERE s.date = :firstDate")
    List<Segnalazione> segnalazioneFiltered(@Param("firstDate") LocalDate firstDate);

}
