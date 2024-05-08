package com.cupidapp.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.feed.model.PromotionNearByGuideModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: PromotionNearGuideLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PromotionNearGuideLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12550b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionNearGuideLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12550b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12550b;
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

    public final void b(@NotNull final PromotionNearByGuideModel model, @NotNull final SensorPosition sensorPosition) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(sensorPosition, "sensorPosition");
        int i10 = R$id.item_near_guide_title;
        TextView item_near_guide_title = (TextView) a(i10);
        kotlin.jvm.internal.s.h(item_near_guide_title, "item_near_guide_title");
        u.a(item_near_guide_title);
        int i11 = R$id.item_near_guide_swipe_btn;
        TextView item_near_guide_swipe_btn = (TextView) a(i11);
        kotlin.jvm.internal.s.h(item_near_guide_swipe_btn, "item_near_guide_swipe_btn");
        u.a(item_near_guide_swipe_btn);
        int i12 = R$id.item_near_guide_near_btn;
        TextView item_near_guide_near_btn = (TextView) a(i12);
        kotlin.jvm.internal.s.h(item_near_guide_near_btn, "item_near_guide_near_btn");
        u.a(item_near_guide_near_btn);
        ((TextView) a(i10)).setText(model.getTitle());
        ((TextView) a(R$id.item_near_guide_des)).setText(model.getSubTitle());
        ((TextView) a(i11)).setText(model.getMatchTitle());
        ((TextView) a(i12)).setText(model.getNearbyTitle());
        ImageLoaderView item_near_guide_img = (ImageLoaderView) a(R$id.item_near_guide_img);
        kotlin.jvm.internal.s.h(item_near_guide_img, "item_near_guide_img");
        ImageLoaderView.g(item_near_guide_img, model.getIcon(), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524159, null), null, 4, null);
        TextView textView = (TextView) a(R$id.promotion_user_des);
        String desc = model.getDesc();
        textView.setText(desc != null ? t.a(desc, -15066598) : null);
        ((PromotionUserAvatarsLayout) a(R$id.promotion_user_avatar_layout)).b(model.getAvatars(), z0.h.c(this, 25.0f));
        TextView item_near_guide_near_btn2 = (TextView) a(i12);
        kotlin.jvm.internal.s.h(item_near_guide_near_btn2, "item_near_guide_near_btn");
        y.d(item_near_guide_near_btn2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.base.view.PromotionNearGuideLayout$configData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                GroupOthersLog.I(GroupOthersLog.f18702a, PromotionNearByGuideModel.this.getTrackName(), sensorPosition, PromotionNearByGuideModel.this.getNearbyTitle(), null, 8, null);
                j.a.b(com.cupidapp.live.base.router.j.f12156c, this.getContext(), PromotionNearByGuideModel.this.getNearbyUrl(), null, 4, null);
            }
        });
        TextView item_near_guide_swipe_btn2 = (TextView) a(i11);
        kotlin.jvm.internal.s.h(item_near_guide_swipe_btn2, "item_near_guide_swipe_btn");
        y.d(item_near_guide_swipe_btn2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.base.view.PromotionNearGuideLayout$configData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                GroupOthersLog.I(GroupOthersLog.f18702a, PromotionNearByGuideModel.this.getTrackName(), sensorPosition, PromotionNearByGuideModel.this.getMatchTitle(), null, 8, null);
                j.a.b(com.cupidapp.live.base.router.j.f12156c, this.getContext(), PromotionNearByGuideModel.this.getMatchUrl(), null, 4, null);
            }
        });
    }

    public final void c() {
        z.a(this, R$layout.view_promotion_guide, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionNearGuideLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12550b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionNearGuideLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12550b = new LinkedHashMap();
        c();
    }
}
