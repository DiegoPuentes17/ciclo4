
package com.ciclo4.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

//Creacion de Getters and Setters
//Creacion de contructores
@Data
@NoArgsConstructor
@AllArgsConstructor

//Creacion tabla USER
@Entity
@Table(name = "user")
public class User implements Serializable{
    
    //Atributos tabla USER
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_email", nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "user_password", nullable = false, length = 50)
    private String password;
    @Column(name = "user_name", nullable = false, length = 80)
    private String name;

}
