package client;

import java.util.Scanner;
import adt.LinkedList;
import adt.ListInterface;
import entity.Playlist;

public class OnlineKaraoke {
public static void main(String[] args) { 
       ListInterface<Playlist> a = new LinkedList<>();
       a = playlist();
    }
    
private static ListInterface<Playlist> playlist(){
        ListInterface<Playlist> play = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        
        do{
            System.out.println("Select an Option:");
            System.out.println("1 - Add a song");
            System.out.println("2 - Remove a song");
            System.out.println("3 - Edit song");
            System.out.println("4 - View whole playlist");              
            System.out.println("5 - Exit");     
            System.out.println();   
            
            System.out.println("Option:");  
            choice = scan.nextInt();
            System.out.println();  
            Playlist playing = new Playlist();
            switch (choice) {
                case 1 ->                     {
                        System.out.println("Enter Song Name: ");
                        scan.nextLine();
                        String songName = scan.nextLine();
                        System.out.println("Enter Artist Name: ");
                        String artistName = scan.nextLine();
                        System.out.println("Enter Duration (in seconds): ");
                        int duration = scan.nextInt();
                        playing = new Playlist(songName, artistName, duration);
                        play.add(playing);
                        System.out.println(); 
                        System.out.println("Successfully added song to playlist");
                        System.out.println(); 
                        break;
                    }
                case 2 -> {
                    for(int i = 1; i <= play.size();i++){
                        System.out.println(play.getElement(i));
                    }       System.out.println("Enter index number of song to delete");
                    int indexDelete = scan.nextInt();
                    if(play.remove(indexDelete) == true){
                        System.out.println("Removed Successfully");
                        System.out.println(); 
                    }
                    else {
                        System.out.println("Not removed");
                        System.out.println(); 
                    }
                    System.out.println(play.size()+" record(s) found.");
                    System.out.println(); 
                    break;
                }
                case 3 -> {
                    for(int i = 1; i<=play.size();i++){
                        System.out.println(play.getElement(i));
                    }
                    System.out.println(play.size()+" record(s) found.");
                    System.out.println(); 
                    System.out.println("Enter index number of song to edit");
                    int indexEdit = scan.nextInt();
                        System.out.println("Enter Song Name: ");
                        scan.nextLine();
                        String songName = scan.nextLine();
                        System.out.println("Enter Artist Name: ");
                        String artistName = scan.nextLine();
                        System.out.println("Enter Duration (in seconds): ");
                        int duration = scan.nextInt();
                        
                        playing = new Playlist(songName, artistName, duration);
                        if(play.replace(indexEdit, playing)){
                            System.out.println("Successfully edited an entry");
                        }
                        else{
                            System.out.println("Faled to edit an entry");
                        }
                        System.out.println(); 
                        break;
                }
                case 4 -> {
                    for(int i = 1; i<=play.size();i++){
                        System.out.println(play.getElement(i));
                    }
                    System.out.println(play.size()+" record(s) found.");
                    System.out.println(); 
                    break;
                }
                default -> {
                }
            }

        } while(choice < 5);
        return play;
    }
}