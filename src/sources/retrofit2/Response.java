package retrofit2;

import okhttp3.ResponseBody;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Response<T> {

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.Response f53390a;

    /* renamed from: b, reason: collision with root package name */
    public final T f53391b;

    /* renamed from: c, reason: collision with root package name */
    public final ResponseBody f53392c;

    public Response(okhttp3.Response response, T t2, ResponseBody responseBody) {
        this.f53390a = response;
        this.f53391b = t2;
        this.f53392c = responseBody;
    }

    public static <T> Response<T> c(ResponseBody responseBody, okhttp3.Response response) {
        t.b(responseBody, "body == null");
        t.b(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new Response<>(response, null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> f(T t2, okhttp3.Response response) {
        t.b(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new Response<>(response, t2, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public T a() {
        return this.f53391b;
    }

    public int b() {
        return this.f53390a.code();
    }

    public boolean d() {
        return this.f53390a.isSuccessful();
    }

    public String e() {
        return this.f53390a.message();
    }

    public String toString() {
        return this.f53390a.toString();
    }
}
