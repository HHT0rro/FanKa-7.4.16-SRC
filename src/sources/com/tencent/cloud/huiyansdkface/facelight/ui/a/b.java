package com.tencent.cloud.huiyansdkface.facelight.ui.a;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class b extends Fragment implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f40981a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutInflater f40982b;

    public <T> T a(int i10) {
        return (T) this.f40981a.findViewById(i10);
    }

    public View b(int i10) {
        View inflate = this.f40982b.inflate(i10, (ViewGroup) null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f40981a.addView(inflate);
        return this.f40981a;
    }

    public int c(int i10) {
        if (isAdded()) {
            return getResources().getColor(i10);
        }
        WLogger.e("BaseFragment", "the faceRecordFragment is not attached to Activity");
        return 0;
    }

    public String d(int i10) {
        if (isAdded()) {
            return getString(i10);
        }
        WLogger.e("BaseFragment", "the faceRecordFragment is not attached to Activity");
        return "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f40982b = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.wbcf_base_fragment_layout, viewGroup, false);
        this.f40981a = (LinearLayout) inflate.findViewById(R.id.wbcf_contain);
        q();
        return inflate;
    }

    public abstract void q();
}
