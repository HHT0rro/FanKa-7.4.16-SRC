package com.cupidapp.live.mediapicker.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ImageDragDeleteButton.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageDragDeleteButton extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17401c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17402b;

    /* compiled from: ImageDragDeleteButton.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageDragDeleteButton(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17402b = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17402b;
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

    public final void b(float f10) {
        ImageView imageView = (ImageView) a(R$id.deleteImageView);
        float f11 = (f10 + 1.0f) * 0.65f;
        float f12 = f11 >= 1.0f ? f11 > 1.3f ? 1.3f : f11 : 1.0f;
        imageView.setPivotX(imageView.getWidth() / 2.0f);
        imageView.setPivotY(imageView.getHeight() / 2.0f);
        imageView.setScaleX(f12);
        imageView.setScaleY(f12);
    }

    public final void c(boolean z10) {
        TextView textView = (TextView) a(R$id.dragHereDeleteTextView);
        if (z10) {
            textView.setText(getContext().getString(R$string.release_to_delete));
            textView.setTextColor(-15066598);
        } else {
            textView.setText(getContext().getString(R$string.drag_here_to_delete));
            textView.setTextColor(-3750202);
        }
        if (z10) {
            Drawable b4 = z0.i.f54815a.b(ContextCompat.getDrawable(getContext(), R$mipmap.icon_delete_image), -1);
            if (b4 != null) {
                ((ImageView) a(R$id.deleteImageView)).setImageDrawable(b4);
            }
            ((RoundedFrameLayout) a(R$id.deleteImageBackgroundView)).setBackgroundResource(R$drawable.shape_circle_red_bg);
            return;
        }
        Drawable b10 = z0.i.f54815a.b(ContextCompat.getDrawable(getContext(), R$mipmap.icon_delete_image), -15066598);
        if (b10 != null) {
            ((ImageView) a(R$id.deleteImageView)).setImageDrawable(b10);
        }
        ((RoundedFrameLayout) a(R$id.deleteImageBackgroundView)).setBackgroundResource(R$drawable.shape_white_bg_gray_stroke_thirty_six_corners);
    }

    public final void d() {
        z.a(this, R$layout.layout_image_drag_delete_button, true);
        int i10 = R$id.deleteImageBackgroundView;
        ((RoundedFrameLayout) a(i10)).setCornerRadius(z0.h.c(this, 36.0f));
        ((RoundedFrameLayout) a(i10)).setBackgroundResource(R$drawable.shape_white_bg_gray_stroke_thirty_six_corners);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageDragDeleteButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17402b = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageDragDeleteButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17402b = new LinkedHashMap();
        d();
    }
}
