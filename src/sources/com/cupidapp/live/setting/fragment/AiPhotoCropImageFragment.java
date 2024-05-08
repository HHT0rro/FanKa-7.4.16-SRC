package com.cupidapp.live.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.FKCropImageLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: AiPhotoCropImageFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AiPhotoCropImageFragment extends FKBaseCropImageFragment {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18101i = new LinkedHashMap();

    @Override // com.cupidapp.live.setting.fragment.FKBaseCropImageFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18101i.clear();
    }

    @Override // com.cupidapp.live.setting.fragment.FKBaseCropImageFragment
    @NotNull
    public FKCropImageLayout U0() {
        FKCropImageLayout cropImageView = (FKCropImageLayout) a1(R$id.cropImageView);
        kotlin.jvm.internal.s.h(cropImageView, "cropImageView");
        return cropImageView;
    }

    @Override // com.cupidapp.live.setting.fragment.FKBaseCropImageFragment
    @NotNull
    public FKCropImageLayout V0() {
        FKCropImageLayout cropImageViewSquare = (FKCropImageLayout) a1(R$id.cropImageViewSquare);
        kotlin.jvm.internal.s.h(cropImageViewSquare, "cropImageViewSquare");
        return cropImageViewSquare;
    }

    @Nullable
    public View a1(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18101i;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_ai_crop_layout, viewGroup, false);
    }

    @Override // com.cupidapp.live.setting.fragment.FKBaseCropImageFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.setting.fragment.FKBaseCropImageFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        ((FKTitleBarLayout) a1(R$id.cropImageTitleLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.AiPhotoCropImageFragment$onViewCreated$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view2) {
                invoke2(view2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                AiPhotoCropImageFragment.this.S0();
            }
        });
        TextView saveButton = (TextView) a1(R$id.saveButton);
        kotlin.jvm.internal.s.h(saveButton, "saveButton");
        y.d(saveButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.AiPhotoCropImageFragment$onViewCreated$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view2) {
                invoke2(view2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                AiPhotoCropImageFragment.this.T0();
            }
        });
    }
}
