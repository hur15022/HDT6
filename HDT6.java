package hdt6;

import java.util.Scanner;
import java.util.Set;

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
                operaciones(ap);
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
    
    public static void operaciones(Set ap){
        System.out.println("\nDesarrolladores con experiencia Java, web y celulares: ");
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
    }
    
}
