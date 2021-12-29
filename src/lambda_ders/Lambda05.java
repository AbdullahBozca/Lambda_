package lambda_ders;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println("1'den x'e kadar cift tamsayilari toplayan bir program yaziniz");
        System.out.println(toplaCift(10));
        System.out.println("Ilk x pozitif cift sayiyi toplayan program yaziniz");
        System.out.println(ilkXPozitifCiftTopla(10));
        System.out.println("Ilk X pozitif tek tamsayiyi toplayan programi yaziniz");
        System.out.println(ilkXPozitifTekTopla(10));
        System.out.println("2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz");
        ikininIlkXKuvveti(5);
        System.out.println();
        System.out.println("Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz");
        sayininIlkXKvt(2, 6);
        System.out.println("Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi yaziniz");
        System.out.println(istenenSayiniXincikuvvet(2, 6));
        System.out.println("Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz");
        System.out.println(faktoriyel(5));


    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program yaziniz.
//Structured Programming
    public static int topla(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional Programming
    public static int topla1(int x) {

        return IntStream.range(1, x + 1).//1 2 3 ... x elemanarinin akısı
                sum();
    }

    public static int topla2(int x) {
        return IntStream.rangeClosed(1, x).
                sum();
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
    public static int toplaCift(int x) {
        return IntStream.rangeClosed(1, x).
                filter(Lambda01::ciftBul).
                sum();
    }


    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz
    public static int ilkXPozitifCiftTopla(int x) {
        return IntStream.iterate(2, t -> t + 2).
                limit(x).
                sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz
    public static int ilkXPozitifTekTopla(int x) {
        return IntStream.iterate(1, t -> t + 2).
                limit(x).
                sum();
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz
    public static void ikininIlkXKuvveti(int x) {
        IntStream.iterate(2, t -> t * 2).
                limit(x).
                forEach(Lambda01::printEl);

    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
    public static void sayininIlkXKvt(int x, int y) {
        IntStream.iterate(x, t -> t * x).
                limit(y).
                forEach(Lambda01::printEl);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz
    public static OptionalInt faktoriyel(int x) {
        return IntStream.rangeClosed(1, x).
                reduce(Math::multiplyExact);
                //reduce(1,(t,u)->t*u);
    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi yaziniz
    public static int istenenSayiniXincikuvvet(int a, int x) {

        return IntStream.iterate(a, t -> t * a).//a a^2 a^3 a^4... x elemanarinin akısı
                limit(x).//akısdaki ilk x elamanı verir
                reduce(0, (t, u) -> u);
    }
}
