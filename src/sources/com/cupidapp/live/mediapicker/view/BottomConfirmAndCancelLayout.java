package com.cupidapp.live.mediapicker.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.i;
import z0.y;
import z0.z;

/* compiled from: BottomConfirmAndCancelLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class BottomConfirmAndCancelLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17385b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomConfirmAndCancelLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17385b = new LinkedHashMap();
        c(this, context, null, 2, null);
    }

    public static /* synthetic */ void c(BottomConfirmAndCancelLayout bottomConfirmAndCancelLayout, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        bottomConfirmAndCancelLayout.b(context, attributeSet);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17385b;
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

    public final void b(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        s.i(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomConfirmAndCancelLayout);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…omConfirmAndCancelLayout)");
        int integer = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        z.a(this, R$layout.layout_bottom_confirm_and_cancel, true);
        if (integer == 1) {
            d();
        }
    }

    public final void d() {
        i.a aVar = z0.i.f54815a;
        Drawable b4 = aVar.b(ContextCompat.getDrawable(getContext(), R$mipmap.icon_close_white_bg), -15066598);
        if (b4 != null) {
            ((ImageView) a(R$id.cancelImageButton)).setImageDrawable(b4);
        }
        Drawable b10 = aVar.b(ContextCompat.getDrawable(getContext(), R$mipmap.icon_video_rotate), -15066598);
        if (b10 != null) {
            ((ImageView) a(R$id.centerImageButton)).setImageDrawable(b10);
        }
        Drawable b11 = aVar.b(ContextCompat.getDrawable(getContext(), R$mipmap.icon_confirm), -15066598);
        if (b11 != null) {
            ((ImageView) a(R$id.confirmImageButton)).setImageDrawable(b11);
        }
    }

    public final void setCancelButtonClickEvent(@NotNull final Function0<p> listener) {
        s.i(listener, "listener");
        ImageView cancelImageButton = (ImageView) a(R$id.cancelImageButton);
        s.h(cancelImageButton, "cancelImageButton");
        y.d(cancelImageButton, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.view.BottomConfirmAndCancelLayout$setCancelButtonClickEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                listener.invoke();
            }
        });
    }

    public final void setCenterButtonClickEvent(@NotNull final Function0<p> listener) {
        s.i(listener, "listener");
        ImageView centerImageButton = (ImageView) a(R$id.centerImageButton);
        s.h(centerImageButton, "centerImageButton");
        y.d(centerImageButton, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.view.BottomConfirmAndCancelLayout$setCenterButtonClickEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                listener.invoke();
            }
        });
    }

    public final void setConfirmButtonClickEvent(@NotNull final Function0<p> listener) {
        s.i(listener, "listener");
        ImageView confirmImageButton = (ImageView) a(R$id.confirmImageButton);
        s.h(confirmImageButton, "confirmImageButton");
        y.d(confirmImageButton, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.view.BottomConfirmAndCancelLayout$setConfirmButtonClickEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                listener.invoke();
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomConfirmAndCancelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17385b = new LinkedHashMap();
        b(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomConfirmAndCancelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17385b = new LinkedHashMap();
        b(context, attributeSet);
    }
}
