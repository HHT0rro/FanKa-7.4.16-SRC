package io.grpc;

import com.google.common.base.o;
import io.grpc.Attributes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class EquivalentAddressGroup {

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/6138")
    public static final Attributes.Key<String> ATTR_AUTHORITY_OVERRIDE = Attributes.Key.create("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");
    private final List<SocketAddress> addrs;
    private final Attributes attrs;
    private final int hashCode;

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4972")
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public @interface Attr {
    }

    public EquivalentAddressGroup(List<SocketAddress> list) {
        this(list, Attributes.EMPTY);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EquivalentAddressGroup)) {
            return false;
        }
        EquivalentAddressGroup equivalentAddressGroup = (EquivalentAddressGroup) obj;
        if (this.addrs.size() != equivalentAddressGroup.addrs.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.addrs.size(); i10++) {
            if (!this.addrs.get(i10).equals(equivalentAddressGroup.addrs.get(i10))) {
                return false;
            }
        }
        return this.attrs.equals(equivalentAddressGroup.attrs);
    }

    public List<SocketAddress> getAddresses() {
        return this.addrs;
    }

    public Attributes getAttributes() {
        return this.attrs;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return "[" + ((Object) this.addrs) + "/" + ((Object) this.attrs) + "]";
    }

    public EquivalentAddressGroup(List<SocketAddress> list, Attributes attributes) {
        o.e(!list.isEmpty(), "addrs is empty");
        List<SocketAddress> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.addrs = unmodifiableList;
        this.attrs = (Attributes) o.s(attributes, "attrs");
        this.hashCode = unmodifiableList.hashCode();
    }

    public EquivalentAddressGroup(SocketAddress socketAddress) {
        this(socketAddress, Attributes.EMPTY);
    }

    public EquivalentAddressGroup(SocketAddress socketAddress, Attributes attributes) {
        this((List<SocketAddress>) Collections.singletonList(socketAddress), attributes);
    }
}
