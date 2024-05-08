package com.cupidapp.live.base.view.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKWithImageButton.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKWithImageButton extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12655b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKWithImageButton(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12655b = new LinkedHashMap();
        c(this, context, null, 2, null);
    }

    public static /* synthetic */ void c(FKWithImageButton fKWithImageButton, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        fKWithImageButton.b(context, attributeSet);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12655b;
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

    public final void b(Context context, AttributeSet attributeSet) {
        z.a(this, R$layout.layout_with_image_button, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FKWithImageButton);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…leable.FKWithImageButton)");
        int dimension = (int) obtainStyledAttributes.getDimension(4, 0.0f);
        if (dimension > 0) {
            int i10 = R$id.btn_with_left_image;
            ((ImageView) a(i10)).setVisibility(0);
            ImageView btn_with_left_image = (ImageView) a(i10);
            s.h(btn_with_left_image, "btn_with_left_image");
            y.n(btn_with_left_image, Integer.valueOf(dimension), Integer.valueOf(dimension));
        }
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            int i11 = R$id.btn_with_left_image;
            ((ImageView) a(i11)).setVisibility(0);
            ((ImageView) a(i11)).setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId2 != 0) {
            ((TextView) a(R$id.btn_with_center_text)).setText(context.getString(resourceId2));
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        if (dimensionPixelSize > 0) {
            ((TextView) a(R$id.btn_with_center_text)).setTextSize(0, dimensionPixelSize);
        }
        ((TextView) a(R$id.btn_with_center_text)).setTextColor(obtainStyledAttributes.getColor(0, -15066598));
        int dimension2 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
        if (dimension2 > 0) {
            int i12 = R$id.btn_with_right_image;
            ((ImageView) a(i12)).setVisibility(0);
            ImageView btn_with_right_image = (ImageView) a(i12);
            s.h(btn_with_right_image, "btn_with_right_image");
            y.n(btn_with_right_image, Integer.valueOf(dimension2), Integer.valueOf(dimension2));
        }
        int resourceId3 = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId3 != 0) {
            int i13 = R$id.btn_with_right_image;
            ((ImageView) a(i13)).setVisibility(0);
            ((ImageView) a(i13)).setImageResource(resourceId3);
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKWithImageButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12655b = new LinkedHashMap();
        b(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKWithImageButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12655b = new LinkedHashMap();
        b(context, attributeSet);
    }
}
