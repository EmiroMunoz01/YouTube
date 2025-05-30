package com.inventario.operadores;
//Pedir dos números y decir cual es el mayor.

import java.util.Scanner;

public class j6numero {


    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);


        System.out.println("Ingrese el primer numero");
        double numero1 = entrada.nextDouble();

        System.out.println("Ingrese el segundo numero");
        double numero2 = entrada.nextDouble();


        if (numero1 > numero2 ) {
            System.out.println("El numero mayor es el "+ numero1);
        } else {
            System.out.println("El numero mayor es el "+ numero2);
        }


    }


}


