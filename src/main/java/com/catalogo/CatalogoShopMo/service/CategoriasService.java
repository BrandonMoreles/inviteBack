package com.catalogo.CatalogoShopMo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.CatalogoShopMo.model.Categorias;
import com.catalogo.CatalogoShopMo.repository.CategoriasRepository;


@Service
public class CategoriasService {
	   private final CategoriasRepository categoriasRepository;

	@Autowired
	    public CategoriasService(CategoriasRepository categoriasRepository) {
	        this.categoriasRepository = categoriasRepository;
	    }
	 public List<Categorias> obtenerCategorias() {
	        return categoriasRepository.findAll();
	    }

	    public Optional<Categorias> obtenerCategoriasPorId(Long id) {
	        return categoriasRepository.findById(id);
	    }

	    public Categorias guardarcCategorias(Categorias categorias) {
	        return categoriasRepository.save(categorias);
	    }

	    public void eliminarCategorias(Long id) {
	        categoriasRepository.deleteById(id);
	    }
	
	    public Categorias buscarPorUnicode(int unicode) {
	        return categoriasRepository.findByUnicode(unicode);
	    }

	public CategoriasRepository getCategoriasRepository() {
		return categoriasRepository;
	}
}
