package additional;

// @note: iterator needs to be imported, while iterable doesn't
import java.util.Iterator;

// @note: iteralbe also typed
public class CircularArray<T> implements Iterable<T>{

	protected T[] array;
	protected int head;

	public CircularArray(int size){
		this.array = (T[]) new Object[size];
		this.head = 0;
	}

	public void rotateRight(int num){
		if(num < 0){
			throw new IllegalArgumentException("num cannot be negative");
		}
		// @note: longer than length: repeat
		num = num % array.length;
		// @note: the general rule, not initial special case
		this.head = this.head - num;
		// @note: the character of circular rotate, can add a time frame
		if(this.head < 0){
			this.head = this.head + array.length;
		}
	}

	public T get(int i){
		if(i < 0 || i > array.length){
			throw new ArrayIndexOutOfBoundsException();
		}
		int index = i + head;
		// @note: equaling is not right either
		if(index >= array.length){
			index = index - array.length;
		}
		return array[index];
	}

	public Iterator<T> iterator(){
		return new CircularArrayIterator<T>(this);
	}

	protected class CircularArrayIterator<T> implements Iterator<T>{
		protected CircularArray<T> ca;
		protected int current;
		public CircularArrayIterator(CircularArray<T> ca){
			this.ca = ca;
			this.current = 0;
		}

		public boolean hasNext(){
			if(this.current < ca.array.length){
				return true;
			}else{
				return false;
			}
		}

		public T next(){
			T result = ca.get(current);
			current++;
			return result;
		}

		public void remove(){
			throw new UnsupportedOperationException();
		}

	}



}