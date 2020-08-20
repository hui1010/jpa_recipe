package se.lexicon.jpa_assignment.entity;

import org.aspectj.apache.bcel.generic.Instruction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<RecipeIngredient> recipeIngredients;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private RecipeInstruction recipeInstruction;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id"))
    private List<RecipeCategory> recipeCategories;

    public Recipe() {
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, List<RecipeCategory> recipeCategories) {
        this.name = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategories = recipeCategories;
    }

    /**
     * convenience methods - add and remove recipeIngredient
     * */
    public boolean addRecipeIngredient(RecipeIngredient recipeIngredient){
        boolean added = false;
        if (recipeIngredients == null)
            recipeIngredients = new ArrayList<>();

        if (recipeIngredient == null)
            throw new IllegalArgumentException("make sure the recipe ingredient is not empty");

        if (!recipeIngredients.contains(recipeIngredient)){
            added = recipeIngredients.add(recipeIngredient);
            recipeIngredient.setRecipe(this);
        }
        return added;
    }

    public boolean removeRecipeIngredient(RecipeIngredient recipeIngredient){
        boolean removed = false;
        if (recipeIngredients == null)
            recipeIngredients = new ArrayList<>();

        if (recipeIngredient == null)
            throw new IllegalArgumentException("make sure the recipe ingredient is not empty");

        if (recipeIngredients.contains(recipeIngredient)){
            removed = recipeIngredients.remove(recipeIngredient);
            recipeIngredient.setRecipe(null);
        }
        return removed;
    }

    /**
     * convenience methods - add to and remove from recipe category
     * */
    public boolean addToRecipeCategory(RecipeCategory recipeCategory){
        boolean added = false;
        if (recipeCategories == null)
            recipeCategories = new ArrayList<>();
        if (recipeCategory == null)
            throw new IllegalArgumentException("please make sure the category is not empty");
        if (!recipeCategories.contains(recipeCategory)){
            added = recipeCategories.add(recipeCategory);
            recipeCategory.addRecipe(this);
        }
        return added;
    }

    public boolean removeFromRecipeCategory(RecipeCategory recipeCategory){
        boolean removed = false;
        if (recipeCategories == null)
            recipeCategories = new ArrayList<>();
        if (recipeCategory == null)
            throw new IllegalArgumentException("please make sure the category is not empty");
        if (recipeCategories.contains(recipeCategory)) {
            removed = recipeCategories.remove(recipeCategory);
            recipeCategory.removeRecipe(this);
        }
        return removed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String recipeName) {
        this.name = recipeName;
    }



    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }


    public List<RecipeCategory> getRecipeCategories() {
        return recipeCategories;
    }

    public void setRecipeCategories(List<RecipeCategory> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id &&
                Objects.equals(name, recipe.name) &&
                Objects.equals(recipeIngredients, recipe.recipeIngredients) &&
                Objects.equals(recipeInstruction, recipe.recipeInstruction) &&
                Objects.equals(recipeCategories, recipe.recipeCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, recipeIngredients, recipeInstruction, recipeCategories);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", recipeInstruction=" + recipeInstruction +
                ", recipeCategories=" + recipeCategories +
                '}';
    }
}
