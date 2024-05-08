package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l11l1111Il {
    public static boolean l1111l111111Il = Log.isLoggable("Volley", 5);
    private static String l111l11111I1l = "Volley";
    private static final String l111l11111lIl = "com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111Il";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class l1111l111111Il {
        public static final boolean l1111l111111Il = l11l1111Il.l1111l111111Il;
        private static final long l111l11111lIl = 0;
        private final List<C0356l1111l111111Il> l111l11111I1l = new ArrayList();
        private boolean l111l11111Il = false;

        /* renamed from: com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111Il$l1111l111111Il$l1111l111111Il, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static class C0356l1111l111111Il {
            public final String l1111l111111Il;
            public final long l111l11111I1l;
            public final long l111l11111lIl;

            public C0356l1111l111111Il(String str, long j10, long j11) {
                this.l1111l111111Il = str;
                this.l111l11111lIl = j10;
                this.l111l11111I1l = j11;
            }
        }

        private long l1111l111111Il() {
            if (this.l111l11111I1l.size() == 0) {
                return 0L;
            }
            return this.l111l11111I1l.get(r2.size() - 1).l111l11111I1l - this.l111l11111I1l.get(0).l111l11111I1l;
        }

        public final void finalize() {
            if (this.l111l11111Il) {
                return;
            }
            l1111l111111Il("Request on the loose");
            l11l1111Il.l111l11111I1l("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public final synchronized void l1111l111111Il(String str) {
            long j10;
            this.l111l11111Il = true;
            if (this.l111l11111I1l.size() == 0) {
                j10 = 0;
            } else {
                long j11 = this.l111l11111I1l.get(0).l111l11111I1l;
                List<C0356l1111l111111Il> list = this.l111l11111I1l;
                j10 = list.get(list.size() - 1).l111l11111I1l - j11;
            }
            if (j10 <= 0) {
                return;
            }
            long j12 = this.l111l11111I1l.get(0).l111l11111I1l;
            l11l1111Il.l111l11111lIl("(%-4d ms) %s", Long.valueOf(j10), str);
            for (C0356l1111l111111Il c0356l1111l111111Il : this.l111l11111I1l) {
                long j13 = c0356l1111l111111Il.l111l11111I1l;
                l11l1111Il.l111l11111lIl("(+%-4d) [%2d] %s", Long.valueOf(j13 - j12), Long.valueOf(c0356l1111l111111Il.l111l11111lIl), c0356l1111l111111Il.l1111l111111Il);
                j12 = j13;
            }
        }

        public final synchronized void l1111l111111Il(String str, long j10) {
            if (this.l111l11111Il) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.l111l11111I1l.add(new C0356l1111l111111Il(str, j10, SystemClock.elapsedRealtime()));
        }
    }

    private static void l1111l111111Il(String str) {
        l111l11111lIl("Changing log tag to %s", str);
        l111l11111I1l = str;
        l1111l111111Il = Log.isLoggable(str, 2);
    }

    public static void l1111l111111Il(String str, Object... objArr) {
        if (l1111l111111Il) {
            l111l1111l1Il(str, objArr);
        }
    }

    public static void l1111l111111Il(Throwable th, String str, Object... objArr) {
        l111l1111l1Il(str, objArr);
    }

    public static void l111l11111I1l(String str, Object... objArr) {
        l111l1111l1Il(str, objArr);
    }

    public static void l111l11111Il(String str, Object... objArr) {
        Log.wtf(l111l11111I1l, l111l1111l1Il(str, objArr));
    }

    public static void l111l11111lIl(String str, Object... objArr) {
        l111l1111l1Il(str, objArr);
    }

    private static void l111l11111lIl(Throwable th, String str, Object... objArr) {
        Log.wtf(l111l11111I1l, l111l1111l1Il(str, objArr), th);
    }

    private static String l111l1111l1Il(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i10 = 2;
        while (true) {
            if (i10 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i10].getClassName().equals(l111l11111lIl)) {
                String className = stackTrace[i10].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i10].getMethodName();
                break;
            }
            i10++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
