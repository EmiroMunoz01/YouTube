package com.inventario.operadores;
//Pedir el radio de un círculo y calcular su área. A=PI*r^2.

import java.util.Scanner;

public class j1circulo {


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double pi = 3.14;

        System.out.println("Ingrese el valor del radio del circulo");


        double radio = entrada.nextDouble();


        double area = pi * (radio * radio);


        System.out.println("El area del circulo es de: " + area);
    }


}


