package com.cupidapp.live.match.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.match.model.LocationChangedModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocationChangedSucDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LocationChangedSucDialog extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16946d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f16947b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16948c;

    /* compiled from: LocationChangedSucDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LocationChangedSucDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new LocationChangedSucDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationChangedSucDialog(Context context) {
        super(context);
        this.f16948c = new LinkedHashMap();
        d();
    }

    public /* synthetic */ LocationChangedSucDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16948c;
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
    public final LocationChangedSucDialog c(@NotNull final LocationChangedModel location) {
        kotlin.jvm.internal.s.i(location, "location");
        ((TextView) a(R$id.dialog_title_text)).setText(location.getTitle());
        ((TextView) a(R$id.dialog_message_text)).setText(location.getSubTitle());
        int i10 = R$id.horizontal_secondary_button;
        ((TextView) a(i10)).setText(location.getLeftButtonName());
        int i11 = R$id.horizontal_main_button;
        ((TextView) a(i11)).setText(location.getRightButtonName());
        TextView horizontal_main_button = (TextView) a(i11);
        kotlin.jvm.internal.s.h(horizontal_main_button, "horizontal_main_button");
        z0.y.d(horizontal_main_button, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.LocationChangedSucDialog$configData$1
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
                j.a.b(com.cupidapp.live.base.router.j.f12156c, LocationChangedSucDialog.this.getContext(), location.getRightButtonUrl(), null, 4, null);
                alertDialog = LocationChangedSucDialog.this.f16947b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                j1.i iVar = j1.i.f50236a;
                PopupName popupName = PopupName.NON_VIP_ROAMING_BUY;
                String rightButtonName = location.getRightButtonName();
                if (rightButtonName == null) {
                    rightButtonName = "";
                }
                j1.i.e(iVar, popupName, rightButtonName, null, null, 12, null);
            }
        });
        TextView horizontal_secondary_button = (TextView) a(i10);
        kotlin.jvm.internal.s.h(horizontal_secondary_button, "horizontal_secondary_button");
        z0.y.d(horizontal_secondary_button, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.LocationChangedSucDialog$configData$2
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
                j.a.b(com.cupidapp.live.base.router.j.f12156c, LocationChangedSucDialog.this.getContext(), location.getLeftButtonUrl(), null, 4, null);
                j1.i iVar = j1.i.f50236a;
                PopupName popupName = PopupName.NON_VIP_ROAMING_BUY;
                String leftButtonName = location.getLeftButtonName();
                if (leftButtonName == null) {
                    leftButtonName = "";
                }
                j1.i.e(iVar, popupName, leftButtonName, null, null, 12, null);
                alertDialog = LocationChangedSucDialog.this.f16947b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        ImageView dialog_close_img = (ImageView) a(R$id.dialog_close_img);
        kotlin.jvm.internal.s.h(dialog_close_img, "dialog_close_img");
        z0.y.d(dialog_close_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.LocationChangedSucDialog$configData$3
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
                alertDialog = LocationChangedSucDialog.this.f16947b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        return this;
    }

    public final void d() {
        z0.z.a(this, R$layout.dialog_location_changed_suc, true);
        TextView dialog_title_text = (TextView) a(R$id.dialog_title_text);
        kotlin.jvm.internal.s.h(dialog_title_text, "dialog_title_text");
        z0.u.a(dialog_title_text);
        TextView horizontal_secondary_button = (TextView) a(R$id.horizontal_secondary_button);
        kotlin.jvm.internal.s.h(horizontal_secondary_button, "horizontal_secondary_button");
        z0.u.a(horizontal_secondary_button);
        TextView horizontal_main_button = (TextView) a(R$id.horizontal_main_button);
        kotlin.jvm.internal.s.h(horizontal_main_button, "horizontal_main_button");
        z0.u.a(horizontal_main_button);
    }

    public final void e() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f16947b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog = this.f16947b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f16947b;
        if (alertDialog2 != null && (window = alertDialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-2, -2);
            window.setGravity(17);
        }
        j1.i.g(j1.i.f50236a, PopupName.NON_VIP_ROAMING_BUY, null, null, 6, null);
    }
}
