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
		return "Titolo: " + titolo + "; " + tag.nome + " " + tag.cognome + " è taggato in questa immagine.";
	}
	
	
}
