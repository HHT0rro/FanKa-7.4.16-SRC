package com.cupidapp.live.base.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.b;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TripleCombineLiveData.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TripleCombineLiveData<T1, T2, T3, R> extends MediatorLiveData<R> {

    /* compiled from: TripleCombineLiveData.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements Observer, p {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f11865a;

        public a(Function1 function) {
            s.i(function, "function");
            this.f11865a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof p)) {
                return s.d(getFunctionDelegate(), ((p) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.p
        @NotNull
        public final b<?> getFunctionDelegate() {
            return this.f11865a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f11865a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TripleCombineLiveData(@NotNull final LiveData<T1> source1, @NotNull final LiveData<T2> source2, @NotNull final LiveData<T3> source3, @NotNull final Function3<? super T1, ? super T2, ? super T3, ? extends R> combiner) {
        s.i(source1, "source1");
        s.i(source2, "source2");
        s.i(source3, "source3");
        s.i(combiner, "combiner");
        addSource(source1, new a(new Function1<T1, kotlin.p>(this) { // from class: com.cupidapp.live.base.livedata.TripleCombineLiveData.1
            public final /* synthetic */ TripleCombineLiveData<T1, T2, T3, R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2((AnonymousClass1) obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T1 t12) {
                this.this$0.setValue(combiner.invoke(t12, source2.getValue(), source3.getValue()));
            }
        }));
        addSource(source2, new a(new Function1<T2, kotlin.p>(this) { // from class: com.cupidapp.live.base.livedata.TripleCombineLiveData.2
            public final /* synthetic */ TripleCombineLiveData<T1, T2, T3, R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2((AnonymousClass2) obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T2 t2) {
                this.this$0.setValue(combiner.invoke(source1.getValue(), t2, source3.getValue()));
            }
        }));
        addSource(source3, new a(new Function1<T3, kotlin.p>(this) { // from class: com.cupidapp.live.base.livedata.TripleCombineLiveData.3
            public final /* synthetic */ TripleCombineLiveData<T1, T2, T3, R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2((AnonymousClass3) obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T3 t32) {
                this.this$0.setValue(combiner.invoke(source1.getValue(), source2.getValue(), t32));
            }
        }));
    }
}
