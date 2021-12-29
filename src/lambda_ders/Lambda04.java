package lambda_ders;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    public static void main(String[] args) {
        TechPro trGunduz = new TechPro("yaz", "TR Gunduz", 97, 124);
        TechPro engGunduz = new TechPro("kis", "ENG gunduz", 95, 131);
        TechPro trGece = new TechPro("bahar", "TR gece", 98, 143);
        TechPro engGece = new TechPro("sonbahar", "ENG gece", 93, 151);

        List<TechPro> list = new ArrayList<>(Arrays.asList(trGunduz, engGunduz, trGece, engGece));
        //bu class ta ağırlıklı olarak return type çalışalacak
        System.out.println("bacth ort 92 den büyük olanları döndüren");
        System.out.println(batchOrt92Byk(list));
        System.out.println("ogrc sayilarinin hic birinin  110 den az olmadigini  kontrol eden pr create ediniz.");
        System.out.println(batchSayisi110Az(list));
        System.out.println("batchlerden herhangi birinde bahar olup olmadığını kontrol edin");
        System.out.println(batchBahar(list));
        System.out.println("batch leri öğrenci sayısına göre büyükten küçüğe sıralayınız");
        System.out.println(ogrSayisiSirala(list));
        System.out.println("batch leri batch ortalamasına göre büyükten küçüüğe sıralayıp ilk 3 ü yazdıran");
        System.out.println(batchOrtIlkUc(list));
        System.out.println(" batch lerdeki öğrenci sayısı en az olan 2. batch i yazdırınız");
        System.out.println(ogrSayisiGoreIkinci(list));
        System.out.println("batch ort 95 den büyük olan ogr sayıları toplamını bulunuz");
        System.out.println(ort95BykOgrSayilariToplamı(list));
        System.out.println("batch ort 95 den büyük olan ogr sayıları toplamını bulunuz");
        System.out.println(ort95BykOgrSayilariToplamı1(list));
        System.out.println("ogr sayıları 130 dan büyük olan batch lerin batch ort bulunuz");
        System.out.println(ogr130BykBatchOrt(list));


    }
    //task 01-->bacth ort 92 den büyük olanları döndüren
    public static boolean batchOrt92Byk(List<TechPro> list) {
        return list.
                stream().
                allMatch(t -> t.getBatchOrt() > 92);//akıştaki her eleman batchort field a göre eşleşmesi kontrol etti
    }
    //task 02-->ogrc sayilarinin hic birinin  110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean batchSayisi110Az(List<TechPro> list) {
        return list.
                stream().
                noneMatch(t -> t.getOgrcSayisi() > 110);
    }
    //task 03--> batchlerden herhangi birinde bahar olup olmadığını kontrol edin
    public static boolean batchBahar(List<TechPro> list) {
        return list.
                stream().
                anyMatch(t -> t.getBatch().equals("bahar"));
    }
    //task 04--> batch leri öğrenci sayısına göre büyükten küçüğe sıralayınız
    public static List<TechPro> ogrSayisiSirala(List<TechPro> list) {
        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi).reversed()).
                collect(Collectors.toList()); //collect metodu akıştaki elamanları istenen şarta göre toplar
                                            //(Collectors.toList())  collect te toplanan elemanları list e toplar
    }
    //task 05-->batch leri batch ortalamasına göre büyükten küçüüğe sıralayıp ilk 3 ü yazdıran
    public static List<TechPro> batchOrtIlkUc(List<TechPro> list){
        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getBatchOrt).reversed()).
                limit(3).
                collect(Collectors.toList());
    }
    //task 06--> batch lerdeki öğrenci sayısı en az olan 2. batch i yazdırınız
    public static List<TechPro> ogrSayisiGoreIkinci(List<TechPro> list){
        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi)).
                limit(2).
                skip(1).
                collect(Collectors.toList());
    }
    //task 07--> batch ort 95 den büyük olan ogr sayıları toplamını bulunuz
    public static int ort95BykOgrSayilariToplamı(List<TechPro> list){
      return   list.
                stream().
                filter(t->t.getBatchOrt()>95).
                map(t->t.getOgrcSayisi()).
                //reduce(0,Integer::sum);
                reduce(0,(t,u)->t+u);
    }
    public static int ort95BykOgrSayilariToplamı1(List<TechPro> list){
        return   list.
                stream().
                filter(t->t.getBatchOrt()>95).
                mapToInt(t->t.getOgrcSayisi()). //mapToInt tipine göre int return eder ve sum methodu çalışır
                sum();
    }
    // task 08--> ogr sayıları 130 dan büyük olan batch lerin batch ort bulunuz
    public static OptionalDouble ogr130BykBatchOrt(List<TechPro> list){
         return list.
                stream().
                filter(t->t.getOgrcSayisi()>130).
                mapToDouble(t->t.getBatchOrt()).
                average();

    }
}
