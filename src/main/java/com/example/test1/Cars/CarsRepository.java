package com.example.test1.Cars;

import com.example.test1.Locations.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Set;

public interface CarsRepository extends PagingAndSortingRepository<Car, Long> {
    Car getById(long id);
    Set<Car> findAllByModel(String model);
    Set<Car> findAllByManifatuer(String manifatuer);
    Set<Car> findAllByModelAndManifatuer(String model, String manifatuer);
    Set<Car> findAllByLocation(Location location);
}
