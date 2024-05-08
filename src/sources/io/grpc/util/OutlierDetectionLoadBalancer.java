package io.grpc.util;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.common.base.o;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.v;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ClientStreamTracer;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.Internal;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ServiceConfigUtil;
import io.grpc.internal.TimeProvider;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.internal.connection.RealConnection;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class OutlierDetectionLoadBalancer extends LoadBalancer {
    private static final Attributes.Key<AddressTracker> ADDRESS_TRACKER_ATTR_KEY = Attributes.Key.create("addressTrackerKey");
    private final LoadBalancer.Helper childHelper;
    private SynchronizationContext.ScheduledHandle detectionTimerHandle;
    private Long detectionTimerStartNanos;
    private final ChannelLogger logger;
    private final GracefulSwitchLoadBalancer switchLb;
    private final SynchronizationContext syncContext;
    private TimeProvider timeProvider;
    private final ScheduledExecutorService timeService;
    public final AddressTrackerMap trackerMap;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class AddressTracker {
        private volatile CallCounter activeCallCounter;
        private OutlierDetectionLoadBalancerConfig config;
        private int ejectionTimeMultiplier;
        private Long ejectionTimeNanos;
        private CallCounter inactiveCallCounter;
        private final Set<OutlierDetectionSubchannel> subchannels = new HashSet();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static class CallCounter {
            public AtomicLong failureCount;
            public AtomicLong successCount;

            private CallCounter() {
                this.successCount = new AtomicLong();
                this.failureCount = new AtomicLong();
            }

            public void reset() {
                this.successCount.set(0L);
                this.failureCount.set(0L);
            }
        }

        public AddressTracker(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig) {
            this.activeCallCounter = new CallCounter();
            this.inactiveCallCounter = new CallCounter();
            this.config = outlierDetectionLoadBalancerConfig;
        }

        public long activeVolume() {
            return this.activeCallCounter.successCount.get() + this.activeCallCounter.failureCount.get();
        }

        public boolean addSubchannel(OutlierDetectionSubchannel outlierDetectionSubchannel) {
            if (subchannelsEjected() && !outlierDetectionSubchannel.isEjected()) {
                outlierDetectionSubchannel.eject();
            } else if (!subchannelsEjected() && outlierDetectionSubchannel.isEjected()) {
                outlierDetectionSubchannel.uneject();
            }
            outlierDetectionSubchannel.setAddressTracker(this);
            return this.subchannels.add(outlierDetectionSubchannel);
        }

        public boolean containsSubchannel(OutlierDetectionSubchannel outlierDetectionSubchannel) {
            return this.subchannels.contains(outlierDetectionSubchannel);
        }

        public void decrementEjectionTimeMultiplier() {
            int i10 = this.ejectionTimeMultiplier;
            this.ejectionTimeMultiplier = i10 == 0 ? 0 : i10 - 1;
        }

        public void ejectSubchannels(long j10) {
            this.ejectionTimeNanos = Long.valueOf(j10);
            this.ejectionTimeMultiplier++;
            Iterator<OutlierDetectionSubchannel> iterator2 = this.subchannels.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().eject();
            }
        }

        public double failureRate() {
            return this.inactiveCallCounter.failureCount.get() / inactiveVolume();
        }

        public Set<OutlierDetectionSubchannel> getSubchannels() {
            return ImmutableSet.copyOf((Collection) this.subchannels);
        }

        public long inactiveVolume() {
            return this.inactiveCallCounter.successCount.get() + this.inactiveCallCounter.failureCount.get();
        }

        public void incrementCallCount(boolean z10) {
            OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig = this.config;
            if (outlierDetectionLoadBalancerConfig.successRateEjection == null && outlierDetectionLoadBalancerConfig.failurePercentageEjection == null) {
                return;
            }
            if (z10) {
                this.activeCallCounter.successCount.getAndIncrement();
            } else {
                this.activeCallCounter.failureCount.getAndIncrement();
            }
        }

        public boolean maxEjectionTimeElapsed(long j10) {
            return j10 > this.ejectionTimeNanos.longValue() + Math.min(this.config.baseEjectionTimeNanos.longValue() * ((long) this.ejectionTimeMultiplier), Math.max(this.config.baseEjectionTimeNanos.longValue(), this.config.maxEjectionTimeNanos.longValue()));
        }

        public boolean removeSubchannel(OutlierDetectionSubchannel outlierDetectionSubchannel) {
            outlierDetectionSubchannel.clearAddressTracker();
            return this.subchannels.remove(outlierDetectionSubchannel);
        }

        public void resetCallCounters() {
            this.activeCallCounter.reset();
            this.inactiveCallCounter.reset();
        }

        public void resetEjectionTimeMultiplier() {
            this.ejectionTimeMultiplier = 0;
        }

        public void setConfig(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig) {
            this.config = outlierDetectionLoadBalancerConfig;
        }

        public boolean subchannelsEjected() {
            return this.ejectionTimeNanos != null;
        }

        public double successRate() {
            return this.inactiveCallCounter.successCount.get() / inactiveVolume();
        }

        public void swapCounters() {
            this.inactiveCallCounter.reset();
            CallCounter callCounter = this.activeCallCounter;
            this.activeCallCounter = this.inactiveCallCounter;
            this.inactiveCallCounter = callCounter;
        }

        public String toString() {
            return "AddressTracker{subchannels=" + ((Object) this.subchannels) + '}';
        }

        public void unejectSubchannels() {
            o.y(this.ejectionTimeNanos != null, "not currently ejected");
            this.ejectionTimeNanos = null;
            Iterator<OutlierDetectionSubchannel> iterator2 = this.subchannels.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().uneject();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class AddressTrackerMap extends v<SocketAddress, AddressTracker> {
        private final Map<SocketAddress, AddressTracker> trackerMap = new HashMap();

        public void cancelTracking() {
            for (AddressTracker addressTracker : this.trackerMap.values()) {
                if (addressTracker.subchannelsEjected()) {
                    addressTracker.unejectSubchannels();
                }
                addressTracker.resetEjectionTimeMultiplier();
            }
        }

        public double ejectionPercentage() {
            if (this.trackerMap.isEmpty()) {
                return ShadowDrawableWrapper.COS_45;
            }
            Iterator<AddressTracker> iterator2 = this.trackerMap.values().iterator2();
            int i10 = 0;
            int i11 = 0;
            while (iterator2.hasNext()) {
                i11++;
                if (iterator2.next().subchannelsEjected()) {
                    i10++;
                }
            }
            return (i10 / i11) * 100.0d;
        }

        public void maybeUnejectOutliers(Long l10) {
            for (AddressTracker addressTracker : this.trackerMap.values()) {
                if (!addressTracker.subchannelsEjected()) {
                    addressTracker.decrementEjectionTimeMultiplier();
                }
                if (addressTracker.subchannelsEjected() && addressTracker.maxEjectionTimeElapsed(l10.longValue())) {
                    addressTracker.unejectSubchannels();
                }
            }
        }

        public void putNewTrackers(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, Collection<SocketAddress> collection) {
            for (SocketAddress socketAddress : collection) {
                if (!this.trackerMap.containsKey(socketAddress)) {
                    this.trackerMap.put(socketAddress, new AddressTracker(outlierDetectionLoadBalancerConfig));
                }
            }
        }

        public void resetCallCounters() {
            Iterator<AddressTracker> iterator2 = this.trackerMap.values().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().resetCallCounters();
            }
        }

        public void swapCounters() {
            Iterator<AddressTracker> iterator2 = this.trackerMap.values().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().swapCounters();
            }
        }

        public void updateTrackerConfigs(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig) {
            Iterator<AddressTracker> iterator2 = this.trackerMap.values().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().setConfig(outlierDetectionLoadBalancerConfig);
            }
        }

        @Override // com.google.common.collect.v, com.google.common.collect.z
        public Map<SocketAddress, AddressTracker> delegate() {
            return this.trackerMap;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class ChildHelper extends ForwardingLoadBalancerHelper {
        private LoadBalancer.Helper delegate;

        public ChildHelper(LoadBalancer.Helper helper) {
            this.delegate = helper;
        }

        @Override // io.grpc.util.ForwardingLoadBalancerHelper, io.grpc.LoadBalancer.Helper
        public LoadBalancer.Subchannel createSubchannel(LoadBalancer.CreateSubchannelArgs createSubchannelArgs) {
            OutlierDetectionSubchannel outlierDetectionSubchannel = new OutlierDetectionSubchannel(this.delegate.createSubchannel(createSubchannelArgs));
            List<EquivalentAddressGroup> addresses = createSubchannelArgs.getAddresses();
            if (OutlierDetectionLoadBalancer.hasSingleAddress(addresses) && OutlierDetectionLoadBalancer.this.trackerMap.containsKey(addresses.get(0).getAddresses().get(0))) {
                AddressTracker addressTracker = OutlierDetectionLoadBalancer.this.trackerMap.get(addresses.get(0).getAddresses().get(0));
                addressTracker.addSubchannel(outlierDetectionSubchannel);
                if (addressTracker.ejectionTimeNanos != null) {
                    outlierDetectionSubchannel.eject();
                }
            }
            return outlierDetectionSubchannel;
        }

        @Override // io.grpc.util.ForwardingLoadBalancerHelper
        public LoadBalancer.Helper delegate() {
            return this.delegate;
        }

        @Override // io.grpc.util.ForwardingLoadBalancerHelper, io.grpc.LoadBalancer.Helper
        public void updateBalancingState(ConnectivityState connectivityState, LoadBalancer.SubchannelPicker subchannelPicker) {
            this.delegate.updateBalancingState(connectivityState, new OutlierDetectionPicker(subchannelPicker));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class DetectionTimer implements Runnable {
        public OutlierDetectionLoadBalancerConfig config;
        public ChannelLogger logger;

        public DetectionTimer(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, ChannelLogger channelLogger) {
            this.config = outlierDetectionLoadBalancerConfig;
            this.logger = channelLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            OutlierDetectionLoadBalancer outlierDetectionLoadBalancer = OutlierDetectionLoadBalancer.this;
            outlierDetectionLoadBalancer.detectionTimerStartNanos = Long.valueOf(outlierDetectionLoadBalancer.timeProvider.currentTimeNanos());
            OutlierDetectionLoadBalancer.this.trackerMap.swapCounters();
            for (OutlierEjectionAlgorithm outlierEjectionAlgorithm : a.a(this.config, this.logger)) {
                OutlierDetectionLoadBalancer outlierDetectionLoadBalancer2 = OutlierDetectionLoadBalancer.this;
                outlierEjectionAlgorithm.ejectOutliers(outlierDetectionLoadBalancer2.trackerMap, outlierDetectionLoadBalancer2.detectionTimerStartNanos.longValue());
            }
            OutlierDetectionLoadBalancer outlierDetectionLoadBalancer3 = OutlierDetectionLoadBalancer.this;
            outlierDetectionLoadBalancer3.trackerMap.maybeUnejectOutliers(outlierDetectionLoadBalancer3.detectionTimerStartNanos);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class FailurePercentageOutlierEjectionAlgorithm implements OutlierEjectionAlgorithm {
        private final OutlierDetectionLoadBalancerConfig config;
        private final ChannelLogger logger;

        public FailurePercentageOutlierEjectionAlgorithm(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, ChannelLogger channelLogger) {
            this.config = outlierDetectionLoadBalancerConfig;
            this.logger = channelLogger;
        }

        @Override // io.grpc.util.OutlierDetectionLoadBalancer.OutlierEjectionAlgorithm
        public void ejectOutliers(AddressTrackerMap addressTrackerMap, long j10) {
            List<AddressTracker> trackersWithVolume = OutlierDetectionLoadBalancer.trackersWithVolume(addressTrackerMap, this.config.failurePercentageEjection.requestVolume.intValue());
            if (trackersWithVolume.size() < this.config.failurePercentageEjection.minimumHosts.intValue() || trackersWithVolume.size() == 0) {
                return;
            }
            for (AddressTracker addressTracker : trackersWithVolume) {
                if (addressTrackerMap.ejectionPercentage() >= this.config.maxEjectionPercent.intValue()) {
                    return;
                }
                if (addressTracker.inactiveVolume() >= this.config.failurePercentageEjection.requestVolume.intValue() && addressTracker.failureRate() > this.config.failurePercentageEjection.threshold.intValue() / 100.0d) {
                    this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}", addressTracker, Double.valueOf(addressTracker.failureRate()));
                    if (new Random().nextInt(100) < this.config.failurePercentageEjection.enforcementPercentage.intValue()) {
                        addressTracker.ejectSubchannels(j10);
                    }
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class OutlierDetectionLoadBalancerConfig {
        public final Long baseEjectionTimeNanos;
        public final ServiceConfigUtil.PolicySelection childPolicy;
        public final FailurePercentageEjection failurePercentageEjection;
        public final Long intervalNanos;
        public final Integer maxEjectionPercent;
        public final Long maxEjectionTimeNanos;
        public final SuccessRateEjection successRateEjection;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static class Builder {
            public ServiceConfigUtil.PolicySelection childPolicy;
            public FailurePercentageEjection failurePercentageEjection;
            public SuccessRateEjection successRateEjection;
            public Long intervalNanos = Long.valueOf(RealConnection.IDLE_CONNECTION_HEALTHY_NS);
            public Long baseEjectionTimeNanos = 30000000000L;
            public Long maxEjectionTimeNanos = 300000000000L;
            public Integer maxEjectionPercent = 10;

            public OutlierDetectionLoadBalancerConfig build() {
                o.x(this.childPolicy != null);
                return new OutlierDetectionLoadBalancerConfig(this.intervalNanos, this.baseEjectionTimeNanos, this.maxEjectionTimeNanos, this.maxEjectionPercent, this.successRateEjection, this.failurePercentageEjection, this.childPolicy);
            }

            public Builder setBaseEjectionTimeNanos(Long l10) {
                o.d(l10 != null);
                this.baseEjectionTimeNanos = l10;
                return this;
            }

            public Builder setChildPolicy(ServiceConfigUtil.PolicySelection policySelection) {
                o.x(policySelection != null);
                this.childPolicy = policySelection;
                return this;
            }

            public Builder setFailurePercentageEjection(FailurePercentageEjection failurePercentageEjection) {
                this.failurePercentageEjection = failurePercentageEjection;
                return this;
            }

            public Builder setIntervalNanos(Long l10) {
                o.d(l10 != null);
                this.intervalNanos = l10;
                return this;
            }

            public Builder setMaxEjectionPercent(Integer num) {
                o.d(num != null);
                this.maxEjectionPercent = num;
                return this;
            }

            public Builder setMaxEjectionTimeNanos(Long l10) {
                o.d(l10 != null);
                this.maxEjectionTimeNanos = l10;
                return this;
            }

            public Builder setSuccessRateEjection(SuccessRateEjection successRateEjection) {
                this.successRateEjection = successRateEjection;
                return this;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static class FailurePercentageEjection {
            public final Integer enforcementPercentage;
            public final Integer minimumHosts;
            public final Integer requestVolume;
            public final Integer threshold;

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
            public static class Builder {
                public Integer threshold = 85;
                public Integer enforcementPercentage = 100;
                public Integer minimumHosts = 5;
                public Integer requestVolume = 50;

                public FailurePercentageEjection build() {
                    return new FailurePercentageEjection(this.threshold, this.enforcementPercentage, this.minimumHosts, this.requestVolume);
                }

                public Builder setEnforcementPercentage(Integer num) {
                    o.d(num != null);
                    o.d(num.intValue() >= 0 && num.intValue() <= 100);
                    this.enforcementPercentage = num;
                    return this;
                }

                public Builder setMinimumHosts(Integer num) {
                    o.d(num != null);
                    o.d(num.intValue() >= 0);
                    this.minimumHosts = num;
                    return this;
                }

                public Builder setRequestVolume(Integer num) {
                    o.d(num != null);
                    o.d(num.intValue() >= 0);
                    this.requestVolume = num;
                    return this;
                }

                public Builder setThreshold(Integer num) {
                    o.d(num != null);
                    o.d(num.intValue() >= 0 && num.intValue() <= 100);
                    this.threshold = num;
                    return this;
                }
            }

            public FailurePercentageEjection(Integer num, Integer num2, Integer num3, Integer num4) {
                this.threshold = num;
                this.enforcementPercentage = num2;
                this.minimumHosts = num3;
                this.requestVolume = num4;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static class SuccessRateEjection {
            public final Integer enforcementPercentage;
            public final Integer minimumHosts;
            public final Integer requestVolume;
            public final Integer stdevFactor;

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
            public static final class Builder {
                public Integer stdevFactor = 1900;
                public Integer enforcementPercentage = 100;
                public Integer minimumHosts = 5;
                public Integer requestVolume = 100;

                public SuccessRateEjection build() {
                    return new SuccessRateEjection(this.stdevFactor, this.enforcementPercentage, this.minimumHosts, this.requestVolume);
                }

                public Builder setEnforcementPercentage(Integer num) {
                    o.d(num != null);
                    o.d(num.intValue() >= 0 && num.intValue() <= 100);
                    this.enforcementPercentage = num;
                    return this;
                }

                public Builder setMinimumHosts(Integer num) {
                    o.d(num != null);
                    o.d(num.intValue() >= 0);
                    this.minimumHosts = num;
                    return this;
                }

                public Builder setRequestVolume(Integer num) {
                    o.d(num != null);
                    o.d(num.intValue() >= 0);
                    this.requestVolume = num;
                    return this;
                }

                public Builder setStdevFactor(Integer num) {
                    o.d(num != null);
                    this.stdevFactor = num;
                    return this;
                }
            }

            public SuccessRateEjection(Integer num, Integer num2, Integer num3, Integer num4) {
                this.stdevFactor = num;
                this.enforcementPercentage = num2;
                this.minimumHosts = num3;
                this.requestVolume = num4;
            }
        }

        public boolean outlierDetectionEnabled() {
            return (this.successRateEjection == null && this.failurePercentageEjection == null) ? false : true;
        }

        private OutlierDetectionLoadBalancerConfig(Long l10, Long l11, Long l12, Integer num, SuccessRateEjection successRateEjection, FailurePercentageEjection failurePercentageEjection, ServiceConfigUtil.PolicySelection policySelection) {
            this.intervalNanos = l10;
            this.baseEjectionTimeNanos = l11;
            this.maxEjectionTimeNanos = l12;
            this.maxEjectionPercent = num;
            this.successRateEjection = successRateEjection;
            this.failurePercentageEjection = failurePercentageEjection;
            this.childPolicy = policySelection;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class OutlierDetectionPicker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.SubchannelPicker delegate;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class ResultCountingClientStreamTracer extends ClientStreamTracer {
            public AddressTracker tracker;

            public ResultCountingClientStreamTracer(AddressTracker addressTracker) {
                this.tracker = addressTracker;
            }

            @Override // io.grpc.StreamTracer
            public void streamClosed(Status status) {
                this.tracker.incrementCallCount(status.isOk());
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class ResultCountingClientStreamTracerFactory extends ClientStreamTracer.Factory {
            private final AddressTracker tracker;

            public ResultCountingClientStreamTracerFactory(AddressTracker addressTracker) {
                this.tracker = addressTracker;
            }

            @Override // io.grpc.ClientStreamTracer.Factory
            public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
                return new ResultCountingClientStreamTracer(this.tracker);
            }
        }

        public OutlierDetectionPicker(LoadBalancer.SubchannelPicker subchannelPicker) {
            this.delegate = subchannelPicker;
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            LoadBalancer.PickResult pickSubchannel = this.delegate.pickSubchannel(pickSubchannelArgs);
            LoadBalancer.Subchannel subchannel = pickSubchannel.getSubchannel();
            return subchannel != null ? LoadBalancer.PickResult.withSubchannel(subchannel, new ResultCountingClientStreamTracerFactory((AddressTracker) subchannel.getAttributes().get(OutlierDetectionLoadBalancer.ADDRESS_TRACKER_ATTR_KEY))) : pickSubchannel;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class OutlierDetectionSubchannel extends ForwardingSubchannel {
        private AddressTracker addressTracker;
        private final LoadBalancer.Subchannel delegate;
        private boolean ejected;
        private ConnectivityStateInfo lastSubchannelState;
        private final ChannelLogger logger;
        private LoadBalancer.SubchannelStateListener subchannelStateListener;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class OutlierDetectionSubchannelStateListener implements LoadBalancer.SubchannelStateListener {
            private final LoadBalancer.SubchannelStateListener delegate;

            public OutlierDetectionSubchannelStateListener(LoadBalancer.SubchannelStateListener subchannelStateListener) {
                this.delegate = subchannelStateListener;
            }

            @Override // io.grpc.LoadBalancer.SubchannelStateListener
            public void onSubchannelState(ConnectivityStateInfo connectivityStateInfo) {
                OutlierDetectionSubchannel.this.lastSubchannelState = connectivityStateInfo;
                if (OutlierDetectionSubchannel.this.ejected) {
                    return;
                }
                this.delegate.onSubchannelState(connectivityStateInfo);
            }
        }

        public OutlierDetectionSubchannel(LoadBalancer.Subchannel subchannel) {
            this.delegate = subchannel;
            this.logger = subchannel.getChannelLogger();
        }

        public void clearAddressTracker() {
            this.addressTracker = null;
        }

        @Override // io.grpc.util.ForwardingSubchannel
        public LoadBalancer.Subchannel delegate() {
            return this.delegate;
        }

        public void eject() {
            this.ejected = true;
            this.subchannelStateListener.onSubchannelState(ConnectivityStateInfo.forTransientFailure(Status.UNAVAILABLE));
            this.logger.log(ChannelLogger.ChannelLogLevel.INFO, "Subchannel ejected: {0}", this);
        }

        @Override // io.grpc.util.ForwardingSubchannel, io.grpc.LoadBalancer.Subchannel
        public Attributes getAttributes() {
            if (this.addressTracker != null) {
                return this.delegate.getAttributes().toBuilder().set(OutlierDetectionLoadBalancer.ADDRESS_TRACKER_ATTR_KEY, this.addressTracker).build();
            }
            return this.delegate.getAttributes();
        }

        public boolean isEjected() {
            return this.ejected;
        }

        public void setAddressTracker(AddressTracker addressTracker) {
            this.addressTracker = addressTracker;
        }

        @Override // io.grpc.util.ForwardingSubchannel, io.grpc.LoadBalancer.Subchannel
        public void start(LoadBalancer.SubchannelStateListener subchannelStateListener) {
            this.subchannelStateListener = subchannelStateListener;
            super.start(new OutlierDetectionSubchannelStateListener(subchannelStateListener));
        }

        @Override // io.grpc.util.ForwardingSubchannel
        public String toString() {
            return "OutlierDetectionSubchannel{addresses=" + ((Object) this.delegate.getAllAddresses()) + '}';
        }

        public void uneject() {
            this.ejected = false;
            ConnectivityStateInfo connectivityStateInfo = this.lastSubchannelState;
            if (connectivityStateInfo != null) {
                this.subchannelStateListener.onSubchannelState(connectivityStateInfo);
                this.logger.log(ChannelLogger.ChannelLogLevel.INFO, "Subchannel unejected: {0}", this);
            }
        }

        @Override // io.grpc.util.ForwardingSubchannel, io.grpc.LoadBalancer.Subchannel
        public void updateAddresses(List<EquivalentAddressGroup> list) {
            if (OutlierDetectionLoadBalancer.hasSingleAddress(getAllAddresses()) && OutlierDetectionLoadBalancer.hasSingleAddress(list)) {
                if (OutlierDetectionLoadBalancer.this.trackerMap.containsValue(this.addressTracker)) {
                    this.addressTracker.removeSubchannel(this);
                }
                SocketAddress socketAddress = list.get(0).getAddresses().get(0);
                if (OutlierDetectionLoadBalancer.this.trackerMap.containsKey(socketAddress)) {
                    OutlierDetectionLoadBalancer.this.trackerMap.get(socketAddress).addSubchannel(this);
                }
            } else if (OutlierDetectionLoadBalancer.hasSingleAddress(getAllAddresses()) && !OutlierDetectionLoadBalancer.hasSingleAddress(list)) {
                if (OutlierDetectionLoadBalancer.this.trackerMap.containsKey(getAddresses().getAddresses().get(0))) {
                    AddressTracker addressTracker = OutlierDetectionLoadBalancer.this.trackerMap.get(getAddresses().getAddresses().get(0));
                    addressTracker.removeSubchannel(this);
                    addressTracker.resetCallCounters();
                }
            } else if (!OutlierDetectionLoadBalancer.hasSingleAddress(getAllAddresses()) && OutlierDetectionLoadBalancer.hasSingleAddress(list)) {
                SocketAddress socketAddress2 = list.get(0).getAddresses().get(0);
                if (OutlierDetectionLoadBalancer.this.trackerMap.containsKey(socketAddress2)) {
                    OutlierDetectionLoadBalancer.this.trackerMap.get(socketAddress2).addSubchannel(this);
                }
            }
            this.delegate.updateAddresses(list);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface OutlierEjectionAlgorithm {
        void ejectOutliers(AddressTrackerMap addressTrackerMap, long j10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class SuccessRateOutlierEjectionAlgorithm implements OutlierEjectionAlgorithm {
        private final OutlierDetectionLoadBalancerConfig config;
        private final ChannelLogger logger;

        public SuccessRateOutlierEjectionAlgorithm(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, ChannelLogger channelLogger) {
            o.e(outlierDetectionLoadBalancerConfig.successRateEjection != null, "success rate ejection config is null");
            this.config = outlierDetectionLoadBalancerConfig;
            this.logger = channelLogger;
        }

        public static double mean(Collection<Double> collection) {
            Iterator<Double> iterator2 = collection.iterator2();
            double d10 = ShadowDrawableWrapper.COS_45;
            while (iterator2.hasNext()) {
                d10 += iterator2.next().doubleValue();
            }
            return d10 / collection.size();
        }

        public static double standardDeviation(Collection<Double> collection, double d10) {
            Iterator<Double> iterator2 = collection.iterator2();
            double d11 = ShadowDrawableWrapper.COS_45;
            while (iterator2.hasNext()) {
                double doubleValue = iterator2.next().doubleValue() - d10;
                d11 += doubleValue * doubleValue;
            }
            return Math.sqrt(d11 / collection.size());
        }

        @Override // io.grpc.util.OutlierDetectionLoadBalancer.OutlierEjectionAlgorithm
        public void ejectOutliers(AddressTrackerMap addressTrackerMap, long j10) {
            List<AddressTracker> trackersWithVolume = OutlierDetectionLoadBalancer.trackersWithVolume(addressTrackerMap, this.config.successRateEjection.requestVolume.intValue());
            if (trackersWithVolume.size() < this.config.successRateEjection.minimumHosts.intValue() || trackersWithVolume.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator iterator2 = trackersWithVolume.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(Double.valueOf(((AddressTracker) iterator2.next()).successRate()));
            }
            double mean = mean(arrayList);
            double standardDeviation = standardDeviation(arrayList, mean);
            double intValue = mean - ((this.config.successRateEjection.stdevFactor.intValue() / 1000.0f) * standardDeviation);
            for (AddressTracker addressTracker : trackersWithVolume) {
                if (addressTrackerMap.ejectionPercentage() >= this.config.maxEjectionPercent.intValue()) {
                    return;
                }
                if (addressTracker.successRate() < intValue) {
                    this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "SuccessRate algorithm detected outlier: {0}. Parameters: successRate={1}, mean={2}, stdev={3}, requiredSuccessRate={4}", addressTracker, Double.valueOf(addressTracker.successRate()), Double.valueOf(mean), Double.valueOf(standardDeviation), Double.valueOf(intValue));
                    if (new Random().nextInt(100) < this.config.successRateEjection.enforcementPercentage.intValue()) {
                        addressTracker.ejectSubchannels(j10);
                    }
                }
            }
        }
    }

    public OutlierDetectionLoadBalancer(LoadBalancer.Helper helper, TimeProvider timeProvider) {
        ChannelLogger channelLogger = helper.getChannelLogger();
        this.logger = channelLogger;
        ChildHelper childHelper = new ChildHelper((LoadBalancer.Helper) o.s(helper, "helper"));
        this.childHelper = childHelper;
        this.switchLb = new GracefulSwitchLoadBalancer(childHelper);
        this.trackerMap = new AddressTrackerMap();
        this.syncContext = (SynchronizationContext) o.s(helper.getSynchronizationContext(), "syncContext");
        this.timeService = (ScheduledExecutorService) o.s(helper.getScheduledExecutorService(), "timeService");
        this.timeProvider = timeProvider;
        channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "OutlierDetection lb created.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasSingleAddress(List<EquivalentAddressGroup> list) {
        Iterator<EquivalentAddressGroup> iterator2 = list.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            i10 += iterator2.next().getAddresses().size();
            if (i10 > 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AddressTracker> trackersWithVolume(AddressTrackerMap addressTrackerMap, int i10) {
        ArrayList arrayList = new ArrayList();
        for (AddressTracker addressTracker : addressTrackerMap.values()) {
            if (addressTracker.inactiveVolume() >= i10) {
                arrayList.add(addressTracker);
            }
        }
        return arrayList;
    }

    @Override // io.grpc.LoadBalancer
    public boolean acceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        Long valueOf;
        this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "Received resolution result: {0}", resolvedAddresses);
        OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig = (OutlierDetectionLoadBalancerConfig) resolvedAddresses.getLoadBalancingPolicyConfig();
        ArrayList arrayList = new ArrayList();
        Iterator<EquivalentAddressGroup> iterator2 = resolvedAddresses.getAddresses().iterator2();
        while (iterator2.hasNext()) {
            arrayList.addAll(iterator2.next().getAddresses());
        }
        this.trackerMap.h().retainAll(arrayList);
        this.trackerMap.updateTrackerConfigs(outlierDetectionLoadBalancerConfig);
        this.trackerMap.putNewTrackers(outlierDetectionLoadBalancerConfig, arrayList);
        this.switchLb.switchTo(outlierDetectionLoadBalancerConfig.childPolicy.getProvider());
        if (outlierDetectionLoadBalancerConfig.outlierDetectionEnabled()) {
            if (this.detectionTimerStartNanos == null) {
                valueOf = outlierDetectionLoadBalancerConfig.intervalNanos;
            } else {
                valueOf = Long.valueOf(Math.max(0L, outlierDetectionLoadBalancerConfig.intervalNanos.longValue() - (this.timeProvider.currentTimeNanos() - this.detectionTimerStartNanos.longValue())));
            }
            SynchronizationContext.ScheduledHandle scheduledHandle = this.detectionTimerHandle;
            if (scheduledHandle != null) {
                scheduledHandle.cancel();
                this.trackerMap.resetCallCounters();
            }
            this.detectionTimerHandle = this.syncContext.scheduleWithFixedDelay(new DetectionTimer(outlierDetectionLoadBalancerConfig, this.logger), valueOf.longValue(), outlierDetectionLoadBalancerConfig.intervalNanos.longValue(), TimeUnit.NANOSECONDS, this.timeService);
        } else {
            SynchronizationContext.ScheduledHandle scheduledHandle2 = this.detectionTimerHandle;
            if (scheduledHandle2 != null) {
                scheduledHandle2.cancel();
                this.detectionTimerStartNanos = null;
                this.trackerMap.cancelTracking();
            }
        }
        this.switchLb.handleResolvedAddresses(resolvedAddresses.toBuilder().setLoadBalancingPolicyConfig(outlierDetectionLoadBalancerConfig.childPolicy.getConfig()).build());
        return true;
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        this.switchLb.handleNameResolutionError(status);
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        this.switchLb.shutdown();
    }
}
