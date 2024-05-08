package com.cupidapp.live.liveshow.view.tag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.cupidapp.live.liveshow.model.CardInfoModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: UserLiveShowRanksLinearLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserLiveShowRanksLinearLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16002b = new LinkedHashMap();

    public UserLiveShowRanksLinearLayout(@Nullable Context context) {
        super(context);
        b();
    }

    public final void a(@Nullable List<CardInfoModel> list, @Nullable String str) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        removeAllViews();
        int l10 = (h.l(this) - h.c(this, 56.0f)) / 3;
        if (list != null) {
            for (CardInfoModel cardInfoModel : list) {
                UserLiveShowRankLayout userLiveShowRankLayout = new UserLiveShowRankLayout(context);
                userLiveShowRankLayout.h(cardInfoModel, str, l10);
                addView(userLiveShowRankLayout, new LinearLayout.LayoutParams(l10, -2));
            }
        }
    }

    public final void b() {
        setOrientation(0);
    }

    public UserLiveShowRanksLinearLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public UserLiveShowRanksLinearLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b();
    }
}
