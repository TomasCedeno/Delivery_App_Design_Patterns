
package logic.product.commands;

import logic.product.*;

public class BuyCommand implements DataSender{
    private Purchase receiver;
    
    public BuyCommand(Purchase receiver){
        this.receiver = receiver;
    }

    @Override
    public void sendData(Product p) {
        receiver.addProduct((Product) p.clone());
    }
}
