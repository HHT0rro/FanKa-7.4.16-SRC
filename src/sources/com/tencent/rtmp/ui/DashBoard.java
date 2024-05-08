package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DashBoard extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f45339a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f45340b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f45341c;

    /* renamed from: d, reason: collision with root package name */
    private final SimpleDateFormat f45342d;

    /* renamed from: e, reason: collision with root package name */
    private ScrollView f45343e;

    /* renamed from: f, reason: collision with root package name */
    private int f45344f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f45345g;

    public DashBoard(Context context) {
        this(context, null);
    }

    public final void a(int i10, int i11, int i12, int i13) {
        TextView textView = this.f45340b;
        if (textView != null) {
            textView.setPadding(i10, i11, i12, 0);
        }
        ScrollView scrollView = this.f45343e;
        if (scrollView != null) {
            scrollView.setPadding(i10, 0, i12, i13);
        }
    }

    public void setEventTextSize(float f10) {
        TextView textView = this.f45341c;
        if (textView != null) {
            textView.setTextSize(f10);
        }
    }

    public void setMessageMaxLength(int i10) {
        this.f45344f = i10;
    }

    public void setShowLevel(int i10) {
        if (i10 == 0) {
            TextView textView = this.f45340b;
            if (textView != null) {
                textView.setVisibility(4);
            }
            ScrollView scrollView = this.f45343e;
            if (scrollView != null) {
                scrollView.setVisibility(4);
            }
            setVisibility(4);
            return;
        }
        if (i10 != 1) {
            a();
            this.f45340b.setVisibility(0);
            this.f45343e.setVisibility(0);
            setVisibility(0);
            return;
        }
        a();
        this.f45340b.setVisibility(0);
        this.f45343e.setVisibility(4);
        setVisibility(0);
    }

    public void setStatusText(CharSequence charSequence) {
        TextView textView = this.f45340b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setStatusTextSize(float f10) {
        TextView textView = this.f45340b;
        if (textView != null) {
            textView.setTextSize(f10);
        }
    }

    public DashBoard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f45339a = new StringBuilder();
        this.f45342d = new SimpleDateFormat("HH:mm:ss.SSS", Locale.ENGLISH);
        this.f45344f = 3000;
        this.f45345g = false;
        setOrientation(1);
        setVisibility(8);
    }

    private void a() {
        if (this.f45340b != null) {
            return;
        }
        this.f45340b = new TextView(getContext());
        this.f45341c = new TextView(getContext());
        this.f45343e = new ScrollView(getContext());
        this.f45340b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f45340b.setTextColor(-49023);
        this.f45340b.setTypeface(Typeface.MONOSPACE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f45343e.setPadding(0, 10, 0, 0);
        this.f45343e.setLayoutParams(layoutParams);
        this.f45343e.setVerticalScrollBarEnabled(true);
        this.f45343e.setScrollbarFadingEnabled(true);
        this.f45341c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f45341c.setTextColor(-49023);
        this.f45343e.addView(this.f45341c);
        addView(this.f45340b);
        addView(this.f45343e);
        if (this.f45339a.length() <= 0) {
            this.f45339a.append("liteav sdk version:\n");
        }
        this.f45341c.setText(this.f45339a.toString());
    }
}
