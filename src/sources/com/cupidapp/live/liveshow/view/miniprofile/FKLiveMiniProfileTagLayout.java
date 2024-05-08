package com.cupidapp.live.liveshow.view.miniprofile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.cupidapp.live.base.view.dialog.BgColor;
import com.cupidapp.live.base.view.dialog.BgType;
import com.cupidapp.live.base.view.dialog.FKPointerDialog;
import com.cupidapp.live.base.view.dialog.PointerPos;
import com.cupidapp.live.liveshow.model.MiniProfileUserTagModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;

/* compiled from: FKLiveMiniProfileTagLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveMiniProfileTagLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public final int f15763b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public FKPointerDialog f15764c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15765d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniProfileTagLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15765d = new LinkedHashMap();
        this.f15763b = h.l(this) - h.c(this, 48.0f);
        f();
    }

    public static final void h(FKLiveMiniProfileTagLayout this$0, MiniProfileUserTagModel model, View view) {
        s.i(this$0, "this$0");
        s.i(model, "$model");
        s.i(view, "$view");
        this$0.e();
        FKPointerDialog.a aVar = FKPointerDialog.f12718p;
        Context context = this$0.getContext();
        s.h(context, "context");
        FKPointerDialog j10 = aVar.a(context).l(BgType.GRADIENT).n(model.getBubbleText()).q(PointerPos.TOP_CENTER, BgColor.DEFAULT).m(true).j(Float.valueOf(0.0f));
        this$0.f15764c = j10;
        if (j10 != null) {
            FKPointerDialog.y(j10, view, 0, 0, 3, 6, null);
        }
    }

    public final void c(@Nullable List<MiniProfileUserTagModel> list) {
        int i10 = 0;
        if (list == null || list.isEmpty()) {
            return;
        }
        removeAllViews();
        LinearLayout d10 = d();
        addView(d10);
        for (final MiniProfileUserTagModel miniProfileUserTagModel : list) {
            Context context = getContext();
            s.h(context, "context");
            final FKLiveMiniProfileTagView fKLiveMiniProfileTagView = new FKLiveMiniProfileTagView(context);
            fKLiveMiniProfileTagView.b(miniProfileUserTagModel, h.c(fKLiveMiniProfileTagView, 20.0f));
            y.d(fKLiveMiniProfileTagView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileTagLayout$configLayout$1$1
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
                    FKLiveMiniProfileTagLayout.this.g(fKLiveMiniProfileTagView, miniProfileUserTagModel);
                }
            });
            fKLiveMiniProfileTagView.measure(View.MeasureSpec.makeMeasureSpec(h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(h.k(this), Integer.MIN_VALUE));
            i10 += fKLiveMiniProfileTagView.getMeasuredWidth();
            if (i10 <= this.f15763b) {
                d10.addView(fKLiveMiniProfileTagView);
            } else {
                i10 = fKLiveMiniProfileTagView.getMeasuredWidth();
                d10 = d();
                addView(d10);
                d10.addView(fKLiveMiniProfileTagView);
            }
        }
    }

    public final LinearLayout d() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = h.c(layoutParams, 4.0f);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    public final void e() {
        FKPointerDialog fKPointerDialog = this.f15764c;
        if (fKPointerDialog != null) {
            fKPointerDialog.g(false);
        }
        this.f15764c = null;
    }

    public final void f() {
        setOrientation(1);
    }

    public final void g(final View view, final MiniProfileUserTagModel miniProfileUserTagModel) {
        String bubbleText = miniProfileUserTagModel.getBubbleText();
        if (bubbleText == null || bubbleText.length() == 0) {
            return;
        }
        view.post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.miniprofile.a
            @Override // java.lang.Runnable
            public final void run() {
                FKLiveMiniProfileTagLayout.h(FKLiveMiniProfileTagLayout.this, miniProfileUserTagModel, view);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniProfileTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15765d = new LinkedHashMap();
        this.f15763b = h.l(this) - h.c(this, 48.0f);
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniProfileTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15765d = new LinkedHashMap();
        this.f15763b = h.l(this) - h.c(this, 48.0f);
        f();
    }
}
