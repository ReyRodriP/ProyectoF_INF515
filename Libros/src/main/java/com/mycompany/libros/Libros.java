/*
 * Autor: 100655341 Reynaldo Rodriguez Polanco
 * Descripción:
 * Esta clase representa la clase principal de la aplicación "Libros".
 * Proporciona un menú interactivo para que el usuario elija la tabla de la base de datos que desea manipular.
 * Utiliza la clase SalesControlador para realizar operaciones en la base de datos.
 * La conexión a la base de datos se gestiona mediante la clase CConexion.
 */

package com.mycompany.libros;

import Controladores.SalesControlador;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Libros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SalesControlador Salesc = new SalesControlador();
        int option = Integer.MAX_VALUE;
        
        CConexion conexion = new CConexion();
        System.out.println("========================================");
        while (option != 0) {
            System.out.println("Elige la tabla que desean manipular: "
                    + "\n 0-Salir"
                    + "\n 1-Store"
                    + "\n 2-Sales"
                    + "\n 3-Sales log"
                    + "\n 4-Title"
                    + "\n 5-Title Author"
                    + "\n 6-Authors"
                    + "\n 7-Employee"
                    + "\n 8-Jobs"
                    + "\n 9-discounts"
                    + "\n 10-Noticias"
                    + "\n 11-Pub info"
                    + "\n 12-Pub menu"
                    + "\n 13-Publishers"
                    + "\n 14-Roysched"
                    + "\n 15-SysUser"
                    + "\n 16-Usuario"
            );
        do {
                try {
                    option = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Digite un numero valido");
                    sc.nextLine();
                }
            } while (option == Integer.MAX_VALUE);
        switch (option) {
                case 0:
                System.out.println("----------------------------------------");
                System.out.println("-----------------SALIENDO---------------");
                System.out.println("----------------------------------------");
                break;
                
                case 1:
                Salesc.Proceso2();
                break;
                
                case 2:
                Salesc.Proceso1();
                break;
                
                case 3:
                Salesc.Proceso6();
                break;
                
                case 4:
                Salesc.Proceso5();
                break;
                
                case 6:
                Salesc.Proceso3();
                break;
                
                case 13:
                Salesc.Proceso4();
                break;
                
        }
    }
}
}
