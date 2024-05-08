package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class Objects {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class ToStringHelper {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f29720a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f29721b;

        public final ToStringHelper add(String str, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(str2.length() + valueOf.length() + 1);
            sb2.append(str2);
            sb2.append("=");
            sb2.append(valueOf);
            this.f29720a.add(sb2.toString());
            return this;
        }

        public final String toString() {
            String simpleName = this.f29721b.getClass().getSimpleName();
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(simpleName);
            sb2.append('{');
            int size = this.f29720a.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append(this.f29720a.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }

        private ToStringHelper(Object obj) {
            this.f29721b = Preconditions.checkNotNull(obj);
            this.f29720a = new ArrayList();
        }
    }

    private Objects() {
        throw new AssertionError((Object) "Uninstantiable");
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        return obj != null && obj.equals(obj2);
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean isNull(Object... objArr) {
        if (objArr == null) {
            return true;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj);
    }
}
