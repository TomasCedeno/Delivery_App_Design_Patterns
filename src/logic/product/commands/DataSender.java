
package logic.product.commands;

import logic.product.Orderable;

public interface DataSender {
    public void sendData(Orderable p, String userId);
}
