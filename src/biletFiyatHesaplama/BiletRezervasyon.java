package biletFiyatHesaplama;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BiletRezervasyon {
    /*
Project: mesafeye ve şartlara göre otobus bileti fiyatı hesaplayan uygulama
        Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş)
        koltuk no  bilgilerini alın.
        Mesafe başına ücret 1 TL / km olarak alın.(Gidiş-Dönüş için *2)
        İlk olarak yolculugun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki kuralları uygulayın ;

       Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
       Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
      1- Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
      2-Yaş indirimi:
       Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
       Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
       Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
      3-Tekli Koltuk ücreti:
       Koltuk numarası 3 veya 3 ün katı ise bilet fiyatı %20 artırılır.

*/
    public static void main(String[] args) {
        List<String> seatNo = new ArrayList<>();
        for (int i = 1; i <33 ; i++) {
            seatNo.add(String.valueOf(i));//["1","2",....]


        }
        Bilet bilet = new Bilet();
        Bus bus = new Bus("34 IST 78",seatNo);
        start(bilet,bus);



    }
    public static void start(Bilet bilet, Bus bus){
        Scanner input = new Scanner(System.in);
        int select;

        do {
            System.out.println("Bilet Rezervasyon Sistemine Hosgeldiniz");
            System.out.println("Lutfen Gideceginiz Mesafeyi KM Olarak Giriniz : ");
            bilet.distance = input.nextInt();
            System.out.println("");
            System.out.println("Lutfen Yasinizi Giriniz : ");
            int age = input.nextInt();
            System.out.println("Lutfen Yolculuk Tipini Seciniz : ");
            System.out.println("1) Tek Yon \n2) Gidis-Donus");
            bilet.typeNo= input.nextInt();
            System.out.println("Koltuk No Seciniz : ");
            System.out.println("Tekli Koltuk Fiyatlari Ciftli Koltuk Fiyatlarindan %20 Daha Fazladir!");
            System.out.println(bus.seats);
            bilet.seatNo= input.nextInt();
            bus.seats.remove(String.valueOf(bilet.seatNo));//"3"
            boolean check =  bilet.typeNo==1||bilet.typeNo==2;
            //boolean check =  (bilet.typeNo==1||bilet.typeNo==2)&&bilet.distance>0 && age>0 ;

            if (bilet.distance>0 && age>0 && check){
                bilet.price=getTotal(bilet,age);
                bilet.printBilet(bus);

            }else {
                System.out.println("Hatali Giris Yaptiniz!");
            }
            System.out.println("Yeni Islem Icin 1, Cikis Icin 0 Giriniz");
            select=input.nextInt();

        }while (select!=0);
        System.out.println("Iyi Gunler Dileriz...");

    }
    public static double getTotal(Bilet bilet, int age){
        double total = 0;
        int dist = bilet.distance;
        int seatNo = bilet.seatNo;
        int type = bilet.typeNo;

        switch (type){
            case 1:
                if (seatNo%3==0){
                    total=dist*1.2;
                }else {
                    total =dist*1;
                }
                System.out.println("Tutar : "+total);
                break;

            case 2:
                if (seatNo%3==0) {
                    total = dist * 2.4;
                }else {
                    total=dist*2;
                }
                System.out.println("Tutar : "+total);
                total = total*0.8;
                System.out.println("Cift Yon Indirimli Tutar");
                break;
        }
        if (age<=12){
            total=total/2;
            System.out.println("Yas Indirimli Tutar : "+total);
        }else if (age>12 && age<=24){
            total=total*0.9;
            System.out.println("Yas Indirimli Tutar : "+total);
        }else if (age>65){
            total = total*0.7;
            System.out.println("Yas Indirimli Tutar : "+total);
        }

        return total;

    }

}
