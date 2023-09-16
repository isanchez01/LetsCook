package com.example.LetsCook.FoodDish;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDishRepository extends JpaRepository<FoodDish, Integer>{
	@Query(nativeQuery = true, value="SELECT * FROM FoodDish dish WHERE dish.dish_name = ?1")
	FoodDish findFoodDishByDishName(String dishName);
	
	@Query(nativeQuery = true, value = "SELECT * FROM fooddish WHERE meal_type = '0'")
	List<FoodDish> findAllBreakfast();
	
	@Query(nativeQuery = true, value = "SELECT * FROM fooddish WHERE meal_type = '1'")
	List<FoodDish> findAllLunch();
	
	@Query(nativeQuery = true, value = "SELECT * FROM fooddish WHERE meal_type = '2'")
	List<FoodDish> findAllDinner();
	

}

