package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: b, reason: collision with root package name */
    public final ConstructorConstructor f26944b;

    /* renamed from: c, reason: collision with root package name */
    public final FieldNamingStrategy f26945c;

    /* renamed from: d, reason: collision with root package name */
    public final Excluder f26946d;

    /* renamed from: e, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f26947e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Adapter<T> extends TypeAdapter<T> {

        /* renamed from: a, reason: collision with root package name */
        public final ObjectConstructor<T> f26955a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<String, BoundField> f26956b;

        public Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.f26955a = objectConstructor;
            this.f26956b = map;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T a10 = this.f26955a.a();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.f26956b.get(jsonReader.nextName());
                    if (boundField != null && boundField.f26959c) {
                        boundField.a(jsonReader, a10);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return a10;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t2) throws IOException {
            if (t2 == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.f26956b.values()) {
                    if (boundField.c(t2)) {
                        jsonWriter.name(boundField.f26957a);
                        boundField.b(jsonWriter, t2);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class BoundField {

        /* renamed from: a, reason: collision with root package name */
        public final String f26957a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f26958b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f26959c;

        public BoundField(String str, boolean z10, boolean z11) {
            this.f26957a = str;
            this.f26958b = z10;
            this.f26959c = z11;
        }

        public abstract void a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        public abstract void b(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        public abstract boolean c(Object obj) throws IOException, IllegalAccessException;
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f26944b = constructorConstructor;
        this.f26945c = fieldNamingStrategy;
        this.f26946d = excluder;
        this.f26947e = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public static boolean c(Field field, boolean z10, Excluder excluder) {
        return (excluder.d(field.getType(), z10) || excluder.h(field, z10)) ? false : true;
    }

    public final BoundField a(final Gson gson, final Field field, String str, final TypeToken<?> typeToken, boolean z10, boolean z11) {
        final boolean a10 = Primitives.a(typeToken.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> a11 = jsonAdapter != null ? this.f26947e.a(this.f26944b, gson, typeToken, jsonAdapter) : null;
        final boolean z12 = a11 != null;
        if (a11 == null) {
            a11 = gson.getAdapter(typeToken);
        }
        final TypeAdapter<?> typeAdapter = a11;
        return new BoundField(str, z10, z11) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public void a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read2 = typeAdapter.read2(jsonReader);
                if (read2 == null && a10) {
                    return;
                }
                field.set(obj, read2);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public void b(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                (z12 ? typeAdapter : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, typeToken.getType())).write(jsonWriter, field.get(obj));
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public boolean c(Object obj) throws IOException, IllegalAccessException {
                return this.f26958b && field.get(obj) != obj;
            }
        };
    }

    public boolean b(Field field, boolean z10) {
        return c(field, z10, this.f26946d);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.f26944b.a(typeToken), d(gson, typeToken, rawType));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, BoundField> d(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        TypeToken<?> typeToken2 = typeToken;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z10 = false;
            int i10 = 0;
            while (i10 < length) {
                Field field = declaredFields[i10];
                boolean b4 = b(field, true);
                boolean b10 = b(field, z10);
                if (b4 || b10) {
                    ReflectionHelper.b(field);
                    Type p10 = C$Gson$Types.p(typeToken2.getType(), cls2, field.getGenericType());
                    List<String> e2 = e(field);
                    int size = e2.size();
                    BoundField boundField = null;
                    int i11 = 0;
                    while (i11 < size) {
                        String str = e2.get(i11);
                        boolean z11 = i11 != 0 ? false : b4;
                        int i12 = i11;
                        BoundField boundField2 = boundField;
                        int i13 = size;
                        List<String> list = e2;
                        Field field2 = field;
                        boundField = boundField2 == null ? (BoundField) linkedHashMap.put(str, a(gson, field, str, TypeToken.get(p10), z11, b10)) : boundField2;
                        i11 = i12 + 1;
                        b4 = z11;
                        e2 = list;
                        size = i13;
                        field = field2;
                    }
                    BoundField boundField3 = boundField;
                    if (boundField3 != null) {
                        throw new IllegalArgumentException(((Object) type) + " declares multiple JSON fields named " + boundField3.f26957a);
                    }
                }
                i10++;
                z10 = false;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.p(typeToken2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = typeToken2.getRawType();
        }
        return linkedHashMap;
    }

    public final List<String> e(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.f26945c.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }
}
