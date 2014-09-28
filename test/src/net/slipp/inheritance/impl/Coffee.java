package net.slipp.inheritance.impl;

import net.slipp.inheritance.Beverage;

public class Coffee extends Beverage
{
    void prepareRecipe()
    {
        boilWater();
        steepTeaBag();
    }
}