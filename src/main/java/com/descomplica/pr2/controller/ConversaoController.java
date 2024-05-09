package com.descomplica.pr2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

import java.text.DecimalFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/")
public class ConversaoController {
    float cambio = 5.08f;
    DecimalFormat df = new DecimalFormat("#.00");

    @GetMapping("/")
    @Operation(summary = "Página Inicial")
    public ResponseEntity<String> get() {
        String instrucoes = "<h1>Página Inicial</h1>";
        instrucoes += "<p>Acesse o Swagger clicando <a href='/swagger-ui.html'><b>aqui!</b></a></p>";
        return ResponseEntity.ok(instrucoes);
    }

    @GetMapping("/dolar-real/{valor}")
    @Operation(summary = "Converter valor de Dólar Americano (US$) para Real Brasilerio (R$)", description = "Calculadora de conversão de valores de Real Brasileiro (R$) para Dólares Americanos (US$)")
    public String dolarPraReal(@PathVariable float valor) {
        float valorConvertido = valor / cambio;
        return "O valor de US$" + df.format(valor) + " correspondem a R$" + df.format(valorConvertido);
    }

    @GetMapping("/real-dolar/{valor}")
    @Operation(summary = "Converter valor de Real Brasileiro (R$) para Dólar Americano (US$)", description = "Calculadora de conversão de valores de Dólares Americanos (US$) para Real Brasileiro (R$)")
    public String RealPraDolar(@PathVariable float valor) {
        float valorConvertido = valor * cambio;
        return "O valor de R$" + df.format(valor) + " correspondem a US$" + df.format(valorConvertido);
    }

}
