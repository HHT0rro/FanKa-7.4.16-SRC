package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.liveshow.model.FKHornType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKSendGiftCountSelectItemLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKSendGiftCountSelectItemLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15547b;

    /* compiled from: FKSendGiftCountSelectItemLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15548a;

        static {
            int[] iArr = new int[FKHornType.values().length];
            try {
                iArr[FKHornType.SmallHornType.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FKHornType.BigHornType.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f15548a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSendGiftCountSelectItemLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15547b = new LinkedHashMap();
        c();
    }

    private final void setSelectedBackground(boolean z10) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(z0.h.c(gradientDrawable, 8.0f));
        gradientDrawable.setColors(new int[]{com.cupidapp.live.base.utils.h.a(-37560, 0.2f), com.cupidapp.live.base.utils.h.a(-247959, 0.2f)});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable.setStroke(z0.h.c(gradientDrawable, 1.0f), -37560);
        RelativeLayout relativeLayout = (RelativeLayout) a(R$id.itemContainerLayout);
        if (!z10) {
            gradientDrawable = null;
        }
        relativeLayout.setBackground(gradientDrawable);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15547b;
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

    public final void b(@NotNull FKSendGiftCountItemModel countModel, boolean z10) {
        s.i(countModel, "countModel");
        ((TextView) a(R$id.sendGiftCountTextView)).setText(String.valueOf(countModel.getGiftCountModel().getCount()));
        ((TextView) a(R$id.sendGiftCountDescTextView)).setText(countModel.getGiftCountModel().getDescription());
        if (countModel.getHornType() == null) {
            ((TextView) a(R$id.hornTagImageView)).setVisibility(8);
        } else {
            int i10 = R$id.hornTagImageView;
            ((TextView) a(i10)).setVisibility(0);
            FKHornType hornType = countModel.getHornType();
            int i11 = hornType == null ? -1 : a.f15548a[hornType.ordinal()];
            if (i11 == 1) {
                ((TextView) a(i10)).setText(getContext().getString(R$string.live_show));
            } else if (i11 == 2) {
                ((TextView) a(i10)).setText(getContext().getString(R$string.full_site));
            }
        }
        setSelectedBackground(z10);
    }

    public final void c() {
        z.a(this, R$layout.layout_send_gift_count_select_item, true);
        ((TextView) a(R$id.sendGiftCountTextView)).getPaint().setFakeBoldText(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSendGiftCountSelectItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15547b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSendGiftCountSelectItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15547b = new LinkedHashMap();
        c();
    }
}
