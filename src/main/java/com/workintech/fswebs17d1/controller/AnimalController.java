package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    @Value("${course.name:Workintech}")
    private String courseName;
    @Value("${project.developer.fullname:Eren}")
    private String developerName;
    private Map<Integer, Animal> animals;

    @PostConstruct
    public void init() { this.animals = new HashMap<>(); }

    @GetMapping
    public List<Animal> getAnimals() { return new ArrayList<>(animals.values()); }
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) { return animals.get(id); }
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) { animals.put(animal.getId(), animal); return animal; }
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal animal) { animals.put(id, animal); return animal; }
    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable Integer id) { return animals.remove(id); }
}
