
package logic.product;

public class BuyCommand implements DataSender{
    private Order receiver;
    
    public BuyCommand(Order receiver){
        this.receiver = receiver;
    }

    @Override
    public void sendData(Product p) {
        // Toma los datos extrínsecos que están en la interfaz
        // Solicita los datos intrínsecos del producto, desde la fábrica
        // Antes de agregar a la orden, se verifica el pago del producto por parte del usuario desde la interfaz
        
        receiver.add(new Product("nombre", 0, 2000, "source", "category"));
    }
}
