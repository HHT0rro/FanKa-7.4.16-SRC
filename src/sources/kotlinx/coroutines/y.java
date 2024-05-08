package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CompletionState.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final Object f51566a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Function1<Throwable, kotlin.p> f51567b;

    /* JADX WARN: Multi-variable type inference failed */
    public y(@Nullable Object obj, @NotNull Function1<? super Throwable, kotlin.p> function1) {
        this.f51566a = obj;
        this.f51567b = function1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return kotlin.jvm.internal.s.d(this.f51566a, yVar.f51566a) && kotlin.jvm.internal.s.d(this.f51567b, yVar.f51567b);
    }

    public int hashCode() {
        Object obj = this.f51566a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f51567b.hashCode();
    }

    @NotNull
    public String toString() {
        return "CompletedWithCancellation(result=" + this.f51566a + ", onCancellation=" + ((Object) this.f51567b) + ')';
    }
}
