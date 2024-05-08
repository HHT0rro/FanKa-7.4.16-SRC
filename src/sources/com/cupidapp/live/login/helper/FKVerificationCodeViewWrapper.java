package com.cupidapp.live.login.helper;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKVerificationCodeViewWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKVerificationCodeViewWrapper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final TextView f16133a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16134b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16135c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final b f16136d;

    public FKVerificationCodeViewWrapper(@NotNull TextView codeView, int i10, int i11) {
        s.i(codeView, "codeView");
        this.f16133a = codeView;
        this.f16134b = i10;
        this.f16135c = i11;
        this.f16136d = new b(60);
    }

    public final void d() {
        this.f16136d.d();
        this.f16133a.setEnabled(false);
        this.f16133a.setAlpha(0.5f);
        this.f16136d.b(new Function1<Integer, p>() { // from class: com.cupidapp.live.login.helper.FKVerificationCodeViewWrapper$start$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i10) {
                TextView textView;
                TextView textView2;
                int i11;
                textView = FKVerificationCodeViewWrapper.this.f16133a;
                textView2 = FKVerificationCodeViewWrapper.this.f16133a;
                Context context = textView2.getContext();
                i11 = FKVerificationCodeViewWrapper.this.f16134b;
                textView.setText(context.getString(i11, Integer.valueOf(i10)));
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.login.helper.FKVerificationCodeViewWrapper$start$2
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
                TextView textView;
                TextView textView2;
                TextView textView3;
                int i10;
                textView = FKVerificationCodeViewWrapper.this.f16133a;
                textView.setEnabled(true);
                textView2 = FKVerificationCodeViewWrapper.this.f16133a;
                textView2.setAlpha(1.0f);
                textView3 = FKVerificationCodeViewWrapper.this.f16133a;
                i10 = FKVerificationCodeViewWrapper.this.f16135c;
                textView3.setText(i10);
            }
        });
    }

    public final void e(@ColorInt int i10, @ColorInt final int i11) {
        this.f16136d.d();
        this.f16133a.setEnabled(false);
        this.f16133a.setTextColor(i10);
        this.f16136d.b(new Function1<Integer, p>() { // from class: com.cupidapp.live.login.helper.FKVerificationCodeViewWrapper$start$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i12) {
                TextView textView;
                TextView textView2;
                int i13;
                textView = FKVerificationCodeViewWrapper.this.f16133a;
                textView2 = FKVerificationCodeViewWrapper.this.f16133a;
                Context context = textView2.getContext();
                i13 = FKVerificationCodeViewWrapper.this.f16134b;
                textView.setText(context.getString(i13, Integer.valueOf(i12)));
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.login.helper.FKVerificationCodeViewWrapper$start$4
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
                TextView textView;
                TextView textView2;
                TextView textView3;
                int i12;
                textView = FKVerificationCodeViewWrapper.this.f16133a;
                textView.setEnabled(true);
                textView2 = FKVerificationCodeViewWrapper.this.f16133a;
                textView2.setTextColor(i11);
                textView3 = FKVerificationCodeViewWrapper.this.f16133a;
                i12 = FKVerificationCodeViewWrapper.this.f16135c;
                textView3.setText(i12);
            }
        });
    }

    public final void f() {
        this.f16136d.d();
    }
}
