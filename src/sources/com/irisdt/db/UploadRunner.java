package com.irisdt.db;

import com.irisdt.StatConfig;
import com.irisdt.grpc.connect.ClientManager;
import com.irisdt.grpc.connect.DauManager;
import com.irisdt.util.NetworkUtils;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class UploadRunner implements Runnable {
    private int uploadBatchSize;
    private int uploadIntervalSeconds;

    public UploadRunner(int i10, int i11) {
        this.uploadBatchSize = i10;
        this.uploadIntervalSeconds = i11;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(this.uploadIntervalSeconds);
            } catch (Exception unused) {
            }
            if (ClientManager.getInstance().isLocalCacheEnable() && NetworkUtils.isNetConnected(StatConfig.getAppContext())) {
                try {
                    ClientManager.getInstance().uploadByDB(this.uploadBatchSize);
                } catch (Exception unused2) {
                }
            }
            if (DauManager.getInstance().isLocalCacheEnable() && NetworkUtils.isNetConnected(StatConfig.getAppContext())) {
                try {
                    DauManager.getInstance().uploadByDB(this.uploadBatchSize);
                } catch (Exception unused3) {
                }
            }
        }
    }
}
