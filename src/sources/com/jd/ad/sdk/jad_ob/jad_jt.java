package com.jd.ad.sdk.jad_ob;

import android.content.Context;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;
import com.jd.ad.sdk.jad_ob.jad_dq;
import com.jd.ad.sdk.jad_ob.jad_er;

/* compiled from: JADRealTimeIntoUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_jt {
    public static int jad_an(Context context) {
        try {
            if (jad_dq.jad_an.jad_an.jad_an("connectionType")) {
                return com.jd.ad.sdk.jad_do.jad_jt.jad_an(context);
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static double[] jad_bo(Context context) {
        double[] dArr = jad_bo.jad_bo;
        try {
            jad_dq jad_dqVar = jad_dq.jad_an.jad_an;
            if (jad_dqVar.jad_fs) {
                return !jad_dqVar.jad_an("geo") ? dArr : jad_er.jad_an.jad_an.jad_an(context);
            }
            JADLocation jADLocation = jad_dqVar.jad_dq;
            return jADLocation != null ? jADLocation.toDoubleArray() : dArr;
        } catch (Exception unused) {
            return dArr;
        }
    }
}
