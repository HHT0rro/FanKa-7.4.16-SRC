package com.jd.ad.sdk.jad_fs;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils;
import com.jd.ad.sdk.jad_vi.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JADTouchListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_bo {
    public jad_an jad_an;

    public jad_bo() {
        this.jad_an = null;
        this.jad_an = new jad_an();
    }

    public String jad_an(@NonNull String str) {
        String str2;
        String replaceAll;
        String sb2;
        String sb3;
        jad_dq jad_dqVar;
        jad_dq jad_dqVar2;
        jad_dq jad_dqVar3;
        jad_an jad_anVar = this.jad_an;
        if (jad_anVar == null) {
            return str;
        }
        try {
            int size = jad_anVar.jad_an.size();
            jad_dq jad_dqVar4 = jad_anVar.jad_bo;
            long j10 = 0;
            long j11 = (jad_dqVar4 == null || (jad_dqVar3 = jad_anVar.jad_cp) == null) ? 0L : jad_dqVar3.jad_an - jad_dqVar4.jad_an;
            if (jad_anVar.jad_an.size() > 0 && (jad_dqVar = jad_anVar.jad_an.get(0)) != null && (jad_dqVar2 = jad_anVar.jad_cp) != null) {
                j10 = jad_dqVar2.jad_an - jad_dqVar.jad_an;
            }
            String str3 = "|" + size + "," + j11 + "," + j10 + "," + JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_do.jad_bo.jad_an()) + "," + JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
            ArrayList arrayList = new ArrayList();
            if (jad_anVar.jad_an.size() > 400) {
                int size2 = jad_anVar.jad_an.size();
                arrayList.add(jad_anVar.jad_an.get(0));
                arrayList.addAll(jad_anVar.jad_an.subList(size2 - 399, size2));
            } else {
                arrayList.addAll(jad_anVar.jad_an);
            }
            String jad_an = jad_anVar.jad_an(arrayList, jad_anVar.jad_an.size() > 10 ? (int) Math.floor(jad_anVar.jad_an.size() / 10) : 1);
            if (jad_anVar.jad_bo != null && jad_anVar.jad_an.isEmpty()) {
                List<jad_dq> list = jad_anVar.jad_an;
                jad_dq jad_dqVar5 = jad_anVar.jad_bo;
                list.add(new jad_dq(jad_dqVar5.jad_bo, jad_dqVar5.jad_cp, jad_dqVar5.jad_an));
            }
            jad_dq jad_dqVar6 = null;
            List<jad_dq> list2 = jad_anVar.jad_an;
            if (list2 != null && list2.size() > 0) {
                List<jad_dq> list3 = jad_anVar.jad_an;
                jad_dqVar6 = list3.get(list3.size() - 1);
            }
            String str4 = str3 + jad_an + ((jad_anVar.jad_cp == null || jad_dqVar6 == null) ? "" : "|" + jad_anVar.jad_cp.jad_bo + "," + jad_anVar.jad_cp.jad_cp + "," + (jad_anVar.jad_cp.jad_an - jad_dqVar6.jad_an)) + ("|" + jad_anVar.jad_an());
            Logger.d("[cheat] path resultString: " + str4);
            StringBuilder sb4 = new StringBuilder();
            if (TextUtils.isEmpty(str)) {
                sb2 = "";
            } else {
                int floor = (int) Math.floor(str.length() / 12);
                StringBuilder sb5 = new StringBuilder();
                for (int i10 = 0; i10 < 12; i10++) {
                    sb5.append(Integer.toHexString(Integer.valueOf(str.charAt(i10 * floor)).intValue() % 12));
                }
                sb2 = sb5.toString();
            }
            sb4.append(sb2);
            sb4.append(str4);
            sb3 = sb4.toString();
        } catch (Exception e2) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("getPathList Exception: ");
            jad_an2.append(e2.toString());
            Logger.d(jad_an2.toString());
        }
        if (!TextUtils.isEmpty(sb3)) {
            Logger.d("[cheat] Path all is: " + sb3);
            str2 = Base64.encodeToString(sb3.getBytes(Charset.defaultCharset()), 10);
            Logger.d("[cheat] Path all encode is: " + str2);
            if (TextUtils.isEmpty(str2)) {
            }
            replaceAll = str.replaceAll("__SDKAC__", str2);
            if (!TextUtils.isEmpty(replaceAll)) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.OPEN_JD_URL_LENGTH_EXCEEDS_4KB;
                jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(new String[0]));
            }
            return replaceAll;
        }
        str2 = "";
        if (TextUtils.isEmpty(str2) && str2.length() > 2048) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar3 = com.jd.ad.sdk.jad_uh.jad_an.URL_AC_LENGTH_EXCEEDS_2KB;
            jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(new String[0]));
            replaceAll = str;
        } else {
            replaceAll = str.replaceAll("__SDKAC__", str2);
        }
        if (!TextUtils.isEmpty(replaceAll) && replaceAll.length() > 4096) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar22 = com.jd.ad.sdk.jad_uh.jad_an.OPEN_JD_URL_LENGTH_EXCEEDS_4KB;
            jad_fs.jad_an("", jad_anVar22.jad_an, jad_anVar22.jad_an(new String[0]));
        }
        return replaceAll;
    }
}
