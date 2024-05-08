package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: b, reason: collision with root package name */
    public final ConstructorConstructor f26917b;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f26917b = constructorConstructor;
    }

    public TypeAdapter<?> a(ConstructorConstructor constructorConstructor, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        TypeAdapter<?> treeTypeAdapter;
        Object a10 = constructorConstructor.a(TypeToken.get((Class) jsonAdapter.value())).a();
        if (a10 instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) a10;
        } else if (a10 instanceof TypeAdapterFactory) {
            treeTypeAdapter = ((TypeAdapterFactory) a10).create(gson, typeToken);
        } else {
            boolean z10 = a10 instanceof JsonSerializer;
            if (!z10 && !(a10 instanceof JsonDeserializer)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a10.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            treeTypeAdapter = new TreeTypeAdapter<>(z10 ? (JsonSerializer) a10 : null, a10 instanceof JsonDeserializer ? (JsonDeserializer) a10 : null, gson, typeToken, null);
        }
        return (treeTypeAdapter == null || !jsonAdapter.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return (TypeAdapter<T>) a(this.f26917b, gson, typeToken, jsonAdapter);
    }
}
