package com.huawei.flexiblelayout;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.parser.expr.expression.MethodCaller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ServiceRegistry.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, n0> f28257a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static c f28258b;

    /* compiled from: ServiceRegistry.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a {
        @k0(alias = "eval")
        public Object a(@NonNull Object... objArr) {
            if (objArr.length > 0) {
                return objArr[0];
            }
            return null;
        }
    }

    /* compiled from: ServiceRegistry.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b implements n0 {

        /* renamed from: a, reason: collision with root package name */
        private final Object f28259a;

        public b(Object obj) {
            this.f28259a = obj;
        }

        @Override // com.huawei.flexiblelayout.n0
        public MethodCaller.Method a(@NonNull String str) {
            return l0.a(this.f28259a, str);
        }
    }

    static {
        a("", new a());
    }

    public static void a(@NonNull String str, @NonNull Object obj) {
        if (TextUtils.isEmpty(str)) {
            if (f28258b == null) {
                f28258b = new c();
            }
            f28258b.a(obj);
            return;
        }
        f28257a.put(str, new b(obj));
    }

    /* compiled from: ServiceRegistry.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class c implements n0 {

        /* renamed from: a, reason: collision with root package name */
        private static final List<Object> f28260a = new ArrayList();

        public void a(Object obj) {
            List<Object> list = f28260a;
            if (list.contains(obj)) {
                return;
            }
            list.add(obj);
        }

        @Override // com.huawei.flexiblelayout.n0
        public MethodCaller.Method a(@NonNull String str) {
            for (int size = f28260a.size() - 1; size >= 0; size--) {
                l0 a10 = l0.a(f28260a.get(size), str);
                if (a10 != null) {
                    return a10;
                }
            }
            return null;
        }
    }

    @Nullable
    public static n0 a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return f28258b;
        }
        return f28257a.get(str);
    }
}
