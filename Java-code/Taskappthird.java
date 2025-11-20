///  TASK-03 

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Taskappthird {

    // user details
    static class User
    {
        String user, pass;
        User(String u, String p)
        {
            user=u;
            pass=p;
            }
        boolean check(String p)
        {
            return pass.equals(p); 
            
        }
    }

    // oop concepts
    static abstract class Task
    {
        String title; boolean done=false;
        Task(String t)
            {
            title=t;
            }
        void complete()
        {
            done=true;
        }
        abstract String type();
        public String toString()
        {
            return "["+type()+"] "+title+(done?" ✔":" ✗");
        }
    }
    // work task 
    static class WorkTask extends Task
    {
        WorkTask(String t)
        {
            super(t);
        }
        String type()
        {
            return "Work";
        }
    }
    //  personal task
    static class PersonalTask extends Task
    {
        PersonalTask(String t)
        {
            super(t);
        }
        String type()
        {
            return "Personal";
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("admin","123"));// login database
        ArrayList<Task> tasks = new ArrayList<>();

        // start login page 
        User current = null;
        
        while(current == null)
                  {
            System.out.println("\n----  TASK LOGIN PAGE  --- ");
            System.out.print("Username: ");
            String u=sc.nextLine();
            System.out.print("Password: ");
            String p=sc.nextLine();
             System.out.println("--------------------------");
            for(User x:users)
            
                if(x.user.equals(u) && x.check(p))
                    current=x;

            if(current==null)
            
                System.out.println("Wrong login.\n");
              }
        // login page end

        // menu  start page 
        while(true)
        {
            System.out.println("\n--- TASK MANAGER ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.println("--- xxx --- xxx ---");
            System.out.print("\n Choose: ");
            int ch;
            try
            {
                ch=sc.nextInt();
                sc.nextLine();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Numbers only!");
                sc.nextLine();
                continue;
            }

            switch(ch)
            {
                case 1:
                    // add tasks 
                    
                    System.out.print("Title: ");
                    String t=sc.nextLine();
                    System.out.print("1- Work \n 2-Personal: ");
                    
                    int type=sc.nextInt(); 
                    sc.nextLine();
                    
                    tasks.add(type==1?new WorkTask(t):new PersonalTask(t));
                    System.out.print("\n-- add the Task !! -- \n");
                    break;

                case 2:
                    // task details
                    
                    if(tasks.isEmpty()) 
                    
                    System.out.println("No tasks.");
                    
                    else
                    {
                        for(int i=0;i<tasks.size();i++)
                        {
                            System.out.println(i+" → "+tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    // add complete task
                    System.out.print("Task : ");
                    int c=sc.nextInt(); 
                    sc.nextLine();
                    if(c>=0 && c<tasks.size())
                          tasks.get(c).complete();
                    else 
                             System.out.println("Invalid.");
                    break;

                case 4:
                    // delete item
                    System.out.print("Delete: ");
                    int d=sc.nextInt();
                    sc.nextLine();
                    if(d>=0 && d<tasks.size()) 
                        tasks.remove(d);
                    else
                          System.out.println("Invalid.");
                    break;

                case 5:
                    System.out.println("Bye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
