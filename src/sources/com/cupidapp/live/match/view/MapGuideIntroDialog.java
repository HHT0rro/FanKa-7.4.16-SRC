package com.cupidapp.live.match.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MapGuideIntroDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MapGuideIntroDialog extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16952d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f16953b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16954c;

    /* compiled from: MapGuideIntroDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MapGuideIntroDialog a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            return new MapGuideIntroDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapGuideIntroDialog(Context context) {
        super(context);
        this.f16954c = new LinkedHashMap();
        c();
    }

    public /* synthetic */ MapGuideIntroDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16954c;
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
        z0.z.a(this, R$layout.layout_intro_map_filter, true);
        ((RoundedFrameLayout) a(R$id.map_guide_root)).setCornerRadius(z0.h.c(this, 16.0f), 0.0f, z0.h.c(this, 16.0f), 0.0f);
        TextView filter_map_guide_btn = (TextView) a(R$id.filter_map_guide_btn);
        kotlin.jvm.internal.s.h(filter_map_guide_btn, "filter_map_guide_btn");
        z0.y.d(filter_map_guide_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.MapGuideIntroDialog$initView$1
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
                alertDialog = MapGuideIntroDialog.this.f16953b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    public final void d() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f16953b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(true);
        }
        AlertDialog alertDialog = this.f16953b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f16953b;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);
        window.setGravity(80);
    }
}
