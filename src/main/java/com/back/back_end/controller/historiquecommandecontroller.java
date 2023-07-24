package com.back.back_end.controller;


import com.back.back_end.model.Commande;
import com.back.back_end.model.HistoriqueCommande;
import com.back.back_end.repository.commanderepository;
import com.back.back_end.repository.historiquecommanderepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/historiquecommande")
public class historiquecommandecontroller {
    private historiquecommanderepository repo;
    @GetMapping("/get")
    public List<HistoriqueCommande> getall(){
        return repo.findAll();
    }
    @GetMapping("/getbyId/{id}")
    public ResponseEntity<?> getbyid (@PathVariable String id){
        Optional<HistoriqueCommande> optionalcat = repo.findById(id);
        if(optionalcat.isPresent()){
            return new ResponseEntity<>(optionalcat.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("HistoriqueCommande not found",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/Createprod")
    public ResponseEntity<?> Create(@RequestBody HistoriqueCommande adr){
        try{
            repo.save(adr);
            return new ResponseEntity<HistoriqueCommande>(adr, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity<?>  update (@PathVariable String id,@RequestBody HistoriqueCommande cat){
        Optional <HistoriqueCommande> optionalcat = repo.findById(id);
        if(optionalcat.isPresent()){
            HistoriqueCommande categoryTosave = optionalcat.get();
            categoryTosave.setListcommande(cat.getListcommande());
            repo.save(categoryTosave);
            return new ResponseEntity<>(categoryTosave, HttpStatus.OK);
        }
        return new ResponseEntity<>("HistoriqueCommande not found",HttpStatus.NOT_FOUND);
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
