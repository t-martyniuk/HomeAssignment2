package HttpEnums;


public class HttpInformationalHandler implements HttpHandlr {
    @Override
    public String generateMessage(int code) {
        return "I'm generating informational message";
    }
}
