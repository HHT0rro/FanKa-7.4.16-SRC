package kotlinx.coroutines.selects;

import kotlinx.coroutines.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Select.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g {

    /* renamed from: a */
    @NotNull
    public static final Object f51497a = new f0("NOT_SELECTED");

    /* renamed from: b */
    @NotNull
    public static final Object f51498b = new f0("ALREADY_SELECTED");

    /* renamed from: c */
    @NotNull
    public static final Object f51499c = new f0("UNDECIDED");

    /* renamed from: d */
    @NotNull
    public static final Object f51500d = new f0("RESUMED");

    /* renamed from: e */
    @NotNull
    public static final h f51501e = new h();

    public static final /* synthetic */ Object a() {
        return f51500d;
    }

    public static final /* synthetic */ h b() {
        return f51501e;
    }

    public static final /* synthetic */ Object c() {
        return f51499c;
    }

    @NotNull
    public static final Object d() {
        return f51498b;
    }

    @NotNull
    public static final Object e() {
        return f51497a;
    }
}
