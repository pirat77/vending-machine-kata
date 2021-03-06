package com.codecool.Storage;

import java.util.HashMap;

public interface Storage<T> {

    boolean addElement(T element);
    boolean removeElements(HashMap<T, Integer> elements);
    boolean removeElement(T element);
    boolean hasElement(T element);
    boolean clearBuffer();
}
