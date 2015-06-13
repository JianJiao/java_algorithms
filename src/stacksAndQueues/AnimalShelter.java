package stacksAndQueues;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AnimalShelter{

	protected LinkedList<Animal> ll = new LinkedList<Animal>();

	// @assume: should only add cat or dog
	public Animal enqueue(Animal ani){
		if(!(ani instanceof Dog) && !(ani instanceof Cat)){
			throw new IllegalArgumentException("only dogs and cats are allowed");
		}
		ll.add(ani);
		return ani;
	}

	public Animal dequeueAny(){
		// @note: should remove first, not last
		return ll.removeFirst();
	}

	public Dog dequeueDog(){
		for(int i=0; i<ll.size(); i++){
			Animal ani = ll.get(i);
			if(ani instanceof Dog){
				// @should also remove it!
				ll.remove(i);
				return (Dog)ani;
			}
		}
		throw new NoDogException();
	}

	public Cat dequeueCat(){
		for(int i=0; i<ll.size(); i++){
			Animal ani = ll.get(i);
			if(ani instanceof Cat){
				// @should also remove it!
				ll.remove(i);
				return (Cat) ani;
			}
		}
		throw new NoCatException();
	}

	protected class NoDogException extends NoSuchElementException{}

	protected class NoCatException extends NoSuchElementException{}
}