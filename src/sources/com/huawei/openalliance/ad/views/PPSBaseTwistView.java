package com.huawei.openalliance.ad.views;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import com.huawei.hms.ads.fs;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.utils.v;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSBaseTwistView extends PPSBaseStyleView {
    public ImageView F;

    public PPSBaseTwistView(Context context) {
        super(context);
    }

    public PPSBaseTwistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSBaseTwistView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (this.F == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new fs(0.33f, 0.0f, 0.67f, 1.0f));
        ArrayList arrayList = new ArrayList(4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.F, Key.ROTATION, 0.0f, -7.0f);
        ofFloat.setDuration(150L);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.F, Key.ROTATION, -7.0f, 7.0f);
        ofFloat2.setDuration(400L);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.F, Key.ROTATION, 7.0f, -4.5f);
        ofFloat3.setDuration(350L);
        arrayList.add(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.F, Key.ROTATION, -4.5f, 2.0f);
        ofFloat4.setDuration(350L);
        arrayList.add(ofFloat4);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.F, Key.ROTATION, 2.0f, 0.0f);
        ofFloat5.setDuration(250L);
        arrayList.add(ofFloat5);
        this.F.invalidate();
        animatorSet.playSequentially(arrayList);
        animatorSet.start();
    }

    public String getViewTag() {
        return "PPSBaseStyleView";
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        gl.V(getViewTag(), "w=%s, h=%s, oldw=%s, oldh=%s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
        this.F.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSBaseTwistView.1
            @Override // java.lang.Runnable
            public void run() {
                gl.V(PPSBaseTwistView.this.getViewTag(), "imageView %s %s", Integer.valueOf(PPSBaseTwistView.this.F.getWidth()), Integer.valueOf(PPSBaseTwistView.this.F.getHeight()));
                PPSBaseTwistView.this.F.setPivotX(r0.getWidth() / 2.0f);
                PPSBaseTwistView.this.F.setPivotY(r0.getHeight() + v.V(PPSBaseTwistView.this.getContext(), 80.0f));
                PPSBaseTwistView.this.V();
            }
        });
    }
}
