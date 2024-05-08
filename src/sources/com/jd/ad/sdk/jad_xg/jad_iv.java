package com.jd.ad.sdk.jad_xg;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_fs.jad_cp;
import com.jd.ad.sdk.jad_ly.jad_bo;
import com.jd.ad.sdk.mdt.service.JADTouchService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: JADTouchServiceImplementor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_iv implements JADTouchService {
    public final String[] jad_an(com.jd.ad.sdk.jad_fs.jad_bo jad_boVar, String str) {
        List<String> emptyList;
        com.jd.ad.sdk.jad_wj.jad_fs jad_cp = jad_bo.jad_an.jad_an.jad_cp(str);
        if (jad_cp != null) {
            emptyList = jad_cp.jad_jw;
        } else {
            emptyList = Collections.emptyList();
        }
        if (emptyList == null) {
            return new String[0];
        }
        String[] strArr = (String[]) emptyList.toArray(new String[0]);
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr2[i10] = jad_boVar.jad_an(strArr[i10]);
        }
        return strArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b8 A[RETURN] */
    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int onViewClicked(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.NonNull android.view.View r8, @androidx.annotation.NonNull java.lang.String r9) {
        /*
            r6 = this;
            com.jd.ad.sdk.jad_fs.jad_cp r8 = com.jd.ad.sdk.jad_fs.jad_cp.jad_an.jad_an
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.jd.ad.sdk.jad_fs.jad_bo> r8 = r8.jad_an
            java.lang.Object r8 = r8.get(r9)
            com.jd.ad.sdk.jad_fs.jad_bo r8 = (com.jd.ad.sdk.jad_fs.jad_bo) r8
            if (r8 == 0) goto Ld
            goto Le
        Ld:
            r8 = 0
        Le:
            r0 = -2
            if (r8 != 0) goto L12
            return r0
        L12:
            com.jd.ad.sdk.jad_ly.jad_cp r1 = com.jd.ad.sdk.jad_ly.jad_cp.jad_an.jad_an
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r1 = r1.jad_an
            java.lang.Object r9 = r1.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r2 = ""
            if (r1 == 0) goto L25
            r9 = r2
        L25:
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 == 0) goto L2c
            return r0
        L2c:
            com.jd.ad.sdk.jad_ly.jad_bo r0 = com.jd.ad.sdk.jad_ly.jad_bo.jad_an.jad_an
            com.jd.ad.sdk.jad_wj.jad_fs r1 = r0.jad_cp(r9)
            if (r1 == 0) goto L3f
            java.lang.String r3 = r1.jad_dq
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L3f
            java.lang.String r1 = r1.jad_dq
            goto L40
        L3f:
            r1 = r2
        L40:
            com.jd.ad.sdk.jad_wj.jad_fs r3 = r0.jad_cp(r9)
            if (r3 == 0) goto L51
            java.lang.String r4 = r3.jad_cp
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L51
            java.lang.String r3 = r3.jad_cp
            goto L52
        L51:
            r3 = r2
        L52:
            com.jd.ad.sdk.jad_wj.jad_fs r0 = r0.jad_cp(r9)
            if (r0 == 0) goto L62
            java.lang.String r4 = r0.jad_kx
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L62
            java.lang.String r2 = r0.jad_kx
        L62:
            java.lang.String r0 = "1"
            boolean r4 = r0.equals(r2)
            r5 = 1
            if (r4 == 0) goto L85
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L85
            java.lang.String r1 = r8.jad_an(r1)
            boolean r1 = com.jd.ad.sdk.jad_er.jad_an.jad_an(r7, r1)
            if (r1 == 0) goto L85
            com.jd.ad.sdk.jad_vi.jad_iv r7 = com.jd.ad.sdk.jad_vi.jad_iv.jad_cp.jad_an
            java.lang.String[] r8 = r6.jad_an(r8, r9)
            r7.jad_an(r8)
            return r5
        L85:
            boolean r0 = r0.equals(r2)
            r1 = 2
            if (r0 == 0) goto Lba
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto Lba
            java.lang.String r0 = r8.jad_an(r3)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L9d
            return r1
        L9d:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 != 0) goto Lab
            if (r7 != 0) goto La7
            goto Lab
        La7:
            com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity.startActivity(r7, r0)     // Catch: java.lang.Exception -> Lab
            goto Lac
        Lab:
            r5 = 0
        Lac:
            if (r5 == 0) goto Lb8
            com.jd.ad.sdk.jad_vi.jad_iv r7 = com.jd.ad.sdk.jad_vi.jad_iv.jad_cp.jad_an
            java.lang.String[] r8 = r6.jad_an(r8, r9)
            r7.jad_an(r8)
            return r2
        Lb8:
            r7 = 3
            return r7
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_xg.jad_iv.onViewClicked(android.content.Context, android.view.View, java.lang.String):int");
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void onViewTouch(@NonNull View view, @NonNull MotionEvent motionEvent, @NonNull String str) {
        com.jd.ad.sdk.jad_fs.jad_an jad_anVar;
        com.jd.ad.sdk.jad_fs.jad_bo jad_boVar = jad_cp.jad_an.jad_an.jad_an.get(str);
        if (jad_boVar == null) {
            jad_boVar = null;
        }
        if (jad_boVar == null || (jad_anVar = jad_boVar.jad_an) == null || motionEvent == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (jad_anVar.jad_an.size() > 999) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(jad_anVar.jad_an.get(0));
                        arrayList.addAll(jad_anVar.jad_an.subList(r0.size() - 399, jad_anVar.jad_an.size()));
                        jad_anVar.jad_an.clear();
                        jad_anVar.jad_an.addAll(arrayList);
                        arrayList.clear();
                    }
                    jad_anVar.jad_an.add(new com.jd.ad.sdk.jad_fs.jad_dq(new Double(motionEvent.getX()).intValue(), new Double(motionEvent.getY()).intValue(), System.currentTimeMillis()));
                    return;
                }
                if (action != 3) {
                    return;
                }
            }
            jad_anVar.jad_cp = new com.jd.ad.sdk.jad_fs.jad_dq(new Double(motionEvent.getX()).intValue(), new Double(motionEvent.getY()).intValue(), System.currentTimeMillis());
            return;
        }
        jad_anVar.jad_an.clear();
        jad_anVar.jad_bo = new com.jd.ad.sdk.jad_fs.jad_dq(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()), System.currentTimeMillis());
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void registerTouchView(@NonNull String str) {
        com.jd.ad.sdk.jad_fs.jad_cp jad_cpVar = jad_cp.jad_an.jad_an;
        if (jad_cpVar.jad_an.get(str) == null) {
            jad_cpVar.jad_an.put(str, new com.jd.ad.sdk.jad_fs.jad_bo());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void unregisterTouchView(@NonNull String str) {
        com.jd.ad.sdk.jad_fs.jad_cp jad_cpVar = jad_cp.jad_an.jad_an;
        if (jad_cpVar.jad_an.get(str) != null) {
            jad_cpVar.jad_an.remove(str);
        }
    }
}
