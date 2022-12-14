package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static Integer generateId = 1; 
	
	static {
		Empresa empresa1 = new Empresa("Alura");
		empresa1.setId(generateId++);
		Empresa empresa2 = new Empresa("Caelum");
		empresa2.setId(generateId++);
		lista.add(empresa1);
		lista.add(empresa2);
		
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("Affonso");
		usuario1.setSenha("12345");
		
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("Augusto");
		usuario2.setSenha("12345");
		
		listaUsuarios.add(usuario1);
		listaUsuarios.add(usuario2);
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

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
	
}
