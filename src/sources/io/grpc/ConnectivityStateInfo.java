package io.grpc;

import com.google.common.base.o;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ConnectivityStateInfo {
    private final ConnectivityState state;
    private final Status status;

    private ConnectivityStateInfo(ConnectivityState connectivityState, Status status) {
        this.state = (ConnectivityState) o.s(connectivityState, "state is null");
        this.status = (Status) o.s(status, "status is null");
    }

    public static ConnectivityStateInfo forNonError(ConnectivityState connectivityState) {
        o.e(connectivityState != ConnectivityState.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new ConnectivityStateInfo(connectivityState, Status.OK);
    }

    public static ConnectivityStateInfo forTransientFailure(Status status) {
        o.e(!status.isOk(), "The error status must not be OK");
        return new ConnectivityStateInfo(ConnectivityState.TRANSIENT_FAILURE, status);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectivityStateInfo)) {
            return false;
        }
        ConnectivityStateInfo connectivityStateInfo = (ConnectivityStateInfo) obj;
        return this.state.equals(connectivityStateInfo.state) && this.status.equals(connectivityStateInfo.status);
    }

    public ConnectivityState getState() {
        return this.state;
    }

    public Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.state.hashCode() ^ this.status.hashCode();
    }

    public String toString() {
        if (this.status.isOk()) {
            return this.state.toString();
        }
        return ((Object) this.state) + "(" + ((Object) this.status) + ")";
    }
}
