package com.in.entity;

//import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;

@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor

public class Ingredient  {
	
//	private static final long serialVersionUID = 1L;
 
  @Id
  private String id;
  private String name;
  private Type type;
  public enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }
public Ingredient(String id, String name, Type type) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
}
public Ingredient() {
	super();
	// TODO Auto-generated constructor stub
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Type getType() {
	return type;
}
public void setType(Type type) {
	this.type = type;
}
 
  
  
  
  
}