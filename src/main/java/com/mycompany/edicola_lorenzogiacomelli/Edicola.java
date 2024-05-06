/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edicola_lorenzogiacomelli;

import eccezioni.EccezioneValoreNonEsistente;
import eccezioni.EccezioniPosizioneNonValida;
import eccezioni.FileException;
import file.TextFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;

/**
 *
 * @author User
 */
public class Edicola implements Serializable
{
    private Giornale [] elencoGiornale;
    private static int NUM_MAX_GIORNALE=1000;
    private int nGiornalePresenti=0;
    
    public Edicola() 
    {
        elencoGiornale =new Giornale[NUM_MAX_GIORNALE];
    }
    
    public Edicola(Edicola e) //costruttore di copia
    {
        elencoGiornale=new Giornale[NUM_MAX_GIORNALE];       
              
        for(int i=0;i<getNUM_MAX_GIORNALE();i++)
        {
            elencoGiornale[i]=e.getGiornale(i);
        }
    }

    public Giornale[] getElencoGiornale() {
        return elencoGiornale;
    }

    public void setElencoGiornale(Giornale[] elencoGiornale) {
        this.elencoGiornale = elencoGiornale;
    }

    public int getnGiornalePresenti() {
        return nGiornalePresenti;
    }

    public Giornale getGiornale(int posizione)
    {
        return elencoGiornale[posizione];
    }
    
     public int getNUM_MAX_GIORNALE() 
    {
        return NUM_MAX_GIORNALE;
    }
     
    public static void setNUM_MAX_GIORNALE(int NUM_MAX_GIORNALE) 
    {
        Edicola.NUM_MAX_GIORNALE = NUM_MAX_GIORNALE;
    }
    
    public int getId(int posizione)
    {
         return elencoGiornale[posizione].getIdGiornale();  
    }
    
    
    public int getNumGiornale()
    {
        int contatore=0;
   
        for(int i=0;i<NUM_MAX_GIORNALE;i++)
        {
            if(elencoGiornale[i]!=null)
                contatore++;
        }
        return contatore;
    }
    
    
    public int aggiungiGiornale(Giornale g) throws InputMismatchException
    {
            elencoGiornale[nGiornalePresenti]=new Giornale(g);
            nGiornalePresenti++;
            return 0;
            
    }
    
    
    public Giornale getGiornalePosizione(int posizione)
    {
        return elencoGiornale[posizione];
    }
    
    public Giornale[] GiornaleNome(String nome) throws ArrayIndexOutOfBoundsException,InputMismatchException,EccezioneValoreNonEsistente
    {
        Giornale[] GiornaleNome=new Giornale[getNumGiornale()];
        Giornale giornale;
        int x=0;
        
        int c=0;
        
        for(int i=0;i<getNumGiornale();i++)
        {
            if(elencoGiornale[i].getNome().compareToIgnoreCase(nome)==0)
            {
                giornale=elencoGiornale[i];
                GiornaleNome[x]=giornale;
                x++;
            }
            else if(elencoGiornale[i].getNome().compareToIgnoreCase(nome)!=0)
            {
                c++;
            }
            
        }
        if(c==nGiornalePresenti)
            throw new EccezioneValoreNonEsistente(); 
        
        return GiornaleNome; 
        
    }
    
    public Giornale[] GiornaleGiorno(LocalDate data) throws DateTimeException, InputMismatchException,EccezioneValoreNonEsistente
    {
        Giornale[] GiornaleGiorno=new Giornale[getNumGiornale()];
        Giornale giornale;
        int x=0;
        int c=0;
        
        for(int i=0;i<getNumGiornale();i++)
        {
            if(elencoGiornale[i].getData().isEqual(data)==true)
            {
                giornale=elencoGiornale[i];
                GiornaleGiorno[x]=giornale;
                x++;
            }
            else if(elencoGiornale[i].getData().isEqual(data)==false)
            {
                c++; 
            }
        }
        if(c==nGiornalePresenti)
            throw new EccezioneValoreNonEsistente(); 
        return GiornaleGiorno;
          
    }
    
    
    public int eliminaGiornaleId(int id) throws InputMismatchException,EccezioneValoreNonEsistente
    {
        int c=0;
        
        for(int i=0;i<nGiornalePresenti;i++)
            {
                if (elencoGiornale[i]!=null)
                {
                    if(elencoGiornale[i].getIdGiornale()==id)
                    {
                        aggiornaPosizioneGiornale(i);
                        return 0; 
                    }
                    else if(elencoGiornale[i].getIdGiornale()!=id)
                    {
                        c++;
                    }
                }
            }
        if(c==nGiornalePresenti)
            throw new EccezioneValoreNonEsistente(); 
        return -1;
        
    }
    
    private void aggiornaPosizioneGiornale(int posizione)
    {
        for (int i=posizione;i<nGiornalePresenti-1;i++)  
        {
            elencoGiornale[i]=elencoGiornale[i+1];
        }
        elencoGiornale[nGiornalePresenti-1]=null;      //se ne elimini uno, sicuramente l'ultimo deve contenere null ( lo faccio per togliere dall'array IL giornale eliminato)
        nGiornalePresenti--;
    }
    
    public Giornale[] ordinaNomiGiornaliDecrescente(String nome) throws NullPointerException,ArrayIndexOutOfBoundsException,EccezioneValoreNonEsistente
    {
        Giornale[] nomiGiornaliDecrescenti=new Giornale[getnGiornalePresenti()];
        Giornale giornale;
        int x=0;
        int c=0;
        
        for(int i=0;i<nGiornalePresenti;i++)
        {
            if(elencoGiornale[i].getNome().compareToIgnoreCase(nome)==0)
            {
                giornale=elencoGiornale[i];
                nomiGiornaliDecrescenti[x]=giornale;
                x++;
            }
            else if(elencoGiornale[i].getNome().compareToIgnoreCase(nome)!=0)
            {
                c++;
            }
        }
        if(c==nGiornalePresenti)
            throw new EccezioneValoreNonEsistente();
        
        nomiGiornaliDecrescenti=Ordinatore.selectionSortOrdinaNomiGiornaliDecrescente(nomiGiornaliDecrescenti);
        return nomiGiornaliDecrescenti;
    }
         
    public void salvaGiornale(String nomeFile) throws IOException,EccezioniPosizioneNonValida, FileException
    {
        TextFile f1=new TextFile(nomeFile,'W');
        Giornale giornale;
        for(int i=0;i<nGiornalePresenti;i++)
            {
               giornale=getGiornalePosizione(i);
                if(giornale!=null)
                {
                    f1.toFile(giornale.getNome()+";"+giornale.getData()+";"+giornale.getNumeroPagine()+";"+giornale.getTipologia()+";"+giornale.getAutore()+";"+giornale.getIdGiornale());
                }
            }
        f1.close();
    }
    
    public void salvaGiornaleBinario(String nomeFile) throws IOException,EccezioniPosizioneNonValida, FileException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
}
