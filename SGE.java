package sge;

import java.util.ArrayList;
import java.util.Scanner;

public class SGE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        int totalEstudiantes = 0;       
        boolean banderaSalir = false;    

        while (!banderaSalir) {
            System.out.println("\n=== SGE ===");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");

            int opcion = 0;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                opcion = 0;
            }

            switch (opcion) {
                case 1 -> {
                    try {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Nota: ");
                        double nota = Double.parseDouble(sc.nextLine());

                        Estudiante nuevo = new Estudiante(id, nombre, nota);
                        estudiantes.add(nuevo);
                        totalEstudiantes++;
                        System.out.println("Estudiante agregado");
                    } catch (NumberFormatException ex) {
                        System.out.println("Dato invalido: el ID debe ser entero y la nota usa punto (ej: 4.5)");
                    }
                }
                case 2 -> {
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados");
                    } else {
                        for (Estudiante e : estudiantes) {
                            mostrarEstudiante(e);
                        }
                        System.out.println("Total: " + totalEstudiantes);
                    }
                }
                case 3 -> {
                    try {
                        System.out.print("ID a buscar: ");
                        int idBuscado = Integer.parseInt(sc.nextLine());
                        boolean encontrado = false; 

                        for (Estudiante e : estudiantes) {
                            if (e.id == idBuscado) {
                                mostrarEstudiante(e);
                                encontrado = true;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("No se encontro un estudiante con ese ID");
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("El ID debe ser un numero entero");
                    }
                }
                case 4 -> {
                    banderaSalir = true;
                    System.out.println("Hasta luego");
                }
                default -> System.out.println("Opcion invalida");
            }
        }
    }

    static void mostrarEstudiante(Estudiante e) {
        System.out.println("ID: " + e.id + " | Nombre: " + e.nombre + " | Nota: " + e.nota);
    }
}
