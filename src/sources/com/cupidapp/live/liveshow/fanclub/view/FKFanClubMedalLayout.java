package com.cupidapp.live.liveshow.fanclub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKFanClubMedalLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubMedalLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14987b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFanClubMedalLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f14987b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f14987b;
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

    public final void b(@NotNull FKFanClubMedalModel medal) {
        ArrayList arrayList;
        List z02;
        s.i(medal, "medal");
        ImageLoaderView fanClubMedalImageView = (ImageLoaderView) a(R$id.fanClubMedalImageView);
        s.h(fanClubMedalImageView, "fanClubMedalImageView");
        ImageLoaderView.g(fanClubMedalImageView, medal.getMedalImage(), null, null, 6, null);
        ((TextView) a(R$id.fanClubMedalLevelTextView)).setText(String.valueOf(medal.getMedalLevel()));
        ((TextView) a(R$id.fanClubMedalNameTextView)).setText(medal.getMedalName());
        String medalBgColor = medal.getMedalBgColor();
        if (medalBgColor == null || (z02 = StringsKt__StringsKt.z0(medalBgColor, new String[]{","}, false, 0, 6, null)) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(t.t(z02, 10));
            Iterator<E> iterator2 = z02.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(Integer.valueOf(h.b((String) iterator2.next())));
            }
        }
        TextView fanClubMedalNameTextView = (TextView) a(R$id.fanClubMedalNameTextView);
        s.h(fanClubMedalNameTextView, "fanClubMedalNameTextView");
        y.j(fanClubMedalNameTextView, 0.0f, z0.h.c(this, 12.0f), z0.h.c(this, 12.0f), z0.h.c(this, 12.0f), arrayList, null, Integer.valueOf(z0.h.c(this, 1.0f)), -1, 33, null);
    }

    public final void c() {
        z.a(this, R$layout.layout_fan_club_medal, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFanClubMedalLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f14987b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFanClubMedalLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f14987b = new LinkedHashMap();
        c();
    }
}
