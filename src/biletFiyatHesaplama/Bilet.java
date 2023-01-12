package biletFiyatHesaplama;

public class Bilet {
    public int distance;

    public int typeNo;

    public double price;

    public int seatNo;

    public void printBilet(Bus bus){
        System.out.println("Toplam Tutar : "+price);
        System.out.println("----Bilet Detay----");
        System.out.println("Otobus Plakasi : "+bus.numberPlate);
        System.out.println("Mesafe : "+ distance);
        System.out.println("Yolculuk tipi : "+ (typeNo==1 ? "Tek Yon" : "Gidis-Donus"));
        System.out.println("Koltuk No : " +seatNo);
        System.out.println("Keyifli Yolculuklar Dileriz...");
    }

}




