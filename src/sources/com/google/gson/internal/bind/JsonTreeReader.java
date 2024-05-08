package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class JsonTreeReader extends JsonReader {

    /* renamed from: f, reason: collision with root package name */
    public static final Reader f26918f = new Reader() { // from class: com.google.gson.internal.bind.JsonTreeReader.1
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) throws IOException {
            throw new AssertionError();
        }
    };

    /* renamed from: g, reason: collision with root package name */
    public static final Object f26919g = new Object();

    /* renamed from: b, reason: collision with root package name */
    public Object[] f26920b;

    /* renamed from: c, reason: collision with root package name */
    public int f26921c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f26922d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f26923e;

    public JsonTreeReader(JsonElement jsonElement) {
        super(f26918f);
        this.f26920b = new Object[32];
        this.f26921c = 0;
        this.f26922d = new String[32];
        this.f26923e = new int[32];
        g(jsonElement);
    }

    private String locationString() {
        return " at path " + getPath();
    }

    public final void a(JsonToken jsonToken) throws IOException {
        if (peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + ((Object) jsonToken) + " but was " + ((Object) peek()) + locationString());
    }

    public JsonElement b() throws IOException {
        JsonToken peek = peek();
        if (peek != JsonToken.NAME && peek != JsonToken.END_ARRAY && peek != JsonToken.END_OBJECT && peek != JsonToken.END_DOCUMENT) {
            JsonElement jsonElement = (JsonElement) d();
            skipValue();
            return jsonElement;
        }
        throw new IllegalStateException("Unexpected " + ((Object) peek) + " when reading a JsonElement.");
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        g(((JsonArray) d()).iterator2());
        this.f26923e[this.f26921c - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        g(((JsonObject) d()).entrySet().iterator2());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26920b = new Object[]{f26919g};
        this.f26921c = 1;
    }

    public final Object d() {
        return this.f26920b[this.f26921c - 1];
    }

    public final Object e() {
        Object[] objArr = this.f26920b;
        int i10 = this.f26921c - 1;
        this.f26921c = i10;
        Object obj = objArr[i10];
        objArr[i10] = null;
        return obj;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        e();
        e();
        int i10 = this.f26921c;
        if (i10 > 0) {
            int[] iArr = this.f26923e;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        e();
        e();
        int i10 = this.f26921c;
        if (i10 > 0) {
            int[] iArr = this.f26923e;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    public void f() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) d()).next();
        g(entry.getValue());
        g(new JsonPrimitive((String) entry.getKey()));
    }

    public final void g(Object obj) {
        int i10 = this.f26921c;
        Object[] objArr = this.f26920b;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            this.f26920b = Arrays.copyOf(objArr, i11);
            this.f26923e = Arrays.copyOf(this.f26923e, i11);
            this.f26922d = (String[]) Arrays.copyOf(this.f26922d, i11);
        }
        Object[] objArr2 = this.f26920b;
        int i12 = this.f26921c;
        this.f26921c = i12 + 1;
        objArr2[i12] = obj;
    }

    public final String getPath(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.f26921c;
            if (i10 < i11) {
                Object[] objArr = this.f26920b;
                if (objArr[i10] instanceof JsonArray) {
                    i10++;
                    if (i10 < i11 && (objArr[i10] instanceof Iterator)) {
                        int i12 = this.f26923e[i10];
                        if (z10 && i12 > 0 && (i10 == i11 - 1 || i10 == i11 - 2)) {
                            i12--;
                        }
                        sb2.append('[');
                        sb2.append(i12);
                        sb2.append(']');
                    }
                } else if ((objArr[i10] instanceof JsonObject) && (i10 = i10 + 1) < i11 && (objArr[i10] instanceof Iterator)) {
                    sb2.append('.');
                    String[] strArr = this.f26922d;
                    if (strArr[i10] != null) {
                        sb2.append(strArr[i10]);
                    }
                }
                i10++;
            } else {
                return sb2.toString();
            }
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPreviousPath() {
        return getPath(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() throws IOException {
        JsonToken peek = peek();
        return (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY || peek == JsonToken.END_DOCUMENT) ? false : true;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) e()).getAsBoolean();
        int i10 = this.f26921c;
        if (i10 > 0) {
            int[] iArr = this.f26923e;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + ((Object) jsonToken) + " but was " + ((Object) peek) + locationString());
        }
        double asDouble = ((JsonPrimitive) d()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        e();
        int i10 = this.f26921c;
        if (i10 > 0) {
            int[] iArr = this.f26923e;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + ((Object) jsonToken) + " but was " + ((Object) peek) + locationString());
        }
        int asInt = ((JsonPrimitive) d()).getAsInt();
        e();
        int i10 = this.f26921c;
        if (i10 > 0) {
            int[] iArr = this.f26923e;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + ((Object) jsonToken) + " but was " + ((Object) peek) + locationString());
        }
        long asLong = ((JsonPrimitive) d()).getAsLong();
        e();
        int i10 = this.f26921c;
        if (i10 > 0) {
            int[] iArr = this.f26923e;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) d()).next();
        String str = (String) entry.getKey();
        this.f26922d[this.f26921c - 1] = str;
        g(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        e();
        int i10 = this.f26921c;
        if (i10 > 0) {
            int[] iArr = this.f26923e;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (peek != jsonToken && peek != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + ((Object) jsonToken) + " but was " + ((Object) peek) + locationString());
        }
        String asString = ((JsonPrimitive) e()).getAsString();
        int i10 = this.f26921c;
        if (i10 > 0) {
            int[] iArr = this.f26923e;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() throws IOException {
        if (this.f26921c == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object d10 = d();
        if (d10 instanceof Iterator) {
            boolean z10 = this.f26920b[this.f26921c - 2] instanceof JsonObject;
            Iterator it = (Iterator) d10;
            if (!it.hasNext()) {
                return z10 ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z10) {
                return JsonToken.NAME;
            }
            g(it.next());
            return peek();
        }
        if (d10 instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (d10 instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (d10 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) d10;
            if (jsonPrimitive.isString()) {
                return JsonToken.STRING;
            }
            if (jsonPrimitive.isBoolean()) {
                return JsonToken.BOOLEAN;
            }
            if (jsonPrimitive.isNumber()) {
                return JsonToken.NUMBER;
            }
            throw new AssertionError();
        }
        if (d10 instanceof JsonNull) {
            return JsonToken.NULL;
        }
        if (d10 == f26919g) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new AssertionError();
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() throws IOException {
        if (peek() == JsonToken.NAME) {
            nextName();
            this.f26922d[this.f26921c - 2] = "null";
        } else {
            e();
            int i10 = this.f26921c;
            if (i10 > 0) {
                this.f26922d[i10 - 1] = "null";
            }
        }
        int i11 = this.f26921c;
        if (i11 > 0) {
            int[] iArr = this.f26923e;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return JsonTreeReader.class.getSimpleName() + locationString();
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        return getPath(false);
    }
}
