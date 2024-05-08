package com.cupidapp.live.club.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.club.model.ActivityModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: ActivityListItemLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ActivityListItemLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13613b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityListItemLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13613b = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13613b;
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

    public final void b(@ColorInt int i10) {
        ((ConstraintLayout) a(R$id.activity_list_item_root_layout)).setBackgroundColor(i10);
    }

    public final void c(@NotNull ActivityModel model) {
        s.i(model, "model");
        int i10 = R$id.activity_name_textview;
        TextView activity_name_textview = (TextView) a(i10);
        s.h(activity_name_textview, "activity_name_textview");
        u.a(activity_name_textview);
        TextView naming_textview = (TextView) a(R$id.naming_textview);
        s.h(naming_textview, "naming_textview");
        u.a(naming_textview);
        ImageLoaderView activity_cover_imageview = (ImageLoaderView) a(R$id.activity_cover_imageview);
        s.h(activity_cover_imageview, "activity_cover_imageview");
        ImageLoaderView.g(activity_cover_imageview, model.getCoverImage(), null, null, 6, null);
        if (model.getActivityScore() != null && model.getActivityScore().floatValue() > 0.0f) {
            LinearLayout activity_score_layout = (LinearLayout) a(R$id.activity_score_layout);
            s.h(activity_score_layout, "activity_score_layout");
            activity_score_layout.setVisibility(0);
            ((TextView) a(R$id.activity_score_textview)).setText(String.valueOf(model.getActivityScore()));
        } else {
            LinearLayout activity_score_layout2 = (LinearLayout) a(R$id.activity_score_layout);
            s.h(activity_score_layout2, "activity_score_layout");
            activity_score_layout2.setVisibility(8);
        }
        if (model.getActTimeInfo() == null) {
            LinearLayout activity_time_layout = (LinearLayout) a(R$id.activity_time_layout);
            s.h(activity_time_layout, "activity_time_layout");
            activity_time_layout.setVisibility(8);
        } else {
            LinearLayout activity_time_layout2 = (LinearLayout) a(R$id.activity_time_layout);
            s.h(activity_time_layout2, "activity_time_layout");
            activity_time_layout2.setVisibility(0);
            ((TextView) a(R$id.activity_time_textview)).setText(model.getActTimeInfo());
        }
        if (model.getSummaryInfo() == null) {
            LinearLayout activity_location_layout = (LinearLayout) a(R$id.activity_location_layout);
            s.h(activity_location_layout, "activity_location_layout");
            activity_location_layout.setVisibility(8);
        } else {
            LinearLayout activity_location_layout2 = (LinearLayout) a(R$id.activity_location_layout);
            s.h(activity_location_layout2, "activity_location_layout");
            activity_location_layout2.setVisibility(0);
            ((TextView) a(R$id.activity_location_textview)).setText(model.getSummaryInfo());
        }
        ((TextView) a(i10)).setText(model.getActivityName());
        if (model.getSponsorAvatar() != null) {
            Layer naming_layer = (Layer) a(R$id.naming_layer);
            s.h(naming_layer, "naming_layer");
            naming_layer.setVisibility(0);
            ImageLoaderView naming_avatar_imageview = (ImageLoaderView) a(R$id.naming_avatar_imageview);
            s.h(naming_avatar_imageview, "naming_avatar_imageview");
            ImageLoaderView.g(naming_avatar_imageview, model.getSponsorAvatar(), null, null, 6, null);
            return;
        }
        Layer naming_layer2 = (Layer) a(R$id.naming_layer);
        s.h(naming_layer2, "naming_layer");
        naming_layer2.setVisibility(8);
    }

    public final void d() {
        z.a(this, R$layout.layout_activity_list_item, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityListItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13613b = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityListItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13613b = new LinkedHashMap();
        d();
    }
}
