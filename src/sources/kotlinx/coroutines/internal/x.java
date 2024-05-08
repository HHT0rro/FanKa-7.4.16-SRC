package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.t0;
import kotlinx.coroutines.x1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MainDispatchers.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class x extends x1 implements m0 {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Throwable f51423b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f51424c;

    public x(@Nullable Throwable th, @Nullable String str) {
        this.f51423b = th;
        this.f51424c = str;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public Void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        C();
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r1 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Void C() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f51423b
            if (r0 == 0) goto L36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f51424c
            if (r1 == 0) goto L25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L27
        L25:
            java.lang.String r1 = ""
        L27:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f51423b
            r1.<init>(r0, r2)
            throw r1
        L36:
            kotlinx.coroutines.internal.w.d()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.x.C():java.lang.Void");
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Void k(long j10, @NotNull kotlinx.coroutines.l<? super kotlin.p> lVar) {
        C();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        C();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    public t0 l(long j10, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        C();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.x1, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public CoroutineDispatcher limitedParallelism(int i10) {
        C();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.x1, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Dispatchers.Main[missing");
        if (this.f51423b != null) {
            str = ", cause=" + ((Object) this.f51423b);
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // kotlinx.coroutines.x1
    @NotNull
    public x1 x() {
        return this;
    }
}
