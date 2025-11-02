package ru.netology.stats;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Getter
class RadioTest {
    private Radio defaultRadio;
    private Radio customRadio;

    @BeforeEach
    void setUp() {
        defaultRadio = new Radio();
        customRadio = new Radio(15);
    }

    // ===== ТЕСТЫ ДЛЯ КОНСТРУКТОРА ПО УМОЛЧАНИЮ =====

    @Test
    void shouldCreateDefaultRadioWith10Stations() {
        assertEquals(9, defaultRadio.getMaxStation());
        assertEquals(0, defaultRadio.getCurrentStation());
        assertEquals(0, defaultRadio.getCurrentVolume());
    }

    @Test
    void shouldSetValidStationForDefaultRadio() {
        defaultRadio.setCurrentStation(5);
        assertEquals(5, defaultRadio.getCurrentStation());
    }
    

    @Test
    void shouldSwitchFromMaxToZeroForDefaultRadio() {
        defaultRadio.setCurrentStation(9);
        defaultRadio.nextStation();
        assertEquals(0, defaultRadio.getCurrentStation());
    }

    @Test
    void shouldSwitchFromZeroToMaxForDefaultRadio() {
        defaultRadio.setCurrentStation(0);
        defaultRadio.prevStation();
        assertEquals(9, defaultRadio.getCurrentStation());
    }

    // ===== ТЕСТЫ ДЛЯ КОНСТРУКТОРА С ПАРАМЕТРОМ =====

    @Test
    void shouldCreateRadioWithCustomStations() {
        assertEquals(14, customRadio.getMaxStation());
    }

    @Test
    void shouldSetValidStationForCustomRadio() {
        customRadio.setCurrentStation(10);
        assertEquals(10, customRadio.getCurrentStation());
    }

    @Test
    void shouldSwitchFromMaxToZeroForCustomRadio() {
        customRadio.setCurrentStation(14);
        customRadio.nextStation();
        assertEquals(0, customRadio.getCurrentStation());
    }

    @Test
    void shouldSwitchFromZeroToMaxForCustomRadio() {
        customRadio.setCurrentStation(0);
        customRadio.prevStation();
        assertEquals(14, customRadio.getCurrentStation());
    }

    // ===== ТЕСТЫ ДЛЯ ГРОМКОСТИ =====

    @Test
    void shouldSetValidVolume() {
        defaultRadio.setCurrentVolume(50);
        assertEquals(50, defaultRadio.getCurrentVolume());
    }


    @Test
    void shouldIncreaseVolume() {
        defaultRadio.setCurrentVolume(50);
        defaultRadio.increaseVolume();
        assertEquals(51, defaultRadio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolumeAboveMax() {
        defaultRadio.setCurrentVolume(100);
        defaultRadio.increaseVolume();
        assertEquals(100, defaultRadio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        defaultRadio.setCurrentVolume(50);
        defaultRadio.decreaseVolume();
        assertEquals(49, defaultRadio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeBelowMin() {
        defaultRadio.setCurrentVolume(0);
        defaultRadio.decreaseVolume();
        assertEquals(0, defaultRadio.getCurrentVolume());
    }

    // ===== ДОПОЛНИТЕЛЬНЫЕ ТЕСТЫ =====

    @Test
    void shouldHandleInvalidStationCount() {
        Radio invalidRadio = new Radio(-5);
        assertEquals(9, invalidRadio.getMaxStation());
    }

    @Test
    void shouldHandleSingleStation() {
        Radio singleStationRadio = new Radio(1);
        assertEquals(0, singleStationRadio.getMaxStation());
        singleStationRadio.setCurrentStation(0);
        assertEquals(0, singleStationRadio.getCurrentStation());
    }

    @Test
    void shouldHandleVolumeBoundaries() {
        defaultRadio.setCurrentVolume(0);
        assertEquals(0, defaultRadio.getCurrentVolume());

        defaultRadio.setCurrentVolume(100);
        assertEquals(100, defaultRadio.getCurrentVolume());
    }
}