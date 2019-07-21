package com.tanis138.chef;

import java.util.Arrays;
import java.util.Comparator;

public enum SaladRecipe {
    TOMATO_CUCUMBER("Tomato and cucumber salad", new Vegetable[]{new Vegetable(VegName.TOMATO, 100),
            new Vegetable(VegName.CUCUMBER, 50), new Vegetable(VegName.ONION, 10)}),
    RADISH_LETTUCE("Radish and carrot salad", new Vegetable[]{new Vegetable(VegName.RADISH, 120),
            new Vegetable(VegName.LETTUCE, 75), new Vegetable(VegName.GARLIC, 5)});

    private Vegetable[] ingredients;
    private String fullName;

    SaladRecipe(String fullName, Vegetable[] ingredients) {
        this.fullName = (fullName != null) ? fullName : "";
        this.ingredients = ingredients;
    }

    public Vegetable[] getIngredients() {
        return ingredients;
    }

    public Vegetable[] getIngredients(double minKcal, double maxKcal) {
        if (ingredients == null || ingredients.length == 0) {
            return null;
        }

        Vegetable[] res = new Vegetable[ingredients.length];

        int j = 0;
        for (int i = 0; i < ingredients.length; i++) {
            if (minKcal <= ingredients[i].getKcal() && ingredients[i].getKcal() <= maxKcal) {
                res[j++] = ingredients[i];
            }
        }

        return (j > 0) ? Arrays.copyOf(res, j) : null;
    }

    public void sortIngredientsByKcal(boolean isReversed) {
        if (ingredients == null || ingredients.length == 0) {
            return;
        }

        if (isReversed) {
            Arrays.sort(ingredients, Comparator.comparing(Vegetable::getKcal).reversed());
        } else {
            Arrays.sort(ingredients, Comparator.comparing(Vegetable::getKcal));
        }
    }

    public void sortIngredientsByProteins(boolean isReversed) {
        if (ingredients == null || ingredients.length == 0) {
            return;
        }

        if (isReversed) {
            Arrays.sort(ingredients, Comparator.comparing(Vegetable::getProteins).reversed());
        } else {
            Arrays.sort(ingredients, Comparator.comparing(Vegetable::getProteins));
        }
    }

    public String getFullName() {
        return fullName;
    }

    public String getNutritionValue() {
        double kcal = 0, proteins = 0, fats = 0, carbs = 0;

        for (Vegetable ingredient : ingredients) {
            kcal += ingredient.getKcal();
            proteins += ingredient.getProteins();
            fats += ingredient.getFats();
            carbs += ingredient.getCarbs();
        }

        return String.format("energy: %.1fkcal; proteins: %.1fg; fats: %.1fg; carbs: %.1fg",
                kcal, proteins, fats, carbs);
    }

    public String getRecipe() {
        StringBuilder sb = new StringBuilder();

        for (Vegetable ingredient : ingredients) {
            sb.append(String.format("%s: %dg, ", ingredient.getName().toString().toLowerCase(), ingredient.getWeightG()));
        }
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == ' ') sb.delete(sb.length() - 2, sb.length());

        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", fullName, getRecipe());
    }
}
