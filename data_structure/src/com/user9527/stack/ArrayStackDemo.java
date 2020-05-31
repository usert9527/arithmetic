package com.user9527.stack;

import java.util.Scanner;

/**
 * @Author: yangtao
 * @date: 2020/5/31 - 12:04
 * 栈是一个先入后出的有序列表 （FFLO）
 *      使用数组实现栈思路：
 *          1. 使用数组模拟栈
 *          2. 定义一个top 来表示栈顶，初始化位 -1
 *          3. 入栈：top ++, stack[top] = date
 *          4. 出栈：Object value = stack[top] , top -- , return value
 *
 */
public class ArrayStackDemo
{
    public static void main(String[] args)
    {
        ArrayStack<Object> stack = new ArrayStack<>(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop)
        {
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：入栈");
            System.out.println("pop：出栈");
            System.out.println("请输入你的选择：");
            key = scanner.next();

            switch (key)
            {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入入栈的数据：");
                    String next = scanner.next();
                    stack.push(next);
                    break;
                case "pop":
                    try{
                        Object pop = stack.pop();
                        System.out.printf("出栈的数据是%s\n",pop);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                case "exit":
                    scanner.close();
                    break;
                default:
                    break;
            }
        }

    }
}

class ArrayStack <T>
{
    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 数组，数组模拟栈，数据就放在该数组中
     */
    private Object[] stack;

    /**
     * top 表示栈顶，初始化 -1
     */
    private int top = -1;

    public ArrayStack(int maxSize)
    {
        this.maxSize = maxSize;
        stack = new Object[this.maxSize];
    }

    /**
     * 栈满
     * @return
     */
    public boolean isFull()
    {
        return top == maxSize -1;
    }

    /**
     * 栈空
     * @return
     */
    public boolean isEmpty()
    {
        return top == -1;
    }

    /**
     * 入栈
     */
    public void push(T date)
    {
        // 1. 先判断是否满
        if(isFull())
        {
            System.out.println("栈满");
            return;
        }
        top ++;
        stack[top] = date;
    }

    /**
     * 出栈：将栈顶的数据返回
     * @return
     */
    public T pop()
    {
        // 1. 先判断是否为空
        if(isEmpty())
        {
            throw new RuntimeException("栈空，没有数据");
        }
        Object value = stack[top];
        top --;
        return (T)value;
    }

    /**
     * 遍历栈
     */
    public void list()
    {
        // 1. 先判断是否为空
        if(isEmpty())
        {
            System.out.println("栈空，没有数据");
            return;
        }

        for (int i = top; i >=0; i--)
        {
            System.out.printf("stack[%d]=%s\n",i,stack[i]);
        }
    }
}
