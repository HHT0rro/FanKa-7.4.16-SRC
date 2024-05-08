package com.android.internal.os;

import android.util.ArrayMap;
import android.util.Slog;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class RailStats {
    private static final String CELLULAR_SUBSYSTEM = "cellular";
    private static final String TAG = "RailStats";
    private static final String WIFI_SUBSYSTEM = "wifi";
    private Map<Long, RailInfoData> mRailInfoData = new ArrayMap();
    private long mCellularTotalEnergyUseduWs = 0;
    private long mWifiTotalEnergyUseduWs = 0;
    private boolean mRailStatsAvailability = true;

    public void updateRailData(long index, String railName, String subSystemName, long timestampSinceBootMs, long energyUsedSinceBootuWs) {
        if (!subSystemName.equals("wifi") && !subSystemName.equals("cellular")) {
            return;
        }
        RailInfoData node = this.mRailInfoData.get(Long.valueOf(index));
        if (node == null) {
            this.mRailInfoData.put(Long.valueOf(index), new RailInfoData(index, railName, subSystemName, timestampSinceBootMs, energyUsedSinceBootuWs));
            if (subSystemName.equals("wifi")) {
                this.mWifiTotalEnergyUseduWs += energyUsedSinceBootuWs;
                return;
            } else {
                if (subSystemName.equals("cellular")) {
                    this.mCellularTotalEnergyUseduWs += energyUsedSinceBootuWs;
                    return;
                }
                return;
            }
        }
        long timeSinceLastLogMs = timestampSinceBootMs - node.timestampSinceBootMs;
        long energyUsedSinceLastLoguWs = energyUsedSinceBootuWs - node.energyUsedSinceBootuWs;
        if (timeSinceLastLogMs < 0 || energyUsedSinceLastLoguWs < 0) {
            energyUsedSinceLastLoguWs = node.energyUsedSinceBootuWs;
        }
        node.timestampSinceBootMs = timestampSinceBootMs;
        node.energyUsedSinceBootuWs = energyUsedSinceBootuWs;
        if (subSystemName.equals("wifi")) {
            this.mWifiTotalEnergyUseduWs += energyUsedSinceLastLoguWs;
        } else if (subSystemName.equals("cellular")) {
            this.mCellularTotalEnergyUseduWs += energyUsedSinceLastLoguWs;
        }
    }

    public void resetCellularTotalEnergyUsed() {
        this.mCellularTotalEnergyUseduWs = 0L;
    }

    public void resetWifiTotalEnergyUsed() {
        this.mWifiTotalEnergyUseduWs = 0L;
    }

    public long getCellularTotalEnergyUseduWs() {
        return this.mCellularTotalEnergyUseduWs;
    }

    public long getWifiTotalEnergyUseduWs() {
        return this.mWifiTotalEnergyUseduWs;
    }

    public void reset() {
        this.mCellularTotalEnergyUseduWs = 0L;
        this.mWifiTotalEnergyUseduWs = 0L;
    }

    public RailStats getRailStats() {
        return this;
    }

    public void setRailStatsAvailability(boolean railStatsAvailability) {
        this.mRailStatsAvailability = railStatsAvailability;
    }

    public boolean isRailStatsAvailable() {
        return this.mRailStatsAvailability;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RailInfoData {
        private static final String TAG = "RailInfoData";
        public long energyUsedSinceBootuWs;
        public long index;
        public String railName;
        public String subSystemName;
        public long timestampSinceBootMs;

        private RailInfoData(long index, String railName, String subSystemName, long timestampSinceBootMs, long energyUsedSinceBoot) {
            this.index = index;
            this.railName = railName;
            this.subSystemName = subSystemName;
            this.timestampSinceBootMs = timestampSinceBootMs;
            this.energyUsedSinceBootuWs = energyUsedSinceBoot;
        }

        public void printData() {
            Slog.d(TAG, "Index = " + this.index);
            Slog.d(TAG, "RailName = " + this.railName);
            Slog.d(TAG, "SubSystemName = " + this.subSystemName);
            Slog.d(TAG, "TimestampSinceBootMs = " + this.timestampSinceBootMs);
            Slog.d(TAG, "EnergyUsedSinceBootuWs = " + this.energyUsedSinceBootuWs);
        }
    }
}
