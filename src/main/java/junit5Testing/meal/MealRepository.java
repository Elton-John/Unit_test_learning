package junit5Testing.meal;

import junit5Testing.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MealRepository {

    private List<Meal> meals = new ArrayList<>();

    public void add(Meal meal) {
        meals.add(meal);
    }

    public List<Meal> getAllMeals() {
        return meals;
    }

    public void delete(Meal meal) {
        meals.remove(meal);
    }

    public List<Meal> getByName(String mealName) {
        return meals.stream()
                .filter(meal -> meal.getName().equals(mealName))
                .collect(Collectors.toList());
    }
}
