package com.cupidapp.live.liveshow.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.profile.model.FansClubMedalModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FanClubMedalView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FanClubMedalView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15288b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FanClubMedalView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15288b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15288b;
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

    public final void b(@NotNull FansClubMedalModel medal, @NotNull Drawable drawable) {
        ArrayList arrayList;
        List z02;
        s.i(medal, "medal");
        s.i(drawable, "drawable");
        ((ImageLoaderView) a(R$id.fan_club_medal_imageview)).setImageDrawable(drawable);
        ((TextView) a(R$id.fan_club_medal_level)).setText(String.valueOf(medal.getLevel()));
        ((TextView) a(R$id.fan_club_medal_name)).setText(medal.getBadgeName());
        String badgeBgColor = medal.getBadgeBgColor();
        if (badgeBgColor == null || (z02 = StringsKt__StringsKt.z0(badgeBgColor, new String[]{","}, false, 0, 6, null)) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(t.t(z02, 10));
            Iterator<E> iterator2 = z02.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(Integer.valueOf(com.cupidapp.live.base.utils.h.b((String) iterator2.next())));
            }
        }
        TextView fan_club_medal_name = (TextView) a(R$id.fan_club_medal_name);
        s.h(fan_club_medal_name, "fan_club_medal_name");
        y.j(fan_club_medal_name, 0.0f, z0.h.c(this, 6.0f), z0.h.c(this, 6.0f), z0.h.c(this, 6.0f), arrayList, null, null, null, 225, null);
    }

    public final void c() {
        z.a(this, R$layout.fan_club_medal_view, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FanClubMedalView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15288b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FanClubMedalView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15288b = new LinkedHashMap();
        c();
    }
}
