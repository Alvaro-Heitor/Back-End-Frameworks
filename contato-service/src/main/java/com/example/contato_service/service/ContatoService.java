package com.example.contato_service.service;

import com.example.contato_service.model.Contato;
import com.example.contato_service.repository.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Object listarTodos() {
        HashMap<String, List<Contato>> map = new HashMap<>();
        var list = contatoRepository.findAllAsc();
        for(Contato item : list){
            var letra = item.getNome().substring(0, 1);
            var itemList = list.stream()
                    .filter(i -> letra.equals(i.getNome().substring(0, 1)))
                    .toList();

            map.put(letra, itemList);
        }
        return map;
    }

    public Contato listarPorId(Long id) {
        Optional<Contato> optionalContato = contatoRepository.findById(id);
        return optionalContato.orElseThrow(() -> new RuntimeException("contato nao encontrado"));
    }

    public Contato atualizarPorId(Long id, Contato contato) {
        Contato contatoSalvo = listarPorId(id);

        contato.setId(id);
        BeanUtils.copyProperties(contato, contatoSalvo);

        contatoRepository.save(contatoSalvo);
        return contatoSalvo;
    }

    public void deletePorId(Long id) {
        Contato contato = listarPorId(id);
        contatoRepository.delete(contato);
    }

    public void favoritarPorId(Long id) {
        Contato contato = listarPorId(id);
        contato.setFavorito(true);
        contatoRepository.save(contato);
    }


}
