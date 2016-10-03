package com.seasons.game;

import com.seasons.game.units.Player;

/**
 * Created by chester on 29.09.16.
 */

public class GameTime {
    float timerSpawn=0;
    float timeSpawn=0.5f;

    int hours,days,months,years;


    public String getTime(){
        return  "Hours: "+hours+
                " Days: "+days+
                " Months: "+months+
                " Years: "+years;
    }

    public int getHours() {
        return hours;
    }

    public int getDays() {
        return days;
    }

    public int getMonths() {
        return months;
    }

    public int getYears() {
        return years;
    }

    public GameTime() {
        hours=0;

        days=0;
        months=0;
        years=0;
    }

    public void update(float dt){
        if(hours>=24){
            hours-=24;
            days++;
        }
        if(days>=30){
            days-=30;
            months++;
        }
        if(months>=12){
            months-=12;
            years++;
        }
        timerSpawn+=dt;
        if(timerSpawn>=timeSpawn){
            tick();
            timerSpawn=0;
        }
    }
    public void tick(){
        this.hours++;
    }



}
