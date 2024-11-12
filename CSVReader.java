import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static int[] readCSV(String filePath) throws IOException {
        ArrayList<Integer> dataList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        // Pula a primeira linha (cabeçalho)
        br.readLine();

        while ((line = br.readLine()) != null) {
            try {
                // Tenta converter a linha em um número inteiro
                int number = Integer.parseInt(line.trim());
                dataList.add(number);
            } catch (NumberFormatException e) {
                // Ignora linhas que não podem ser convertidas em números
                System.out.println("Linha ignorada (não é um número): " + line);
            }
        }
        br.close();

        // Converte ArrayList para array de int
        return dataList.stream().mapToInt(Integer::intValue).toArray();
    }
}
