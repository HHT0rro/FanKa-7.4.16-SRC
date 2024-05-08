package com.cupidapp.live.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.setting.adapter.PushRecoveryAdapter;
import com.cupidapp.live.setting.model.NewPushSettingResult;
import com.cupidapp.live.setting.model.PushLabelModel;
import com.cupidapp.live.setting.model.PushPauseOptionModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.z;

/* compiled from: RecoveryPushSettingLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RecoveryPushSettingLayout extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f18225b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Integer f18226c;

    /* renamed from: d, reason: collision with root package name */
    public int f18227d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Integer f18228e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Function0<p> f18229f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Function0<p> f18230g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18231h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecoveryPushSettingLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18231h = new LinkedHashMap();
        this.f18225b = c.b(new Function0<PushRecoveryAdapter>() { // from class: com.cupidapp.live.setting.view.RecoveryPushSettingLayout$pushRecoveryAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PushRecoveryAdapter invoke() {
                PushRecoveryAdapter pushRecoveryAdapter = new PushRecoveryAdapter();
                final RecoveryPushSettingLayout recoveryPushSettingLayout = RecoveryPushSettingLayout.this;
                pushRecoveryAdapter.l().k(i0.h(f.a(Integer.valueOf(R$id.utilLeaveLocation), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.setting.view.RecoveryPushSettingLayout$pushRecoveryAdapter$2$1$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i10) {
                        RecoveryPushSettingLayout.this.f18227d = i10;
                        RecoveryPushSettingLayout.this.setSelectItem();
                    }
                })));
                return pushRecoveryAdapter;
            }
        });
        c();
    }

    private final PushRecoveryAdapter getPushRecoveryAdapter() {
        return (PushRecoveryAdapter) this.f18225b.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18231h;
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
        PushPauseOptionModel pushPauseOption;
        PushPauseOptionModel pushPauseOption2;
        z.a(this, R$layout.layout_push_setting_recyclerview, true);
        RecyclerView recyclerView = (RecyclerView) a(R$id.pushSettingRecyclerView);
        recyclerView.setAdapter(getPushRecoveryAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        g gVar = g.f52734a;
        NewPushSettingResult c4 = gVar.v0().c();
        if (c4 != null && (pushPauseOption = c4.getPushPauseOption()) != null) {
            NewPushSettingResult c10 = gVar.v0().c();
            this.f18228e = (c10 == null || (pushPauseOption2 = c10.getPushPauseOption()) == null) ? null : Integer.valueOf(pushPauseOption2.getPushCurrentLabelId());
            String countdown = pushPauseOption.getCountdown();
            if (countdown != null) {
                getPushRecoveryAdapter().d(new PushLabelModel(null, countdown, true, false, 8, null));
                this.f18228e = null;
            }
            getPushRecoveryAdapter().e(pushPauseOption.getPushPauseLabels());
        }
        getPushRecoveryAdapter().notifyDataSetChanged();
    }

    public final void d() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.location_services_request, 0, 2, null), R$string.go_to_open, null, new Function0<p>() { // from class: com.cupidapp.live.setting.view.RecoveryPushSettingLayout$openLocationServices$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0<p> requestLocationServices = RecoveryPushSettingLayout.this.getRequestLocationServices();
                if (requestLocationServices != null) {
                    requestLocationServices.invoke();
                }
            }
        }, 2, null), 0, null, 3, null), null, 1, null);
    }

    @Nullable
    public final Function0<p> getRequestLocationPermission() {
        return this.f18229f;
    }

    @Nullable
    public final Function0<p> getRequestLocationServices() {
        return this.f18230g;
    }

    @Nullable
    public final Integer getSelectId() {
        if (s.d(this.f18226c, this.f18228e)) {
            return null;
        }
        return this.f18226c;
    }

    public final void setRequestLocationPermission(@Nullable Function0<p> function0) {
        this.f18229f = function0;
    }

    public final void setRequestLocationServices(@Nullable Function0<p> function0) {
        this.f18230g = function0;
    }

    public final void setSelectItem() {
        if (getPushRecoveryAdapter().j().size() <= this.f18227d) {
            return;
        }
        Object obj = getPushRecoveryAdapter().j().get(this.f18227d);
        if ((obj instanceof PushLabelModel) && ((PushLabelModel) obj).getPushEnableLocation()) {
            LocationUtils.Companion companion = LocationUtils.f12270h;
            if (!companion.b(getContext())) {
                d();
                return;
            } else if (companion.c(getContext())) {
                Function0<p> function0 = this.f18229f;
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            }
        }
        LocationUtils.Companion companion2 = LocationUtils.f12270h;
        if (companion2.a().f()) {
            LocationUtils.o(companion2.a(), getContext(), null, null, null, 14, null);
        }
        int i10 = 0;
        for (Object obj2 : getPushRecoveryAdapter().j()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            if (obj2 instanceof PushLabelModel) {
                PushLabelModel pushLabelModel = (PushLabelModel) obj2;
                pushLabelModel.setChecked(i10 == this.f18227d);
                if (i10 == this.f18227d) {
                    this.f18226c = pushLabelModel.getId();
                }
            }
            i10 = i11;
        }
        getPushRecoveryAdapter().notifyDataSetChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecoveryPushSettingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18231h = new LinkedHashMap();
        this.f18225b = c.b(new Function0<PushRecoveryAdapter>() { // from class: com.cupidapp.live.setting.view.RecoveryPushSettingLayout$pushRecoveryAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PushRecoveryAdapter invoke() {
                PushRecoveryAdapter pushRecoveryAdapter = new PushRecoveryAdapter();
                final RecoveryPushSettingLayout recoveryPushSettingLayout = RecoveryPushSettingLayout.this;
                pushRecoveryAdapter.l().k(i0.h(f.a(Integer.valueOf(R$id.utilLeaveLocation), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.setting.view.RecoveryPushSettingLayout$pushRecoveryAdapter$2$1$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i10) {
                        RecoveryPushSettingLayout.this.f18227d = i10;
                        RecoveryPushSettingLayout.this.setSelectItem();
                    }
                })));
                return pushRecoveryAdapter;
            }
        });
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecoveryPushSettingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18231h = new LinkedHashMap();
        this.f18225b = c.b(new Function0<PushRecoveryAdapter>() { // from class: com.cupidapp.live.setting.view.RecoveryPushSettingLayout$pushRecoveryAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PushRecoveryAdapter invoke() {
                PushRecoveryAdapter pushRecoveryAdapter = new PushRecoveryAdapter();
                final RecoveryPushSettingLayout recoveryPushSettingLayout = RecoveryPushSettingLayout.this;
                pushRecoveryAdapter.l().k(i0.h(f.a(Integer.valueOf(R$id.utilLeaveLocation), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.setting.view.RecoveryPushSettingLayout$pushRecoveryAdapter$2$1$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i102) {
                        RecoveryPushSettingLayout.this.f18227d = i102;
                        RecoveryPushSettingLayout.this.setSelectItem();
                    }
                })));
                return pushRecoveryAdapter;
            }
        });
        c();
    }
}
