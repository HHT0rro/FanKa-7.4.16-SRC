package sun.nio.ch;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class IOStatus {
    public static final int EOF = -1;
    public static final int INTERRUPTED = -3;
    public static final int THROWN = -5;
    public static final int UNAVAILABLE = -2;
    public static final int UNSUPPORTED = -4;
    public static final int UNSUPPORTED_CASE = -6;

    private IOStatus() {
    }

    public static int normalize(int n10) {
        if (n10 == -2) {
            return 0;
        }
        return n10;
    }

    public static boolean check(int n10) {
        return n10 >= -2;
    }

    public static long normalize(long n10) {
        if (n10 == -2) {
            return 0L;
        }
        return n10;
    }

    public static boolean check(long n10) {
        return n10 >= -2;
    }

    public static boolean checkAll(long n10) {
        return n10 > -1 || n10 < -6;
    }

    static boolean okayToRetry(long n10) {
        return n10 == -2 || n10 == -3;
    }
}
