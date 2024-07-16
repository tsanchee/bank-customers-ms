package com.bank.customers.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "customer")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    private String id;
    
    @Field(name = "customerType")
    private String customerType;
    
    @Field(name = "docType")
    private String docType;
    
    @Indexed(unique = true)
    private String docNumber;
    
    @Field(name = "firstName")
    private String firstName;
    
    @Field(name = "lastName")
    private String lastName;

    @Field(name = "birthday")
    private String birthday;
    
    @Field(name = "address")
    private String address;
    
    @Field(name = "telephone")
    private String telephone;
    
    @Field(name = "email")
    private String email;
    
    @Field(name = "married")
    private boolean married;
    
    @Field(name = "actived")
    private boolean actived;

}
