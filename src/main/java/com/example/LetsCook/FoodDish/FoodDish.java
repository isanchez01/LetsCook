package com.example.LetsCook.FoodDish;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "fooddish")
public class FoodDish {
	public enum Meal {
		BREAKFAST("Breakfast"),
		LUNCH("Lunch"),
		DINNER("Dinner");
		private final String mealTime;
		
		private Meal(String mealTime) {
			this.mealTime = mealTime;
		}
		
		public String getMealTime(){
			return mealTime;
		}
	}
	
	@Id
	@SequenceGenerator(name = "letscook_sequence", sequenceName = "letscook_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "letscook_sequence")
	private int id;
	private Meal mealType;
	private String dishName;
	private String[] ingredients;
	private int calories;
	private String[] instructions; 
	public FoodDish() {
		
	}
	public FoodDish (Meal mealType, String dishName, String[] ingredientList, int calories, String[] instructionList) {
		this.mealType = mealType;
		this.dishName = dishName;
		this.ingredients = ingredientList;
		this.calories = calories;
		this.instructions = instructionList;
	}
	
	public int getId() {
		return id;
	}
	public Meal getMealtype() {
		return mealType;
	}
	public void setMealType(Meal newMealType) {
		this.mealType = newMealType;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String newDishName) {
		this.dishName = newDishName;
	}
	public String[] getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(String[] newIngredientList) {
		this.ingredients = newIngredientList;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int newCalories) {
		this.calories = newCalories;
	}
	public String[] getInstructions() {
		return instructions;
	}
	public void setInstructions(String[] newInstructions) {
		this.instructions = newInstructions;
	}
	public void getDishInfo() {
		System.out.println("Name of Dish: " + dishName);
		System.out.print("Ingredients: ");
		for (int i = 0; i < ingredients.length; i++) {
			if (i < ingredients.length - 1) {
				System.out.print(ingredients[i] + ", ");
			}
			else {
				System.out.print(ingredients[i] + '\n');
			}
		}
		System.out.println("Calories: " + calories);
	}
}

