
import java.util.*;

// Account abstract sınıfı
abstract class Account {
    protected int ID; 
    protected int balance;
    
    public Account(int ID, int balance) {
        this.ID = ID;
        this.balance = balance;
    }
    
    public abstract void deposit(int amount);
    
    public abstract void withdraw(int amount);
    
    public int getBalance() {
        return balance;
    }
    
    public int getID() {
        return ID;
    }
    
    public abstract double calculateBenefit();
}

// ShortTerm sınıfı
class ShortTerm extends Account {
    static final int MIN_BALANCE = 1000;
    private static final double INTEREST_RATE = 0.17;
    
    public ShortTerm(int ID, int balance) {
        super(ID, balance);
    }
    
    public void deposit(int amount) {
        balance += amount;
    }
    
    public void withdraw(int amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
        } else {
            System.out.println("Çekilebilecek miktarı aştınız!");
        }
    }
    
    public double calculateBenefit() {
        Date currentDate = new Date();
        Date openingDate = new Date(2023, 5, 5); // Başlangıç tarihi (05.05.2023)
        long timeDiff = currentDate.getTime() - openingDate.getTime();
        int daysPassed = (int) (timeDiff / (24 * 60 * 60 * 1000)); // Gün cinsinden geçen süre
        
        double dailyInterestRate = INTEREST_RATE / 365;
        double benefit = balance * dailyInterestRate * daysPassed;
        
        return benefit;
    }
}

// LongTerm sınıfı
class LongTerm extends Account {
    static final int MIN_BALANCE = 1500;
    private static final double INTEREST_RATE = 0.24;
    
    public LongTerm(int ID, int balance) {
        super(ID, balance);
    }
    
    public void deposit(int amount) {
        balance += amount;
    }
    
    public void withdraw(int amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
        } else {
            System.out.println("Çekilebilecek miktarı aştınız!");
        }
    }
    
    public double calculateBenefit() {
        Date currentDate = new Date();
        Date openingDate = new Date(2023, 5, 5); // Başlangıç tarihi (05.05.2023)
        long timeDiff = currentDate.getTime() - openingDate.getTime();
        int daysPassed = (int) (timeDiff / (24 * 60 * 60 * 1000)); // Gün cinsinden geçen süre
        
        double dailyInterestRate = INTEREST_RATE / 365;
        double benefit = balance * dailyInterestRate * daysPassed;
        
        return benefit;
    }
}

// Special sınıfı
class Special extends Account {
    private int initialBalance;
    private static final double INTEREST_RATE = 0.12;
    
    public Special(int ID, int balance) {
        super(ID, balance);
        this.initialBalance = balance;
    }
    
    public void deposit(int amount) {
        balance += amount;
    }
    
    public void withdraw(int amount) {
        if (balance - amount >= initialBalance) {
            balance -= amount;
        } else {
            System.out.println("Çekilebilecek miktarı aştınız!");
        }
    }
    
    public double calculateBenefit() {
        Date currentDate = new Date();
        Date openingDate = new Date(2023, 5, 5); // Başlangıç tarihi (05.05.2023)
        long timeDiff = currentDate.getTime() - openingDate.getTime();
        int daysPassed = (int) (timeDiff / (24 * 60 * 60 * 1000)); // Gün cinsinden geçen süre
        
        double dailyInterestRate = INTEREST_RATE / 365;
        double benefit = balance * dailyInterestRate * daysPassed;
        
        return benefit;
    }
}

// Current sınıfı
class Current extends Account {
    public Current(int ID, int balance) {
        super(ID, balance);
    }
    
    public void deposit(int amount) {
        balance += amount;
    }
    
    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Çekilebilecek miktarı aştınız!");
        }
    }
    
    public double calculateBenefit() {
        return 0; // Faizsiz hesap
    }
}

// Bank sınıfı
class Bank {
    private List<Account> accounts;
    private Date currentDate;
    
    public Bank() {
        accounts = new ArrayList<>();
        currentDate = new Date(2023, 5, 5); // Başlangıç tarihi (05.05.2023)
    }
    
    public void getAccount() {
        for (Account account : accounts) {
            System.out.println("Hesap No: " + account.getID() + ", Bakiye: " + account.getBalance());
        }
    }
    
    public void getDate() {
        System.out.println("Şu anki tarih: " + currentDate);
    }
    
    public void deposit(int ID, int cash) {
        Account account = findAccount(ID);
        if (account != null) {
            account.deposit(cash);
            System.out.println(cash + " TL hesaba yatırıldı.");
        } else {
            System.out.println("Hesap bulunamadı!");
        }
    }
    
    public void withdraw(int ID, int cash) {
        Account account = findAccount(ID);
        if (account != null) {
            account.withdraw(cash);
            System.out.println(cash + " TL hesaptan çekildi.");
        } else {
            System.out.println("Hesap bulunamadı!");
        }
    }
    
    public void set_dd_mm_yy(int day, int month, int year) {
        currentDate = new Date(year, month, day);
    }
    
    public void showAccount() {
        for (Account account : accounts) {
            System.out.println("Hesap No: " + account.getID());
            System.out.println("Son 5 işlem:");
            System.out.println("Bakiye: " + account.getBalance());
            System.out.println("Kar: " + account.calculateBenefit());
            System.out.println("------------");
        }
    }
    
    public void showIDs() {
        for (Account account : accounts) {
            System.out.println("Hesap No: " + account.getID());
        }
    }
    
    public void sortition() {
        List<Special> specialAccounts = new ArrayList<>();
        int totalPoints = 0;
        
        for (Account account : accounts) {
            if (account instanceof Special) {
                specialAccounts.add((Special) account);
                totalPoints += account.getBalance() / 2000;
            }
        }
        
        if (specialAccounts.size() == 0) {
            System.out.println("Özel hesap bulunamadı!");
            return;
        }
        
        Random random = new Random();
        int winningNumber = random.nextInt(totalPoints) + 1;
        int accumulatedPoints = 0;
        
        for (Special account : specialAccounts) {
            accumulatedPoints += account.getBalance() / 2000;
            if (accumulatedPoints >= winningNumber) {
                account.deposit(10000);
                System.out.println("Çekiliş sonucu " + account.getID() + " hesabına 10000 TL ödül yatırıldı.");
                break;
            }
        }
    }
    
    private Account findAccount(int ID) {
        for (Account account : accounts) {
            if (account.getID() == ID) {
                return account;
            }
        }
        return null;
    }
    
    public void create_S_ID_balance(int ID, int balance) {
        if (findAccount(ID) == null) {
            if (balance >= ShortTerm.MIN_BALANCE) {
                Account account = new ShortTerm(ID, balance);
                accounts.add(account);
                System.out.println("Kısa vadeli hesap oluşturuldu. Hesap No: " + ID);
            } else {
                System.out.println("Başlangıç parası yetersiz!");
            }
        } else {
            System.out.println("Bu ID'ye sahip bir hesap zaten bulunmaktadır!");
        }
    }
    
    public void create_L_ID_balance(int ID, int balance) {
        if (findAccount(ID) == null) {
            if (LongTerm.MIN_BALANCE >= balance) {
                System.out.println("Başlangıç parası yetersiz!");
            } else {
                Account account = new LongTerm(ID, balance);
                accounts.add(account);
                System.out.println("Uzun vadeli hesap oluşturuldu. Hesap No: " + ID);
            }
        } else {
            System.out.println("Bu ID'ye sahip bir hesap zaten bulunmaktadır!");
        }
    }
    
    public void create_O_ID_balance(int ID, int balance) {
        if (findAccount(ID) == null) {
            Account account = new Special(ID, balance);
            accounts.add(account);
            System.out.println("Özel hesap oluşturuldu. Hesap No: " + ID);
        } else {
            System.out.println("Bu ID'ye sahip bir hesap zaten bulunmaktadır!");
        }
    }
    
    public void create_C_ID_balance(int ID, int balance) {
        if (findAccount(ID) == null) {
            Account account = new Current(ID, balance);
            accounts.add(account);
            System.out.println("Cari hesap oluşturuldu. Hesap No: " + ID);
        } else {
            System.out.println("Bu ID'ye sahip bir hesap zaten bulunmaktadır!");
        }
    }
}

// Ana sınıf
public class BankApplication {
    public static void main(String[] args) {
        Bank bank = new Bank();
        
        bank.create_S_ID_balance(1, 2000);
        bank.create_L_ID_balance(2, 3000);
        bank.create_O_ID_balance(3, 5000);
        bank.create_C_ID_balance(4, 1000);
        
        bank.deposit(1, 1000);
        bank.withdraw(2, 2000);
        
        bank.set_dd_mm_yy(15, 5, 2023);
        bank.showAccount();
        
        bank.sortition();
        
        bank.showIDs();
    }
}