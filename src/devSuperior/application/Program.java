package devSuperior.application;

import devSuperior.entities.Lesson;
import devSuperior.entities.Task;
import devSuperior.entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        List<Lesson> list = new ArrayList<>();

        Locale.setDefault(Locale.ENGLISH);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas aulas tem o curso? ");
        int n  = sc.nextInt();
        System.out.println();
        for (int i = 1; i <=n ; i++) {
            System.out.println("Dados da " + i + "a aula: ");
            System.out.print("Conteúdo ou Tarefa (c/t)? ");
            char opt = sc.next().charAt(0);
            System.out.print("Título: ");
            String title = sc.nextLine();
            sc.nextLine();
            if ( opt == 'c'){
                System.out.print("URL do video: ");
                String url = sc.nextLine();
                System.out.print("Duracao em segundos: ");
                Integer seconds = sc.nextInt();

                list.add(new Video(title, url, seconds));
            }else {
                System.out.print("Descricao: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questoes: ");
                Integer questionCount = sc.nextInt();

                list.add(new Task(title,description,questionCount));
            }
            System.out.println();
        }

        Double sum = 0.0;
        for (Lesson lesson : list) {
            double result = lesson.duration();
            sum += result;
        }
        System.out.println();
        System.out.println("DURACAO TOTAL DO CURSO = " + String.format("%.2f",sum));

        sc.close();
    }
}
