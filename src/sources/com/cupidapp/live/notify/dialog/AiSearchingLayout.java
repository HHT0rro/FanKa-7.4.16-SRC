package com.cupidapp.live.notify.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: AiSearchingLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AiSearchingLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17498b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiSearchingLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17498b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17498b;
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

    public final void b(@NotNull String path) {
        s.i(path, "path");
        ImageLoaderView dialog_ai_identify_img = (ImageLoaderView) a(R$id.dialog_ai_identify_img);
        s.h(dialog_ai_identify_img, "dialog_ai_identify_img");
        ImageLoaderView.f(dialog_ai_identify_img, new b(false, path, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
    }

    public final void c() {
        z.a(this, R$layout.dialog_ai_searching, true);
        setBackgroundColor(ContextCompat.getColor(getContext(), R$color.text_gray));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiSearchingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17498b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiSearchingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17498b = new LinkedHashMap();
        c();
    }
}
