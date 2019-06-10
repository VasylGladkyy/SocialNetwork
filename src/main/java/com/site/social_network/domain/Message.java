package com.site.social_network.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Massage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="create_date",nullable = false)
    private String text;
}
