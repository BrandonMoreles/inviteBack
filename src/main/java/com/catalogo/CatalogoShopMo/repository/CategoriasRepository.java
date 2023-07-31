package com.catalogo.CatalogoShopMo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogo.CatalogoShopMo.model.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
	void deleteById(Long id);
    Categorias findByUnicode(int unicode);

}
