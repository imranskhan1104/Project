package com.imran.demo.services.impl;

import com.imran.demo.entities.*;
import com.imran.demo.exception.ResourceNotFoundException;
import com.imran.demo.payloads.PetDto;
//import com.imran.demo.repositories.PetImageRepo;
import com.imran.demo.repositories.PetRepo;
import com.imran.demo.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepo petRepo;

//    @Autowired
//    private PetImageRepo petImageRepo;



    @Override
    public PetDto getPetByID(Integer petId) {
        Pet pet =this.petRepo.findById(petId).orElseThrow(()-> new ResourceNotFoundException("Pet"," id ",petId));
        return this.petToDto(pet);
    }

    @Override
    public PetDto addPet(PetDto petDto) {
        Pet pet=this.dtoToPet(petDto);
        Pet savedPet = this.petRepo.save(pet);
        return this.petToDto(savedPet);
    }

    @Override
    public PetDto updatePet(PetDto petDto, Integer petId) {
        Pet pet =this.petRepo.findById(petId).orElseThrow(()-> new ResourceNotFoundException("Pet"," id ",petId));
        pet.setCategory(petDto.getCategory());
        pet.setName(petDto.getName());
        pet.setPhotoUrls(petDto.getPhotoUrls());
        pet.setTags(petDto.getTags());
        pet.setStatus(petDto.getStatus());

        Pet updatePet=this.petRepo.save(pet);
        return this.petToDto(updatePet);
    }

    @Override
    public void updateWithFormData(Integer petId, String name, String status) {
        Pet pet =this.petRepo.findById(petId).orElseThrow(()-> new ResourceNotFoundException("Pet"," id ",petId));

        pet.setName(name);
        pet.setStatus(status);
        this.petRepo.save(pet);
    }

    @Override
    public void deletePet(Integer petId) {
        Pet pet=this.petRepo.findById(petId).orElseThrow(()-> new ResourceNotFoundException("Pet"," id ",petId));
        this.petRepo.delete(pet);
    }

//    @Override
//    public void uploadImage(MultipartFile file, Integer petId) throws IOException {
//        PetImageRepo pet=this.petImageRepo.findById(petId).orElseThrow(()-> new ResourceNotFoundException("Pet"," id ",petId));
//        PetImages petImages=new PetImages();
//        petImages.setImage(file.getBytes());
//        petImages.setName(file.getOriginalFilename());
//        this.petImageRepo.save(pet);
//    }


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

//    public PetDto petToDto(Pet pet)
//    {
//        PetDto petDto=new PetDto();
//        petDto.setId(pet.getId());
//        petDto.setCategory(new Category(pet.getCategory().getCid(),pet.getCategory().getName()));
//        petDto.setName(pet.getName());
//        petDto.setPhotoUrls(pet.getPhotoUrls());
//        petDto.setTags(pet.getTags());
//        petDto.setStatus(pet.getStatus());
//
//        return petDto;
//    }

    public PetDto petToDto(Pet pet) {
        PetDto petDto = new PetDto();
        petDto.setId(pet.getId());
        petDto.setCategory(new Category(pet.getCategory().getCid(), pet.getCategory().getName()));
        petDto.setName(pet.getName());
        petDto.setPhotoUrls(pet.getPhotoUrls());
        List<Tag> tag1 = pet.getTags().stream().map(tag -> new Tag(tag.getTid(), tag.getName())).collect(Collectors.toList());
        petDto.setTags(tag1);
        petDto.setStatus(pet.getStatus());
        return petDto;
    }
}
