package com.tanis138.chef;

public class Salad {
    private VegStorage vegStorage;
    private SaladRecipe saladRecipe;

    public Salad(VegStorage vegStorage) {
        this.vegStorage = vegStorage;
    }

    public boolean make(SaladRecipe saladRecipe) {
        this.saladRecipe = null;

        if (vegStorage == null) {
            System.out.println("Can't make salad: vegetable storage is empty!");
            return false;
        }

        if (saladRecipe == null) {
            System.out.println("Can't make salad: recipe is empty!");
            return false;
        }

        Vegetable[] ingredients = saladRecipe.getIngredients();

        // check if we have enough ingredients in our storage
        for (Vegetable ingredient : ingredients) {
            if (!vegStorage.isAvailable(ingredient.getName(), ingredient.getWeightG())) {
                System.out.printf("Can't make \"%s\": insufficient %s!\n",
                        saladRecipe.getFullName(), ingredient.getName().toString().toLowerCase());
                return false;
            }
        }

        // get Vegetable from the storage
        for (Vegetable ingredient : ingredients) {
            if (!vegStorage.get(ingredient.getName(), ingredient.getWeightG())) {
                System.out.printf("Can't make \"%s\": unable to get %s from the storage!\n",
                        saladRecipe.getFullName(), ingredient.getName().toString().toLowerCase());
                return false;
            }
        }

        this.saladRecipe = saladRecipe;
        System.out.println(saladRecipe.getFullName() + " successfully made!");
        System.out.printf("\trecipe: %s\n", saladRecipe.getRecipe());
        System.out.printf("\tnutrition: %s\n", saladRecipe.getNutritionValue());
        return true;
    }

    public void showIngredientsByKcal(double minKcal, double maxKcal) {
        if (saladRecipe == null) {
            System.out.println("Can't show ingredients: recipe is empty!");
            return;
        }

        if (minKcal > maxKcal) {
            double t = minKcal;
            minKcal = maxKcal;
            maxKcal = t;
        }
        System.out.printf("\tingredients %.0f..%.0f kcal: ", minKcal, maxKcal);

        Vegetable[] vegetables = saladRecipe.getIngredients(minKcal, maxKcal);
        if (vegetables != null) {
            for (Vegetable veg : vegetables) {
                System.out.printf("%s(%.1f), ", veg.getName().toString().toLowerCase(), veg.getKcal());
            }
        }
        System.out.println();
    }

    public void showIngredientsByKcal(boolean isReversed) {
        if (saladRecipe == null) {
            System.out.println("Can't show ingredients: recipe is empty!");
            return;
        }

        System.out.printf("\tingredients sorted (%s) by energy (kcal): ", isReversed ? "desc." : "asc.");

        saladRecipe.sortIngredientsByKcal(isReversed);
        Vegetable[] vegetables = saladRecipe.getIngredients();
        if (vegetables != null) {
            for (Vegetable veg : vegetables) {
                System.out.printf("%s(%.1f), ", veg.getName().toString().toLowerCase(), veg.getKcal());
            }
        }
        System.out.println();
    }

    public void showIngredientsByProteins(boolean isReversed) {
        if (saladRecipe == null) {
            System.out.println("Can't show ingredients: recipe is empty!");
            return;
        }

        System.out.printf("\tingredients sorted (%s) by proteins (g): ", isReversed ? "desc." : "asc.");

        saladRecipe.sortIngredientsByProteins(isReversed);
        Vegetable[] vegetables = saladRecipe.getIngredients();
        if (vegetables != null) {
            for (Vegetable veg : vegetables) {
                System.out.printf("%s(%.1f), ", veg.getName().toString().toLowerCase(), veg.getProteins());
            }
        }
        System.out.println();
    }
}
