package com.inventario.operadores;

import java.util.Scanner;

//Pedir tres números y mostrarlos ordenados de mayor a menor.
public class j9numero {


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Numero A");
        double numeroA = entrada.nextDouble();

        System.out.println("Numero B");
        double numeroB = entrada.nextDouble();

        System.out.println("Numero C");
        double numeroC = entrada.nextDouble();

        if (numeroA < numeroB) {
            if (numeroB < numeroC) {
                System.out.println("El numero mayor es " + numeroC);
                System.out.println("El orden de los numeros es: " + numeroC + " - " + numeroB + " - " + numeroA);
            } else {
                System.out.println("El numero mayor es " + numeroB);
                if (numeroC < numeroA){
                    System.out.println("El orden de los numeros es: " + numeroB + " - " + numeroA + " - " + numeroC);
                }else {
                    System.out.println("El orden de los numeros es: " + numeroB + " - " + numeroC + " - " + numeroA);
                }
            }
        } else if (numeroA < numeroC) {
            System.out.println("El numero mayor es " + numeroC);
            System.out.println("El orden de los numeros es: " + numeroC + " - " + numeroA + " - " + numeroB);
        } else {
            System.out.println("El numero mayor es " + numeroA);
            if (numeroB < numeroC){
                System.out.println("El orden de los numeros es: " + numeroA + " - " + numeroC + " - " + numeroB);
            }else {
                System.out.println("El orden de los numeros es: " + numeroA + " - " + numeroB + " - " + numeroC);
            }
        }


    }
}
