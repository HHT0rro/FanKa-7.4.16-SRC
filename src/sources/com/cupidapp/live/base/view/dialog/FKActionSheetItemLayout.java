package com.cupidapp.live.base.view.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKActionSheetItemLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKActionSheetItemLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12697b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKActionSheetItemLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12697b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12697b;
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

    public final void b(@NotNull FKActionSheetItemModel model, boolean z10) {
        Integer rightImgResId;
        Integer leftImgResId;
        s.i(model, "model");
        int i10 = R$id.action_sheet_item_text;
        ((TextView) a(i10)).setText(model.getTextResId());
        ((TextView) a(i10)).setTextColor(model.getItemType().getTextColor());
        if (model.getLeftImgResId() != null && ((leftImgResId = model.getLeftImgResId()) == null || leftImgResId.intValue() != 0)) {
            int i11 = R$id.action_sheet_item_left_img;
            ((ImageView) a(i11)).setVisibility(0);
            ((ImageView) a(i11)).setImageResource(model.getLeftImgResId().intValue());
        }
        if (model.getRightImgResId() != null && ((rightImgResId = model.getRightImgResId()) == null || rightImgResId.intValue() != 0)) {
            int i12 = R$id.action_sheet_item_right_img;
            ((ImageView) a(i12)).setVisibility(0);
            ((ImageView) a(i12)).setImageResource(model.getRightImgResId().intValue());
        }
        if (model.getSubTextResId() != null) {
            int i13 = R$id.action_sheet_item_sub_text;
            ((TextView) a(i13)).setText(model.getSubTextResId().intValue());
            ((TextView) a(i13)).setVisibility(0);
        } else {
            ((TextView) a(R$id.action_sheet_item_sub_text)).setVisibility(8);
        }
        a(R$id.action_sheet_item_spacing).setVisibility(z10 ? 0 : 8);
    }

    public final void c() {
        z.a(this, R$layout.layout_action_sheet_item, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKActionSheetItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12697b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKActionSheetItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12697b = new LinkedHashMap();
        c();
    }
}
