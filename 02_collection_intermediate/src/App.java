import java.util.Scanner;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Shoes> shoes = new ArrayList<Shoes>();

        while(true){
            System.out.println("Shoe Shop");
            System.out.println("--------------");
            System.out.println("1. View Shoes");
            System.out.println("2. Add Shoes");
            System.out.println("3. Delete Shoes");
            System.out.println("4. Exit");
            System.out.print(">> ");
            int choice;

            try{
                choice = scanner.nextInt();
                if(choice < 1 || choice > 4){
                    throw new Error("Invalid Input");
                }

                if (choice == 1){
                    scanner.nextLine();
                    if(shoes.isEmpty()){
                        System.out.println("No Shoes Available");
                    } else{
                        int index = 1;
                        for(Shoes s: shoes){
                            System.out.printf("%d %s\n", index, s.name);
                            System.out.println("=========================");
                            System.out.printf("Category: %s\n", s.category); 
                            System.out.printf("Release Date: %s\n", s.release_date); 
                            System.out.printf("Price: %d\n\n", s.price); 
                        }
                    }
                    System.out.println("Press Enter To Continue");
                    scanner.nextLine();
                } else if (choice == 2){
                    String name, category, release;
                    int price;
                    scanner.nextLine();

                    while(true){
                        System.out.printf("Input shoe's name [name ends with shoe, example: 'Fire shoe']: ");
                        try{
                            name = scanner.nextLine();

                            if(!name.endsWith("shoe")){
                                throw new Error("Must end with 'shoe' (case sensitive)");
                            }
                            break;
                        }
                        catch(Error e){
                            System.out.println(e);
                        }
                    }
                    
                    while(true){
                        System.out.printf("Input shoe's category [Sneaker, Running, Boot] (case sensitive): ");
                        try{
                            category = scanner.nextLine();

                            if(!(category.equals("Sneaker") || category.equals("Running") || category.equals("Boot"))){
                                throw new Error("Input Not Valid");
                            }
                            break;
                        }
                        catch(Error e){
                            System.out.println(e);
                        }
                    }
                    
                    
                    SimpleDateFormat dateChecker = new SimpleDateFormat("dd-MM-yyyy");
                    dateChecker.setLenient(false);

                    while(true){
                        System.out.printf("Input shoe's release date [dd-mm-yyyy]: ");
                        try{
                            release = scanner.nextLine();

                            dateChecker.parse(release);
                            break;
                        }
                        catch(ParseException e){
                            System.out.println(e);
                        }
                    }

                    while(true){
                        System.out.printf("Input shoe's price [more than or equal 5000]: ");
                        try{
                            price = scanner.nextInt();

                            if(price < 5000){
                                throw new Error("Input Not Valid");
                            }
                            break;
                        }
                        catch(Error e){
                            System.out.println(e);
                        }
                    }

                    shoes.add(new Shoes(name, category, release, price));

                    scanner.nextLine();
                    System.out.println("Shoe Added!");
                    System.out.println("Press Enter To Continue");
                    scanner.nextLine();
                }else if (choice == 3){
                    scanner.nextLine();
                    if(shoes.isEmpty()){
                        System.out.println("No Shoes Available");
                    } else{
                        int index = 1;
                        for(Shoes s: shoes){
                            System.out.printf("%d %s\n", index, s.name);
                            System.out.println("=========================");
                            System.out.printf("Category: %s\n", s.category); 
                            System.out.printf("Release Date: %s\n", s.release_date); 
                            System.out.printf("Price: %d\n\n", s.price); 
                        }

                        System.out.printf("Choose Shoe's number to delete [1..%d]\n", shoes.size());
                        int select;

                        while(true){
                            try{
                                select = scanner.nextInt();
                                if(select <= 0 || select > shoes.size()){
                                    throw new Error("Invalid Input");
                                }
                                break;
                            }
                            catch(Exception e){
                                System.out.println(e);
                            }
                        }

                        shoes.remove(select - 1);
                        scanner.nextLine();
                        System.out.println("Shoes  Removed");
                    }
                    System.out.println("Press Enter To Continue");
                    scanner.nextLine();
                }else if (choice == 4){
                    break;
                }else{
                    throw new Error("Unhandled Case");
                }
            }
            catch(Error e){
                System.out.println(e);
            }
        }

        scanner.close();

        System.out.println("Thank you for using this application!");

    }
}
