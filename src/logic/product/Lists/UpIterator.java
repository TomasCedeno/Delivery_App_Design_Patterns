
package logic.product.Lists;

import logic.product.Product;

public class UpIterator implements Iterator {
    private ProductList list;
    private int currentPosition;
    
    public UpIterator(ProductList list){
        this.list = list;
        this.currentPosition = -1;
    }

    @Override
    public Product getNextProduct() {
        currentPosition++;
        return list.getProducts().get(currentPosition);
    }

    @Override
    public boolean hasMore() {
        return currentPosition < list.getProducts().size()-1;
    }

    @Override
    public void setCurrentPosition(int index) {
        this.currentPosition = index;
    }

    @Override
    public int getCurrentPosition() {
        return this.currentPosition;
    }
}
