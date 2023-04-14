package com.mensagens.mensagens.mensagem;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mensagens.mensagens.mensagens.Mensagem;
import com.mensagens.mensagens.mensagens.MensagemArquivo;
import com.mensagens.mensagens.mensagens.MensagemController;
import com.mensagens.mensagens.mensagens.MensagemService;
import com.mensagens.mensagens.mensagens.MensagemTexto;
import com.mensagens.mensagens.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class MensagemControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    MensagemController mensagemController;

    @Mock
    MensagemService mensagemService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(mensagemController).build();
    }

    @Test
    void test_criar_mensagem_texto() throws Exception{



        Usuario usuario = new Usuario();
        usuario.setId(1);

        MensagemTexto mensagem = new MensagemTexto();
        mensagem.setTexto("teste");
        mensagem.setUsuario(usuario);

        ObjectMapper om = new ObjectMapper();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/mensagemText")
            .contentType("application/json")
            .content(om.writeValueAsString(json)))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String content = result.getResponse().getContentAsString();
        Assertions.assertEquals(om.writeValueAsString(mensagem), content);
    }

    @Test
    void test_criar_mensagem_arquivo() throws Exception{
            


    
            Usuario usuario = new Usuario();
            usuario.setId(1);
    
            MensagemArquivo mensagem = new MensagemArquivo();
            mensagem.setExtensao("teste.py");
            mensagem.setUsuario(usuario);
    
            Mockito.when(mensagemService.criarMensagemArquivo(json)).thenReturn(mensagem);
    
            ObjectMapper om = new ObjectMapper();
    
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/mensagemArquivo")
                .contentType("application/json")
                .content(om.writeValueAsString(json)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    
            String content = result.getResponse().getContentAsString();
            Assertions.assertEquals(om.writeValueAsString(mensagem), content);
    }

    @Test
    void test_todas_mensagens() throws Exception{

        Usuario usuario = new Usuario();
        usuario.setId(1);

        MensagemTexto mensagem = new MensagemTexto();
        mensagem.setTexto("teste");
        mensagem.setUsuario(usuario);

        List<Mensagem> mensagens = new ArrayList<>();
        mensagens.add(mensagem);

        Mockito.when(mensagemService.getMensagens()).thenReturn(mensagens);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/mensagem"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        ObjectMapper om = new ObjectMapper();

        Assertions.assertEquals(1, om.readValue(result.getResponse().getContentAsString(), List.class).size());
    }

    
}