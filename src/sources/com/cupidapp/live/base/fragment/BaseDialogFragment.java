package com.cupidapp.live.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.cupidapp.live.base.activity.DefaultEvent;
import com.cupidapp.live.base.network.g;
import he.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseDialogFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseDialogFragment extends DialogFragment implements g {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11785d = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public CompositeDisposable f11783b = new CompositeDisposable();

    /* renamed from: c, reason: collision with root package name */
    public boolean f11784c = true;

    @Override // com.cupidapp.live.base.network.g
    public void H(@NotNull Disposable disposable) {
        s.i(disposable, "disposable");
        this.f11783b.add(disposable);
    }

    public void N0() {
        this.f11785d.clear();
    }

    public boolean O0() {
        return this.f11784c;
    }

    @Override // com.cupidapp.live.base.network.g
    @Nullable
    public Context getStartApiRequestContext() {
        return getContext();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f11783b.dispose();
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
        if (O0()) {
            y0.a.f54658a.c(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (O0()) {
            y0.a.b(y0.a.f54658a, this, null, 2, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        if (this.f11783b.isDisposed()) {
            this.f11783b = new CompositeDisposable();
        }
    }
}
