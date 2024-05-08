package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.n0;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.consult.adapter.ConsultCommentAdapter;
import com.cupidapp.live.consult.model.ConsultCommentModel;
import com.cupidapp.live.consult.model.ConsultCommentType;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: ConsultCommentListLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultCommentListLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final ConsultCommentAdapter f13851b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public SensorPosition f13852c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13853d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultCommentListLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13853d = new LinkedHashMap();
        this.f13851b = new ConsultCommentAdapter();
        this.f13852c = SensorPosition.Unknown;
        g();
    }

    public static /* synthetic */ void e(ConsultCommentListLayout consultCommentListLayout, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        consultCommentListLayout.d(list, z10);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13853d;
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

    public final void d(@Nullable List<ConsultCommentModel> list, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (z10) {
            int size = this.f13851b.j().size();
            this.f13851b.j().clear();
            this.f13851b.notifyItemRangeRemoved(0, size);
        }
        this.f13851b.u(list);
        Integer v2 = this.f13851b.v();
        if (v2 != null) {
            ((RecyclerView) a(R$id.consult_comment_recycler_view)).scrollToPosition(v2.intValue());
        }
    }

    public final void f() {
        this.f13851b.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.view.ConsultCommentListLayout$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof ConsultCommentModel) {
                    ConsultCommentListLayout.this.h((ConsultCommentModel) obj);
                }
            }
        });
    }

    public final void g() {
        z.a(this, R$layout.layout_consult_comment_list, true);
        RecyclerView initView$lambda$0 = (RecyclerView) a(R$id.consult_comment_recycler_view);
        initView$lambda$0.setLayoutManager(new LinearLayoutManager(initView$lambda$0.getContext()));
        initView$lambda$0.setAdapter(this.f13851b);
        s.h(initView$lambda$0, "initView$lambda$0");
        initView$lambda$0.addItemDecoration(new FKAddExtraSpacingDecoration(0, h.c(initView$lambda$0, 4.0f), 0, 0, 0, h.c(initView$lambda$0, 4.0f), 29, null));
        f();
    }

    public final void h(final ConsultCommentModel consultCommentModel) {
        if (s.d(consultCommentModel.getType(), ConsultCommentType.COMMENT.getValue())) {
            User user = consultCommentModel.getUser();
            boolean z10 = false;
            if (user != null && user.isMyself()) {
                z10 = true;
            }
            if (z10) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new FKActionSheetItemModel(R$string.report, null, null, null, null, new Function0<p>() { // from class: com.cupidapp.live.consult.view.ConsultCommentListLayout$showClickCommentActionSheetDialog$report$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    SensorPosition sensorPosition;
                    n0 n0Var = n0.f12353a;
                    String reportData = ConsultCommentModel.this.getReportData();
                    sensorPosition = this.f13852c;
                    User user2 = ConsultCommentModel.this.getUser();
                    j.a.b(j.f12156c, this.getContext(), n0Var.b(reportData, sensorPosition, user2 != null ? user2.userId() : null), null, 4, null);
                }
            }, 30, null));
            FKActionSheetDialog.f12692f.a(getContext()).g(true).f(arrayList).h();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setCurrentPagePosition(@NotNull SensorPosition position) {
        s.i(position, "position");
        this.f13852c = position;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultCommentListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13853d = new LinkedHashMap();
        this.f13851b = new ConsultCommentAdapter();
        this.f13852c = SensorPosition.Unknown;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultCommentListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13853d = new LinkedHashMap();
        this.f13851b = new ConsultCommentAdapter();
        this.f13852c = SensorPosition.Unknown;
        g();
    }
}
