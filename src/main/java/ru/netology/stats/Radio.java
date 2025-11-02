package ru.netology.stats;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int maxStation;

    //  (10 станций)
    public Radio() {
        this.maxStation = 9; // 10 станций: от 0 до 9
    }

    // (количество станций)
    public Radio(int stationCount) {
        if (stationCount <= 0) {
            this.maxStation = 9;
        } else {
            this.maxStation = stationCount - 1;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int newStation) {
        if (newStation >= 0 && newStation <= maxStation) {
            currentStation = newStation;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newVolume) {
        if (newVolume >= 0 && newVolume <= 100) {
            currentVolume = newVolume;
        }
    }

    public int getMaxStation() {
        return maxStation;
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