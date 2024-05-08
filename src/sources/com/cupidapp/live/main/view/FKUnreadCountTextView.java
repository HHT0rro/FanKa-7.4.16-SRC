package com.cupidapp.live.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$string;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: FKUnreadCountTextView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKUnreadCountTextView extends AppCompatTextView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16201b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKUnreadCountTextView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16201b = new LinkedHashMap();
        a();
    }

    public final void a() {
        int c4 = h.c(this, 16.0f);
        getPaint().setFakeBoldText(true);
        setGravity(17);
        setTextColor(-1);
        setTextSize(11.0f);
        setBackground(ContextCompat.getDrawable(getContext(), R$drawable.shape_red_bg_ten_corners));
        setMinHeight(c4);
        setMinWidth(c4);
        int measureText = (int) ((c4 - getPaint().measureText("0")) / 2);
        setPadding(measureText, 0, measureText, 0);
    }

    public final void setUnreadCount(int i10) {
        if (i10 > 99) {
            setText(getContext().getString(R$string.max_count));
            setVisibility(0);
        } else if (i10 > 0) {
            setText(String.valueOf(i10));
            setVisibility(0);
        } else {
            setText((CharSequence) null);
            setVisibility(4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKUnreadCountTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16201b = new LinkedHashMap();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKUnreadCountTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16201b = new LinkedHashMap();
        a();
    }
}
