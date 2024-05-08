package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: b, reason: collision with root package name */
    public final ConstructorConstructor f26929b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f26930c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public final TypeAdapter<K> f26931a;

        /* renamed from: b, reason: collision with root package name */
        public final TypeAdapter<V> f26932b;

        /* renamed from: c, reason: collision with root package name */
        public final ObjectConstructor<? extends Map<K, V>> f26933c;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.f26931a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f26932b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f26933c = objectConstructor;
        }

        public final String a(JsonElement jsonElement) {
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return String.valueOf(asJsonPrimitive.getAsNumber());
                }
                if (asJsonPrimitive.isBoolean()) {
                    return Boolean.toString(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.isString()) {
                    return asJsonPrimitive.getAsString();
                }
                throw new AssertionError();
            }
            if (jsonElement.isJsonNull()) {
                return "null";
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<K, V> read2(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map<K, V> a10 = this.f26933c.a();
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    K read2 = this.f26931a.read2(jsonReader);
                    if (a10.put(read2, this.f26932b.read2(jsonReader)) == null) {
                        jsonReader.endArray();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + ((Object) read2));
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                    K read22 = this.f26931a.read2(jsonReader);
                    if (a10.put(read22, this.f26932b.read2(jsonReader)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + ((Object) read22));
                    }
                }
                jsonReader.endObject();
            }
            return a10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Map<K, V> map) throws IOException {
            if (map == null) {
                jsonWriter.nullValue();
                return;
            }
            if (!MapTypeAdapterFactory.this.f26930c) {
                jsonWriter.beginObject();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.name(String.valueOf(entry.getKey()));
                    this.f26932b.write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i10 = 0;
            boolean z10 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                JsonElement jsonTree = this.f26931a.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z10 |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
            }
            if (z10) {
                jsonWriter.beginArray();
                int size = arrayList.size();
                while (i10 < size) {
                    jsonWriter.beginArray();
                    Streams.b((JsonElement) arrayList.get(i10), jsonWriter);
                    this.f26932b.write(jsonWriter, arrayList2.get(i10));
                    jsonWriter.endArray();
                    i10++;
                }
                jsonWriter.endArray();
                return;
            }
            jsonWriter.beginObject();
            int size2 = arrayList.size();
            while (i10 < size2) {
                jsonWriter.name(a((JsonElement) arrayList.get(i10)));
                this.f26932b.write(jsonWriter, arrayList2.get(i10));
                i10++;
            }
            jsonWriter.endObject();
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z10) {
        this.f26929b = constructorConstructor;
        this.f26930c = z10;
    }

    public final TypeAdapter<?> a(Gson gson, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return gson.getAdapter(TypeToken.get(type));
        }
        return TypeAdapters.f26981f;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Type[] j10 = C$Gson$Types.j(type, C$Gson$Types.k(type));
        return new Adapter(gson, j10[0], a(gson, j10[0]), j10[1], gson.getAdapter(TypeToken.get(j10[1])), this.f26929b.a(typeToken));
    }
}
