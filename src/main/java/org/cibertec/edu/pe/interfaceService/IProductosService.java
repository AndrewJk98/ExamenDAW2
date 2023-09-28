package org.cibertec.edu.pe.interfaceService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.modelo.Productos;

public interface IProductosService {
	public List<Productos> Listar();
	public Optional<Productos> Buscar(String Id);
	public int Grabar(Productos ObjC);
	public void Suprimir(String Id);
}
