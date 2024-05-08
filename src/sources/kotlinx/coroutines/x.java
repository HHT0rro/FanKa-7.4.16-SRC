package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: CompletionState.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class x {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51561b = AtomicIntegerFieldUpdater.newUpdater(x.class, "_handled");

    @NotNull
    private volatile /* synthetic */ int _handled;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Throwable f51562a;

    public x(@NotNull Throwable th, boolean z10) {
        this.f51562a = th;
        this._handled = z10 ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f51561b.compareAndSet(this, 0, 1);
    }

    @NotNull
    public String toString() {
        return j0.a(this) + '[' + ((Object) this.f51562a) + ']';
    }

    public /* synthetic */ x(Throwable th, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i10 & 2) != 0 ? false : z10);
    }
}
