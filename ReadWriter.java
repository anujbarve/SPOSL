public class ReadWriter { static int
    mutex = 1; static int database = 1;
    static int Read_Count = 0; static void
    Reader() throws Exception { while
    (true) { mutex = wait(mutex);
    Read_Count += 1; if (Read_Count ==
    1) { database = signal(database);
    }
    mutex = signal(mutex);
    System.out.println(Read_Count + "user reading data.....");
    mutex = wait(mutex); Read_Count -= 1; if (Read_Count
    == 0) { database = signal(database);
    }
    mutex = signal(mutex);
    System.out.println("Reading finished..!!!");
    break;
    }
    }
    static int wait(int mutex) {
    while (mutex <= 0) {
    break;} mutex -= 1;
    return mutex;
    }
    static int signal(int database) {
    database += 1; return
    database;
    }
    static void Writer() throws Exception {
    while (true) { database =
    wait(database);
    System.out.println("writing on database...");
    database = signal(database);
    System.out.println("writing finished!!!");
    break;
    }
    }
    public static void main(String[] args) throws Exception {
    
    Writer();
    Reader();
    Reader();
    }
}