package com.imran.demo.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pet")
@NoArgsConstructor
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;


    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "category")
    private Category category;

//    private String category;
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(joinColumns = @JoinColumn(name = "Id"))
    @Column(name = "photourl")
    private List<String> photoUrls;

    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name = "tag")
    private List<Tag> tags;


    private String status;

}