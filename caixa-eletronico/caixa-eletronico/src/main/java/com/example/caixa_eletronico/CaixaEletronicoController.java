package com.example.caixa_eletronico;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaixaEletronicoController {
    private static Double saldo = 0.0;
    @GetMapping
    public SaldoDTO consultar(){
        return new SaldoDTO(saldo);
    }
    @PostMapping
    public void depositar(@RequestBody ValorDTO depositar){
        saldo += depositar.valor();
    }
    @PostMapping (path = "/sacar")
    public void sacar(@RequestBody ValorDTO sacar){
        if(saldo < sacar.valor()){
            throw new RuntimeException("Saldo Insuficiente!");
        }
        saldo -= sacar.valor();
    }
}
