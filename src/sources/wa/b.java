package wa;

import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f54317a;

    public b(Bundle bundle) {
        this.f54317a = bundle == null ? new Bundle() : bundle;
    }

    public int a(String str) {
        return b(str, 0);
    }

    public int b(String str, int i10) {
        try {
            return this.f54317a.getInt(str, i10);
        } catch (Throwable th) {
            ra.a.e("SafeBundle", "getInt exception: " + th.getMessage(), true);
            return i10;
        }
    }

    public long c(String str, long j10) {
        try {
            return this.f54317a.getLong(str, j10);
        } catch (Throwable th) {
            ra.a.e("SafeBundle", "getLong exception: " + th.getMessage(), true);
            return j10;
        }
    }

    public String d(String str) {
        try {
            return this.f54317a.getString(str);
        } catch (Throwable th) {
            ra.a.e("SafeBundle", "getString exception: " + th.getMessage(), true);
            return "";
        }
    }

    public String e(String str, String str2) {
        try {
            return this.f54317a.getString(str, str2);
        } catch (Throwable th) {
            ra.a.e("SafeBundle", "getString exception: " + th.getMessage(), true);
            return str2;
        }
    }

    public String toString() {
        try {
            return this.f54317a.toString();
        } catch (Throwable unused) {
            ra.a.c("SafeBundle", "toString exception.");
            return null;
        }
    }
}
