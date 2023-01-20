package com.dds.notesbox.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dds.notesbox.dao.repositories.AddressRepository;
import com.dds.notesbox.dao.repositories.CategoryRepository;
import com.dds.notesbox.dao.repositories.CustomerRepository;
import com.dds.notesbox.dao.repositories.SpecialCollectionRepository;

import com.dds.notesbox.dao.repositories.MelodyRepository;
import com.dds.notesbox.dao.repositories.UserRepository;
import com.dds.notesbox.models.products.Category;
import com.dds.notesbox.models.products.Melody;
import com.dds.notesbox.models.products.SpecialCollection;
import com.dds.notesbox.models.users.Address;
import com.dds.notesbox.models.users.Customer;

@RestController
public class SampleDataController {

  /* Repositories */

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private MelodyRepository melodyRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private SpecialCollectionRepository specialCollectionRepository;
  
  @RequestMapping(value = "api/test/users/create-sample-data")
  public String createSampleUsers() {
    Address a1 = new Address("Rivadavia", "210", "Buenos Aires", "CABA", "Argentina", null, null);
    Customer c1 = new Customer("Matias Rossi", "contraseña", "mr@mail.com", a1);
    addressRepository.persist(a1);
    customerRepository.persist(c1);

    return "Data created";
  }

  @RequestMapping( value = "api/test/melodies/create-sample-data")
  public String createSampleMelodies() {
    /* Categories */
    Category festive = new Category("Festive 🎊");
    Category sports = new Category("Sports");
    Category movies = new Category("Movies");
    Category classical = new Category("Classical");
    Category other = new Category("Other");

    List<Category> categories = new ArrayList<>(Arrays.asList(festive, sports, movies, classical, other));

    categories.forEach(c -> categoryRepository.persist(c));


    /* Melodies */
    Melody jingleBells = new Melody("Jingle Bells", "", 24, 19, festive);
    Melody lastChristmas = new Melody("Last Christmas", "", 24, festive);
    Melody muchachos = new Melody("Mucahchos", "", 29, sports);
    Melody arrancarmelo = new Melody("Arrancarmelo", "", 29, sports);
    Melody titanic = new Melody("Titanic", "", 29, movies);
    Melody miEnfermedad = new Melody("Mi Enfermedad", "", 29, other);

    Melody theScientist = new Melody("The Scientist", "", 29, other);
    Melody amEnde = new Melody("Am Ende", "", 24, sports);
    Melody dangerZone = new Melody("Danger Zone", "", 29, movies);
    Melody takeMyBreathAway = new Melody("Take My Breath Away", "", 29, movies);
    Melody holdMyHand = new Melody("Hold My Hand", "", 29, 19, movies);
    Melody frostyTheSnowman = new Melody("Frosty the Snowman", "", 24, festive);
    Melody christmasWaltz = new Melody("The Christmas Waltz", "", 24, 19, festive);
    Melody firstNoel = new Melody("The First Noël", "", 24, festive);
    Melody oChristmasTree = new Melody("O Christmas Tree", "", 24, festive);

    List<Melody> melodies = new ArrayList<>(Arrays.asList(jingleBells, lastChristmas, muchachos, arrancarmelo, 
    titanic, miEnfermedad, theScientist, amEnde, dangerZone, takeMyBreathAway, holdMyHand, frostyTheSnowman,
    christmasWaltz, firstNoel, oChristmasTree));

    melodies.forEach(m -> melodyRepository.persist(m));
    categories.forEach(c -> categoryRepository.update(c));


    /* Special Collections */
    SpecialCollection seasonalPicks = new SpecialCollection("Seasonal picks");
    SpecialCollection trending = new SpecialCollection("Trending");
    SpecialCollection newest = new SpecialCollection("Newest");

    List<SpecialCollection> scList = new ArrayList<>(Arrays.asList(seasonalPicks, trending, newest));

    scList.forEach(m -> specialCollectionRepository.persist(m));
    

    seasonalPicks.addProduct(jingleBells);
    seasonalPicks.addProduct(lastChristmas);
    seasonalPicks.addProduct(frostyTheSnowman);
    seasonalPicks.addProduct(christmasWaltz);
    seasonalPicks.addProduct(firstNoel);
    seasonalPicks.addProduct(oChristmasTree);

    trending.addProduct(muchachos);
    trending.addProduct(jingleBells);
    trending.addProduct(lastChristmas);
    trending.addProduct(oChristmasTree);
    trending.addProduct(holdMyHand);
    trending.addProduct(arrancarmelo);
    newest.addProduct(miEnfermedad);
    newest.addProduct(theScientist);
    newest.addProduct(amEnde);
    newest.addProduct(dangerZone);
    newest.addProduct(lastChristmas);
    newest.addProduct(jingleBells);
    
    scList.forEach(m -> specialCollectionRepository.update(m));


    
    return "Data created";
  }
}
