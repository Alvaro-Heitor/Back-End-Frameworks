package com.example.contato_service.controller;

import com.example.contato_service.model.Contato;
import com.example.contato_service.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> listarTodos() {
        return (List<Contato>) contatoService.listarTodos();
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato) {
        return contatoService.create(contato);
    }

    @GetMapping("/{id}")
    public Contato listarPorId(@PathVariable Long id) {
        return contatoService.listarPorId(id);
    }

    @PutMapping("/{id}")
    public Contato atualizarPorId(@PathVariable Long id, @RequestBody Contato contato) {
        return contatoService.atualizarPorId(id, contato);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        contatoService.deletePorId(id);
    }

    @PatchMapping("/{id}/favoritar")
    public void favoritarPorId(@PathVariable Long id) {
        contatoService.favoritarPorId(id);
    }
}
