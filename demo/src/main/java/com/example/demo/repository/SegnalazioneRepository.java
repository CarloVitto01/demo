package com.example.demo.repository;

import com.example.demo.entity.TbSegnalazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SegnalazioneRepository extends JpaRepository<TbSegnalazione, Long> {
    @Query("SELECT ts FROM TbSegnalazione ts WHERE ts.date = :date")
    List<TbSegnalazione> findByDate(@Param("date") LocalDate date);
}
