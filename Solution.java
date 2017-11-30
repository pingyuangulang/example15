/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 吉彬
 */
import java.util.Stack;
public class Solution {
    public static void main(String[] args){
        
    }
    /*
    问题：
    输入两个整数序列，第一个序列表示栈的压入顺序，
    请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
    例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
    但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
    */
    
    /*
    解决思路：
    先将压入序列的第一个元素入栈，
    然后栈顶元素与弹出序列的第一个元素比较，
    如果不相等则将压入序列的下一个元素入栈；
    如果相等则出栈，再拿栈顶元素与弹出序列的下一个元素比较，如此反复进行。
    在入栈时压入序列已无元素可入栈，则说明弹出序列与压入序列不对应。
    */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean flag = false;
        if(pushA!=null&&popA!=null&&pushA.length==popA.length&&popA.length!=0){
            flag = true;
            int push_index = 0,pop_index=0;
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(pushA[push_index++]);//先往栈中压入一个数字
            while(pop_index<popA.length){
                //出栈数字不是栈顶元素，且压栈序列中有元素可入栈，则入栈
                while(stack.peek()!=popA[pop_index]&&push_index<pushA.length){
                    stack.push(pushA[push_index++]);
                }
                //判断上面while循环是因为那种原因退出的
                if(stack.peek()==popA[pop_index]){
                    pop_index++;
                    stack.pop();
                }
                else if(push_index>=pushA.length){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}