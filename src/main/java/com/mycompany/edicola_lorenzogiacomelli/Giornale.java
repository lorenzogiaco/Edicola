/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edicola_lorenzogiacomelli;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Giornale 
{
    private String nome;
    private LocalDate data;
    private int numeroPagine;
    private String tipologia;
    private String autore;
    private int idGiornale;
    
    public Giornale(String nome, LocalDate data, int numeroPagine, String tipologia, String autore, int idGiornale) 
    {
        this.nome = nome;
        this.data = data;
        this.numeroPagine = numeroPagine;
        this.tipologia = tipologia;
        this.autore = autore;
        this.idGiornale = idGiornale;
    }
    
    public Giornale(Giornale g)
    {        
        nome=g.getNome();
        data=g.getData();
        numeroPagine=g.getNumeroPagine();
        tipologia=g.getTipologia();
        autore=g.getAutore();
        idGiornale=g.getIdGiornale();        
    }     
    
    public Giornale()
    {
        idGiornale=0;
        nome="";
        tipologia="";
        autore="";
        data=LocalDate.now();
        numeroPagine=0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(int anno,int mese,int giorno) 
    {
        data=LocalDate.of(anno,mese,giorno);
    }

    public int getNumeroPagine() 
    {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getIdGiornale() {
        return idGiornale;
    }

    public void setIdGiornale(int idGiornale) {
        this.idGiornale = idGiornale;
    }

    @Override
    public String toString() {
        return "Giornale{" + "nome=" + nome + ", data=" + data + ", numeroPagine=" + numeroPagine + ", tipologia=" + tipologia + ", autore=" + autore + ", idGiornale=" + idGiornale + '}';
    }
    
    
    
    
    
}
