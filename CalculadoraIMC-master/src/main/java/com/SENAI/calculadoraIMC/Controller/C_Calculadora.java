package com.SENAI.calculadoraIMC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Calculadora {
    @GetMapping("/")
    public String getHome(){
        return "Calculadora/calculadora";
    }

    @PostMapping("/")
    public String postHome(@RequestParam("altura") Float altura,
                           @RequestParam("peso") Float peso,
                            Model model){
        altura = altura/100;
        Float IMC = peso / (altura*altura);
        String categoria;
        if(IMC < 18.5){
            categoria = "Você está abaixo do peso";
        } else if(IMC > 18.5 && IMC < 25){
            categoria = "Você está com o peso Ideal";
        } else if(IMC > 24.9 && IMC < 30){
            categoria = "Você está com sobre peso";
        } else if(IMC > 29.9 && IMC < 35){
            categoria = "Você está com Obesidade Grau 1";
        } else if(IMC > 34.9 && IMC < 39.9){
            categoria = "Você está com Obesidade Grau 2 (Severa)";
        } else {
            categoria = "Você está com Obesidade Grau 3 (Mórbida)";
        }
        model.addAttribute("calculoIMC", String.format("%.2f",IMC));
        model.addAttribute("textoCategoria",categoria);
        return "Calculadora/calculadora";
    }
}
