import java.util.Vector;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class TrabalhoFinal {
    public static void main(String[] args) throws Exception {
        Vector<String> vector = new Vector<>();
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        String[] palavras = readWordsFromFile("C:\\Users\\Especial\\OneDrive\\Documentos\\Códigos\\Python\\Estrutura de Dados\\Trabalho Final de ED\\leipzig100k.txt");
        float tempoTotal = 0;

        // TEMPOS DE INSERÇÃO
        // ---------------------------------------------------------------------
        System.out.println("TEMPOS DE INSERÇÃO DE PALAVRAS ---------------------");
        long tempoInicial = System.nanoTime();
        for (String palavra : palavras) {
            vector.add(palavra);
        }
        long tempoFinal = System.nanoTime();
        System.out.println("Tempo decorrido para Vector: " + (tempoFinal - tempoInicial) + " ns");

        tempoInicial = System.nanoTime();
        for (String palavra : palavras) {
            linkedList.add(palavra);
        }
        tempoFinal = System.nanoTime();
        System.out.println("Tempo decorrido para LinkedList: " + (tempoFinal - tempoInicial) + " ns");

        tempoInicial = System.nanoTime();
        for (String palavra : palavras) {
            arrayList.add(palavra);
        }
        tempoFinal = System.nanoTime();
        System.out.println("Tempo decorrido para ArrayList: " + (tempoFinal - tempoInicial) + " ns");

        tempoInicial = System.nanoTime();
        for (String palavra : palavras) {
            hashSet.add(palavra);
        }
        tempoFinal = System.nanoTime();
        System.out.println("Tempo decorrido para HashSet: " + (tempoFinal - tempoInicial) + " ns");

        tempoInicial = System.nanoTime();
        for (String palavra : palavras) {
            linkedHashSet.add(palavra);
        }
        tempoFinal = System.nanoTime();
        System.out.println("Tempo decorrido para LinkedHashSet: " + (tempoFinal - tempoInicial) + " ns");

        tempoInicial = System.nanoTime();
        for (String palavra : palavras) {
            treeSet.add(palavra);
        }
        tempoFinal = System.nanoTime();
        System.out.println("Tempo decorrido para TreeSet: " + (tempoFinal - tempoInicial) + " ns");

        tempoInicial = System.nanoTime();
        for (String palavra : palavras) {
            hashMap.put(palavra, 0);
        }
        tempoFinal = System.nanoTime();
        System.out.println("Tempo decorrido para HashMap: " + (tempoFinal - tempoInicial) + " ns");

        tempoInicial = System.nanoTime();
        for (String palavra : palavras) {
            linkedHashMap.put(palavra, 0);
        }
        tempoFinal = System.nanoTime();
        System.out.println("Tempo decorrido para LinkedHashMap: " + (tempoFinal - tempoInicial) + " ns");

        tempoInicial = System.nanoTime();
        for (String palavra : palavras) {
            treeMap.put(palavra, 0);
        }
        tempoFinal = System.nanoTime();
        System.out.println("Tempo decorrido para TreeMap: " + (tempoFinal - tempoInicial) + " ns");

        String[] consultas = { "Lisbon", "NASA", "Kyunghee", "Konkuk", "Sogang", "momentarily", "rubella",
                "vaccinations", "government", "Authorities" };

        // TEMPOS DE CONSULTA
        // ---------------------------------------------------------------------
        System.out.println("\nTEMPOS DE CONSULTA ---------------------------------");

        System.out.println("# Vector: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            boolean resultado = vector.contains(consulta);
            tempoFinal = System.nanoTime();
            if (resultado) {
                System.out.println("Busca por '" + consulta + "' em Vector: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            } else {
                System.out
                        .println("'" + consulta + "' não encontrado em Vector: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            }
        }
        System.out.println("Tempo médio para Vector = " + tempoTotal / 10 + " ns\n");

        tempoTotal = 0;
        System.out.println("# LinkedList: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            boolean resultado = linkedList.contains(consulta);
            tempoFinal = System.nanoTime();
            if (resultado) {
                System.out
                        .println("Busca por '" + consulta + "' em LinkedList: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            } else {
                System.out.println(
                        "'" + consulta + "' não encontrado em LinkedList: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            }
        }
        System.out.println("Tempo médio para LinkedList = " + tempoTotal / 10 + " ns\n");

        tempoTotal = 0;
        System.out.println("# ArrayList: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            boolean resultado = arrayList.contains(consulta);
            tempoFinal = System.nanoTime();
            if (resultado) {
                System.out.println("Busca por '" + consulta + "' em ArrayList: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            } else {
                System.out.println(
                        "'" + consulta + "' não encontrado em ArrayList: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            }
        }
        System.out.println("Tempo médio para ArrayList = " + tempoTotal / 10 + " ns\n");

        tempoTotal = 0;
        System.out.println("# HashSet: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            boolean resultado = hashSet.contains(consulta);
            tempoFinal = System.nanoTime();
            if (resultado) {
                System.out.println("Busca por '" + consulta + "' em HashSet: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            } else {
                System.out.println(
                        "'" + consulta + "' não encontrado em HashSet: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            }
        }
        System.out.println("Tempo médio para HashSet = " + tempoTotal / 10 + " ns\n");

        tempoTotal = 0;
        System.out.println("# LinkedHashSet: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            boolean resultado = linkedHashSet.contains(consulta);
            tempoFinal = System.nanoTime();
            if (resultado) {
                System.out.println(
                        "Busca por '" + consulta + "' em LinkedHashSet: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            } else {
                System.out.println(
                        "'" + consulta + "' não encontrado em LinkedHashSet: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            }
        }
        System.out.println("Tempo médio para LinkedHashSet = " + tempoTotal / 10 + " ns\n");

        tempoTotal = 0;
        System.out.println("# TreeSet: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            boolean resultado = treeSet.contains(consulta);
            tempoFinal = System.nanoTime();
            if (resultado) {
                System.out.println("Busca por '" + consulta + "' em TreeSet: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            } else {
                System.out.println(
                        "'" + consulta + "' não encontrado em TreeSet: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            }
        }
        System.out.println("Tempo médio para TreeSet = " + tempoTotal / 10 + " ns\n");

        tempoTotal = 0;
        System.out.println("# HashMap: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            boolean resultado = hashMap.containsKey(consulta);
            tempoFinal = System.nanoTime();
            if (resultado) {
                System.out.println("Busca por '" + consulta + "' em HashMap: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            } else {
                System.out.println(
                        "'" + consulta + "' não encontrado em HashMap: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            }
        }
        System.out.println("Tempo médio para HashMap = " + tempoTotal / 10 + " ns\n");

        tempoTotal = 0;
        System.out.println("# LinkedHashMap: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            boolean resultado = linkedHashMap.containsKey(consulta);
            tempoFinal = System.nanoTime();
            if (resultado) {
                System.out.println(
                        "Busca por '" + consulta + "' em LinkedHashMap: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            } else {
                System.out.println(
                        "'" + consulta + "' não encontrado em LinkedHashMap: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            }
        }
        System.out.println("Tempo médio para LinkedHashMap = " + tempoTotal / 10 + " ns\n");

        tempoTotal = 0;
        System.out.println("# TreeMap: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            boolean resultado = treeMap.containsKey(consulta);
            tempoFinal = System.nanoTime();
            if (resultado) {
                System.out.println("Busca por '" + consulta + "' em TreeMap: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            } else {
                System.out.println(
                        "'" + consulta + "' não encontrado em TreeMap: " + (tempoFinal - tempoInicial) + " ns");
                tempoTotal += (tempoFinal - tempoInicial);
            }
        }
        System.out.println("Tempo médio para TreeMap = " + tempoTotal / 10 + " ns\n");

        // TEMPOS DE REMOÇÃO
        // ---------------------------------------------------------------------
        System.out.println("\nTEMPOS DE REMOÇÃO ----------------------------------");

        // LinkedList
        tempoTotal = 0;
        System.out.println("# LinkedList: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            linkedList.remove(consulta);
            tempoFinal = System.nanoTime();
            System.out.println("Remoção de '" + consulta + "' em LinkedList: " + (tempoFinal - tempoInicial) + " ns");
            tempoTotal += (tempoFinal - tempoInicial);
        }
        System.out.println("Tempo médio para LinkedList = " + tempoTotal / 10 + " ns\n");

        // ArrayList
        tempoTotal = 0;
        System.out.println("# ArrayList: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            arrayList.remove(consulta);
            tempoFinal = System.nanoTime();
            System.out.println("Remoção de '" + consulta + "' em ArrayList: " + (tempoFinal - tempoInicial) + " ns");
            tempoTotal += (tempoFinal - tempoInicial);
        }
        System.out.println("Tempo médio para ArrayList = " + tempoTotal / 10 + " ns\n");

        // HashSet
        tempoTotal = 0;
        System.out.println("# HashSet: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            hashSet.remove(consulta);
            tempoFinal = System.nanoTime();
            System.out.println("Remoção de '" + consulta + "' em HashSet: " + (tempoFinal - tempoInicial) + " ns");
            tempoTotal += (tempoFinal - tempoInicial);
        }
        System.out.println("Tempo médio para HashSet = " + tempoTotal / 10 + " ns\n");

        // LinkedHashSet
        tempoTotal = 0;
        System.out.println("# LinkedHashSet: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            linkedHashSet.remove(consulta);
            tempoFinal = System.nanoTime();
            System.out
                    .println("Remoção de '" + consulta + "' em LinkedHashSet: " + (tempoFinal - tempoInicial) + " ns");
            tempoTotal += (tempoFinal - tempoInicial);
        }
        System.out.println("Tempo médio para LinkedHashSet = " + tempoTotal / 10 + " ns\n");

        // TreeSet
        tempoTotal = 0;
        System.out.println("# TreeSet: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            treeSet.remove(consulta);
            tempoFinal = System.nanoTime();
            System.out.println("Remoção de '" + consulta + "' em TreeSet: " + (tempoFinal - tempoInicial) + " ns");
            tempoTotal += (tempoFinal - tempoInicial);
        }
        System.out.println("Tempo médio para TreeSet = " + tempoTotal / 10 + " ns\n");

        // HashMap
        tempoTotal = 0;
        System.out.println("# HashMap: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            hashMap.remove(consulta);
            tempoFinal = System.nanoTime();
            System.out.println("Remoção de '" + consulta + "' em HashMap: " + (tempoFinal - tempoInicial) + " ns");
            tempoTotal += (tempoFinal - tempoInicial);
        }
        System.out.println("Tempo médio para HashMap = " + tempoTotal / 10 + " ns\n");

        // LinkedHashMap
        tempoTotal = 0;
        System.out.println("# LinkedHashMap: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            linkedHashMap.remove(consulta);
            tempoFinal = System.nanoTime();
            System.out
                    .println("Remoção de '" + consulta + "' em LinkedHashMap: " + (tempoFinal - tempoInicial) + " ns");
            tempoTotal += (tempoFinal - tempoInicial);
        }
        System.out.println("Tempo médio para LinkedHashMap = " + tempoTotal / 10 + " ns\n");

        // TreeMap
        tempoTotal = 0;
        System.out.println("# TreeMap: ");
        for (String consulta : consultas) {
            tempoInicial = System.nanoTime();
            treeMap.remove(consulta);
            tempoFinal = System.nanoTime();
            System.out.println("Remoção de '" + consulta + "' em TreeMap: " + (tempoFinal - tempoInicial) + " ns");
            tempoTotal += (tempoFinal - tempoInicial);
        }
        System.out.println("Tempo médio para TreeMap = " + tempoTotal / 10 + " ns\n");

    }

    private static String[] readWordsFromFile(String filename) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        return content.split("\\s+|\\d+|\\p{Punct}");
    }
}
