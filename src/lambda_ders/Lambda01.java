package lambda_ders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {
    /*
   1) Lambda "Functional Programming"
      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
   ve hatasiz code yazma acilarindan cok faydalidir.
   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
      Lambda kullanmak hatasız code kullanmaktır.
*/
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));
        System.out.println("\nstructured");
        print(list);
        System.out.println("\nfunctional");
        printFunctional(list);
        System.out.println("\nfunctional");
        printFunctional1(list);
        System.out.println("\nstructured");
        printCift(list);
        System.out.println("\nfunctional");
        printCift1(list);
        System.out.println("\nfunctional");
        printCift2(list);
        System.out.println("\nfunctional");
        printCift3(list);
        System.out.println("\nfunctional");
        printTek(list);
        System.out.println("\nfunctional");
        ciftKare(list);
        System.out.println("\nfunctional");
        printTekKup(list);
        System.out.println("\nfunctional");
        ciftKareKok(list);
        System.out.println("\nfunctional");
        enBuyuk(list);

    }
    //structured Programming ile list elemanlerinin  tamamini aralarina bosluk birakarak yazdiriniz
    public static  void print(List<Integer> list){
        for (Integer w:list) {
            System.out.print(w+" ");
        }
    }
    //Functional Programming ile list elemanlerinin  tamamini aralarina bosluk birakarak yazdiriniz
    public static void printFunctional(List<Integer> list){
        list.stream().forEach(t->System.out.print(t+" "));
        //stream dataları yukarıdan aşağı akış haline getirir
        //forEach datanın elemanına göre her bir elemanı getirir
        //t-> lambda operatörü
        //lambda Expresion yapısı çok taviye edilmez bunun yerine method reference kullanılır
        //method reference---> kenfi creat ettiğimiz veya javadan aldığımı method ile
        // classname::methodname


    }
    public static void printEl(int t){//refere edilece method creat edin
        System.out.print(t+" ");
    }
    public static void printFunctional1(List<Integer> list){
        list.stream().forEach(Lambda01::printEl);
    }
    //structured Programming ile list elemanlerinin  cift olanalrini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printCift(List<Integer> list){
        for (Integer w:list) {
            if (w%2==0){
                System.out.print(w+" ");
            }
        }
    }
    //Functional Programming ile list elemanlerinin  cift olanalrini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printCift1(List<Integer> list){
        list.stream().filter(t->t%2==0).forEach(Lambda01::printEl);
        //bir akış içindeki elemanları istenen şarta göre filtreleme yapar
    }
    public static boolean ciftBul(int i){// refere edilecek tohum method creat edildi

    return i%2==0;
    }
    public static void printCift2(List<Integer> list){
        list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl);
    }
    //Functional Programming ile list elemanlerinin  cift olanalrini 60 dan küçük olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz-
    public static void printCift3(List<Integer> list){
        list.stream().filter(t->t%2==0 && t<60).forEach(Lambda01::printEl);
    }
    //Functional Programming ile list elemanlerinin  tek olanlarini veya 20 den büyük olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz-
    public static void printTek(List<Integer> list){
        list.stream().filter(t->t%2!=0 || t>20).forEach(Lambda01::printEl);
    }
    //Functional Programming ile list elemanlerinin  cift olanalrini karelerini ayni satirda aralarina bosluk birakarak yazdiriniz-
    public static void ciftKare(List<Integer> list){
        list.stream().filter(Lambda01::ciftBul).map(t->t*t).forEach(Lambda01::printEl);
        //map()--> bir ara islemde kullanilir.elemanları istenen isleme gore degistirmek update etmek icin kullanilir.
    }
    //Functional Programming ile list elemanlerinin  tek olanalrini küplerinin 1 fazlasın ayni satirda aralarina bosluk birakarak yazdiriniz-
    public static void printTekKup(List<Integer> list){
        list.stream().filter(t->t%2==1).map(t->t*t*t+1).forEach(Lambda01::printEl);
    }
    //Functional Programming ile list elemanlerinin  cift olanalrini karekökleri ayni satirda aralarina bosluk birakarak yazdiriniz-
    public static void ciftKareKok(List<Integer>list){
        list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t->System.out.print(t+" "));
    }
    //list in en büyük elemanını yazdırınız
    public static void enBuyuk(List<Integer> list){
    Optional<Integer> maxDeger= list.stream().reduce(Math::max);
        System.out.println(maxDeger);
    }



}
