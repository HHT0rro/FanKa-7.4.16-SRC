package com.cupidapp.live.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.EquityModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.y;
import z0.z;

/* compiled from: UserEntranceCardLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserEntranceCardLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18239b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserEntranceCardLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18239b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18239b;
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

    public final void b(@NotNull final EquityModel model) {
        s.i(model, "model");
        ImageLoaderView entrance_card_img = (ImageLoaderView) a(R$id.entrance_card_img);
        s.h(entrance_card_img, "entrance_card_img");
        ImageLoaderView.g(entrance_card_img, model.getIcon(), null, null, 6, null);
        ((TextView) a(R$id.entrance_title_text)).setText(model.getTitle());
        TextView textView = (TextView) a(R$id.entrance_des_text);
        String description = model.getDescription();
        textView.setText(description != null ? t.a(description, -49088) : null);
        boolean z10 = false;
        a(R$id.red_dot).setVisibility(model.getRedDot() ? 0 : 8);
        String url = model.getUrl();
        if (url != null) {
            if (url.length() > 0) {
                z10 = true;
            }
        }
        if (z10) {
            y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.setting.view.UserEntranceCardLayout$configData$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    SensorsLogKeyButtonClick.UserSetting userSetting = SensorsLogKeyButtonClick.UserSetting.CustomName;
                    String trackName = EquityModel.this.getTrackName();
                    if (trackName == null) {
                        trackName = "";
                    }
                    userSetting.setButtonName(trackName);
                    userSetting.click();
                    j.a.b(j.f12156c, this.getContext(), EquityModel.this.getUrl(), null, 4, null);
                    this.a(R$id.red_dot).setVisibility(8);
                    if (!EquityModel.this.getRedDot() || EquityModel.this.getEntranceType() == null) {
                        return;
                    }
                    Observable<Result<Object>> j02 = NetworkClient.f11868a.N().j0(EquityModel.this.getEntranceType());
                    Object context = this.getContext();
                    g gVar = context instanceof g ? (g) context : null;
                    Disposable disposed = j02.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.setting.view.UserEntranceCardLayout$configData$1$invoke$$inlined$handleByContext$default$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(Object obj) {
                            invoke2(obj);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj) {
                        }
                    }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
                    if (disposed != null) {
                        s.h(disposed, "disposed");
                        if (gVar != null) {
                            gVar.H(disposed);
                        }
                    }
                    s.h(disposed, "disposed");
                }
            });
        }
    }

    public final void c() {
        z.a(this, R$layout.layout_user_entrance_card, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserEntranceCardLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18239b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserEntranceCardLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18239b = new LinkedHashMap();
        c();
    }
}
