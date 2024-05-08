package com.cupidapp.live.appdialog.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.appdialog.model.GuideOpenPushDialogModel;
import com.cupidapp.live.appdialog.model.WindowType;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.o0;
import com.cupidapp.live.base.utils.r0;
import e1.a;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKGuideOpenPushDialogLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKGuideOpenPushDialogLayout extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f11679c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11680b;

    /* compiled from: FKGuideOpenPushDialogLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull GuideOpenPushDialogModel model, @NotNull SensorPosition position) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(model, "model");
            kotlin.jvm.internal.s.i(position, "position");
            if (r0.f12373a.a(context)) {
                return;
            }
            new FKGuideOpenPushDialogLayout(context).f(model, position);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKGuideOpenPushDialogLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11680b = new LinkedHashMap();
        e();
    }

    public static final void g(GuideOpenPushDialogModel model, FKGuideOpenPushDialogLayout this$0) {
        kotlin.jvm.internal.s.i(model, "$model");
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ImageModel image = model.getImage();
        int i10 = R$id.guideOpenPushImageView;
        int scaleHeightByWidth = image.getScaleHeightByWidth(((ImageLoaderView) this$0.c(i10)).getWidth());
        ImageLoaderView guideOpenPushImageView = (ImageLoaderView) this$0.c(i10);
        kotlin.jvm.internal.s.h(guideOpenPushImageView, "guideOpenPushImageView");
        y.o(guideOpenPushImageView, null, Integer.valueOf(scaleHeightByWidth), 1, null);
        ImageLoaderView guideOpenPushImageView2 = (ImageLoaderView) this$0.c(i10);
        kotlin.jvm.internal.s.h(guideOpenPushImageView2, "guideOpenPushImageView");
        ImageLoaderView.g(guideOpenPushImageView2, model.getImage(), null, null, 6, null);
    }

    public static final void h(GuideOpenPushDialogModel model, FKGuideOpenPushDialogLayout this$0, SensorPosition position, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(model, "$model");
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(position, "$position");
        Observable c4 = a.C0726a.c(NetworkClient.f11868a.i(), model.getScene(), WindowType.PushPriWindow.getType(), null, null, null, null, model.getRuleId(), null, null, null, 956, null);
        Object context = this$0.getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = c4.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKGuideOpenPushDialogLayout$showOpenPushDialog$lambda$2$$inlined$handleByContext$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        j1.i.g(j1.i.f50236a, PopupName.PUSH_GUIDE_POPUP, position, null, 4, null);
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f11680b;
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
        z.a(this, R$layout.layout_guide_open_push_dialog, true);
    }

    public final void f(final GuideOpenPushDialogModel guideOpenPushDialogModel, final SensorPosition sensorPosition) {
        int i10 = R$id.guideOpenPushImageView;
        ((ImageLoaderView) c(i10)).post(new Runnable() { // from class: com.cupidapp.live.appdialog.layout.i
            @Override // java.lang.Runnable
            public final void run() {
                FKGuideOpenPushDialogLayout.g(GuideOpenPushDialogModel.this, this);
            }
        });
        final AlertDialog create = z0.b.f54812a.e(getContext()).create();
        create.setCanceledOnTouchOutside(false);
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.appdialog.layout.h
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                FKGuideOpenPushDialogLayout.h(GuideOpenPushDialogModel.this, this, sensorPosition, dialogInterface);
            }
        });
        create.show();
        create.setContentView(this);
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -2);
        }
        ImageLoaderView guideOpenPushImageView = (ImageLoaderView) c(i10);
        kotlin.jvm.internal.s.h(guideOpenPushImageView, "guideOpenPushImageView");
        y.d(guideOpenPushImageView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKGuideOpenPushDialogLayout$showOpenPushDialog$4
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
                create.dismiss();
                r0.f12373a.c(this.getContext());
                j1.i.f50236a.a(PopupName.PUSH_GUIDE_POPUP, PopupButtonName.OpenPush, sensorPosition);
                o0.f12367a.g(true);
            }
        });
        ImageView closePushDialogButton = (ImageView) c(R$id.closePushDialogButton);
        kotlin.jvm.internal.s.h(closePushDialogButton, "closePushDialogButton");
        y.d(closePushDialogButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKGuideOpenPushDialogLayout$showOpenPushDialog$5
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
                create.dismiss();
                j1.i.f50236a.a(PopupName.PUSH_GUIDE_POPUP, PopupButtonName.Close, sensorPosition);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKGuideOpenPushDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11680b = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKGuideOpenPushDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11680b = new LinkedHashMap();
        e();
    }
}
