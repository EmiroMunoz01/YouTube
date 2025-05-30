package com.inventario.operadores;

import java.util.Scanner;

//Pedir dos números y mostrarlos ordenados de mayor a menor.
public class j8numero {


    public static void main(String[] args) {


        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el numero A");
        double numeroA = entrada.nextDouble();

        System.out.println("Ingrese el numero B");
        double numeroB = entrada.nextDouble();


        if (numeroB < numeroA) {
            System.out.println(numeroA);
            System.out.println(numeroB);
        } else {
            System.out.println(numeroB);
            System.out.println(numeroA);
        }
    }
}
