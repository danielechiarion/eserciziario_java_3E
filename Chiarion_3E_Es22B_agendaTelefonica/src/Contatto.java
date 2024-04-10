enum tipoContratto{abitazione, cellulare, aziendale, undefined};

public class Contatto {
    public String nome;
    public String cognome;
    public String telefono;
    public tipoContratto tipo;

    public String stampa()
    {
        /* aggiungo una condizione
        per la tipologia di telefono */
        if(tipo==null)
            tipo=tipoContratto.undefined; //assegno il valore undefined

        return String.format("Nome: %s\tCognome: %s\nTelefono: %s,\ttipo: %s\n", nome, cognome, telefono, tipo.toString());
    }
}
