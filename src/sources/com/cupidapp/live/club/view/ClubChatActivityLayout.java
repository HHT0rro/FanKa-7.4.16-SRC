package com.cupidapp.live.club.view;

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
import com.cupidapp.live.club.model.ActivityStatus;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ClubChatActivityLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatActivityLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13614b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatActivityLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13614b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13614b;
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

    public final void b(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        ImageLoaderView club_activity_bg_img = (ImageLoaderView) a(R$id.club_activity_bg_img);
        s.h(club_activity_bg_img, "club_activity_bg_img");
        ImageLoaderView.g(club_activity_bg_img, model.getBgImage(), null, null, 6, null);
        String title = model.getTitle();
        if (title == null || title.length() == 0) {
            ((LinearLayout) a(R$id.club_activity_sponsor_layout)).setVisibility(8);
        } else {
            ((LinearLayout) a(R$id.club_activity_sponsor_layout)).setVisibility(0);
            ((TextView) a(R$id.club_activity_sponsor_text)).setText(model.getTitle());
        }
        TextView configActivityData$lambda$0 = (TextView) a(R$id.club_activity_status_text);
        ActivityStatus.a aVar = ActivityStatus.Companion;
        ActivityStatus a10 = aVar.a(model.getStatus());
        configActivityData$lambda$0.setText(a10 != null ? a10.getStatusName() : null);
        Integer status = model.getStatus();
        configActivityData$lambda$0.setTextColor((status != null && status.intValue() == ActivityStatus.InProgress.getStatus()) ? -8891597 : -1);
        s.h(configActivityData$lambda$0, "configActivityData$lambda$0");
        y.i(configActivityData$lambda$0, (r18 & 1) != 0 ? 0.0f : z0.h.c(configActivityData$lambda$0, 4.0f), r.e(Integer.valueOf(aVar.b(model.getStatus()))), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        ((TextView) a(R$id.club_activity_name_text)).setText(model.getDesc());
    }

    public final void c() {
        z.a(this, R$layout.layout_club_chat_activity, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatActivityLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13614b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatActivityLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13614b = new LinkedHashMap();
        c();
    }
}
