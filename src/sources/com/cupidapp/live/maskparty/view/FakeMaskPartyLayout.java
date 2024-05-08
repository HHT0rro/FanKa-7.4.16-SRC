package com.cupidapp.live.maskparty.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.appdialog.model.FakeMaskPartyModel;
import com.cupidapp.live.appdialog.model.WindowType;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.maskparty.activity.MaskPartyMatchActivity;
import com.cupidapp.live.track.group.GroupOthersLog;
import e1.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FakeMaskPartyLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FakeMaskPartyLayout extends BaseLayout {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f16374h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static boolean f16375i;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public AlertDialog f16376d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FakeMaskPartyModel f16377e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public SensorPosition f16378f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16379g;

    /* compiled from: FakeMaskPartyLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return FakeMaskPartyLayout.f16375i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FakeMaskPartyLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16379g = new LinkedHashMap();
        l();
    }

    public static final void o(FakeMaskPartyModel model, FakeMaskPartyLayout this$0, SensorPosition currentPage, DialogInterface dialogInterface) {
        s.i(model, "$model");
        s.i(this$0, "this$0");
        s.i(currentPage, "$currentPage");
        Disposable disposed = a.C0726a.c(NetworkClient.f11868a.i(), model.getScene(), WindowType.SecretLounge.getType(), null, null, null, null, null, null, null, null, 1020, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.view.FakeMaskPartyLayout$showMatchDialog$lambda$1$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this$0)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            this$0.H(disposed);
        }
        s.h(disposed, "disposed");
        String gameTrackName = model.getGameTrackName();
        if (gameTrackName == null || gameTrackName.length() == 0) {
            return;
        }
        GroupOthersLog.a0(GroupOthersLog.f18702a, model.getGameTrackName(), currentPage.getValue(), null, 4, null);
    }

    public static final void p(DialogInterface dialogInterface) {
        f16375i = false;
    }

    @Nullable
    public View g(int i10) {
        Map<Integer, View> map = this.f16379g;
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

    public final void l() {
        z.a(this, R$layout.layout_fake_mask_party, true);
        ((TextView) g(R$id.fake_match_description_text)).getPaint().setFakeBoldText(true);
        ((TextView) g(R$id.fake_match_button)).getPaint().setFakeBoldText(true);
        LinearLayout fake_match_layout = (LinearLayout) g(R$id.fake_match_layout);
        s.h(fake_match_layout, "fake_match_layout");
        y.d(fake_match_layout, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.FakeMaskPartyLayout$initView$1
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
                FakeMaskPartyModel fakeMaskPartyModel;
                AlertDialog alertDialog;
                SensorPosition sensorPosition;
                fakeMaskPartyModel = FakeMaskPartyLayout.this.f16377e;
                if (fakeMaskPartyModel != null) {
                    FakeMaskPartyLayout fakeMaskPartyLayout = FakeMaskPartyLayout.this;
                    alertDialog = fakeMaskPartyLayout.f16376d;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                    }
                    MaskPartyMatchActivity.a.b(MaskPartyMatchActivity.f16245r, fakeMaskPartyLayout.getContext(), r.e(Integer.valueOf(fakeMaskPartyModel.getPlayType())), true, false, fakeMaskPartyModel.getGameTrackName(), 8, null);
                    String gameTrackName = fakeMaskPartyModel.getGameTrackName();
                    if (gameTrackName == null || gameTrackName.length() == 0) {
                        return;
                    }
                    GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                    String gameTrackName2 = fakeMaskPartyModel.getGameTrackName();
                    sensorPosition = fakeMaskPartyLayout.f16378f;
                    GroupOthersLog.Y(groupOthersLog, gameTrackName2, sensorPosition != null ? sensorPosition.getValue() : null, PopupButtonName.Confirm.getValue(), null, 8, null);
                }
            }
        });
        ImageView close_fake_match_imageview = (ImageView) g(R$id.close_fake_match_imageview);
        s.h(close_fake_match_imageview, "close_fake_match_imageview");
        y.d(close_fake_match_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.FakeMaskPartyLayout$initView$2
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
                alertDialog = FakeMaskPartyLayout.this.f16376d;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    public final void m(@NotNull final FakeMaskPartyModel model, @NotNull final SensorPosition currentPage) {
        Window window;
        s.i(model, "model");
        s.i(currentPage, "currentPage");
        f16375i = true;
        this.f16377e = model;
        this.f16378f = currentPage;
        ImageLoaderView fake_match_bg_image = (ImageLoaderView) g(R$id.fake_match_bg_image);
        s.h(fake_match_bg_image, "fake_match_bg_image");
        ImageLoaderView.g(fake_match_bg_image, model.getBgImage(), null, null, 6, null);
        ((TextView) g(R$id.fake_match_title_text)).setText(model.getTitle());
        ((TextView) g(R$id.fake_match_description_text)).setText(model.getContent());
        ((TextView) g(R$id.fake_match_times_text)).setText(model.getGiveMsg());
        ((TextView) g(R$id.fake_match_button)).setText(model.getButtonDesc());
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f16376d = create;
        if (create != null) {
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.maskparty.view.b
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    FakeMaskPartyLayout.o(FakeMaskPartyModel.this, this, currentPage, dialogInterface);
                }
            });
        }
        AlertDialog alertDialog = this.f16376d;
        if (alertDialog != null) {
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.maskparty.view.a
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FakeMaskPartyLayout.p(dialogInterface);
                }
            });
        }
        AlertDialog alertDialog2 = this.f16376d;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
        AlertDialog alertDialog3 = this.f16376d;
        if (alertDialog3 == null || (window = alertDialog3.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R$style.dialog_translate_anim);
        window.setLayout(-1, -2);
        window.setGravity(80);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FakeMaskPartyLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16379g = new LinkedHashMap();
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FakeMaskPartyLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16379g = new LinkedHashMap();
        l();
    }
}
