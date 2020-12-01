package com.globomatics.bike.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.globomatics.bike.models.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {

	Page<Bike> findAll(Pageable pageable);
}
