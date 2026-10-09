public class Aluno {
    private String nome;
    private boolean ehMembro;
    private String[] perfil;
    private String[] habilidades;
    private String[] interesses;
    private String[] atividadePreferida;
    
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

    
    public String[] getAtividadePreferida() {
        return atividadePreferida;
    }

    public void setAtividadePreferida(String[] atividadePreferida) {
        this.atividadePreferida = atividadePreferida;
    }

    public boolean isEhMembro() {
        return ehMembro;
    }

    public void setEhMembro(boolean ehMembro) {
        this.ehMembro = ehMembro;
    }

    
    
}
