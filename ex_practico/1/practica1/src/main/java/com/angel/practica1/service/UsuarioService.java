package com.angel.practica1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.practica1.model.Usuario;
import com.angel.practica1.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Get all usuarios
     * @return List<Usuario>
     */
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     * Get usuario by id
     * @param id
     * @return Usuario
     */
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    /**
     * Save usuario
     * @param usuario
     * @return Usuario
     */
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Update usuario
     * @param usuario, id
     * @return Usuario
     */
    public Usuario updUsuario(Long id, Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findById(id).orElse(null);
        existingUsuario.setNombre(usuario.getNombre());
        existingUsuario.setApellido(usuario.getApellido());
        existingUsuario.setEmail(usuario.getEmail());
        existingUsuario.setDireccion(usuario.getDireccion());
        return usuarioRepository.save(existingUsuario);
    }

    /**
     * Delete usuario
     * @param id
     */
    public void delUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
