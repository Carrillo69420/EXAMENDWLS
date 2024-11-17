/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Usuario;

/**
 *
 * @author Arturo Carrillo
 */
public interface UsuarioService {

        List<Usuario> GetAllProductos();

        Optional<Usuario> ObtenerProductosID(Long id);

        Optional<Usuario> InsertarProducto(Usuario Usuario);

        Optional<Usuario> ActualizarProducto(Long id, Usuario Usuario);
        
        void BorrarProducto(Long id);


    
}
