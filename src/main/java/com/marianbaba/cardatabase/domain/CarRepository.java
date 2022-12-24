package com.marianbaba.cardatabase.domain;

import java.util.List;

// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// also, there are PagingAndSortingRepository (two additional findAll methods)

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
	List<Car> findByBrand(@Param("brand") String brand);
	
	List<Car> findByColor(@Param("color") String color);
	
	List<Car> findByYearOfProduction(Integer yearOfProduction);

	List<Car> findByBrandAndModel(String brand, String model);
	
	List<Car> findByBrandOrderByYearOfProductionAsc(String brand);

//	@Query("select c from Car where c.brand = ?1")
//	List<Car> findByBrand(String brand);

	
}