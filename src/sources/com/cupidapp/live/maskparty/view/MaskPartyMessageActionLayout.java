package com.cupidapp.live.maskparty.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.utils.PopupWindowLocationModel;
import com.cupidapp.live.maskparty.model.MaskPartyLongClickActionType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyMessageActionLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyMessageActionLayout extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f16426e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public static MaskPartyMessageActionLayout f16427f;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f16428b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function1<? super MaskPartyLongClickActionType, p> f16429c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16430d;

    /* compiled from: MaskPartyMessageActionLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull List<? extends MaskPartyLongClickActionType> actions, @NotNull PopupWindowLocationModel popupLocation, @NotNull Function1<? super MaskPartyLongClickActionType, p> itemClick) {
            s.i(actions, "actions");
            s.i(popupLocation, "popupLocation");
            s.i(itemClick, "itemClick");
            if (context == null) {
                return;
            }
            MaskPartyMessageActionLayout maskPartyMessageActionLayout = new MaskPartyMessageActionLayout(context);
            maskPartyMessageActionLayout.h(actions, popupLocation, itemClick);
            MaskPartyMessageActionLayout.f16427f = maskPartyMessageActionLayout;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMessageActionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16430d = new LinkedHashMap();
        g();
    }

    public final void e(List<? extends MaskPartyLongClickActionType> list) {
        removeAllViews();
        int i10 = 0;
        for (MaskPartyLongClickActionType maskPartyLongClickActionType : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            final MaskPartyLongClickActionType maskPartyLongClickActionType2 = maskPartyLongClickActionType;
            View b4 = z.b(this, R$layout.mask_party_message_action_item_view, false, 2, null);
            ((TextView) b4.findViewById(R$id.action_view)).setText(b4.getContext().getString(maskPartyLongClickActionType2.getResId()));
            b4.findViewById(R$id.line_view).setVisibility(i10 == list.size() + (-1) ? 8 : 0);
            y.d(b4, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyMessageActionLayout$configActionLayout$1$1
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
                    Function1 function1;
                    MaskPartyMessageActionLayout.this.f();
                    function1 = MaskPartyMessageActionLayout.this.f16429c;
                    if (function1 != null) {
                        function1.invoke(maskPartyLongClickActionType2);
                    }
                }
            });
            addView(b4);
            i10 = i11;
        }
    }

    public final void f() {
        AlertDialog alertDialog = this.f16428b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void g() {
        setBackgroundResource(R$drawable.shape_black_151515_bg_12_corners);
        setOrientation(1);
        setPadding(0, z0.h.c(this, 1.0f), 0, z0.h.c(this, 1.0f));
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    public final void h(List<? extends MaskPartyLongClickActionType> list, PopupWindowLocationModel popupWindowLocationModel, Function1<? super MaskPartyLongClickActionType, p> function1) {
        int intValue;
        int intValue2;
        Window window;
        this.f16429c = function1;
        e(list);
        measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(z0.h.k(this), Integer.MIN_VALUE));
        int width = popupWindowLocationModel.getParent().getWidth() - getMeasuredWidth();
        if (width > 0) {
            intValue = popupWindowLocationModel.getLocation().getFirst().intValue() + (width / 2);
        } else {
            intValue = popupWindowLocationModel.getLocation().getFirst().intValue();
        }
        if (popupWindowLocationModel.getLocation().getSecond().intValue() > z0.h.k(this) / 4) {
            intValue2 = popupWindowLocationModel.getLocation().getSecond().intValue() - (getMeasuredHeight() + z0.h.c(this, 8.0f));
        } else {
            intValue2 = popupWindowLocationModel.getLocation().getSecond().intValue() + popupWindowLocationModel.getParent().getHeight() + z0.h.c(this, 8.0f);
        }
        int m10 = intValue2 - z0.h.m(getContext());
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f16428b = create;
        if (create != null) {
            create.show();
        }
        AlertDialog alertDialog = this.f16428b;
        if (alertDialog == null || (window = alertDialog.getWindow()) == null) {
            return;
        }
        window.getAttributes().f816x = intValue;
        window.getAttributes().f817y = m10;
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(z0.h.c(window, 86.0f), -2);
        window.setGravity(popupWindowLocationModel.getGravity());
        window.setDimAmount(0.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMessageActionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16430d = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMessageActionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16430d = new LinkedHashMap();
        g();
    }
}
