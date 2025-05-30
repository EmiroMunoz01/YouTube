package com.inventario.operadores;

import java.util.Scanner;

//escriba un numero entre 1 y 99999 e indicar cuantas cifras tiene
public class j10numero {



    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero: ");

        int numero = entrada.nextInt();

        if(numero < 10){
            System.out.println("El numero "+ numero + " es de 1 cifra.");

        } else if (numero < 100) {
            System.out.println("El numero "+ numero + " es de 2 cifra.");
        }
        else if (numero < 1000) {
            System.out.println("El numero "+ numero + " es de 3 cifra.");
        }
        else if (numero < 10000) {
            System.out.println("El numero "+ numero + " es de 4 cifra.");
        }else if (numero < 100000) {
            System.out.println("El numero "+ numero + " es de 5 cifra.");
        }

        else {
            System.out.println("El numero "+ numero + " no esta soportado, es de mas de 5 cifras Xd");
        }

    }
}
