package stacksAndQueues;

public class Test{

	public static void main(String[] args){
		Test test = new Test();
		test.testArrayThreeStacks();
		test.testArrayStack();
		// test.testStackWithMin();
		test.testSetOfStacks();
		test.testHanoi();
		test.testStack();
		test.testMyQueue();
	}

	public void testMyQueue(){
		end();
		start("my queue");

		MyQueue<Integer> mq = new MyQueue<Integer>();
		mq.enqueue(3);
		mq.enqueue(3);
		mq.enqueue(2);
		mq.enqueue(1);
		System.out.println(mq.dequeue());
		System.out.println(mq.dequeue());
		mq.enqueue(0);
		mq.enqueue(9);
		System.out.println(mq.dequeue());
		System.out.println(mq.dequeue());
		System.out.println(mq.dequeue());
		System.out.println(mq.dequeue());
		mq.enqueue(0);
		mq.enqueue(3);
		System.out.println(mq.dequeue());
		System.out.println(mq.dequeue());
		mq.enqueue(0);
		System.out.println(mq.dequeue());
		mq.enqueue(3);
		System.out.println(mq.dequeue());


		end();
	}
	

	public void testStack(){
		end();
		start("stack");
		Stack<Integer> s = new Stack<Integer>();
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());

		end();
	}


	public void testHanoi(){
		end();
		start("Hanoi");
		Hanoi han = new Hanoi(5);
		// for(int i=0; i<5; i++){
		// 	System.out.println(han.stacks[0].pop());
		// }
		han.moveAllToThird();
		for(int i=0; i<5; i++){
			System.out.println(han.stacks[2].pop());
		}
		end();
	}

	public void testSetOfStacks(){
		end();
		start("set of stacks");
		SetOfStacks ss = new SetOfStacks();
		ss.push(3);
		ss.push(2);
		ss.push(1);
		ss.push(0);
		ss.push(-1);
		println(ss.pop());
		println(ss.pop());
		println(ss.pop());
		println(ss.pop());
		println(ss.pop());

		end();

		ss.push(3);
		ss.push(2);
		ss.push(1);
		ss.push(0);
		ss.push(-1);
		ss.push(3);
		ss.push(2);
		ss.push(3);
		ss.push(2);
		ss.push(1);	//  10
		ss.push(0);
		ss.push(-1);
		ss.push(1);
		ss.push(3);
		ss.push(2);
		ss.push(1);
		ss.push(0);
		ss.push(-1);
		ss.push(3);
		ss.push(2);  // 20
		ss.push(3);
		ss.push(2);
		ss.push(3);
		ss.push(2);
		ss.push(1);
		ss.push(0);
		ss.push(-1);
		ss.push(1);
		ss.push(0);
		ss.push(-1);	 //30
		ss.push(1);
		ss.push(0);
		ss.push(-1);
		ss.push(0);
		ss.push(3);
		ss.push(2);
		ss.push(1);
		ss.push(0);
		ss.push(-1);
		ss.push(-1);

		println(ss.popAt(0));
		println(ss.pop());
		println(ss.pop());
		println(ss.pop());
		println(ss.popAt(0));
		println(ss.popAt(2));
		end();
		ss.push(3);
		ss.push(2);
		println(ss.pop());
		println(ss.pop());
		println(ss.pop());
		println(ss.pop());




		end();
	}



	public void testStackWithMin(){
		end();
		start("stack with min");
		StackWithMin swm = new StackWithMin();
		println(swm.min());
		swm.push(4);
		println(swm.min());
		swm.push(5);
		println(swm.min());
		swm.push(3);
		println(swm.min());

		end();

		println(swm.pop());
		println(swm.min());
		println(swm.pop());
		println(swm.min());
		println(swm.pop());
		println(swm.min());
		println(swm.pop());
		println(swm.min());

		end();
	}


	public void testArrayStack(){
		end();
		start("array stack");
		ArrayStack as = new ArrayStack();
		as.push(0, 1);
		as.push(0, 2);
		as.push(0, 3);
		as.push(0, 3);
		as.push(0, 3);
		as.push(2, 4);
		as.push(2, 5);
		as.push(2, 7);
		as.push(2, 8);
		// as.push(1, 2);
		// as.push(1, 3);
		for(int i=0; i<5; i++){
			Object result = as.pop(0);
			System.out.println(result);
		}
		for(int i=0; i<4; i++){
			Object result = as.pop(2);
			System.out.println(result);
		}



		end();
	}


	public void testArrayThreeStacks(){
		start("array three stacks");

		ArrayThreeStacks tStack = new ArrayThreeStacks();
		Object obj = tStack.pop(1);
		println(obj);

		tStack.push(1, 3);
		obj = tStack.pop(1);
		println(obj);

		tStack.push(0, 0);
		tStack.push(0, 1);
		tStack.push(0, 2);
		tStack.push(0, 3);
		for(int i=0; i<4; i++){
			obj = tStack.pop(0);
			println(obj);
		}


		end();
	}


	public static void println(Object obj){
		System.out.println(obj);
	}

	public static void start(String str){
		System.out.println("***testing " + str);
	}

	public static void end(){
		System.out.println();
	}
}