package p1;

import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocalStoreManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class d<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final f<T> f52730a;

    public d(@NotNull f<T> key) {
        s.i(key, "key");
        this.f52730a = key;
    }

    @Nullable
    public MMKV a() {
        return h.f52842c.a().d();
    }

    @NotNull
    public f<T> b() {
        return this.f52730a;
    }

    @Nullable
    public final T c() {
        return b().a().b(b().b(), a());
    }

    public final void d(@Nullable T t2) {
        b().a().a(b().b(), a(), t2);
    }
}
