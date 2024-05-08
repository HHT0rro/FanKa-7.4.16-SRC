package com.cupidapp.live.mediapicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: MediaCheckedView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaCheckedView extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f17412b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17413c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaCheckedView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17413c = new LinkedHashMap();
        b();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17413c;
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

    public final void b() {
        z.a(this, R$layout.media_media_content, true);
    }

    public final void c() {
        this.f17412b = false;
        int i10 = R$id.checkboxNum;
        ((TextView) a(i10)).setText("");
        ((TextView) a(i10)).setVisibility(8);
        ((ImageView) a(R$id.checkboxImage)).setVisibility(0);
    }

    public final void setCheckBoxNum(int i10) {
        this.f17412b = true;
        int i11 = R$id.checkboxNum;
        ((TextView) a(i11)).setText(String.valueOf(i10 + 1));
        ((TextView) a(i11)).setVisibility(0);
        ((ImageView) a(R$id.checkboxImage)).setVisibility(8);
    }

    public final void setChecked(boolean z10) {
        this.f17412b = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaCheckedView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17413c = new LinkedHashMap();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaCheckedView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17413c = new LinkedHashMap();
        b();
    }
}
