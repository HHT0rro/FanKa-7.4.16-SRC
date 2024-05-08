package com.cupidapp.live.liveshow.view.tag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.s;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: LiveShowRankTagListLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveShowRankTagListLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<LiveShowTagListModel> f15972b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15973c = new LinkedHashMap();

    public LiveShowRankTagListLayout(@Nullable Context context) {
        super(context);
        this.f15972b = new ArrayList();
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(@org.jetbrains.annotations.Nullable java.util.List<com.cupidapp.live.liveshow.view.tag.LiveShowTagListModel> r22) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.tag.LiveShowRankTagListLayout.a(java.util.List):void");
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = h.c(layoutParams, 8.0f);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    public final void c() {
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMarginStart(h.c(layoutParams, 10.0f));
        layoutParams.setMarginEnd(h.c(layoutParams, 10.0f));
        setLayoutParams(layoutParams);
        setVisibility(8);
    }

    public final void d(@Nullable List<LiveShowTagListModel> list) {
        int i10 = 0;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() != this.f15972b.size()) {
            removeAllViews();
            a(list);
            return;
        }
        this.f15972b.clear();
        this.f15972b.addAll(list);
        LinearLayout linearLayout = null;
        for (LiveShowTagListModel liveShowTagListModel : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                s.s();
            }
            LiveShowTagListModel liveShowTagListModel2 = liveShowTagListModel;
            int i12 = i10 % 3;
            if (i12 == 0) {
                View childAt = getChildAt(i10 / 3);
                linearLayout = childAt instanceof LinearLayout ? (LinearLayout) childAt : null;
            }
            View childAt2 = linearLayout != null ? linearLayout.getChildAt(i12) : null;
            if (childAt2 instanceof LiveShowOverallScrollingTagLayout) {
                ((LiveShowOverallScrollingTagLayout) childAt2).m(liveShowTagListModel2.getList(), TagScrollingType.OverallScrolling.getType());
            } else if (childAt2 instanceof LiveShowInternalScrollingTagLayout) {
                ((LiveShowInternalScrollingTagLayout) childAt2).r(liveShowTagListModel2.getList(), liveShowTagListModel2.getScrollType());
            }
            i10 = i11;
        }
    }

    public LiveShowRankTagListLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15972b = new ArrayList();
        c();
    }

    public LiveShowRankTagListLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f15972b = new ArrayList();
        c();
    }
}
