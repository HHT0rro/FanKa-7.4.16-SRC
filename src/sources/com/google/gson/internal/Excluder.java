package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {

    /* renamed from: h, reason: collision with root package name */
    public static final Excluder f26867h = new Excluder();

    /* renamed from: e, reason: collision with root package name */
    public boolean f26871e;

    /* renamed from: b, reason: collision with root package name */
    public double f26868b = -1.0d;

    /* renamed from: c, reason: collision with root package name */
    public int f26869c = 136;

    /* renamed from: d, reason: collision with root package name */
    public boolean f26870d = true;

    /* renamed from: f, reason: collision with root package name */
    public List<ExclusionStrategy> f26872f = Collections.emptyList();

    /* renamed from: g, reason: collision with root package name */
    public List<ExclusionStrategy> f26873g = Collections.emptyList();

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public Excluder c() {
        Excluder clone = clone();
        clone.f26870d = false;
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean e2 = e(rawType);
        final boolean z10 = e2 || g(rawType, true);
        final boolean z11 = e2 || g(rawType, false);
        if (z10 || z11) {
            return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1

                /* renamed from: a, reason: collision with root package name */
                public TypeAdapter<T> f26874a;

                public final TypeAdapter<T> a() {
                    TypeAdapter<T> typeAdapter = this.f26874a;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                    this.f26874a = delegateAdapter;
                    return delegateAdapter;
                }

                @Override // com.google.gson.TypeAdapter
                /* renamed from: read */
                public T read2(JsonReader jsonReader) throws IOException {
                    if (z11) {
                        jsonReader.skipValue();
                        return null;
                    }
                    return a().read2(jsonReader);
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, T t2) throws IOException {
                    if (z10) {
                        jsonWriter.nullValue();
                    } else {
                        a().write(jsonWriter, t2);
                    }
                }
            };
        }
        return null;
    }

    public boolean d(Class<?> cls, boolean z10) {
        return e(cls) || g(cls, z10);
    }

    public final boolean e(Class<?> cls) {
        if (this.f26868b == -1.0d || o((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return (!this.f26870d && k(cls)) || j(cls);
        }
        return true;
    }

    public final boolean g(Class<?> cls, boolean z10) {
        Iterator<ExclusionStrategy> iterator2 = (z10 ? this.f26872f : this.f26873g).iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean h(Field field, boolean z10) {
        Expose expose;
        if ((this.f26869c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f26868b != -1.0d && !o((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f26871e && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z10 ? expose.deserialize() : expose.serialize()))) {
            return true;
        }
        if ((!this.f26870d && k(field.getType())) || j(field.getType())) {
            return true;
        }
        List<ExclusionStrategy> list = z10 ? this.f26872f : this.f26873g;
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        Iterator<ExclusionStrategy> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    public Excluder i() {
        Excluder clone = clone();
        clone.f26871e = true;
        return clone;
    }

    public final boolean j(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || l(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    public final boolean k(Class<?> cls) {
        return cls.isMemberClass() && !l(cls);
    }

    public final boolean l(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public final boolean m(Since since) {
        return since == null || since.value() <= this.f26868b;
    }

    public final boolean n(Until until) {
        return until == null || until.value() > this.f26868b;
    }

    public final boolean o(Since since, Until until) {
        return m(since) && n(until);
    }

    public Excluder p(ExclusionStrategy exclusionStrategy, boolean z10, boolean z11) {
        Excluder clone = clone();
        if (z10) {
            ArrayList arrayList = new ArrayList(this.f26872f);
            clone.f26872f = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z11) {
            ArrayList arrayList2 = new ArrayList(this.f26873g);
            clone.f26873g = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return clone;
    }

    public Excluder q(int... iArr) {
        Excluder clone = clone();
        clone.f26869c = 0;
        for (int i10 : iArr) {
            clone.f26869c = i10 | clone.f26869c;
        }
        return clone;
    }

    public Excluder r(double d10) {
        Excluder clone = clone();
        clone.f26868b = d10;
        return clone;
    }
}
