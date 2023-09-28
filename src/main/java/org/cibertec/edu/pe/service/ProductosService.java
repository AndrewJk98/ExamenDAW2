package org.cibertec.edu.pe.service;
import java.util.List;
import java.util.Optional;
import org.cibertec.edu.pe.interfaceService.IProductosService;
import org.cibertec.edu.pe.interfaces.IProductos;
import org.cibertec.edu.pe.modelo.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService implements IProductosService {

	@Autowired
	private IProductos data;
	
	@Override
	public List<Productos> Listar() {
		return (List<Productos>)data.findAll();
	}

	@Override
	public Optional<Productos> Buscar(String Id) {
		return data.findById(Id);
	}

	@Override
	public int Grabar(Productos ObjC) {
		int rpta = 0;
		Productos Obj = data.save(ObjC);
		if(!Obj.equals(null))rpta = 1;
		return rpta;
	}

	@Override
	public void Suprimir(String Id) {
		data.deleteById(Id);
	}
}
