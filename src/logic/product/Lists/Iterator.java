
package logic.product.Lists;

import logic.product.Product;

public interface Iterator {
    public Product getNextProduct();
    public boolean hasMore();
    public void setCurrentPosition(int index);
}
