package com.example.demo.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.OrderBy;
import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Livre;
import com.example.demo.repos.*;

import com.example.demo.entities.*;

@RestController
public class LivreController {
	@Autowired
	private LivreRepo br;
	//Avoir tous les livres
	@GetMapping("/emsi_api/livres")
	  public List<Livre> getAllBook(){
		
	    return br.findAll();
	  } 
	//Ajouter un livre
	@PostMapping("/emsi_api/livres/add")
	  public String addBook( @RequestBody Livre book){
		 br.save(book);
		 return "Livre ajoutee avec succes..";
	  } 
	// Avoir un livre d apres son id
    @GetMapping("/emsi_api/livres/{id}")
    public Optional<Livre> getNoteById(@PathVariable(value = "id") Long id)  {
        return br.findById(id);
                
    }
    //mise a jour
    @PutMapping("/emsi_api/livres/update/{id}")
    public String updateNote(@PathVariable(value = "id") Long bookId,
                           @Validated @RequestBody Livre bookDetails)  {

       Livre book = br.findById(bookId).get();

		book.setId(bookDetails.getId());
        book.setTitre(bookDetails.getTitre());
        book.setDsortie(bookDetails.getDsortie());
        book.setAuteur(bookDetails.getAuteur());
        book.setNbpages(bookDetails.getNbpages());
        book.setDconsultation(bookDetails.getDconsultation());
        book.setDisponibilite(bookDetails.isDisponibilite());
        Livre updatedBook = br.save(book);

        return "Livre Mise a jour avec succes..";
    }
    //supprimer 
    @DeleteMapping("/emsi_api/livres/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") Long id)  {
        Livre book = br.findById(id).get();

         br.delete(book);

        return "Livre  "+id+" supprimee avec succes..";
    }
	

}
