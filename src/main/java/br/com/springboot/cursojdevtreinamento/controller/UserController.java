package br.com.springboot.cursojdevtreinamento.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author nicolas.santos
 */

@RestController
public class UserController {

    @RequestMapping(value = "/mostrarnome/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String usuarioText(@PathVariable String name){
        return "Curso Spring Boot API" + name + "!";
    }

    @RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String retornaOlaMundo(@PathVariable String nome){
        return "Olá Mundo " + nome;
    }
}
