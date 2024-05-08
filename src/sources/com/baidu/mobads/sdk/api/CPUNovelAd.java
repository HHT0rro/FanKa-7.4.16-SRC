package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.db;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CPUNovelAd {
    private db mCpuNovelProd;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface CpuNovelListener {
        void onAdClick();

        void onAdImpression();

        void onReadTime(long j10);
    }

    public CPUNovelAd(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam, CpuNovelListener cpuNovelListener) {
        db dbVar = new db(context, str, cPUWebAdRequestParam);
        this.mCpuNovelProd = dbVar;
        dbVar.a(cpuNovelListener);
        this.mCpuNovelProd.a();
    }

    public void destory() {
        db dbVar = this.mCpuNovelProd;
        if (dbVar != null) {
            dbVar.y();
        }
    }

    public View getNovelView() {
        return this.mCpuNovelProd.w();
    }
}
