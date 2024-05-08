package com.huawei.flexiblelayout.script.vm;

import androidx.annotation.NonNull;
import com.koushikdutta.quack.JavaScriptObject;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class VMRevisionHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final String f28493a = "__VM_REVISION__";

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicLong f28494b = new AtomicLong(0);

    public static long a(@NonNull JavaScriptObject javaScriptObject) {
        Object obj = javaScriptObject.get(f28493a);
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            try {
                return Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
            }
        }
        return 0L;
    }

    public static void b(@NonNull JavaScriptObject javaScriptObject) {
        long incrementAndGet = f28494b.incrementAndGet();
        if (incrementAndGet <= ZipUtils.UPPER_UNIXTIME_BOUND) {
            javaScriptObject.set(f28493a, (Object) Long.valueOf(incrementAndGet));
        } else {
            javaScriptObject.set(f28493a, (Object) String.valueOf(incrementAndGet));
        }
    }

    public static boolean a(@NonNull JavaScriptObject javaScriptObject, @NonNull JavaScriptObject javaScriptObject2) {
        return a(javaScriptObject) >= a(javaScriptObject2);
    }
}
