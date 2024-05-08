package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.consult.model.ConsultAnchorTaskItemModel;
import com.cupidapp.live.consult.model.ConsultAnchorTaskModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ConsultAnchorTaskLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultAnchorTaskLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super String, p> f13836b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ConsultAnchorTaskModel f13837c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13838d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultAnchorTaskLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13838d = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13838d;
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

    public final void c(@Nullable ConsultAnchorTaskModel consultAnchorTaskModel) {
        List<ConsultAnchorTaskItemModel> list;
        this.f13837c = consultAnchorTaskModel;
        ConsultAnchorTaskItemModel consultAnchorTaskItemModel = (consultAnchorTaskModel == null || (list = consultAnchorTaskModel.getList()) == null) ? null : (ConsultAnchorTaskItemModel) CollectionsKt___CollectionsKt.W(list, 0);
        if (consultAnchorTaskItemModel == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((TextView) a(R$id.consult_first_anchor_task_text)).setText(consultAnchorTaskItemModel.getText());
        float f10 = 100;
        ((ProgressBar) a(R$id.consult_first_anchor_task_progress_bar)).setProgress((int) (consultAnchorTaskItemModel.getPercent() * f10));
        ConsultAnchorTaskItemModel consultAnchorTaskItemModel2 = (ConsultAnchorTaskItemModel) CollectionsKt___CollectionsKt.W(consultAnchorTaskModel.getList(), 1);
        if (consultAnchorTaskItemModel2 == null) {
            ((TextView) a(R$id.consult_second_anchor_task_text)).setVisibility(8);
            ((ProgressBar) a(R$id.consult_second_anchor_task_progress_bar)).setVisibility(8);
            return;
        }
        int i10 = R$id.consult_second_anchor_task_text;
        ((TextView) a(i10)).setVisibility(0);
        int i11 = R$id.consult_second_anchor_task_progress_bar;
        ((ProgressBar) a(i11)).setVisibility(0);
        ((TextView) a(i10)).setText(consultAnchorTaskItemModel2.getText());
        ((ProgressBar) a(i11)).setProgress((int) (consultAnchorTaskItemModel2.getPercent() * f10));
    }

    public final void d() {
        z.a(this, R$layout.layout_consult_anchor_task, true);
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultAnchorTaskLayout$initView$1
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
                ConsultAnchorTaskModel consultAnchorTaskModel;
                String jumpUrl;
                Function1<String, p> clickCallback;
                consultAnchorTaskModel = ConsultAnchorTaskLayout.this.f13837c;
                if (consultAnchorTaskModel == null || (jumpUrl = consultAnchorTaskModel.getJumpUrl()) == null || (clickCallback = ConsultAnchorTaskLayout.this.getClickCallback()) == null) {
                    return;
                }
                clickCallback.invoke(jumpUrl);
            }
        });
    }

    @Nullable
    public final Function1<String, p> getClickCallback() {
        return this.f13836b;
    }

    public final void setClickCallback(@Nullable Function1<? super String, p> function1) {
        this.f13836b = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultAnchorTaskLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13838d = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultAnchorTaskLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13838d = new LinkedHashMap();
        d();
    }
}
