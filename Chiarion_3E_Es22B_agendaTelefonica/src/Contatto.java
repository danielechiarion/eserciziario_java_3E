import org.json.JSONArray;
import org.json.JSONObject;

import static tools.jsonFile.*;

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

	/* metodo per convertire una stringa di JSONObject
	 * in un array di contatti */
	public static Contatto[] getLista(String filePath, int maxContatti){
		JSONArray list = readDataJSON(filePath);
		Contatto[] rubrica = new Contatto[maxContatti];

		/* copio tutti i valori */
		for(int i=0;i<list.length() && list.getJSONObject(i)!=null;i++){
			/* inserisco tutti gli attributi
			nel metodo costruttore */
			rubrica[i]=new Contatto(list.getJSONObject(i).getString("nome"),
					list.getJSONObject(i).getString("cognome"),
					list.getJSONObject(i).getString("telefono"),
					tipoContratto.valueOf(list.getJSONObject(i).getString("tipo")));

			rubrica[i].setRicarica(list.getJSONObject(i).getDouble("ricarica")); //setto la ricarica
		}

		return rubrica;
	}

	/* metodo per trasformare un array
	 * di contatti in un JSONArray */
	public static JSONArray convertToJSON(Contatto[] gestore, int contrattiVenduti){
		/* creo il jsonArrray con il numero di contatti richiesti */
		JSONArray contactList = new JSONArray(contrattiVenduti);

		/* per ogni oggetto gli assegno un JSONObject
		e lo salvo nell'array */
		for(int i=0;i<contrattiVenduti;i++){
			JSONObject contact = new JSONObject(); //creo JSON object

			/* assegno all'oggetto tutti gli attributi
			* necessari */
			contact.put("nome", gestore[i].getNome());
			contact.put("cognome", gestore[i].getCognome());
			contact.put("telefono", gestore[i].getTelefono());
			contact.put("tipo", gestore[i].getTipo().name());
			contact.put("ricarica", gestore[i].getRicarica());

			/* aggiungo l'oggetto al JSONArray */
			contactList.put(contact);
		}

		return contactList; //ritorno l'array completo
	}
}
