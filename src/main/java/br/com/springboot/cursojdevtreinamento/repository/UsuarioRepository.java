package br.com.springboot.cursojdevtreinamento.repository;

import br.com.springboot.cursojdevtreinamento.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

}
