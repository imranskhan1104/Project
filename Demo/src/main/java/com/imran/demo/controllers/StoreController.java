package com.imran.demo.controllers;

import com.imran.demo.entities.Pet;
import com.imran.demo.entities.Store;
import com.imran.demo.payloads.PetDto;
import com.imran.demo.payloads.StoreDto;
import com.imran.demo.repositories.PetRepo;
import com.imran.demo.repositories.StoreRepo;
import com.imran.demo.response.ApiResponse;
import com.imran.demo.services.StoreService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private PetRepo petRepo;

    @PostMapping("/")
    public ResponseEntity<?> placeOrder(@RequestBody StoreDto storeDto)
    {
        Optional<Pet> pet=this.petRepo.findById(storeDto.getPetId());

        if (pet.isPresent())
        {
            StoreDto placeOrder = this.storeService.placeOrder(storeDto);
            return new ResponseEntity<>(placeOrder, HttpStatus.CREATED);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("No pet with the given pet ID", false));
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable("orderId") Integer orderId)
    {
        this.storeService.deleteOrder(orderId);
        return new ResponseEntity<ApiResponse> (new ApiResponse("Order Deleted Successfully", true), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<StoreDto> findOrderById(@PathVariable("orderId")Integer orderId)
    {
        return ResponseEntity.ok(this.storeService.findOrderById(orderId));
    }

    @GetMapping("/")
    public ResponseEntity<HashMap<String,Integer>> countByStatus()
    {
        return ResponseEntity.ok(this.storeService.countByStatus());
    }
}
