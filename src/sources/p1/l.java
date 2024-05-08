package p1;

import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Convert.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class l implements c<String> {
    @Override // p1.c
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String b(@NotNull String key, @Nullable MMKV mmkv) {
        s.i(key, "key");
        if (mmkv != null) {
            return mmkv.getString(key, "");
        }
        return null;
    }

    @Override // p1.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull String key, @Nullable MMKV mmkv, @Nullable String str) {
        s.i(key, "key");
        if (mmkv != null) {
            mmkv.putString(key, str);
        }
    }
}
