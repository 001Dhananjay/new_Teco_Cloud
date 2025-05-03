package com.in.controller;



import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.in.entity.TacoOrder;



@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}

	@ModelAttribute("tacoOrder")
	public TacoOrder tacoOrder() {
		return new TacoOrder();
	}

	
	  @PostMapping public String processOrder(TacoOrder order, SessionStatus
	  sessionStatus) { sessionStatus.setComplete();
	  
	  return "redirect:/"; }
	  
	 
}
