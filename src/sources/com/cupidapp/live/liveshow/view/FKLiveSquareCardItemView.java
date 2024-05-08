package com.cupidapp.live.liveshow.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveSquareCardItemView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveSquareCardItemView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15264b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSquareCardItemView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15264b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15264b;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b(@NotNull LiveShowModel squareItem) {
        s.i(squareItem, "squareItem");
        ImageLoaderView squareCardImageView = (ImageLoaderView) a(R$id.squareCardImageView);
        s.h(squareCardImageView, "squareCardImageView");
        ImageLoaderView.g(squareCardImageView, squareItem.getCoverImage(), null, null, 6, null);
        ((TextView) a(R$id.squareCardUserNameView)).setText(squareItem.getUser().getName());
        ((TextView) a(R$id.squareCardViewerCountView)).setText(squareItem.getFormatHeatValue());
        ((TextView) a(R$id.squareCardTitleView)).setText(squareItem.getTitle());
        ((LiveShowCoverTagView) a(R$id.square_card_cover_tag_view)).b(squareItem.getCoverTag(), z0.h.c(this, 18.0f));
    }

    public final void c() {
        z.a(this, R$layout.layout_live_square_card_view, true);
        Drawable background = a(R$id.squareCardShadowView).getBackground();
        GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
        float c4 = z0.h.c(this, 2.0f);
        if (gradientDrawable == null) {
            return;
        }
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, c4, c4, c4, c4});
    }

    public final void setSquareCardViewSize(int i10) {
        ImageLoaderView squareCardImageView = (ImageLoaderView) a(R$id.squareCardImageView);
        s.h(squareCardImageView, "squareCardImageView");
        y.n(squareCardImageView, Integer.valueOf(i10), Integer.valueOf(i10));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSquareCardItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15264b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSquareCardItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15264b = new LinkedHashMap();
        c();
    }
}
