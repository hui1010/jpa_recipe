package se.lexicon.jpa_assignment.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "recipe_recipe_categories",
            joinColumns = @JoinColumn(name = "recipe_categories_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> recipes;

    public RecipeCategory() {
    }

    public RecipeCategory(String category, List<Recipe> recipes) {
        this.name = category;
        this.recipes = recipes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String category) {
        this.name = category;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(recipes, that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, recipes);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", category='" + name + '\'' +
                ", recipes=" + recipes +
                '}';
    }

    /**
     * convenience methods - add and remove recipe
     * */
    public boolean addRecipe(Recipe recipe){
        boolean added = false;
        if (recipes == null)
            recipes = new ArrayList<>();

        if (recipe == null)
            throw new IllegalArgumentException("please make sure the recipe is not empty");

        if (!recipes.contains(recipe)){
            added = recipes.add(recipe);
            recipe.getRecipeCategories().add(this);
        }
        return added;
    }

    public boolean removeRecipe(Recipe recipe){
        boolean removed = false;
        if (recipes == null)
            recipes = new ArrayList<>();

        if (recipe == null)
            throw new IllegalArgumentException("please make sure the recipe is not empty");

        if (recipes.contains(recipe)){
            removed = recipes.add(recipe);
            recipe.getRecipeCategories().remove(this);
        }
        return removed;
    }

}
