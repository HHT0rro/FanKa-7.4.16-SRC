package com.huawei.appgallery.coreservice.internal.support.parcelable.b;

import android.os.Parcel;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.a.j;
import com.huawei.appgallery.coreservice.internal.support.parcelable.a.m;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import x9.g;
import x9.h;
import x9.i;
import x9.k;
import x9.l;
import x9.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<com.huawei.appgallery.coreservice.internal.support.parcelable.b.a, c> f27603a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a extends RuntimeException {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f27603a = hashMap;
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.BINDER, new x9.a());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.BOOLEAN, new x9.b());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.BUNDLE, new x9.c());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.BYTE_ARRAY, new x9.d());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.DOUBLE, new x9.e());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.FLOAT, new x9.f());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.HASH_MAP, new g());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.INT_ARRAY, new h());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.INTEGER, new i());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.INTERFACE, new j());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.LIST, new com.huawei.appgallery.coreservice.internal.support.parcelable.a.a());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.LONG, new x9.j());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.PARCELABLE_ARRAY, new m());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.PARCELABLE, new k());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.STRING_ARRAY, new l());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.STRING_LIST, new x9.m());
        hashMap.put(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.STRING, new n());
    }

    public static <T extends AutoParcelable> T a(Class<T> cls, Parcel parcel) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            boolean isAccessible = declaredConstructor.isAccessible();
            declaredConstructor.setAccessible(true);
            try {
                try {
                    T newInstance = declaredConstructor.newInstance(new Object[0]);
                    try {
                        d(newInstance, parcel);
                    } catch (Exception e2) {
                        b.f27602a.b("SafeParcel", "can not readObject", e2);
                    }
                    return newInstance;
                } catch (IllegalAccessException e10) {
                    throw new a("newInstance failed", e10);
                } catch (InstantiationException e11) {
                    throw new a("newInstance failed", e11);
                } catch (InvocationTargetException e12) {
                    throw new a("newInstance failed", e12);
                }
            } finally {
                declaredConstructor.setAccessible(isAccessible);
            }
        } catch (NoSuchMethodException e13) {
            throw new a("createObject() requires a default constructor", e13);
        } catch (SecurityException e14) {
            throw new a("createObject() requires a public constructor", e14);
        }
    }

    public static ClassLoader b(Class cls) {
        return cls == null ? ClassLoader.getSystemClassLoader() : cls.getClassLoader();
    }

    public static Map<String, String> c(Parcel parcel) {
        HashMap hashMap = new HashMap();
        String[] d10 = l.d(parcel, parcel.readInt());
        if (d10 != null) {
            for (String str : d10) {
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split("\\|");
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    }
                }
            }
        }
        return hashMap;
    }

    public static void d(@NonNull AutoParcelable autoParcelable, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Class<?> cls = autoParcelable.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(EnableAutoParcel.class)) {
                    int value = ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).value();
                    if (sparseArray.get(value) != null) {
                        throw new a("Field number " + value + " is used twice in " + cls.getName() + " for fields " + field.getName() + " and " + ((Field) sparseArray.get(value)).getName());
                    }
                    sparseArray.put(value, field);
                }
            }
        }
        Class<?> cls2 = autoParcelable.getClass();
        int b4 = d.b(parcel);
        Map<String, String> c4 = c(parcel);
        while (parcel.dataPosition() < b4) {
            int readInt = parcel.readInt();
            int a10 = d.a(readInt);
            Field field2 = (Field) sparseArray.get(a10);
            if (field2 == null) {
                b.f27602a.a("SafeParcel", "Unknown field num " + a10 + " in " + cls2.getName() + ", skipping.");
            } else {
                try {
                    h(autoParcelable, parcel, field2, readInt, c4);
                } catch (d.a e2) {
                    d.e(parcel, readInt);
                    b.f27602a.d("SafeParcel", "Error reading field: " + a10 + " in " + cls2.getName() + ", skipping." + e2.getMessage());
                }
            }
            d.f(parcel, readInt);
        }
        if (parcel.dataPosition() <= b4) {
            return;
        }
        throw new a("Overread allowed size end=" + b4 + "-" + parcel.dataPosition());
    }

    public static void e(AutoParcelable autoParcelable, Parcel parcel, int i10) {
        Class<?> cls = autoParcelable.getClass();
        int c4 = f.c(parcel, 20293);
        f(autoParcelable, parcel, cls);
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(EnableAutoParcel.class)) {
                    try {
                        g(autoParcelable, parcel, field, i10);
                    } catch (Exception e2) {
                        b.f27602a.d("SafeParcel", "Error writing field: " + ((Object) e2));
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        f.a(parcel, c4);
    }

    public static void f(AutoParcelable autoParcelable, Parcel parcel, Class cls) {
        TypeVariable<Class<?>>[] typeParameters = autoParcelable.getClass().getTypeParameters();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            if (!TextUtils.isEmpty(typeVariable.getName())) {
                arrayList2.add(typeVariable.getName());
            }
        }
        if (!arrayList2.isEmpty()) {
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            for (int i10 = 0; i10 < length; i10++) {
                Field field = declaredFields[i10];
                if (field.isAnnotationPresent(EnableAutoParcel.class) && arrayList2.contains(field.getGenericType().toString())) {
                    boolean isAccessible = field.isAccessible();
                    field.setAccessible(true);
                    String name = field.getName();
                    try {
                        try {
                            Object obj = field.get(autoParcelable);
                            if (obj != null) {
                                arrayList.add(name + "|" + obj.getClass().getCanonicalName());
                            }
                        } catch (IllegalAccessException unused) {
                            b.f27602a.c("SafeParcel", "can not get the value of the field:" + name);
                        }
                    } finally {
                        field.setAccessible(isAccessible);
                    }
                }
            }
        }
        new l().a(parcel, null, 0, (String[]) arrayList.toArray(new String[typeParameters.length]), 0, false);
    }

    public static void g(AutoParcelable autoParcelable, Parcel parcel, Field field, int i10) {
        int value = ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).value();
        boolean mayNull = ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).mayNull();
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        c cVar = f27603a.get(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.a(field));
        if (cVar == null) {
            b.f27602a.c("SafeParcel", "can not find process to write:" + field.getName());
        } else {
            cVar.a(parcel, field, value, field.get(autoParcelable), i10, mayNull);
        }
        field.setAccessible(isAccessible);
    }

    public static void h(AutoParcelable autoParcelable, Parcel parcel, Field field, int i10, Map<String, String> map) {
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        try {
            try {
                c cVar = f27603a.get(com.huawei.appgallery.coreservice.internal.support.parcelable.b.a.a(field));
                if (cVar == null) {
                    b.f27602a.c("SafeParcel", "can not find process to read:" + field.getName());
                } else {
                    cVar.b(autoParcelable, field, parcel, i10, map);
                }
            } catch (IllegalAccessException unused) {
                b.f27602a.d("SafeParcel", "can not set field value");
            }
        } finally {
            field.setAccessible(isAccessible);
        }
    }
}
