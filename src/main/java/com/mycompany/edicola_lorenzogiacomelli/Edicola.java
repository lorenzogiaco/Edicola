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
 *la classe rappresenta un edicola
 * La classe contiene tutti i metodi per effettuare operazioni sugli oggetti 
 * di classe Giornale, essi sono contenuti in un array
 * elencoGiornali: è un array di oggetti di classe Giornale 
 * NUM_MAX_GIORNALE: attributo statico,è una costante, rappresenta il numero massimo dei giornali che è 1000
 * nGiornalePresenti: è un contatore che conta il numero di giornali presenti nell'array
 * @author User
 */
public class Edicola implements Serializable
{
    private Giornale [] elencoGiornale;
    private static int NUM_MAX_GIORNALE=1000;
    private int nGiornalePresenti=0;

    /**
     * Costruttore della classe Giornale
     * Consente di istanziare un nuovo giornale
     * Costituito da NUM_MAX_GIORNALE giornali vuoti
     */
    public Edicola() 
    {
        elencoGiornale =new Giornale[NUM_MAX_GIORNALE];
    }
    
    /**
     * Costruttore di copia. Consente di istanziare una nuova Edicola,
     * copiando un altro oggetto di classe Edicola
     * copia dell' Edicola passata come parametro
     * @param e oggetto di classe Edicola da cui effettuare la copia
     */    
    public Edicola(Edicola e) //costruttore di copia
    {
        elencoGiornale=new Giornale[NUM_MAX_GIORNALE];       
              
        for(int i=0;i<getNUM_MAX_GIORNALE();i++)
        {
            elencoGiornale[i]=e.getGiornale(i);
        }
    }
    
    /**
    * Restituisce l'elenco dei giornali.
    * @return Un array contenente l'elenco dei giornali.
    */
    public Giornale[] getElencoGiornale() {
        return elencoGiornale;
    }

    /**
    * Imposta l'elenco dei giornali con quello specificato.
    * @param elencoGiornale Il nuovo array di giornali da impostare.
    */
    public void setElencoGiornale(Giornale[] elencoGiornale) {
        this.elencoGiornale = elencoGiornale;
    }
    
    /**
     * Metodo getter della variabile nGiornalePresenti
     * Ci permette di visualizzare il valore della variabile nGiornalePresenti
     * @return valore  nGiornalePresenti
     */
    public int getnGiornalePresenti() {
        return nGiornalePresenti;
    }

    /**
    * Restituisce il giornale nella posizione specificata nell'elenco dei giornali.
    * @param posizione La posizione del giornale nell'elenco.
    * @return Il giornale nella posizione specificata.
    */

    public Giornale getGiornale(int posizione)
    {
        return elencoGiornale[posizione];
    }
    
    /**
     * Metodo getter della costante NUM_MAX_GIORNALE
     * Ci permette di visualizzare il valore della variabile NUM_MAX_GIORNALE
     * @return valore NUM_MAX_GIORNALE
     */
     public int getNUM_MAX_GIORNALE() 
    {
        return NUM_MAX_GIORNALE;
    }
    /**
    * Metodo setter della costante NUM_MAX_GIORNALE
    * Ci permette di assegnare un valore alla variabile NUM_MAX_GIORNALE 
    * @param NUM_MAX_GIORNALE valore della variabile NUM_MAX_GIORNALE
    */     
    public static void setNUM_MAX_GIORNALE(int NUM_MAX_GIORNALE) 
    {
        Edicola.NUM_MAX_GIORNALE = NUM_MAX_GIORNALE;
    }
    
    /**
    * Metodo che restituisce l'ID identificativo dell'oggetto nella posizione specificata.
    * @param posizione La posizione dell'oggetto di cui si desidera ottenere l'ID.
    * @return L'ID identificativo dell'oggetto nella posizione specificata dell'array.
    */
    public int getId(int posizione)
    {
         return elencoGiornale[posizione].getIdGiornale();  
    }
    
    /**
     * Metodo getter del numero dei giornali presenti con valore diverso da null
     * Ci permette di visualizzare il numero di giornali presenti nell'array con contenuto diverso da null
     * @return numero di giornali presenti nell'array con valore diverso da null
     */
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
    
    /**
     * Metodo aggiunge un giornale all'array
     * Ci permette di aggiungere una nuovo giornale all'array di oggetti di classe Giornale
     * @param g oggetto di classe Giornale da aggiungere all'array
     * @return restituisce 0 se l'aggiunta è andata a buon fine
     * @throws InputMismatchException .
     */
    public int aggiungiGiornale(Giornale g) throws InputMismatchException
    {
            elencoGiornale[nGiornalePresenti]=new Giornale(g);
            nGiornalePresenti++;
            return 0;
            
    }
    
    /**
     * Metodo getter dell'array di oggetti di classe Giornale elencoGiornale
     * inserendo la posizione dell'oggetto che vogliamo visualizzare
     * Ci permette di visualizzare il contenuto dell'oggetto in posizione posizione
     * @param posizione è la posizione in cui voglio vedere l'oggetto
     * @return Il contenuto dell'array elencoGiornale in posizione posizione, sarà un oggetto di classe Giornale
     */
    public Giornale getGiornalePosizione(int posizione)
    {
        return elencoGiornale[posizione];
    }
    
    /**
     * Metodo che visulizza tutte i giornali di un nome
     * Ci permette di visualizzare tuute i giornali di un nome
     * @param nome nome di cui cercare i giornali
     * @return un array di classe Gironale contenente tutte i giornali di quel nome
     * @throws ArrayIndexOutOfBoundsException.
     * @throws InputMismatchException.
     * @throws EccezioneValoreNonEsistente .
      */
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
    
    /**
    * Metodo che restituisce un array di giornali effettuati in una data specifica.
    * Questo metodo consente di visualizzare tutti i giornali effettuati in un giorno, mese e anno specifici.
    * @param data La data di cui si vogliono visualizzare i giornali.
    * @return Un array di oggetti di classe Giornale contenente tutti i giornali della data specificata.
    * @throws DateTimeException.
    * @throws InputMismatchException.
    * @throws EccezioneValoreNonEsistente.
    */
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
    
    /**
    * Metodo che elimina un giornale dall'array "elencoGiornale" utilizzando il codice identificativo.
    * Questo metodo consente di eliminare un giornale in base al suo codice identificativo.
    * @param id Il codice identificativo del giornale da eliminare.
    * @return 0 se l'eliminazione è avvenuta con successo, -1 altrimenti.
    * @throws InputMismatchException.
    * @throws EccezioneValoreNonEsistente.
    */
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
    
    /**
     * Metodo che aggiorna la posizione degli oggetti nell'array dopo l'eliminazione di un oggetto
     * Inserendo la posizione ci permette di spostare gli oggetti
     * per non lasciare il buco creato dall'eliminazione
     * @param posizione posizione in cui deve spostare gli elementi
     */
    private void aggiornaPosizioneGiornale(int posizione)
    {
        for (int i=posizione;i<nGiornalePresenti-1;i++)  
        {
            elencoGiornale[i]=elencoGiornale[i+1];
        }
        elencoGiornale[nGiornalePresenti-1]=null;      //se ne elimini uno, sicuramente l'ultimo deve contenere null ( lo faccio per togliere dall'array IL giornale eliminato)
        nGiornalePresenti--;
    }
    
    /**
    * Metodo che ordina i giornali con un determinato nome in ordine decrescente.
    * Questo metodo restituisce un array di oggetti Giornale ordinato in ordine decrescente in base al nome.
    * @param nome il nome dei giornali che si desidera ordinare.
    * @return un array di oggetti Giornale ordinato in ordine decrescente in base al nome.
    * @throws NullPointerException.
    * @throws ArrayIndexOutOfBoundsException.
    * @throws EccezioneValoreNonEsistente.
    */
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
    
    /**
     * Metodo che salva tutti i giornali dell'array su un file CSV
     * @param nomeFile nome del file CSV su cui vogliamo salvare i dati
     * @throws IOException.
     * @throws EccezioniPosizioneNonValida.
     * @throws FileException .
     */     
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
    
    /**
     * Metodo che salva tutte i giornali dell'array su un file binario
     * @param nomeFile nome del file binario su cui vogliamo salvare i dati
     * @throws IOException .
     * @throws EccezioniPosizioneNonValida .
     * @throws FileException  .
     */
    public void salvaGiornaleBinario(String nomeFile) throws IOException,EccezioniPosizioneNonValida, FileException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
}
