package io.grpc;

import com.google.common.base.j;
import com.google.common.base.l;
import com.google.common.base.o;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.NameResolver;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class LoadBalancer {

    @Internal
    public static final Attributes.Key<Map<String, ?>> ATTR_HEALTH_CHECKING_CONFIG = Attributes.Key.create("internal:health-checking-config");
    private int recursionCount;

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class CreateSubchannelArgs {
        private final List<EquivalentAddressGroup> addrs;
        private final Attributes attrs;
        private final Object[][] customOptions;

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {
            private List<EquivalentAddressGroup> addrs;
            private Attributes attrs = Attributes.EMPTY;
            private Object[][] customOptions = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

            /* JADX INFO: Access modifiers changed from: private */
            public Builder copyCustomOptions(Object[][] objArr) {
                Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, objArr.length, 2);
                this.customOptions = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return this;
            }

            public <T> Builder addOption(Key<T> key, T t2) {
                o.s(key, "key");
                o.s(t2, "value");
                int i10 = 0;
                while (true) {
                    Object[][] objArr = this.customOptions;
                    if (i10 >= objArr.length) {
                        i10 = -1;
                        break;
                    }
                    if (key.equals(objArr[i10][0])) {
                        break;
                    }
                    i10++;
                }
                if (i10 == -1) {
                    Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.customOptions.length + 1, 2);
                    Object[][] objArr3 = this.customOptions;
                    System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                    this.customOptions = objArr2;
                    i10 = objArr2.length - 1;
                }
                Object[][] objArr4 = this.customOptions;
                Object[] objArr5 = new Object[2];
                objArr5[0] = key;
                objArr5[1] = t2;
                objArr4[i10] = objArr5;
                return this;
            }

            public CreateSubchannelArgs build() {
                return new CreateSubchannelArgs(this.addrs, this.attrs, this.customOptions);
            }

            public Builder setAddresses(EquivalentAddressGroup equivalentAddressGroup) {
                this.addrs = Collections.singletonList(equivalentAddressGroup);
                return this;
            }

            public Builder setAttributes(Attributes attributes) {
                this.attrs = (Attributes) o.s(attributes, "attrs");
                return this;
            }

            public Builder setAddresses(List<EquivalentAddressGroup> list) {
                o.e(!list.isEmpty(), "addrs is empty");
                this.addrs = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Key<T> {
            private final String debugString;
            private final T defaultValue;

            private Key(String str, T t2) {
                this.debugString = str;
                this.defaultValue = t2;
            }

            public static <T> Key<T> create(String str) {
                o.s(str, "debugString");
                return new Key<>(str, null);
            }

            public static <T> Key<T> createWithDefault(String str, T t2) {
                o.s(str, "debugString");
                return new Key<>(str, t2);
            }

            public T getDefault() {
                return this.defaultValue;
            }

            public String toString() {
                return this.debugString;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addrs;
        }

        public Attributes getAttributes() {
            return this.attrs;
        }

        public <T> T getOption(Key<T> key) {
            o.s(key, "key");
            int i10 = 0;
            while (true) {
                Object[][] objArr = this.customOptions;
                if (i10 < objArr.length) {
                    if (key.equals(objArr[i10][0])) {
                        return (T) this.customOptions[i10][1];
                    }
                    i10++;
                } else {
                    return (T) ((Key) key).defaultValue;
                }
            }
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addrs).setAttributes(this.attrs).copyCustomOptions(this.customOptions);
        }

        public String toString() {
            return j.c(this).d("addrs", this.addrs).d("attrs", this.attrs).d("customOptions", Arrays.deepToString(this.customOptions)).toString();
        }

        private CreateSubchannelArgs(List<EquivalentAddressGroup> list, Attributes attributes, Object[][] objArr) {
            this.addrs = (List) o.s(list, "addresses are not set");
            this.attrs = (Attributes) o.s(attributes, "attrs");
            this.customOptions = (Object[][]) o.s(objArr, "customOptions");
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Factory {
        public abstract LoadBalancer newLoadBalancer(Helper helper);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Helper {
        public abstract ManagedChannel createOobChannel(EquivalentAddressGroup equivalentAddressGroup, String str);

        public ManagedChannel createOobChannel(List<EquivalentAddressGroup> list, String str) {
            throw new UnsupportedOperationException();
        }

        public ManagedChannel createResolvingOobChannel(String str) {
            return createResolvingOobChannelBuilder(str).build();
        }

        @Deprecated
        public ManagedChannelBuilder<?> createResolvingOobChannelBuilder(String str) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public Subchannel createSubchannel(CreateSubchannelArgs createSubchannelArgs) {
            throw new UnsupportedOperationException();
        }

        public abstract String getAuthority();

        public ChannelCredentials getChannelCredentials() {
            return getUnsafeChannelCredentials().withoutBearerTokens();
        }

        public ChannelLogger getChannelLogger() {
            throw new UnsupportedOperationException();
        }

        public NameResolver.Args getNameResolverArgs() {
            throw new UnsupportedOperationException();
        }

        public NameResolverRegistry getNameResolverRegistry() {
            throw new UnsupportedOperationException();
        }

        public ScheduledExecutorService getScheduledExecutorService() {
            throw new UnsupportedOperationException();
        }

        public SynchronizationContext getSynchronizationContext() {
            throw new UnsupportedOperationException();
        }

        public ChannelCredentials getUnsafeChannelCredentials() {
            throw new UnsupportedOperationException();
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/8088")
        @Deprecated
        public void ignoreRefreshNameResolutionCheck() {
        }

        public void refreshNameResolution() {
            throw new UnsupportedOperationException();
        }

        public abstract void updateBalancingState(ConnectivityState connectivityState, SubchannelPicker subchannelPicker);

        public void updateOobChannelAddresses(ManagedChannel managedChannel, EquivalentAddressGroup equivalentAddressGroup) {
            throw new UnsupportedOperationException();
        }

        public ManagedChannelBuilder<?> createResolvingOobChannelBuilder(String str, ChannelCredentials channelCredentials) {
            throw new UnsupportedOperationException();
        }

        public void updateOobChannelAddresses(ManagedChannel managedChannel, List<EquivalentAddressGroup> list) {
            throw new UnsupportedOperationException();
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class PickSubchannelArgs {
        public abstract CallOptions getCallOptions();

        public abstract Metadata getHeaders();

        public abstract MethodDescriptor<?, ?> getMethodDescriptor();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ResolvedAddresses {
        private final List<EquivalentAddressGroup> addresses;
        private final Attributes attributes;
        private final Object loadBalancingPolicyConfig;

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {
            private List<EquivalentAddressGroup> addresses;
            private Attributes attributes = Attributes.EMPTY;
            private Object loadBalancingPolicyConfig;

            public ResolvedAddresses build() {
                return new ResolvedAddresses(this.addresses, this.attributes, this.loadBalancingPolicyConfig);
            }

            public Builder setAddresses(List<EquivalentAddressGroup> list) {
                this.addresses = list;
                return this;
            }

            public Builder setAttributes(Attributes attributes) {
                this.attributes = attributes;
                return this;
            }

            public Builder setLoadBalancingPolicyConfig(Object obj) {
                this.loadBalancingPolicyConfig = obj;
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResolvedAddresses)) {
                return false;
            }
            ResolvedAddresses resolvedAddresses = (ResolvedAddresses) obj;
            return l.a(this.addresses, resolvedAddresses.addresses) && l.a(this.attributes, resolvedAddresses.attributes) && l.a(this.loadBalancingPolicyConfig, resolvedAddresses.loadBalancingPolicyConfig);
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addresses;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        public Object getLoadBalancingPolicyConfig() {
            return this.loadBalancingPolicyConfig;
        }

        public int hashCode() {
            return l.b(this.addresses, this.attributes, this.loadBalancingPolicyConfig);
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addresses).setAttributes(this.attributes).setLoadBalancingPolicyConfig(this.loadBalancingPolicyConfig);
        }

        public String toString() {
            return j.c(this).d("addresses", this.addresses).d("attributes", this.attributes).d("loadBalancingPolicyConfig", this.loadBalancingPolicyConfig).toString();
        }

        private ResolvedAddresses(List<EquivalentAddressGroup> list, Attributes attributes, Object obj) {
            this.addresses = Collections.unmodifiableList(new ArrayList((Collection) o.s(list, "addresses")));
            this.attributes = (Attributes) o.s(attributes, "attributes");
            this.loadBalancingPolicyConfig = obj;
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Subchannel {
        @Internal
        public Channel asChannel() {
            throw new UnsupportedOperationException();
        }

        public final EquivalentAddressGroup getAddresses() {
            List<EquivalentAddressGroup> allAddresses = getAllAddresses();
            o.B(allAddresses.size() == 1, "%s does not have exactly one group", allAddresses);
            return allAddresses.get(0);
        }

        public List<EquivalentAddressGroup> getAllAddresses() {
            throw new UnsupportedOperationException();
        }

        public abstract Attributes getAttributes();

        public ChannelLogger getChannelLogger() {
            throw new UnsupportedOperationException();
        }

        @Internal
        public Object getInternalSubchannel() {
            throw new UnsupportedOperationException();
        }

        public abstract void requestConnection();

        public abstract void shutdown();

        public void start(SubchannelStateListener subchannelStateListener) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public void updateAddresses(List<EquivalentAddressGroup> list) {
            throw new UnsupportedOperationException();
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class SubchannelPicker {
        public abstract PickResult pickSubchannel(PickSubchannelArgs pickSubchannelArgs);

        @Deprecated
        public void requestConnection() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface SubchannelStateListener {
        void onSubchannelState(ConnectivityStateInfo connectivityStateInfo);
    }

    public boolean acceptResolvedAddresses(ResolvedAddresses resolvedAddresses) {
        if (resolvedAddresses.getAddresses().isEmpty() && !canHandleEmptyAddressListFromNameResolution()) {
            handleNameResolutionError(Status.UNAVAILABLE.withDescription("NameResolver returned no usable address. addrs=" + ((Object) resolvedAddresses.getAddresses()) + ", attrs=" + ((Object) resolvedAddresses.getAttributes())));
            return false;
        }
        int i10 = this.recursionCount;
        this.recursionCount = i10 + 1;
        if (i10 == 0) {
            handleResolvedAddresses(resolvedAddresses);
        }
        this.recursionCount = 0;
        return true;
    }

    public boolean canHandleEmptyAddressListFromNameResolution() {
        return false;
    }

    public abstract void handleNameResolutionError(Status status);

    public void handleResolvedAddresses(ResolvedAddresses resolvedAddresses) {
        int i10 = this.recursionCount;
        this.recursionCount = i10 + 1;
        if (i10 == 0) {
            acceptResolvedAddresses(resolvedAddresses);
        }
        this.recursionCount = 0;
    }

    @Deprecated
    public void handleSubchannelState(Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
    }

    public void requestConnection() {
    }

    public abstract void shutdown();

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class PickResult {
        private static final PickResult NO_RESULT = new PickResult(null, null, Status.OK, false);
        private final boolean drop;
        private final Status status;
        private final ClientStreamTracer.Factory streamTracerFactory;
        private final Subchannel subchannel;

        private PickResult(Subchannel subchannel, ClientStreamTracer.Factory factory, Status status, boolean z10) {
            this.subchannel = subchannel;
            this.streamTracerFactory = factory;
            this.status = (Status) o.s(status, "status");
            this.drop = z10;
        }

        public static PickResult withDrop(Status status) {
            o.e(!status.isOk(), "drop status shouldn't be OK");
            return new PickResult(null, null, status, true);
        }

        public static PickResult withError(Status status) {
            o.e(!status.isOk(), "error status shouldn't be OK");
            return new PickResult(null, null, status, false);
        }

        public static PickResult withNoResult() {
            return NO_RESULT;
        }

        public static PickResult withSubchannel(Subchannel subchannel, ClientStreamTracer.Factory factory) {
            return new PickResult((Subchannel) o.s(subchannel, "subchannel"), factory, Status.OK, false);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PickResult)) {
                return false;
            }
            PickResult pickResult = (PickResult) obj;
            return l.a(this.subchannel, pickResult.subchannel) && l.a(this.status, pickResult.status) && l.a(this.streamTracerFactory, pickResult.streamTracerFactory) && this.drop == pickResult.drop;
        }

        public Status getStatus() {
            return this.status;
        }

        public ClientStreamTracer.Factory getStreamTracerFactory() {
            return this.streamTracerFactory;
        }

        public Subchannel getSubchannel() {
            return this.subchannel;
        }

        public int hashCode() {
            return l.b(this.subchannel, this.status, this.streamTracerFactory, Boolean.valueOf(this.drop));
        }

        public boolean isDrop() {
            return this.drop;
        }

        public String toString() {
            return j.c(this).d("subchannel", this.subchannel).d("streamTracerFactory", this.streamTracerFactory).d("status", this.status).e("drop", this.drop).toString();
        }

        public static PickResult withSubchannel(Subchannel subchannel) {
            return withSubchannel(subchannel, null);
        }
    }
}
