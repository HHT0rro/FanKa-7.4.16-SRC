package p1;

import com.cupidapp.live.base.network.gson.GsonUtil;
import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Convert.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class k<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Class<T> f52848a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Gson f52849b;

    public k(@NotNull Class<T> type) {
        s.i(type, "type");
        this.f52848a = type;
        this.f52849b = GsonUtil.f12000a.b();
    }

    @Override // p1.c
    public void a(@NotNull String key, @Nullable MMKV mmkv, @Nullable T t2) {
        s.i(key, "key");
        if (mmkv != null) {
            mmkv.encode(key, this.f52849b.toJson(t2));
        }
    }

    @Override // p1.c
    @Nullable
    public T b(@NotNull String key, @Nullable MMKV mmkv) {
        s.i(key, "key");
        return (T) this.f52849b.fromJson(mmkv != null ? mmkv.decodeString(key) : null, (Class) this.f52848a);
    }
}
