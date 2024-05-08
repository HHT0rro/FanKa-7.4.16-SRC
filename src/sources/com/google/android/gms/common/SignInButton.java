package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.base.R$styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.zay;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public int f23361b;

    /* renamed from: c, reason: collision with root package name */
    public int f23362c;

    /* renamed from: d, reason: collision with root package name */
    public View f23363d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public View.OnClickListener f23364e;

    public SignInButton(@RecentlyNonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(@RecentlyNonNull View view) {
        View.OnClickListener onClickListener = this.f23364e;
        if (onClickListener == null || view != this.f23363d) {
            return;
        }
        onClickListener.onClick(this);
    }

    public final void setColorScheme(@RecentlyNonNull int i10) {
        setStyle(this.f23361b, i10);
    }

    @Override // android.view.View
    public final void setEnabled(@RecentlyNonNull boolean z10) {
        super.setEnabled(z10);
        this.f23363d.setEnabled(z10);
    }

    @Override // android.view.View
    public final void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f23364e = onClickListener;
        View view = this.f23363d;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(@RecentlyNonNull Scope[] scopeArr) {
        setStyle(this.f23361b, this.f23362c);
    }

    public final void setSize(@RecentlyNonNull int i10) {
        setStyle(i10, this.f23362c);
    }

    public final void setStyle(@RecentlyNonNull int i10, @RecentlyNonNull int i11) {
        this.f23361b = i10;
        this.f23362c = i11;
        Context context = getContext();
        View view = this.f23363d;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f23363d = r.c(context, this.f23361b, this.f23362c);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            int i12 = this.f23361b;
            int i13 = this.f23362c;
            zay zayVar = new zay(context);
            zayVar.b(context.getResources(), i12, i13);
            this.f23363d = zayVar;
        }
        addView(this.f23363d);
        this.f23363d.setEnabled(isEnabled());
        this.f23363d.setOnClickListener(this);
    }

    public SignInButton(@RecentlyNonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(@RecentlyNonNull Context context, @Nullable AttributeSet attributeSet, @RecentlyNonNull int i10) {
        super(context, attributeSet, i10);
        this.f23364e = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SignInButton, 0, 0);
        try {
            this.f23361b = obtainStyledAttributes.getInt(R$styleable.SignInButton_buttonSize, 0);
            this.f23362c = obtainStyledAttributes.getInt(R$styleable.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            setStyle(this.f23361b, this.f23362c);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Deprecated
    public final void setStyle(@RecentlyNonNull int i10, @RecentlyNonNull int i11, @RecentlyNonNull Scope[] scopeArr) {
        setStyle(i10, i11);
    }
}
