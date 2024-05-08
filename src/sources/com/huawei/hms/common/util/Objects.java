package com.huawei.hms.common.util;

import com.huawei.hms.common.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class Objects {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class ToStringHelper {

        /* renamed from: a, reason: collision with root package name */
        public final List<String> f29773a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f29774b;

        public ToStringHelper(Object obj) {
            this.f29774b = Preconditions.checkNotNull(obj);
            this.f29773a = new ArrayList();
        }

        public ToStringHelper add(String str, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            this.f29773a.add(str2 + "=" + valueOf);
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f29774b.getClass().getSimpleName());
            sb2.append('{');
            int size = this.f29773a.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append(this.f29773a.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    public Objects() {
        throw new AssertionError((Object) "illegal argument");
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj);
    }
}
