package junit5Testing.homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
class UnitServiceTest {

    @Mock
    private CargoRepository cargoRepository;
    @Mock
    private UnitRepository unitRepository;
    @InjectMocks
    private UnitService unitService;
    @Spy
    Cargo cargoSpy;
    @Spy
    Unit unitSpy;

    @Test
    void shouldLoadCargoWhenCargoIsPresent() {
        //given
        given(cargoRepository.findCargoByName("box")).willReturn(Optional.of(cargoSpy));
        willDoNothing().given(unitSpy).loadCargo(cargoSpy);

        //when
        unitService.addCargoByName(unitSpy, "box");

        //then
        verify(cargoRepository).findCargoByName("box");
        verify(unitSpy).loadCargo(cargoSpy);
        assertNotNull(cargoSpy);
    }

    @Test
    void shouldThrowExceptionWhenCargoIsNotPresent() {
        //given
        given(cargoRepository.findCargoByName("box")).willReturn(Optional.empty());

        //when        //then
        verify(unitSpy, never()).loadCargo(cargoSpy);
        assertThrows(NoSuchElementException.class, () -> unitService.addCargoByName(unitSpy, "box"));
    }


    @Test
    void shouldReturnUnitWhenExist() {
        //given
        Coordinates coordinates = new Coordinates(10, 10);
        given(unitRepository.getUnitByCoordinates(coordinates)).willReturn(unitSpy);

        //when
        Unit unitResult = unitService.getUnitOn(coordinates);

        //then
        verify(unitRepository).getUnitByCoordinates(coordinates);
        assertEquals(unitResult, unitSpy);
    }

    @Test
    void shouldThrowExceptionWhenUnitNotFind() {
        //given
        Coordinates coordinates = new Coordinates(10, 10);
        given(unitRepository.getUnitByCoordinates(coordinates)).willReturn(null);

        //when        //then
        assertThrows(NoSuchElementException.class, () -> unitService.getUnitOn(coordinates));
    }
}