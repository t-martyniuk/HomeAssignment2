package HttpEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum HttpStatus {
    INFORMATIONAL(100,199,new HttpInformationalHandler()),
    SUCCESS (200,299, new HttpRegularHandler()),
    REDIRECTION (300,399, new HttpRedirectionalHandler()),
    CLIENT_ERROR(400,499, new HttpClientErrorHandler()),
    SERVER_ERROR (500,599, new HttpServerErrorHandler());
    private final int min, max;
    private final HttpHandlr handler;

    /**
     * Turns HTTP code into HTTP status.
     * @param code HTTP code.
     * @return HTTP status.
     */
    public static HttpStatus findByHttpCode(int code) {
        for (HttpStatus value : values()) {
            if (code >= value.min && code < value.max) {
                return value;
            }
        } throw new IllegalStateException("unknown error code " + code);
    }

}
