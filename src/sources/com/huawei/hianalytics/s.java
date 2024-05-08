package com.huawei.hianalytics;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.LogAdapter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class s implements LogAdapter {
    public boolean lmn = false;
    public int klm = 4;
    public String ikl = "FormalHASDK";

    @Override // com.huawei.hianalytics.core.log.LogAdapter
    public void init(int i10, String str) {
        if (this.lmn) {
            return;
        }
        this.klm = i10;
        this.lmn = true;
        this.ikl = str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.lineSeparator());
        sb2.append("======================================= ");
        sb2.append(System.lineSeparator());
        sb2.append(this.ikl + "_3.0.1.501");
        sb2.append(System.lineSeparator());
        sb2.append("=======================================");
    }

    @Override // com.huawei.hianalytics.core.log.LogAdapter
    public boolean isLoggable(int i10) {
        return this.lmn && i10 >= this.klm;
    }

    public final void lmn(int i10, String str, String str2) {
        int length = str2.length();
        int i11 = 0;
        int i12 = 3000;
        for (int i13 = 0; i13 < (length / 3000) + 1; i13++) {
            if (length > i12) {
                if (i10 == 3) {
                    str2.substring(i11, i12);
                } else if (i10 == 5) {
                    str2.substring(i11, i12);
                } else if (i10 != 6) {
                    str2.substring(i11, i12);
                } else {
                    str2.substring(i11, i12);
                }
                int i14 = i12;
                i12 += 3000;
                i11 = i14;
            } else if (i10 == 3) {
                str2.substring(i11, length);
            } else if (i10 == 5) {
                str2.substring(i11, length);
            } else if (i10 != 6) {
                str2.substring(i11, length);
            } else {
                str2.substring(i11, length);
            }
        }
    }

    @Override // com.huawei.hianalytics.core.log.LogAdapter
    public void println(int i10, String str, String str2) {
        String str3 = str + "==> " + str2;
        if (TextUtils.isEmpty(this.ikl)) {
            lmn(i10, "FormalHASDK", str3);
        } else {
            lmn(i10, this.ikl, str3);
        }
    }

    @Override // com.huawei.hianalytics.core.log.LogAdapter
    public void println(int i10, String str, String str2, String str3) {
        if (TextUtils.isEmpty(this.ikl)) {
            lmn(i10, "FormalHASDK", str + "==> " + str2 + "|" + str3);
            return;
        }
        lmn(i10, this.ikl, str + "==> " + str2 + "|" + str3);
    }
}
