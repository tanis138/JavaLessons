package com.tanis138.chef;

public class ChefRunner {

    public static void main(String[] args) {
        // fill vegetable storage
        VegStorage vegStorage = new VegStorage();
        vegStorage.add(new Vegetable(VegName.CARROT, 700));
        vegStorage.add(new Vegetable(VegName.TOMATO, 1500));
        vegStorage.add(new Vegetable(VegName.CUCUMBER, 1000));
        vegStorage.add(new Vegetable(VegName.LETTUCE, 500));
        vegStorage.add(new Vegetable(VegName.GARLIC, 100));
        vegStorage.add(new Vegetable(VegName.RADISH, 600));
        System.out.println(vegStorage);
        System.out.println();

        // trying to make salad
        Salad salad = new Salad(vegStorage);
        salad.make(SaladRecipe.TOMATO_CUCUMBER);
        System.out.println();

        // add onions
        vegStorage.add(new Vegetable(VegName.ONION, 700));
        System.out.println(vegStorage);
        System.out.println();

        // trying to make salad again
        if (salad.make(SaladRecipe.TOMATO_CUCUMBER)) {
            // show ingredients in range
            salad.showIngredientsByKcal(5, 30);
            // sort ingredients by proteins (descending)
            salad.showIngredientsByProteins(true);
        }
        System.out.println(vegStorage);
        System.out.println();

        // trying to make another salad
        if (salad.make(SaladRecipe.RADISH_LETTUCE)) {
            // show ingredients in range
            salad.showIngredientsByKcal(0, 10);
            // sort ingredients by energy (ascending)
            salad.showIngredientsByKcal(false);
        }
        System.out.println(vegStorage);
    }
}
