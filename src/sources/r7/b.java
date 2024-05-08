package r7;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public final Object f53299b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public long f53300c = Long.MIN_VALUE;

    /* renamed from: a, reason: collision with root package name */
    public final long f53298a = Math.round(30000.0d);

    public b(double d10) {
    }

    public final boolean a() {
        synchronized (this.f53299b) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f53300c + this.f53298a > currentTimeMillis) {
                return false;
            }
            this.f53300c = currentTimeMillis;
            return true;
        }
    }
}
