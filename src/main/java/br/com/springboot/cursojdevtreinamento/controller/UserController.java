package br.com.springboot.cursojdevtreinamento.controller;


import br.com.springboot.cursojdevtreinamento.model.UsuarioModel;
import br.com.springboot.cursojdevtreinamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nicolas.santos
 */

@RestController
public class UserController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/mostrarnome/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String usuarioText(@PathVariable String name) {
        return "Curso Spring Boot API" + name + "!";
    }

    @RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String retornaOlaMundo(@PathVariable String nome) {

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(nome);
        usuarioRepository.save(usuario);//Este save vai gravar no banco de dados

        return "Olá Mundo " + nome;
    }

    @GetMapping(value = "listatodos") /*Primeiro metodo de API*/
    @ResponseBody
    public ResponseEntity<List<UsuarioModel>> listaUsuario() {

        List<UsuarioModel> usuarios = usuarioRepository.findAll(); /*Executa a consulta no banco de dados*/

        return new ResponseEntity<List<UsuarioModel>>(usuarios, HttpStatus.OK); /*Retorna a lista em JSON*/
    }

    @PostMapping (value = "salvar") /* Mapeia a URL*/
    @ResponseBody /*Descrição da resposta */
    public ResponseEntity<UsuarioModel> salvar(@RequestBody UsuarioModel usuarioModel){ //Recebe os dados para salvar

        UsuarioModel user = usuarioRepository.save(usuarioModel);

        return new ResponseEntity<UsuarioModel>(user, HttpStatus.CREATED);
    }

    @DeleteMapping (value = "delete") /* Mapeia a URL*/
    @ResponseBody /*Descrição da resposta */
    public ResponseEntity<String> delete(@RequestParam Long idUser){ //Recebe os dados para delete

       usuarioRepository.deleteById(idUser);

        return new ResponseEntity<String>("Usuário Deletado com Sucesso!", HttpStatus.OK);
    }

    @GetMapping (value = "buscarid") /* Mapeia a URL*/
    @ResponseBody /*Descrição da resposta */
    public ResponseEntity<UsuarioModel> buscarid(@RequestParam Long idUser){ //Recebe os dados para consultar

        UsuarioModel usuario = usuarioRepository.findById(idUser).get();

        return new ResponseEntity<UsuarioModel>(usuario, HttpStatus.OK);
    }


}
