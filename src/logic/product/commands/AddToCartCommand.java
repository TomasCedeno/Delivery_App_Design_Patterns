
package logic.product.commands;

import logic.product.*;
import Launcher.Out;

public class AddToCartCommand implements DataSender {
    private Cart receiver;
    
    public AddToCartCommand(Cart receiver){
        this.receiver = receiver;
    }

    @Override
    public void sendData(Orderable p, String userId) {
        for(Product product: receiver.getProducts()){
            if(((Product) p).getName().equals(product.getName())){
                Out.show("Ya has agregado este producto.");
                return ;
            }
        }
        
        receiver.add((Product) p);
        Out.show("Producto agregado a tu carrito.");
    }
}
