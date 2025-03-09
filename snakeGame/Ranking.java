import java.io.*;
import java.util.*;

public class Ranking {

    public List<List<Object>> extraiRanking() {
        String nomeArquivo = "ranking.txt";
        List<List<Object>> ranking = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length < 2) continue; // Evita erros em linhas mal formatadas
                
                String nome = partes[0];
                int pontuacao;
                try {
                    pontuacao = Integer.parseInt(partes[1]);
                } catch (NumberFormatException e) {
                    continue; // Ignora entradas inválidas
                }

                ranking.add(Arrays.asList(nome, pontuacao));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Ordena pelo segundo item (pontuação) em ordem decrescente
        ranking.sort((lista1, lista2) -> Integer.compare((int) lista2.get(1), (int) lista1.get(1)));

        return ranking; // ✅ Agora o método retorna a lista corretamente
    }

    // ✅ Método para obter os 5 melhores jogadores
    public List<String> getTop5Ranking() {
        List<List<Object>> ranking = extraiRanking();
        List<String> top5 = new ArrayList<>();

        int limite = Math.min(5, ranking.size()); // Se houver menos de 5 jogadores, usa o total disponível
        for (int i = 0; i < limite; i++) {
            String nome = (String) ranking.get(i).get(0);
            int pontuacao = (int) ranking.get(i).get(1);
            top5.add(nome + " - " + pontuacao);
        }

        return top5;
    }
}
