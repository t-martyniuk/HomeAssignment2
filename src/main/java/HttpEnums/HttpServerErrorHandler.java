package HttpEnums;

public class HttpServerErrorHandler implements HttpHandlr {
    @Override
    public String generateMessage(int code) {
        return "I'm generating server error message";
    }
}
