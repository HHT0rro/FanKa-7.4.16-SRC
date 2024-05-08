package com.cupidapp.live.club.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.club.model.ClubNoticeModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: ClubNoticeLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubNoticeLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13646b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubNoticeLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13646b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13646b;
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

    public final void b(@NotNull ClubNoticeModel notice) {
        s.i(notice, "notice");
        ImageLoaderView publisher_avatar_imageview = (ImageLoaderView) a(R$id.publisher_avatar_imageview);
        s.h(publisher_avatar_imageview, "publisher_avatar_imageview");
        ImageLoaderView.g(publisher_avatar_imageview, notice.getAvatar(), null, null, 6, null);
        ((TextView) a(R$id.publisher_name_textview)).setText(notice.getNickname());
        ((TextView) a(R$id.publish_time_textview)).setText(notice.getPublishTime());
        ((TextView) a(R$id.club_notice_textview)).setText(notice.getMsg());
    }

    public final void c() {
        z.a(this, R$layout.layout_club_notice, true);
        TextView publisher_name_textview = (TextView) a(R$id.publisher_name_textview);
        s.h(publisher_name_textview, "publisher_name_textview");
        u.a(publisher_name_textview);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubNoticeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13646b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubNoticeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13646b = new LinkedHashMap();
        c();
    }
}
