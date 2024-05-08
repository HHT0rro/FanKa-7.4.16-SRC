package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Zip.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1", f = "Zip.kt", l = {273}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FlowKt__ZipKt$combineTransformUnsafe$1 extends SuspendLambda implements Function2<d<Object>, Continuation<? super kotlin.p>, Object> {
    public final /* synthetic */ c<Object>[] $flows;
    public final /* synthetic */ Function3<d<Object>, Object[], Continuation<? super kotlin.p>, Object> $transform;
    private /* synthetic */ Object L$0;
    public int label;

    /* compiled from: Zip.kt */
    @kotlin.d
    @td.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1", f = "Zip.kt", l = {273}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<d<Object>, Object[], Continuation<? super kotlin.p>, Object> {
        public final /* synthetic */ Function3<d<Object>, Object[], Continuation<? super kotlin.p>, Object> $transform;
        private /* synthetic */ Object L$0;
        public /* synthetic */ Object L$1;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super d<Object>, ? super Object[], ? super Continuation<? super kotlin.p>, ? extends Object> function3, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$transform = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull d<Object> dVar, @NotNull Object[] objArr, @Nullable Continuation<? super kotlin.p> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, continuation);
            anonymousClass1.L$0 = dVar;
            anonymousClass1.L$1 = objArr;
            return anonymousClass1.invokeSuspend(kotlin.p.f51048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object d10 = sd.a.d();
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.e.b(obj);
                d<Object> dVar = (d) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                Function3<d<Object>, Object[], Continuation<? super kotlin.p>, Object> function3 = this.$transform;
                this.L$0 = null;
                this.label = 1;
                if (function3.invoke(dVar, objArr, this) == d10) {
                    return d10;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.e.b(obj);
            }
            return kotlin.p.f51048a;
        }

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            this.$transform.invoke((d) this.L$0, (Object[]) this.L$1, this);
            return kotlin.p.f51048a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combineTransformUnsafe$1(c<Object>[] cVarArr, Function3<? super d<Object>, ? super Object[], ? super Continuation<? super kotlin.p>, ? extends Object> function3, Continuation<? super FlowKt__ZipKt$combineTransformUnsafe$1> continuation) {
        super(2, continuation);
        this.$flows = cVarArr;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ZipKt$combineTransformUnsafe$1 flowKt__ZipKt$combineTransformUnsafe$1 = new FlowKt__ZipKt$combineTransformUnsafe$1(this.$flows, this.$transform, continuation);
        flowKt__ZipKt$combineTransformUnsafe$1.L$0 = obj;
        return flowKt__ZipKt$combineTransformUnsafe$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull d<Object> dVar, @Nullable Continuation<? super kotlin.p> continuation) {
        return ((FlowKt__ZipKt$combineTransformUnsafe$1) create(dVar, continuation)).invokeSuspend(kotlin.p.f51048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Function0 b4;
        Object d10 = sd.a.d();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.e.b(obj);
            d dVar = (d) this.L$0;
            c<Object>[] cVarArr = this.$flows;
            b4 = FlowKt__ZipKt.b();
            kotlin.jvm.internal.s.n();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, null);
            this.label = 1;
            if (CombineKt.a(dVar, cVarArr, b4, anonymousClass1, this) == d10) {
                return d10;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.e.b(obj);
        }
        return kotlin.p.f51048a;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        Function0 b4;
        d dVar = (d) this.L$0;
        c<Object>[] cVarArr = this.$flows;
        b4 = FlowKt__ZipKt.b();
        kotlin.jvm.internal.s.n();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, null);
        kotlin.jvm.internal.r.c(0);
        CombineKt.a(dVar, cVarArr, b4, anonymousClass1, this);
        kotlin.jvm.internal.r.c(1);
        return kotlin.p.f51048a;
    }
}
