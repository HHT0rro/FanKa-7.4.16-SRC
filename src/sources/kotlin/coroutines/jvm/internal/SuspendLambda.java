package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContinuationImpl.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class SuspendLambda extends ContinuationImpl implements q<Object> {
    private final int arity;

    public SuspendLambda(int i10, @Nullable Continuation<Object> continuation) {
        super(continuation);
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.q
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public String toString() {
        if (getCompletion() == null) {
            String j10 = v.j(this);
            s.h(j10, "renderLambdaToString(this)");
            return j10;
        }
        return super.toString();
    }

    public SuspendLambda(int i10) {
        this(i10, null);
    }
}
