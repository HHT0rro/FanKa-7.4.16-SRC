package com.huawei.hms.ml.scan;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.mlsdk.common.MLAnalyzer;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p.o4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import z8.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HmsScanAnalyzer extends MLAnalyzer<HmsScan> {
    private static final String TAG = "HmsScanAnalyzer";
    private Context mContext;
    private HmsScanAnalyzerOptions mlVisionScanDetectorOptions;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Creator {
        private Context mContext;
        private HmsScanAnalyzerOptions mOptions;

        public Creator(Context context) {
            this.mContext = context;
        }

        public HmsScanAnalyzer create() {
            Context context = this.mContext;
            HmsScanAnalyzerOptions hmsScanAnalyzerOptions = this.mOptions;
            if (hmsScanAnalyzerOptions == null) {
                hmsScanAnalyzerOptions = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(0, new int[0]).create();
            }
            return new HmsScanAnalyzer(context, hmsScanAnalyzerOptions);
        }

        public Creator setHmsScanTypes(int i10, int... iArr) {
            this.mOptions = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(i10, iArr).create();
            return this;
        }

        public Creator setHmsScanTypes(HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
            if (hmsScanAnalyzerOptions == null) {
                this.mOptions = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(0, new int[0]).create();
            } else {
                this.mOptions = hmsScanAnalyzerOptions;
            }
            return this;
        }

        public Creator() {
            this.mContext = c.c().b();
        }
    }

    @Override // com.huawei.hms.mlsdk.common.MLAnalyzer
    public SparseArray<HmsScan> analyseFrame(MLFrame mLFrame) {
        o4.b("scankit mul", "start analyseFrame");
        if (mLFrame == null) {
            return new SparseArray<>();
        }
        HmsScan[] detectForHmsDector = ScanUtil.detectForHmsDector(this.mContext, mLFrame, this.mlVisionScanDetectorOptions);
        o4.b("scankit mul", "analyseFrame end");
        SparseArray<HmsScan> sparseArray = new SparseArray<>();
        for (HmsScan hmsScan : detectForHmsDector) {
            if (hmsScan != null && !TextUtils.isEmpty(hmsScan.originalValue)) {
                sparseArray.append(hmsScan.originalValue.hashCode(), hmsScan);
            }
        }
        return sparseArray;
    }

    public Task<List<HmsScan>> analyzInAsyn(final MLFrame mLFrame) {
        return Tasks.callInBackground(new Callable<List<HmsScan>>() { // from class: com.huawei.hms.ml.scan.HmsScanAnalyzer.1
            @Override // java.util.concurrent.Callable
            public List<HmsScan> call() throws Exception {
                if (mLFrame == null) {
                    return null;
                }
                HmsScan[] detectForHmsDector = ScanUtil.detectForHmsDector(HmsScanAnalyzer.this.mContext, mLFrame, HmsScanAnalyzer.this.mlVisionScanDetectorOptions);
                ArrayList arrayList = new ArrayList();
                for (HmsScan hmsScan : detectForHmsDector) {
                    if (hmsScan != null && !TextUtils.isEmpty(hmsScan.originalValue)) {
                        arrayList.add(hmsScan);
                    }
                }
                return arrayList;
            }
        });
    }

    public void destory() throws IOException {
        super.destroy();
    }

    @Override // com.huawei.hms.mlsdk.common.MLAnalyzer
    public boolean isAvailable() {
        return ScanUtil.isScanAvailable(this.mContext);
    }

    public HmsScanAnalyzer(HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        this.mContext = c.c().b();
        this.mlVisionScanDetectorOptions = hmsScanAnalyzerOptions;
    }

    public HmsScanAnalyzer() {
        if (c.c() != null) {
            this.mContext = c.c().b();
        } else {
            o4.e(TAG, "AGConnectInstanceImpl contect is null");
        }
    }

    private HmsScanAnalyzer(Context context, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        this.mContext = context;
        this.mlVisionScanDetectorOptions = hmsScanAnalyzerOptions;
    }
}
