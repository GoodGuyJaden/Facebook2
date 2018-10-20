package facebook;

public class Persona 
{
	String nome;
	String cognome;
	String eta;
	
	public Persona(String nome, String cognome,String eta)
	{
		this.nome=nome;
		this.cognome=cognome;
		this.eta=eta.replaceAll("\\D+","");
	}
		
	public static boolean uguale(Persona p,Persona p1)
	{
		if(p1.nome.equals(p.nome) && p1.cognome.equals(p.cognome) && p.eta.equals(p1.eta)) return true;
		
		else return false;
		
	}
	
	@Override
	public String toString() {
		return nome + " " + cognome + " " + eta + " anni.";
	}
	
	public String toString1() {
		return "il nome è" + nome ;
	}
	
}
