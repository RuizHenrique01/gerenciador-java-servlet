package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static Integer generateId = 1; 
	
	static {
		Empresa empresa1 = new Empresa("Alura");
		empresa1.setId(generateId++);
		Empresa empresa2 = new Empresa("Caelum");
		empresa2.setId(generateId++);
		lista.add(empresa1);
		lista.add(empresa2);
	}
	
	public void adicionar(Empresa empresa) {
		empresa.setId(generateId++);
		Banco.lista.add(empresa);
	}
	
	public void remover(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}
	
	public Empresa buscaPorId(Integer id) {
		for(Empresa emp : lista) {
			if(emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}
	
	public List<Empresa> listar(){
		return Banco.lista;
	}
	
}
