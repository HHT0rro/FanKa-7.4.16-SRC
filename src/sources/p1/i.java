package p1;

import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Convert.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i implements c<Long> {

    /* renamed from: a, reason: collision with root package name */
    public final long f52846a;

    public i(long j10) {
        this.f52846a = j10;
    }

    @Override // p1.c
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long b(@NotNull String key, @Nullable MMKV mmkv) {
        s.i(key, "key");
        if (mmkv != null) {
            return Long.valueOf(mmkv.getLong(key, this.f52846a));
        }
        return null;
    }

    @Override // p1.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull String key, @Nullable MMKV mmkv, @Nullable Long l10) {
        s.i(key, "key");
        if (l10 != null) {
            if (mmkv != null) {
                mmkv.putLong(key, l10.longValue());
            }
        } else if (mmkv != null) {
            mmkv.removeValueForKey(key);
        }
    }

    public /* synthetic */ i(long j10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 0L : j10);
    }
}
