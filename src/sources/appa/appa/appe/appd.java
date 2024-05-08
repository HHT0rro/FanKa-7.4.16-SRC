package appa.appa.appe;

import android.content.Context;
import com.wangmai.bean.NativeProcessorBean;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: AbstractWMNativePotProcesser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public abstract class appd extends appa.appa.appa.appa {
    protected boolean autoGenerateAdLogo;

    public appd(Context context) {
        super(context);
        this.autoGenerateAdLogo = true;
    }

    public abstract void nativeAd(NativeProcessorBean nativeProcessorBean);
}
