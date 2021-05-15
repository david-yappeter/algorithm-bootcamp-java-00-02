import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class App  {
    public static void main(String[] args) throws Exception {
        String[] judul = {
            "██████╗░░░░░░██╗  ░░░░░░░██████╗██╗░░██╗░█████╗░██████╗░███████╗",
            "██╔══██╗░░░░░██║  ░░░░░░██╔════╝██║░░██║██╔══██╗██╔══██╗██╔════╝",
            "██████╦╝░░░░░██║  █████╗╚█████╗░███████║███████║██████╔╝█████╗░░",
            "██╔══██╗██╗░░██║  ╚════╝░╚═══██╗██╔══██║██╔══██║██╔══██╗██╔══╝░░",
            "██████╦╝╚█████╔╝  ░░░░░░██████╔╝██║░░██║██║░░██║██║░░██║███████╗",
            "╚═════╝░░╚════╝░  ░░░░░░╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚═╝╚══════╝",
        };

        for(int i = 0; i < judul.length; i++){
            System.out.println(judul[i]);
        }

        Scanner scanner = new Scanner(System.in);


        int choice;

        ArrayList<Participant> participants = new ArrayList<Participant>();

        while(true){
            System.out.println("+=========================+");
            System.out.println("+Options                  +");
            System.out.println("+=========================+"); 
            System.out.println("+1. Start Sharing         +");
            System.out.println("+2. Update Participant    +");
            System.out.println("+3. Delete Participant    +");
            System.out.println("+4. Close App             +");
            System.out.println("+=========================+");
            System.out.print  ("Choice >> ");
            choice = scanner.nextInt();

            try{
                if(choice >= 1 && choice <= 4){
                    if(choice == 1){
                        int num;
                        String username;
                        while(true){
                            try{
                                System.out.print("Input a Number [0-100] : ");
                                num = scanner.nextInt();
                                if(num < 0 || num > 100){
                                    throw new Exception("Invalid");
                                }
                                break;
                            }
                            catch(Exception e){
                                System.out.println("Invalid Input");
                            }
                        }

                        scanner.nextLine();

                        while(true){
                            try{
                                System.out.print("Input username[5-20] : ");
                                username = scanner.nextLine();

                                if (username.length() < 5 || username.length() > 20) {
                                    throw new Exception("Invalid Input");
                                }
                                
                                for(Participant p: participants){
                                    if(p.username.equalsIgnoreCase(username)) {
                                        throw new Exception("Username already Exists");
                                    }
                                }

                                participants.add(new Participant(num, username));
                                break;
                            }
                            catch(Exception e){
                                System.out.println(e);
                            }
                        }
                        

                    } else if (choice == 2){
                        if(participants.size() == 0){
                            System.out.println("EMPTY PARTICIPANT\nPress Enter to Continue");
                            scanner.nextLine();
                            scanner.nextLine();
                        }

                        System.out.println("+==========================================+");
                        System.out.println("+ Share List                               +");
                        System.out.println("+==========================================+");
                        int index = 1;
                        for(Participant p: participants){
                            System.out.printf("+ %03d|%-25s| %-4d+\n", index, p.username, p.share_number);
                            index++;
                        }
                        System.out.println("+==========================================+");
                        int select;
                        
                        while(true){
                            try{
                                System.out.printf("Which participant you would like to edit [1-%d] [0 to exit :]", participants.size());
                                select = scanner.nextInt();
                                if(select == 0){
                                    break;
                                }
                                if(select <= participants.size() && select > 1){
                                    int update_num;
                                    while(true){
                                        System.out.println("Input a number");
                                        try{
                                            update_num = scanner.nextInt();
                                            if(update_num <= 100 && update_num > 1){
                                                participants.set(select - 1, new Participant(update_num, participants.get(select - 1).username));
                                                System.out.println("Update Success\n Press Enter To Continue");
                                                scanner.nextLine(); 
                                                break;
                                            } else{
                                                throw new Error("Invalid");
                                            }
                                        }
                                        catch(Exception e){
                                            System.out.println("Invalid Input");
                                        }
                                    }
                                } else{
                                    throw new Error("Invalid Input");
                                }
                                break;
                            }
                            catch(Exception e){
                                System.out.println("Invalid Input");
                            }
                        }

                        scanner.nextLine(); 
                    } else if(choice == 3){
                        if(participants.size() == 0){
                            System.out.println("EMPTY PARTICIPANT\nPress Enter to Continue");
                            scanner.nextLine();
                            scanner.nextLine();
                        }

                        System.out.println("+==========================================+");
                        System.out.println("+ Share List                               +");
                        System.out.println("+==========================================+");
                        int index = 1;
                        for(Participant p: participants){
                            System.out.printf("+ %03d|%-25s| %-4d+\n", index, p.username, p.share_number);
                            index++;
                        }
                        System.out.println("+==========================================+");
                        int select;

                        while(true){
                            try{
                                System.out.printf("Which participant you would like to Delete [1-%d] [0 to exit :]", participants.size());
                                select = scanner.nextInt();
                                if(select == 0){
                                    break;
                                }
                                if(select <= participants.size() && select >= 1){
                                    participants.remove(select - 1);
                                    System.out.println("Successfully Remove");
                                    System.out.println("Press Enter To Continue");

                                    scanner.nextLine();
                                    break;
                                } else{
                                    throw new Exception("Invalid Input");
                                }
                            }
                            catch(Exception e){
                                System.out.println("Invalid Input");
                            }
                        }
                        scanner.nextLine();
                    } else if(choice == 4){
                        System.out.println("Here is the list of completed Shared List");
                        System.out.println("Remember, Sharing is caring, happy sharing :D");
                        System.out.println("+==========================================+");
                        System.out.println("+ Share List                               +");
                        System.out.println("+==========================================+");
                        System.out.println("+ Username           | Before   | After    +");
                        System.out.println("+==========================================+");
                        int index = 1;
                        Collections.sort(participants, (p1, p2) -> p1.username.compareTo(p2.username));

                        ArrayList<Participant> participantsClone = (ArrayList<Participant>) participants.clone();

                        Collections.shuffle(participantsClone);

                        
                        for(Participant p: participants){
                            System.out.printf("+%-25s| %-4d | %-4d +\n", p.username, p.share_number, participantsClone.get(index - 1).share_number);
                            index++;
                        }
                        System.out.println("+==========================================+");
                        break;
                    }
                } else{
                    throw new Exception("Invalid");
                }
            }
            catch(Exception e){
                System.out.println("Invalid Input");
            }
        }

        

        scanner.close();
    }
}
