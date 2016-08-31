/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt6;

/**
 *
 * @author Diego H
 */
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Factory<E> {
    
    public Set<E> Factory(int i){
        switch(i){
            case 1:
                return new HashSet();
            case 2:
                return new TreeSet();
            case 3: 
                return new LinkedHashSet();
            default:
                System.out.println("Elijio una opcion incorrecta");
                return null;
        }
                
    }
    
}
