package com.cupidapp.live.liveshow.view.miniprofile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.TransformationType;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.network.model.ImageModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: FKLiveUserRankView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveUserRankView extends ImageLoaderView {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15767l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveUserRankView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15767l = new LinkedHashMap();
    }

    public final void h(@Nullable ImageModel imageModel) {
        if (imageModel == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        y.o(this, Integer.valueOf(imageModel.getScaleWidthByHeight(getLayoutParams().height)), null, 2, null);
        ImageLoaderView.g(this, imageModel, new b(false, null, null, null, null, null, null, 0, 0, null, TransformationType.FitCenter, null, null, false, 0, 0, false, null, null, 523263, null), null, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveUserRankView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15767l = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveUserRankView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15767l = new LinkedHashMap();
    }
}
