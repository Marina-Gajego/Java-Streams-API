package br.com.letscode.java;

import entidade.Arquivo;
import entidade.ComparatorIdade;
import entidade.Oscar;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static Arquivo leituraArquivo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        System.out.println("1- Quem foi o ator mais jovem a ganhar um Oscar");
        System.out.println("2- Quem foi a atriz que mais vezes foi premiada?");
        System.out.println("3- Qual atriz entre 20 e 30 anos que mais vezes foi vencedora?");
        System.out.println("4- Quais atores ou atrizes receberam mais de um Oscar? Elabore uma única estrutura contendo atores e atrizes.");
        System.out.println("5- Quando informado o nome de um ator ou atriz, dê um resumo de quantos prêmios ele/ela recebeu e liste ano, idade e nome de cada filme pelo qual foi premiado(a).");
        op = sc.nextInt();
        menu(op);
    }

    private static void menu(int op){
        int esc = 0;
        Scanner sc = new Scanner(System.in);
        switch(op){
            case 1:
                leituraArquivo = new Arquivo("homem.csv");
                maisjovem();
                break;
            case 2:
                leituraArquivo = new Arquivo("mulher.csv");
                maisganhou();
                break;
            case 3:
                leituraArquivo = new Arquivo("mulher.csv");
                ganhouentreidade();
                break;
            case 4:
                System.out.println("Deseja saber da atriz ou do ator? 1- Atriz || 2- Ator");
                esc = sc.nextInt();
                if(esc == 1){
                    leituraArquivo = new Arquivo("mulher.csv");
                    maisdeumoscar();
                }else{
                    leituraArquivo = new Arquivo("homem.csv");
                    maisdeumoscar();
                }
                break;
            case 5:
                System.out.println("Deseja saber da atriz ou do ator? 1- Atriz || 2- Ator");
                esc = sc.nextInt();
                if(esc == 1){
                    leituraArquivo = new Arquivo("mulher.csv");
                    pesquisa();
                }else{
                    leituraArquivo = new Arquivo("homem.csv");
                    pesquisa();
                }
                break;
            default:
                System.out.println("OPÇÂO INVALIDA");
        }
    }

    private  static  void maisjovem(){
        System.out.println("\nAtriz mais jovem a ganhar o Oscar: ");
        List<Oscar> oscarList = leituraArquivo.getOscarList();
        oscarList.sort(new ComparatorIdade());
        System.out.println(oscarList.get(0));
    }

    private static void maisganhou() {
        System.out.println("\nAtriz que mais ganhou oscars");
        List<Oscar> oscarList = leituraArquivo.getOscarList();
        Map<String, Long> map = oscarList.stream()
                .map(Oscar::getNome)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(c -> System.out.println("A atriz com mais oscar é " + c.getKey() + " - " + c.getValue() + " Oscar"));
    }

    private static void ganhouentreidade() {
        System.out.println("\nAtriz que mais ganhou oscars entre 20 e 30 anos");
        List<Oscar> oscarList = leituraArquivo.getOscarList();
        Map<String, Long> map = oscarList.stream()
                .filter(oscar -> oscar.getIdade() >= 20 && oscar.getIdade() <= 30)
                .map(Oscar::getNome)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(c -> System.out.println("A atriz com mais oscar entre 20 e 30 anos é" + c.getKey() + " - " + c.getValue() + " Oscar"));
    }

    private static void maisdeumoscar(){
    }

    private static void pesquisa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do ator ou atriz: ");
        String nome = sc.nextLine();
        List<Oscar> oscarList = leituraArquivo.getOscarList();
        oscarList.stream()
                .filter(oscar -> oscar.getNome().equals(nome))
                .forEach(System.out::println);
    }

}
