package HttpEnums;

public interface HttpHandlr {
    /**
     * Handles HTTP code with generating appropriate message.
     * @param code HTTP code.
     * @return generated message.
     */
    String generateMessage(int code);
}
