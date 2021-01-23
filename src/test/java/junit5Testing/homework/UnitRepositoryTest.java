package junit5Testing.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

class UnitRepositoryTest {
    Coordinates firstCoordinates;
    Unit firstUnit;
    Coordinates secondCoordinates;
    Unit secondUnit;
    UnitRepository unitRepository;

    @BeforeEach
    void setData() {
        firstCoordinates = new Coordinates(1, 1);
        firstUnit = new Unit(firstCoordinates, 100, 100);
        secondCoordinates = new Coordinates(2, 2);
        secondUnit = new Unit(secondCoordinates, 100, 100);
        unitRepository = new UnitRepository();
        unitRepository.addUnit(firstUnit);
        unitRepository.addUnit(secondUnit);
    }

    @Test
    void shouldGetUnitByCoordinates() {
        //given set in BeforeEach

        //when
        Unit unitByCoordinates = unitRepository.getUnitByCoordinates(firstCoordinates);

        //then
        assertThat(unitByCoordinates, is(firstUnit));
    }

    @Test
    void shouldReturnNullByCoordinatesWitchNotExist() {
        //given set in BeforeEach

        //when
        Unit unitByCoordinates = unitRepository.getUnitByCoordinates(new Coordinates(5, 5));

        //then
        assertThat(unitByCoordinates, is(nullValue()));
    }
}