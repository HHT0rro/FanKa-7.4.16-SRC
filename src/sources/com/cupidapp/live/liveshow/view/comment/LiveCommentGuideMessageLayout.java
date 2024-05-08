package com.cupidapp.live.liveshow.view.comment;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.liveshow.adapter.LiveCommentMessageGuideModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: LiveCommentGuideMessageLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveCommentGuideMessageLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15393b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCommentGuideMessageLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15393b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15393b;
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

    public final void b(@NotNull LiveCommentMessageGuideModel model) {
        s.i(model, "model");
        List<Integer> bgColor = model.getBgColor();
        if (bgColor != null) {
            ConstraintLayout guide_container_layout = (ConstraintLayout) a(R$id.guide_container_layout);
            s.h(guide_container_layout, "guide_container_layout");
            y.i(guide_container_layout, (r18 & 1) != 0 ? 0.0f : h.c(this, 13.0f), bgColor, (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        }
        if (model.getIcon() == null) {
            ImageLoaderView guide_message_imageview = (ImageLoaderView) a(R$id.guide_message_imageview);
            s.h(guide_message_imageview, "guide_message_imageview");
            ImageLoaderView.g(guide_message_imageview, model.getIconImage(), null, null, 6, null);
        } else {
            ((ImageLoaderView) a(R$id.guide_message_imageview)).setImageResource(model.getIcon().intValue());
        }
        String message = model.getMessage();
        if (!(message == null || message.length() == 0)) {
            ((TextView) a(R$id.guide_message_textview)).setText(model.getMessage());
        }
        ImageView right_arrow_imageview = (ImageView) a(R$id.right_arrow_imageview);
        s.h(right_arrow_imageview, "right_arrow_imageview");
        right_arrow_imageview.setVisibility(model.getCanClick() ? 0 : 8);
    }

    public final void c() {
        z.a(this, R$layout.layout_live_comment_guide_message, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCommentGuideMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15393b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCommentGuideMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15393b = new LinkedHashMap();
        c();
    }
}
