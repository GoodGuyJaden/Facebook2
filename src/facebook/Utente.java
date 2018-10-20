package facebook;

public class Utente 
{
	private Persona [] listaAmici = new Persona[50];
	private Foto [] galleria = new Foto[100];
	private static int indice=0;
	private static int indiceFoto=0;
	
	
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
		
		System.out.println("Persona non trovata.");
		return null;
	}
	
	public boolean addAmici(Persona p)
	{
		if(indice==0)
		{
			listaAmici[indice]=p;
			System.out.println("Amico aggiunto alla lista amici.");
			indice++;
		}
		else
		{
			if(controllo(p)) System.out.println("Hai già questo amico nella lista amici.");
			
			else 
			{
				listaAmici[indice]=p;
				indice++;
				System.out.println("Amico aggiunto alla lista amici.");
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
					if(i==indice-1)
					{
						indice=i;
						break;
					}
					else
					{
						listaAmici[i]=listaAmici[i+1];
						listaAmici[i+1]=null;
						i=-1;
					}
					
				}
				
			}
		
		}
	}
	
	public void setIndiceFoto()
	{	
		if(indiceFoto==1)
		{
			indiceFoto--;
		}
		else
		{
			for (int i=0;i<indiceFoto;i++)
			{
				if(galleria[i]==null)
				{
					if(i==indiceFoto-1)
					{
						indiceFoto=i;
						break;
					}
					else
					{
						galleria[i]=galleria[i+1];
						galleria[i+1]=null;
						i=-1;
					}
					
				}
				
			}
		
		}
	}
	
	public void stampaLista() 
	{
		if(indice==0)
		{
			System.out.println("Non hai amici.");
		}
		else
		{
			System.out.println("I tuoi amici sono:");
			
			for (int i=0;i<indice;i++)
			{
					System.out.println(listaAmici[i]);
			}
		}
		
	}
	
	public void stampaGalleria() 
	{
		if(indiceFoto==0)
		{
			System.out.println("Non hai foto nella galleria.");
		}
		else
		{
			System.out.println("Le tue foto sono:");
			
			for (int i=0;i<indiceFoto;i++)
			{
				System.out.println(galleria[i]);
			}
		}
		
	}
	
	public boolean addFoto(Foto f)
	{
		if(indiceFoto==0)
		{
			galleria[indiceFoto]=f;
			System.out.println("Foto aggiunto alla galleria.");
			indiceFoto++;
		}
		else
		{
			for(int i=0;i<indiceFoto;i++)
			{
				if(galleria[i].titolo.equals(f.titolo)) 
				{
					System.out.println("Hai già una foto con questo titolo. Non puoi aggiungerla.");
					return false;
				}
			}
				
				galleria[indiceFoto]=f;
				indiceFoto++;
				System.out.println("Foto aggiunta.");
		}
		return false;
	}

	public void contaTag(Persona p) 
	{
		int conta=0;
		
		for(int i=0;i<indiceFoto;i++)
		{
			if(galleria[indiceFoto].tag.equals(p)) conta++;
		}
		
		System.out.println("Questa persona è stata taggata in "+conta+" foto.");
	}

	public void bff()
	{
		int indice=0;
		int conta=0;
		int max=0;
		Persona p=null;
		
		for(int i=0;i<indiceFoto;i++)
		{
			if(galleria[indice].tag.equals(galleria[i].tag)) conta++;
			
			if(conta>max)
			{
				p=galleria[indice].tag;
				max=conta;
				conta=0;
				indice++;
			}
			else
			{
				conta=0;
				indice++;
			}
		}
		
		System.out.println("L'amico taggato in più foto è: "+p);
	}

	public boolean addTag(String titolo,Persona p)
	{
		for (int i=0;i<indiceFoto;i++)
		{
			if(titolo.equals(galleria[i].titolo))
			{
				galleria[i].tag=p;
				System.out.println("Tag effettuato.");
				return true;
			}
		}
		System.out.println("Foto non trovata.");
		return false;
	}
	
	public boolean remFoto(String titolo)
	{
		if(indiceFoto==0)
		{
			System.out.println("Non hai foto, non puoi usare questa funzione.");
		}
		else
		{
			for (int i=0;i<indiceFoto;i++)	
			{
				if(titolo.equals(galleria[i].titolo))
				{
					galleria[i]=null;
					setIndiceFoto();
					System.out.println("Questa foto è stata rimossa dalla galleria.");
					return true;
				}		
			}
		}
		
		return false;
	}
	
	

}
