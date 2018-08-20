package chapter_1_stackandqueue;

import java.util.Stack;

public class Problem_01_GetMinStack {

	//第一个栈,第一种方法
	public static class MyStack1 {
	    //初始化两个栈,一个为正式使用的栈,一个为使用栈的最小元素
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		//栈初始化
		public MyStack1() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		//下压栈,并判断最小元素
		public void push(int newNum) {
		    //为空直接更新最小元素,非空判断是否更新最小元素
			if (this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			} else if (newNum <= this.getmin()) {
				this.stackMin.push(newNum);
			}
			//无论是否为空直接添加元素到栈顶
			this.stackData.push(newNum);
		}

		//获取栈顶元素
		public int pop() {
		    //如果为空则报异常
			if (this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			//获取栈顶元素
			int value = this.stackData.pop();
			//如果栈顶元素为当前最小,获取存储最小栈的栈顶元素为获取栈顶后的最小元素
			if (value == this.getmin()) {
				this.stackMin.pop();
			}
			return value;
		}

		//获取栈中最小元素
		public int getmin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			//返回栈顶的值,不删除栈顶的值
			return this.stackMin.peek();
		}
	}

	//第二个栈,第二种方法
	public static class MyStack2 {
	    //初始化常规栈和最小值栈
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MyStack2() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		//添加栈顶元素,
        // 如果栈为空直接添加最小元素到最小栈,
        // 如果小于最小栈也将当前元素添加到最小栈中,
        // 如果添加元素大于最小栈栈顶元素,添加最小栈站栈顶元素到最小栈
        //最后执行常规栈添加操作
		public void push(int newNum) {
			if (this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			} else if (newNum < this.getmin()) {
				this.stackMin.push(newNum);
			} else {
				int newMin = this.stackMin.peek();
				this.stackMin.push(newMin);
			}
			this.stackData.push(newNum);
		}

		//获取栈顶元素
        //判断是否为空栈
        //弹出小栈栈顶元素
        //获取常规栈顶元素
		public int pop() {
			if (this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			this.stackMin.pop();
			return this.stackData.pop();
		}

		//获取当前栈最小元素
        //非空判断
        //展示不删除最小栈栈顶元素
		public int getmin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return this.stackMin.peek();
		}
	}

	public static void main(String[] args) {
	    //初始化栈1
		MyStack1 stack1 = new MyStack1();
		stack1.push(3);//添加元素
		System.out.println(stack1.getmin());//获取最小值
		stack1.push(4);
		System.out.println(stack1.getmin());
		stack1.push(1);
		System.out.println(stack1.getmin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getmin());

		System.out.println("=============");

		MyStack1 stack2 = new MyStack1();
		stack2.push(3);
		System.out.println(stack2.getmin());
		stack2.push(4);
		System.out.println(stack2.getmin());
		stack2.push(1);
		System.out.println(stack2.getmin());
		System.out.println(stack2.pop());
		System.out.println(stack2.getmin());
	}

}
