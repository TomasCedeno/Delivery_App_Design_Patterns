
package logic.product.commands;

import logic.product.*;

public class AddToCartCommand implements DataSender {
    private Cart receiver;
    
    public AddToCartCommand(Cart receiver){
        this.receiver = receiver;
    }

    @Override
    public String sendData(Orderable p, String userId) {
        for(Product product: receiver.getProducts()){
            if(((Product) p).getName().equals(product.getName())){
                return "Ya has agregado este producto.";
            }
        }
        
        receiver.add((Product) p);
        return "Producto agregado a tu carrito.";
    }
}
