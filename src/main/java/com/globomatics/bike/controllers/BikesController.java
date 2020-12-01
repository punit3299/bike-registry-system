package com.globomatics.bike.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {
	
	@Autowired
	private BikeRepository bikeRepo; 
	
	@GetMapping
	public Page<Bike> list(Pageable pageable){
//		Sort sort = Sort.by(Sort.Direction.ASC, "name");
//		pageable = PageRequest.of(0, 2, sort);
		return bikeRepo.findAll(pageable);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Bike create(@RequestBody Bike bike) {
		return bikeRepo.save(bike);
	}

	@GetMapping("/{id}")
	public Bike get(@PathVariable("id") long id){
		return bikeRepo.findById(id).get();
	}
}
