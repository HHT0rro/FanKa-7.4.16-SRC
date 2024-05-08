package he;

import android.util.Log;
import java.util.logging.Level;

/* compiled from: Logger.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface e {

    /* compiled from: Logger.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a implements e {

        /* renamed from: b, reason: collision with root package name */
        public static final boolean f49625b;

        /* renamed from: a, reason: collision with root package name */
        public final String f49626a;

        static {
            boolean z10;
            try {
                Class.forName("android.util.Log");
                z10 = true;
            } catch (ClassNotFoundException unused) {
                z10 = false;
            }
            f49625b = z10;
        }

        public a(String str) {
            this.f49626a = str;
        }

        public static boolean c() {
            return f49625b;
        }

        @Override // he.e
        public void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(d(level), this.f49626a, str);
            }
        }

        @Override // he.e
        public void b(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                Log.println(d(level), this.f49626a, str + "\n" + Log.getStackTraceString(th));
            }
        }

        public int d(Level level) {
            int intValue = level.intValue();
            if (intValue < 800) {
                return intValue < 500 ? 2 : 3;
            }
            if (intValue < 900) {
                return 4;
            }
            return intValue < 1000 ? 5 : 6;
        }
    }

    /* compiled from: Logger.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b implements e {
        @Override // he.e
        public void a(Level level, String str) {
            System.out.println("[" + ((Object) level) + "] " + str);
        }

        @Override // he.e
        public void b(Level level, String str, Throwable th) {
            System.out.println("[" + ((Object) level) + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void b(Level level, String str, Throwable th);
}
