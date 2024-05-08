package com.cupidapp.live.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.base.activity.DefaultEvent;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKAlertLayout;
import he.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKBaseFragment extends Fragment implements g {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11789d = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public CompositeDisposable f11787b = new CompositeDisposable();

    /* renamed from: c, reason: collision with root package name */
    public boolean f11788c = true;

    @Override // com.cupidapp.live.base.network.g
    public void H(@NotNull Disposable disposable) {
        s.i(disposable, "disposable");
        this.f11787b.add(disposable);
    }

    public void N0() {
        this.f11789d.clear();
    }

    @NotNull
    public SensorPosition O0() {
        return SensorPosition.Unknown;
    }

    public boolean P0() {
        return this.f11788c;
    }

    public final void Q0() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            FKAlertLayout.a aVar = FKAlertLayout.f12456d;
            View findViewById = activity.findViewById(16908290);
            s.h(findViewById, "it.findViewById(android.R.id.content)");
            aVar.c((ViewGroup) findViewById);
        }
    }

    public final void R0() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            FKAlertLayout.a aVar = FKAlertLayout.f12456d;
            View findViewById = activity.findViewById(16908290);
            s.h(findViewById, "it.findViewById<ViewGroup>(android.R.id.content)");
            aVar.a((ViewGroup) findViewById).e();
        }
    }

    @Override // com.cupidapp.live.base.network.g
    @Nullable
    public Context getStartApiRequestContext() {
        return getActivity();
    }

    public boolean onBackPressed() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f11787b.dispose();
        super.onDestroyView();
        N0();
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull DefaultEvent event) {
        s.i(event, "event");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (P0()) {
            y0.a.f54658a.c(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (P0()) {
            y0.a.b(y0.a.f54658a, this, null, 2, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        if (this.f11787b.isDisposed()) {
            this.f11787b = new CompositeDisposable();
        }
    }
}
