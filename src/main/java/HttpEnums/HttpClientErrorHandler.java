package HttpEnums;

public class HttpClientErrorHandler implements HttpHandlr {
    @Override
    public String generateMessage(int code) {
        return "I'm generating client error message";
    }
}
