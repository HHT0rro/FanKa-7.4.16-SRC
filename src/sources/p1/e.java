package p1;

import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Convert.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e implements c<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public final int f52731a;

    public e(int i10) {
        this.f52731a = i10;
    }

    @Override // p1.c
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Integer b(@NotNull String key, @Nullable MMKV mmkv) {
        s.i(key, "key");
        if (mmkv != null) {
            return Integer.valueOf(mmkv.getInt(key, this.f52731a));
        }
        return null;
    }

    @Override // p1.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull String key, @Nullable MMKV mmkv, @Nullable Integer num) {
        s.i(key, "key");
        if (num != null) {
            if (mmkv != null) {
                mmkv.putInt(key, num.intValue());
            }
        } else if (mmkv != null) {
            mmkv.removeValueForKey(key);
        }
    }

    public /* synthetic */ e(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : i10);
    }
}
