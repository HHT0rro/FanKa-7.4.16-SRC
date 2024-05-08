package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.ranges.IntRange;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKCustomGiftSendCountLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKCustomGiftSendCountLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public d f15503b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15504c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKCustomGiftSendCountLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15504c = new LinkedHashMap();
        f();
    }

    public static final void h(final FKCustomGiftSendCountLayout this$0, final d this_apply, final Function0 showSuccess, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        s.i(this_apply, "$this_apply");
        s.i(showSuccess, "$showSuccess");
        this$0.postDelayed(new Runnable() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.f
            @Override // java.lang.Runnable
            public final void run() {
                FKCustomGiftSendCountLayout.i(d.this, this$0, showSuccess);
            }
        }, 50L);
    }

    public static final void i(d this_apply, FKCustomGiftSendCountLayout this$0, Function0 showSuccess) {
        s.i(this_apply, "$this_apply");
        s.i(this$0, "this$0");
        s.i(showSuccess, "$showSuccess");
        Context context = this_apply.getContext();
        s.h(context, "context");
        EditText customGiftCountEditText = (EditText) this$0.c(R$id.customGiftCountEditText);
        s.h(customGiftCountEditText, "customGiftCountEditText");
        z0.h.v(context, customGiftCountEditText);
        showSuccess.invoke();
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f15504c;
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

    public final void e() {
        d dVar = this.f15503b;
        if (dVar != null) {
            dVar.dismiss();
        }
    }

    public final void f() {
        z.a(this, R$layout.layout_custom_gift_send_count, true);
    }

    public final void g(@NotNull final Function0<p> showSuccess, @NotNull final Function1<? super Integer, p> determineCallback) {
        Window window;
        s.i(showSuccess, "showSuccess");
        s.i(determineCallback, "determineCallback");
        Context context = getContext();
        s.h(context, "context");
        final d dVar = new d(context);
        dVar.setContentView(this);
        dVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.e
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                FKCustomGiftSendCountLayout.h(FKCustomGiftSendCountLayout.this, dVar, showSuccess, dialogInterface);
            }
        });
        this.f15503b = dVar;
        dVar.show();
        d dVar2 = this.f15503b;
        if (dVar2 != null && (window = dVar2.getWindow()) != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setDimAmount(0.0f);
        }
        FKUniversalButton determineButton = (FKUniversalButton) c(R$id.determineButton);
        s.h(determineButton, "determineButton");
        y.d(determineButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKCustomGiftSendCountLayout$showCustomGiftCountDialog$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                d dVar3;
                Integer j10 = o.j(((EditText) FKCustomGiftSendCountLayout.this.c(R$id.customGiftCountEditText)).getText().toString());
                if (j10 == null || !new IntRange(1, 9999).i(j10.intValue())) {
                    return;
                }
                dVar3 = FKCustomGiftSendCountLayout.this.f15503b;
                if (dVar3 != null) {
                    dVar3.dismiss();
                }
                determineCallback.invoke(j10);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKCustomGiftSendCountLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15504c = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKCustomGiftSendCountLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15504c = new LinkedHashMap();
        f();
    }
}
