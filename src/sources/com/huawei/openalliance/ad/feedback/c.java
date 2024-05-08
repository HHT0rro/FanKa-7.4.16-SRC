package com.huawei.openalliance.ad.feedback;

import android.view.View;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.utils.aa;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {
    private int I;
    private final List<View> V = new ArrayList();
    private int Z = 0;

    public int Code() {
        return this.I;
    }

    public void Code(int i10) {
        this.Z = i10;
    }

    public void Code(int i10, int i11, int i12, int i13, int i14, int i15) {
        if (aa.Code(this.V)) {
            return;
        }
        if (i10 == -1) {
            int i16 = i12 + (i14 - this.Z) + i11 + i15;
            for (int size = this.V.size() - 1; size >= 0; size--) {
                this.V.get(size).layout(i16, i13, this.V.get(size).getMeasuredWidth() + i16, this.V.get(size).getMeasuredHeight() + i13);
                i16 += this.V.get(size).getMeasuredWidth() + i15;
            }
            return;
        }
        if (i10 == 0) {
            int size2 = ((((this.V.size() - 1) * i15) + i14) - this.Z) / (this.V.size() + 1);
            for (View view : this.V) {
                int i17 = i12 + size2;
                view.layout(i17, i13, view.getMeasuredWidth() + i17, view.getMeasuredHeight() + i13);
                i12 = i17 + view.getMeasuredWidth();
            }
            return;
        }
        if (i10 != 1) {
            gl.V("FlowLayoutLine", "lineMode error");
            return;
        }
        for (View view2 : this.V) {
            view2.layout(i12, i13, view2.getMeasuredWidth() + i12, view2.getMeasuredHeight() + i13);
            i12 += view2.getMeasuredWidth() + i15;
        }
    }

    public void Code(View view) {
        this.V.add(view);
        if (this.I < view.getMeasuredHeight()) {
            this.I = view.getMeasuredHeight();
        }
    }
}
