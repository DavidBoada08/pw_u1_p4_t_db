package com.example;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.repository.modelo.Estudiante;
import com.example.service.EstudianteService;

@SpringBootApplication
public class PwU1P4TDbApplication implements CommandLineRunner {

	@Autowired
	private EstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(PwU1P4TDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub}

		Estudiante miEstudiante = new Estudiante();
		miEstudiante.setApellido("Boada");
		miEstudiante.setCedula("1720030723");
		miEstudiante.setNombre("David");
		miEstudiante.setFechaNacimiento(LocalDateTime.of(1989, 7, 7, 10, 50));

		Estudiante miEstudiante1 = new Estudiante();
		miEstudiante1.setApellido("Betancourt");
		miEstudiante1.setCedula("12458633");
		miEstudiante1.setNombre("Christian");

		// se puede h}usar el LocalDateTime o LocalDate
		miEstudiante1.setFechaNacimiento(LocalDateTime.of(1989, 7, 7, 10, 50));

		// 1.- Guardar Estudiante
		this.estudianteService.guardar(miEstudiante);
		this.estudianteService.guardar(miEstudiante1);

		// 5.- imprimir Reporte

		List<Estudiante> reporte = this.estudianteService.reporteDeTodos();
		System.out.println("Reporte de todos los estudiantes");
		for (Estudiante estu : reporte) {
			System.out.println(estu);
		}

		// 2.-Actualizar
		miEstudiante1.setApellido("Alban");
		this.estudianteService.actualizar(miEstudiante1);

		List<Estudiante> reporte2 = this.estudianteService.reporteDeTodos();
		System.out.println("Reporte de todos los estudiantes");
		for (Estudiante estu : reporte2) {
			System.out.println(estu);
		}
		;

		// 3.- eliminar
		this.estudianteService.borrar("13131654");
		List<Estudiante> reporte3 = this.estudianteService.reporteDeTodos();
		System.out.println("Reporte de todos los estudiantes");
		for (Estudiante estu : reporte3) {
			System.out.println(estu);
		}
		
		Estudiante e = this.estudianteService.buscarPorCedula("1720030723");
		System.out.println("La Cedula buscada"
				+ "\nPertence al  "+e);
		Estudiante e1= this.estudianteService.buscarPorCedula("12131212");
		System.out.println("El estudiante no está registrado  " + e1);

	}

}
