package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancellableContinuationImpl.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final Object f51554a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final j f51555b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final Function1<Throwable, kotlin.p> f51556c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final Object f51557d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final Throwable f51558e;

    /* JADX WARN: Multi-variable type inference failed */
    public w(@Nullable Object obj, @Nullable j jVar, @Nullable Function1<? super Throwable, kotlin.p> function1, @Nullable Object obj2, @Nullable Throwable th) {
        this.f51554a = obj;
        this.f51555b = jVar;
        this.f51556c = function1;
        this.f51557d = obj2;
        this.f51558e = th;
    }

    public static /* synthetic */ w b(w wVar, Object obj, j jVar, Function1 function1, Object obj2, Throwable th, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = wVar.f51554a;
        }
        if ((i10 & 2) != 0) {
            jVar = wVar.f51555b;
        }
        j jVar2 = jVar;
        if ((i10 & 4) != 0) {
            function1 = wVar.f51556c;
        }
        Function1 function12 = function1;
        if ((i10 & 8) != 0) {
            obj2 = wVar.f51557d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th = wVar.f51558e;
        }
        return wVar.a(obj, jVar2, function12, obj4, th);
    }

    @NotNull
    public final w a(@Nullable Object obj, @Nullable j jVar, @Nullable Function1<? super Throwable, kotlin.p> function1, @Nullable Object obj2, @Nullable Throwable th) {
        return new w(obj, jVar, function1, obj2, th);
    }

    public final boolean c() {
        return this.f51558e != null;
    }

    public final void d(@NotNull m<?> mVar, @NotNull Throwable th) {
        j jVar = this.f51555b;
        if (jVar != null) {
            mVar.j(jVar, th);
        }
        Function1<Throwable, kotlin.p> function1 = this.f51556c;
        if (function1 != null) {
            mVar.k(function1, th);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return kotlin.jvm.internal.s.d(this.f51554a, wVar.f51554a) && kotlin.jvm.internal.s.d(this.f51555b, wVar.f51555b) && kotlin.jvm.internal.s.d(this.f51556c, wVar.f51556c) && kotlin.jvm.internal.s.d(this.f51557d, wVar.f51557d) && kotlin.jvm.internal.s.d(this.f51558e, wVar.f51558e);
    }

    public int hashCode() {
        Object obj = this.f51554a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        j jVar = this.f51555b;
        int hashCode2 = (hashCode + (jVar == null ? 0 : jVar.hashCode())) * 31;
        Function1<Throwable, kotlin.p> function1 = this.f51556c;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.f51557d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f51558e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.f51554a + ", cancelHandler=" + ((Object) this.f51555b) + ", onCancellation=" + ((Object) this.f51556c) + ", idempotentResume=" + this.f51557d + ", cancelCause=" + ((Object) this.f51558e) + ')';
    }

    public /* synthetic */ w(Object obj, j jVar, Function1 function1, Object obj2, Throwable th, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i10 & 2) != 0 ? null : jVar, (i10 & 4) != 0 ? null : function1, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th);
    }
}
