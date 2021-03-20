package junit5Testing.meal;

import junit5Testing.Meal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class MealRepositoryTest {

    MealRepository repository = new MealRepository();

    @BeforeEach
    void cleanUp(){
        repository.getAllMeals().clear();
    }

    @Test
    void shouldBeAbleToAddMealToRepository() {
        //given
        Meal meal = new Meal(20, "pizza");

        //when
        repository.add(meal);

        //then
        assertThat(repository.getAllMeals().get(0), is(meal));
    }

    @Test
    void shouldBeAbleToRemoveMealFromRepository() {
        //given
        Meal meal = new Meal(20, "pizza");
        repository.add(meal);

        //when
        repository.delete(meal);

        //then
        assertThat(repository.getAllMeals(), not(contains(meal)));
    }

    @Test
    void shouldBeAbleToFindMealByName() {
        //given
        Meal meal = new Meal(20, "pizza");
        repository.add(meal);

        //when
        List<Meal> result = repository.getByName("pizza");

        //then
        assertThat(result.size(), is(1));

    }
}
