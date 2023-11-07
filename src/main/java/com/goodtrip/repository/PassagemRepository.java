package com.goodtrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodtrip.model.Passagem;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {

}
