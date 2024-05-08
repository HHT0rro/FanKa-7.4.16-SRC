package com.huawei.hmf.orb.exception;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ConnectRemoteException extends Exception {
    private Status mStatus;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Status {
        NotFoundService,
        UnableBindService,
        RejectBindService,
        UnknownConnector,
        NotFoundRepository
    }

    public ConnectRemoteException(Status status, String str) {
        super(str);
        this.mStatus = status;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public ConnectRemoteException(Status status) {
        this(status, null);
    }
}
