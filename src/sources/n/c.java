package n;

import com.airbnb.lottie.g0;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LogcatLogger.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f52002a = new HashSet();

    @Override // com.airbnb.lottie.g0
    public void a(String str, Throwable th) {
        boolean z10 = com.airbnb.lottie.c.f1878a;
    }

    @Override // com.airbnb.lottie.g0
    public void b(String str, Throwable th) {
        Set<String> set = f52002a;
        if (set.contains(str)) {
            return;
        }
        set.add(str);
    }

    public void c(String str, Throwable th) {
        boolean z10 = com.airbnb.lottie.c.f1878a;
    }

    @Override // com.airbnb.lottie.g0
    public void debug(String str) {
        c(str, null);
    }

    @Override // com.airbnb.lottie.g0
    public void warning(String str) {
        b(str, null);
    }
}
