import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Kalkulatory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Witaj w programie!");
        System.out.println("Wybierz program do uruchomienia: ");
        System.out.println("1) Kalkulator prosty");
        System.out.println("2) Kalkulator walut");
        System.out.println("3) Kalkulator PIT");
        System.out.println("4) Kalkulator miejsc zerowych funkcji kwadratowej");
        System.out.println("5) Sklep komputerowy");
        int wybor = input.nextInt();

        switch (wybor) {
            case 1:
                KalkulatorProsty kalkulatorProsty = new KalkulatorProsty();
                kalkulatorProsty.main();
                break;
            case 2:
                KalkulatorWalut kalkulatorWalut = new KalkulatorWalut();
                kalkulatorWalut.main();
                break;
            case 3:
                KalkulatorPIT kalkulatorPIT = new KalkulatorPIT();
                kalkulatorPIT.main();
                break;
            case 4:
                KalkulatorFunkcjiKwadratowej kalkulatorFunkcjiKwadratowej = new KalkulatorFunkcjiKwadratowej();
                kalkulatorFunkcjiKwadratowej.main();
                break;
            case 5:
                SklepKomputerowy sklepKomputerowy = new SklepKomputerowy();
                sklepKomputerowy.main();
                break;
            default:
                System.out.println("Niepoprawny wybór");
                break;
        }

        input.close();
    }
}

class KalkulatorProsty {
    public void main() {
        char operator;
        Double a, b, wynik;
        Scanner input = new Scanner(System.in);
        // wypisanie możliwych operacji
        System.out.println("1) Dodawanie");
        System.out.println("2) Odejmowanie");
        System.out.println("3) Mnożenie");
        System.out.println("4) Dzielenie");
        System.out.println("Wybierz operację: ");
        operator = input.next().charAt(0); // wybór operacji
        System.out.println("Podaj a");
        a = input.nextDouble();
        System.out.println("Podaj b");
        b = input.nextDouble();

        switch (operator) {
            case '1':
                wynik = a + b;
                System.out.println(a + " + " + b + " = " + wynik);
                break;
            case '2':
                wynik = a - b;
                System.out.println(a + " - " + b + " = " + wynik);
                break;
            case '3':
                wynik = a * b;
                System.out.println(a + " * " + b + " = " + wynik);
                break;
            case '4':
                wynik = a / b;
                System.out.println(a + " / " + b + " = " + wynik);
                break;

            default:
                System.out.println("Niepoprawny znak");
                break;
        }
        input.close();
    }
}

class KalkulatorWalut {
    public void main() {
        Scanner input = new Scanner(System.in);
        System.out.println("Witaj w kalkulatorze walut!");
        System.out.println("Dostępne waluty: ");
        System.out.println("1. Polski złoty (PLN)");
        System.out.println("2. Euro (EUR)");
        System.out.println("3. Dolar amerykański (USD)");
        System.out.println("Wybierz walutę, którą chcesz przeliczyć: ");
        int walutaZrodlowa = input.nextInt();

        System.out.println("Podaj kwotę do przeliczenia: ");
        double kwota = input.nextDouble();

        System.out.println("Wybierz walutę, na którą chcesz przeliczyć: ");
        int walutaDocelowa = input.nextInt();

        double przeliczonaKwota = 0;

        // Przeliczanie polskiego złotego na inne waluty
        if (walutaZrodlowa == 1) {
            if (walutaDocelowa == 2) {
                przeliczonaKwota = kwota / 4.5; // Kurs Euro do PLN
            } else if (walutaDocelowa == 3) {
                przeliczonaKwota = kwota / 3.8; // Kurs Dolar do PLN
            } else {
                System.out.println("Nieprawidłowy wybór waluty docelowej.");
                return;
            }
        }

        // Przeliczanie euro na inne waluty
        else if (walutaZrodlowa == 2) {
            if (walutaDocelowa == 1) {
                przeliczonaKwota = kwota * 4.5; // Kurs PLN do Euro
            } else if (walutaDocelowa == 3) {
                przeliczonaKwota = kwota * 1.2; // Kurs Euro do Dolar
            } else {
                System.out.println("Nieprawidłowy wybór waluty docelowej.");
                return;
            }
        }

        // Przeliczanie dolarów na inne waluty
        else if (walutaZrodlowa == 3) {
            if (walutaDocelowa == 1) {
                przeliczonaKwota = kwota * 3.8; // Kurs PLN do Dolar
            } else if (walutaDocelowa == 2) {
                przeliczonaKwota = kwota / 1.2; // Kurs Euro do Dolar
            } else {
                System.out.println("Nieprawidłowy wybór waluty docelowej.");
                return;
            }
        } else {
            System.out.println("Nieprawidłowy wybór waluty źródłowej.");
            return;
        }

        System.out.println("Przeliczona kwota: " + przeliczonaKwota);
    }
}

class KalkulatorPIT {
    public void main() {
        Scanner input = new Scanner(System.in);
        System.out.println("Witaj w kalkulatorze podatku dochodowego!");
        System.out.println("Podaj swoje dochody roczne: ");
        double rocznyDochod = input.nextDouble();

        double podatek;

        if (rocznyDochod <= 85528) {
            podatek = rocznyDochod * 0.18 - 556.02;
        } else {
            double podstawaPodatku = 85528 * 0.18 - 556.02;
            double nadwyzkaDochodu = rocznyDochod - 85528;
            double dodatkowyPodatek = nadwyzkaDochodu * 0.32;
            podatek = podstawaPodatku + dodatkowyPodatek;
        }
        System.out.println("Podatek dochodowy do zapłaty: " + podatek);
    }}
class KalkulatorFunkcjiKwadratowej {
        public void main() {
            Scanner input = new Scanner(System.in);
            System.out.println("Witaj w kalkulatorze miejsc zerowych funkcji kwadratowej!");
            System.out.println("Podaj współczynniki a, b i c dla równania ax^2 + bx + c = 0");
            System.out.print("a: ");
            double a = input.nextDouble();
            System.out.print("b: ");
            double b = input.nextDouble();
            System.out.print("c: ");
            double c = input.nextDouble();

            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Dwa miejsca zerowe: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("Jedno miejsce zerowe: x = " + x);
            } else {
                System.out.println("Brak miejsc zerowych.");
            }
        }
}
class SklepKomputerowy {
    public void main() {
        Scanner input = new Scanner(System.in);

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

    private static Map<String, Double> przygotujModeleProcesorow() {
        Map<String, Double> modeleProcesorow = new HashMap<>();
        modeleProcesorow.put("Procesor A", 1000.0);
        modeleProcesorow.put("Procesor B", 1200.0);
        modeleProcesorow.put("Procesor C", 900.0);
        modeleProcesorow.put("Procesor D", 1100.0);
        modeleProcesorow.put("Procesor E", 950.0);
        return modeleProcesorow;
    }

    private static Map<String, Double> przygotujModelePlytGlownych() {
        Map<String, Double> modelePlytGlownych = new HashMap<>();
        modelePlytGlownych.put("Płyta A", 500.0);
        modelePlytGlownych.put("Płyta B", 550.0);
        modelePlytGlownych.put("Płyta C", 600.0);
        modelePlytGlownych.put("Płyta D", 450.0);
        modelePlytGlownych.put("Płyta E", 520.0);
        return modelePlytGlownych;
    }

    private static Map<String, Double> przygotujModeleRam() {
        Map<String, Double> modeleRam = new HashMap<>();
        modeleRam.put("RAM A", 300.0);
        modeleRam.put("RAM B", 350.0);
        modeleRam.put("RAM C", 400.0);
        modeleRam.put("RAM D", 280.0);
        modeleRam.put("RAM E", 320.0);
        return modeleRam;
    }

    private static Map<String, Double> przygotujModeleKartGraficznych() {
        Map<String, Double> modeleKartGraficznych = new HashMap<>();
        modeleKartGraficznych.put("Karta A", 800.0);
        modeleKartGraficznych.put("Karta B", 850.0);
        modeleKartGraficznych.put("Karta C", 900.0);
        modeleKartGraficznych.put("Karta D", 750.0);
        modeleKartGraficznych.put("Karta E", 820.0);
        return modeleKartGraficznych;
    }

    private static Map<String, Double> przygotujModeleDyskow() {
        Map<String, Double> modeleDyskow = new HashMap<>();
        modeleDyskow.put("Dysk A", 200.0);
        modeleDyskow.put("Dysk B", 220.0);
        modeleDyskow.put("Dysk C", 180.0);
        modeleDyskow.put("Dysk D", 240.0);
        modeleDyskow.put("Dysk E", 210.0);
        return modeleDyskow;
    }

    private static Map<String, Double> przygotujModeleObudow() {
        Map<String, Double> modeleObudow = new HashMap<>();
        modeleObudow.put("Obudowa A", 150.0);
        modeleObudow.put("Obudowa B", 180.0);
        modeleObudow.put("Obudowa C", 200.0);
        modeleObudow.put("Obudowa D", 130.0);
        modeleObudow.put("Obudowa E", 160.0);
        return modeleObudow;
    }

    private static Map<String, Double> przygotujModeleZasilaczy() {
        Map<String, Double> modeleZasilaczy = new HashMap<>();
        modeleZasilaczy.put("Zasilacz A", 180.0);
        modeleZasilaczy.put("Zasilacz B", 200.0);
        modeleZasilaczy.put("Zasilacz C", 220.0);
        modeleZasilaczy.put("Zasilacz D", 160.0);
        modeleZasilaczy.put("Zasilacz E", 190.0);
        return modeleZasilaczy;
    }
}