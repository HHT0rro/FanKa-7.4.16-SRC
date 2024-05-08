package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CrossOverlay {
    public static final int UPDATE_TYPE_DATA = 0;

    /* renamed from: a, reason: collision with root package name */
    public ICrossVectorOverlay f8202a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface GenerateCrossImageListener {
        void onGenerateComplete(Bitmap bitmap, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnCrossVectorUpdateListener {
        void onUpdate(int i10, UpdateItem updateItem);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class UpdateItem {
        public int dataUpdateFlag = -1;
    }

    public CrossOverlay(CrossOverlayOptions crossOverlayOptions, ICrossVectorOverlay iCrossVectorOverlay) {
        this.f8202a = iCrossVectorOverlay;
    }

    public void remove() {
        ICrossVectorOverlay iCrossVectorOverlay = this.f8202a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.remove();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        try {
            this.f8202a.setAttribute(aVectorCrossAttr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int setData(byte[] bArr) {
        ICrossVectorOverlay iCrossVectorOverlay;
        if (bArr == null || (iCrossVectorOverlay = this.f8202a) == null) {
            return 0;
        }
        try {
            iCrossVectorOverlay.setData(bArr);
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setGenerateCrossImageListener(GenerateCrossImageListener generateCrossImageListener) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f8202a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setGenerateCrossImageListener(generateCrossImageListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setImageMode(boolean z10) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f8202a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setImageMode(z10);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setOnCrossVectorUpdateListener(OnCrossVectorUpdateListener onCrossVectorUpdateListener) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f8202a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setOnCrossVectorUpdateListener(onCrossVectorUpdateListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setVisible(boolean z10) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f8202a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setVisible(z10);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
