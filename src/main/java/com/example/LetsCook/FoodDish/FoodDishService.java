package com.example.LetsCook.FoodDish;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.LetsCook.FoodDish.FoodDish.Meal;

@Service
public class FoodDishService {
	private final FoodDishRepository foodDishRepository;
	
	@Autowired
	public FoodDishService(FoodDishRepository foodDishRepository) {
		this.foodDishRepository = foodDishRepository;
	}
	public List<FoodDish> getFoodDishes() {
		return foodDishRepository.findAll();
	}
	public List<FoodDish> findAllBreakfastMeals() {
		return foodDishRepository.findAllBreakfast();
	}
	public List<FoodDish> findAllLunchMeals() {
		return foodDishRepository.findAllLunch();
	}
	public List<FoodDish> findAllDinnerMeals() {
		return foodDishRepository.findAllDinner();
	}
	public FoodDish getFoodDishByName(String dishname) {
		return foodDishRepository.findFoodDishByDishName(dishname);
		
	}
	public void addDish(String mealName, int calories, String[] ingredients, String mealtimeString, String[] insructions) {
		FoodDish newDish = new FoodDish();
		Meal mealtimeType = null;
		mealtimeString = mealtimeString.toUpperCase();
		if (mealtimeString.equals("BREAKFAST")) {
			mealtimeType = Meal.BREAKFAST;
		}
		else if (mealtimeString.equals("LUNCH")) {
			mealtimeType = Meal.LUNCH;
		}
		else if (mealtimeString.equals("DINNER")) {
			mealtimeType = Meal.DINNER;
		}
		newDish.setDishName(mealName);
		newDish.setCalories(calories);
		newDish.setIngredients(ingredients);
		newDish.setMealType(mealtimeType);
		newDish.setInstructions(insructions);
		foodDishRepository.save(newDish);
	}
}
