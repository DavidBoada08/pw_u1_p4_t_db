package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.EstudianteRepo;
import com.example.repository.modelo.Estudiante;

@Service
public class EstudainteServiceImpl implements EstudianteService {
	
	@Autowired
	private EstudianteRepo estudianteRepo;

	@Override
	public void guardar(Estudiante estudiante) {
		this.estudianteRepo.insertar(estudiante);
		
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepo.actualizar(estudiante);
		
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		
		return this.estudianteRepo.selecionar(cedula);
	}

	@Override
	public void borrar(String cedula) {
		this.estudianteRepo.eliminar(cedula);
	}

	@Override
	public List<Estudiante> reporteDeTodos() {


		return this.estudianteRepo.selecionarTodos();
	}
	

}
