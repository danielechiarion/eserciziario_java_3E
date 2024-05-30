enum tipoContratto{abitazione, cellulare, aziendale, undefined};

public class Contatto {
    protected String nome;
    protected String cognome;
    protected String telefono;
    protected tipoContratto tipo;
	protected double ricarica;

	public Contatto(String nome, String cognome, String telefono, tipoContratto tipo){
		this.nome=nome;
		this.cognome=cognome;
		this.telefono=telefono;
		this.tipo=tipo;
		this.ricarica=10; //imposto valore di default
	}   

	public String stampa()
    {
        /* aggiungo una condizione
        per la tipologia di telefono */
        if(tipo==null)
            tipo=tipoContratto.undefined; //assegno il valore undefined

        return String.format("Nome: %s\tCognome: %s\nTelefono: %s,\ttipo: %s\n%.2f€\n", nome, cognome, telefono, tipo.toString(), ricarica);
    }

	/* ridefinizione del metodo toString()
	* che determina il formato stringa che salva
	* su file CSV */
	@Override
	public String toString(){
		/* ritorno il formato dei dati da salvare in CSV,
		* con virgola come separatore */
		return String.format("%s,%s,%s,%s, %f",
				this.nome, this.cognome, this.telefono, this.tipo.name(), this.ricarica);
	}

	/* metod get/set */
	public String getNome(){
		return this.nome;
	}
	public String getCognome(){
		return this.cognome;
	}
	public String getTelefono(){
		return this.telefono;
	}
	public tipoContratto getTipo(){ return this.tipo; }
	public double getRicarica(){ return this.ricarica; }
	
	public void setNome(String nome){
		this.nome=nome;
	}
	public void setCognome(String cognome){
		this.cognome=cognome;
	}
	public void setTipo(tipoContratto tipo){
		this.tipo=tipo;
	}
	public void setTelefono(String telefono){ this.telefono=telefono; }
	public void setRicarica(double importo){ this.ricarica += importo; }
}
