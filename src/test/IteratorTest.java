
package test;

import logic.product.Lists.*;

public class IteratorTest {
    public static void main(String[] args) {
        ProductList list = new HomeProductList();
        Iterator it = list.createDownIterator();
        
        System.out.println(it.hasMore());
        System.out.println(it.getNextProduct().getName());
        System.out.println(it.hasMore());
        System.out.println(it.getNextProduct().getName());
        System.out.println(it.hasMore());
        System.out.println(it.getNextProduct().getName());
        System.out.println(it.hasMore());
        System.out.println(it.getNextProduct().getName());
        
        it.setCurrentPosition(1);
        System.out.println(it.hasMore());
        System.out.println(it.getNextProduct().getName());
    }
}
