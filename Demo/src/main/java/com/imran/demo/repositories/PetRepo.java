package com.imran.demo.repositories;

import com.imran.demo.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface PetRepo extends JpaRepository<Pet,Integer> {

}

