package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinExtensions.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class KotlinExtensions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: KotlinExtensions.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<T> implements d<T> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.l f53387b;

        public a(kotlinx.coroutines.l lVar) {
            this.f53387b = lVar;
        }

        @Override // retrofit2.d
        public void a(@NotNull retrofit2.b<T> call, @NotNull Throwable t2) {
            kotlin.jvm.internal.s.j(call, "call");
            kotlin.jvm.internal.s.j(t2, "t");
            kotlinx.coroutines.l lVar = this.f53387b;
            Result.Companion companion = Result.Companion;
            lVar.resumeWith(Result.m3565constructorimpl(kotlin.e.a(t2)));
        }

        @Override // retrofit2.d
        public void b(@NotNull retrofit2.b<T> call, @NotNull Response<T> response) {
            kotlin.jvm.internal.s.j(call, "call");
            kotlin.jvm.internal.s.j(response, "response");
            if (response.d()) {
                T a10 = response.a();
                if (a10 == null) {
                    Object tag = call.request().tag(i.class);
                    if (tag == null) {
                        kotlin.jvm.internal.s.u();
                    }
                    kotlin.jvm.internal.s.e(tag, "call.request().tag(Invocation::class.java)!!");
                    Method method = ((i) tag).a();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Response from ");
                    kotlin.jvm.internal.s.e(method, "method");
                    Class<?> declaringClass = method.getDeclaringClass();
                    kotlin.jvm.internal.s.e(declaringClass, "method.declaringClass");
                    sb2.append(declaringClass.getName());
                    sb2.append('.');
                    sb2.append(method.getName());
                    sb2.append(" was null but response body type was declared as non-null");
                    KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb2.toString());
                    kotlinx.coroutines.l lVar = this.f53387b;
                    Result.Companion companion = Result.Companion;
                    lVar.resumeWith(Result.m3565constructorimpl(kotlin.e.a(kotlinNullPointerException)));
                    return;
                }
                kotlinx.coroutines.l lVar2 = this.f53387b;
                Result.Companion companion2 = Result.Companion;
                lVar2.resumeWith(Result.m3565constructorimpl(a10));
                return;
            }
            kotlinx.coroutines.l lVar3 = this.f53387b;
            HttpException httpException = new HttpException(response);
            Result.Companion companion3 = Result.Companion;
            lVar3.resumeWith(Result.m3565constructorimpl(kotlin.e.a(httpException)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: KotlinExtensions.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b<T> implements d<T> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.l f53388b;

        public b(kotlinx.coroutines.l lVar) {
            this.f53388b = lVar;
        }

        @Override // retrofit2.d
        public void a(@NotNull retrofit2.b<T> call, @NotNull Throwable t2) {
            kotlin.jvm.internal.s.j(call, "call");
            kotlin.jvm.internal.s.j(t2, "t");
            kotlinx.coroutines.l lVar = this.f53388b;
            Result.Companion companion = Result.Companion;
            lVar.resumeWith(Result.m3565constructorimpl(kotlin.e.a(t2)));
        }

        @Override // retrofit2.d
        public void b(@NotNull retrofit2.b<T> call, @NotNull Response<T> response) {
            kotlin.jvm.internal.s.j(call, "call");
            kotlin.jvm.internal.s.j(response, "response");
            if (response.d()) {
                kotlinx.coroutines.l lVar = this.f53388b;
                T a10 = response.a();
                Result.Companion companion = Result.Companion;
                lVar.resumeWith(Result.m3565constructorimpl(a10));
                return;
            }
            kotlinx.coroutines.l lVar2 = this.f53388b;
            HttpException httpException = new HttpException(response);
            Result.Companion companion2 = Result.Companion;
            lVar2.resumeWith(Result.m3565constructorimpl(kotlin.e.a(httpException)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: KotlinExtensions.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c<T> implements d<T> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.l f53389b;

        public c(kotlinx.coroutines.l lVar) {
            this.f53389b = lVar;
        }

        @Override // retrofit2.d
        public void a(@NotNull retrofit2.b<T> call, @NotNull Throwable t2) {
            kotlin.jvm.internal.s.j(call, "call");
            kotlin.jvm.internal.s.j(t2, "t");
            kotlinx.coroutines.l lVar = this.f53389b;
            Result.Companion companion = Result.Companion;
            lVar.resumeWith(Result.m3565constructorimpl(kotlin.e.a(t2)));
        }

        @Override // retrofit2.d
        public void b(@NotNull retrofit2.b<T> call, @NotNull Response<T> response) {
            kotlin.jvm.internal.s.j(call, "call");
            kotlin.jvm.internal.s.j(response, "response");
            kotlinx.coroutines.l lVar = this.f53389b;
            Result.Companion companion = Result.Companion;
            lVar.resumeWith(Result.m3565constructorimpl(response));
        }
    }

    @Nullable
    public static final <T> Object a(@NotNull final retrofit2.b<T> bVar, @NotNull Continuation<? super T> continuation) {
        kotlinx.coroutines.m mVar = new kotlinx.coroutines.m(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        mVar.v(new Function1<Throwable, kotlin.p>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                b.this.cancel();
            }
        });
        bVar.b(new a(mVar));
        Object r10 = mVar.r();
        if (r10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return r10;
    }

    @Nullable
    public static final <T> Object b(@NotNull final retrofit2.b<T> bVar, @NotNull Continuation<? super T> continuation) {
        kotlinx.coroutines.m mVar = new kotlinx.coroutines.m(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        mVar.v(new Function1<Throwable, kotlin.p>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                b.this.cancel();
            }
        });
        bVar.b(new b(mVar));
        Object r10 = mVar.r();
        if (r10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return r10;
    }

    @Nullable
    public static final <T> Object c(@NotNull final retrofit2.b<T> bVar, @NotNull Continuation<? super Response<T>> continuation) {
        kotlinx.coroutines.m mVar = new kotlinx.coroutines.m(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        mVar.v(new Function1<Throwable, kotlin.p>() { // from class: retrofit2.KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                b.this.cancel();
            }
        });
        bVar.b(new c(mVar));
        Object r10 = mVar.r();
        if (r10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return r10;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object d(@org.jetbrains.annotations.NotNull java.lang.Exception r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$yieldAndThrow$1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$yieldAndThrow$1 r0 = (retrofit2.KotlinExtensions$yieldAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$yieldAndThrow$1 r0 = new retrofit2.KotlinExtensions$yieldAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = sd.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            boolean r0 = r5 instanceof kotlin.Result.Failure
            if (r0 == 0) goto L49
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            boolean r2 = r5 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L4a
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = kotlinx.coroutines.q2.a(r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            throw r4
        L4a:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.d(java.lang.Exception, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
