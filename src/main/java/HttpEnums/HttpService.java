package HttpEnums;

public class HttpService {
    /**
     * Turns HTTP code into HTTP status and sends the appropriate generated message.
     * @param code HTTP code.
     */
    public void handleHttpCode(int code) {

        HttpStatus httpCode = HttpStatus.findByHttpCode(code);
        HttpHandlr handler = httpCode.getHandler();
        String message = handler.generateMessage(code);
        send(message,code);
    }

    /**
     * Sends message.
     * @param message generated message.
     * @param code HTTP code.
     */
    private void send(String message, int code) {
        System.out.println("received code " + code + ", sending " + message);
    }
}
