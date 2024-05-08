package com.cupidapp.live.base.web.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$drawable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKWebProgressBar.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseHorizontalProgressBar extends ProgressBar {

    /* renamed from: b, reason: collision with root package name */
    public final int f13105b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13106c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseHorizontalProgressBar(@Nullable Context context) {
        super(context);
        this.f13106c = new LinkedHashMap();
        this.f13105b = 1000;
    }

    public final void a() {
        setProgressDrawable(ContextCompat.getDrawable(getContext(), R$drawable.app_progressbar_horizontal_gradient));
        setMax(this.f13105b);
        setProgress(0);
    }

    public BaseHorizontalProgressBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842872);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseHorizontalProgressBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f13106c = new LinkedHashMap();
        this.f13105b = 1000;
    }
}
