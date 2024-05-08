package sun.nio.ch;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.channels.MembershipKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MembershipRegistry {
    private Map<InetAddress, List<MembershipKeyImpl>> groups;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface ThrowingConsumer<T, X extends Throwable> {
        void accept(T t2) throws Throwable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MembershipKey checkMembership(InetAddress group, NetworkInterface interf, InetAddress source) {
        List<MembershipKeyImpl> keys;
        Map<InetAddress, List<MembershipKeyImpl>> map = this.groups;
        if (map != null && (keys = map.get(group)) != null) {
            for (MembershipKeyImpl key : keys) {
                if (key.networkInterface().equals(interf)) {
                    if (source == null) {
                        if (key.sourceAddress() == null) {
                            return key;
                        }
                        throw new IllegalStateException("Already a member to receive all packets");
                    }
                    if (key.sourceAddress() == null) {
                        throw new IllegalStateException("Already have source-specific membership");
                    }
                    if (source.equals(key.sourceAddress())) {
                        return key;
                    }
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(MembershipKeyImpl key) {
        List<MembershipKeyImpl> keys;
        InetAddress group = key.group();
        Map<InetAddress, List<MembershipKeyImpl>> map = this.groups;
        if (map == null) {
            this.groups = new HashMap();
            keys = null;
        } else {
            List<MembershipKeyImpl> keys2 = map.get(group);
            keys = keys2;
        }
        if (keys == null) {
            keys = new LinkedList();
            this.groups.put(group, keys);
        }
        keys.add(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove(MembershipKeyImpl key) {
        InetAddress group = key.group();
        List<MembershipKeyImpl> keys = this.groups.get(group);
        if (keys != null) {
            Iterator<MembershipKeyImpl> i10 = keys.iterator2();
            while (true) {
                if (!i10.hasNext()) {
                    break;
                } else if (i10.next() == key) {
                    i10.remove();
                    break;
                }
            }
            if (keys.isEmpty()) {
                this.groups.remove(group);
            }
        }
    }

    <X extends Throwable> void forEach(ThrowingConsumer<MembershipKeyImpl, X> action) throws Throwable {
        Map<InetAddress, List<MembershipKeyImpl>> map = this.groups;
        if (map != null) {
            for (List<MembershipKeyImpl> keys : map.values()) {
                for (MembershipKeyImpl key : keys) {
                    action.accept(key);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateAll() {
        forEach(new ThrowingConsumer() { // from class: sun.nio.ch.MembershipRegistry$$ExternalSyntheticLambda0
            @Override // sun.nio.ch.MembershipRegistry.ThrowingConsumer
            public final void accept(Object obj) {
                ((MembershipKeyImpl) obj).invalidate();
            }
        });
    }
}
