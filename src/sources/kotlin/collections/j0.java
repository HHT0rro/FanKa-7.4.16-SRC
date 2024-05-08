package kotlin.collections;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReversedViews.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j0<T> extends b<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<T> f50933b;

    /* JADX WARN: Multi-variable type inference failed */
    public j0(@NotNull List<? extends T> delegate) {
        kotlin.jvm.internal.s.i(delegate, "delegate");
        this.f50933b = delegate;
    }

    @Override // kotlin.collections.b, java.util.List
    public T get(int i10) {
        int G;
        List<T> list = this.f50933b;
        G = y.G(this, i10);
        return list.get(G);
    }

    @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f50933b.size();
    }
}
