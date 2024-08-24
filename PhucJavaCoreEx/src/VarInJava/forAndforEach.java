/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VarInJava;

/**
 *
 * @author NguyenPhuc
 */
public class forAndforEach {
    public static void main(String[] args) {
        char[] $bangchucai = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        
        //for
        for(int i = 0; i<$bangchucai.length; i++){
            System.out.println("Phan tu thu [" + i + "] = "+ $bangchucai[i]);
        }
        
        //for:each
        for(int j: $bangchucai){
            System.out.println("Phan tu thu [" + j + "] = "+ $bangchucai[j]);
        }
    }
}
