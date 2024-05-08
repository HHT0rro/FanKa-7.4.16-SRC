package androidx.databinding;

import androidx.annotation.RestrictTo;
import androidx.databinding.ViewDataBindingKtx;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ViewDataBindingKtx.kt */
@d
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ViewDataBindingKtx {

    @NotNull
    public static final ViewDataBindingKtx INSTANCE = new ViewDataBindingKtx();

    @NotNull
    private static final CreateWeakListener CREATE_STATE_FLOW_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBindingKtx$CREATE_STATE_FLOW_LISTENER$1
        @Override // androidx.databinding.CreateWeakListener
        public final WeakListener create(ViewDataBinding viewDataBinding, int i10, ReferenceQueue<ViewDataBinding> referenceQueue) {
            s.h(referenceQueue, "referenceQueue");
            return new ViewDataBindingKtx.StateFlowListener(viewDataBinding, i10, referenceQueue).getListener();
        }
    };

    /* compiled from: ViewDataBindingKtx.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class StateFlowListener implements ObservableReference<c<? extends Object>> {

        @Nullable
        private WeakReference<LifecycleOwner> _lifecycleOwnerRef;

        @NotNull
        private final WeakListener<c<Object>> listener;

        @Nullable
        private n1 observerJob;

        public StateFlowListener(@Nullable ViewDataBinding viewDataBinding, int i10, @NotNull ReferenceQueue<ViewDataBinding> referenceQueue) {
            s.i(referenceQueue, "referenceQueue");
            this.listener = new WeakListener<>(viewDataBinding, i10, this, referenceQueue);
        }

        private final void startCollection(LifecycleOwner lifecycleOwner, c<? extends Object> cVar) {
            n1 n1Var = this.observerJob;
            if (n1Var != null) {
                n1.a.a(n1Var, null, 1, null);
            }
            this.observerJob = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenCreated(new ViewDataBindingKtx$StateFlowListener$startCollection$1(cVar, this, null));
        }

        @Override // androidx.databinding.ObservableReference
        @NotNull
        public WeakListener<c<? extends Object>> getListener() {
            return this.listener;
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
            WeakReference<LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            if ((weakReference == null ? null : weakReference.get()) == lifecycleOwner) {
                return;
            }
            n1 n1Var = this.observerJob;
            if (n1Var != null) {
                n1.a.a(n1Var, null, 1, null);
            }
            if (lifecycleOwner == null) {
                this._lifecycleOwnerRef = null;
                return;
            }
            this._lifecycleOwnerRef = new WeakReference<>(lifecycleOwner);
            c<? extends Object> cVar = (c) this.listener.getTarget();
            if (cVar != null) {
                startCollection(lifecycleOwner, cVar);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(@Nullable c<? extends Object> cVar) {
            WeakReference<LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            LifecycleOwner lifecycleOwner = weakReference == null ? null : weakReference.get();
            if (lifecycleOwner == null || cVar == null) {
                return;
            }
            startCollection(lifecycleOwner, cVar);
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(@Nullable c<? extends Object> cVar) {
            n1 n1Var = this.observerJob;
            if (n1Var != null) {
                n1.a.a(n1Var, null, 1, null);
            }
            this.observerJob = null;
        }
    }

    private ViewDataBindingKtx() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean updateStateFlowRegistration(@NotNull ViewDataBinding viewDataBinding, int i10, @Nullable c<?> cVar) {
        s.i(viewDataBinding, "viewDataBinding");
        viewDataBinding.mInStateFlowRegisterObserver = true;
        try {
            return viewDataBinding.updateRegistration(i10, cVar, CREATE_STATE_FLOW_LISTENER);
        } finally {
            viewDataBinding.mInStateFlowRegisterObserver = false;
        }
    }
}
