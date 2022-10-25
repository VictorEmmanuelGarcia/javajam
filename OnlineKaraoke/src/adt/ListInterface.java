package adt;

public interface ListInterface<T> {

    public void add(T newEntry);
    public int indexOf(T Entry);
    public boolean remove(int Entry);
    public boolean replace(int givenPosition, T newEntry);
    public T getElement(int Entry);
    public boolean clear();
    public boolean isEmpty();
    public int size();
}

