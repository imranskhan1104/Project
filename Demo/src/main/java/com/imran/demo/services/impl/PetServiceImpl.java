package com.imran.demo.services.impl;

import com.imran.demo.entities.Pet;
import com.imran.demo.entities.User;
import com.imran.demo.payloads.PetDto;
import com.imran.demo.repositories.PetRepo;
import com.imran.demo.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepo petRepo;


//    @Override
//    public PetDto getPetByID(Integer PetId) {
//        return null;
//    }

    @Override
    public PetDto addPet(PetDto petDto) {
        Pet pet=this.dtoToPet(petDto);
        Pet savedPet = this.petRepo.save(pet);
        return this.petToDto(savedPet);
    }

    public Pet dtoToPet(PetDto petDto)
    {
        Pet pet=new Pet();
        pet.setId(petDto.getId());
        pet.setCategory(petDto.getCategory());
        pet.setName(petDto.getName());
        pet.setPhotoUrls(petDto.getPhotoUrls());
        pet.setTags(petDto.getTags());
        pet.setStatus(petDto.getStatus());

        return pet;
    }

    public PetDto petToDto(Pet pet)
    {
        PetDto petDto=new PetDto();
        petDto.setId(pet.getId());
        petDto.setCategory(pet.getCategory());
        petDto.setName(pet.getName());
        petDto.setPhotoUrls(pet.getPhotoUrls());
        petDto.setTags(pet.getTags());
        petDto.setStatus(pet.getStatus());

        return petDto;
    }
}
