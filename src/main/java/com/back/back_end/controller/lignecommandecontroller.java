package com.back.back_end.controller;

import com.back.back_end.model.Adress;
import com.back.back_end.model.LigneCommande;
import com.back.back_end.repository.adresserepository;
import com.back.back_end.repository.lignecommanderepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Lignecommande")
public class lignecommandecontroller {
    private lignecommanderepository repo;
    @Autowired
    public lignecommandecontroller(lignecommanderepository repo){
        this.repo=repo;
    }
    @GetMapping("/get")
    public List<LigneCommande> getall(){
        return repo.findAll();
    }
    @GetMapping("/getbyId/{id}")
    public ResponseEntity<?> getbyid (@PathVariable String id){
        Optional<LigneCommande> optionalcat = repo.findById(id);
        if(optionalcat.isPresent()){
            return new ResponseEntity<>(optionalcat.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("ligne not found",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/Create")
    public ResponseEntity<?> Create(@RequestBody LigneCommande adr){
        try{
            repo.save(adr);
            return new ResponseEntity<LigneCommande>(adr, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
    @PutMapping ("/Update/{id}")
    public ResponseEntity<?>  update (@PathVariable String id,@RequestBody LigneCommande cat){
        Optional <LigneCommande> optionalcat = repo.findById(id);
        if(optionalcat.isPresent()){
            LigneCommande categoryTosave = optionalcat.get();
            categoryTosave.setQuantite(cat.getQuantite() != null ?cat.getQuantite():cat.getQuantite());
            categoryTosave.setPrixtotale(cat.getPrixtotale() != 0 ? cat.getPrixtotale() : categoryTosave.getPrixtotale());
            repo.save(categoryTosave);
            return new ResponseEntity<>(categoryTosave, HttpStatus.OK);
        }
        return new ResponseEntity<>("ligne not found",HttpStatus.NOT_FOUND);

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
