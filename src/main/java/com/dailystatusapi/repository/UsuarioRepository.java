package com.dailystatusapi.repository;

import java.util.Optional;

import com.dailystatusapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);
}
