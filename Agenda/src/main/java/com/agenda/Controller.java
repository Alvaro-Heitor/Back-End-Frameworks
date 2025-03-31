package com.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private BancoDeDados bancoDeDados;

    @PostMapping("/")
    public Agenda criar(@RequestBody Agenda agenda){
        agenda = bancoDeDados.criar(agenda);
        return agenda;
    }
    @GetMapping
    public List<Agenda> Listar(){
        return AgendaRepository.listar(Agenda);
    }
    @PutMapping("/{id}")
    public Agenda Atualizar(@PathVariable Long id, @RequestBody Agenda agenda){
        return bancoDeDados.atualizar(id, agenda);
    }
    @DeleteMapping
    public ResponseEntity<Void> Excluir(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
}