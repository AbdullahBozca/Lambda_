package lambda_ders;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lambda06 {
    public static void main(String[] args) throws IOException {
        //TASK 01 --> abdullah.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** abdullah.txt dosyasini okuyunuz -->  ");
        Files.
                lines(Paths.get("C:\\Users\\Bozca\\IdeaProjects\\Lambda_\\src\\lambda_ders\\abdullah.txt")).
                forEach(System.out::println);

        //TASK 02 --> abdullah.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** abdullah.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.
                lines(Paths.get("C:\\Users\\Bozca\\IdeaProjects\\Lambda_\\src\\lambda_ders\\abdullah.txt")).
                map(t->t.toUpperCase()).
                //map(String::toUpperCase()).
                forEach(System.out::println);

        //TASK 03 --> abdullah.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** abdullah.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        Files.
                lines(Paths.get("C:\\Users\\Bozca\\IdeaProjects\\Lambda_\\src\\lambda_ders\\abdullah.txt")).
                map(t->t.toLowerCase()).
                limit(1).
                forEach(System.out::println);

        //TASK 04 --> abdullah.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** abdullah.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.
                lines(Paths.get("C:\\Users\\Bozca\\IdeaProjects\\Lambda_\\src\\lambda_ders\\abdullah.txt")).
                filter(t -> t.contains("basari")).
                count());

        //TASK 05 --> abdullah.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** abdullah.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("C:\\Users\\Bozca\\IdeaProjects\\Lambda_\\src\\lambda_ders\\abdullah.txt")).
                map(t -> t.split(" ")).flatMap(Arrays::stream).
                distinct().
                collect(Collectors.toList()));


        //TASK 06 --> abdullah.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** abdullah.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("C:\\Users\\Bozca\\IdeaProjects\\Lambda_\\src\\lambda_ders\\abdullah.txt")).
                map(t -> t.split(" ")).flatMap(Arrays::stream).
                sorted().
                collect(Collectors.toList()));

        //TASK 07 --> abdullah.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** abdullah.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("C:\\Users\\Bozca\\IdeaProjects\\Lambda_\\src\\lambda_ders\\abdullah.txt")).
                map(t -> t.split(" ")).flatMap(Arrays::stream).
                filter(t -> t.equalsIgnoreCase("basari")).
                count());
        //TASK 08 --> abdullah.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** abdullah.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("C:\\Users\\Bozca\\IdeaProjects\\Lambda_\\src\\lambda_ders\\abdullah.txt")).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).
                count());
        //TASK 09 --> abdullah.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** abdullah.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("C:\\Users\\Bozca\\IdeaProjects\\Lambda_\\src\\lambda_ders\\abdullah.txt")).
                map(t -> t.split(" ")).flatMap(Arrays::stream).
                filter(t -> t.contains("a")).
                collect(Collectors.toList()));
        //TASK 10 --> abdullah.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** abdullah.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("C:\\Users\\Bozca\\IdeaProjects\\Lambda_\\src\\lambda_ders\\abdullah.txt")).
                map(t -> t.split("")).
                flatMap(Arrays::stream).
                distinct().
                count());
        //TASK 11 --> abdullah.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** abdullah.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("C:\\Users\\Bozca\\IdeaProjects\\Lambda_\\src\\lambda_ders\\abdullah.txt")).
                map(t -> t.split("")).
                flatMap(Arrays::stream).
                distinct().
                collect(Collectors.toList()));
    }
}
