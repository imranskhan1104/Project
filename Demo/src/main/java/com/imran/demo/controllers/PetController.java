package com.imran.demo.controllers;

import com.imran.demo.payloads.PetDto;
import com.imran.demo.payloads.UserDto;
import com.imran.demo.services.PetService;
import com.imran.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/pets")
public class PetController {

        @Autowired
        private PetService petService;

        @PostMapping("/")
        public ResponseEntity<PetDto> addPet(@RequestBody PetDto petDto) {
            PetDto createPetDto = this.petService.addPet(petDto);
            return new ResponseEntity<>(createPetDto, HttpStatus.CREATED);
        }
}
