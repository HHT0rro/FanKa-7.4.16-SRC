package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* compiled from: Select.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f51502a = AtomicLongFieldUpdater.newUpdater(h.class, "number");

    @NotNull
    private volatile /* synthetic */ long number = 1;

    public final long a() {
        return f51502a.incrementAndGet(this);
    }
}
