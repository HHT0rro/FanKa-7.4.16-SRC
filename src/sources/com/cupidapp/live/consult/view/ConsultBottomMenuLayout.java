package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.consult.activity.BaseConsultActivity;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.consult.view.ConsultCommentEditTextLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ConsultBottomMenuLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultBottomMenuLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public ConsultLiveModel f13843b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13844c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultBottomMenuLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13844c = new LinkedHashMap();
        e();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13844c;
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
        TextView consult_bottom_menu_start_comment_btn = (TextView) a(R$id.consult_bottom_menu_start_comment_btn);
        s.h(consult_bottom_menu_start_comment_btn, "consult_bottom_menu_start_comment_btn");
        y.d(consult_bottom_menu_start_comment_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultBottomMenuLayout$bindClickEvent$1
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
                ConsultLiveModel consultLiveModel;
                ConsultCommentEditTextLayout.Companion companion = ConsultCommentEditTextLayout.f13845h;
                Context context = ConsultBottomMenuLayout.this.getContext();
                s.h(context, "context");
                consultLiveModel = ConsultBottomMenuLayout.this.f13843b;
                companion.b(context, consultLiveModel != null ? consultLiveModel.getId() : null);
            }
        });
        ImageView consult_bottom_menu_more_btn = (ImageView) a(R$id.consult_bottom_menu_more_btn);
        s.h(consult_bottom_menu_more_btn, "consult_bottom_menu_more_btn");
        y.d(consult_bottom_menu_more_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultBottomMenuLayout$bindClickEvent$2
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
                ConsultLiveModel consultLiveModel;
                Context context = ConsultBottomMenuLayout.this.getContext();
                BaseConsultActivity baseConsultActivity = context instanceof BaseConsultActivity ? (BaseConsultActivity) context : null;
                if (baseConsultActivity != null) {
                    consultLiveModel = ConsultBottomMenuLayout.this.f13843b;
                    baseConsultActivity.k1(consultLiveModel);
                }
            }
        });
    }

    public final void d(@NotNull ConsultLiveModel model) {
        s.i(model, "model");
        this.f13843b = model;
    }

    public final void e() {
        z.a(this, R$layout.layout_consult_bottom_menu, true);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultBottomMenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13844c = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultBottomMenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13844c = new LinkedHashMap();
        e();
    }
}
