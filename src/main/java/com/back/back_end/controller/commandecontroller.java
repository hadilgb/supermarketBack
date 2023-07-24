package com.back.back_end.controller;

import com.back.back_end.model.Commande;
import com.back.back_end.repository.ProductRepository;
import com.back.back_end.repository.commanderepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Commande")
public class commandecontroller {
    private commanderepository repo;
    @Autowired
    public commandecontroller(commanderepository repo){
        this.repo=repo;
    }
    @GetMapping("/get")
    public List<Commande> getall(){
        return repo.findAll();
    }
    @GetMapping("/getbyId/{id}")
    public ResponseEntity<?> getbyid (@PathVariable String id){
        Optional<Commande> optionalcat = repo.findById(id);
        if(optionalcat.isPresent()){
            return new ResponseEntity<>(optionalcat.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Commande not found",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/Createprod")
    public ResponseEntity<?> Create(@RequestBody Commande adr){
        try{
            repo.save(adr);
            return new ResponseEntity<Commande>(adr, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity<?>  update (@PathVariable String id,@RequestBody Commande cat){
        Optional <Commande> optionalcat = repo.findById(id);
        if(optionalcat.isPresent()){
            Commande categoryTosave = optionalcat.get();
            categoryTosave.setPrixTT(cat.getPrixTT() != 0 ?cat.getPrixTT():cat.getPrixTT());
            categoryTosave.setEtat(cat.getEtat() != null ? cat.getEtat() : categoryTosave.getEtat());
            repo.save(categoryTosave);
            return new ResponseEntity<>(categoryTosave, HttpStatus.OK);
        }
        return new ResponseEntity<>("Commande not found",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable String id){
        try{
            repo.deleteById(id);
            return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

}
