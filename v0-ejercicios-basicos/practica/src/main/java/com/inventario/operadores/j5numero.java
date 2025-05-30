package com.inventario.operadores;
//Pedir dos números y decir si uno es múltiplo del otro

import java.util.Scanner;

public class j5numero {


    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);


        System.out.println("Ingrese el primer numero");
        double numero1 = entrada.nextDouble();

        System.out.println("Ingrese el segundo numero");
        double numero2 = entrada.nextDouble();


        if (numero1 % numero2 == 0) {
            System.out.println("Los numeros SI son divisibles entre si");
        } else {
            System.out.println("Los numeros NO son divisibles entre si");
        }


    }


}


