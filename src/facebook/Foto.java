package facebook;

public class Foto 
{
	String titolo;
	Persona tag;
	
	public Foto(String titolo, Persona tag)
	{
		this.titolo=titolo;
		this.tag=tag;
	}

	@Override
	public String toString() {
		
		if(this.tag==null)
		{
			return "Titolo: " + titolo + ";";
		}
		else return "Titolo: " + titolo + "; " + tag.nome + " " + tag.cognome + " � taggato in questa immagine.";
	}
	
	
}
