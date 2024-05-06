/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edicola_lorenzogiacomelli;

/**
 *
 * @author User
 */
public class Ordinatore 
{
    public static void scambia(Giornale g[],int posizione1,int posizione2)
    {
        Giornale c;
        c=g[posizione1];
        g[posizione1]=g[posizione2];
        g[posizione2]=c;
    }

    public static Giornale[] selectionSortOrdinaNomiGiornaliDecrescente(Giornale[] g)
    {
        int c=0;
        for(int i=0;i<g.length;i++)
        {
            if(g[i]!=null)
                c++;
        }
        
        
        Giornale[] ordinato=new Giornale[c];

        
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=g[i];
        
        
        for (int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].getData().isAfter(ordinato[i].getData()))
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
}
