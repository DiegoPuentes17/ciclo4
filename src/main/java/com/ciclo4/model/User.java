
package com.ciclo4.model;

import java.util.Date;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

//Creacion de Getters and Setters
//Creacion de contructores
@Data
@NoArgsConstructor
@AllArgsConstructor

//Creacion de la collection USER
@Document(collection = "usuarios")
public class User{
    
    //Atributos tabla USER
    @Id
    private Integer id;
    private String identification;
    private String name;
    private String address;
    private String cellPhone;
    private String email;
    private String password;
    private String zone;
    private String type;

}
