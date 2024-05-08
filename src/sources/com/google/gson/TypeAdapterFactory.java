package com.google.gson;

import com.google.gson.reflect.TypeToken;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}
