package com.cupidapp.live.login.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.match.view.FKClickAnimationLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LoginNextButton.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LoginNextButton extends FKClickAnimationLayout {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f16173k = new a(null);

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public ImageView f16174h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public FKSVGAImageView f16175i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16176j;

    /* compiled from: LoginNextButton.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginNextButton(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16176j = new LinkedHashMap();
        d(this, context, null, 2, null);
    }

    public static /* synthetic */ void d(LoginNextButton loginNextButton, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        loginNextButton.c(context, attributeSet);
    }

    public final void b() {
        FKSVGAImageView fKSVGAImageView = this.f16175i;
        if (fKSVGAImageView != null && fKSVGAImageView.k()) {
            setDisable(false);
            FKSVGAImageView fKSVGAImageView2 = this.f16175i;
            if (fKSVGAImageView2 != null) {
                fKSVGAImageView2.K();
            }
            FKSVGAImageView fKSVGAImageView3 = this.f16175i;
            if (fKSVGAImageView3 == null) {
                return;
            }
            fKSVGAImageView3.setVisibility(8);
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        ImageView imageView = new ImageView(context);
        this.f16174h = imageView;
        s.f(imageView);
        imageView.setImageResource(R$mipmap.icon_login_next_btn);
        View view = this.f16174h;
        s.f(view);
        addView(view, -1, -1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LoginNextButton);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.LoginNextButton)");
        int resourceId = obtainStyledAttributes.getResourceId(0, R$mipmap.icon_login_next_btn);
        ImageView imageView2 = this.f16174h;
        s.f(imageView2);
        imageView2.setImageResource(resourceId);
        obtainStyledAttributes.recycle();
        FKSVGAImageView fKSVGAImageView = new FKSVGAImageView(context);
        this.f16175i = fKSVGAImageView;
        s.f(fKSVGAImageView);
        addView(fKSVGAImageView, -1, -1);
    }

    public final void e() {
        FKSVGAImageView fKSVGAImageView = this.f16175i;
        if ((fKSVGAImageView == null || fKSVGAImageView.k()) ? false : true) {
            setDisable(true);
            FKSVGAImageView fKSVGAImageView2 = this.f16175i;
            if (fKSVGAImageView2 != null) {
                fKSVGAImageView2.setVisibility(0);
            }
            FKSVGAImageView fKSVGAImageView3 = this.f16175i;
            if (fKSVGAImageView3 != null) {
                FKSVGAImageView.F(fKSVGAImageView3, "login_next_loading.svga", null, null, 6, null);
            }
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z10) {
        super.setSelected(z10);
        if (z10) {
            ImageView imageView = this.f16174h;
            s.f(imageView);
            imageView.setAlpha(1.0f);
            setDisable(false);
            return;
        }
        ImageView imageView2 = this.f16174h;
        s.f(imageView2);
        imageView2.setAlpha(0.3f);
        setDisable(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginNextButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16176j = new LinkedHashMap();
        c(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginNextButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16176j = new LinkedHashMap();
        c(context, attributeSet);
    }
}
