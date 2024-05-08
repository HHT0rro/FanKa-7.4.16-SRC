package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class JsonTreeWriter extends JsonWriter {

    /* renamed from: e, reason: collision with root package name */
    public static final Writer f26924e = new Writer() { // from class: com.google.gson.internal.bind.JsonTreeWriter.1
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    };

    /* renamed from: f, reason: collision with root package name */
    public static final JsonPrimitive f26925f = new JsonPrimitive("closed");

    /* renamed from: b, reason: collision with root package name */
    public final List<JsonElement> f26926b;

    /* renamed from: c, reason: collision with root package name */
    public String f26927c;

    /* renamed from: d, reason: collision with root package name */
    public JsonElement f26928d;

    public JsonTreeWriter() {
        super(f26924e);
        this.f26926b = new ArrayList();
        this.f26928d = JsonNull.INSTANCE;
    }

    public JsonElement a() {
        if (this.f26926b.isEmpty()) {
            return this.f26928d;
        }
        throw new IllegalStateException("Expected one JSON element but was " + ((Object) this.f26926b));
    }

    public final JsonElement b() {
        return this.f26926b.get(r0.size() - 1);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() throws IOException {
        JsonArray jsonArray = new JsonArray();
        d(jsonArray);
        this.f26926b.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() throws IOException {
        JsonObject jsonObject = new JsonObject();
        d(jsonObject);
        this.f26926b.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f26926b.isEmpty()) {
            this.f26926b.add(f26925f);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public final void d(JsonElement jsonElement) {
        if (this.f26927c != null) {
            if (!jsonElement.isJsonNull() || getSerializeNulls()) {
                ((JsonObject) b()).add(this.f26927c, jsonElement);
            }
            this.f26927c = null;
            return;
        }
        if (this.f26926b.isEmpty()) {
            this.f26928d = jsonElement;
            return;
        }
        JsonElement b4 = b();
        if (b4 instanceof JsonArray) {
            ((JsonArray) b4).add(jsonElement);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() throws IOException {
        if (!this.f26926b.isEmpty() && this.f26927c == null) {
            if (b() instanceof JsonArray) {
                this.f26926b.remove(r0.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() throws IOException {
        if (!this.f26926b.isEmpty() && this.f26927c == null) {
            if (b() instanceof JsonObject) {
                this.f26926b.remove(r0.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (!this.f26926b.isEmpty() && this.f26927c == null) {
            if (b() instanceof JsonObject) {
                this.f26927c = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() throws IOException {
        d(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        d(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean z10) throws IOException {
        d(new JsonPrimitive(Boolean.valueOf(z10)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        d(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double d10) throws IOException {
        if (!isLenient() && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d10);
        }
        d(new JsonPrimitive(Double.valueOf(d10)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long j10) throws IOException {
        d(new JsonPrimitive(Long.valueOf(j10)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + ((Object) number));
            }
        }
        d(new JsonPrimitive(number));
        return this;
    }
}
