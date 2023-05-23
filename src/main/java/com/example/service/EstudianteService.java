package com.example.service;

import java.util.List;

import com.example.repository.modelo.Estudiante;

public interface EstudianteService {

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	// se busca atravez de un identificador
	public Estudiante buscarPorCedula(String cedula);

	// se elimina atravez de un identificador
	public void borrar(String cedula);

	public List<Estudiante> reporteDeTodos();

}
