package com.google.android.gms.common.internal;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g {

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List<String> f23682a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f23683b;

        public a(Object obj) {
            this.f23683b = h.h(obj);
            this.f23682a = new ArrayList();
        }

        @RecentlyNonNull
        public final a a(@RecentlyNonNull String str, @Nullable Object obj) {
            List<String> list = this.f23682a;
            String str2 = (String) h.h(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 1 + valueOf.length());
            sb2.append(str2);
            sb2.append("=");
            sb2.append(valueOf);
            list.add(sb2.toString());
            return this;
        }

        @RecentlyNonNull
        public final String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f23683b.getClass().getSimpleName());
            sb2.append('{');
            int size = this.f23682a.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append(this.f23682a.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    @RecentlyNonNull
    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @RecentlyNonNull
    public static int b(@RecentlyNonNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @RecentlyNonNull
    public static a c(@RecentlyNonNull Object obj) {
        return new a(obj);
    }
}
