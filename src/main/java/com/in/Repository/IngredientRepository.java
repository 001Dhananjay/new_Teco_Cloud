package com.in.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.entity.Ingredient;
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
