package com.consciousprogrammers.springbootrecipeapp.bootstrap;

import com.consciousprogrammers.springbootrecipeapp.model.*;
import com.consciousprogrammers.springbootrecipeapp.repositories.CategoryRepository;
import com.consciousprogrammers.springbootrecipeapp.repositories.RecipeRepository;
import com.consciousprogrammers.springbootrecipeapp.repositories.UnitOfMessureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.soap.Node;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;

    private CategoryRepository categoryRepository;

    private UnitOfMessureRepository unitOfMessureRepository;


    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMessureRepository unitOfMessureRepository) {



        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMessureRepository = unitOfMessureRepository;
    }



    private List<Recipe> getRecipes(){


        log.debug("getRecipes()-> start");


        List<Recipe> recipes = new ArrayList<>();


        Optional<UnitOfMessure> teaspoonOptional =unitOfMessureRepository.findByUnitOfMessure("teaspoon");
        Optional<UnitOfMessure> tablespoonOptional =unitOfMessureRepository.findByUnitOfMessure("tablespoon");
        Optional<UnitOfMessure> eachOptional =unitOfMessureRepository.findByUnitOfMessure("each");
        Optional<UnitOfMessure> pintOptional =unitOfMessureRepository.findByUnitOfMessure("pint");
        Optional<UnitOfMessure> cupOptional =unitOfMessureRepository.findByUnitOfMessure("cup");
        Optional<UnitOfMessure> pinchOptional =unitOfMessureRepository.findByUnitOfMessure("pinch");
        Optional<UnitOfMessure> gramsOptional =unitOfMessureRepository.findByUnitOfMessure("grams");
        Optional<UnitOfMessure> ounceOptional =unitOfMessureRepository.findByUnitOfMessure("ounce");
        Optional<UnitOfMessure> toServeOptional =unitOfMessureRepository.findByUnitOfMessure("to serve");

        UnitOfMessure teaspoon = teaspoonOptional.get();
        UnitOfMessure tablespoon = tablespoonOptional.get();
        UnitOfMessure each = eachOptional.get();
        UnitOfMessure pint = pintOptional.get();
        UnitOfMessure cup = cupOptional.get();
        UnitOfMessure pinch = pinchOptional.get();
        UnitOfMessure grams =gramsOptional.get();
        UnitOfMessure ounce = ounceOptional.get();
        UnitOfMessure toServe = ounceOptional.get();



        Optional<Category> italianOptional = categoryRepository.findByDescription("Italian");
        Optional<Category> mexicanOptional = categoryRepository.findByDescription("Mexican");
        Optional<Category> australianOptional = categoryRepository.findByDescription("Australian");
        Optional<Category> sriLankanOptional = categoryRepository.findByDescription("Sri Lankan");
        Optional<Category> indianOptional = categoryRepository.findByDescription("Indian");
        Optional<Category> thaiOptional = categoryRepository.findByDescription("Thai");
        Optional<Category> indonesianOptional = categoryRepository.findByDescription("Indonesian");




        Category italian = italianOptional.get();
        Category mexican =mexicanOptional.get();
        Category australian =australianOptional.get();
        Category sriLankan =sriLankanOptional.get();
        Category indian =indianOptional.get();
        Category thai =thaiOptional.get();
        Category indonesian =indonesianOptional.get();


        Recipe thirtyMinuteChickenParmigianaBake = new Recipe();

        thirtyMinuteChickenParmigianaBake.setDescription("30-minute chicken parmigiana bake");
        thirtyMinuteChickenParmigianaBake.setCookTime(30);
        thirtyMinuteChickenParmigianaBake.setDificulty(Dificulty.MODARATE);
        thirtyMinuteChickenParmigianaBake.setPrepTime(10);
        thirtyMinuteChickenParmigianaBake.setCookTime(30);

        thirtyMinuteChickenParmigianaBake.setDirections("Step 1\n" +
                "Preheat oven to 220°C/200°C fan-forced. Heat 1 tablespoon oil in a large frying pan over medium-high heat. Cook chicken, in 2 batches, for 2 to 3 minutes each side or until browned and cooked through. Transfer to a plate." +
                "Step 2\n" +
                "Heat remaining oil in pan. Add onion and garlic. Cook, stirring occasionally, for 2 minutes or until onion has softened. Add peppers and eggplant. Cook, stirring, for 1 minute. Add pasta sauce and Spicy Red sauce. Bring to the boil. Stir in basil. Season with salt and pepper." +
                "Step 3\n" +
                "Place half the chicken in a 10 cup-capacity ovenproof dish. Pour over half the sauce mixture. Top with remaining chicken and sauce mixture. Top with cheese. Sprinkle with breadcrumbs." +
                "Step 4\n" +
                "Bake for 10 to 15 minutes or until top is golden. Serve topped with basil.");

        Notes pamaNotes = new Notes();

        pamaNotes.setRecipeNotes("Serve with cooked short pasta such as spirals, penne or farfalle.\n" +
                "\n" +
                "Chicken breast schnitzels (uncrumbed) can also be sold as chicken minute steaks.\n" +
                "\n" +
                "We used a tub of antipasto chargrilled eggplant that's already diced. You could use 200g chargrilled eggplant from the supermarket deli, diced, instead.");

        thirtyMinuteChickenParmigianaBake.setNotes(pamaNotes);


        thirtyMinuteChickenParmigianaBake.addIngredient(new Ingredient("olive oil",new BigDecimal(1.5),tablespoon));
        thirtyMinuteChickenParmigianaBake.addIngredient(new Ingredient("chicken breast schnitzels (uncrumbed)",new BigDecimal(700),grams));
        thirtyMinuteChickenParmigianaBake.addIngredient(new Ingredient("medium brown onion, chopped",new BigDecimal(1),each));
        thirtyMinuteChickenParmigianaBake.addIngredient(new Ingredient("garlic cloves, crushed",new BigDecimal(2),each));
        thirtyMinuteChickenParmigianaBake.addIngredient(new Ingredient("jar fire-roasted pepper strips, drained",new BigDecimal(340),grams));
        thirtyMinuteChickenParmigianaBake.addIngredient(new Ingredient("tub diced antipasto chargrilled eggplant, drained (see note)",new BigDecimal(230),grams));
        thirtyMinuteChickenParmigianaBake.addIngredient(new Ingredient("cups tomato pasta sauce",new BigDecimal(1.5),cup));
        thirtyMinuteChickenParmigianaBake.addIngredient(new Ingredient("Fountain Spicy Red sauce",new BigDecimal(1/3),cup));
        thirtyMinuteChickenParmigianaBake.addIngredient(new Ingredient("cup fresh basil leaves, torn",new BigDecimal(1/4),grams));
        thirtyMinuteChickenParmigianaBake.addIngredient(new Ingredient("fresh breadcrumbs",new BigDecimal(1/3),cup));
        thirtyMinuteChickenParmigianaBake.addIngredient(new Ingredient("Basil leaves",new BigDecimal(0),tablespoon));

        thirtyMinuteChickenParmigianaBake.getCategories().add(mexican);
        thirtyMinuteChickenParmigianaBake.getCategories().add(australian);


        recipes.add(thirtyMinuteChickenParmigianaBake);

        log.debug("getRecipes()-> end");

        return recipes;




    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
        log.debug("Loading bootstrap data");
    }
}
