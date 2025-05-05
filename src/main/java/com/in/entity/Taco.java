package com.in.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.antlr.v4.runtime.misc.NotNull;
//import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Taco implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
