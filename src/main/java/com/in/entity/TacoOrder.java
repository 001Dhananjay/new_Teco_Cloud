package com.in.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TacoOrder implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	 
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	
	
	@Column(name ="customer_name")
	 private String deliveryName;
	  private String deliveryStreet;
	  private String deliveryCity;
	  private String deliveryState;
	  private String deliveryZip;
	  private String ccNumber;
	  private String ccExpiration;
	  private String ccCVV;
	 
	 
	  private Date placedAt = new Date();
	  
	  @OneToMany(cascade = CascadeType.ALL)
	  private List<Taco> tacos = new ArrayList<>();
	 
	  public void addTaco(Taco taco) {
	    tacos.add(taco);
	  }
	  
}
