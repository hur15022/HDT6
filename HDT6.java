package hdt6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Jose
 */
public class HDT6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("¡Bievenido!");
        
        int s = menu();
        
        Factory fak = new Factory();
        
        Set ap = fak.set(s);
        
        while(ap == null){
            s = menu();
            
            ap = fak.set(s);
        }
        
        System.out.println("Menu:\n1) Ingresar Persona \n2) Operaciones \n3) Salir");
        int ingMenu = teclado.nextInt();
        
        while (ingMenu != 3){
            if (ingMenu == 1){
                Persona per = ingresarPersona();
        
                ap.add(per);
            } else if (ingMenu == 2){
                String[][] array=operaciones(ap);
                String[] java=array[0];
                String[] web=array[1];
                Set lista1;
                Set lista2;
               if (s==1){
                   lista1=new HashSet(Arrays.asList(java));
                   lista2=new HashSet(Arrays.asList(web));
               }else if(s==2){
                   lista1=new TreeSet(Arrays.asList(java));
                   lista2=new TreeSet(Arrays.asList(web));
               }else{
                   lista1=new LinkedHashSet(Arrays.asList(java));
                   lista2=new LinkedHashSet(Arrays.asList(web));
               }
               
               if (lista2.containsAll(lista1)){
                   System.out.println("El conjunto java esta contenido en el conjunto web");
               }else{
                  System.out.println("El conjunto java no esta contenido en el conjunto web"); 
               }
               
               
                
            } else {
                System.out.println("Menu:\n1) Ingresar Persona \n2) Operaciones \n3) Salir");
                ingMenu = teclado.nextInt();
            }
            
            System.out.println("Menu:\n1) Ingresar Persona \n2) Operaciones \n3) Salir");
            ingMenu = teclado.nextInt();
        }
        
    }
    
    //MENU
    public static int menu(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Elija el conjunto que desea usar:\n1) HashSet \n2) TreeSet \n3) LinkedSet");
        
        int seleccion = teclado.nextInt();
        
        return seleccion;
    }
    
    
    
    public static Persona ingresarPersona(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre de la persona: ");
        String nombre = teclado.nextLine();
        
        System.out.println("¿Puede programar Java? (1 = Si, 0 = No)");
        int j = teclado.nextInt();
        boolean desarrollaJava;
        if (j == 1){
            desarrollaJava = true;
        } else {
            desarrollaJava = false;
        }
        
        System.out.println("¿Puede programar Web? (1 = Si, 0 = No)");
        int k = teclado.nextInt();
        boolean desarrollaWeb;
        if (k == 1){
            desarrollaWeb = true;
        } else {
            desarrollaWeb = false;
        }
        
        System.out.println("¿Puede programar Celulares? (1 = Si, 0 = No)");
        int l = teclado.nextInt();
        boolean desarrollaCelular;
        if (l == 1){
            desarrollaCelular = true;
        } else {
            desarrollaCelular = false;
        }
        
        Persona per = new Persona(nombre, desarrollaJava, desarrollaWeb, desarrollaCelular);
        
        return per;
    }
    
    public static String[][] operaciones(Set ap){
        String[] java=new String[100];
        String[] web=new String[100];
        String[] celular=new String[100];
        System.out.println("\nDesarrolladores con experiencia Java, web y celulares: ");
        int i=0;
        int j=0;
        int k=0;
        for (Object p : ap.toArray()){
            Persona pe = (Persona) p;
            if (pe.isDesarrollaJava() == true && pe.isDesarrollaWeb() == true && pe.isDesarrollaCelular() == true){
                System.out.println("   - " + pe.getNombre());
            }
        }
        
        System.out.println("\nDesarrolladores con experiencia Java, pero sin experiencia web y celular: ");
        for (Object p : ap.toArray()){
            Persona pe = (Persona) p;
            if (pe.isDesarrollaJava() == true && pe.isDesarrollaWeb() == false && pe.isDesarrollaCelular() == false){
                System.out.println("   - " + pe.getNombre());
            }
        }
        
        System.out.println("\nDesarrolladores con experiencia Web y celulare, pero sin experiencia Java: ");
        for (Object p : ap.toArray()){
            Persona pe = (Persona) p;
            if (pe.isDesarrollaJava() == false && pe.isDesarrollaWeb() == true && pe.isDesarrollaCelular() == true){
                System.out.println("   - " + pe.getNombre());
            }
            
        }
        
        System.out.println("\nDesarrolladores con experiencia Web o Celular pero sin java: ");
        for (Object p : ap.toArray()){
            Persona pe = (Persona) p;
            if (pe.isDesarrollaJava() == false && (pe.isDesarrollaWeb() == true || pe.isDesarrollaCelular() == true)){
                System.out.println("   - " + pe.getNombre());
            }
        }
        
        for (Object p : ap.toArray()){
            Persona pe = (Persona) p;
            if (pe.isDesarrollaJava() == true && pe.isDesarrollaWeb() == true && pe.isDesarrollaCelular() == true){
                java[i]=pe.getNombre();
                web[j]=pe.getNombre();
                celular[k]=pe.getNombre();
            }
            i++;
            j++;
            k++;
        }
        
        for (Object p : ap.toArray()){
            Persona pe = (Persona) p;
            if (pe.isDesarrollaJava() == false && pe.isDesarrollaWeb() == true && pe.isDesarrollaCelular() == true){
                System.out.println("   - " + pe.getNombre());
                web[j]=pe.getNombre();
                celular[k]=pe.getNombre();
            }
            j++;
            k++;
        }
        
        for (Object p : ap.toArray()){
            Persona pe = (Persona) p;
            if (pe.isDesarrollaJava() == true && pe.isDesarrollaWeb() == false && pe.isDesarrollaCelular() == true){
                System.out.println("   - " + pe.getNombre());
                java[i]=pe.getNombre();
                celular[k]=pe.getNombre();
            }
            i++;
            k++;
        }
        
        for (Object p : ap.toArray()){
            Persona pe = (Persona) p;
            if (pe.isDesarrollaJava() == true && pe.isDesarrollaWeb() == true && pe.isDesarrollaCelular() == false){
                System.out.println("   - " + pe.getNombre());
                java[i]=pe.getNombre();
                web[j]=pe.getNombre();
            }
            i++;
            j++;
        }
        
        for (Object p : ap.toArray()){
            Persona pe = (Persona) p;
            if (pe.isDesarrollaJava() == true && pe.isDesarrollaWeb() == false && pe.isDesarrollaCelular() == false){
                System.out.println("   - " + pe.getNombre());
                java[i]=pe.getNombre();
            }
            i++;
        }
        
        for (Object p : ap.toArray()){
            Persona pe = (Persona) p;
            if (pe.isDesarrollaJava() == false && pe.isDesarrollaWeb() == true && pe.isDesarrollaCelular() == false){
                System.out.println("   - " + pe.getNombre());
                web[j]=pe.getNombre();
            }
            j++;
        }
        
        for (Object p : ap.toArray()){
            Persona pe = (Persona) p;
            if (pe.isDesarrollaJava() == false && pe.isDesarrollaWeb() == false && pe.isDesarrollaCelular() == true){
                System.out.println("   - " + pe.getNombre());
                celular[k]=pe.getNombre();
            }
            k++;
        }
        
        String[][] arreglo=new String[100][100];
        arreglo[0]=java;
        arreglo[1]=web;
        arreglo[2]=celular;
        
       return arreglo;
    }
    
}
    

