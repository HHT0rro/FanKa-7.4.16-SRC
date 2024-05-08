package p1;

import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: LocalStoreManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f52842c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final h f52843d = new h();

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final MMKV f52844a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final MMKV f52845b;

    /* compiled from: LocalStoreManager.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final h a() {
            return h.f52843d;
        }
    }

    public h() {
        MMKV defaultMMKV = MMKV.defaultMMKV();
        s.h(defaultMMKV, "defaultMMKV()");
        this.f52844a = defaultMMKV;
        MMKV mmkvWithID = MMKV.mmkvWithID("APP_NOT_CLEAR_PREFERENCES");
        s.h(mmkvWithID, "mmkvWithID(\"APP_NOT_CLEAR_PREFERENCES\")");
        this.f52845b = mmkvWithID;
    }

    public final boolean b() {
        return this.f52844a.clear().commit();
    }

    @NotNull
    public final MMKV c() {
        return this.f52845b;
    }

    @NotNull
    public final MMKV d() {
        return this.f52844a;
    }
}
