package papeisieee;
public class Assinatura {
    private int pontuacao;
    private int pontuacaoMax;
    private float compatibilidade;
    private String tipo;
    private String nome;
    private String[] perfil;
    private String[] habilidades;
    private String[] interesses;
    private int numInteresses;
    private int numHabilidades;
    private String[] atividadesPreferidas;

    public Assinatura(String tipo, String nome, int pontuacaoMax, String[] perfil, String[] habilidades, String[] interesses, String[] atividadesPreferidas) {
        this.tipo = tipo;
        this.nome = nome;
        this.pontuacaoMax = pontuacaoMax;
        this.perfil = perfil;
        this.habilidades = habilidades;
        this.interesses = interesses;
        this.atividadesPreferidas = atividadesPreferidas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getPontuacaoMax() {
        return pontuacaoMax;
    }

    public void setPontuacaoMax(int pontuacaoMax) {
        this.pontuacaoMax = pontuacaoMax;
    }

    public float getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(float compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getPerfil() {
        return perfil;
    }

    public void setPerfil(String[] perfil) {
        this.perfil = perfil;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    public String[] getInteresses() {
        return interesses;
    }

    public void setInteresses(String[] interesses) {
        this.interesses = interesses;
    }

    public String[] getAtividadesPreferidas() {
        return atividadesPreferidas;
    }

    public void setAtividadesPreferidas(String[] atividadesPreferidas) {
        this.atividadesPreferidas = atividadesPreferidas;
    }

    public int getNumInteresses() {
        return numInteresses;
    }

    public void setNumInteresses(int numInteresses) {
        this.numInteresses = numInteresses;
    }

    public int getNumHabilidades() {
        return numHabilidades;
    }

    public void setNumHabilidades(int numHabilidades) {
        this.numHabilidades = numHabilidades;
    }
    

    
    
    
}
