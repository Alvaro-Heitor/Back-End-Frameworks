package com.agenda;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BancoDeDados {
private static List<Agenda> agendas = new ArrayList<>();
public Agenda criar(Agenda agenda){
    agenda.setId(agendas.size() + 1L);
    agendas.add(agenda);
    return agenda;
    }
    public List<Agenda> listar(){
     return agendas;
    }
    public Agenda atualizar(Long id, Agenda novaAgenda){
    Agenda agenda = null;
    for (Agenda item : agendas) {
        if (Objects.equals(item.getId(), id)){

            item.setTitulo(novaAgenda.getTitulo());
            item.setDescricao(novaAgenda.getDescricao());
            break;
            }
        }
    return agenda;
    }
    public void excluir(Long id){
        for (Agenda item : agendas){
            if (Objects.equals(item.getId(), id)){
                Agenda agenda = item;
                break;
            }
        }
    }
}
