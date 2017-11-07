package HttpEnums;

public class HttpRegularHandler implements HttpHandlr {
    @Override
    public String generateMessage(int code) {
        return "I'm generating success message";
    }
}
