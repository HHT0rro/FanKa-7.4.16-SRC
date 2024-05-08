package me;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.f;

/* compiled from: GsonRequestBodyConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b<T> implements f<T, RequestBody> {

    /* renamed from: c, reason: collision with root package name */
    public static final MediaType f51993c = MediaType.get("application/json; charset=UTF-8");

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f51994d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final Gson f51995a;

    /* renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f51996b;

    public b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f51995a = gson;
        this.f51996b = typeAdapter;
    }

    @Override // retrofit2.f
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RequestBody convert(T t2) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter newJsonWriter = this.f51995a.newJsonWriter(new OutputStreamWriter(buffer.outputStream(), f51994d));
        this.f51996b.write(newJsonWriter, t2);
        newJsonWriter.close();
        return RequestBody.create(f51993c, buffer.readByteString());
    }
}
