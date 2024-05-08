package me;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.f;
import retrofit2.p;

/* compiled from: GsonConverterFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a extends f.a {

    /* renamed from: a, reason: collision with root package name */
    public final Gson f51992a;

    public a(Gson gson) {
        this.f51992a = gson;
    }

    public static a a() {
        return b(new Gson());
    }

    public static a b(Gson gson) {
        Objects.requireNonNull(gson, "gson == null");
        return new a(gson);
    }

    @Override // retrofit2.f.a
    public f<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, p pVar) {
        return new b(this.f51992a, this.f51992a.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.f.a
    public f<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, p pVar) {
        return new c(this.f51992a, this.f51992a.getAdapter(TypeToken.get(type)));
    }
}
