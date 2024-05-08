package com.cupidapp.live.liveshow.view.miniprofile;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.liveshow.model.MiniProfileUserTagModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FKLiveMiniProfileTagView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveMiniProfileTagView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15766b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniProfileTagView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15766b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15766b;
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

    public final void b(@NotNull MiniProfileUserTagModel tagModel, int i10) {
        s.i(tagModel, "tagModel");
        if (tagModel.getColor() == null && tagModel.getText() == null && tagModel.getIcon() != null) {
            int scaleWidthByHeight = tagModel.getIcon().getScaleWidthByHeight(i10);
            LinearLayout linearLayout = (LinearLayout) a(R$id.profileTagLayout);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(scaleWidthByHeight, i10);
            layoutParams.setMargins(h.c(layoutParams, 2.0f), 0, h.c(layoutParams, 2.0f), 0);
            linearLayout.setLayoutParams(layoutParams);
            int i11 = R$id.tagBackgroundImageView;
            ((ImageLoaderView) a(i11)).setVisibility(0);
            ImageLoaderView tagBackgroundImageView = (ImageLoaderView) a(i11);
            s.h(tagBackgroundImageView, "tagBackgroundImageView");
            ImageLoaderView.g(tagBackgroundImageView, tagModel.getIcon(), null, null, 6, null);
            ((ImageLoaderView) a(R$id.tagIconImageView)).setVisibility(8);
            ((TextView) a(R$id.tagTextView)).setVisibility(8);
            return;
        }
        ((ImageLoaderView) a(R$id.tagBackgroundImageView)).setVisibility(8);
        int i12 = R$id.profileTagLayout;
        LinearLayout linearLayout2 = (LinearLayout) a(i12);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, i10);
        layoutParams2.setMargins(h.c(layoutParams2, 2.0f), 0, h.c(layoutParams2, 2.0f), 0);
        linearLayout2.setLayoutParams(layoutParams2);
        if (tagModel.getIcon() != null) {
            int i13 = R$id.tagIconImageView;
            ((ImageLoaderView) a(i13)).setVisibility(0);
            ImageLoaderView tagIconImageView = (ImageLoaderView) a(i13);
            s.h(tagIconImageView, "tagIconImageView");
            ImageLoaderView.g(tagIconImageView, tagModel.getIcon(), null, null, 6, null);
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, i10);
            layoutParams3.setMargins(h.c(layoutParams3, 8.0f), 0, h.c(layoutParams3, 8.0f), 0);
            ((TextView) a(R$id.tagTextView)).setLayoutParams(layoutParams3);
        }
        if (tagModel.getColor() != null) {
            ((TextView) a(R$id.tagTextView)).setTextColor(com.cupidapp.live.base.utils.h.b(tagModel.getColor()));
        }
        if (tagModel.getText() != null) {
            ((TextView) a(R$id.tagTextView)).setText(tagModel.getText());
        }
        if (tagModel.getBackgroundColor() != null) {
            int b4 = com.cupidapp.live.base.utils.h.b(tagModel.getBackgroundColor());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(h.c(this, 5.0f));
            gradientDrawable.setColor(b4);
            ((LinearLayout) a(i12)).setBackground(gradientDrawable);
        }
    }

    public final void c() {
        z.a(this, R$layout.layout_mini_profile_tag, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniProfileTagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15766b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniProfileTagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15766b = new LinkedHashMap();
        c();
    }
}
