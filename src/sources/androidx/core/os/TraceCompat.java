package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    @RequiresApi(18)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static void beginSection(String str) {
            Trace.beginSection(str);
        }

        @DoNotInline
        public static void endSection() {
            Trace.endSection();
        }
    }

    @RequiresApi(29)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void beginAsyncSection(String str, int i10) {
            Trace.beginAsyncSection(str, i10);
        }

        @DoNotInline
        public static void endAsyncSection(String str, int i10) {
            Trace.endAsyncSection(str, i10);
        }

        @DoNotInline
        public static boolean isEnabled() {
            return Trace.isEnabled();
        }

        @DoNotInline
        public static void setCounter(String str, long j10) {
            Trace.setCounter(str, j10);
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class<Long> cls = Long.TYPE;
                sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", cls);
                Class<Integer> cls2 = Integer.TYPE;
                sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                sTraceCounterMethod = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception unused) {
            }
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String str, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.beginAsyncSection(str, i10);
        } else {
            try {
                sAsyncTraceBeginMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i10));
            } catch (Exception unused) {
            }
        }
    }

    public static void beginSection(@NonNull String str) {
        Api18Impl.beginSection(str);
    }

    public static void endAsyncSection(@NonNull String str, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.endAsyncSection(str, i10);
        } else {
            try {
                sAsyncTraceEndMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i10));
            } catch (Exception unused) {
            }
        }
    }

    public static void endSection() {
        Api18Impl.endSection();
    }

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.isEnabled();
        }
        try {
            return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void setCounter(@NonNull String str, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setCounter(str, i10);
        } else {
            try {
                sTraceCounterMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i10));
            } catch (Exception unused) {
            }
        }
    }
}
