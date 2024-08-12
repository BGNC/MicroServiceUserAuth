package com.bgnc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tbl_auth")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Auth {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;


    private String userName;
    private String password;
    private String email;
    private Boolean isActive;
    private Long createAt;

}
