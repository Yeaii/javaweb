package com.example.demo.repository;

import com.example.demo.domain.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterDao extends JpaRepository<Writer, Long> {
    Writer findByWname(String wname);
}