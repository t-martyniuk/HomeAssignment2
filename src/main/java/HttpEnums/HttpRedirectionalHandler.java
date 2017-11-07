package HttpEnums;

public class HttpRedirectionalHandler implements HttpHandlr {
    @Override
    public String generateMessage(int code) {
        return "I'm generating redirectional message";
    }
}
