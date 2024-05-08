package com.cupidapp.live.setting.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.view.FKCropImageLayout;
import com.cupidapp.live.setting.model.FKCropImageModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseCropImageFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class FKBaseCropImageFragment extends FKBaseFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f18109h = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Function0<kotlin.p> f18110e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Function1<? super Bitmap, kotlin.p> f18111f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18112g = new LinkedHashMap();

    /* compiled from: BaseCropImageFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKBaseCropImageFragment a(@NotNull FKBaseCropImageFragment fragment, @NotNull FragmentActivity activity, int i10, @NotNull FKCropImageModel model) {
            kotlin.jvm.internal.s.i(fragment, "fragment");
            kotlin.jvm.internal.s.i(activity, "activity");
            kotlin.jvm.internal.s.i(model, "model");
            Bundle bundle = new Bundle();
            z0.g.d(bundle, model);
            fragment.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R$anim.anim_activity_common_start, 0, 0, R$anim.anim_activity_common_hide_by_start).add(i10, fragment).commitAllowingStateLoss();
            return fragment;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18112g.clear();
    }

    public final void S0() {
        Function0<kotlin.p> function0 = this.f18110e;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void T0() {
        Function1<? super Bitmap, kotlin.p> function1;
        Bitmap w3 = W0().w(1242.0f);
        if (w3 == null || (function1 = this.f18111f) == null) {
            return;
        }
        function1.invoke(w3);
    }

    @NotNull
    public abstract FKCropImageLayout U0();

    @NotNull
    public abstract FKCropImageLayout V0();

    public final FKCropImageLayout W0() {
        FKCropImageModel fKCropImageModel;
        FKCropImageLayout V0 = V0();
        Bundle arguments = getArguments();
        if (arguments == null || (fKCropImageModel = (FKCropImageModel) z0.g.b(arguments, FKCropImageModel.class)) == null) {
            return V0;
        }
        if (fKCropImageModel.getCropSquare()) {
            V0().setVisibility(0);
            U0().setVisibility(8);
            return V0();
        }
        V0().setVisibility(8);
        U0().setVisibility(0);
        return U0();
    }

    public final void X0(@Nullable Function0<kotlin.p> function0) {
        this.f18110e = function0;
    }

    public final void Y0(@Nullable Function1<? super Bitmap, kotlin.p> function1) {
        this.f18111f = function1;
    }

    public final void Z0(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (kotlin.text.p.F(str, "file://", false, 2, null)) {
            str = str.substring(7);
            kotlin.jvm.internal.s.h(str, "this as java.lang.String).substring(startIndex)");
        }
        W0().setImageFromPath(str);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        FKCropImageModel fKCropImageModel;
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Z0((arguments == null || (fKCropImageModel = (FKCropImageModel) z0.g.b(arguments, FKCropImageModel.class)) == null) ? null : fKCropImageModel.getMediaContentPath());
    }
}
