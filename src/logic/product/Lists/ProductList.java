
package logic.product.Lists;

import java.util.ArrayList;
import logic.product.Product;

public interface ProductList {
    public Iterator createUpIterator();
    public Iterator createDownIterator();
    public ArrayList<Product> getProducts();
}
