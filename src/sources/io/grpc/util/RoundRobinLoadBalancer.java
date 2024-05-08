package io.grpc.util;

import com.google.common.base.j;
import com.google.common.base.l;
import com.google.common.base.o;
import com.huawei.quickcard.base.Attributes;
import io.grpc.Attributes;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.Internal;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class RoundRobinLoadBalancer extends LoadBalancer {
    private ConnectivityState currentState;
    private final LoadBalancer.Helper helper;
    public static final Attributes.Key<Ref<ConnectivityStateInfo>> STATE_INFO = Attributes.Key.create("state-info");
    private static final Status EMPTY_OK = Status.OK.withDescription("no subchannels ready");
    private final Map<EquivalentAddressGroup, LoadBalancer.Subchannel> subchannels = new HashMap();
    public RoundRobinPicker currentPicker = new EmptyPicker(EMPTY_OK);
    private final Random random = new Random();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class EmptyPicker extends RoundRobinPicker {
        private final Status status;

        public EmptyPicker(Status status) {
            this.status = (Status) o.s(status, "status");
        }

        @Override // io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker
        public boolean isEquivalentTo(RoundRobinPicker roundRobinPicker) {
            if (roundRobinPicker instanceof EmptyPicker) {
                EmptyPicker emptyPicker = (EmptyPicker) roundRobinPicker;
                if (l.a(this.status, emptyPicker.status) || (this.status.isOk() && emptyPicker.status.isOk())) {
                    return true;
                }
            }
            return false;
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return this.status.isOk() ? LoadBalancer.PickResult.withNoResult() : LoadBalancer.PickResult.withError(this.status);
        }

        public String toString() {
            return j.b(EmptyPicker.class).d("status", this.status).toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ReadyPicker extends RoundRobinPicker {
        private static final AtomicIntegerFieldUpdater<ReadyPicker> indexUpdater = AtomicIntegerFieldUpdater.newUpdater(ReadyPicker.class, Attributes.Style.INDEX);
        private volatile int index;
        private final List<LoadBalancer.Subchannel> list;

        public ReadyPicker(List<LoadBalancer.Subchannel> list, int i10) {
            o.e(!list.isEmpty(), "empty list");
            this.list = list;
            this.index = i10 - 1;
        }

        private LoadBalancer.Subchannel nextSubchannel() {
            int size = this.list.size();
            AtomicIntegerFieldUpdater<ReadyPicker> atomicIntegerFieldUpdater = indexUpdater;
            int incrementAndGet = atomicIntegerFieldUpdater.incrementAndGet(this);
            if (incrementAndGet >= size) {
                int i10 = incrementAndGet % size;
                atomicIntegerFieldUpdater.compareAndSet(this, incrementAndGet, i10);
                incrementAndGet = i10;
            }
            return this.list.get(incrementAndGet);
        }

        public List<LoadBalancer.Subchannel> getList() {
            return this.list;
        }

        @Override // io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker
        public boolean isEquivalentTo(RoundRobinPicker roundRobinPicker) {
            if (!(roundRobinPicker instanceof ReadyPicker)) {
                return false;
            }
            ReadyPicker readyPicker = (ReadyPicker) roundRobinPicker;
            return readyPicker == this || (this.list.size() == readyPicker.list.size() && new HashSet(this.list).containsAll(readyPicker.list));
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return LoadBalancer.PickResult.withSubchannel(nextSubchannel());
        }

        public String toString() {
            return j.b(ReadyPicker.class).d("list", this.list).toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Ref<T> {
        public T value;

        public Ref(T t2) {
            this.value = t2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class RoundRobinPicker extends LoadBalancer.SubchannelPicker {
        public abstract boolean isEquivalentTo(RoundRobinPicker roundRobinPicker);
    }

    public RoundRobinLoadBalancer(LoadBalancer.Helper helper) {
        this.helper = (LoadBalancer.Helper) o.s(helper, "helper");
    }

    private static List<LoadBalancer.Subchannel> filterNonFailingSubchannels(Collection<LoadBalancer.Subchannel> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (LoadBalancer.Subchannel subchannel : collection) {
            if (isReady(subchannel)) {
                arrayList.add(subchannel);
            }
        }
        return arrayList;
    }

    private static Ref<ConnectivityStateInfo> getSubchannelStateInfoRef(LoadBalancer.Subchannel subchannel) {
        return (Ref) o.s((Ref) subchannel.getAttributes().get(STATE_INFO), "STATE_INFO");
    }

    public static boolean isReady(LoadBalancer.Subchannel subchannel) {
        return getSubchannelStateInfoRef(subchannel).value.getState() == ConnectivityState.READY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void processSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        if (this.subchannels.get(stripAttrs(subchannel.getAddresses())) != subchannel) {
            return;
        }
        ConnectivityState state = connectivityStateInfo.getState();
        ConnectivityState connectivityState = ConnectivityState.TRANSIENT_FAILURE;
        if (state == connectivityState || connectivityStateInfo.getState() == ConnectivityState.IDLE) {
            this.helper.refreshNameResolution();
        }
        ConnectivityState state2 = connectivityStateInfo.getState();
        ConnectivityState connectivityState2 = ConnectivityState.IDLE;
        if (state2 == connectivityState2) {
            subchannel.requestConnection();
        }
        Ref<ConnectivityStateInfo> subchannelStateInfoRef = getSubchannelStateInfoRef(subchannel);
        if (subchannelStateInfoRef.value.getState().equals(connectivityState) && (connectivityStateInfo.getState().equals(ConnectivityState.CONNECTING) || connectivityStateInfo.getState().equals(connectivityState2))) {
            return;
        }
        subchannelStateInfoRef.value = connectivityStateInfo;
        updateBalancingState();
    }

    private static <T> Set<T> setsDifference(Set<T> set, Set<T> set2) {
        HashSet hashSet = new HashSet(set);
        hashSet.removeAll(set2);
        return hashSet;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, io.grpc.ConnectivityStateInfo] */
    private void shutdownSubchannel(LoadBalancer.Subchannel subchannel) {
        subchannel.shutdown();
        getSubchannelStateInfoRef(subchannel).value = ConnectivityStateInfo.forNonError(ConnectivityState.SHUTDOWN);
    }

    private static Map<EquivalentAddressGroup, EquivalentAddressGroup> stripAttrs(List<EquivalentAddressGroup> list) {
        HashMap hashMap = new HashMap(list.size() * 2);
        for (EquivalentAddressGroup equivalentAddressGroup : list) {
            hashMap.put(stripAttrs(equivalentAddressGroup), equivalentAddressGroup);
        }
        return hashMap;
    }

    private void updateBalancingState() {
        List<LoadBalancer.Subchannel> filterNonFailingSubchannels = filterNonFailingSubchannels(getSubchannels());
        if (filterNonFailingSubchannels.isEmpty()) {
            boolean z10 = false;
            Status status = EMPTY_OK;
            Iterator<LoadBalancer.Subchannel> iterator2 = getSubchannels().iterator2();
            while (iterator2.hasNext()) {
                ConnectivityStateInfo connectivityStateInfo = getSubchannelStateInfoRef(iterator2.next()).value;
                if (connectivityStateInfo.getState() == ConnectivityState.CONNECTING || connectivityStateInfo.getState() == ConnectivityState.IDLE) {
                    z10 = true;
                }
                if (status == EMPTY_OK || !status.isOk()) {
                    status = connectivityStateInfo.getStatus();
                }
            }
            updateBalancingState(z10 ? ConnectivityState.CONNECTING : ConnectivityState.TRANSIENT_FAILURE, new EmptyPicker(status));
            return;
        }
        updateBalancingState(ConnectivityState.READY, createReadyPicker(filterNonFailingSubchannels));
    }

    @Override // io.grpc.LoadBalancer
    public boolean acceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        if (resolvedAddresses.getAddresses().isEmpty()) {
            handleNameResolutionError(Status.UNAVAILABLE.withDescription("NameResolver returned no usable address. addrs=" + ((Object) resolvedAddresses.getAddresses()) + ", attrs=" + ((Object) resolvedAddresses.getAttributes())));
            return false;
        }
        List<EquivalentAddressGroup> addresses = resolvedAddresses.getAddresses();
        Set<EquivalentAddressGroup> h10 = this.subchannels.h();
        Map<EquivalentAddressGroup, EquivalentAddressGroup> stripAttrs = stripAttrs(addresses);
        Set set = setsDifference(h10, stripAttrs.h());
        for (Map.Entry<EquivalentAddressGroup, EquivalentAddressGroup> entry : stripAttrs.entrySet()) {
            EquivalentAddressGroup key = entry.getKey();
            EquivalentAddressGroup value = entry.getValue();
            LoadBalancer.Subchannel subchannel = this.subchannels.get(key);
            if (subchannel != null) {
                subchannel.updateAddresses(Collections.singletonList(value));
            } else {
                final LoadBalancer.Subchannel subchannel2 = (LoadBalancer.Subchannel) o.s(this.helper.createSubchannel(LoadBalancer.CreateSubchannelArgs.newBuilder().setAddresses(value).setAttributes(io.grpc.Attributes.newBuilder().set(STATE_INFO, new Ref(ConnectivityStateInfo.forNonError(ConnectivityState.IDLE))).build()).build()), "subchannel");
                subchannel2.start(new LoadBalancer.SubchannelStateListener() { // from class: io.grpc.util.RoundRobinLoadBalancer.1
                    @Override // io.grpc.LoadBalancer.SubchannelStateListener
                    public void onSubchannelState(ConnectivityStateInfo connectivityStateInfo) {
                        RoundRobinLoadBalancer.this.processSubchannelState(subchannel2, connectivityStateInfo);
                    }
                });
                this.subchannels.put(key, subchannel2);
                subchannel2.requestConnection();
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = set.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(this.subchannels.remove((EquivalentAddressGroup) iterator2.next()));
        }
        updateBalancingState();
        Iterator iterator22 = arrayList.iterator2();
        while (iterator22.hasNext()) {
            shutdownSubchannel((LoadBalancer.Subchannel) iterator22.next());
        }
        return true;
    }

    public RoundRobinPicker createReadyPicker(List<LoadBalancer.Subchannel> list) {
        return new ReadyPicker(list, this.random.nextInt(list.size()));
    }

    public Collection<LoadBalancer.Subchannel> getSubchannels() {
        return this.subchannels.values();
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        if (this.currentState != ConnectivityState.READY) {
            updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new EmptyPicker(status));
        }
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        Iterator<LoadBalancer.Subchannel> iterator2 = getSubchannels().iterator2();
        while (iterator2.hasNext()) {
            shutdownSubchannel(iterator2.next());
        }
        this.subchannels.clear();
    }

    private static EquivalentAddressGroup stripAttrs(EquivalentAddressGroup equivalentAddressGroup) {
        return new EquivalentAddressGroup(equivalentAddressGroup.getAddresses());
    }

    private void updateBalancingState(ConnectivityState connectivityState, RoundRobinPicker roundRobinPicker) {
        if (connectivityState == this.currentState && roundRobinPicker.isEquivalentTo(this.currentPicker)) {
            return;
        }
        this.helper.updateBalancingState(connectivityState, roundRobinPicker);
        this.currentState = connectivityState;
        this.currentPicker = roundRobinPicker;
    }
}
