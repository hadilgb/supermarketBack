package com.back.back_end.controller;

import com.back.back_end.model.Product;
import com.back.back_end.model.category;
import com.back.back_end.repository.ProductRepository;
import com.back.back_end.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Product")
public class productcontroller {
    private ProductRepository prodrepo;
    private categoryRepository catrepo;
    @Autowired
    public productcontroller(ProductRepository prodrepo){
        this.prodrepo=prodrepo;
    }
    @GetMapping("/getprod")
    public List<Product> getall(){
        return prodrepo.findAll();
    }
    @GetMapping("/productbyId/{id}")
    public ResponseEntity<?> getbyid (@PathVariable String id){
        Optional<Product> optionalcat = prodrepo.findById(id);
        if(optionalcat.isPresent()){
            return new ResponseEntity<>(optionalcat.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("category not found",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/productbyName/{name}")
    public ResponseEntity<?> getbyname (@PathVariable String name){
        List <Product> optionalcat = prodrepo.findItemByName(name);
        if(optionalcat.size()>0){
            return new ResponseEntity<List<Product>>(optionalcat, HttpStatus.OK);
        }
        return new ResponseEntity<>("category not found",HttpStatus.NOT_FOUND);
    }
    @PostMapping("/Createprod")
    public ResponseEntity<?> Create(@RequestBody Product prod){
        try{
            prodrepo.save(prod);
            return new ResponseEntity<Product>(prod, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping ("/Updateprod/{id}")
    public ResponseEntity<?>  update (@PathVariable String id,@RequestBody Product cat){
        Optional <Product> optionalcat = prodrepo.findById(id);
        if(optionalcat.isPresent()){
            Product categoryTosave = optionalcat.get();
            categoryTosave.setQuantite(cat.getQuantite() != null ?cat.getQuantite():cat.getQuantite());
            categoryTosave.setPrixunite(cat.getPrixunite() != 0 ?cat.getPrixunite():cat.getPrixunite());
            categoryTosave.setNombreClic(cat.getNombreClic() != 0 ?cat.getNombreClic():cat.getNombreClic());
            categoryTosave.setNombreClic(cat.getNombrevente() != 0 ?cat.getNombrevente():cat.getNombrevente());
            categoryTosave.setImgUrl(cat.getImgUrl() != null ? cat.getImgUrl() : categoryTosave.getImgUrl());
            prodrepo.save(categoryTosave);
            return new ResponseEntity<>(categoryTosave, HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/deleteprod/{id}")
    public ResponseEntity<?> delete (@PathVariable String id){
        try{
            prodrepo.deleteById(id);
            return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}

