package kotlin.jvm.internal;

import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.h0;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassReference.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class m implements kotlin.reflect.c<Object>, l {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f51024c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Map<Class<? extends kotlin.b<?>>, Integer> f51025d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final HashMap<String, String> f51026e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final HashMap<String, String> f51027f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final HashMap<String, String> f51028g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final Map<String, String> f51029h;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Class<?> f51030b;

    /* compiled from: ClassReference.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final String a(@NotNull Class<?> jClass) {
            String str;
            s.i(jClass, "jClass");
            String str2 = null;
            if (!jClass.isAnonymousClass()) {
                if (jClass.isLocalClass()) {
                    String name = jClass.getSimpleName();
                    Method enclosingMethod = jClass.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        s.h(name, "name");
                        String I0 = StringsKt__StringsKt.I0(name, enclosingMethod.getName() + '$', null, 2, null);
                        if (I0 != null) {
                            return I0;
                        }
                    }
                    Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
                    if (enclosingConstructor == null) {
                        s.h(name, "name");
                        return StringsKt__StringsKt.H0(name, '$', null, 2, null);
                    }
                    s.h(name, "name");
                    return StringsKt__StringsKt.I0(name, enclosingConstructor.getName() + '$', null, 2, null);
                }
                if (jClass.isArray()) {
                    Class<?> componentType = jClass.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) m.f51029h.get(componentType.getName())) != null) {
                        str2 = str + "Array";
                    }
                    if (str2 == null) {
                        return "Array";
                    }
                } else {
                    String str3 = (String) m.f51029h.get(jClass.getName());
                    return str3 == null ? jClass.getSimpleName() : str3;
                }
            }
            return str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i10 = 0;
        List m10 = kotlin.collections.s.m(Function0.class, Function1.class, Function2.class, Function3.class, yd.n.class, yd.o.class, yd.p.class, yd.q.class, yd.r.class, yd.s.class, yd.a.class, yd.b.class, yd.c.class, yd.d.class, yd.e.class, yd.f.class, yd.g.class, yd.h.class, yd.i.class, yd.j.class, yd.k.class, yd.l.class, yd.m.class);
        ArrayList arrayList = new ArrayList(kotlin.collections.t.t(m10, 10));
        for (Object obj : m10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            arrayList.add(kotlin.f.a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f51025d = i0.l(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f51026e = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f51027f = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        s.h(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("kotlin.jvm.internal.");
            s.h(kotlinName, "kotlinName");
            sb2.append(StringsKt__StringsKt.K0(kotlinName, '.', null, 2, null));
            sb2.append("CompanionObject");
            Pair a10 = kotlin.f.a(sb2.toString(), kotlinName + ".Companion");
            hashMap3.put(a10.getFirst(), a10.getSecond());
        }
        for (Map.Entry<Class<? extends kotlin.b<?>>, Integer> entry : f51025d.entrySet()) {
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f51028g = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(h0.c(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), StringsKt__StringsKt.K0((String) entry2.getValue(), '.', null, 2, null));
        }
        f51029h = linkedHashMap;
    }

    public m(@NotNull Class<?> jClass) {
        s.i(jClass, "jClass");
        this.f51030b = jClass;
    }

    @Override // kotlin.jvm.internal.l
    @NotNull
    public Class<?> a() {
        return this.f51030b;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof m) && s.d(xd.a.b(this), xd.a.b((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return xd.a.b(this).hashCode();
    }

    @Override // kotlin.reflect.c
    @Nullable
    public String j() {
        return f51024c.a(a());
    }

    @NotNull
    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
