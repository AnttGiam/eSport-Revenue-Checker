public class Giocatore {

    private String nome;
    private String cognome;
    private String paese;
    private String nickname;
    private String guadagni;
    private String gioco;
    private String genere;

    public Giocatore(String nome, String cognome, String paese, String nickname, String guadagni, String gioco, String genere) {
        this.nome = nome;
        this.cognome = cognome;
        this.paese = paese;
        this.nickname = nickname;
        this.guadagni = guadagni;
        this.gioco = gioco;
        this.genere = genere;
    }

    public Giocatore() {
        this.nome = "";
        this.cognome = "";
        this.paese = "";
        this.nickname = "";
        this.guadagni = "";
        this.gioco = "";
        this.genere = "";
    }

    @Override
    public String toString() {
        return "Giocatore{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", paese='" + paese + '\'' +
                ", nickname='" + nickname + '\'' +
                ", guadagni='" + guadagni + '\'' +
                ", gioco='" + gioco + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGuadagni() {
        return guadagni;
    }

    public void setGuadagni(String guadagni) {
        this.guadagni = guadagni;
    }

    public String getGioco() {
        return gioco;
    }

    public void setGioco(String gioco) {
        this.gioco = gioco;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
