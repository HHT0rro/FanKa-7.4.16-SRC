package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.views.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c extends a {
    public c(Context context) {
        super(context);
        this.V.Code(context.getResources().getDrawable(R.drawable.hiad_app_down_btn_normal_hm));
        a.C0341a c0341a = this.V;
        Resources resources = context.getResources();
        int i10 = R.color.hiad_emui_white;
        c0341a.Code(resources.getColor(i10));
        LayerDrawable layerDrawable = (LayerDrawable) Code(context, R.drawable.hiad_app_down_btn_processing_hm);
        Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301);
        if (findDrawableByLayerId instanceof ClipDrawable) {
            h hVar = new h(findDrawableByLayerId, 17, 1);
            layerDrawable.mutate();
            layerDrawable.setDrawableByLayerId(16908301, hVar);
            this.I.Code(layerDrawable);
        } else {
            gl.I("ExtandAppDownloadButtonStyleHm", "not clipDrawable");
            this.I.Code(Code(context, R.drawable.hiad_app_down_btn_processing));
        }
        this.I.Code(context.getResources().getColor(R.color.hiad_emui_black));
        LayerDrawable layerDrawable2 = (LayerDrawable) Code(context, R.drawable.hiad_app_down_btn_installing_hm);
        if (layerDrawable2.findDrawableByLayerId(16908301) instanceof ClipDrawable) {
            f fVar = new f(v.V(context, 18.0f));
            layerDrawable2.mutate();
            layerDrawable2.setDrawableByLayerId(16908301, fVar);
            this.Z.Code(layerDrawable2);
            fVar.Code();
        } else {
            gl.I("ExtandAppDownloadButtonStyleHm", "not clipDrawable");
            this.Z.Code(Code(context, R.drawable.hiad_app_down_btn_installing));
        }
        this.Z.Code(context.getResources().getColor(i10));
    }
}
