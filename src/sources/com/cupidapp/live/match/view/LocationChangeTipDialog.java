package com.cupidapp.live.match.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.model.LocationChangeModel;
import com.cupidapp.live.base.network.model.UserVipType;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocationChangeTipDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LocationChangeTipDialog extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f16942e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.match.view.a f16943b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AlertDialog f16944c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16945d;

    /* compiled from: LocationChangeTipDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LocationChangeTipDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new LocationChangeTipDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationChangeTipDialog(Context context) {
        super(context);
        this.f16945d = new LinkedHashMap();
        e();
    }

    public /* synthetic */ LocationChangeTipDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16945d;
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
    public final LocationChangeTipDialog d(@NotNull final LocationChangeModel location) {
        kotlin.jvm.internal.s.i(location, "location");
        if (UserVipType.Companion.a(location.getVipType())) {
            int i10 = R$id.vip_icon;
            ((UserIconViewLayout) a(i10)).setVisibility(0);
            UserIconViewLayout vip_icon = (UserIconViewLayout) a(i10);
            kotlin.jvm.internal.s.h(vip_icon, "vip_icon");
            UserIconViewLayout.d(vip_icon, location.mapUserVipDetailModel(), null, null, false, 6, null);
            ((TextView) a(R$id.vip_name)).setVisibility(0);
        } else {
            ((UserIconViewLayout) a(R$id.vip_icon)).setVisibility(8);
            ((TextView) a(R$id.vip_name)).setVisibility(8);
        }
        ((TextView) a(R$id.title_txt)).setText(location.getTitle());
        ((TextView) a(R$id.sub_title_txt)).setText(location.getSubTitle());
        int i11 = R$id.confirm_button;
        ((FKUniversalButton) a(i11)).setText(location.getButton());
        FKUniversalButton confirm_button = (FKUniversalButton) a(i11);
        kotlin.jvm.internal.s.h(confirm_button, "confirm_button");
        z0.y.d(confirm_button, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.LocationChangeTipDialog$configData$1
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
                a aVar;
                AlertDialog alertDialog;
                aVar = LocationChangeTipDialog.this.f16943b;
                if (aVar != null) {
                    aVar.a();
                }
                j1.i iVar = j1.i.f50236a;
                PopupName popupName = PopupName.ROAMING;
                String button = location.getButton();
                if (button == null) {
                    button = "";
                }
                j1.i.e(iVar, popupName, button, null, null, 12, null);
                alertDialog = LocationChangeTipDialog.this.f16944c;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        return this;
    }

    public final void e() {
        z0.z.a(this, R$layout.dialog_location_change_tip, true);
        TextView not_need_btn = (TextView) a(R$id.not_need_btn);
        kotlin.jvm.internal.s.h(not_need_btn, "not_need_btn");
        z0.y.d(not_need_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.LocationChangeTipDialog$initView$1
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
                j1.i.d(j1.i.f50236a, PopupName.ROAMING, PopupButtonName.NOT, null, 4, null);
                alertDialog = LocationChangeTipDialog.this.f16944c;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    @NotNull
    public final LocationChangeTipDialog f(@NotNull com.cupidapp.live.match.view.a listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f16943b = listener;
        return this;
    }

    public final void g() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f16944c = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog = this.f16944c;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f16944c;
        if (alertDialog2 != null && (window = alertDialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-2, -2);
            window.setGravity(17);
        }
        j1.i.g(j1.i.f50236a, PopupName.ROAMING, null, null, 6, null);
    }
}
