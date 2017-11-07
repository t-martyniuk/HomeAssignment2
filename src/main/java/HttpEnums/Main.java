package HttpEnums;

import lombok.extern.slf4j.Slf4j;
import org.fluttercode.datafactory.impl.DataFactory;
@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        HttpService sender = new HttpService();
        DataFactory df = new DataFactory();
        while (true) {
            int code = df.getNumberBetween(0,1000);
            try {
                sender.handleHttpCode(code);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            Thread.sleep(1000);
        }
    }
}
