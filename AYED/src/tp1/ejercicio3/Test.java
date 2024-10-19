package tp1.ejercicio3;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        ArrayList<Profesor> listaProfesores = new ArrayList<>();

        Estudiante e1 = new Estudiante("Juan", "Perez", "Ingeniería", "juanperez@gmail.com", "C/ Juan Perez");        
        Estudiante e2 = new Estudiante("Juan", "Perez", "Ingeniería", "juanperez@gmail.com", "C/ Juan Perez");        
        listaEstudiantes.add(e1);
        listaEstudiantes.add(e2);
        Profesor p1 = new Profesor("Juan", "Perez", "juanperez@gmail.com", "Ingeniería", "Informática");
        Profesor p2 = new Profesor("Juan", "Perez", "juanperez@gmail.com", "Ingeniería", "Informática");
        listaProfesores.add(p1);
        listaProfesores.add(p2);        

        for (Profesor profesor : listaProfesores) {
            System.out.println(profesor.tusDatos());
        }
        System.out.println("-----");
        for (Profesor profesor : listaProfesores) {
            System.out.println(profesor.tusDatos());
        }

    }
}   
