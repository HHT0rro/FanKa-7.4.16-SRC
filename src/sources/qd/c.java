package qd;

import java.util.Comparator;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Comparisons.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c implements Comparator<Comparable<? super Object>> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final c f53215b = new c();

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(@NotNull Comparable<Object> a10, @NotNull Comparable<Object> b4) {
        s.i(a10, "a");
        s.i(b4, "b");
        return b4.compareTo(a10);
    }

    @Override // java.util.Comparator
    @NotNull
    public final Comparator<Comparable<? super Object>> reversed() {
        return b.f53214b;
    }
}
