package p1;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: LocalKey.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f52732a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final c<T> f52733b;

    public f(@NotNull String key, @NotNull c<T> convert) {
        s.i(key, "key");
        s.i(convert, "convert");
        this.f52732a = key;
        this.f52733b = convert;
    }

    @NotNull
    public final c<T> a() {
        return this.f52733b;
    }

    @NotNull
    public final String b() {
        return this.f52732a;
    }
}
