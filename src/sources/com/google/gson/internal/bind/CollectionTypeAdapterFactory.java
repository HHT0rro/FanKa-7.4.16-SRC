package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: b, reason: collision with root package name */
    public final ConstructorConstructor f26908b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Adapter<E> extends TypeAdapter<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        public final TypeAdapter<E> f26909a;

        /* renamed from: b, reason: collision with root package name */
        public final ObjectConstructor<? extends Collection<E>> f26910b;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            this.f26909a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f26910b = objectConstructor;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<E> read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection<E> a10 = this.f26910b.a();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                a10.add(this.f26909a.read2(jsonReader));
            }
            jsonReader.endArray();
            return a10;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Collection<E> collection) throws IOException {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            Iterator<E> iterator2 = collection.iterator2();
            while (iterator2.hasNext()) {
                this.f26909a.write(jsonWriter, iterator2.next());
            }
            jsonWriter.endArray();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f26908b = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type h10 = C$Gson$Types.h(type, rawType);
        return new Adapter(gson, h10, gson.getAdapter(TypeToken.get(h10)), this.f26908b.a(typeToken));
    }
}
