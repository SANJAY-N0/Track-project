///  TASK-02 

import java.util.ArrayList;
import java.util.Scanner;

public class Taskappsecond 
{

    // User
    static class User
    {
        String user, pass;

        User(String u, String p) 
        {
            user = u;
            pass = p;
        }

        boolean check(String p)
        {
            return pass.equals(p);
        }
    }

    // Task- base
    static abstract class Task
    {
        String title;
        boolean done = false;

        Task(String t) 
        {
            title = t;
        }

        void complete()
        {
            done = true;
        }

        abstract String type();

        public String toString() 
        {
            return "[" + type() + "] " + title + (done ? " /" : " ✗");
        }
    }

    // work
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

    // personal
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

    // ---------- MAIN ----------
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("admin", "123"));   // login user
        ArrayList<Task> tasks = new ArrayList<>();
        User current = null;

        // login page start 
        while (current == null)
        {
            System.out.println("\n========== LOGIN PAGE ==========");
            System.out.print("Username: ");
            String u = sc.nextLine();
            System.out.print("Password: ");
            String p = sc.nextLine();
            System.out.println("================================");

            for (User x : users)
                if (x.user.equals(u) && x.check(p))
                    current = x;

            if (current == null)
                System.out.println("Wrong username or password\n");
        }

        // menu items 
        while (true)
        {
            System.out.println("\n======== TASK MANAGER ========");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.println("================================");
            System.out.print("Choose: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch)
            {
                case 1:
                    System.out.print("Title: ");
                    String t = sc.nextLine();

                    System.out.print("1-Work\n2-Personal\nChoose: ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    tasks.add(type == 1 ? new WorkTask(t) : new PersonalTask(t));
                    System.out.println(" -> Task Added!");
                    break;

                case 2:
                    // view the task
                    if (tasks.isEmpty())
                        System.out.println("No tasks yet.");
                    else
                    {
                        for (int i = 0; i < tasks.size(); i++)
                            System.out.println(i + " -> " + tasks.get(i));
                    }
                    break;

                case 3:
                    // complete the task 
                    System.out.print("Task No: ");
                    int c = sc.nextInt();
                    sc.nextLine();
                    if (c >= 0 && c < tasks.size())
                        tasks.get(c).complete();
                    else
                        System.out.println("Invalid task.");
                    break;

                case 4:
                    // delete the task
                    System.out.print("Delete No: ");
                    int d = sc.nextInt();
                    sc.nextLine();
                    if (d >= 0 && d < tasks.size())
                        tasks.remove(d);
                    else
                        System.out.println("Invalid index.");
                    break;

                case 5:
                    // exit code 
                    System.out.println(" Bye!");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

