package me;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.f;

/* compiled from: GsonResponseBodyConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c<T> implements f<ResponseBody, T> {

    /* renamed from: a, reason: collision with root package name */
    public final Gson f51997a;

    /* renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f51998b;

    public c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f51997a = gson;
        this.f51998b = typeAdapter;
    }

    @Override // retrofit2.f
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public T convert(ResponseBody responseBody) throws IOException {
        JsonReader newJsonReader = this.f51997a.newJsonReader(responseBody.charStream());
        try {
            T read2 = this.f51998b.read2(newJsonReader);
            if (newJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return read2;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
