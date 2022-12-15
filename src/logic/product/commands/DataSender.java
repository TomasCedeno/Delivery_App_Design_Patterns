
package logic.product.commands;

import logic.product.Orderable;

public interface DataSender {
    public String sendData(Orderable p, String userId);
}
