package facebook;

import java.util.Scanner;

public class Principale 
{
	private static Scanner sc = new Scanner(System.in);
	private static Persona p;
	private static Utente u = new Utente();
		
	public static void main (String[]args)
	{
		menu();
		/*Persona p1=new Persona("Mattia","Passuello","18");
		Persona p2=new Persona("Andrea","Sabia","19");
		u.addAmici(p1);
		u.addAmici(p2);
		System.out.println(u.cerca("Matteo"));*/
		
	
	}
	
	static public boolean sceltaAggiungi(Persona p)
	{
		String scelta;
		
		System.out.println("Vuoi aggiungere la persona taggata agli amici?  y/n");
		
		scelta=sc.nextLine();
		if(scelta.toLowerCase().equals("y"))
		{
			u.addAmici(p);
			return true;
		}
		return false;
	}
	
	
	static public boolean sceltaRicerca()
	{
		
		String scelta;
		String nome;
		
		System.out.println("Vuoi usare la funzione cerca amico?  y/n ");
		scelta=sc.nextLine();
		
		if(scelta.toLowerCase().equals("y"))
		{	
			System.out.println("Inserisci il nome o il cognome del tuo amico: ");
			nome=sc.nextLine();
			p = u.cerca(nome);
			return true;
		}
		
		return false;
	}
	
	static public void menu()
	{
		
		String scelta ="";
		String nome;
		String cognome;
		String titolo;
		String eta;
		
		while(!scelta.equals("x")) 
		{
			/*
			System.out.println("");
			System.out.println("Inserisci 1 per aggiungere un amico.");
			System.out.println("Inserisci 2 per aggiungere una foto.");
			System.out.println("Inserisci 3 per aggiungere un tag ad una foto.");
			System.out.println("Inserisci 4 per contare quante foto sono taggate ad una persona.");
			System.out.println("Inserisci 5 per visualizzare la persona con più tag.");
			System.out.println("Inserisci 6 per visualizzare la tua lista amici.");
			System.out.println("Inserisci 7 per visualizzare la galleria.");
			System.out.println("Inserisci 8 per rimuovere un amico");
			System.out.println("Inserisci x per uscire");
			*/
			System.out.println("Inserisci 1 per aggiungere un amico.");
			System.out.println("Inserisci 8 per rimuovere un amico");
			scelta=sc.nextLine();
			
			switch(scelta)
			{
			case "0":
				u.getIndice();
				break;
				case "1":
						System.out.println("Inserisci 1)nome 2)cognome 3)eta separati da uno spazio: ");
						//System.out.println("Inserisci il nome: ");
						nome=sc.next();
						//System.out.println("Inserisci il cognome: ");
						cognome=sc.next();
						//System.out.println("Inserisci l'età: ");
						eta=sc.next();
						sc.nextLine();
						p = new Persona(nome,cognome,eta);
						u.addAmici(p);
						break;
					
				case "2":
						System.out.println("Inserisci il titolo della foto: ");
						titolo=sc.nextLine();
						
						System.out.println("Vuoi taggare qualcuno? y/n");
						scelta=sc.nextLine();
						
						if(scelta.toLowerCase().equals("y"))
						{
							if(sceltaRicerca()) u.addFoto(new Foto(titolo,p));
							
							else
							{
								System.out.println("Inserisci il nome: ");
								nome=sc.next();
								System.out.println("Inserisci il cognome: ");
								cognome=sc.next();
								System.out.println("Inserisci l'età: ");
								eta=sc.next();
								sc.nextLine();
								p=new Persona(nome,cognome,eta);
								u.addFoto(new Foto(titolo,p));
								sceltaAggiungi(p);
							}
						}
						else u.addFoto(new Foto(titolo,null));
						
						break;
					
				case "3":
						System.out.println("Inserisci il titolo della foto: ");
						titolo=sc.nextLine();
						
						if(sceltaRicerca()) u.addTag(titolo,p);
						
						else
						{
							System.out.println("Inserisci il nome: ");
							nome=sc.next();
							System.out.println("Inserisci il cognome: ");
							cognome=sc.next();
							System.out.println("Inserisci l'età: ");
							eta=sc.next();
							sc.nextLine();
							p=new Persona(nome,cognome,eta);
							u.addTag(titolo,p);
							sceltaAggiungi(p);
						}
						break;
					
				case "4":
						System.out.println("Inserisci il nome o il cognome della persona da cercare: ");
						nome=sc.next();
						sc.nextLine();
						u.contaTag(u.cerca(nome));
						break;
				
				case "5":
						u.bff();
						break;
						
				case "6":
						u.stampaLista();
						break;
						
				case "7":
						u.stampaGalleria();
						break;
						
				case "8":
						System.out.println("Inserisci o il nome o il cognome della persona da cancellare.");
						p=u.cerca(sc.next());
						if(p==null)
						{
							System.out.println("Non è stato trovato nessun utente con questo nome/cognome.");
						}
						else
						{
							sc.nextLine();
							u.remAmici(p);
						}
						break;
						
				default:
						System.out.println("Selezionare un'opzione valida.");
						break;
			}
		}
		
	}
}
