/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edicola_lorenzogiacomelli;

import java.time.LocalDate;

/**
 * Classe che rappresenta un giornale.
 * Un giornale ha un nome, una data di pubblicazione, un numero di pagine, una tipologia, un autore e un identificativo.
 * In questa classe vengono inserite tutte le informazioni
 * di un giornale.
 */

public class Giornale 
{
    private String nome;
    private LocalDate data;
    private int numeroPagine;
    private String tipologia;
    private String autore;
    private int idGiornale;
    
    /**
    * Costruttore della classe Giornale.
    * 
    * @param nome Il nome del giornale.
    * @param data La data di pubblicazione del giornale.
    * @param numeroPagine Il numero di pagine del giornale.
    * @param tipologia La tipologia del giornale.
    * @param autore L'autore del giornale.
    * @param idGiornale L'identificativo del giornale.
    */    
    public Giornale(String nome, LocalDate data, int numeroPagine, String tipologia, String autore, int idGiornale) 
    {
        this.nome = nome;
        this.data = data;
        this.numeroPagine = numeroPagine;
        this.tipologia = tipologia;
        this.autore = autore;
        this.idGiornale = idGiornale;
    }
    
    /**
     * Costruttore di copia della classe Giornale. Consente di istanziare una nuovo giornale
     * Copia di un giornale passato come parametro
     * @param g oggetto di classe Giornle di cui verrà effettuata la copia nel costruttore di copia
     */
    public Giornale(Giornale g)
    {        
        nome=g.getNome();
        data=g.getData();
        numeroPagine=g.getNumeroPagine();
        tipologia=g.getTipologia();
        autore=g.getAutore();
        idGiornale=g.getIdGiornale();        
    }     
    
    /**
     * Costruttore di default della classe Giornale
     * Consente di istanziare un oggetto di classe Giornale con valori nulli 
     * Alle variabili:
     * idGiornale: con valore 0
     * nome: come stringa vuota
     * tipologia: come stringa vuota
     * autore: come stringa vuota
     * data: con valore del giorno,mese e anno e momento in cui viene istanziata
     * numeroPagine: con valore 0
     */
    public Giornale()
    {
        idGiornale=0;
        nome="";
        tipologia="";
        autore="";
        data=LocalDate.now();
        numeroPagine=0;
    }
    
    /**
     * Metodo getter della variabile Nome
     * Ci permette di visualizzare il contenuto della variabile nome
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Metodo setter della variabile nome
     * Ci permette di assegnare un valore alla variabile nome
     * @param nome valore della variabile nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Metodo getter della variabile data
     * Ci permette di visualizzare il contenuto della variabile data
     * @return data
     */
    public LocalDate getData() {
        return data;
    }
    
    /**
     * Metodo setter della variabile Data.
     * Ci permette di assegnare un valore alla variabile data inserendo il valore di anno,mese e giorno.
     * @param anno valore della variabile anno.
     * @param mese valore della variabile mese.
     * @param giorno valore della variabile giorno.
     */
    public void setData(int anno,int mese,int giorno) 
    {
        data=LocalDate.of(anno,mese,giorno);
    }

    /**
     * Metodo getter della variabile NumeroPagine
     * Ci permette di visualizzare il contenuto della variabile NumeroPagine
     * @return numeroPagine;
     */
    public int getNumeroPagine() 
    {
        return numeroPagine;
    }
    
    /**
     * Metodo setter della variabile NumeroPagine.
     * Ci permette di assegnare un valore alla variabile NumeroPagine.
     * @param numeroPagine valore della variabile numeroPagine.
     */
    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    /**
     * Metodo getter della variabile tipologia
     * Ci permette di visualizzare il contenuto della variabile tipologia
     * @return tipologia
     */
    public String getTipologia() {
        return tipologia;
    }

    /**
     * Metodo setter della variabile Tipologia.
     * Ci permette di assegnare un valore alla variabile tipologia.
     * @param tipologia valore della variabile tipologia.
     */
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    /**
     * Metodo getter della variabile autore.
     * Ci permette di visualizzare il contenuto della variabile autore.
     * @return autore.
     */
    public String getAutore() {
        return autore;
    }

    /**
     * Metodo setter della variabile Autore.
     * Ci permette di assegnare un valore alla variabile Autore.
     * @param autore valore della variabile autore.
     */
    public void setAutore(String autore) {
        this.autore = autore;
    }
    
    /**
    * Restituisce il codice identificativo del giornale.
    * @return Il codice identificativo del giornale.
    */

    public int getIdGiornale() {
        return idGiornale;
    }

    /**
    * Imposta il codice identificativo del giornale.
    * 
    * @param idGiornale Il nuovo codice identificativo del giornale da impostare.
    */

    public void setIdGiornale(int idGiornale) {
        this.idGiornale = idGiornale;
    }

    /**
     * Metodo toString di tutti gli attributi della classe Giornale, degli oggetti di classe Giornale.
     * Ci permette di visualizzare il valore di tutti gli attributi dell'oggetto di classe Giornale.
     * @return una stringa contenente il valore degli attributi di giornle.
     */
    @Override
    public String toString() {
        return "Giornale{" + "nome=" + nome + ", data=" + data + ", numeroPagine=" + numeroPagine + ", tipologia=" + tipologia + ", autore=" + autore + ", idGiornale=" + idGiornale + '}';
    }
    
    
    
    
    
}
