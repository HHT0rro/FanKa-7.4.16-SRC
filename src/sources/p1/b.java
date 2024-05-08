package p1;

import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Convert.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b implements c<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f52729a;

    public b(boolean z10) {
        this.f52729a = z10;
    }

    @Override // p1.c
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(@NotNull String key, @Nullable MMKV mmkv) {
        s.i(key, "key");
        if (mmkv != null) {
            return Boolean.valueOf(mmkv.getBoolean(key, this.f52729a));
        }
        return null;
    }

    @Override // p1.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull String key, @Nullable MMKV mmkv, @Nullable Boolean bool) {
        s.i(key, "key");
        if (bool != null) {
            if (mmkv != null) {
                mmkv.putBoolean(key, bool.booleanValue());
            }
        } else if (mmkv != null) {
            mmkv.removeValueForKey(key);
        }
    }

    public /* synthetic */ b(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10);
    }
}
