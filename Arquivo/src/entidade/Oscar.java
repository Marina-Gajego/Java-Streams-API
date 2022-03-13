package entidade;

public class Oscar {

    private Integer ano;
    private Integer idade;
    private String nome;
    private String filme;

    private Oscar(Integer ano, Integer idade, String nome, String filme) {
        this.ano = ano;
        this.idade = idade;
        this.nome = nome;
        this.filme = filme;
    }

    public static Oscar of(String line) {
        String[] split = line.split(";\\s");
        return new Oscar(
                Integer.parseInt(split[1]), //ano
                Integer.parseInt(split[2]), //idade
                split[3],  //nome
                split[4]); //filme
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Oscar: " +
                "Nome= " + nome  +
                ", Idade= " + idade +
                ", Filme= " + filme +
                ", Ano=" + ano + "\n";
    }
}
