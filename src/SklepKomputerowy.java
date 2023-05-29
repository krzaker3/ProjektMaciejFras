import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SklepKomputerowy {
    public void main() {
        Scanner input = new Scanner(System.in);
        //wypisanie wszystkich możliwych kategori
        System.out.println("Witaj w sklepie komputerowym!");
        System.out.println("Dostępne komponenty:");
        System.out.println("1) Procesor");
        System.out.println("2) Płyta główna");
        System.out.println("3) RAM");
        System.out.println("4) Karta graficzna");
        System.out.println("5) Dysk");
        System.out.println("6) Obudowa");
        System.out.println("7) Zasilacz");

        Map<String, Map<String, Double>> cenyKomponentow = new HashMap<>();
        cenyKomponentow.put("Procesor", przygotujModeleProcesorow());
        cenyKomponentow.put("Płyta główna", przygotujModelePlytGlownych());
        cenyKomponentow.put("RAM", przygotujModeleRam());
        cenyKomponentow.put("Karta graficzna", przygotujModeleKartGraficznych());
        cenyKomponentow.put("Dysk", przygotujModeleDyskow());
        cenyKomponentow.put("Obudowa", przygotujModeleObudow());
        cenyKomponentow.put("Zasilacz", przygotujModeleZasilaczy());

        Map<String, Double> wybraneKomponenty = new HashMap<>();
        double sumaCen = 0.0;

        while (true) {
            System.out.println("Wybierz numer komponentu (lub 0 aby zakończyć):");
            int wybor = input.nextInt();

            if (wybor == 0) {
                break;
            }

            if (wybor < 1 || wybor > 7) {
                System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
                continue;
            }

            String nazwaKomponentu = pobierzNazweKomponentu(wybor);
            Map<String, Double> modeleKomponentu = cenyKomponentow.get(nazwaKomponentu);

            System.out.println("Dostępne modele dla " + nazwaKomponentu + ":");

            int numerModelu = 1;
            for (Map.Entry<String, Double> entry : modeleKomponentu.entrySet()) {
                System.out.println(numerModelu + ") " + entry.getKey() + " - " + entry.getValue() + " PLN");
                numerModelu++;
            }

            System.out.println("Wybierz numer modelu:");
            int wyborModelu = input.nextInt();

            if (wyborModelu < 1 || wyborModelu > modeleKomponentu.size()) {
                System.out.println("Niepoprawny wybór modelu. Spróbuj ponownie.");
                continue;
            }

            String nazwaModelu = pobierzNazweModelu(wyborModelu, modeleKomponentu);
            double cenaKomponentu = modeleKomponentu.get(nazwaModelu);

            System.out.println("Wybrano: " + nazwaKomponentu + " - " + nazwaModelu);
            System.out.println("Cena: " + cenaKomponentu + " PLN");

            wybraneKomponenty.put(nazwaKomponentu, cenaKomponentu);
            sumaCen += cenaKomponentu;

            System.out.println();
        }

        System.out.println("Wybrane komponenty:");
        for (Map.Entry<String, Double> entry : wybraneKomponenty.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " PLN");
        }

        System.out.println("Łączna cena: " + sumaCen + " PLN");

        input.close();
    }

    private static String pobierzNazweKomponentu(int numerKomponentu) {
        switch (numerKomponentu) {
            case 1:
                return "Procesor";
            case 2:
                return "Płyta główna";
            case 3:
                return "RAM";
            case 4:
                return "Karta graficzna";
            case 5:
                return "Dysk";
            case 6:
                return "Obudowa";
            case 7:
                return "Zasilacz";
            default:
                return "";
        }
    }

    private static String pobierzNazweModelu(int numerModelu, Map<String, Double> modeleKomponentu) {
        int index = 1;
        for (Map.Entry<String, Double> entry : modeleKomponentu.entrySet()) {
            if (index == numerModelu) {
                return entry.getKey();
            }
            index++;
        }
        return "";
    }
    //mapy przechowywujące modele i ceny danych podzespołów
    private static Map<String, Double> przygotujModeleProcesorow() {
        Map<String, Double> modeleProcesorow = new HashMap<>();
        modeleProcesorow.put("AMD Ryzen 5 5600", 619.0);
        modeleProcesorow.put("Intel Core i5-12400F", 729.0);
        modeleProcesorow.put("AMD Ryzen 7 5700X", 879.0);
        modeleProcesorow.put("Intel Core i5-13600KF", 1399.0);
        modeleProcesorow.put("Intel Core i7-13700K", 1949.0);
        return modeleProcesorow;
    }

    private static Map<String, Double> przygotujModelePlytGlownych() {
        Map<String, Double> modelePlytGlownych = new HashMap<>();
        modelePlytGlownych.put("Gigabyte B550 GAMING X V2", 509.0);
        modelePlytGlownych.put("ASUS PRIME B760M-A WIFI DDR4", 769.0);
        modelePlytGlownych.put("Gigabyte B760 GAMING X DDR4", 699.0);
        modelePlytGlownych.put("Gigabyte Z790 AORUS ELITE AX", 1399.0);
        modelePlytGlownych.put("MSI B550 GAMING GEN3", 489.0);
        return modelePlytGlownych;
    }

    private static Map<String, Double> przygotujModeleRam() {
        Map<String, Double> modeleRam = new HashMap<>();
        modeleRam.put("Kingston FURY 32GB (2x16GB) 3200MHz", 339.0);
        modeleRam.put("GOODRAM 16GB (2x8GB) 3200MHz", 189.0);
        modeleRam.put("Patriot 16GB (2x8GB) 3200MHz", 219.0);
        modeleRam.put("Kingston FURY 32GB (2x16GB) 5600MHz", 549.0);
        modeleRam.put("Patriot 32GB (2x16GB) 6000MHz", 569.0);
        return modeleRam;
    }

    private static Map<String, Double> przygotujModeleKartGraficznych() {
        Map<String, Double> modeleKartGraficznych = new HashMap<>();
        modeleKartGraficznych.put("Gigabyte GeForce RTX 3060 GAMING OC", 1869.0);
        modeleKartGraficznych.put("MSI GeForce RTX 4070 GAMING X TRIO", 3449.0);
        modeleKartGraficznych.put("ASRock Radeon RX 6600 Challenger D", 1229.0);
        modeleKartGraficznych.put("AMD Radeon RX 6950 XT", 3199.0);
        modeleKartGraficznych.put("MSI GeForce RTX 4070 Ti VENTUS 3X OC", 4099.0);
        return modeleKartGraficznych;
    }

    private static Map<String, Double> przygotujModeleDyskow() {
        Map<String, Double> modeleDyskow = new HashMap<>();
        modeleDyskow.put("Lexar 1TB M.2 PCIe NVMe NM620", 213.0);
        modeleDyskow.put("Samsung 1TB M.2 PCIe Gen4 NVMe 980 PRO", 399.0);
        modeleDyskow.put("Kingston 1TB M.2 PCIe Gen4 NVMe KC3000", 349.0);
        modeleDyskow.put("GOODRAM 1TB SATA SSD CX400", 209.0);
        modeleDyskow.put("KIOXIA 480GB SATA SSD EXCERIA", 112.0);
        return modeleDyskow;
    }

    private static Map<String, Double> przygotujModeleObudow() {
        Map<String, Double> modeleObudow = new HashMap<>();
        modeleObudow.put("Logic ATOS ARGB", 189.0);
        modeleObudow.put("ENDORFY Signum 300 ARGB", 369.0);
        modeleObudow.put("be quiet! Pure Base 500DX Black", 599.0);
        modeleObudow.put("Zalman S2", 219.0);
        modeleObudow.put("Corsair 4000D Airflow Biała", 479.0);
        return modeleObudow;
    }

    private static Map<String, Double> przygotujModeleZasilaczy() {
        Map<String, Double> modeleZasilaczy = new HashMap<>();
        modeleZasilaczy.put("ENDORFY Supremo FM5 750W 80 Plus Gold", 499.0);
        modeleZasilaczy.put("Cooler Master MWE GOLD-V2 750W 80 Plus Gold", 449.0);
        modeleZasilaczy.put("be quiet! Pure Power 12 M 750W 80 Plus Gold", 559.0);
        modeleZasilaczy.put("Corsair RM1000x 1000W 80 Plus Gold", 899.0);
        modeleZasilaczy.put("Gigabyte Aorus 750W 80 Plus Gold", 549.0);
        return modeleZasilaczy;
    }
}
