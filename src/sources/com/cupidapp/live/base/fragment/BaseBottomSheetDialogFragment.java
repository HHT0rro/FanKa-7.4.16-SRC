package com.cupidapp.live.base.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.activity.DefaultEvent;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.utils.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseBottomSheetDialogFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseBottomSheetDialogFragment extends BottomSheetDialogFragment implements g, d {

    /* renamed from: c, reason: collision with root package name */
    public boolean f11780c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11781d = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public CompositeDisposable f11779b = new CompositeDisposable();

    /* compiled from: BaseBottomSheetDialogFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior<View> f11782a;

        public a(BottomSheetBehavior<View> bottomSheetBehavior) {
            this.f11782a = bottomSheetBehavior;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NotNull View bottomSheet, float f10) {
            s.i(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NotNull View bottomSheet, int i10) {
            s.i(bottomSheet, "bottomSheet");
            if (i10 == 1) {
                this.f11782a.setState(3);
            }
        }
    }

    public static /* synthetic */ void S0(BaseBottomSheetDialogFragment baseBottomSheetDialogFragment, int i10, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBottomSheetBehaviorState");
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        baseBottomSheetDialogFragment.R0(i10, z10);
    }

    public static final void T0(BaseBottomSheetDialogFragment this$0, int i10, boolean z10) {
        s.i(this$0, "this$0");
        View view = this$0.getView();
        Object parent = view != null ? view.getParent() : null;
        View view2 = parent instanceof View ? (View) parent : null;
        ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
        CoordinatorLayout.LayoutParams layoutParams2 = layoutParams instanceof CoordinatorLayout.LayoutParams ? (CoordinatorLayout.LayoutParams) layoutParams : null;
        Object behavior = layoutParams2 != null ? layoutParams2.getBehavior() : null;
        BottomSheetBehavior bottomSheetBehavior = behavior instanceof BottomSheetBehavior ? (BottomSheetBehavior) behavior : null;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(i10);
        }
        if (!z10 || bottomSheetBehavior == null) {
            return;
        }
        bottomSheetBehavior.addBottomSheetCallback(new a(bottomSheetBehavior));
    }

    @Override // com.cupidapp.live.base.network.g
    public void H(@NotNull Disposable disposable) {
        s.i(disposable, "disposable");
        this.f11779b.add(disposable);
    }

    @Override // com.cupidapp.live.base.fragment.d
    public void L() {
        try {
            Q0();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void O0() {
        this.f11781d.clear();
    }

    public boolean P0() {
        return this.f11780c;
    }

    public final void Q0() {
        if (isResumed()) {
            dismiss();
        } else {
            dismissAllowingStateLoss();
        }
    }

    public final void R0(final int i10, final boolean z10) {
        View view = getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.cupidapp.live.base.fragment.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseBottomSheetDialogFragment.T0(BaseBottomSheetDialogFragment.this, i10, z10);
                }
            });
        }
    }

    public final void U0(@NotNull RecyclerView recyclerView) {
        s.i(recyclerView, "recyclerView");
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override // com.cupidapp.live.base.network.g
    @Nullable
    public Context getStartApiRequestContext() {
        return getActivity();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.TransparentBottomSheetDialogTheme);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context context = getContext();
        if (context != null) {
            return new AppBottomSheetDialog(context, getTheme());
        }
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        s.h(onCreateDialog, "{\n            super.onCr…dInstanceState)\n        }");
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (P0()) {
            b.f11807a.d(this);
        }
        this.f11779b.dispose();
        super.onDestroyView();
        j.f12332a.a("BaseBottomSheetDialogFragment", "onDestroyView this: " + ((Object) this));
        O0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull DefaultEvent event) {
        s.i(event, "event");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        y0.a.f54658a.c(this);
        j.f12332a.a("BaseBottomSheetDialogFragment", "onPause this: " + ((Object) this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        y0.a.b(y0.a.f54658a, this, null, 2, null);
        j.f12332a.a("BaseBottomSheetDialogFragment", "onResume this: " + ((Object) this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        if (P0()) {
            b.f11807a.a(this);
        }
        if (this.f11779b.isDisposed()) {
            this.f11779b = new CompositeDisposable();
        }
    }
}
