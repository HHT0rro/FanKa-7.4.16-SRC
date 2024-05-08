package sun.nio.ch;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.channels.MembershipKey;
import java.nio.channels.MulticastChannel;
import java.util.HashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MembershipKeyImpl extends MembershipKey {
    private HashSet<InetAddress> blockedSet;
    private final MulticastChannel ch;
    private final InetAddress group;
    private final NetworkInterface interf;
    private volatile boolean invalid;
    private final InetAddress source;
    private final Object stateLock;

    private MembershipKeyImpl(MulticastChannel ch, InetAddress group, NetworkInterface interf, InetAddress source) {
        this.stateLock = new Object();
        this.ch = ch;
        this.group = group;
        this.interf = interf;
        this.source = source;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Type4 extends MembershipKeyImpl {
        private final int groupAddress;
        private final int interfAddress;
        private final int sourceAddress;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Type4(MulticastChannel ch, InetAddress group, NetworkInterface interf, InetAddress source, int groupAddress, int interfAddress, int sourceAddress) {
            super(ch, group, interf, source);
            this.groupAddress = groupAddress;
            this.interfAddress = interfAddress;
            this.sourceAddress = sourceAddress;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int groupAddress() {
            return this.groupAddress;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int interfaceAddress() {
            return this.interfAddress;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int source() {
            return this.sourceAddress;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Type6 extends MembershipKeyImpl {
        private final byte[] groupAddress;
        private final int index;
        private final byte[] sourceAddress;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Type6(MulticastChannel ch, InetAddress group, NetworkInterface interf, InetAddress source, byte[] groupAddress, int index, byte[] sourceAddress) {
            super(ch, group, interf, source);
            this.groupAddress = groupAddress;
            this.index = index;
            this.sourceAddress = sourceAddress;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public byte[] groupAddress() {
            return this.groupAddress;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int index() {
            return this.index;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public byte[] source() {
            return this.sourceAddress;
        }
    }

    @Override // java.nio.channels.MembershipKey
    public boolean isValid() {
        return !this.invalid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidate() {
        this.invalid = true;
    }

    @Override // java.nio.channels.MembershipKey
    public void drop() {
        ((DatagramChannelImpl) this.ch).drop(this);
    }

    @Override // java.nio.channels.MembershipKey
    public MulticastChannel channel() {
        return this.ch;
    }

    @Override // java.nio.channels.MembershipKey
    public InetAddress group() {
        return this.group;
    }

    @Override // java.nio.channels.MembershipKey
    public NetworkInterface networkInterface() {
        return this.interf;
    }

    @Override // java.nio.channels.MembershipKey
    public InetAddress sourceAddress() {
        return this.source;
    }

    @Override // java.nio.channels.MembershipKey
    public MembershipKey block(InetAddress toBlock) throws IOException {
        if (this.source != null) {
            throw new IllegalStateException("key is source-specific");
        }
        synchronized (this.stateLock) {
            HashSet<InetAddress> hashSet = this.blockedSet;
            if (hashSet != null && hashSet.contains(toBlock)) {
                return this;
            }
            ((DatagramChannelImpl) this.ch).block(this, toBlock);
            if (this.blockedSet == null) {
                this.blockedSet = new HashSet<>();
            }
            this.blockedSet.add(toBlock);
            return this;
        }
    }

    @Override // java.nio.channels.MembershipKey
    public MembershipKey unblock(InetAddress toUnblock) {
        synchronized (this.stateLock) {
            HashSet<InetAddress> hashSet = this.blockedSet;
            if (hashSet == null || !hashSet.contains(toUnblock)) {
                throw new IllegalStateException("not blocked");
            }
            ((DatagramChannelImpl) this.ch).unblock(this, toUnblock);
            this.blockedSet.remove(toUnblock);
        }
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append('<');
        sb2.append(this.group.getHostAddress());
        sb2.append(',');
        sb2.append(this.interf.getName());
        if (this.source != null) {
            sb2.append(',');
            sb2.append(this.source.getHostAddress());
        }
        sb2.append('>');
        return sb2.toString();
    }
}
