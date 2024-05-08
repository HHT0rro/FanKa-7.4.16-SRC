package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RouteException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private IOException f41728a;

    /* renamed from: b, reason: collision with root package name */
    private IOException f41729b;

    public RouteException(IOException iOException) {
        super(iOException);
        this.f41728a = iOException;
        this.f41729b = iOException;
    }

    public void addConnectException(IOException iOException) {
        Util.addSuppressedIfPossible(this.f41728a, iOException);
        this.f41729b = iOException;
    }

    public IOException getFirstConnectException() {
        return this.f41728a;
    }

    public IOException getLastConnectException() {
        return this.f41729b;
    }
}
