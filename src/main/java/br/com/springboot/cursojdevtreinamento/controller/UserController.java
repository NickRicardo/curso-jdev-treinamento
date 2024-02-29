package br.com.springboot.cursojdevtreinamento.controller;


import br.com.springboot.cursojdevtreinamento.model.UsuarioModel;
import br.com.springboot.cursojdevtreinamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author nicolas.santos
 */

@RestController
public class UserController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/mostrarnome/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String usuarioText(@PathVariable String name){
        return "Curso Spring Boot API" + name + "!";
    }

    @RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String retornaOlaMundo(@PathVariable String nome){

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(nome);
        usuarioRepository.save(usuario);//Este save vai gravar no banco de dados

        return "Olá Mundo " + nome;
    }
}
