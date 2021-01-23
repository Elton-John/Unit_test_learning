package junit5Testing.homework;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnitTest {

    @Test
    void shouldLoadCargoWhenCargoWeightLessThatMaxCargoWeight() {
        //given
        Cargo cargo = new Cargo("box", 20);
        Unit unit = new Unit(new Coordinates(0, 0), 100, 100);

        //when
        unit.loadCargo(cargo);

        //then
        assertThat(unit.getCargos(), hasItem(cargo));
        assertThat(unit.getCurrentCargoWeight(), is(20));
    }

    @Test
    void shouldThrowExceptionWhenCargoWeightMoreThatMaxCargoWeight() {
        //given
        Cargo cargo = new Cargo("box", 120);
        Unit unit = new Unit(new Coordinates(0, 0), 100, 100);

        //when  //then
        assertThrows(IllegalStateException.class, () -> unit.loadCargo(cargo));
    }
}