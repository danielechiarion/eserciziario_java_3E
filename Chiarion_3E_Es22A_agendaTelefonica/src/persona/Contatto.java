package persona;
public class Contatto {
    public enum tipoTel{ABITAZIONE, CELLULARE, AZIENDALE};
    /* attributi del contatto */
    public String nome;
    public String cognome;
    public String telefono;
    public tipoTel utilizzo;

    public String anagrafica()
    {
        return String.format("Nome: %s Cognome: %s Telefono: %s Tipologia: %s", nome, cognome, telefono, utilizzo.toString()); //puoi usare anche utilizzo.name
    }
}
