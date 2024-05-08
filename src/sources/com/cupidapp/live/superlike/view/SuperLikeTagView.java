package com.cupidapp.live.superlike.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: SuperLikeTagView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikeTagView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public SuperLikeType f18645b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public SuperLikeSize f18646c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Integer f18647d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18648e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikeTagView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18648e = new LinkedHashMap();
        this.f18645b = SuperLikeType.SUPER_LIKE_ME;
        this.f18646c = SuperLikeSize.SMALL;
        h(this, context, null, 2, null);
    }

    public static /* synthetic */ void h(SuperLikeTagView superLikeTagView, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        superLikeTagView.g(context, attributeSet);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18648e;
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

    public final void b() {
        setBackgroundColor(0);
        if (this.f18647d != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R$id.root);
            Integer num = this.f18647d;
            s.f(num);
            constraintLayout.setBackgroundColor(num.intValue());
            return;
        }
        ((ConstraintLayout) a(R$id.root)).setBackgroundResource(R$drawable.rect_cor_4_sd_ffffff);
    }

    public final void c(@Nullable Integer num) {
        int intValue = num != null ? num.intValue() : 0;
        if (intValue > 0) {
            setVisibility(0);
            e(intValue);
            f(intValue);
            d(intValue);
            b();
            return;
        }
        setVisibility(8);
    }

    public final void d(int i10) {
        if (i10 <= 1) {
            ((TextView) a(R$id.super_like_you_count)).setVisibility(8);
            ((TextView) a(R$id.super_like_you_mul)).setVisibility(8);
            return;
        }
        h hVar = h.f18669a;
        Context context = getContext();
        s.h(context, "context");
        int c4 = hVar.c(context, i10);
        int i11 = R$id.super_like_you_count;
        ((TextView) a(i11)).setVisibility(0);
        int i12 = R$id.super_like_you_mul;
        ((TextView) a(i12)).setVisibility(0);
        ((TextView) a(i11)).setTextSize(this.f18646c.getCountTxtSize());
        ((TextView) a(i12)).setTextSize(this.f18646c.getCountTxtSize());
        ((TextView) a(i11)).setText(String.valueOf(i10));
        ((TextView) a(i11)).setTextColor(c4);
        ((TextView) a(i12)).setTextColor(c4);
    }

    public final void e(int i10) {
        int f10 = h.f18669a.f(i10);
        int i11 = R$id.super_like_tag;
        ImageView super_like_tag = (ImageView) a(i11);
        s.h(super_like_tag, "super_like_tag");
        y.n(super_like_tag, Integer.valueOf(this.f18646c.getIconSize()), Integer.valueOf(this.f18646c.getIconSize()));
        ((ImageView) a(i11)).setImageResource(f10);
    }

    public final void f(int i10) {
        String string;
        h hVar = h.f18669a;
        Context context = getContext();
        s.h(context, "context");
        List<Integer> e2 = hVar.e(context, i10);
        int i11 = R$id.super_like_you;
        TextView textView = (TextView) a(i11);
        if (this.f18645b == SuperLikeType.SUPER_LIKE_BY_ME) {
            string = getContext().getString(R$string.super_like);
        } else {
            string = getContext().getString(R$string.super_like_you);
        }
        textView.setText(string);
        ((TextView) a(i11)).setTextSize(this.f18646c.getTxtSize());
        TextView super_like_you = (TextView) a(i11);
        s.h(super_like_you, "super_like_you");
        u.g(super_like_you, e2);
    }

    public final void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SuperLikeTagView);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…yleable.SuperLikeTagView)");
        this.f18646c = i(obtainStyledAttributes.getInteger(0, SuperLikeSize.SMALL.getValue()));
        this.f18645b = j(obtainStyledAttributes.getInteger(1, SuperLikeType.SUPER_LIKE_ME.getValue()));
        obtainStyledAttributes.recycle();
        z.a(this, R$layout.layout_super_like_you_tag, true);
        setVisibility(8);
        setBackgroundColor(0);
    }

    public final SuperLikeSize i(int i10) {
        SuperLikeSize superLikeSize = SuperLikeSize.SuperBIG;
        if (i10 == superLikeSize.getValue()) {
            return superLikeSize;
        }
        SuperLikeSize superLikeSize2 = SuperLikeSize.BIG;
        if (i10 == superLikeSize2.getValue()) {
            return superLikeSize2;
        }
        SuperLikeSize superLikeSize3 = SuperLikeSize.MEDIUM;
        return i10 == superLikeSize3.getValue() ? superLikeSize3 : SuperLikeSize.SMALL;
    }

    public final SuperLikeType j(int i10) {
        SuperLikeType superLikeType = SuperLikeType.SUPER_LIKE_BY_ME;
        return i10 == superLikeType.getValue() ? superLikeType : SuperLikeType.SUPER_LIKE_ME;
    }

    public final void setCustomTagBg(@ColorInt int i10) {
        this.f18647d = Integer.valueOf(i10);
    }

    public final void setType(@NotNull SuperLikeType type) {
        s.i(type, "type");
        this.f18645b = type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikeTagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18648e = new LinkedHashMap();
        this.f18645b = SuperLikeType.SUPER_LIKE_ME;
        this.f18646c = SuperLikeSize.SMALL;
        g(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikeTagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18648e = new LinkedHashMap();
        this.f18645b = SuperLikeType.SUPER_LIKE_ME;
        this.f18646c = SuperLikeSize.SMALL;
        g(context, attributeSet);
    }
}
