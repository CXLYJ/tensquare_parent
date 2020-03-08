package Off;

import java.util.Stack;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/3/8 14:40
 *
 * 用两个栈来实现一个队列，完成队列的push和pop操作，队列中的元素为int类型
 */
public class Solution29 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }

        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
