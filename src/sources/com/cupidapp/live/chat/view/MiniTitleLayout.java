package com.cupidapp.live.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.chat2.model.MiniTitleModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: MiniTitleLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MiniTitleLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13234b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniTitleLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13234b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13234b;
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

    public final void b(@NotNull MiniTitleModel title, int i10) {
        s.i(title, "title");
        int i11 = R$id.miniTitleTextView;
        ((TextView) a(i11)).getLayoutParams().width = i10;
        ((TextView) a(i11)).setText(title.getMiniTitle());
        int i12 = R$id.miniTitleValueTextView;
        ((TextView) a(i12)).setText(title.getMiniText());
        String miniTextColor = title.getMiniTextColor();
        if (miniTextColor == null || miniTextColor.length() == 0) {
            ((TextView) a(i12)).setTextColor(-12566464);
        } else {
            ((TextView) a(i12)).setTextColor(h.b(title.getMiniTextColor()));
        }
    }

    public final void c() {
        z.a(this, R$layout.layout_rich_message_mini_title, true);
        ((TextView) a(R$id.miniTitleTextView)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.miniTitleValueTextView)).getPaint().setFakeBoldText(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13234b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13234b = new LinkedHashMap();
        c();
    }
}
