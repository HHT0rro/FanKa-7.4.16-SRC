package com.cupidapp.live.liveshow.view.giftcollection;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.b;
import z0.y;
import z0.z;

/* compiled from: ActivityDescriptionLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ActivityDescriptionLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f15414b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15415c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityDescriptionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15415c = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15415c;
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
        z.a(this, R$layout.layout_activity_description, true);
        ((TextView) a(R$id.description_title)).getPaint().setFakeBoldText(true);
        int i10 = R$id.i_know_button;
        ((TextView) a(i10)).getPaint().setFakeBoldText(true);
        TextView i_know_button = (TextView) a(i10);
        s.h(i_know_button, "i_know_button");
        y.d(i_know_button, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftcollection.ActivityDescriptionLayout$initView$1
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
                AlertDialog alertDialog;
                alertDialog = ActivityDescriptionLayout.this.f15414b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    public final void d(@NotNull String description) {
        Window window;
        s.i(description, "description");
        ((TextView) a(R$id.description_content)).setText(description);
        AlertDialog create = b.f54812a.e(getContext()).setView(this).create();
        this.f15414b = create;
        if (create != null) {
            create.show();
        }
        AlertDialog alertDialog = this.f15414b;
        if (alertDialog == null || (window = alertDialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-2, -2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityDescriptionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15415c = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityDescriptionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15415c = new LinkedHashMap();
        c();
    }
}
