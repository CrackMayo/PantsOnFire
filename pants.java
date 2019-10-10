/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.maratons.maratones;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class pants {
    public static void main(String[]args){
        Map<String,String> nyt;
        nyt = new HashMap<String,String>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<n;i++){
            String[] value = scan.nextLine().split(" are worse than ");
            nyt.put(value[0],value[1]);
        }
        for(int i=0; i<m; i++){
            String[] trump = scan.nextLine().split(" are worse than ");
            if(nyt.containsKey(trump[0])){
                String value = nyt.get(trump[0]);
                if(value.equals(trump[1])){
                    System.out.println("Fact");
                }else{
                    boolean ok = false;
                    String previo = value;
                    while(!ok){
                        if(!nyt.containsKey(value)){
                            System.out.println("Pants on Fire");
                            ok = true;
                        }
                        else{
                            String valor = nyt.get(value);
                            if(valor.equals(trump[1])){
                                System.out.println("Fact");
                                ok = true;
                            }else
                                previo = nyt.get(value);  
                        }
                    }
                }                
            }else if(nyt.containsKey(trump[1]) && nyt.get(trump[1]).equals(trump[0])){
                    System.out.println("Alternative Fact");
                
            }else{
                System.out.println("Pants on Fire");
            }
        }
    }
}
