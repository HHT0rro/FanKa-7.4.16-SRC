package h;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

/* compiled from: LottieCompositionCache.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    public static final e f49481b = new e();

    /* renamed from: a, reason: collision with root package name */
    public final LruCache<String, LottieComposition> f49482a = new LruCache<>(20);

    @VisibleForTesting
    public e() {
    }

    public static e b() {
        return f49481b;
    }

    @Nullable
    public LottieComposition a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f49482a.get(str);
    }

    public void c(@Nullable String str, LottieComposition lottieComposition) {
        if (str == null) {
            return;
        }
        this.f49482a.put(str, lottieComposition);
    }
}
