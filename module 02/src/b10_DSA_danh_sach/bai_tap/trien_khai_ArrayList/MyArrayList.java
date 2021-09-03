package b10_DSA_danh_sach.bai_tap.trien_khai_ArrayList;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity: " + capacity + " is illegal");
        }
    }

    public void add(int index, E element) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index:  " + index + " is illegal");
        } else if (size == elements.length) {
            ensureCapacity(elements.length * 2);
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index){
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index:  " + index + " is illegal");
        }
        E removedElement = (E)elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        elements[size-1] = null;
        return removedElement;
    }

    public void clear (){
        size = 0;
        for (int i =0; i < elements.length; i++){
            elements[i] = null;
        }
    }

    public int getSize(){
        return this.size;
    }

    public MyArrayList <E> clone (){
       MyArrayList<E> newList = new MyArrayList<E>(elements.length);
        newList.elements = Arrays.copyOf(this.elements, this.size);
        newList.size = size;
        return newList;
    }

    public boolean contains (E element){
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int indexOf (E element){
        for (int i =0; i < size; i++){
            if (elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public boolean add( E element){
        if (elements.length == size ){
            ensureCapacity(2);
        }
        elements[size] = element;
        size++;
        return true;
    }

    public  void ensureCapacity(int minCapacity){
        if (minCapacity > 1 ){
            int newSize = elements.length * minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity: " + minCapacity + " is illegal");
        }
    }

    public E get (int index){
        return (E) elements[index];
    }

    public void printInfo(E element){
        System.out.println(element.toString());
    }
}
