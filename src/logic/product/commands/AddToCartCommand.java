
package logic.product.commands;

import logic.product.*;

public class AddToCartCommand implements DataSender {
    private Cart receiver;
    
    public AddToCartCommand(Cart receiver){
        this.receiver = receiver;
    }

    @Override
    public void sendData(Product p) {
        receiver.add(p.clone());
    }
}
