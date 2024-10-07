package com.angel.practica1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.angel.practica1.exceptions.UserNotFoundException;
import com.angel.practica1.model.Usuario;
import com.angel.practica1.service.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);

        if (usuario == null) {
            throw new UserNotFoundException("Usuario no encontrado" + id);
        }

        return ResponseEntity.ok(usuario);
    }
    
    @PostMapping()
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario entity) {
        Usuario usuario = usuarioService.saveUsuario(entity);
        return ResponseEntity.ok(usuario);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable String id, @RequestBody Usuario entity) {
        usuarioService.updUsuario(Long.parseLong(id), entity);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.delUsuario(id);
    }
    
}
