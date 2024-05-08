package com.cupidapp.live.base.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDialogFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseAppCompatDialogFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseAppCompatDialogFragment extends AppCompatDialogFragment implements d {

    /* renamed from: b, reason: collision with root package name */
    public boolean f11777b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11778c = new LinkedHashMap();

    @Override // com.cupidapp.live.base.fragment.d
    public void L() {
        try {
            P0();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void N0() {
        this.f11778c.clear();
    }

    public boolean O0() {
        return this.f11777b;
    }

    public final void P0() {
        if (isResumed()) {
            dismiss();
        } else {
            dismissAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (O0()) {
            b.f11807a.d(this);
        }
        super.onDestroyView();
        N0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        if (O0()) {
            b.f11807a.a(this);
        }
    }
}
