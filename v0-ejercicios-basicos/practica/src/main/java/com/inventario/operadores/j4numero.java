package com.inventario.operadores;
//Pedir un número e indicar si es positivo o negativo

import java.util.Scanner;

public class j4numero {


    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);



        System.out.println("Ingrese el numero");

        double numero1 = entrada.nextDouble();



        if(numero1 < 0 ){
            System.out.println("El numero es negativo");
        }else {
            System.out.println("El numero es positivo");
        }


    }


}


