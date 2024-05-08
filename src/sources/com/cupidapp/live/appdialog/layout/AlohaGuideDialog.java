package com.cupidapp.live.appdialog.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.match.model.AlohaGuideModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: AlohaGuideDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AlohaGuideDialog extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f11651d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f11652b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11653c;

    /* compiled from: AlohaGuideDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AlohaGuideDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new AlohaGuideDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlohaGuideDialog(Context context) {
        super(context);
        this.f11653c = new LinkedHashMap();
        d();
    }

    public /* synthetic */ AlohaGuideDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f11653c;
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

    @NotNull
    public final AlohaGuideDialog c(@NotNull AlohaGuideModel model, @NotNull final Function0<kotlin.p> btnClick) {
        int i10;
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(btnClick, "btnClick");
        List<ImageModel> newAlohaList = model.getNewAlohaList();
        if (newAlohaList == null) {
            newAlohaList = kotlin.collections.s.j();
        }
        ImageLoaderView aloha_guide_first_img = (ImageLoaderView) a(R$id.aloha_guide_first_img);
        kotlin.jvm.internal.s.h(aloha_guide_first_img, "aloha_guide_first_img");
        ImageLoaderView.g(aloha_guide_first_img, (ImageModel) CollectionsKt___CollectionsKt.W(newAlohaList, 0), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(9.0f, 0, 2, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
        if (CollectionsKt___CollectionsKt.W(newAlohaList, 1) != null) {
            ImageLoaderView aloha_guide_second_img = (ImageLoaderView) a(R$id.aloha_guide_second_img);
            kotlin.jvm.internal.s.h(aloha_guide_second_img, "aloha_guide_second_img");
            i10 = 2;
            ImageLoaderView.g(aloha_guide_second_img, (ImageModel) CollectionsKt___CollectionsKt.W(newAlohaList, 1), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(9.0f, 0, 2, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
        } else {
            i10 = 2;
            ((ImageLoaderView) a(R$id.aloha_guide_second_img)).setImageResource(R$drawable.rect_cor_100_sd_e5e5e5);
        }
        if (CollectionsKt___CollectionsKt.W(newAlohaList, i10) != null) {
            ImageLoaderView aloha_guide_third_img = (ImageLoaderView) a(R$id.aloha_guide_third_img);
            kotlin.jvm.internal.s.h(aloha_guide_third_img, "aloha_guide_third_img");
            ImageLoaderView.g(aloha_guide_third_img, (ImageModel) CollectionsKt___CollectionsKt.W(newAlohaList, i10), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(9.0f, 0, i10, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
        } else {
            ((ImageLoaderView) a(R$id.aloha_guide_third_img)).setImageResource(R$drawable.rect_cor_100_sd_e5e5e5);
        }
        TextView textView = (TextView) a(R$id.aloha_guide_title);
        String newAlohaText = model.getNewAlohaText();
        textView.setText(newAlohaText != null ? t.a(newAlohaText, -49088) : null);
        TextView dialog_aloha_btn = (TextView) a(R$id.dialog_aloha_btn);
        kotlin.jvm.internal.s.h(dialog_aloha_btn, "dialog_aloha_btn");
        y.d(dialog_aloha_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.AlohaGuideDialog$configData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Function0<kotlin.p> function0 = btnClick;
                if (function0 != null) {
                    function0.invoke();
                }
                alertDialog = this.f11652b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        return this;
    }

    public final void d() {
        z.a(this, R$layout.dialog_aloha_guide, true);
        TextView aloha_guide_title = (TextView) a(R$id.aloha_guide_title);
        kotlin.jvm.internal.s.h(aloha_guide_title, "aloha_guide_title");
        u.a(aloha_guide_title);
        TextView dialog_aloha_btn = (TextView) a(R$id.dialog_aloha_btn);
        kotlin.jvm.internal.s.h(dialog_aloha_btn, "dialog_aloha_btn");
        u.a(dialog_aloha_btn);
        int i10 = R$id.aloha_guide_close;
        TextView aloha_guide_close = (TextView) a(i10);
        kotlin.jvm.internal.s.h(aloha_guide_close, "aloha_guide_close");
        u.a(aloha_guide_close);
        TextView aloha_guide_close2 = (TextView) a(i10);
        kotlin.jvm.internal.s.h(aloha_guide_close2, "aloha_guide_close");
        y.d(aloha_guide_close2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.AlohaGuideDialog$initView$1
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
                alertDialog = AlohaGuideDialog.this.f11652b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    public final void e() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f11652b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(true);
        }
        AlertDialog alertDialog = this.f11652b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f11652b;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R$style.dialog_translate_anim);
        window.setLayout(z0.h.c(window, 283.0f), -2);
        window.setGravity(17);
    }
}
