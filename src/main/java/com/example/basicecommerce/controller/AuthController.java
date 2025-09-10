package com.example.basicecommerce.controller;

import com.example.basicecommerce.dto.LoginDTO;
import com.example.basicecommerce.dto.RegistroDTO;
import com.example.basicecommerce.model.Usuario;
import com.example.basicecommerce.repository.UsuarioRepository;
import com.example.basicecommerce.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioRepository repo, PasswordEncoder encoder, JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegistroDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.username);
        usuario.setPassword(encoder.encode(dto.password));
        usuario.setRol(Usuario.Rol.CLIENTE);
        repo.save(usuario);
        return "Usuario registrado con éxito";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        Usuario usuario = repo.findByUsername(dto.username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!encoder.matches(dto.password, usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        return jwtUtil.generarToken(usuario.getUsername());
    }
}
