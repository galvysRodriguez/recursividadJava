/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrecursividad;

import java.util.Scanner;

/**
 *
 * @author Agustín
 */
public class EjerciciosRecursividad {
    static Scanner scan = new Scanner(System.in);
    
    
    public static int ingresarNumero(String cadena, String error){
        boolean validacion = true;
        int numero = 0;
                while(validacion){
                    try{
                        System.out.print(cadena);
                        String valor = scan.next();
                        numero = Integer.parseInt(valor);
                        validacion = false;
                    }
                    catch(Exception e){
                        System.out.println("ERROR:" + error +"\n ");
                    }
                    
                }
        return numero;
    }
    
    public static int ingresarBase(){
        int base =0;
        System.out.println("\nEscoja con la base que desea calcular :");
        System.out.println("1. Base hexadecimal");
        System.out.println("2. Base menor que 10 \n");
        
        String seleccion = scan.next();
        seleccion = seleccion.trim();
        
        switch(seleccion){
        case "1":
                base = 16;
                break;
         case "2":
                boolean banderas = true;
                while(banderas){
                    try{
                        System.out.println("\nIngrese una base menor que 10: \n ");
                        String x = scan.next();
                        int valor = Integer.parseInt(x);
                        if(valor <10 && valor>1){
                            base = valor;
                            banderas = false;
                        }
                        else{
                            System.out.println("\nERROR:La base debe ser mayor que 1 y menor que 10 \n ");
                        }
                    }
                    catch(Exception e){
                        System.out.println("\nERROR:Debe ingresar un numero entero \n ");
                    }
                }
                break;
        }
        return base;
    }
    
    public static void convertirANumHexadecimal(int num,int base, String hexadecimal){
        int resto = num % base;
        String aux =null;
        
        if (resto>=0 && resto<=9){
            aux=String.valueOf(resto);
        }else{
            switch(resto){
                case 10:
                    aux="A";
                    break;
                case 11:
                    aux="B";
                    break;
                case 12:
                    aux="C";
                    break;
                case 13:
                    aux="D";
                    break;
                case 14:
                    aux="E";
                    break;
                case 15:
                    aux="F";
                    break;
                }
            }
        hexadecimal= aux+hexadecimal;
            
        if (num > base){
            convertirANumHexadecimal(num/base,base,hexadecimal);
        }else{
            System.out.println("\nEl numero en base " + base + " es " + hexadecimal);
        }
    }
    
    public static void imprimirTablaMultiplicar(int x,int y){
        if (y <= 12){
            
            System.out.println(x + " x " + y + " = " + (x*y));
            imprimirTablaMultiplicar(x,y+1);
        }
    }

    public static void sumaNumeros(int sumPositivos,int sumNegativos, int numPares, int numImpares){
        int x = ingresarNumero("\nIngresar su numero:","Debe ser un numero valido\n");
        
        if (x!=0){
            if (x>0){
                sumPositivos = sumPositivos + x;
            }else if (x<0){
                sumNegativos = sumNegativos + x;
            }

            if (x % 2 == 0){
                numPares++;
            }else{
                numImpares++;
            }
            
            sumaNumeros(sumPositivos,sumNegativos,numPares,numImpares);
        }else{
            System.out.println("\nLos valores obtenidos fueron:");
            System.out.println("La suma de los positivos es: " + sumPositivos);
            System.out.println("La suma de los negativos es: " + sumNegativos);
            System.out.println("La cantidad de numeros pares fue " + numPares);
            System.out.println("La cantidad de numeros impares fue " + numImpares);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        boolean salidaMenu=false;
        System.out.println("Escoja el ejercicio a acceder:");
        System.out.println("1. Ejercicio (1) Conversor a hexadecimal");
        System.out.println("2. Ejercicio (5) Tablas de multiplicar");
        System.out.println("3. Ejercicio (10) Suma de negativos y positivos, numeros pares e impares");
        System.out.println("4. Salir del programa\n");

        String eleccion = scan.next();
        eleccion = eleccion.trim();
        while(salidaMenu==false){
            switch(eleccion){
            case "1":
                int base = ingresarBase();
                int numBase = ingresarNumero("\nIngrese el numero que desea convertir : ","Debe ingresar un numero entero \n ");

                convertirANumHexadecimal(numBase,base,"");
                break;

            case "2":
                int num = ingresarNumero("\nIngrese la tabla que desea mostrar: \nTabla del ", "Debe ingresar un numero entero \n ");
                imprimirTablaMultiplicar(num,1);
                break;

            case "3":
                sumaNumeros(0,0,0,0);
                break;
            
            case "4":
                salidaMenu=true;
                break;
                
            default:
                System.out.println("ERROR:Debe ingresar una de las opciones \n ");
                break;
            }
        }
    }
}
