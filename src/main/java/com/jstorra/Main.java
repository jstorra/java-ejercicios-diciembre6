package com.jstorra;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        try {
            do {
                System.out.println("""
                        \nEscogé el ejercicio a ejecutar:
                        1. Sistema bancario
                        2. Suma de primos segun numero
                        3. Numero perfecto
                        4. Salir
                        """);
                System.out.print("Opcion: ");
                opcion = scanner.nextInt();
                if (opcion == 1) {
                    ejercicio1();
                } else if (opcion == 2) {
                    ejercicio2();
                } else if (opcion == 3) {
                    ejercicio3();
                } else if (opcion == 4) {
                    System.out.println("\nSaliendo...");
                } else {
                    System.out.println("\nERROR: La opción no es válida.");
                }
            } while (opcion != 4);
        } catch (Exception e) {
            System.out.println("\nERROR: El caracter ingresado no es válido.");
        }
    }

    public static void ejercicio1() {
        // 1. Escribe un programa en Java que simule un sistema bancario simple. El programa debe permitir al usuario realizar depósitos, realizar retiros
        // (basado en el saldo. Si el retiro es posible debe indicar cuales billetes entrega el cajero teniendo en cuenta que solo se dan billetes de 50.000, 20.000, 10.000)
        // y consultar su saldo.

        // Nota: el cajero debe priorizar siempre entregar la máxima cantidad de billetes de mayor nominación que sea posible.
        // Se debe tener en cuenta cantidad de billetes disponibles en el cajero y priorizar la entrega dependiendo de la disponibilidad.

        Scanner scanner = new Scanner(System.in);

        int opcion;
        double saldo = 0;
        int[] billetes = {50000, 20000, 10000}, cantidad = {5, 10, 2};

        try {
            do {
                System.out.println("""
                    \nIngresa el numero segun la acción a realizar:
                    1. Consultar saldo
                    2. Deposito
                    3. Retiro
                    4. Volver al menu
                        """);
                System.out.print("Opcion: ");
                opcion = scanner.nextInt();
                if (opcion == 1) {
                    System.out.println("\n--------------- DETALLES ---------------");
                    System.out.println("Saldo actual: " + saldo);
                    System.out.println("----------------------------------------");
                } else if (opcion == 2) {
                    System.out.println("Saldo actual: $" + saldo);
                    System.out.print("Ingrese el monto a depositar: $");
                    saldo += scanner.nextDouble();
                    System.out.println("\n--------------- DETALLES ---------------");
                    System.out.println("Nuevo saldo: " + saldo);
                    System.out.println("----------------------------------------");
                } else if (opcion == 3) {
                    System.out.println("Saldo disponible: $" + saldo);
                    System.out.print("Ingrese la cantidad a retirar: $");
                    double cantidadRetiro = scanner.nextDouble();
                    if (cantidadRetiro > saldo) {
                        System.out.println("\nMENSAJE: El retiro excede el saldo disponible.");
                    } else {
                        int count50 = 0, count20 = 0, count10 = 0, suma = 0;
                        double copiaCantidadRetiro = cantidadRetiro;
                        if (cantidadRetiro < billetes[2]) {
                            System.out.println("\nMENSAJE: No se puede retirar la cantidad solicitada.");
                        } else {
                            for (int billete : billetes) {
                                while (cantidadRetiro >= billete) {
                                    if (billete == 50000 && cantidad[0] == 0 || billete == 20000 && cantidad[1] == 0 || billete == 10000 && cantidad[2] == 0) {
                                        break;
                                    }
                                    if (billete == 50000 && cantidad[0] > 0) {
                                        cantidad[0] -= 1;
                                        count50++;
                                    } else if (billete == 20000 && cantidad[1] > 0) {
                                        cantidad[1] -= 1;
                                        count20++;
                                    } else if (billete == 10000 && cantidad[2] > 0) {
                                        cantidad[2] -= 1;
                                        count10++;
                                    } else {
                                        break;
                                    }
                                    cantidadRetiro -= billete;
                                    suma += billete;
                                    saldo -= suma;
                                }
                            }
                            System.out.println("\n--------------- DETALLES ---------------");
                            System.out.println("Cantidad billetes $50.000: " + count50);
                            System.out.println("Cantidad billetes $20.000: " + count20);
                            System.out.println("Cantidad billetes $10.000: " + count10);

                            System.out.println("\nRestantes billetes $50.000: " + cantidad[0]);
                            System.out.println("Restantes billetes $20.000: " + cantidad[1]);
                            System.out.println("Restantes billetes $10.000: " + cantidad[2]);

                            System.out.println("\nCantidad retirada: $" + suma);
                            System.out.println("Saldo restante: $" + saldo);
                            System.out.println("----------------------------------------");
                        }
                    }
                } else if (opcion == 4) {
                    System.out.println("\nVolviendo...");
                } else {
                    System.out.println("\nERROR: La opción no es válida.");
                }
            } while (opcion != 4);
        } catch (Exception e) {
            System.out.println("\nERROR: El caracter ingresado no es válido.");
        }
    }

    public static void ejercicio2() {
        // 2. Escribe un programa en Java que solicite al usuario ingresar un número entero positivo. El programa debe calcular la suma
        // de los dígitos primos en ese número. Por ejemplo, si el número es 12345, la suma sería 2 + 3 + 5 = 10, ya que 2, 3 y 5 son dígitos primos.

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("\nIngresa un numero entero: ");
            int numero = scanner.nextInt();
            char[] numeroString = String.valueOf(numero).toCharArray();
            int suma = 0;
            boolean primerPrimo = true;
            String primos = "";

            for (char n : numeroString) {
                boolean esPrimo = true;
                int num = (int) n - '0';
                for (int i = 2; i < num; i++) {
                    if (num % i == 0) {
                        esPrimo = false;
                        break;
                    }
                }
                if (esPrimo && num != 1 && primerPrimo){
                    primos += num;
                    suma += num;
                    primerPrimo = false;
                } else if (esPrimo && num != 1) {
                    primos += ", " + num;
                    suma += num;
                }
            }
            System.out.println("Primos: " + primos + " | Suma: " + suma);
        } catch (Exception e) {
            System.out.println("\nERROR: El caracter ingresado no es válido.");
        }
    }

    public static void ejercicio3() {
        // 3. Ejercicio de números perfectos. Un número perfecto es aquel cuya suma de sus divisores propios (excluyendo él mismo) es igual al propio número.
        // Por ejemplo, 28 es un número perfecto ya que sus divisores propios (1, 2, 4, 7, 14) suman 28.
        // Escribe un programa en Java que solicite al usuario ingresar un número y determine si es un número perfecto o no.

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("\nIngresa un numero entero: ");
            int numero = scanner.nextInt();
            int suma = 0;
            boolean primerDivisor = true;
            String divisores = "";

            for (int i = 1; i < numero; i++) {
                if (numero % i == 0) {
                    if (primerDivisor) {
                        divisores += i;
                        primerDivisor = false;
                    } else {
                        divisores += ", " + i;
                    }
                    suma += i;
                }
            }
            System.out.printf("%nDivisores: %s | Suma: %s%nResultado: %s%n",divisores, suma, (numero == suma) ? "Es un numero perfecto." : "No es un numero perfecto.");
        } catch (Exception e) {
            System.out.println("\nERROR: El caracter ingresado no es válido.");
        }
    }
}