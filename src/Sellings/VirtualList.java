package Sellings;

import java.util.*;

public class VirtualList<Product> implements List<Product> {

    private List source;
    private int customerID;

    public VirtualList(int id) {
        this.customerID = id;
    }


    private List getSource() {
        if (source == null) {
            ProductDaoImpl pDao = ProductDaoImpl.getInstance();
            source = pDao.findForCustomer(this.customerID);
        }
        return source;
    }

    @Override
    public String toString() {

        String listString = "";
        List productList = getSource();

        for(Object product: productList) {
            Product productInstance =    (Product) product;

            listString+=productInstance.toString();
        }

        return listString;

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Product> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Product product) {
        return this.getSource().add(product);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Product> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Product> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Product get(int index) {
        return (Product) getSource().get(index);
    }

    @Override
    public Product set(int index, Product element) {
        return null;
    }

    @Override
    public void add(int index, Product element) {

    }

    @Override
    public Product remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Product> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Product> listIterator(int index) {
        return null;
    }

    @Override
    public List<Product> subList(int fromIndex, int toIndex) {
        return null;
    }
}
