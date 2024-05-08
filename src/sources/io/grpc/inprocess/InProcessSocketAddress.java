package io.grpc.inprocess;

import com.google.common.base.o;
import java.net.SocketAddress;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InProcessSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -2803441206326023474L;
    private final String name;

    public InProcessSocketAddress(String str) {
        this.name = (String) o.s(str, "name");
    }

    public boolean equals(Object obj) {
        if (obj instanceof InProcessSocketAddress) {
            return this.name.equals(((InProcessSocketAddress) obj).name);
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return this.name;
    }
}
