package com.imran.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;
}
