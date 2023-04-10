package com.imran.demo.controllers;

import com.imran.demo.entities.Pet;
import com.imran.demo.payloads.PetDto;
import com.imran.demo.payloads.UserDto;
import com.imran.demo.response.ApiResponse;
import com.imran.demo.services.PetService;
import com.imran.demo.services.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


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


    @GetMapping("/{petId}")
    public ResponseEntity<PetDto> getPetById(@PathVariable Integer petId) {
        return ResponseEntity.ok(this.petService.getPetByID(petId));
    }

    @PutMapping("/{petId}")
    public ResponseEntity<PetDto> updatePet(@RequestBody PetDto petDto, @PathVariable("petId") Integer petId) {
        PetDto updatePet = this.petService.updatePet(petDto, petId);
        return ResponseEntity.ok(updatePet);
    }


    @PutMapping("/{petId}/formData")
    public ResponseEntity<ApiResponse> updateWithFormData(@PathVariable("petId") Integer petId, @RequestParam String name, @RequestParam String status) {
        this.petService.updateWithFormData(petId, name, status);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Pet Updated Successfully", true), HttpStatus.OK);    }

    @DeleteMapping("/{petId}")
    public ResponseEntity<ApiResponse> deletePet(@PathVariable("petId") Integer petId)
    {
        this.petService.deletePet(petId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Pet Deleted Successfully", true), HttpStatus.OK);
    }


//    @PostMapping("{/{petId}/uploadImage")
//        public ResponseEntity<ApiResponse> uploadImage(@PathVariable("petId") Integer petId, @RequestParam("uploadImage")MultipartFile file) throws IOException {
//            this.petService.uploadImage(file,petId);
//            return new ResponseEntity<ApiResponse>(new ApiResponse("Pet Image Uploaded Successfully",true), HttpStatus.OK);
//        }
}
