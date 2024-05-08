package androidx.lifecycle;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.m;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.x1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowLiveData.kt */
@td.d(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {110, 114}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class FlowLiveDataConversions$asFlow$1<T> extends SuspendLambda implements Function2<m<? super T>, Continuation<? super p>, Object> {
    public final /* synthetic */ LiveData<T> $this_asFlow;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* compiled from: FlowLiveData.kt */
    @td.d(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<h0, Continuation<? super p>, Object> {
        public final /* synthetic */ Observer<T> $observer;
        public final /* synthetic */ LiveData<T> $this_asFlow;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LiveData<T> liveData, Observer<T> observer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_asFlow = liveData;
            this.$observer = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_asFlow, this.$observer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo1743invoke(@NotNull h0 h0Var, @Nullable Continuation<? super p> continuation) {
            return ((AnonymousClass1) create(h0Var, continuation)).invokeSuspend(p.f51048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            sd.a.d();
            if (this.label == 0) {
                kotlin.e.b(obj);
                this.$this_asFlow.observeForever(this.$observer);
                return p.f51048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asFlow$1(LiveData<T> liveData, Continuation<? super FlowLiveDataConversions$asFlow$1> continuation) {
        super(2, continuation);
        this.$this_asFlow = liveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.$this_asFlow, continuation);
        flowLiveDataConversions$asFlow$1.L$0 = obj;
        return flowLiveDataConversions$asFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull m<? super T> mVar, @Nullable Continuation<? super p> continuation) {
        return ((FlowLiveDataConversions$asFlow$1) create(mVar, continuation)).invokeSuspend(p.f51048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        final Observer observer;
        m mVar;
        Object d10 = sd.a.d();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.e.b(obj);
            final m mVar2 = (m) this.L$0;
            observer = new Observer() { // from class: androidx.lifecycle.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    m.this.l(obj2);
                }
            };
            x1 x10 = r0.c().x();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, observer, null);
            this.L$0 = mVar2;
            this.L$1 = observer;
            this.label = 1;
            if (kotlinx.coroutines.g.c(x10, anonymousClass1, this) == d10) {
                return d10;
            }
            mVar = mVar2;
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.e.b(obj);
                return p.f51048a;
            }
            observer = (Observer) this.L$1;
            mVar = (m) this.L$0;
            kotlin.e.b(obj);
        }
        final LiveData<T> liveData = this.$this_asFlow;
        Function0<p> function0 = new Function0<p>() { // from class: androidx.lifecycle.FlowLiveDataConversions$asFlow$1.2

            /* compiled from: FlowLiveData.kt */
            @td.d(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
            /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1, reason: invalid class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<h0, Continuation<? super p>, Object> {
                public final /* synthetic */ Observer<T> $observer;
                public final /* synthetic */ LiveData<T> $this_asFlow;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(LiveData<T> liveData, Observer<T> observer, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$this_asFlow = liveData;
                    this.$observer = observer;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.$this_asFlow, this.$observer, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo1743invoke(@NotNull h0 h0Var, @Nullable Continuation<? super p> continuation) {
                    return ((AnonymousClass1) create(h0Var, continuation)).invokeSuspend(p.f51048a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    sd.a.d();
                    if (this.label == 0) {
                        kotlin.e.b(obj);
                        this.$this_asFlow.removeObserver(this.$observer);
                        return p.f51048a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                kotlinx.coroutines.h.b(f1.f51235b, r0.c().x(), null, new AnonymousClass1(liveData, observer, null), 2, null);
            }
        };
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (ProduceKt.a(mVar, function0, this) == d10) {
            return d10;
        }
        return p.f51048a;
    }
}
