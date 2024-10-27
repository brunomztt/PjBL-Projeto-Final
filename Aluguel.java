import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Aluguel extends Filme {
    protected LocalDate dataAluguel;
    protected LocalDate dataExpiracao;
    protected LocalDate dataDevolucao;
    protected boolean devolvido;
    protected int diasAlugados;
    protected double valorTotal;


    public Aluguel(String titulo, int ano, String genero, String diretor, double duracao, String descricao, String classificacao, double avaliacaoMedia, double preco) {
        super(titulo, ano, genero, diretor, duracao, descricao, classificacao, avaliacaoMedia, classificacao, avaliacaoMedia, preco);
        this.dataAluguel = LocalDate.now();
        this.dataExpiracao = LocalDate.now();
        this.dataDevolucao = LocalDate.now();
        this.diasAlugados = diasAlugados;
        this.valorTotal = getPreco();
    }


    public double calcularMulta(int diasAtraso) {
        double taxaMulta = 5.0; // taxa de multa diária
        return diasAtraso * taxaMulta;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public String exibirResumoAluguel() {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String dataAluguelStr = formatoData.format(dataAluguel);
        String dataDevolucaoStr = (dataDevolucao != null) ? formatoData.format(dataDevolucao) : "Ainda não devolvido";

        return "Dados do Aluguel:\n" +
                "Filme: " + getDescricaoFilme() + "\n" +
                "Data do Aluguel: " + dataAluguelStr + "\n" +
                "Data de Devolução: " + dataDevolucaoStr + "\n" +
                "Valor do Aluguel: R$" + valorTotal + "\n" +
                "Status de Devolução: " + (devolvido ? "Devolvido" : "Pendente");
    }
}
