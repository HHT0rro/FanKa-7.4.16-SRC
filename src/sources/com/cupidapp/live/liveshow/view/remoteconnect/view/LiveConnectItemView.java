package com.cupidapp.live.liveshow.view.remoteconnect.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: LiveConnectItemView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveConnectItemView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15871b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConnectItemView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15871b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15871b;
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

    public final void b(int i10, @NotNull String connectText, @Nullable String str, boolean z10) {
        s.i(connectText, "connectText");
        ((ImageView) a(R$id.connect_item_imageview)).setImageResource(i10);
        if (str == null || str.length() == 0) {
            setEnabled(true);
            d(z10);
            ((TextView) a(R$id.connect_item_textview)).setText(connectText);
            return;
        }
        setEnabled(false);
        View foreground_view = a(R$id.foreground_view);
        s.h(foreground_view, "foreground_view");
        foreground_view.setVisibility(0);
        int i11 = R$id.connect_item_textview;
        ((TextView) a(i11)).setTextColor(-6710887);
        ((TextView) a(i11)).setText(str);
        int i12 = R$id.select_item_imageview;
        ImageView select_item_imageview = (ImageView) a(i12);
        s.h(select_item_imageview, "select_item_imageview");
        select_item_imageview.setVisibility(0);
        ((ImageView) a(i12)).setImageResource(R$mipmap.icon_connect_lock);
    }

    public final void c() {
        z.a(this, R$layout.live_connect_item_view, true);
    }

    public final void d(boolean z10) {
        if (isEnabled()) {
            if (isSelected() && z10) {
                return;
            }
            setSelected(z10);
            View foreground_view = a(R$id.foreground_view);
            s.h(foreground_view, "foreground_view");
            foreground_view.setVisibility(8);
            ConstraintLayout connect_container_layout = (ConstraintLayout) a(R$id.connect_container_layout);
            s.h(connect_container_layout, "connect_container_layout");
            y.i(connect_container_layout, (r18 & 1) != 0 ? 0.0f : h.c(this, 16.0f), r.e(Integer.valueOf(z10 ? com.cupidapp.live.base.utils.h.a(-49088, 0.05f) : 0)), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            ((TextView) a(R$id.connect_item_textview)).setTextColor(z10 ? -49088 : -15066598);
            if (z10) {
                int i10 = R$id.select_item_imageview;
                ImageView select_item_imageview = (ImageView) a(i10);
                s.h(select_item_imageview, "select_item_imageview");
                select_item_imageview.setVisibility(0);
                ((ImageView) a(i10)).setImageResource(R$drawable.icon_agree_checkbox_red_bg_white_tick);
                return;
            }
            ImageView select_item_imageview2 = (ImageView) a(R$id.select_item_imageview);
            s.h(select_item_imageview2, "select_item_imageview");
            select_item_imageview2.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConnectItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15871b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConnectItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15871b = new LinkedHashMap();
        c();
    }
}
