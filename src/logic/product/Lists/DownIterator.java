
package logic.product.Lists;

import logic.product.Product;

public class DownIterator implements Iterator {
    private ProductList list;
    private int currentPosition;
    
    public DownIterator(ProductList list){
        this.list = list;
        this.currentPosition = list.getProducts().size()-1;
    }

    @Override
    public Product getNextProduct() {
        currentPosition--;
        return list.getProducts().get(currentPosition);
    }

    @Override
    public boolean hasMore() {
        return currentPosition > 0;
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
