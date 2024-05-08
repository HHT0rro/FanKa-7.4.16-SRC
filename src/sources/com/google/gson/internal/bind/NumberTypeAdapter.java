package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {

    /* renamed from: b, reason: collision with root package name */
    public static final TypeAdapterFactory f26935b = b(ToNumberPolicy.LAZILY_PARSED_NUMBER);

    /* renamed from: a, reason: collision with root package name */
    public final ToNumberStrategy f26936a;

    /* renamed from: com.google.gson.internal.bind.NumberTypeAdapter$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26938a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f26938a = iArr;
            try {
                iArr[JsonToken.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26938a[JsonToken.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26938a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public NumberTypeAdapter(ToNumberStrategy toNumberStrategy) {
        this.f26936a = toNumberStrategy;
    }

    public static TypeAdapterFactory a(ToNumberStrategy toNumberStrategy) {
        if (toNumberStrategy == ToNumberPolicy.LAZILY_PARSED_NUMBER) {
            return f26935b;
        }
        return b(toNumberStrategy);
    }

    public static TypeAdapterFactory b(ToNumberStrategy toNumberStrategy) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.NumberTypeAdapter.1
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public Number read2(JsonReader jsonReader) throws IOException {
        JsonToken peek = jsonReader.peek();
        int i10 = AnonymousClass2.f26938a[peek.ordinal()];
        if (i10 == 1) {
            jsonReader.nextNull();
            return null;
        }
        if (i10 != 2 && i10 != 3) {
            throw new JsonSyntaxException("Expecting number, got: " + ((Object) peek) + "; at path " + jsonReader.getPath());
        }
        return this.f26936a.readNumber(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Number number) throws IOException {
        jsonWriter.value(number);
    }
}
