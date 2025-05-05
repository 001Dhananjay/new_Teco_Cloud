package com.in.Repository;

import org.springframework.data.repository.CrudRepository;

import com.in.entity.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}