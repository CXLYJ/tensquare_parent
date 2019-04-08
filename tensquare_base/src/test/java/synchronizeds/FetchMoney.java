package synchronizeds;

/**
 * Created by lyj on 2019/2/18.
 * synchronized测试
 */
public class FetchMoney {

    public static void main(String[] args) {
        Bank bank = new Bank();

        Thread t1 = new MoneyThread(bank); //从银行取钱
        Thread t2 = new MoneyThread(bank); //从银行取钱

        t1.start();
        t2.start();
    }

}

class Bank{
    private int money = 1000;

    /**
     * 当没有加synchronize运行结果：
     *
     * Left Money: 200
     * 800
     * Left Money: -600
     * 800
     * 因为getMoney()方法中有一些逻辑判断，进入最后一个else语句块后，有一个简短的休眠，那么在第一个线程休眠的过程中，
     * 第二个线程也成功进入了这个else语句块（因为存款的钱还没有取走），
     * 当两个线程结束休眠后，不再进行逻辑判断而是直接将钱取走，所以两个线程都取到了800元钱，此时money为负600。
     *
     * 需要注意这里并不能确定哪一个线程是第一个线程，哪一个线程是第二个线程，先后顺序是不定的。
     *
     * @param number
     * @return
     */

    /**
     * 加上synchronize后
     *
     * Left Money: 200
     * 800
     * -2
     * @param number
     * @return
     */
    public synchronized int getMoney(int number){
        if (number < 0){
            return -1;
        }
        else if (number > money){
            return -2;
        }
        else if (money < 0){
            return -3;
        }
        else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= number;

            System.out.println("Left Money: " + money);
            return number;
        }
    }
}

class MoneyThread extends Thread{

     private Bank bank;

    public MoneyThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
       int number = bank.getMoney(800);
        System.out.println(number);
    }
}