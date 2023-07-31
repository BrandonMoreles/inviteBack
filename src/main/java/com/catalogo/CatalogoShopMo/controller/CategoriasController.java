package com.catalogo.CatalogoShopMo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.catalogo.CatalogoShopMo.model.Categorias;
import com.catalogo.CatalogoShopMo.service.CategoriasService;
import java.util.Set;

@RestController
@RequestMapping("/invitacion")
public class CategoriasController {
    private final CategoriasService categoriasService;

    @Autowired
    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @GetMapping("/invite")
    public String obtenerCategorias(Model model) {
        List<Categorias> categorias = categoriasService.obtenerCategorias();
        model.addAttribute("categorias", categorias);
        return "categorias"; // nombre de la vista que mostrará la lista de productos
    }

    @GetMapping
    public List<Categorias> obtenerTodasCategorias() {
        return categoriasService.obtenerCategorias();
    }

    @GetMapping("/{id}")
    public Categorias obtenerCategoriasPorId(@PathVariable int id) {
        return categoriasService.buscarPorUnicode(id);
    }

    @PostMapping
    public ResponseEntity<Categorias> crearCategoria(@RequestBody Categorias categoria) {
        Categorias categoriaGuardada = categoriasService.guardarcCategorias(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorias> actualizarCategoria(@PathVariable Long id, @RequestBody Categorias categoria) {
        Optional<Categorias> categoriaExistente = categoriasService.obtenerCategoriasPorId(id);

        if (!categoriaExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        categoria.setId(id);
        Categorias categoriaActualizada = categoriasService.guardarcCategorias(categoria);

        return ResponseEntity.ok(categoriaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        if (!categoriasService.obtenerCategoriasPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        categoriasService.eliminarCategorias(id);
        return ResponseEntity.noContent().build();
    }

    public CategoriasService getCategoriasService() {
        return categoriasService;
    }
    @PutMapping("/{unicode}/verify") // Cambiar el mapeo de acuerdo al valor que desees recibir como unicode
    public ResponseEntity<Categorias> actualizarVerify(@PathVariable int unicode) {
        Categorias categoria = categoriasService.buscarPorUnicode(unicode);

        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }

        categoria.setVerify(true); // Cambiar el valor a true

        Categorias categoriaActualizada = categoriasService.guardarcCategorias(categoria); // Guardar la categoría actualizada

        return ResponseEntity.ok(categoriaActualizada);
    }
}

