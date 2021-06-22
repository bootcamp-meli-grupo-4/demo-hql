package com.example.demo.controller;

import com.example.demo.models.UsuarioModel;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/list")
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/list/{name}")
    public ArrayList<UsuarioModel> obtenerUsuariosPorNombre(@PathVariable String name){
        return usuarioService.obtenerUsuariosPorNombre3(name);
    }

    @GetMapping("/{id}")
    public ArrayList<UsuarioModel> obtenerUsuariosPorId(@PathVariable Long id){
        return usuarioService.obtenerUsuariosPorId(id);
    }


    @PostMapping
    public Integer guardarUsuario(@RequestBody UsuarioModel usuarioModel){
        return this.usuarioService.guardarUsuario(usuarioModel);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
