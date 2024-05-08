package retrofit2;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient Response<?> response;

    public HttpException(Response<?> response) {
        super(getMessage(response));
        this.code = response.b();
        this.message = response.e();
        this.response = response;
    }

    private static String getMessage(Response<?> response) {
        t.b(response, "response == null");
        return "HTTP " + response.b() + " " + response.e();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public Response<?> response() {
        return this.response;
    }
}
