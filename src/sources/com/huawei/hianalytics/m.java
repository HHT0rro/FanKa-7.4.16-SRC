package com.huawei.hianalytics;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class m {
    public static m klm;
    public Context lmn;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class lmn extends n {
        public String klm;
        public String lmn;

        public lmn(String str, String str2) {
            this.lmn = str;
            this.klm = str2;
        }

        @Override // com.huawei.hianalytics.n
        public int lmn() {
            x klm = d.klm(this.lmn, this.klm);
            int i10 = (klm != null && klm.ikl ? 4 : 0) | 0;
            x klm2 = d.klm(this.lmn, this.klm);
            int i11 = i10 | (klm2 != null && klm2.lmn ? 2 : 0);
            x klm3 = d.klm(this.lmn, this.klm);
            return i11 | ((klm3 == null || !klm3.klm) ? 0 : 1);
        }
    }

    public static m lmn() {
        m mVar;
        synchronized (m.class) {
            if (klm == null) {
                klm = new m();
            }
            mVar = klm;
        }
        return mVar;
    }
}
