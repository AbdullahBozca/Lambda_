package lambda_ders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("mehmet", "emre", "nilgun", "yildız", "kader", "emine", "islam", "islam", "emre", "abdullah"));
        System.out.println("list elemanlarını alfabetik büyük harf sırasıyla ve tekrarsız yazdırınız");
        alfabetikTekrarsiz(list);
        System.out.println("list elemanları karakter sayısını ters sıralı tekrarsız yazdırınız");
        karakterSayisiTersTekrarsız(list);
        System.out.println("list elemanlarını karakter sayısına küçükten büyüğe göre yazdırınız");
        karakterSayisiKckByk(list);
        System.out.println("list elemanlarını son harfine göre ters sıralı yazdırın");
        sonHarfTersSıralı(list);
        System.out.println("çift sayılı elemanların karelerini hesaplayan, tekrarsiz büyükten küçüğe sıralı yazdırınız");
        ciftElemanTekrasizBykKck(list);
        System.out.println("karakter sayısı en büyük elemanı yazınız");
        karakterSayisiEnByk(list);
        System.out.println("karakter sayısı en büyük elemanı yazınız");
        karakterSayisiEnByk2(list);
    }

    //list elemanlarını alfabetik büyük harf sırasıyla ve tekrarsız yazdırınız
    public static void alfabetikTekrarsiz(List<String> list) {
        list.
                stream().
                //map(t->t.toUpperCase()).
                        map(String::toUpperCase).
                sorted().
                distinct().
                forEach(System.out::println);
    }

    //list elemanları karakter sayısını ters sıralı tekrarsız yazdırınız
    public static void karakterSayisiTersTekrarsız(List<String> list) {
        list.
                stream().
                map(t -> t.length()).
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(Lambda01::printEl);
    }

    //list elemanlarını karakter sayısına küçükten büyüğe göre yazdırınız
    public static void karakterSayisiKckByk(List<String> list) {
        list.
                stream().
                sorted(Comparator.comparing(t -> t.length())).
                forEach(System.out::println);
    }

    //list elemanlarını son harfine göre ters sıralı yazdırın
    public static void sonHarfTersSıralı(List<String> list) {
        list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length() - 1)).reversed()).
                forEach(System.out::println);
    }

    //çift sayılı elemanların karelerini hesaplayan, tekrarsiz büyükten küçüğe sıralı yazdırınız
    public static void ciftElemanTekrasizBykKck(List<String> list) {
        list.
                stream().
                map(t -> t.length() * t.length()).
                filter(Lambda01::ciftBul).
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(Lambda01::printEl);
    }

    //List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz
    public static void harfSayisi7Kontrol(List<String> list) {
        // boolean  kontrol=  list.stream().
        //     allMatch(t->t.length()<=7);//her bir elemanı harf syisini <=7 ye eslesmesine bakti
        //    if (kontrol ) {
        //        System.out.println("list elemanlari 7 harfden buyuk degil");

        //    }else{
        //        System.out.println("AGAM list elemanlari 7 harfden BUYUK ");
        //    }
        //System.out.println(kontrol);
        System.out.println(list.stream().allMatch(t -> t.length() <= 7) ? "list elemanlari 7 harfden buyuk degil" : "AGAM list elemanlari 7 harfden BUYUK ");
    }

    //List elelmanlarinin "W" ile baslamasını kontrol ediniz
    public static void wBaslamaKontrol(List<String> list) {
        System.out.println(list.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile baslayan isim kimse ayaga kalksin" : "AGAM w ile baslayan isim oluuuurrr ");


    }

    //List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz
    public static void xbitmeKontrol(List<String> list) {
        System.out.println(list.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "x ile biten isim kimse ayaga kalksin" : "AGAM x ile biten isim oluuuurrr ");
        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
    }

    //karakter sayısı en büyük elemanı yazınız
    public static void karakterSayisiEnByk(List<String> list) {
        System.out.println(list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).//karakter uzunluğuna göre sıralar
                //findFirst());//ilk elemanı aldı
                limit(1));//limit(a) akıştan çıkan elemanları a parameteresine göre sınırlandırır.
    }
    //karakter sayısı en büyük elemanı yazınız
    public static void karakterSayisiEnByk2(List<String> list) {
        Stream<String> sonIsim = list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).//karakter uzunluğuna göre sıralar
                //findFirst());//ilk elemanı aldı
                        limit(1);//limit(a) akıştan çıkan elemanları a parameteresine göre sınırlandırır.
        System.out.println(sonIsim);
    }
}
