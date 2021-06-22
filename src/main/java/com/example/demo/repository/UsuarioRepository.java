package com.example.demo.repository;

import com.example.demo.models.UsuarioModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    @Query("select u from UsuarioModel u where u.userName like :name order by u.userName")
    List<UsuarioModel> findUsuarioModelByName(@Param("name") String name);

    @Override
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuario WHERE id = :id", nativeQuery = true)
    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM usuario WHERE id = :id", nativeQuery = true)
    ArrayList<UsuarioModel> procurarPorId(Long id);

    @Query(value = "SELECT * FROM usuario WHERE user_name like %:nombre%", nativeQuery = true)
    ArrayList<UsuarioModel> obterUsuarioPorNombre(String nombre);

    @Override
    @Query(value = "SELECT * FROM usuario", nativeQuery = true)
    List<UsuarioModel> findAll();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuario (user_name, password) VALUES (:username, :password);", nativeQuery = true)
    Integer salvarUsuario(String username, String password);
}



