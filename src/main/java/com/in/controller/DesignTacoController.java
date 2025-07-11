package com.in.controller;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in.entity.Ingredient;
import com.in.entity.Ingredient.Type;
import com.in.entity.Taco;
import com.in.entity.TacoOrder;


@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
	    List<Ingredient> ingredients = Arrays.asList(
	      new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
	      new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
	      new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
	      new Ingredient("CARN", "Carnitas", Type.PROTEIN),
	      new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
	      new Ingredient("LETC", "Lettuce", Type.VEGGIES),
	      new Ingredient("CHED", "Cheddar", Type.CHEESE),
	      new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
	      new Ingredient("SLSA", "Salsa", Type.SAUCE),
	      new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
	    );
	 
	    Type[] types = Ingredient.Type.values();
	    for (Type type : types) {
	      model.addAttribute(type.toString().toLowerCase(),
	          filterByType(ingredients, type));
	    }
	  }
	 
	  @ModelAttribute(name = "tacoOrder")
	  public TacoOrder order() {
	    return new TacoOrder();
	  }
	  
	  @ModelAttribute(name = "taco")
	  public Taco taco() {
	    return new Taco();
	  }
	 
	  @GetMapping
	  public String showDesignForm() {
	    return "design";
	  }
	 
	  private Iterable<Ingredient> filterByType(
	      List<Ingredient> ingredients, Type type) {
	    return ingredients
	              .stream()
	              .filter(x -> x.getType().equals(type))
	              .collect(Collectors.toList());
	  }
	  
	  
		
		  @PostMapping public String processTaco(Taco taco,
		  
		  @ModelAttribute TacoOrder tacoOrder) { tacoOrder.addTaco(taco);
		  
		  
		  return "redirect:/orders/current"; }
		 
	  
	  
	  

}
