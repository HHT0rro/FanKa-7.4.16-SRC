package p1;

import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocalStoreManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a<T> extends d<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final f<T> f52728b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull f<T> key) {
        super(key);
        s.i(key, "key");
        this.f52728b = key;
    }

    @Override // p1.d
    @Nullable
    public MMKV a() {
        return h.f52842c.a().c();
    }

    @Override // p1.d
    @NotNull
    public f<T> b() {
        return this.f52728b;
    }
}
