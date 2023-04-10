package com.imran.demo.payloads;

import com.imran.demo.entities.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StoreDto {
    private Integer id;
    private int petId;
    private  int quantity;
    private LocalDateTime shipDate;
    private String status;
    private boolean complete;
}
