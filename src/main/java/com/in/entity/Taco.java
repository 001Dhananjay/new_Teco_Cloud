package com.in.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Taco {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	 
	  private String name;
	 
	  private Date createdAt = new Date();
	 
	
	  @ManyToMany()
	  private List<Ingredient> ingredients = new ArrayList<>();
	  
	  public void addIngredient(Ingredient ingredient) {
	    this.ingredients.add(ingredient);
	  }	  
}
