import java.util.Scanner;

abstract class Person{
    private String name;
    private int balance;
    private int number;

    Person(String name,int number) {
        this.name = name;
        this.number = number;
    }

    public void addBalance(int balance) { this.balance += balance; }
    public void deductBalance(int a) {
        this.balance -= a;
    }

    void paidMoney(int amount) {
        deductBalance(amount);
    }

    abstract boolean isEligible();
    abstract String PersonIS();

    public String getName() { return name; }
    public int getBalance() { return balance; }
    public int getNumber() { return number; }

}

class User extends Person {
    User(String name,int n) {
        super(name,n);
    }

    @Override
    String PersonIS() {
        return "Normal Person";
    }

    @Override
    boolean isEligible() {
        return false;
    }
}

class VIP extends Person {
    VIP(String name,int n) {
        super(name,n);
    }

    @Override
    String PersonIS() {
        return "VIP Person";
    }

    @Override
    boolean isEligible() {
        return true;
    }
}

class Bank {
    private Person[] users;
    private int count;

    Bank() {
        users = new Person[10];
    }

    public boolean addUser(Person user) {
        for (int i=0;i<count;i++) {
            if (users[i].getNumber() == user.getNumber()) {
                return false;
            }
        }
        if (count < users.length) {
            users[count++] = user;
            return true;
        }
        return false;
    }

    public boolean PayToPay(int sender,int receiver,int amount) {
        if (amount > 0) {
            for (int i=0;i<count;i++) {
                if (users[i].getNumber() == sender) {
                    for (int j=0;j<count;j++) {
                        if (users[j].getNumber() == receiver) {
                            if (users[i].getBalance() >= amount) {
                                users[i].paidMoney(amount);
                                users[j].addBalance(amount);
                                if (users[i].isEligible()) {
                                    users[i].addBalance((int)(amount * (0.10f)));
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean AddMoney(int number,int balance) {
        if (balance > 0) {
            for (int i=0;i<count;i++) {
                if (users[i].getNumber() == number) {
                    users[i].addBalance(balance);
                    return true;
                }
            }
        }
        return false;
    }

    public Person viewBalance(int num) {
        for (int i=0;i<count;i++) {
            if (num == users[i].getNumber()) {
                return users[i];
            }
        }
        return null;
    }
}

class PhonePe{
    static void showMenu() {
        System.out.print("\n1.Add User\n2.PaymentMethod\n3.Add Money\n4.View Account\n5.Exit");
    }
    public static void main(String[] args) {
        Person user;
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        showMenu();
        boolean isRun = true;
        while (isRun) {
            System.out.print("\nChoose Option: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("\n1.Normal User\n2.VIP User");
                    System.out.print("Choose Option: ");
                    int chooseAgain = sc.nextInt();
                    switch (chooseAgain) {
                        case 1:
                            sc.nextLine();
                            System.out.print("Enter User Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter User Phone Number: ");
                            int number = sc.nextInt();
                            user = new User(name, number);
                            if (bank.addUser(user)) {
                                System.out.println("User " + name + " Created Successfully!");
                                System.out.println(name+" Balance Is: "+user.getBalance());
                            } else {
                                System.out.println("Not Created Due to spacefull!");
                            }
                            break;

                        case 2:
                            sc.nextLine();
                            System.out.print("Enter User Name: ");
                            String name1 = sc.nextLine();
                            System.out.print("Enter User Phone Number: ");
                            int number1 = sc.nextInt();
                            user = new VIP(name1,number1);
                            if (bank.addUser(user)) {
                                System.out.println("VIP User " + name1 + " Created Successfully!");
                                System.out.println(name1+" Balance Is: "+user.getBalance());
                            } else {
                                System.out.println("Not Created Due to spacefull!");
                            }
                            break;
                    }
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Number Of Senders: ");
                    int numberWhoPaying = sc.nextInt();
                    System.out.print("Enter Number Of Recievers: ");
                    int numberWhogetPaid = sc.nextInt();
                    System.out.print("Enter Amount To Send: ");
                    int paidamount = sc.nextInt();
                    if (bank.PayToPay(numberWhoPaying,numberWhogetPaid,paidamount)) {
                        System.out.println("Successfully Paid");
                    }
                    else {
                        System.out.println("Something is Wrong!");
                    }
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Number Of User: ");
                    int numberUser = sc.nextInt();
                    System.out.print("Enter Amount To Add: ");
                    int deposite = sc.nextInt();
                    if (bank.AddMoney(numberUser,deposite)) {
                        System.out.println("Money Deposite Successfully!");
                    }
                    else {
                        System.out.println("Something is Wrong!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Number: ");
                    int num = sc.nextInt();
                    Person a = bank.viewBalance(num);
                    if (a != null) {
                        System.out.println("Person Is: "+a.PersonIS());
                        System.out.println("User Name: "+a.getName());
                        System.out.println("User Balance: "+a.getBalance());
                    }
                    else {
                        System.out.println("No User Found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank You Bye!");
                    isRun = false;
                    break;

            }
        }
    }
}