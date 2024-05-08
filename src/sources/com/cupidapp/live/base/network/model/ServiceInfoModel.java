package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ServiceInfoModel {

    @NotNull
    private String host;
    private int port;

    public ServiceInfoModel(@NotNull String host, int i10) {
        s.i(host, "host");
        this.host = host;
        this.port = i10;
    }

    public static /* synthetic */ ServiceInfoModel copy$default(ServiceInfoModel serviceInfoModel, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = serviceInfoModel.host;
        }
        if ((i11 & 2) != 0) {
            i10 = serviceInfoModel.port;
        }
        return serviceInfoModel.copy(str, i10);
    }

    @NotNull
    public final String component1() {
        return this.host;
    }

    public final int component2() {
        return this.port;
    }

    @NotNull
    public final ServiceInfoModel copy(@NotNull String host, int i10) {
        s.i(host, "host");
        return new ServiceInfoModel(host, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServiceInfoModel)) {
            return false;
        }
        ServiceInfoModel serviceInfoModel = (ServiceInfoModel) obj;
        return s.d(this.host, serviceInfoModel.host) && this.port == serviceInfoModel.port;
    }

    @NotNull
    public final String getHost() {
        return this.host;
    }

    public final int getPort() {
        return this.port;
    }

    public int hashCode() {
        return (this.host.hashCode() * 31) + this.port;
    }

    public final void setHost(@NotNull String str) {
        s.i(str, "<set-?>");
        this.host = str;
    }

    public final void setPort(int i10) {
        this.port = i10;
    }

    @NotNull
    public String toString() {
        return "ServiceInfoModel(host=" + this.host + ", port=" + this.port + ")";
    }
}
