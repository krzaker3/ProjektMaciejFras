import java.util.Scanner;
public class Kalkulatory extends SklepKomputerowy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //
        System.out.println("Witaj w projekcie zaliczeniowym !");
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
        System.out.println("1) Dodawanie");
        System.out.println("2) Odejmowanie");
        System.out.println("3) Mnożenie");
        System.out.println("4) Dzielenie");
        System.out.println("Wybierz operację: ");
        operator = input.next().charAt(0);
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
                przeliczonaKwota = kwota / 4.2; // Kurs Dolar do PLN
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
                przeliczonaKwota = kwota * 1.1; // Kurs Euro do Dolar
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
                przeliczonaKwota = kwota / 1.1; // Kurs Euro do Dolar
            } else {
                System.out.println("Nieprawidłowy wybór waluty docelowej.");
                return;
            }
        } else {
            System.out.println("Nieprawidłowy wybór waluty źródłowej.");
            return;
        }

        System.out.println("Przeliczona kwota: " + przeliczonaKwota);
        input.close();
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
            input.close();
        }
}
