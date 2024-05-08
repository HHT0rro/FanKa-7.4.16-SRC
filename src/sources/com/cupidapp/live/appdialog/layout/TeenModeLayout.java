package com.cupidapp.live.appdialog.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.appdialog.model.TeenModeModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import io.reactivex.Completable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: TeenModeLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TeenModeLayout extends TabBaseDialogLayout {

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public TeenModeModel f11711h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public SensorPosition f11712i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11713j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TeenModeLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11713j = new LinkedHashMap();
        this.f11712i = SensorPosition.Unknown;
        E();
    }

    @Nullable
    public View C(int i10) {
        Map<Integer, View> map = this.f11713j;
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

    public final void E() {
        z.a(this, R$layout.layout_adolescent_mode, true);
        ((TextView) C(R$id.adolescent_mode_title_textview)).getPaint().setFakeBoldText(true);
        FKUniversalButton know_it_btn = (FKUniversalButton) C(R$id.know_it_btn);
        kotlin.jvm.internal.s.h(know_it_btn, "know_it_btn");
        y.d(know_it_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.TeenModeLayout$initView$1
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
                TeenModeLayout.this.q();
                j1.i.d(j1.i.f50236a, PopupName.TEENAGER_MODE, PopupButtonName.Cancel, null, 4, null);
            }
        });
        TextView open_adolescent_mode_textview = (TextView) C(R$id.open_adolescent_mode_textview);
        kotlin.jvm.internal.s.h(open_adolescent_mode_textview, "open_adolescent_mode_textview");
        y.d(open_adolescent_mode_textview, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.TeenModeLayout$initView$2
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
                TeenModeModel teenModeModel;
                TeenModeLayout.this.q();
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                Context context = TeenModeLayout.this.getContext();
                teenModeModel = TeenModeLayout.this.f11711h;
                j.a.b(aVar, context, teenModeModel != null ? teenModeModel.getUrl() : null, null, 4, null);
                j1.i.d(j1.i.f50236a, PopupName.TEENAGER_MODE, PopupButtonName.Confirm, null, 4, null);
            }
        });
    }

    public final void F(@NotNull TeenModeModel model, @NotNull SensorPosition position) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(position, "position");
        this.f11711h = model;
        this.f11712i = position;
        TabBaseDialogLayout.x(this, -2, -2, 0, false, null, 28, null);
        j1.i.g(j1.i.f50236a, PopupName.TEENAGER_MODE, null, null, 6, null);
    }

    @Override // com.cupidapp.live.appdialog.layout.TabBaseDialogLayout
    @NotNull
    public SensorPosition getPosition() {
        return this.f11712i;
    }

    @Override // com.cupidapp.live.appdialog.layout.TabBaseDialogLayout
    public boolean u() {
        TeenModeModel teenModeModel = this.f11711h;
        if (teenModeModel != null) {
            return teenModeModel.getReTabChange();
        }
        return false;
    }

    @Override // com.cupidapp.live.appdialog.layout.TabBaseDialogLayout
    @NotNull
    public Completable v() {
        Completable complete = Completable.complete();
        kotlin.jvm.internal.s.h(complete, "complete()");
        return complete;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TeenModeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11713j = new LinkedHashMap();
        this.f11712i = SensorPosition.Unknown;
        E();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TeenModeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11713j = new LinkedHashMap();
        this.f11712i = SensorPosition.Unknown;
        E();
    }
}
