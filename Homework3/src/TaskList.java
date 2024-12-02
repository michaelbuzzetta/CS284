import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

//Received tutoring from Joshua Ronai
//Michael Buzzetta
//I pledge my honor that I have abided by the Stevens Honor System

public class TaskList<E>
{
    /*
    This class and all its code is responsible for creating, storing and tracking the task list that is used during the
    user input section
     */
    ListQueue<E> all;
    ListQueue<E> completed;
    ListQueue<E> active;
    private int LOW_PRIORITY = Integer.MAX_VALUE;
    private int HIGH_PRIORITY=1;

    public ListQueue<E> getAll() {
        return all;
    }

    public void setAll(ListQueue<E> all) {
        this.all = all;
    }

    public ListQueue<E> getCompleted() {
        return completed;
    }

    public void setCompleted(ListQueue<E> completed) {
        this.completed = completed;
    }

    public ListQueue<E> getActive() {
        return active;
    }

    public void setActive(ListQueue<E> active) {
        this.active = active;
    }

    public TaskList()
    {
        all=new ListQueue<>();
        completed=new ListQueue<>();
        active=new ListQueue<>();
    }

    public boolean createTask(E item)
    {
        if (item==null)
        {
            return false;
        }
        active.offer(item, LOW_PRIORITY);
        all.offer(item, LOW_PRIORITY);
        return true;
    }

    public boolean createTask(E item, int priority)
    {
        if (item==null)
        {
            return false;
        }
        active.offer(item, priority);
        all.offer(item, priority);
        return true;
    }

    public void printTopThree()
    {
        Iterator<E> it = active.iterator();
        int i=0;
        while(i<3)
        {
            if(i+1> active.getSize())
            {
                throw new NoSuchElementException("There are no more elements");
            }
            E task=it.next();
            System.out.println(task);
            i++;
        }
    }

    private void printTasks(ListQueue<E> queue)
    {
        ListQueue.Node<E> current = queue.getFront();
        int x=1;
        while(x<= queue.getSize())
        {
            E task=current.getData();
            System.out.println(x + ". " +task);
            x++;
            current=current.getNext();
        }
    }

    public void showActiveTasks()
    {
        printTasks(active);
    }

    public void showAllTasks()
    {
        printTasks(all);
    }

    public void showCompletedTasks()
    {
        printTasks(completed);
    }

    public boolean crossOffMostUrgent()
    {
        if(active.getSize()==0)
        {
            System.out.println("there is nothing here!");
            return false;
        }

        E task=active.poll();
        completed.offer(task,LOW_PRIORITY);
        return true;
    }

    public boolean crossOffTask(int taskNumber)
    {
        if(taskNumber<1||taskNumber> active.getSize())
        {
            return false;
        }
        ListQueue.Node<E> current = active.getFront();
        for(int i=1; i<taskNumber; i++)
        {
            current=current.getNext();
        }
        E data1 = current.getData();
        active.remove(current);
        completed.offer(data1, taskNumber);
        return true;
    }
}
