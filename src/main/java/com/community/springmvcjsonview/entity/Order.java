package com.community.springmvcjsonview.entity;

import com.community.springmvcjsonview.view.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonView(Views.UserDetails.class)
    private Long id;

    @JsonView(Views.UserDetails.class)
    private String product;

    @JsonView(Views.UserDetails.class)
    private Double total;

    @JsonView(Views.UserDetails.class)
    private String status;

    @ManyToOne
    @JsonIgnore
    private User user;
}
