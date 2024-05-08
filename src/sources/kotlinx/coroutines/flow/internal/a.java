package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.flow.internal.c;
import kotlinx.coroutines.flow.p1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractSharedFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class a<S extends c<?>> {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public S[] f51320b;

    /* renamed from: c, reason: collision with root package name */
    public int f51321c;

    /* renamed from: d, reason: collision with root package name */
    public int f51322d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public r f51323e;

    @NotNull
    public final S e() {
        S s2;
        r rVar;
        synchronized (this) {
            S[] sArr = this.f51320b;
            if (sArr == null) {
                sArr = g(2);
                this.f51320b = sArr;
            } else if (this.f51321c >= sArr.length) {
                Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                s.h(copyOf, "copyOf(this, newSize)");
                this.f51320b = (S[]) ((c[]) copyOf);
                sArr = (S[]) ((c[]) copyOf);
            }
            int i10 = this.f51322d;
            do {
                s2 = sArr[i10];
                if (s2 == null) {
                    s2 = f();
                    sArr[i10] = s2;
                }
                i10++;
                if (i10 >= sArr.length) {
                    i10 = 0;
                }
            } while (!s2.a(this));
            this.f51322d = i10;
            this.f51321c++;
            rVar = this.f51323e;
        }
        if (rVar != null) {
            rVar.Z(1);
        }
        return s2;
    }

    @NotNull
    public abstract S f();

    @NotNull
    public abstract S[] g(int i10);

    public final void h(@NotNull S s2) {
        r rVar;
        int i10;
        Continuation<kotlin.p>[] b4;
        synchronized (this) {
            int i11 = this.f51321c - 1;
            this.f51321c = i11;
            rVar = this.f51323e;
            if (i11 == 0) {
                this.f51322d = 0;
            }
            b4 = s2.b(this);
        }
        for (Continuation<kotlin.p> continuation : b4) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m3565constructorimpl(kotlin.p.f51048a));
            }
        }
        if (rVar != null) {
            rVar.Z(-1);
        }
    }

    public final int i() {
        return this.f51321c;
    }

    @Nullable
    public final S[] l() {
        return this.f51320b;
    }

    @NotNull
    public final p1<Integer> o() {
        r rVar;
        synchronized (this) {
            rVar = this.f51323e;
            if (rVar == null) {
                rVar = new r(this.f51321c);
                this.f51323e = rVar;
            }
        }
        return rVar;
    }
}
