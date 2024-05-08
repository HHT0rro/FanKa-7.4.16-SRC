package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.build.w;
import com.alibaba.security.biometrics.skin.model.NavigatorSkinData;
import com.alibaba.security.biometrics.utils.notch.NotchUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TitleBarWidget extends BaseWidget {

    /* renamed from: b, reason: collision with root package name */
    private static final String f2540b = "TitleBarWidget";

    /* renamed from: c, reason: collision with root package name */
    private ImageView f2541c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f2542d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f2543e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2544f;

    /* renamed from: g, reason: collision with root package name */
    private View.OnClickListener f2545g;

    public TitleBarWidget(Context context) {
        super(context);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void b() {
        NavigatorSkinData b4 = b("navigator");
        if (b4 != null) {
            w.a(this.f2541c, b4.getCloseImageView(), R.drawable.rp_face_top_back);
        } else {
            this.f2541c.setImageResource(R.drawable.rp_face_top_back);
        }
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void d() {
        RelativeLayout.LayoutParams layoutParams;
        if (NotchUtils.getStatusBarHeight(getContext()) <= 0 || (layoutParams = (RelativeLayout.LayoutParams) getLayoutParams()) == null) {
            return;
        }
        layoutParams.setMargins(0, NotchUtils.getStatusBarHeight(getContext()), 0, 0);
        setLayoutParams(layoutParams);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public String getSkinParentKey() {
        return "navigator";
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.f2545g = onClickListener;
    }

    public void setTitle(String str) {
        TextView textView = this.f2543e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public TitleBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void a() {
        this.f2541c = (ImageView) findViewById(R.id.abfl_widget_tb_close);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.abfl_widget_tb_close_parent);
        this.f2542d = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.TitleBarWidget.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (TitleBarWidget.this.f2545g != null) {
                    TitleBarWidget.this.f2545g.onClick(view);
                }
            }
        });
        this.f2543e = (TextView) findViewById(R.id.tvTitle);
    }

    public TitleBarWidget(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
