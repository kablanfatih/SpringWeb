package com.kablanfatih.springweb.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "code", nullable = false, updatable = false, unique = true)
    private String inventoryCode;

    @Column(name = "type", nullable = false)
    private String type;

    public Item(String inventoryCode, String type) {
        this.inventoryCode = inventoryCode;
        this.type = type;
    }

}
