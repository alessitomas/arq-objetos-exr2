package com.mensagens.mensagens.mensagens;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MensagemController {
    @Autowired
    private MensagemService mensagemService;
    
    @GetMapping("/mensagem")
    public List<Mensagem> getMensagens() {
        return mensagemService.getMensagens();
    }
    @PostMapping("/mensagemText")
    public MensagemTexto criaMensagemText(@RequestBody Map<String, Object> json) {
        return mensagemService.salvaMensagemText(json.get("id_user").toString(), json.get("texto").toString());
    }
    @PostMapping("/mensagemArquivo")
    public MensagemArquivo criaMensagemArquivo(@RequestBody Map<String, Object> json) {
        return mensagemService.salvaMensagemArquivo(json.get("id_user").toString(), json.get("texto").toString());
    }
    @GetMapping("/mensagem/{id}")
    public Mensagem getMensagemById(@PathVariable String id) {
        return mensagemService.getMensagemById(id);
    }
    @GetMapping("/mensagem/{id}/user")
    public List<Mensagem> getMensagens_user(@PathVariable String id) {
        return mensagemService.getMensagens_user(id);
    }
    
}
