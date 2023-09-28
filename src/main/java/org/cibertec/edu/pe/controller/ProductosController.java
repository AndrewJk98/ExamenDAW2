package org.cibertec.edu.pe.controller;
import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductosService;
import org.cibertec.edu.pe.modelo.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProductosController {
	
	@Autowired
	private IProductosService servicio;
	
	// Método para Listar
	@GetMapping("/listar")
	public String Listado(Model m) {
		List<Productos> lista = servicio.Listar();
		m.addAttribute("productos", lista);
		return "listado";	// listado.html
	}
	
	// Método para Buscar
	@GetMapping("/addCart/{id}")
	public String Buscar(@PathVariable String id,Model m) {
		Optional<Productos> ObjC = servicio.Buscar(id);
		m.addAttribute("producto", ObjC);
		return "addCart";
	}

	@GetMapping("/nuevo")
	public String agregar(Model m) {
		m.addAttribute("producto",new Productos());
		return "form";
	}

	@PostMapping("/save")
	public String salvar(@Validated Productos ObjC, Model m) {
		servicio.Grabar(ObjC);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable String id, Model m) {
		Optional<Productos> ObjC = servicio.Buscar(id);
		m.addAttribute("producto", ObjC);
		return "form";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable String id, Model m) {
		servicio.Suprimir(id);
		return "redirect:/listar";
	}
}
