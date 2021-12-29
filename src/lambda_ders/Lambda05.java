package lambda_ders;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println("1'den x'e kadar cift tamsayilari toplayan bir program yaziniz");
        System.out.println(toplaCift(10));
        System.out.println(toplaCift2(10));

    }
    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program yaziniz.
//Structured Programming
    public static int topla(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam +=i;
        }
        return toplam;
    }
    //Functional Programming
    public static int topla1(int x) {

        return IntStream.range(1,x+1).//1 2 3 ... x elemanarinin akısı
                sum();
    }
    public static int topla2(int x){
        return IntStream.rangeClosed(1,x).
                sum();
    }

//TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
    public static int toplaCift(int x){
        return IntStream.rangeClosed(1,x).
                filter(Lambda01::ciftBul).
                sum();
    }
    public static int toplaCift2(int x){
        return IntStream.iterate(2,t->t+2).
                limit(x).
                sum();
    }


//TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz


//TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz

//TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz

//TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz

//TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz
}
