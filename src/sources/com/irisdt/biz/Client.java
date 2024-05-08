package com.irisdt.biz;

import com.google.protobuf.Any;
import com.google.protobuf.Message;
import com.irisdt.StatConfig;
import com.irisdt.client.ClientProtos;
import com.irisdt.grpc.connect.ClientManager;
import com.irisdt.util.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class Client {
    private int batchSize;
    private boolean localCacheEnable;
    private int minUploadInterval;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final Client INSTANCE = new Client();

        private InstanceHolder() {
        }
    }

    public static Client getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public int getBatchSize() {
        return this.batchSize;
    }

    public int getMinUploadInterval() {
        return this.minUploadInterval;
    }

    public boolean isLocalCacheEnable() {
        return this.localCacheEnable;
    }

    public void send(Message message, long j10, String str) {
        if (message == null) {
            return;
        }
        try {
            ClientManager.getInstance().record(ClientProtos.Request.newBuilder().setClientTime(System.currentTimeMillis()).setExtra(Any.pack(message)).setUid(j10).setUidStr(Utils.getStringValue(str)).build());
        } catch (Exception unused) {
        }
    }

    public void setBatchSize(int i10) {
        if (i10 <= 1) {
            this.batchSize = 1;
        } else if (i10 <= 100) {
            this.batchSize = i10;
        }
    }

    public void setEnable(boolean z10) {
        StatConfig.setClientEnable(z10);
    }

    public void setLocalCacheEnable(boolean z10) {
        this.localCacheEnable = z10;
    }

    public void setLogEnable(boolean z10) {
        StatConfig.setClientLogEnable(z10);
    }

    public void setMinUploadInterval(int i10) {
        this.minUploadInterval = Math.max(i10, 1000);
    }

    private Client() {
        this.batchSize = 30;
        this.minUploadInterval = 5000;
        this.localCacheEnable = true;
    }

    public void send(String str, long j10, String str2) {
        if (str == null) {
            return;
        }
        try {
            ClientManager.getInstance().record(ClientProtos.Request.newBuilder().setClientTime(System.currentTimeMillis()).setExtraStr(str).setUid(j10).setUidStr(Utils.getStringValue(str2)).build());
        } catch (Exception unused) {
        }
    }
}
