package com.cupidapp.live.profile.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.club.model.ClubMedalModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ClubMedalItemLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ClubMedalItemLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17846b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubMedalItemLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17846b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17846b;
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

    public final void b(@NotNull ClubMedalModel medal) {
        s.i(medal, "medal");
        ImageLoaderView medal_imageview = (ImageLoaderView) a(R$id.medal_imageview);
        s.h(medal_imageview, "medal_imageview");
        ImageLoaderView.g(medal_imageview, medal.getMedalIcon(), null, null, 6, null);
        ((TextView) a(R$id.medal_name_textview)).setText(medal.getMedalName());
    }

    public final void c() {
        z.a(this, R$layout.layout_club_medal_item, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubMedalItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17846b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubMedalItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17846b = new LinkedHashMap();
        c();
    }
}
