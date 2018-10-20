package facebook;

public class Utente 
{
	Persona [] listaAmici = new Persona[50];
	private Foto [] galleria = new Foto[100];
	private static int indice=0;
	private static int indiceFoto=0;
	
	public void getIndice()
	{
		System.out.println("L'indice è: " + indice);
	}
	public void getIndiceFoto()
	{
		System.out.println("L'indice delle foto è: "+indiceFoto);
	}
	
	public Persona cerca (String stringa)
	{
		
			for(int i=0;i<indice;i++)
			{
				if (stringa.equals(listaAmici[i].nome))
				{
					return listaAmici[i];
				}
				else if (stringa.equals(listaAmici[i].cognome))
				{
					return listaAmici[i];
				}
			}
			
		return null;
	}
	
	public boolean addAmici(Persona p)
	{
		if(indice==0)
		{
			listaAmici[indice]=p;
			System.out.println("Amico aggiunto alla lista amici.");
			indice++;
			System.out.println("Indice incrementato: "+indice);
		}
		else
		{
			if(controllo(p)) System.out.println("Hai già questo amico nella lista amici.");
			
			else 
			{
				listaAmici[indice]=p;
				indice++;
				System.out.println("Indice incrementato nell'else: "+indice);
				System.out.println("Amico aggiunto.");
			}
				
		}
		return false;
		
	}
	
	private boolean controllo(Persona p)
	{
		for(int i=0;i<indice;i++)
		{
			if(Persona.uguale(listaAmici[i], p)) return true;
		}
		return false;
	}
	
	
	public boolean remAmici(Persona p)
	{
		if(indice==0)
		{
			System.out.println("Non hai amici, non puoi usare questa funzione.");
		}
		else
		{
			for (int i=0;i<indice;i++)	
			{
				if(Persona.uguale(listaAmici[i], p))
				{
					listaAmici[i]=null;
					setIndice();
					System.out.println("Questa persona non fa più parte della tua lista amici.");
					return true;
				}		
			}
		}
		
		return false;
	}
	
	public void setIndice()
	{	
		if(indice==1)
		{
			indice--;
		}
		else
		{
			for (int i=0;i<indice;i++)
			{
				if(listaAmici[i]==null)
				{
					System.out.println("La i è nulla: "+i);
					if(i==indice-1)
					{
						indice=i;
						System.out.println("indice impostato a i: "+indice);
						break;
					}
					else
					{
						listaAmici[i]=listaAmici[i+1];
						System.out.println("Ho spostato i con i+1 e stampo i: "+listaAmici[i]);
						listaAmici[i+1]=null;
						System.out.println("Setto i+1 a null e lo stampo: "+listaAmici[i+1]);
						i=-1;
						System.out.println("Setto i-1 e lo stampo: "+i);
					}
					
				}
				
		}
		
		}
	}
	
	public void stampaLista() 
	{
		System.out.println("I tuoi amici sono:");
		
		if(indice==0)
		{
			System.out.println("Non hai amici.");
		}
		else
		{
			for (int i=0;i<indice;i++)
			{
					System.out.println(listaAmici[i]);
			}
		}
		
	}
	
	public void stampaGalleria() 
	{
		boolean valore=false;
		System.out.println("Le tue foto sono :");
		
		for (Foto f:galleria)
		{
			if(f!=null)
			{
				if(f.tag!=null)
				{
					System.out.println(f);
					valore=true;
				}
				else
				{
					System.out.println("Titolo: "+ f.titolo + "; Questa foto non ha tag.");
					valore=true;
				}
			}
			
			
		}
		
		if(!valore) System.out.println("Non hai foto.");
		
	}
	
	public boolean addFoto(Foto f)
	{
		for (int i=0;i<galleria.length;i++)
		{
			if(galleria[i]==null)
			{
				galleria[i]=f;
				System.out.println("Foto aggiunta alla galleria");
				return true;
			}
		}
		return false;
	}

	public void contaTag(Persona p) 
	{
		int conta=0;
		
		for(int i=0;i<galleria.length;i++)
		{
			if((galleria[i]!=null && galleria[i].tag.equals(p))) conta++;
			
		}
		
		System.out.println("Questa persona è stata taggata in "+conta+" foto.");
	}
//SISTEMARE ANCHE GALLERIA CON INDICEFOTO
	
	public void bff()
	{
		int indice=0;
		int conta=0;
		int max=0;
		Persona p=null;
		
		for (int i=0;i<galleria.length;i++)
		{
			try 
			{
				if(i==(galleria.length-1) && galleria[i]==null && indice<galleria.length)
				{
					if(conta>=max)
					{
						max=conta;
						//System.out.println("Galleria tag:    " + galleria[indice].tag);
						p=galleria[indice].tag;
						//System.out.println("persona:  " + p);
						indice++;
						conta=0;
						i=0;
					}
					else
					{
						if(indice==galleria.length-1)
						{
							
						}
						else
						{
							indice++;
							conta=0;
							i=0;
						}
						
					}
				}
				else
				{
					if(galleria[indice].tag.equals(galleria[i].tag))
					{
						//System.out.println("i: "+ i);
						conta++;
						//System.out.println("conta: " +conta);
					}
					else
					{
						//System.out.println("i: "+i);
						//System.out.println("diverso");
					}
				}
				
				
				
				
			}catch(NullPointerException e)
			
			{
				
			}
		}
		System.out.println("L'amico taggato in più foto è: "+p);
	}

	public void addTag(String titolo,Persona p)
	{
		try
		{
			for (int i=0;i<galleria.length;i++)
			{
				if(titolo.equals(galleria[i].titolo))
				{
					galleria[i].tag=p;
					System.out.println("Tag effettuato.");
					break;
				}
			}
			
		}catch(NullPointerException e)
		
		{
			System.out.println("Foto non trovata nella galleria.");
		}
		
	}
	
	
	/*
	public boolean remFoto(String titolo)
	{
		try
		{
			for (int i=0;i<galleria.length;i++)
			{
				if (titolo.equals(galleria[i].titolo))
				{
					galleria[i]=null;
					return true;
				}
			}
			
		}catch(NullPointerException e)
		
		{
			System.out.println("Non hai una foto con questo titolo.");
		}
		return false;
	}
	*/
	

}
