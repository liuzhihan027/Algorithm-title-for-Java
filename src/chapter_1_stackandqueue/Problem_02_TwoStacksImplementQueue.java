package chapter_1_stackandqueue;

import java.util.Stack;

//使用两个形成队列
public class Problem_02_TwoStacksImplementQueue {

	public static class TwoStacksQueue {
		public Stack<Integer> stackPush;
		public Stack<Integer> stackPop;

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		public void add(int pushInt) {
			stackPush.push(pushInt);
		}

		public int poll() {
		    //执行时保证将添加栈中的全部元素一次性压入获取栈
            //保证将添加栈导入获取栈时获取栈为空的,否则添加栈不变,直接从获取栈中拿,知道拿空才执行一次性倒入
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}

		//算法描述同出队列
		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}
	}

	public static void main(String[] args) {
		TwoStacksQueue test = new TwoStacksQueue();
		test.add(1);
		test.add(2);
		test.add(3);
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());

        test.add(11);
        test.add(22);
        System.out.println(test.poll());
        test.add(33);
        test.add(44);
        System.out.println(test.poll());
        System.out.println(test.poll());
        System.out.println(test.poll());
	}

}
