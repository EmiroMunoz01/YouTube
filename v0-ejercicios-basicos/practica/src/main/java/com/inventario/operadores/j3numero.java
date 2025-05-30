package com.inventario.operadores;
//Pedir dos números y decir si son iguales o no

import java.util.Scanner;

public class j3numero {


    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);



        System.out.println("Ingrese el primer numero");

        double numero1 = entrada.nextDouble();

        System.out.println("Ingrese el segundo numero");

        double numero2 = entrada.nextDouble();

        if(numero1 == numero2){
            System.out.println("Los numeros son iguales");
        }else {
            System.out.println("Los numeros no son iguales");
        }


    }


}


