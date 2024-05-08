package com.cupidapp.live.appdialog.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKFakeChangeAvatarSuccessLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFakeChangeAvatarSuccessLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f11666b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11667c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFakeChangeAvatarSuccessLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11667c = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f11667c;
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

    public final void c() {
        z.a(this, R$layout.layout_fake_change_avatar_success, true);
        ((TextView) a(R$id.changeNewAvatarTitle)).getPaint().setFakeBoldText(true);
        ImageView changeAvatarCloseImage = (ImageView) a(R$id.changeAvatarCloseImage);
        kotlin.jvm.internal.s.h(changeAvatarCloseImage, "changeAvatarCloseImage");
        y.d(changeAvatarCloseImage, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFakeChangeAvatarSuccessLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                AlertDialog alertDialog;
                alertDialog = FKFakeChangeAvatarSuccessLayout.this.f11666b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        FKUniversalButton knowButton = (FKUniversalButton) a(R$id.knowButton);
        kotlin.jvm.internal.s.h(knowButton, "knowButton");
        y.d(knowButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFakeChangeAvatarSuccessLayout$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                AlertDialog alertDialog;
                alertDialog = FKFakeChangeAvatarSuccessLayout.this.f11666b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    public final void d(@NotNull ImageModel avatar) {
        Window window;
        kotlin.jvm.internal.s.i(avatar, "avatar");
        ImageLoaderView newAvatarImage = (ImageLoaderView) a(R$id.newAvatarImage);
        kotlin.jvm.internal.s.h(newAvatarImage, "newAvatarImage");
        ImageLoaderView.g(newAvatarImage, avatar, null, null, 6, null);
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f11666b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog = this.f11666b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f11666b;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R$style.dialog_translate_anim);
        window.setLayout(-1, -2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFakeChangeAvatarSuccessLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11667c = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFakeChangeAvatarSuccessLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11667c = new LinkedHashMap();
        c();
    }
}
