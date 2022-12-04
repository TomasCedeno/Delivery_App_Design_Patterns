
package logic.product;

public class AddToCartCommand implements DataSender {
    private Cart receiver;
    
    public AddToCartCommand(Cart receiver){
        this.receiver = receiver;
    }

    @Override
    public void sendData(Product p) {
        // Toma los datos extrínsecos que están en la interfaz
        // Solicita los datos intrínsecos del producto, desde la fábrica
        
        receiver.add(new Product(0, "nombre", 2000, 1, "source", "description"));
    }
}
