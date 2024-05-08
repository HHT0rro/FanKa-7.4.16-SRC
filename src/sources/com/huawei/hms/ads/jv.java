package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.SourceParam;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class jv extends ju<lk> implements kh {
    public jv(Context context, lk lkVar) {
        super(context, lkVar);
    }

    @Override // com.huawei.hms.ads.ju
    public void V(final String str) {
        ((lk) I()).B();
        gl.V("PPSImageViewPresenter", "onMaterialLoaded - begin to load image");
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(str);
        sourceParam.Code(this.Code);
        com.huawei.openalliance.ad.utils.y.Code(((ju) this).V, sourceParam, new com.huawei.openalliance.ad.utils.aj() { // from class: com.huawei.hms.ads.jv.1
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                gl.V("PPSImageViewPresenter", "onMaterialLoaded - image load failed");
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jv.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((lk) jv.this.I()).Code(-9);
                    }
                });
                jv jvVar = jv.this;
                jvVar.V(jvVar.Code);
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str2, final Drawable drawable) {
                if (TextUtils.equals(str2, str)) {
                    gl.V("PPSImageViewPresenter", "onMaterialLoaded - image load success");
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jv.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((lk) jv.this.I()).Code(drawable);
                            ((lk) jv.this.I()).Z();
                        }
                    });
                } else {
                    Code();
                    jv jvVar = jv.this;
                    eo.Code(((ju) jvVar).V, 5, "url not equals filePath", jvVar.Code);
                }
            }
        });
    }
}
