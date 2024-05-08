package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {

    /* renamed from: a, reason: collision with root package name */
    public final JsonSerializer<T> f26960a;

    /* renamed from: b, reason: collision with root package name */
    public final JsonDeserializer<T> f26961b;

    /* renamed from: c, reason: collision with root package name */
    public final Gson f26962c;

    /* renamed from: d, reason: collision with root package name */
    public final TypeToken<T> f26963d;

    /* renamed from: e, reason: collision with root package name */
    public final TypeAdapterFactory f26964e;

    /* renamed from: f, reason: collision with root package name */
    public final TreeTypeAdapter<T>.GsonContextImpl f26965f = new GsonContextImpl();

    /* renamed from: g, reason: collision with root package name */
    public volatile TypeAdapter<T> f26966g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        public GsonContextImpl() {
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return (R) TreeTypeAdapter.this.f26962c.fromJson(jsonElement, type);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.f26962c.toJsonTree(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.f26962c.toJsonTree(obj, type);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {

        /* renamed from: b, reason: collision with root package name */
        public final TypeToken<?> f26968b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f26969c;

        /* renamed from: d, reason: collision with root package name */
        public final Class<?> f26970d;

        /* renamed from: e, reason: collision with root package name */
        public final JsonSerializer<?> f26971e;

        /* renamed from: f, reason: collision with root package name */
        public final JsonDeserializer<?> f26972f;

        public SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z10, Class<?> cls) {
            JsonSerializer<?> jsonSerializer = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.f26971e = jsonSerializer;
            JsonDeserializer<?> jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            this.f26972f = jsonDeserializer;
            C$Gson$Preconditions.a((jsonSerializer == null && jsonDeserializer == null) ? false : true);
            this.f26968b = typeToken;
            this.f26969c = z10;
            this.f26970d = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean isAssignableFrom;
            TypeToken<?> typeToken2 = this.f26968b;
            if (typeToken2 != null) {
                isAssignableFrom = typeToken2.equals(typeToken) || (this.f26969c && this.f26968b.getType() == typeToken.getRawType());
            } else {
                isAssignableFrom = this.f26970d.isAssignableFrom(typeToken.getRawType());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.f26971e, this.f26972f, gson, typeToken, this);
            }
            return null;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this.f26960a = jsonSerializer;
        this.f26961b = jsonDeserializer;
        this.f26962c = gson;
        this.f26963d = typeToken;
        this.f26964e = typeAdapterFactory;
    }

    public static TypeAdapterFactory b(TypeToken<?> typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }

    public static TypeAdapterFactory c(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    public final TypeAdapter<T> a() {
        TypeAdapter<T> typeAdapter = this.f26966g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.f26962c.getDelegateAdapter(this.f26964e, this.f26963d);
        this.f26966g = delegateAdapter;
        return delegateAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public T read2(JsonReader jsonReader) throws IOException {
        if (this.f26961b == null) {
            return a().read2(jsonReader);
        }
        JsonElement a10 = Streams.a(jsonReader);
        if (a10.isJsonNull()) {
            return null;
        }
        return this.f26961b.deserialize(a10, this.f26963d.getType(), this.f26965f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t2) throws IOException {
        JsonSerializer<T> jsonSerializer = this.f26960a;
        if (jsonSerializer == null) {
            a().write(jsonWriter, t2);
        } else if (t2 == null) {
            jsonWriter.nullValue();
        } else {
            Streams.b(jsonSerializer.serialize(t2, this.f26963d.getType(), this.f26965f), jsonWriter);
        }
    }
}
