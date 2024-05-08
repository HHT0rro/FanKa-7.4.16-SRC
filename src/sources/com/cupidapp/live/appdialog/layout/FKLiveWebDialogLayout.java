package com.cupidapp.live.appdialog.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.appdialog.model.WebDialogModel;
import com.cupidapp.live.appdialog.model.WindowType;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import e1.a;
import io.reactivex.Completable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveWebDialogLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveWebDialogLayout extends TabBaseDialogLayout {

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public WebDialogModel f11691h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public SensorPosition f11692i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11693j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveWebDialogLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11693j = new LinkedHashMap();
        this.f11692i = SensorPosition.Unknown;
        D();
    }

    @Nullable
    public View C(int i10) {
        Map<Integer, View> map = this.f11693j;
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

    public final void D() {
        z.a(this, R$layout.layout_live_web_dialog, true);
    }

    public final void E(@NotNull final WebDialogModel webDialog, @NotNull SensorPosition position) {
        kotlin.jvm.internal.s.i(webDialog, "webDialog");
        kotlin.jvm.internal.s.i(position, "position");
        this.f11691h = webDialog;
        this.f11692i = position;
        if (webDialog.getImage() == null) {
            j.a.b(com.cupidapp.live.base.router.j.f12156c, getContext(), webDialog.getWebUrl(), null, 4, null);
            r();
            return;
        }
        int i10 = R$id.liveWebDialogImage;
        ((ImageLoaderView) C(i10)).getLayoutParams().height = webDialog.getImage().getScaleHeightByWidth(z0.h.l(this));
        ImageLoaderView liveWebDialogImage = (ImageLoaderView) C(i10);
        kotlin.jvm.internal.s.h(liveWebDialogImage, "liveWebDialogImage");
        ImageLoaderView.g(liveWebDialogImage, webDialog.getImage(), null, null, 6, null);
        w(-1, -1, 17, true, Integer.valueOf(R$style.dialog_translate_anim));
        ImageLoaderView liveWebDialogImage2 = (ImageLoaderView) C(i10);
        kotlin.jvm.internal.s.h(liveWebDialogImage2, "liveWebDialogImage");
        y.d(liveWebDialogImage2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKLiveWebDialogLayout$showLiveWebDialog$1
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
                FKLiveWebDialogLayout.this.q();
                j.a.b(com.cupidapp.live.base.router.j.f12156c, FKLiveWebDialogLayout.this.getContext(), webDialog.getWebUrl(), null, 4, null);
            }
        });
        ImageView closeWebDialogImage = (ImageView) C(R$id.closeWebDialogImage);
        kotlin.jvm.internal.s.h(closeWebDialogImage, "closeWebDialogImage");
        y.d(closeWebDialogImage, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKLiveWebDialogLayout$showLiveWebDialog$2
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
                FKLiveWebDialogLayout.this.q();
            }
        });
    }

    @Override // com.cupidapp.live.appdialog.layout.TabBaseDialogLayout
    @NotNull
    public SensorPosition getPosition() {
        return this.f11692i;
    }

    @Override // com.cupidapp.live.appdialog.layout.TabBaseDialogLayout
    public boolean u() {
        WebDialogModel webDialogModel = this.f11691h;
        if (webDialogModel != null) {
            return webDialogModel.getReTabChange();
        }
        return false;
    }

    @Override // com.cupidapp.live.appdialog.layout.TabBaseDialogLayout
    @NotNull
    public Completable v() {
        if (this.f11691h != null) {
            e1.a i10 = NetworkClient.f11868a.i();
            WebDialogModel webDialogModel = this.f11691h;
            kotlin.jvm.internal.s.f(webDialogModel);
            String scene = webDialogModel.getScene();
            String type = WindowType.Web.getType();
            WebDialogModel webDialogModel2 = this.f11691h;
            kotlin.jvm.internal.s.f(webDialogModel2);
            Completable ignoreElements = a.C0726a.c(i10, scene, type, null, Long.valueOf(webDialogModel2.getWebId()), null, null, null, null, null, null, 1012, null).ignoreElements();
            kotlin.jvm.internal.s.h(ignoreElements, "{\n        NetworkClient.… ).ignoreElements()\n    }");
            return ignoreElements;
        }
        Completable complete = Completable.complete();
        kotlin.jvm.internal.s.h(complete, "{\n        Completable.complete()\n    }");
        return complete;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveWebDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11693j = new LinkedHashMap();
        this.f11692i = SensorPosition.Unknown;
        D();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveWebDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11693j = new LinkedHashMap();
        this.f11692i = SensorPosition.Unknown;
        D();
    }
}
