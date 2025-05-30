package com.inventario.operadores;
//Pedir el radio de una circunferencia y calcular su longitud.

import java.util.Scanner;

public class j2circulo {


    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double pi = 3.14;

        System.out.println("Ingrese el valor del radio del circulo");

        double radio = entrada.nextDouble();

        double perimetro = 2 * pi * radio;

        System.out.println("El perimetro del circulo es de: " + perimetro);

    }


}


