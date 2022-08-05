package com.rubypaper.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubypaper.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

}









