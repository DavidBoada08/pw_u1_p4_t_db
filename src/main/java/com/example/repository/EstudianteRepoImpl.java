package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.repository.modelo.Estudiante;

@Repository
public class EstudianteRepoImpl implements EstudianteRepo {

	// Mok servicios de simulacion de base de datos
	private static List<Estudiante> baseDatos = new ArrayList<>();

	@Override
	public void insertar(Estudiante estudiante) {
		baseDatos.add(estudiante);

	}

	@Override
	public void actualizar(Estudiante estudiante) {
		Estudiante estu = this.selecionar(estudiante.getCedula());
		this.eliminar(estudiante.getCedula());
		this.insertar(estudiante);
	}

	@Override
	public Estudiante selecionar(String cedula) {
		Estudiante estuEncontrado = new Estudiante();
		for (Estudiante estu : baseDatos) {
			if (cedula.equals(estu.getCedula())) {
				estuEncontrado = estu;
			}
		}
		return estuEncontrado;
	}

	@Override
	public void eliminar(String cedula) {
		Estudiante estu =  this.selecionar(cedula);
		baseDatos.remove(estu);
	}

	@Override
	public List<Estudiante> selecionarTodos() {
		return baseDatos;
	}
	
}
