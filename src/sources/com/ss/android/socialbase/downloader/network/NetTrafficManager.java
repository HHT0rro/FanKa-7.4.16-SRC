package com.ss.android.socialbase.downloader.network;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NetTrafficManager {
    private static final long BANDWIDTH_LOWER_BOUND = 3;
    private static final int BYTES_TO_BITS = 8;
    private static final double DEFAULT_DECAY_CONSTANT = 0.05d;
    private static final int DEFAULT_GOOD_BANDWIDTH = 2000;
    private static final long DEFAULT_HYSTERESIS_PERCENT = 20;
    private static final int DEFAULT_MODERATE_BANDWIDTH = 550;
    private static final int DEFAULT_POOR_BANDWIDTH = 150;
    private static final double DEFAULT_SAMPLES_TO_QUALITY_CHANGE = 5.0d;
    private static final double HYSTERESIS_BOTTOM_MULTIPLIER = 0.8d;
    private static final double HYSTERESIS_TOP_MULTIPLIER = 1.25d;
    private static final String TAG = "NetTrafficManager";
    private final AtomicReference<NetworkQuality> currentNetworkQuality;
    private volatile boolean initiateStateChange;
    private final ArrayList<NetworkStateChangeListener> listenerList;
    private final ExponentialGeometricAverage mDownloadBandwidth;
    private AtomicReference<NetworkQuality> nextNetworkQuality;
    private int sampleCount;

    /* renamed from: com.ss.android.socialbase.downloader.network.NetTrafficManager$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality;

        static {
            int[] iArr = new int[NetworkQuality.values().length];
            $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality = iArr;
            try {
                iArr[NetworkQuality.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ConnectionClassManagerHolder {
        public static final NetTrafficManager instance = new NetTrafficManager(null);

        private ConnectionClassManagerHolder() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface NetworkStateChangeListener {
        void onBandwidthStateChange(NetworkQuality networkQuality);
    }

    public /* synthetic */ NetTrafficManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static NetTrafficManager getInstance() {
        return ConnectionClassManagerHolder.instance;
    }

    private NetworkQuality mapBandwidthQuality(double d10) {
        if (d10 < ShadowDrawableWrapper.COS_45) {
            return NetworkQuality.UNKNOWN;
        }
        if (d10 < 150.0d) {
            return NetworkQuality.POOR;
        }
        if (d10 < 550.0d) {
            return NetworkQuality.MODERATE;
        }
        if (d10 < 2000.0d) {
            return NetworkQuality.GOOD;
        }
        return NetworkQuality.EXCELLENT;
    }

    private void notifyListeners() {
        try {
            int size = this.listenerList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.listenerList.get(i10).onBandwidthStateChange(this.currentNetworkQuality.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean significantlyOutsideCurrentBand() {
        if (this.mDownloadBandwidth == null) {
            return false;
        }
        try {
            int i10 = AnonymousClass1.$SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[this.currentNetworkQuality.get().ordinal()];
            double d10 = 2000.0d;
            double d11 = 550.0d;
            if (i10 == 1) {
                d11 = 0.0d;
                d10 = 150.0d;
            } else if (i10 == 2) {
                d10 = 550.0d;
                d11 = 150.0d;
            } else if (i10 != 3) {
                if (i10 != 4) {
                    return true;
                }
                d10 = 3.4028234663852886E38d;
                d11 = 2000.0d;
            }
            double average = this.mDownloadBandwidth.getAverage();
            if (average > d10) {
                if (average > d10 * HYSTERESIS_TOP_MULTIPLIER) {
                    return true;
                }
            } else if (average < d11 * HYSTERESIS_BOTTOM_MULTIPLIER) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public synchronized void addBandwidth(long j10, long j11) {
        NetworkQuality currentNetworkQuality;
        double d10 = ((j10 * 1.0d) / j11) * 8.0d;
        if (j11 == 0 || d10 < 3.0d) {
            return;
        }
        try {
            this.mDownloadBandwidth.addMeasurement(d10);
            currentNetworkQuality = getCurrentNetworkQuality();
        } catch (Throwable unused) {
        }
        if (this.initiateStateChange) {
            this.sampleCount++;
            if (currentNetworkQuality != this.nextNetworkQuality.get()) {
                this.initiateStateChange = false;
                this.sampleCount = 1;
            }
            if (this.sampleCount >= DEFAULT_SAMPLES_TO_QUALITY_CHANGE && significantlyOutsideCurrentBand()) {
                this.initiateStateChange = false;
                this.sampleCount = 1;
                this.currentNetworkQuality.set(this.nextNetworkQuality.get());
                notifyListeners();
            }
            return;
        }
        if (this.currentNetworkQuality.get() != currentNetworkQuality) {
            this.initiateStateChange = true;
            this.nextNetworkQuality = new AtomicReference<>(currentNetworkQuality);
        }
    }

    public synchronized NetworkQuality getCurrentNetworkQuality() {
        ExponentialGeometricAverage exponentialGeometricAverage = this.mDownloadBandwidth;
        if (exponentialGeometricAverage == null) {
            return NetworkQuality.UNKNOWN;
        }
        try {
            return mapBandwidthQuality(exponentialGeometricAverage.getAverage());
        } catch (Throwable th) {
            th.printStackTrace();
            return NetworkQuality.UNKNOWN;
        }
    }

    public synchronized double getDownloadKBitsPerSecond() {
        ExponentialGeometricAverage exponentialGeometricAverage;
        exponentialGeometricAverage = this.mDownloadBandwidth;
        return exponentialGeometricAverage == null ? -1.0d : exponentialGeometricAverage.getAverage();
    }

    public NetworkQuality register(NetworkStateChangeListener networkStateChangeListener) {
        if (networkStateChangeListener != null) {
            this.listenerList.add(networkStateChangeListener);
        }
        return this.currentNetworkQuality.get();
    }

    public void remove(NetworkStateChangeListener networkStateChangeListener) {
        if (networkStateChangeListener != null) {
            this.listenerList.remove(networkStateChangeListener);
        }
    }

    public void reset() {
        try {
            ExponentialGeometricAverage exponentialGeometricAverage = this.mDownloadBandwidth;
            if (exponentialGeometricAverage != null) {
                exponentialGeometricAverage.reset();
            }
            this.currentNetworkQuality.set(NetworkQuality.UNKNOWN);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private NetTrafficManager() {
        this.mDownloadBandwidth = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.initiateStateChange = false;
        this.currentNetworkQuality = new AtomicReference<>(NetworkQuality.UNKNOWN);
        this.listenerList = new ArrayList<>();
    }
}
