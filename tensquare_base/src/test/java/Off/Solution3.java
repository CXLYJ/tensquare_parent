package Off;

import java.util.Stack;

/**
 * Created by lyj on 2019/1/31.
 * 剑指off
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Solution3 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

//    public void push(int node){
//        stack1.push(node);
//    }
//
//    public int pop(){
//        while (!stack1.isEmpty()){
//            stack2.push(stack1.pop());
//        }
//        int first = stack2.pop();
//        while (!stack2.isEmpty()){
//            stack1.push(stack2.pop());
//        }
//        return first;
//    }


    /**
     * 入栈操作
     * @param node
     */
    public void push(int node){
        stack1.push(node);
    }

    /**
     * 出栈操作
     */
    public int pop(){
        if (stack1.empty()&&stack2.empty()){
            //如果两个队列都为空的话抛出运行时异常
            throw new RuntimeException("Queue is empty!");
        }
        //如果队列2为空
        if (stack2.empty()){
            while (!stack1.empty()){
                //队列1不为空将队列1出栈队列2入栈
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop(); //移除堆栈顶部的对象，并作为此函数的值返回该对象
    }


}
