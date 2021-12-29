package lambda_ders;

import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, -3, 7, 34, 22, -60, 42, 15));
        ciftKareEn(list);
        System.out.println("list'teki tüm elemanların toplamını yazdırırız(lambda  expression)");
        toplam1(list);
        System.out.println("list'teki tüm elemanların toplamını yazdırırız(method reference)");
        toplam2(list);
        System.out.println("list teki cift elemanların çarpımını yazdırınız(method reference)");
        ciftCarpım(list);
        System.out.println("list teki cift elemanların çarpımını yazdırınız(lambda  expression)");
        ciftCarpim2(list);
        System.out.println("list'teki elemanlardan en küçüğünün 4 farklı yöntemle yazdırınız(Integer class)");
        minEleman(list);
        System.out.println("list'teki elemanlardan en küçüğünün 4 farklı yöntemle yazdırınız(Math class)");
        minEleman2(list);
        System.out.println("list'teki elemanlardan en küçüğünün 4 farklı yöntemle yazdırınız");
        minEleman3(list);
        System.out.println("List'teki 15'ten buyuk en kucuk tek sayiyi yazdiriniz");
        onBesBuyukEnKucukTekSayi(list);
        System.out.println("list in çift elemanlarını karelerini küçükten büyüğe  yazdırınız");
        ciftBuyuktenKucuge(list);
        System.out.println();
        System.out.println("list'in tek  elemanlarinin kareleri ni buyukten kucuge  yazdiriniz");
        tekKareBuyuktenKucuge(list);
    }

    //list'in çift olan elemanların karelerini alınız ve en büyüğünü yazdıran
    public static void ciftKareEn(List<Integer> list) {
        Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        System.out.print(maxEl);
        System.out.println();
    }

    //list'teki tüm elemanların toplamını yazdırırız(lambda  expression)
    public static void toplam1(List<Integer> list) {
        int toplam = list.stream().reduce(0, (x, y) -> x + y);
       /*
            x her zaman ilk değerini atanan değerden alır.
            y her zaman değerini list.stream() den alır
            x ilk değerden sonraki değerlerini işlemden alır
        */
        System.out.println(toplam);
    }

    //list'teki tüm elemanların toplamını yazdırırız(method reference)
    public static void toplam2(List<Integer> list) {
        Optional<Integer> toplam = list.stream().reduce(Integer::sum);
        Optional<Integer> toplam2 = list.stream().reduce(Math::addExact);

        System.out.println(toplam);
        System.out.println(toplam2);
    }

    //list teki cift elemanların çarpımını yazdırınız(method reference)
    public static void ciftCarpım(List<Integer> list) {
        Optional<Integer> carpim = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
        System.out.println(carpim);
    }

    //list teki cift elemanların çarpımını yazdırınız(lambda  expression)
    public static void ciftCarpim2(List<Integer> list) {
        int carpim = list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> x * y);
        System.out.println(carpim);
    }

    //list'teki elemanlardan en küçüğünün 4 farklı yöntemle yazdırınız
    //method reference-Integer class
    public static void minEleman(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Integer::min);
        System.out.println(min);
    }

    //list'teki elemanlardan en küçüğünün 4 farklı yöntemle yazdırınız
    //method reference-Math class
    public static void minEleman2(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Math::min);
        System.out.println(min);
    }

    //list'teki elemanlardan en küçüğünün 4 farklı yöntemle yazdırınız
    //method reference
    public static int minBul(int a, int b) {
        return a < b ? a : b;
    }

    public static void minEleman3(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Lambda02::minBul);
        System.out.println(min);
    }

    //list'teki elemanlardan en küçüğünün 4 farklı yöntemle yazdırınız
    //lambda expression
    public static void minEleman4(List<Integer> list) {
        Integer min = list.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
        System.out.println(min);
    }

    //List'teki 15'ten buyuk en kucuk tek sayiyi yazdiriniz
    public static void onBesBuyukEnKucukTekSayi(List<Integer> list){
        /*list.
                stream().
                filter(t->t%2==1).
                filter(t->t>15).
                reduce(Integer::min);

         */
        System.out.println(list.
                stream().
                filter(t->t%2==1 & t>15).
                reduce(Integer::min));

    }

    //list in çift elemanlarını karelerini küçükten büyüğe  yazdırınız
    public static void ciftBuyuktenKucuge(List<Integer> list){

        list.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                sorted().
                forEach(Lambda01::printEl);
    }

    //list'in tek  elemanlarinin kareleri ni buyukten kucuge  yazdiriniz
    public static void tekKareBuyuktenKucuge(List<Integer> list){
        list.
                stream().
                filter(t->t%2!=0).
                map(t->t*t).
                sorted(Comparator.reverseOrder()).
                forEach(Lambda01::printEl);
    }








}
