/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.edicola_lorenzogiacomelli;

import eccezioni.EccezioneValoreNonEsistente;
import eccezioni.EccezioniPosizioneNonValida;
import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class App implements Serializable
{

    public static void main(String[] args) 
    {
        String[] vociMenu=new String[8];
        int sceltaUtente=-1;
        Scanner tastiera=new Scanner(System.in);
        
        Edicola e=new Edicola();
        Giornale giornale;
        
        String nome;
        LocalDate data;
        int numeroPagine;
        int giorno, mese, anno;
        String tipologia;
        String autore;
        int idGiornale = 0;
        
        String nomeFile="edicola.txt";
        String nomeFileBin="edicola.bin";
        
        
                
        vociMenu[0] = "Esci";
        vociMenu[1] = "Aggiungi un nuovo giornale";
        vociMenu[2] = "Visualizza giornali in base al titolo";
        vociMenu[3] = "Modifica un giornale esistente";
        vociMenu[4] = "Rimuovi un giornale";
        vociMenu[5] = "Visualizza giornali in ordine alfabetico per titolo";
        vociMenu[6] = "Esporta tutti i giornali in formato CSV";
        vociMenu[7] = "Salva giornali su file binario";

        /*
        try
        {
            FileInputStream f1=new FileInputStream(nomeFileBin);
            ObjectInputStream reader=new ObjectInputStream(f1);
            try
            {
                e=(Edicola)reader.readObject();
                reader.close();
                System.out.println("\nLettura da file avvevuta correttamente");
                        
            }
            catch(ClassNotFoundException ex)
            {
                reader.close();
                System.out.println("\nErrore nella lettura");
            }
        }
        catch(IOException ex)
        {
            System.out.println("\nImpossibile accedere al file");
        }
        */
        
        
        
        
        Menu menu=new Menu(vociMenu);
        
        do
        {
            try
            {
                    int id;
                    if(e.getnGiornalePresenti()>0)
                    {
                       id=e.getId(e.getnGiornalePresenti()-1); 
                    }
                    else
                    {
                        id=-1;
                    }
                    
                    
                    
                    
                    tastiera.nextLine();
                    sceltaUtente=menu.sceltaMenu();
                    System.out.println("Premi un tasto per continuare...");
                    tastiera.nextLine();

                    switch(sceltaUtente)
                    {
                        case 0:
                        {
                            System.out.println("L'applicazione e' terminata");
                            break;
                        }
                        case 1:
                        {
                            if(e.getnGiornalePresenti()>= e.getNUM_MAX_GIORNALE())
                            {
                                System.out.println("Il numero massimo di giornali è stato raggiunto");
                                System.out.println("premi un tasto per continuare....");
                                tastiera.nextLine();
                                break;
                            }
                            
                           try
                           {
                            
                                System.out.println("Nome-->");
                                nome=tastiera.nextLine();
                                System.out.println("Numero pagine-->");
                                numeroPagine=tastiera.nextInt();
                                System.out.println("Tipologia-->");
                                tipologia=tastiera.nextLine();
                                System.out.println("Autore-->");
                                autore=tastiera.nextLine();
                                System.out.println("Data: ");
                                System.out.println("Giorno --> ");
                                giorno=tastiera.nextInt();
                                System.out.println("Mese --> ");
                                mese=tastiera.nextInt();
                                System.out.println("Anno --> ");
                                anno=tastiera.nextInt();
                                data=LocalDate.of(anno, mese, giorno);
                                
                                
                                idGiornale++;
                                giornale=new Giornale(nome, data, numeroPagine, tipologia, autore, idGiornale);
                                
                                e.aggiungiGiornale(giornale);

                                break;
                           }
                           catch(InputMismatchException e1)
                            {
                                System.out.println("il valore che è stato inserito non è corretto");
                                tastiera.nextLine();
                                
                                break;
                            }
                           
                        }
                        case 2:
                        {
                            try
                            {
                            
                                Giornale[] elencoGiornale;
                                String nome1;
                                System.out.println("Nome-->");
                                nome1=tastiera.nextLine();

                                elencoGiornale=e.GiornaleNome(nome1);
                                
                                       for(int i=0;i<elencoGiornale.length;i++)
                                       {
                                           if(elencoGiornale[0]==null)
                                               System.out.println("nessuna nome per il giornale"+nome1);
                                           if(elencoGiornale[i]!=null)
                                              System.out.println(elencoGiornale[i]);
                                           else 
                                           {
                                               break;
                                           }
                                               
                                           
                                       }
                             break;
                            }
                            catch(ArrayIndexOutOfBoundsException e1)
                            {
                                    System.out.println("il giornale inserito non è presente ");
                                    System.out.println("Premi un tasto per continuare...");
                                    tastiera.nextLine();
                                    break;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("l'inserimento non è valido");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            } 
                            catch(EccezioneValoreNonEsistente ex)
                            {
                                System.out.println("Il giorno inserito non è esistente");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            } 

                            
                        }
                        case 3:
                        {
                            try
                            {
                                Giornale[] elencoGiornale;
                                int anno1,mese1,giorno1;
                                LocalDate data1;
                                System.out.println("Anno-->");
                                anno1=tastiera.nextInt();
                                System.out.println("Mese-->");
                                mese1=tastiera.nextInt();
                                System.out.println("Giorno-->");
                                giorno1=tastiera.nextInt();
                                data1=LocalDate.of(anno1,mese1,giorno1);

                                elencoGiornale=e.GiornaleGiorno(data1);


                                if(elencoGiornale==null)
                                        System.out.println("nessuna revisione per il giorno "+data1);
                                else
                                  {
                                       for(int i=0;i<elencoGiornale.length;i++)
                                           if(elencoGiornale[i]!=null)
                                              System.out.println(elencoGiornale[i]);

                                  }

                                break;
                                
                            }
                            catch(DateTimeException e1)
                            {
                                System.out.println("errore nell'inserimento della data");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("l'inserimento non è valido");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            }  
                            catch(EccezioneValoreNonEsistente ex)
                            {
                                System.out.println("Il giorno inserito non è esistente");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            } 
                        }
                        case 4:
                        {
                            try
                            {
                                int codice,x;
                                System.out.println("codice-->");
                                codice=tastiera.nextInt();

                                x=e.eliminaGiornaleId(codice);
                                if(x==0)
                                    System.out.println("eliminazione avvenuta correttamente");
                                else
                                    System.out.println("eliminazione non avvenuta");

                                break;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("l'inserimento non è valido");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            } 
                            catch(EccezioneValoreNonEsistente ex)
                            {
                                System.out.println(ex.toString());
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            } 
                        }
                        case 5:
                        {


                            try
                            {
                                Giornale[] elencoGiornale;
                                String nome1;

                                System.out.println("Nome-->");
                                nome1=tastiera.nextLine();
                                

                                elencoGiornale=e.ordinaNomiGiornaliDecrescente(nome1);
                                    for(int i=0;i<elencoGiornale.length;i++)
                                    {
                                        System.out.println("CodiceId--> "+elencoGiornale[i].getIdGiornale()+" Autore--> "+elencoGiornale[i].getAutore()+" Nome--> "+elencoGiornale[i].getNome()+" Numero pagine--> "+elencoGiornale[i].getNumeroPagine()+" Tipologia--> "+elencoGiornale[i].getTipologia()+" Data--> "+elencoGiornale[i].getData());
                                    }
                                    System.out.println("premi un pulsante per continuare");
                                        tastiera.nextLine();  
                            }
                            catch(NullPointerException e1)
                            {
                                System.out.println("si è verificato un problema");
                            }
                            catch(ArrayIndexOutOfBoundsException e2)
                            {
                            System.out.println("giornale inserito non è presente");
                            break;
                            }
                            catch(EccezioneValoreNonEsistente ex)
                            {
                                System.out.println("Il giornale inserito non sono esistenti");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            } 
                            


                            break;
                        }
                        case 6:
                        {
                            try
                                {
                                    e.salvaGiornale(nomeFile);
                                    System.out.println("salvataggio avvenuto correttamente");
                                }
                                catch(IOException e1)
                                {
                                    System.out.println("impossibile accedere al file, i giornali non sono stati salvati");
                                }
                                catch(FileException e2)
                                {
                                    System.out.println(e2.toString());
                                } 
                                catch(EccezioniPosizioneNonValida e1)
                                {
                                    System.out.println("La posizione non è valida");
                                }


                            break;
                        }
                        case 7:
                        {
                            try
                                {
                                    e.salvaGiornaleBinario(nomeFileBin);
                                    System.out.println("salvataggio avvenuto correttamente");
                                }
                                catch(IOException e1)
                                {
                                    System.out.println("impossibile accedere al file binario, i giornali non sono state salvate");
                                }
                                catch(FileException e2)
                                {
                                    System.out.println(e2.toString());
                                } 
                                catch(EccezioniPosizioneNonValida e1)
                                {
                                    System.out.println("La posizione non è valida");
                                }

                            break;
                        }


                    }
            }
            catch(InputMismatchException | NumberFormatException e1)
            {
                tastiera.nextLine();
                System.out.println("l'input non è corretto");
            }   
            catch(ArrayIndexOutOfBoundsException ex)
            {
                tastiera.nextLine();
                System.out.println("Si è verificato un problema");
            } 
            catch(DateTimeException ex)
            {
                tastiera.nextLine();
                System.out.println("l'inserimento della data non è corretto");
            }
            
            
            
        }while(sceltaUtente!=0);
        
        
        
    }
} 
    

