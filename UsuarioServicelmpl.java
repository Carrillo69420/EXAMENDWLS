/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsuarioRepository;
import com.example.demo.dto.Usuario;


/**
 *
 * @author Arturo Carrillo
 */
@Service
public class UsuarioServicelmpl  implements UsuarioService{

    @Autowired
    public UsuarioRepository usuarioRepository;
    
    org.slf4j.Logger logger = LoggerFactory.getLogger(UsuarioServicelmpl.class);
    


    @Override
    public List<Usuario> GetAllProductos() {
        List<Usuario> Usuario = usuarioRepository.findAll();
        return Usuario;


    }

    @Override
    public Optional<Usuario> ObtenerProductosID(Long id) {
    Optional<Usuario> searchUser=usuarioRepository.findById(id);
        if(searchUser.isPresent()){
            logger.error("Encontrado el producto");
            return searchUser;
            
        }else{
            logger.error("No se encuentra el producto");
            throw new NoSuchElementException("No se encontro nada, regrese mas tarde por favor");
        }
    



    }

    @Override
    public Optional<Usuario> InsertarProducto(Usuario Usuario) {
        Optional<Usuario> optUsuario = Optional.of(Usuario);
        if(optUsuario.isPresent()){
            Usuario NuevoProducto= new Usuario();
            
            NuevoProducto.setNombre(Usuario.getNombre());
            NuevoProducto.setPrecio(Usuario.getPrecio());
            NuevoProducto.setExistencia(Usuario.getExistencia());
            NuevoProducto.setDescripcion(Usuario.getDescripcion());
            usuarioRepository.save(NuevoProducto);
            logger.info("Se ha insertado el producto que buscaba");
            
            Optional<Usuario> Producto = Optional .of(NuevoProducto);
            return Producto;


        }else{

            logger.error("No ha ingresado ningun usuario");
            throw new UnsupportedOperationException(" El examen se puso dificil pero no hay nada que papa Dios no pueda");

        }
        
    }

    @Override
    public Optional<Usuario> ActualizarProducto(Long id, Usuario Usuario) {
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if(optUsuario.isPresent()){
            Usuario Actualizate = optUsuario.get();

            Actualizate.setNombre(Usuario.getNombre());
            Actualizate.setPrecio(Usuario.getPrecio());
            Actualizate.setExistencia(Usuario.getExistencia());
            Actualizate.setDescripcion(Usuario.getDescripcion());

            usuarioRepository.save(Actualizate);





            
        

            logger.error("Se ha actualizado el producto con el id:  "+id);

            return Optional.of(Actualizate);

        }else{

        }
        logger.error("No se ha actualizado nada");

        throw new UnsupportedOperationException("Nel mijo");




    }

    @Override
    public void BorrarProducto(Long id) {
        
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if(optUsuario.isPresent()){
            Usuario ProductoEpico = optUsuario.get();

            usuarioRepository.deleteById(ProductoEpico.getId());

            logger.error("Se ha borrado el producto, lloremos");



        }else{
            logger.error("Ni pepe mijo, la proxima sera");
        }






        
    }


    
}
