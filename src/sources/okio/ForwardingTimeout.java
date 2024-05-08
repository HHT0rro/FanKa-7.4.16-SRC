package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ForwardingTimeout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ForwardingTimeout extends Timeout {

    @NotNull
    private Timeout delegate;

    public ForwardingTimeout(@NotNull Timeout delegate) {
        s.i(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @NotNull
    public final Timeout delegate() {
        return this.delegate;
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    /* renamed from: setDelegate, reason: collision with other method in class */
    public final /* synthetic */ void m3743setDelegate(@NotNull Timeout timeout) {
        s.i(timeout, "<set-?>");
        this.delegate = timeout;
    }

    @Override // okio.Timeout
    public void throwIfReached() throws IOException {
        this.delegate.throwIfReached();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout timeout(long j10, @NotNull TimeUnit unit) {
        s.i(unit, "unit");
        return this.delegate.timeout(j10, unit);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout deadlineNanoTime(long j10) {
        return this.delegate.deadlineNanoTime(j10);
    }

    @NotNull
    public final ForwardingTimeout setDelegate(@NotNull Timeout delegate) {
        s.i(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }
}
