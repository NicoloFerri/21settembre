package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/studenti")
public class StudenteController {
    private List<Studente> studenti = new ArrayList<>();

    @GetMapping("/")
    public List<Studente> getStudenti(){
        return studenti;
    }

    @GetMapping("/{id}")
    public Studente getStudenteById(@PathVariable int id){
        for (Studente studente : studenti) {
            if(studente.getId()==id){
                return studente;
            }
        }
        return null;
    }


    @PostMapping("/")
    public String aggiungiStudente(@RequestBody Studente studente){
        studenti.add(studente);
        return "Studente aggiunto!";
    }

    @PutMapping("/{id}")
    public String aggiornaStudente(@PathVariable int id , @RequestBody Studente studente){
        for (int i=0 ; i<studenti.size();i++){
            if(studenti.get(i).getId()==id){
                studenti.set(i,studente);
                return "Studente aggiornato!";
            }
        }
        return "Studente non trovato!";
    }


    @DeleteMapping("/{id}")
    public String eliminaStudente(@PathVariable int id){
        for (Studente studente : studenti) {
            if(studente.getId()==id){
                studenti.remove(studente);
                return "Studente eliminato!";
        }
            }
       return "Studente non trovato!";
    }
}
