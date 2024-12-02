import java.util.Scanner;

//Received tutoring from Joshua Ronai
//Michael Buzzetta
//I pledge my honor that I have abided by the Stevens Honor System

public class TestTaskList<E>
{
    /*
    this class and its code are the basis for the test code used for the user input section
     */
    TaskList<E> toDoList=new TaskList<>();
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        TestTaskList test=new TestTaskList();
        test.printMenu();
    }

    public void printMenu()
    {
        System.out.println("~~~ TO-DO List Program, created by truly yours ~~~");
        boolean test=true;
        while(test) {
            if (toDoList.getActive().getSize() == 0) {
                System.out.println("==> Currently there are NO items in the To-Do List");
            } else {
                System.out.println("Current TO-DO List:");
                System.out.println("-------------------");
                toDoList.showActiveTasks();
            }
            System.out.println("To add a new task without priority information, press 1.");
            System.out.println("To add a new task with a priority information, press 2.");
            System.out.println("To cross off the task at the top of the list, press 3.");
            System.out.println("To cross off a certain task in the list, press 4.");
            System.out.println("To see the top 3 highest priority tasks, press 5.");
            System.out.println("To see the completed tasks, press 6.");
            System.out.println("To see the all tasks that has been completed or still active, press 7.");
            System.out.println("To quit the program, press 8.");
            String menuItem = scan.nextLine();
            try
            {
                test=processMenuItem(Integer.parseInt(menuItem));
            }
            catch(NumberFormatException E)
            {
                System.out.println("ERROR! Please enter a number between 1 and 8 (included).");
            }
        }


    }

    private boolean processMenuItem(int menuItem)
    {
        if(menuItem==1)
        {
            System.out.println("Please enter the task description:");
            String task=scan.nextLine();
            toDoList.createTask((E) task);
            System.out.println("Successfully entered the task to the to-do list!");
        }
        else if(menuItem==2)
        {
            System.out.println("Please enter the task description:");
            String task=scan.nextLine();
            System.out.println("Please enter a priority number (1 indicates highest priority, increasing\n" +
                    "numbers show lower priority) :");
            String priority=scan.nextLine();
            toDoList.createTask((E) task, Integer.parseInt(priority));
            System.out.println("Successfully entered the to-do list!");
        }
        else if(menuItem==3)
        {
            E task=toDoList.getActive().peek();
            toDoList.crossOffMostUrgent();
            System.out.println("Task is completed and removed from the list: "+task);
            System.out.println("Successfully removed the most urgent task/top of the list task!");
        }
        else if(menuItem==4)
        {
            System.out.println("Please enter the task number you would like to cross off the list :");
            String certain=scan.nextLine();
            E task = toDoList.getActive().peek();
            boolean removed=toDoList.crossOffTask(Integer.parseInt(certain));
            if(!removed)
            {
                System.out.println("Unsuccessful operation! Please try again!");
            }
            else
            {
                System.out.println("Task number " + certain + " is removed: " + task);
                System.out.println("Successfully removed the task number: " + certain);
            }

        }
        else if(menuItem==5)
        {
            System.out.println("Top 3 highest priority tasks:");
            System.out.println("------------------------------");
            System.out.println("Printing Top Three Tasks...");
            toDoList.printTopThree();
        }
        else if(menuItem==6)
        {
            System.out.println("Completed Tasks: ");
            System.out.println("----------------");
            toDoList.showCompletedTasks();
        }
        else if(menuItem==7)
        {
            System.out.println("All of the Tasks - Both completed and active:");
            System.out.println("---------------------------------------------");
            toDoList.showAllTasks();
        }
        else if(menuItem==8)
        {
            return false;
        }
        else
        {
            System.out.println("ERROR! Please enter a number between 1 and 8 (included).");
        }

        return true;
    }
}
