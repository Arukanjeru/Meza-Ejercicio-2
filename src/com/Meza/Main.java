package com.Meza;
import com.Meza.Condiciones.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Visitas> visitas = new ArrayList();
        Scanner lector = new Scanner(System.in);
        boolean z = true;

        while (z) {
            boolean x = true;
            boolean y = true;
            System.out.println("Bienvenido a tu viaje ideal Aruka");
            System.out.println("\t(1) Hacer una reservacion");
            System.out.println("\t(2) Ver lista de clientes y viajes");
            System.out.println("\t(3) Salir");
            int opc = VerificarDatos.solicitarEntero("¿Que desea hacer?");
            System.out.println("\n");

            switch (opc) {

                case 1:
                    Visitas nuevaVisita = new Visitas();
                    while (x) {
                        try {
                            /**Verifica que el nombre este dentro de lo establecido**/
                            System.out.println("Ingrese su nombre completo: ");
                            String nombreCompleto = lector.nextLine();
                            if (!nombreCompleto.isBlank()) {
                                nuevaVisita.setNombre(nombreCompleto);
                            }
                            x = false;
                            nuevaVisita.nombreCompleto = nombreCompleto;
                        } catch (ErrorValidacion e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    x = true;

                    /**Verifica que el numero de telefono este dentro de los establecido**/
                    while (x) {
                        /**Pide su numero de telefono**/
                                System.out.println("Ingrese el numero de telefono del cliente: ");
                                String telefono = lector.nextLine();
                                System.out.println();
                                try {
                                    if (!telefono.isBlank()) {
                                        nuevaVisita.setTelefono(telefono);
                                    }
                                    nuevaVisita.telefono = telefono;

                                    /**Verifica por si el numero de telefono pertenece ya a algun turista**/
                                    for (Visitas c : visitas) {
                                        if (telefono.equals(c.telefono)) {
                                            System.out.println("Bienvenido de vuelta\n\n");
                                            c.contador += 1;
                                            x = false;
                                            break;
                                        }
                                    }

                                    /**Si el numero de telefono no esta en la lista lo agregara**/
                                    if (!x) {
                                        break;
                                    } else {
                                        nuevaVisita.contador = 1;
                                        visitas.add(nuevaVisita);
                                        x = false;
                                        System.out.println("Esperamos cumplir sus expectativas\n\n");
                                    }

                                } catch (ErrorValidacion e) {
                                    System.err.println(e.getMessage());
                                }

                            }

                    break;

                case 2:
                    /**Muesta la lista de clientes registrados**/
                    System.out.println("<><><>Lista de clientes<><><>");
                    for (Visitas c : visitas) {
                        System.out.println("Nombre: " + c.nombreCompleto);
                        System.out.println("Telefono: " + c.telefono);
                        System.out.println("Viajes realizados: " + c.contador);
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("Adios");
                    z = false;
                    break;
                default:

                    break;


            }


        }
    }
}
