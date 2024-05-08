package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.dialog.FKCustomViewAlertDialog;
import j1.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: ConsultRoomFirstEnterGuideLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultRoomFirstEnterGuideLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Companion f13868d = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static FKCustomViewAlertDialog f13869e;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<p> f13870b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13871c;

    /* compiled from: ConsultRoomFirstEnterGuideLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            s.i(context, "context");
            FKCustomViewAlertDialog fKCustomViewAlertDialog = ConsultRoomFirstEnterGuideLayout.f13869e;
            boolean z10 = false;
            if (fKCustomViewAlertDialog != null && fKCustomViewAlertDialog.g()) {
                z10 = true;
            }
            if (z10) {
                return;
            }
            ConsultRoomFirstEnterGuideLayout consultRoomFirstEnterGuideLayout = new ConsultRoomFirstEnterGuideLayout(context);
            consultRoomFirstEnterGuideLayout.f13870b = new Function0<p>() { // from class: com.cupidapp.live.consult.view.ConsultRoomFirstEnterGuideLayout$Companion$showGuide$layout$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKCustomViewAlertDialog fKCustomViewAlertDialog2 = ConsultRoomFirstEnterGuideLayout.f13869e;
                    if (fKCustomViewAlertDialog2 != null) {
                        fKCustomViewAlertDialog2.f();
                    }
                }
            };
            FKCustomViewAlertDialog a10 = FKCustomViewAlertDialog.f12713e.a(context);
            ConsultRoomFirstEnterGuideLayout.f13869e = a10 != null ? a10.c() : null;
            FKCustomViewAlertDialog fKCustomViewAlertDialog2 = ConsultRoomFirstEnterGuideLayout.f13869e;
            if (fKCustomViewAlertDialog2 != null) {
                fKCustomViewAlertDialog2.i(true);
            }
            FKCustomViewAlertDialog fKCustomViewAlertDialog3 = ConsultRoomFirstEnterGuideLayout.f13869e;
            if (fKCustomViewAlertDialog3 != null) {
                fKCustomViewAlertDialog3.k();
            }
            FKCustomViewAlertDialog fKCustomViewAlertDialog4 = ConsultRoomFirstEnterGuideLayout.f13869e;
            if (fKCustomViewAlertDialog4 != null) {
                fKCustomViewAlertDialog4.h(consultRoomFirstEnterGuideLayout);
            }
            FKCustomViewAlertDialog fKCustomViewAlertDialog5 = ConsultRoomFirstEnterGuideLayout.f13869e;
            if (fKCustomViewAlertDialog5 != null) {
                FKCustomViewAlertDialog.setDialogWindow$default(fKCustomViewAlertDialog5, 0, -1, -1, 0, 9, null);
            }
            i.g(i.f50236a, PopupName.CONSULT_ROOM_FIRST_GUIDE, SensorPosition.CONSULT_ROOM, null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultRoomFirstEnterGuideLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13871c = new LinkedHashMap();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13871c;
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

    public final void f() {
        z.a(this, R$layout.layout_consult_room_first_enter_guide, true);
        int i10 = R$id.next_step_txt;
        TextView next_step_txt = (TextView) a(i10);
        s.h(next_step_txt, "next_step_txt");
        u.a(next_step_txt);
        int i11 = R$id.i_know_txt;
        TextView i_know_txt = (TextView) a(i11);
        s.h(i_know_txt, "i_know_txt");
        u.a(i_know_txt);
        TextView next_step_txt2 = (TextView) a(i10);
        s.h(next_step_txt2, "next_step_txt");
        y.d(next_step_txt2, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultRoomFirstEnterGuideLayout$initView$1
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
                ((Group) ConsultRoomFirstEnterGuideLayout.this.a(R$id.first_enter_room_guide_group)).setVisibility(8);
                ((Group) ConsultRoomFirstEnterGuideLayout.this.a(R$id.connect_guide_group)).setVisibility(0);
                i.g(i.f50236a, PopupName.CONSULT_ROOM_SECRET_CONNECT, SensorPosition.CONSULT_ROOM, null, 4, null);
            }
        });
        TextView i_know_txt2 = (TextView) a(i11);
        s.h(i_know_txt2, "i_know_txt");
        y.d(i_know_txt2, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultRoomFirstEnterGuideLayout$initView$2
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
                Function0 function0;
                function0 = ConsultRoomFirstEnterGuideLayout.this.f13870b;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultRoomFirstEnterGuideLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13871c = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultRoomFirstEnterGuideLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13871c = new LinkedHashMap();
        f();
    }
}
