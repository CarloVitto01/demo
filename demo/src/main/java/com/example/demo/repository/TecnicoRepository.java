package com.example.demo.repository;

import com.example.demo.entity.TbTecnico;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepositoryImplementation<TbTecnico, Long> {
}
