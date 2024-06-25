package org.example.crudspringredis.controller;

import java.util.List;
import java.util.Optional;

import org.example.crudspringredis.model.Usuario;
import org.example.crudspringredis.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") // Permite solicitações de qualquer origem
@RequestMapping("/usuarios")

public class UsuarioController {
	
    private final UsuarioRepository usuarioRepository;

    
        public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @CrossOrigin(origins = "*") // Permite solicitações de qualquer origem    
    @PostMapping
    public Usuario addProduct(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @CrossOrigin(origins = "*") // Permite solicitações de qualquer origem
    @GetMapping("/{id}")
    public Optional<Usuario> getProduct(@PathVariable String id) {
        return usuarioRepository.findById(id);
    }
    @CrossOrigin(origins = "*") // Permite solicitações de qualquer origem
    @GetMapping
    public List<Usuario> getAllProducts() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @CrossOrigin(origins = "*") // Permite solicitações de qualquer origem
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable String id, @RequestBody Usuario usuarioDetails) {
    	Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        usuario.setNome(usuarioDetails.getNome());
        usuario.setEmail(usuarioDetails.getEmail());
        return usuarioRepository.save(usuario);
    }

    @CrossOrigin(origins = "*") // Permite solicitações de qualquer origem
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable String id) {
        usuarioRepository.deleteById(id);
    }
}