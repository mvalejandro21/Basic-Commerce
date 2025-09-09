package com.example.basicecommerce.controller;


import com.example.basicecommerce.model.Usuario;
import com.example.basicecommerce.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class AuthController {
    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;

    public AuthController(UsuarioRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        usuario.setRol("USER");
        repo.save(usuario);
        return "Usuario registrado con éxito";
    }
}
