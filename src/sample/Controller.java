package sample;

import com.sun.xml.internal.ws.api.model.ExceptionType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.net.InetAddress;
import java.net.NetworkInterface;


public class Controller {

    @FXML private Label label2;
    @FXML private Label labelMTU;
    @FXML private Label labelMAC;

public void handleButton(){
    try {

            InetAddress thisIp = InetAddress.getLocalHost();
            label2.setText(thisIp.getHostAddress());

            NetworkInterface netObj = NetworkInterface.getByInetAddress(thisIp);
            int MTU = netObj.getMTU();
            labelMTU.setText(Integer.toString(MTU));

            byte[] Mac =netObj.getHardwareAddress();
            int i;
            StringBuilder store = new StringBuilder();
            for( i=0; i<Mac.length; i++) {
                store.append(String.format("%2X%s", Mac[i], (i < Mac.length -1)? "-":"" ));
        }
             labelMAC.setText(store.toString());
}
        catch (Exception e) {

        System.out.println("Error: Code could not Run");

    }
    }

}

