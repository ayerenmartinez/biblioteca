package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EditorialServicio {
    @Autowired
    EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre){
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorialRepositorio.save(editorial);
    }

    public List<Editorial> listarEditoriales(){
        List<Editorial> editoriales = new ArrayList<>();
        editoriales = editorialRepositorio.findAll();
        return editoriales;
    }

    public void modificarEditorial(String id, String nombre){
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        if(respuesta.isPresent()){
            Editorial editorial = respuesta.get();
            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        }
    }
}
