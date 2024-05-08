package com.cupidapp.live.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: TodayLuckyScoreLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TodayLuckyScoreLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18232b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TodayLuckyScoreLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18232b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18232b;
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

    /* JADX WARN: Code restructure failed: missing block: B:6:0x004d, code lost:
    
        if ((r0.length() > 0) == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(@org.jetbrains.annotations.NotNull final com.cupidapp.live.base.network.model.TodayLuckyScoreModel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "model"
            kotlin.jvm.internal.s.i(r8, r0)
            int r0 = com.cupidapp.live.R$id.lucky_score_img
            android.view.View r0 = r7.a(r0)
            r1 = r0
            com.cupidapp.live.base.imageloader.ImageLoaderView r1 = (com.cupidapp.live.base.imageloader.ImageLoaderView) r1
            java.lang.String r0 = "lucky_score_img"
            kotlin.jvm.internal.s.h(r1, r0)
            com.cupidapp.live.base.network.model.ImageModel r2 = r8.getIcon()
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            com.cupidapp.live.base.imageloader.ImageLoaderView.g(r1, r2, r3, r4, r5, r6)
            int r0 = com.cupidapp.live.R$id.lucky_score_txt
            android.view.View r0 = r7.a(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r8.getTitle()
            r0.setText(r1)
            int r0 = com.cupidapp.live.R$id.lucky_score_des
            android.view.View r0 = r7.a(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r8.getDescription()
            r0.setText(r1)
            java.lang.String r0 = r8.getUrl()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L50
            int r0 = r0.length()
            if (r0 <= 0) goto L4c
            r0 = 1
            goto L4d
        L4c:
            r0 = 0
        L4d:
            if (r0 != r1) goto L50
            goto L51
        L50:
            r1 = 0
        L51:
            if (r1 == 0) goto L5b
            com.cupidapp.live.setting.view.TodayLuckyScoreLayout$configData$1 r0 = new com.cupidapp.live.setting.view.TodayLuckyScoreLayout$configData$1
            r0.<init>()
            z0.y.d(r7, r0)
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.setting.view.TodayLuckyScoreLayout.b(com.cupidapp.live.base.network.model.TodayLuckyScoreModel):void");
    }

    public final void c() {
        z.a(this, R$layout.layout_lucky_score, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TodayLuckyScoreLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18232b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TodayLuckyScoreLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18232b = new LinkedHashMap();
        c();
    }
}
