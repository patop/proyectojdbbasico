package com.pjb.presentacion;

import java.util.List;
import java.util.Scanner;

import com.pjb.datos.PersonaDAO;
import com.pjb.domain.Persona;

public class Main {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        int opcion = -1;
        Scanner scanner = new Scanner(System.in);

        
        while (opcion != 0) {
            System.out.println("Ingrese opción\n" +
                    "1.- Mostrar Personas en la BD\n" +
                    "2.- Insertar Persona en la BD\n" +
                    "3.- Modificar Persona en la BD\n" +
                    "4.- Eliminar Persona en la BD\n" +
                    "0.- Salir");
            opcion = Integer.parseInt(scanner.nextLine());
           
            if (opcion == 1) {
                mostrarPersonas(personaDAO);
            }else if (opcion == 2) {
                insertarPersona(personaDAO);
            }else if (opcion == 3) {
                actualizarPersona(personaDAO);
            }else if (opcion == 4) {
                eliminarPersona(personaDAO);
            }else if (opcion == 0) {
                System.out.println("Adios");
                scanner.close();
            }else{
                System.out.println("Opcion no reconocida");
            }
        }

    }

    public static void mostrarPersonas(PersonaDAO personaDAO) {
        List<Persona> personas = personaDAO.seleccionar();
        System.out.println("*********************************************");
        personas.forEach(persona -> {
            System.out.println("Persona" + persona);
        });
        System.out.println("*************************************************");
    }

    public static void insertarPersona(PersonaDAO personaDAO) {
        Persona persona = null;
        Scanner scanner = new Scanner(System.in);
        String nombrePersona = null;
        String claverPersona = null;

        System.out.println("Ingrese Nombre de la persona: ");
        nombrePersona = scanner.nextLine();
        System.out.println("Ingrese Clave de la Persona: ");
        claverPersona = scanner.nextLine();
        //scanner.close();
        persona = new Persona(nombrePersona, claverPersona);
        personaDAO.insertar(persona);
        mostrarPersonas(personaDAO);
    }

    public static void eliminarPersona(PersonaDAO personaDAO) {
        Persona persona = null;
        Scanner scanner = new Scanner(System.in);
        int idPersona;

        System.out.println("Ingrese ID Persona: ");
        idPersona = Integer.parseInt(scanner.nextLine());
        //scanner.close();
        persona = new Persona(idPersona);
        personaDAO.eliminar(persona);

        mostrarPersonas(personaDAO);
    }

    public static void actualizarPersona(PersonaDAO personaDAO) {
        Persona persona = null;
        Scanner scanner = new Scanner(System.in);
        String nombrePersona = null;
        String clavePersona = null;
        int idPersona;

        System.out.println("Ingrese Id Persona: ");
        idPersona = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese Nombre de la Persona: ");
        nombrePersona = scanner.nextLine();
        System.out.println("Ingrese Clave Persona: ");
        clavePersona = scanner.nextLine();
        //scanner.close();

        persona = new Persona(idPersona, nombrePersona, clavePersona);
        personaDAO.actualizar(persona);

        mostrarPersonas(personaDAO);

    }

}