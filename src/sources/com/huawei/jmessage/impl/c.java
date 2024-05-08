package com.huawei.jmessage.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.json.Jsons;
import com.koushikdutta.quack.JavaScriptObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsObjectHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f32046a = "JsObjectHelper";

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Class<?>, InterfaceC0327c<?>> f32047b;

    /* compiled from: JsObjectHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements InterfaceC0327c<FLMap> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.huawei.jmessage.impl.c.InterfaceC0327c
        public FLMap a(@NonNull JavaScriptObject javaScriptObject) {
            return c.b(javaScriptObject);
        }
    }

    /* compiled from: JsObjectHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements InterfaceC0327c<FLArray> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.huawei.jmessage.impl.c.InterfaceC0327c
        public FLArray a(@NonNull JavaScriptObject javaScriptObject) {
            return c.c(javaScriptObject);
        }
    }

    /* compiled from: JsObjectHelper.java */
    /* renamed from: com.huawei.jmessage.impl.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface InterfaceC0327c<T> {
        T a(@NonNull JavaScriptObject javaScriptObject);
    }

    static {
        HashMap hashMap = new HashMap();
        f32047b = hashMap;
        hashMap.put(FLMap.class, new a());
        hashMap.put(FLArray.class, new b());
    }

    public static <T> T a(@Nullable JavaScriptObject javaScriptObject, @NonNull InterfaceC0327c<T> interfaceC0327c) {
        if (javaScriptObject == null) {
            return null;
        }
        return interfaceC0327c.a(javaScriptObject);
    }

    public static boolean b(Object obj) {
        return (obj instanceof JavaScriptObject) && ((JavaScriptObject) obj).isArray();
    }

    public static boolean c(Object obj) {
        return (obj instanceof JavaScriptObject) && ((JavaScriptObject) obj).isFunction();
    }

    public static boolean d(Object obj) {
        if (obj instanceof JavaScriptObject) {
            JavaScriptObject javaScriptObject = (JavaScriptObject) obj;
            if (!javaScriptObject.isArray() && !javaScriptObject.isFunction()) {
                return true;
            }
        }
        return false;
    }

    public static <T> T a(@Nullable JavaScriptObject javaScriptObject, @NonNull Class<T> cls) {
        InterfaceC0327c<?> interfaceC0327c;
        if (javaScriptObject == null || (interfaceC0327c = f32047b.get(cls)) == null) {
            return null;
        }
        return (T) interfaceC0327c.a(javaScriptObject);
    }

    @NonNull
    public static FLMap b(@NonNull JavaScriptObject javaScriptObject) {
        Iterable<String> a10;
        FLMap newJson = Jsons.newJson();
        if (d(javaScriptObject) && (a10 = a(javaScriptObject)) != null) {
            for (String str : a10) {
                Object a11 = a(javaScriptObject.get(str));
                if (a11 != null) {
                    newJson.put(str, a11);
                }
            }
        }
        return newJson;
    }

    @NonNull
    public static FLArray c(@NonNull JavaScriptObject javaScriptObject) {
        FLArray newJsonArray = Jsons.newJsonArray();
        if (b((Object) javaScriptObject)) {
            Iterator iterator2 = javaScriptObject.asJSValue().asIterable(Object.class).iterator2();
            while (iterator2.hasNext()) {
                newJsonArray.add(a(iterator2.next()));
            }
        }
        return newJsonArray;
    }

    public static Object a(@Nullable Object obj, @NonNull Class<?> cls) {
        return obj instanceof JavaScriptObject ? a((JavaScriptObject) obj, (Class) cls) : obj;
    }

    private static Iterable<String> a(@NonNull JavaScriptObject javaScriptObject) {
        if (javaScriptObject.quackContext.isClose()) {
            return null;
        }
        return ((JavaScriptObject) ((JavaScriptObject) javaScriptObject.quackContext.evaluate("Object.keys")).call(javaScriptObject)).asJSValue().asIterable(String.class);
    }

    private static Object a(Object obj) {
        if (!(obj instanceof JavaScriptObject)) {
            return obj;
        }
        if (b(obj)) {
            return c((JavaScriptObject) obj);
        }
        if (d(obj)) {
            return b((JavaScriptObject) obj);
        }
        return null;
    }
}
