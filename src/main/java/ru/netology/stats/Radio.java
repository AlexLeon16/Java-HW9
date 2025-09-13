package ru.netology.stats;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Radio {
    @Setter
    private int currentStation;

    @Setter
    private int currentVolume;

    private final int maxStation;

    public Radio() {
        this.maxStation = 9;
    }

    public Radio(int stationCount) {
        if (stationCount <= 0) {
            this.maxStation = 9;
        } else {
            this.maxStation = stationCount - 1;
        }
    }

    public void nextStation() {
        if (currentStation == maxStation) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prevStation() {
        if (currentStation == 0) {
            currentStation = maxStation;
        } else {
            currentStation--;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}