package cycOffer;

import java.util.Stack;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/12/2
 *
 * 包含min函数的栈
 */
public class Offer30 {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node){
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop(){
        dataStack.pop();
        minStack.pop();
    }

    public int top(){
        return dataStack.peek();
    }

    public int min(){
        return minStack.peek();
    }

}
