package com.imran.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface PetImagRepo extends JpaRepository<Image, Long> {
}
