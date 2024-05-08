package com.jd.ad.sdk.jad_iv;

import android.graphics.Rect;
import android.os.Message;
import android.view.View;
import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.jad_iv.jad_er;
import com.jd.ad.sdk.jad_jt.jad_iv;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ExposureManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_dq implements jad_er.jad_an {
    public WeakReference<View> jad_an;
    public jad_er jad_bo;
    public volatile JADExposureListener jad_cp;
    public int jad_dq;
    public final com.jd.ad.sdk.jad_wj.jad_bo jad_er = new com.jd.ad.sdk.jad_wj.jad_bo();
    public WeakReference<String> jad_fs;

    @Override // com.jd.ad.sdk.jad_iv.jad_er.jad_an
    public void jad_an(Message message) {
        com.jd.ad.sdk.jad_wj.jad_bo jad_boVar;
        int i10;
        int jad_an;
        com.jd.ad.sdk.jad_wj.jad_bo jad_boVar2;
        int jad_an2;
        int i11;
        int i12 = message.what;
        int i13 = 0;
        if (i12 == 1) {
            View jad_bo = jad_bo();
            if (jad_bo == null) {
                jad_er jad_erVar = this.jad_bo;
                if (jad_erVar != null) {
                    jad_erVar.removeCallbacksAndMessages(null);
                    return;
                }
                return;
            }
            if (jad_bo.getVisibility() != 0) {
                jad_er jad_erVar2 = this.jad_bo;
                if (jad_erVar2 != null) {
                    jad_erVar2.sendEmptyMessageDelayed(1, 1000L);
                    return;
                }
                return;
            }
            if (this.jad_cp != null && (jad_boVar = this.jad_er) != null && !jad_boVar.jad_an) {
                Rect rect = new Rect();
                if (jad_bo.getGlobalVisibleRect(rect)) {
                    int width = rect.width();
                    int height = rect.height();
                    i10 = width;
                    i13 = height;
                } else {
                    i10 = 0;
                }
                int i14 = this.jad_dq;
                int width2 = jad_bo.getWidth();
                int height2 = jad_bo.getHeight();
                if (i14 == 1) {
                    int screenWidth = JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
                    int screenHeight = JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
                    jad_an = jad_iv.jad_an(height2 * width2, screenWidth * screenHeight);
                    i13 = height2;
                    height2 = screenHeight;
                    i10 = width2;
                    width2 = screenWidth;
                } else {
                    jad_an = jad_iv.jad_an(i13 * i10, width2 * height2);
                }
                JADExposureListener jADExposureListener = this.jad_cp;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visible_area", jad_an);
                    jSONObject.put("width", width2);
                    jSONObject.put("height", height2);
                    jSONObject.put("visible_width", i10);
                    jSONObject.put("visible_height", i13);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jADExposureListener.onPreExposure(jSONObject.toString());
                this.jad_er.jad_an = true;
            }
            jad_er jad_erVar3 = this.jad_bo;
            if (jad_erVar3 != null) {
                jad_erVar3.sendEmptyMessage(2);
                return;
            }
            return;
        }
        if (i12 != 2) {
            if (i12 == 3) {
                View jad_bo2 = jad_bo();
                if (jad_bo2 == null) {
                    jad_er jad_erVar4 = this.jad_bo;
                    if (jad_erVar4 != null) {
                        jad_erVar4.removeCallbacksAndMessages(null);
                        return;
                    }
                    return;
                }
                if (jad_bo2.getVisibility() != 0) {
                    jad_er jad_erVar5 = this.jad_bo;
                    if (jad_erVar5 != null) {
                        jad_erVar5.sendEmptyMessage(1);
                        return;
                    }
                    return;
                }
                if (!jad_an()) {
                    jad_er jad_erVar6 = this.jad_bo;
                    if (jad_erVar6 != null) {
                        jad_erVar6.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    }
                    return;
                }
                jad_er jad_erVar7 = this.jad_bo;
                if (jad_erVar7 != null) {
                    jad_erVar7.sendEmptyMessageDelayed(4, 1000L);
                    return;
                }
                return;
            }
            if (i12 != 4) {
                return;
            }
            View jad_bo3 = jad_bo();
            if (jad_bo3 == null) {
                jad_er jad_erVar8 = this.jad_bo;
                if (jad_erVar8 != null) {
                    jad_erVar8.removeCallbacksAndMessages(null);
                    return;
                }
                return;
            }
            if (jad_bo3.getVisibility() != 0) {
                jad_er jad_erVar9 = this.jad_bo;
                if (jad_erVar9 != null) {
                    jad_erVar9.sendEmptyMessage(1);
                    return;
                }
                return;
            }
            if (!jad_an()) {
                jad_er jad_erVar10 = this.jad_bo;
                if (jad_erVar10 != null) {
                    jad_erVar10.sendEmptyMessageDelayed(3, 1000L);
                    return;
                }
                return;
            }
            com.jd.ad.sdk.jad_wj.jad_bo jad_boVar3 = this.jad_er;
            if (jad_boVar3 != null && !jad_boVar3.jad_cp) {
                jad_an(false, CommonConstants.ExposureType.EXPOSURE_VALID.getIndex());
            }
            jad_er jad_erVar11 = this.jad_bo;
            if (jad_erVar11 != null) {
                jad_erVar11.removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        View jad_bo4 = jad_bo();
        if (jad_bo4 == null) {
            jad_er jad_erVar12 = this.jad_bo;
            if (jad_erVar12 != null) {
                jad_erVar12.removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        if (jad_bo4.getVisibility() != 0) {
            jad_er jad_erVar13 = this.jad_bo;
            if (jad_erVar13 != null) {
                jad_erVar13.sendEmptyMessage(1);
                return;
            }
            return;
        }
        if (!jad_cp()) {
            jad_er jad_erVar14 = this.jad_bo;
            if (jad_erVar14 != null) {
                jad_erVar14.sendEmptyMessageDelayed(2, 1000L);
                return;
            }
            return;
        }
        if (this.jad_cp != null && (jad_boVar2 = this.jad_er) != null && !jad_boVar2.jad_bo) {
            Rect rect2 = new Rect();
            jad_bo4.getGlobalVisibleRect(rect2);
            int i15 = this.jad_dq;
            int width3 = rect2.width();
            int height3 = rect2.height();
            int width4 = jad_bo4.getWidth();
            int height4 = jad_bo4.getHeight();
            if (i15 == 1) {
                int screenWidth2 = JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
                int screenHeight2 = JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
                jad_an2 = jad_iv.jad_an(height4 * width4, screenWidth2 * screenHeight2);
                height3 = height4;
                height4 = screenHeight2;
                i11 = screenWidth2;
            } else {
                jad_an2 = jad_iv.jad_an(height3 * width3, width4 * height4);
                i11 = width4;
                width4 = width3;
            }
            JADExposureListener jADExposureListener2 = this.jad_cp;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("visible_area", jad_an2);
                jSONObject2.put("width", i11);
                jSONObject2.put("height", height4);
                jSONObject2.put("visible_width", width4);
                jSONObject2.put("visible_height", height3);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            jADExposureListener2.onExposure(jSONObject2.toString());
            this.jad_er.jad_bo = true;
        }
        jad_er jad_erVar15 = this.jad_bo;
        if (jad_erVar15 != null) {
            jad_erVar15.sendEmptyMessage(3);
        }
    }

    public final View jad_bo() {
        WeakReference<View> weakReference = this.jad_an;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final boolean jad_cp() {
        View jad_bo = jad_bo();
        if (jad_bo == null) {
            return false;
        }
        Rect rect = new Rect();
        return jad_bo.getGlobalVisibleRect(rect) && rect.width() >= 1 && rect.height() >= 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        if (r2 == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void jad_an(boolean r12, int r13) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_iv.jad_dq.jad_an(boolean, int):void");
    }

    public final boolean jad_an() {
        int jad_an;
        if (this.jad_dq == 1) {
            return jad_cp();
        }
        View jad_bo = jad_bo();
        if (jad_bo != null) {
            Rect rect = new Rect();
            if (jad_bo.getGlobalVisibleRect(rect)) {
                int i10 = this.jad_dq;
                int width = rect.width();
                int height = rect.height();
                int width2 = jad_bo.getWidth();
                int height2 = jad_bo.getHeight();
                if (i10 == 1) {
                    jad_an = jad_iv.jad_an(height2 * width2, JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_do.jad_bo.jad_an()) * JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_do.jad_bo.jad_an()));
                    width = width2;
                } else {
                    jad_an = jad_iv.jad_an(height * width, width2 * height2);
                    height2 = height;
                }
                if (i10 != 1 ? jad_an >= 50 : !(width < 1 || height2 < 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
