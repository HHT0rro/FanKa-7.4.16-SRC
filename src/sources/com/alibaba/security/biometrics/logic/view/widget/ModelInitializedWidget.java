package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.build.w;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ModelInitializedWidget extends BaseWidget {

    /* renamed from: b, reason: collision with root package name */
    public TextView f2533b;

    /* renamed from: c, reason: collision with root package name */
    public ProgressBar f2534c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f2535d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f2536e;

    public ModelInitializedWidget(Context context) {
        super(context);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void a() {
        this.f2535d = (TextView) findViewById(R.id.abfl_widget_init_main_title);
        this.f2536e = (TextView) findViewById(R.id.abfl_widget_init_sub_title);
        this.f2533b = (TextView) findViewById(R.id.abfl_widget_init_progress_tv);
        this.f2534c = (ProgressBar) findViewById(R.id.abfl_widget_init_progress_bar);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void b() {
        w.a(this.f2533b, d("progressText"));
        w.a(this.f2536e, d("subHintText"));
        w.a(this.f2533b, d("mainHintText"));
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public String getSkinParentKey() {
        return "loadPage";
    }

    public final void h() {
        b();
        setVisibility(0);
    }

    public final void i() {
        b();
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.f2535d.setText(context.getString(R.string.face_init_net_connecting_error));
        this.f2536e.setText(context.getString(R.string.face_liveness_upload_fail_msg));
        TextView textView = this.f2535d;
        Resources resources = context.getResources();
        int i10 = R.color.rpsdk_progress_error;
        textView.setTextColor(resources.getColor(i10));
        this.f2536e.setTextColor(context.getResources().getColor(i10));
    }

    public ModelInitializedWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ModelInitializedWidget(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    private void a(int i10) {
        this.f2534c.setProgress(i10);
        this.f2533b.setText(String.format(getContext().getString(R.string.face_init_progress), Integer.valueOf(i10)));
    }
}
