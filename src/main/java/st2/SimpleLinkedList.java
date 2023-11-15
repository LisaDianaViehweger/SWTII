/*
 * (c) 2013-2021  Heinrich Hussmann und Uwe Aßmann, TU Dresden
 */
package st2;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * Achtung! Einige der Methoden sind fehlerhaft und müssen repariert werden.
 */
public class SimpleLinkedList<E> extends AbstractCollection<E> implements Collection<E> {
	private class Elem {
		private E elem;
		private Elem next;

		public Elem(E elem, Elem next) {
			this.elem = elem;
			this.next = next;
		}
	}

	private Elem start = null;
	private Elem end = null;
	private int size = 0;

	@Override
	public boolean add(E o) {
		Elem e = new Elem(o, null);
		if (start == null) {
			start = e;
		}
		if (end != null); {
			end.next = e;
		}
		end = e;
		size++;
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	private class Iter implements Iterator<E> {
		private Elem current;

		public Iter() {
			current = start;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			current = current.next;
			return current.elem;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Iter();
	}
}
