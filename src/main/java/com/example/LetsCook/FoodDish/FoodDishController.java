package com.example.LetsCook.FoodDish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class FoodDishController {
	private final FoodDishService foodDishService;
	private FoodDish foodDish;
	@Autowired
	public FoodDishController(FoodDishService foodDishService) {
		this.foodDishService = foodDishService;
	}
	@RequestMapping(value="/letscook")
	public String index() {
		return "letscook";
	}
	
	@GetMapping(value="/allRecipes")
	public @ResponseBody ModelAndView getAllMealsByMealtime(@RequestParam("mealtime") String mealtime) {
		mealtime = mealtime.toUpperCase();
		List<FoodDish> mealList = new ArrayList<FoodDish>();
		if (mealtime.equals("BREAKFAST")) {
			mealList = foodDishService.findAllBreakfastMeals();
		}
		else if (mealtime.equals("LUNCH")) {
			mealList = foodDishService.findAllLunchMeals();
		}
		else if (mealtime.equals("DINNER")) {
			mealList = foodDishService.findAllDinnerMeals();
		}
		ArrayList<String> mealNameList = new ArrayList<String>();
		for(int i = 0; i < mealList.size(); i++) {
			mealNameList.add(mealList.get(i).getDishName());
		}
		
		ModelAndView modelView = new ModelAndView("allRecipes");
		modelView.addObject("recipelist", mealNameList);
	                    
		return modelView;

	}
	@GetMapping(value="/getDish")
	public @ResponseBody ModelAndView getFoodDish(@RequestParam("dishname") String inputDish) {
		ModelAndView modelView = new ModelAndView("getDish");
		modelView.addObject("fooddish", foodDishService.getFoodDishByName(inputDish));
		modelView.addObject("ingredients", foodDishService.getFoodDishByName(inputDish).getIngredients());
		modelView.addObject("instructions", foodDishService.getFoodDishByName(inputDish).getInstructions());
		return modelView;
	}
	
	@PostMapping(value="/addDish")
	public @ResponseBody ModelAndView addFoodDish(@RequestParam Map<String, String> inputDish) {
		System.out.println(inputDish);
		int caloriesInt = Integer.parseInt(inputDish.get("calories"));
		String[] ingredientList = inputDish.get("ingredients").split(", ");
		String[] instructionList = inputDish.get("instructions").split(", ");
		foodDishService.addDish(inputDish.get("dish_name"), caloriesInt, ingredientList, inputDish.get("addDish_mealtime"), instructionList);
		ModelAndView modelView = new ModelAndView("addDish");
		return modelView;
	}
	
}
