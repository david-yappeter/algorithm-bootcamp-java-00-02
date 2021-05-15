import java.util.Scanner;

public class App {
    public static void main(String[] args)  {

        String[] judul = {
            "██████╗░░░░░░██╗  ░░░░░░  ████████╗░█████╗░██████╗░██╗░░░░░███████╗",
            "██╔══██╗░░░░░██║  ░░░░░░  ╚══██╔══╝██╔══██╗██╔══██╗██║░░░░░██╔════╝",
            "██████╦╝░░░░░██║  █████╗  ░░░██║░░░███████║██████╦╝██║░░░░░█████╗░░",
            "██╔══██╗██╗░░██║  ╚════╝  ░░░██║░░░██╔══██║██╔══██╗██║░░░░░██╔══╝░░",
            "██████╦╝╚█████╔╝  ░░░░░░  ░░░██║░░░██║░░██║██████╦╝███████╗███████╗",
            "╚═════╝░░╚════╝░  ░░░░░░  ░░░╚═╝░░░╚═╝░░╚═╝╚═════╝░╚══════╝╚══════╝",
        };

        for(int i = 0; i < judul.length; i++){
            System.out.println(judul[i]);
        }

        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true){
            try{
                System.out.println("1. Start the simulation!!");
                System.out.println("2. Close the Application");
                System.out.print("Choice >> ");
                
                choice = scanner.nextInt();
                if(!(choice == 1 || choice == 2) ){
                    throw new Error("Invalid");
                }

                break;
            }
            catch(Exception e){
                System.out.println("Invalid Input!");
            }
        }

        if(choice == 2){
            scanner.close();
        close();
        }

        int a,b;
        while(true){
            try{
                System.out.print("Input First Number 1-100 Inclusive: ");
                a = scanner.nextInt();
                if(a <= 0 && a > 100){
                    throw new Error("Invalid");
                }
                break;
            }
            catch(Exception e){
                System.out.println("Invalid Input!");
            }
        }
        
        while(true){
            try{
                System.out.print("Input First Number 1-100 Inclusive: ");
                b = scanner.nextInt();
                if(b <= 0 && b > 100){
                    throw new Error("Invalid");
                }
                break;
            }
            catch(Exception e){
                System.out.println("Invalid Input!");
            }
        }
        

        //102
        System.out.println("+==============================================================================================================+");
        System.out.println("+   (String Type)     | (Character Type)    | * (Integer Type)    |  / (floating type)  |input1==input2(bool)  +");
        System.out.printf ("+%21s|%21s|%21d|%21.3f|%21b+\n", a + " + " + b, (char)a + " " + (char)b, a * b, ((double)a) / ((double)b), a == b);
        System.out.println("+==============================================================================================================+");
        System.out.println("Press enter to proceed");
        scanner.nextLine();
        scanner.nextLine();

        System.out.println("+==========|==========|==========|==========|==========|+");
        System.out.println("+     +    |     -    |    *     |    /     |    %     |+");
        System.out.println("+==========|==========|==========|==========|==========|+");
        System.out.printf("+%10d|%10d|%10d|%10f|%10d+\n", a + b, a - b , a *b, ((double)a / (double) b), a % b);
        System.out.println("+==========|==========|==========|==========|==========|+");
        System.out.println("Press enter to proceed");
        scanner.nextLine();

        boolean c,d;
        while(true){
            try{
                System.out.print("Give me value for p1 [true/false]: ");
                c = scanner.nextBoolean();
                
                break;
            }
            catch(Exception e){
                System.out.println("Invalid Input!");
            }
        }

        while(true){
            try{
                System.out.print("Give me value for p2 [true/false]: ");
                d = scanner.nextBoolean();
                
                break;
            }
            catch(Exception e){
                System.out.println("Invalid Input!");
            }
        }
        
        System.out.println("+==========|==========|==========|==========+");
        System.out.println("Logical Table");
        System.out.println("+==========|==========|==========|==========+");
        System.out.printf("P1 = %s, P2 = %s\n", (c ? "T": "F"), (d ? "T": "F"));
        System.out.println("+==========|==========|==========|==========+");     
        System.out.printf("+%10s|%10s|%10s|%10s+\n", "!P1", "!P2", "&&", "||");
        System.out.println("+==========|==========|==========|==========+");    
        System.out.printf("+%10b|%10b|%10b|%10b+\n", !c, !d, c && d, c || d);
        System.out.println("+==========|==========|==========|==========+");    
        System.out.println("Press enter to proceed");
        scanner.nextLine();
        scanner.nextLine();

        scanner.close();
        close();
    }

    static void close(){
        System.out.println("Thank you for using the apps");
        System.exit(0);
    }
}
