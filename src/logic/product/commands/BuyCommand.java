
package logic.product.commands;

import java.util.ArrayList;
import logic.product.*;

public class BuyCommand implements DataSender{
    private Purchase receiver;
    
    public BuyCommand(Purchase receiver){
        this.receiver = receiver;
    }

    @Override
    public void sendData(Product p) {
        // Toma los datos extrínsecos que están en la interfaz
        // Solicita los datos intrínsecos del producto, desde la fábrica
        // Antes de agregar a la orden, se verifica el pago del producto por parte del usuario desde la interfaz
        
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("nombre", 2000, "source"));
        receiver.setProducts(product);
    }
}
