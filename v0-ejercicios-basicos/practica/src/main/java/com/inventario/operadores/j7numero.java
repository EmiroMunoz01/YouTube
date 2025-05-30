package com.inventario.operadores;

import java.util.Scanner;

//Pedir dos números y decir cual es el mayor o si son iguales.
public class j7numero {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Numero A");
        double numeroA = entrada.nextDouble();

        System.out.println("Numero B");
        double numeroB = entrada.nextDouble();

        if (numeroA < numeroB) {
            System.out.println(numeroB + " es mayor a " + numeroA);
        } else if (numeroA == numeroB) {
            System.out.println("Los numeros son iguales");
        } else {
            System.out.println(numeroA + " es mayor a " + numeroB);
        }

    }
}

