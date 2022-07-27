import java.util.Scanner;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

class Model {

    int id;
    String brand;
    String modelName;
    int price;
    int year;
    String mpg;
    String details;

    public Model(int idd, String b, String m, int p, int y, String mp, String dt) {
        id = idd;
        brand = b;
        modelName = m;
        price = p;
        year = y;
        mpg = mp;
        details = dt;
    }
}

class Customer {
    String cusID;
    String cusName;
    int paid;
    int due;
    String cusContact;
    String cusAddrs;

    public void Payment() {
        Scanner CUS = new Scanner(System.in);

        System.out.println("Enter your ID      : ");
        cusID = CUS.nextLine();
        System.out.println("Enter your Name    : ");
        cusName = CUS.nextLine();

        System.out.println("Enter your Contact : ");
        cusContact = CUS.nextLine();
        System.out.println("Enter your Address : ");
        cusAddrs = CUS.nextLine();
        System.out.println("Enter The amount you want to pay : ");

        paid = CUS.nextInt();

        CUS.close();

    }

    public void Info() {
        System.out.println("\n<<<<<<<<...Customer Recipt...>>>>>>>>");
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        
        System.out.println("Date & Time      :" + formattedDate);
        System.out.println("Customer ID      : " + cusID);
        System.out.println("Customer Name    : " + cusName);
        System.out.println("Customer Address : " + cusAddrs);
        System.out.println("Customer Phone   : " + cusContact);

    }

    public void Bill() {
        System.out.println("\n<<<<<<<<...Bill...>>>>>>>>");
        System.out.println("Paid amount    : " + paid);
        System.out.println("Due  amout     : " + due);
        System.out.println("\n");
    }
}

public class Base {

    public static void main(String[] args) {

        Model Venza = new Model(111, "Toyota", "Venza", 33240, 2022, "40/37", "Explore beyond the ordinary.");
        Model CHR = new Model(222, "Toyota", "C-HR", 24130, 2022, "27/31", "Look sharp at every turn.");
        Model Civic = new Model(333, "Honda", "Civik Sedan", 22550, 2022, "31/40", "Red Classic Car. ");
        Model Accord = new Model(444, "Honda", "Accord Sedan", 26520, 2022, "30/38", "Black Classic Design.");
        Model ES = new Model(555, "Lexus", "ES", 42025, 2022, "40/37", "Silver Premium.");
        Model LS = new Model(666, "Lexus", "LS", 77157, 2022, "45/39", "Black Royal.");
        Scanner scan = new Scanner(System.in);

        Model list[];
        String selected; // keep vale of selected model
        list = new Model[6];
        list[0] = Venza;
        list[1] = CHR;
        list[2] = Civic;
        list[3] = Accord;
        list[4] = ES;
        list[5] = LS;
        Customer C1 = new Customer();

        class MainCar {

            static int total;

            public void ShowCar(int inp) {

                System.out.println(list[inp].modelName);

                System.out.println("Car ID      : " + list[inp].id);
                System.out.println("Brand       :" + list[inp].brand);
                System.out.println("Model       :" + list[inp].modelName);
                System.out.println("Price       :" + list[inp].price);
                total = (list[inp].price * 200) / 100 + list[inp].price;
                System.out.println("Total(+VAT) :" + total);
                System.out.println("Milage      :" + list[inp].mpg);
                System.out.println("Year        :" + list[inp].year);

                System.out.println("---Press 1 to Buy or * to go back---");
            }

            public void BillPay() {
                C1.Payment();
                C1.Info();
                C1.due = total - C1.paid;
                C1.Bill();
                System.out.println("\n---Purchase Successful---");
                System.exit(0);
            }

        }
        MainCar B1 = new MainCar();
        MainCar Show = new MainCar();

        class CaseOption {
            public void opt(String selected) {
                Show.ShowCar(Integer.parseInt(selected));
                selected = scan.nextLine();
                switch (selected) {
                    case "1": {

                        B1.BillPay();

                        break;
                    }
                    case "*": {
                        System.out.println("<--- Back");
                        break;
                    }

                    case "e": {
                        System.exit(0);
                    }

                }
            }
        }

        CaseOption s1 = new CaseOption();

        class SelectOption {
            public void modelSelect(String selected) {
                switch (selected) {
                    case "0": {

                        s1.opt(selected);

                        break;
                    }
                    case "1": {
                        s1.opt(selected);

                        break;
                    }
                    case "2": {
                        s1.opt(selected);

                        break;
                    }
                    case "3": {
                        s1.opt(selected);

                        break;
                    }
                    case "4": {
                        s1.opt(selected);

                        break;
                    }
                    case "5": {
                        s1.opt(selected);

                        break;
                    }
                    case "*": {
                        System.out.println("<<---");
                        break;
                    }
                    case "e": {
                        System.exit(0);
                    }

                }
            }
        }

        SelectOption M1 = new SelectOption();

        while (true) {
            System.out.println("-------Welcome to CSR-------");
            System.out.println(">---Press >> 1 << for : Menu\n>---Press >> e << for : Exit");
            String input = scan.nextLine();

            switch (input) {

                case "1": {

                    System.out.println("--->-Main Menu-<---");
                    System.out
                            .println("\nPress >> 1 << for Toyota \nPress >> 2 << for Honda\nPress >> 3 << for Lexus\n");

                    String inp = scan.nextLine();

                    switch (inp) {
                        case "1": {

                            System.out.println("--Models from Toyota :--");

                            System.out.println("\nPress >> 0 <<  for Venza \nPress >> 1 << for CHR");
                            selected = scan.nextLine();
                            M1.modelSelect(selected);

                            break;
                        }
                        case "2": {
                            System.out.println("--Models from Honda :--");

                            System.out.println("\nPress >> 2 <<  for Civic \nPress >> 3 <<  for Accord");
                            selected = scan.nextLine();

                            M1.modelSelect(selected);

                            break;
                        }
                        case "3": {
                            System.out.println("--Models from Lexus :--");

                            System.out.println("\nPress >> 4 << for ES \nPress >> 5 <<  for LS");
                            selected = scan.nextLine();

                            M1.modelSelect(selected);

                            break;
                        }
                        case "*": {
                            System.out.println("<---Back");
                        }

                        default: {
                            break;
                        }
                    }

                    break;
                }
                case "e": {
                    System.out.println("<<---Exited--->>");
                    System.exit(0);
                    break;
                }
                case "*": {
                    break;
                }
                default: {
                    System.out.println("Enter 1 or e only");
                    break;
                }

            }
        }

    }

}
