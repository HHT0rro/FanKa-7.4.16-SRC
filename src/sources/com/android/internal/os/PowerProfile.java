package com.android.internal.os;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.os.PowerProfileProto;
import com.android.internal.power.ModemPowerProfile;
import com.android.internal.util.XmlUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.function.BiConsumer;
import org.apache.commons.io.IOUtils;
import org.xmlpull.v1.XmlPullParserException;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PowerProfile {
    private static final String ATTR_NAME = "name";
    private static final String CPU_CLUSTER_POWER_COUNT = "cpu.cluster_power.cluster";
    private static final String CPU_CORE_POWER_PREFIX = "cpu.core_power.cluster";
    private static final String CPU_CORE_SPEED_PREFIX = "cpu.core_speeds.cluster";
    private static final String CPU_PER_CLUSTER_CORE_COUNT = "cpu.clusters.cores";
    private static final String CPU_POWER_BRACKETS_PREFIX = "cpu.power_brackets.cluster";
    private static final int DEFAULT_CPU_POWER_BRACKET_NUMBER = 3;

    @Deprecated
    public static final String POWER_AMBIENT_DISPLAY = "ambient.on";
    public static final String POWER_AUDIO = "audio";
    public static final String POWER_BATTERY_CAPACITY = "battery.capacity";

    @Deprecated
    public static final String POWER_BLUETOOTH_ACTIVE = "bluetooth.active";

    @Deprecated
    public static final String POWER_BLUETOOTH_AT_CMD = "bluetooth.at";
    public static final String POWER_BLUETOOTH_CONTROLLER_IDLE = "bluetooth.controller.idle";
    public static final String POWER_BLUETOOTH_CONTROLLER_OPERATING_VOLTAGE = "bluetooth.controller.voltage";
    public static final String POWER_BLUETOOTH_CONTROLLER_RX = "bluetooth.controller.rx";
    public static final String POWER_BLUETOOTH_CONTROLLER_TX = "bluetooth.controller.tx";

    @Deprecated
    public static final String POWER_BLUETOOTH_ON = "bluetooth.on";
    public static final String POWER_CAMERA = "camera.avg";
    public static final String POWER_CPU_ACTIVE = "cpu.active";
    public static final String POWER_CPU_IDLE = "cpu.idle";
    public static final String POWER_CPU_SUSPEND = "cpu.suspend";
    public static final String POWER_FLASHLIGHT = "camera.flashlight";
    public static final String POWER_GPS_ON = "gps.on";
    public static final String POWER_GPS_OPERATING_VOLTAGE = "gps.voltage";
    public static final String POWER_GPS_SIGNAL_QUALITY_BASED = "gps.signalqualitybased";
    public static final String POWER_GROUP_DISPLAY_AMBIENT = "ambient.on.display";
    public static final String POWER_GROUP_DISPLAY_SCREEN_FULL = "screen.full.display";
    public static final String POWER_GROUP_DISPLAY_SCREEN_ON = "screen.on.display";
    public static final String POWER_MEMORY = "memory.bandwidths";
    public static final String POWER_MODEM_CONTROLLER_IDLE = "modem.controller.idle";
    public static final String POWER_MODEM_CONTROLLER_OPERATING_VOLTAGE = "modem.controller.voltage";
    public static final String POWER_MODEM_CONTROLLER_RX = "modem.controller.rx";
    public static final String POWER_MODEM_CONTROLLER_SLEEP = "modem.controller.sleep";
    public static final String POWER_MODEM_CONTROLLER_TX = "modem.controller.tx";
    public static final String POWER_RADIO_ACTIVE = "radio.active";
    public static final String POWER_RADIO_ON = "radio.on";
    public static final String POWER_RADIO_SCANNING = "radio.scanning";

    @Deprecated
    public static final String POWER_SCREEN_FULL = "screen.full";

    @Deprecated
    public static final String POWER_SCREEN_ON = "screen.on";
    public static final String POWER_VIDEO = "video";
    public static final String POWER_WIFI_ACTIVE = "wifi.active";
    public static final String POWER_WIFI_BATCHED_SCAN = "wifi.batchedscan";
    public static final String POWER_WIFI_CONTROLLER_IDLE = "wifi.controller.idle";
    public static final String POWER_WIFI_CONTROLLER_OPERATING_VOLTAGE = "wifi.controller.voltage";
    public static final String POWER_WIFI_CONTROLLER_RX = "wifi.controller.rx";
    public static final String POWER_WIFI_CONTROLLER_TX = "wifi.controller.tx";
    public static final String POWER_WIFI_CONTROLLER_TX_LEVELS = "wifi.controller.tx_levels";
    public static final String POWER_WIFI_ON = "wifi.on";
    public static final String POWER_WIFI_SCAN = "wifi.scan";
    private static final long SUBSYSTEM_FIELDS_MASK = -1;
    private static final long SUBSYSTEM_MASK = 64424509440L;
    public static final long SUBSYSTEM_MODEM = 4294967296L;
    public static final long SUBSYSTEM_NONE = 0;
    public static final String TAG = "PowerProfile";
    private static final String TAG_ARRAY = "array";
    private static final String TAG_ARRAYITEM = "value";
    private static final String TAG_DEVICE = "device";
    private static final String TAG_ITEM = "item";
    private static final String TAG_MODEM = "modem";
    private CpuClusterKey[] mCpuClusters;
    private int mCpuPowerBracketCount;
    private int mNumDisplays;
    IPowerProfileExt mPowerProfileExt;
    static final HashMap<String, Double> sPowerItemMap = new HashMap<>();
    static final HashMap<String, Double[]> sPowerArrayMap = new HashMap<>();
    static final ModemPowerProfile sModemPowerProfile = new ModemPowerProfile();
    private static final Object sLock = new Object();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface PowerGroup {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface Subsystem {
    }

    public PowerProfile(Context context) {
        this(context, false);
    }

    public PowerProfile(Context context, boolean forTest) {
        this.mPowerProfileExt = (IPowerProfileExt) ExtLoader.type(IPowerProfileExt.class).base(this).create();
        synchronized (sLock) {
            int xmlId = forTest ? 18284564 : 18284563;
            initLocked(context, xmlId);
        }
    }

    public void forceInitForTesting(Context context, int xmlId) {
        synchronized (sLock) {
            sPowerItemMap.clear();
            sPowerArrayMap.clear();
            sModemPowerProfile.clear();
            initLocked(context, xmlId);
        }
    }

    private void initLocked(Context context, int xmlId) {
        if (sPowerItemMap.size() == 0 && sPowerArrayMap.size() == 0) {
            readPowerValuesFromXml(context, xmlId);
        }
        initCpuClusters();
        initDisplays();
        initModem();
    }

    private void readPowerValuesFromXml(Context context, int xmlId) {
        int value;
        Resources resources = context.getResources();
        if (!this.mPowerProfileExt.readPowerValuesFromXml(sPowerArrayMap, sPowerItemMap)) {
            XmlResourceParser parser = resources.getXml(xmlId);
            boolean parsingArray = false;
            ArrayList<Double> array = new ArrayList<>();
            String arrayName = null;
            try {
                try {
                    XmlUtils.beginDocument(parser, "device");
                    while (true) {
                        XmlUtils.nextElement(parser);
                        String element = parser.getName();
                        if (element == null) {
                            break;
                        }
                        if (parsingArray && !element.equals("value")) {
                            sPowerArrayMap.put(arrayName, (Double[]) array.toArray(new Double[array.size()]));
                            parsingArray = false;
                        }
                        if (element.equals(TAG_ARRAY)) {
                            parsingArray = true;
                            array.clear();
                            arrayName = parser.getAttributeValue(null, "name");
                        } else {
                            if (!element.equals("item") && !element.equals("value")) {
                                if (element.equals(TAG_MODEM)) {
                                    sModemPowerProfile.parseFromXml(parser);
                                }
                            }
                            String name = parsingArray ? null : parser.getAttributeValue(null, "name");
                            if (parser.next() == 4) {
                                String power = parser.getText();
                                double value2 = ShadowDrawableWrapper.COS_45;
                                try {
                                    value2 = Double.valueOf(power).doubleValue();
                                } catch (NumberFormatException e2) {
                                }
                                if (element.equals("item")) {
                                    sPowerItemMap.put(name, Double.valueOf(value2));
                                } else if (parsingArray) {
                                    array.add(Double.valueOf(value2));
                                }
                            }
                        }
                    }
                    if (parsingArray) {
                        sPowerArrayMap.put(arrayName, (Double[]) array.toArray(new Double[array.size()]));
                    }
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                } catch (XmlPullParserException e11) {
                    throw new RuntimeException(e11);
                }
            } finally {
                parser.close();
            }
        }
        int[] configResIds = {17694759, 17694764, 17694765, 17694763};
        String[] configResIdKeys = {POWER_BLUETOOTH_CONTROLLER_IDLE, POWER_BLUETOOTH_CONTROLLER_RX, POWER_BLUETOOTH_CONTROLLER_TX, POWER_BLUETOOTH_CONTROLLER_OPERATING_VOLTAGE};
        for (int i10 = 0; i10 < configResIds.length; i10++) {
            String key = configResIdKeys[i10];
            HashMap<String, Double> hashMap = sPowerItemMap;
            if ((!hashMap.containsKey(key) || hashMap.get(key).doubleValue() <= ShadowDrawableWrapper.COS_45) && (value = resources.getInteger(configResIds[i10])) > 0) {
                hashMap.put(key, Double.valueOf(value));
            }
        }
    }

    private void initCpuClusters() {
        HashMap<String, Double[]> hashMap = sPowerArrayMap;
        if (hashMap.containsKey(CPU_PER_CLUSTER_CORE_COUNT)) {
            Double[] data = hashMap.get(CPU_PER_CLUSTER_CORE_COUNT);
            this.mCpuClusters = new CpuClusterKey[data.length];
            for (int cluster = 0; cluster < data.length; cluster++) {
                int numCpusInCluster = (int) Math.round(data[cluster].doubleValue());
                this.mCpuClusters[cluster] = new CpuClusterKey(CPU_CORE_SPEED_PREFIX + cluster, CPU_CLUSTER_POWER_COUNT + cluster, CPU_CORE_POWER_PREFIX + cluster, numCpusInCluster);
            }
        } else {
            this.mCpuClusters = new CpuClusterKey[1];
            int numCpus = 1;
            HashMap<String, Double> hashMap2 = sPowerItemMap;
            if (hashMap2.containsKey(CPU_PER_CLUSTER_CORE_COUNT)) {
                numCpus = (int) Math.round(hashMap2.get(CPU_PER_CLUSTER_CORE_COUNT).doubleValue());
            }
            this.mCpuClusters[0] = new CpuClusterKey("cpu.core_speeds.cluster0", "cpu.cluster_power.cluster0", "cpu.core_power.cluster0", numCpus);
        }
        initCpuPowerBrackets(3);
    }

    public void initCpuPowerBrackets(int defaultCpuPowerBracketNumber) {
        boolean anyBracketsSpecified = false;
        boolean allBracketsSpecified = true;
        for (int cluster = 0; cluster < this.mCpuClusters.length; cluster++) {
            int steps = getNumSpeedStepsInCpuCluster(cluster);
            this.mCpuClusters[cluster].powerBrackets = new int[steps];
            if (sPowerArrayMap.get(CPU_POWER_BRACKETS_PREFIX + cluster) != null) {
                anyBracketsSpecified = true;
            } else {
                allBracketsSpecified = false;
            }
        }
        if (!anyBracketsSpecified || allBracketsSpecified) {
            this.mCpuPowerBracketCount = 0;
            if (allBracketsSpecified) {
                for (int cluster2 = 0; cluster2 < this.mCpuClusters.length; cluster2++) {
                    Double[] data = sPowerArrayMap.get(CPU_POWER_BRACKETS_PREFIX + cluster2);
                    if (data.length != this.mCpuClusters[cluster2].powerBrackets.length) {
                        throw new RuntimeException("Wrong number of items in cpu.power_brackets.cluster" + cluster2);
                    }
                    for (int i10 = 0; i10 < data.length; i10++) {
                        int bracket = (int) Math.round(data[i10].doubleValue());
                        this.mCpuClusters[cluster2].powerBrackets[i10] = bracket;
                        if (bracket > this.mCpuPowerBracketCount) {
                            this.mCpuPowerBracketCount = bracket;
                        }
                    }
                }
                int cluster3 = this.mCpuPowerBracketCount;
                this.mCpuPowerBracketCount = cluster3 + 1;
                return;
            }
            double minPower = Double.MAX_VALUE;
            double maxPower = Double.MIN_VALUE;
            int stateCount = 0;
            for (int cluster4 = 0; cluster4 < this.mCpuClusters.length; cluster4++) {
                int steps2 = getNumSpeedStepsInCpuCluster(cluster4);
                for (int step = 0; step < steps2; step++) {
                    double power = getAveragePowerForCpuCore(cluster4, step);
                    if (power < minPower) {
                        minPower = power;
                    }
                    if (power > maxPower) {
                        maxPower = power;
                    }
                }
                stateCount += steps2;
            }
            if (stateCount <= defaultCpuPowerBracketNumber) {
                this.mCpuPowerBracketCount = stateCount;
                int bracket2 = 0;
                for (int cluster5 = 0; cluster5 < this.mCpuClusters.length; cluster5++) {
                    int steps3 = getNumSpeedStepsInCpuCluster(cluster5);
                    int step2 = 0;
                    while (step2 < steps3) {
                        this.mCpuClusters[cluster5].powerBrackets[step2] = bracket2;
                        step2++;
                        bracket2++;
                    }
                }
                return;
            }
            this.mCpuPowerBracketCount = defaultCpuPowerBracketNumber;
            double minLogPower = Math.log(minPower);
            double logBracket = (Math.log(maxPower) - minLogPower) / defaultCpuPowerBracketNumber;
            for (int cluster6 = 0; cluster6 < this.mCpuClusters.length; cluster6++) {
                int steps4 = getNumSpeedStepsInCpuCluster(cluster6);
                int step3 = 0;
                while (step3 < steps4) {
                    boolean anyBracketsSpecified2 = anyBracketsSpecified;
                    boolean allBracketsSpecified2 = allBracketsSpecified;
                    int bracket3 = (int) ((Math.log(getAveragePowerForCpuCore(cluster6, step3)) - minLogPower) / logBracket);
                    if (bracket3 >= defaultCpuPowerBracketNumber) {
                        bracket3 = defaultCpuPowerBracketNumber - 1;
                    }
                    this.mCpuClusters[cluster6].powerBrackets[step3] = bracket3;
                    step3++;
                    allBracketsSpecified = allBracketsSpecified2;
                    anyBracketsSpecified = anyBracketsSpecified2;
                }
            }
            return;
        }
        throw new RuntimeException("Power brackets should be specified for all clusters or no clusters");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class CpuClusterKey {
        public final String clusterPowerKey;
        public final String corePowerKey;
        public final String freqKey;
        public final int numCpus;
        public int[] powerBrackets;

        private CpuClusterKey(String freqKey, String clusterPowerKey, String corePowerKey, int numCpus) {
            this.freqKey = freqKey;
            this.clusterPowerKey = clusterPowerKey;
            this.corePowerKey = corePowerKey;
            this.numCpus = numCpus;
        }
    }

    public int getNumCpuClusters() {
        return this.mCpuClusters.length;
    }

    public int getNumCoresInCpuCluster(int cluster) {
        if (cluster < 0) {
            return 0;
        }
        CpuClusterKey[] cpuClusterKeyArr = this.mCpuClusters;
        if (cluster >= cpuClusterKeyArr.length) {
            return 0;
        }
        return cpuClusterKeyArr[cluster].numCpus;
    }

    public int getNumSpeedStepsInCpuCluster(int cluster) {
        if (cluster < 0) {
            return 0;
        }
        CpuClusterKey[] cpuClusterKeyArr = this.mCpuClusters;
        if (cluster >= cpuClusterKeyArr.length) {
            return 0;
        }
        HashMap<String, Double[]> hashMap = sPowerArrayMap;
        if (hashMap.containsKey(cpuClusterKeyArr[cluster].freqKey)) {
            return hashMap.get(this.mCpuClusters[cluster].freqKey).length;
        }
        return 1;
    }

    public double getAveragePowerForCpuCluster(int cluster) {
        if (cluster < 0) {
            return ShadowDrawableWrapper.COS_45;
        }
        CpuClusterKey[] cpuClusterKeyArr = this.mCpuClusters;
        if (cluster < cpuClusterKeyArr.length) {
            return getAveragePower(cpuClusterKeyArr[cluster].clusterPowerKey);
        }
        return ShadowDrawableWrapper.COS_45;
    }

    public double getAveragePowerForCpuCore(int cluster, int step) {
        if (cluster < 0) {
            return ShadowDrawableWrapper.COS_45;
        }
        CpuClusterKey[] cpuClusterKeyArr = this.mCpuClusters;
        if (cluster < cpuClusterKeyArr.length) {
            return getAveragePower(cpuClusterKeyArr[cluster].corePowerKey, step);
        }
        return ShadowDrawableWrapper.COS_45;
    }

    public int getCpuPowerBracketCount() {
        return this.mCpuPowerBracketCount;
    }

    public String getCpuPowerBracketDescription(int powerBracket) {
        StringBuilder sb2 = new StringBuilder();
        int cluster = 0;
        while (true) {
            CpuClusterKey[] cpuClusterKeyArr = this.mCpuClusters;
            if (cluster < cpuClusterKeyArr.length) {
                int[] brackets = cpuClusterKeyArr[cluster].powerBrackets;
                for (int step = 0; step < brackets.length; step++) {
                    if (brackets[step] == powerBracket) {
                        if (sb2.length() != 0) {
                            sb2.append(", ");
                        }
                        if (this.mCpuClusters.length > 1) {
                            sb2.append(cluster).append(IOUtils.DIR_SEPARATOR_UNIX);
                        }
                        Double[] freqs = sPowerArrayMap.get(this.mCpuClusters[cluster].freqKey);
                        if (freqs != null && step < freqs.length) {
                            sb2.append(freqs[step].intValue() / 1000);
                        }
                        sb2.append('(');
                        sb2.append(String.format(Locale.US, "%.1f", Double.valueOf(getAveragePowerForCpuCore(cluster, step))));
                        sb2.append(')');
                    }
                }
                cluster++;
            } else {
                return sb2.toString();
            }
        }
    }

    public int getPowerBracketForCpuCore(int cluster, int step) {
        if (cluster < 0) {
            return 0;
        }
        CpuClusterKey[] cpuClusterKeyArr = this.mCpuClusters;
        if (cluster < cpuClusterKeyArr.length && step >= 0 && step < cpuClusterKeyArr[cluster].powerBrackets.length) {
            return this.mCpuClusters[cluster].powerBrackets[step];
        }
        return 0;
    }

    private void initDisplays() {
        this.mNumDisplays = 0;
        while (true) {
            if (Double.isNaN(getAveragePowerForOrdinal(POWER_GROUP_DISPLAY_AMBIENT, this.mNumDisplays, Double.NaN)) && Double.isNaN(getAveragePowerForOrdinal(POWER_GROUP_DISPLAY_SCREEN_ON, this.mNumDisplays, Double.NaN)) && Double.isNaN(getAveragePowerForOrdinal(POWER_GROUP_DISPLAY_SCREEN_FULL, this.mNumDisplays, Double.NaN))) {
                break;
            } else {
                this.mNumDisplays++;
            }
        }
        HashMap<String, Double> hashMap = sPowerItemMap;
        Double deprecatedAmbientDisplay = hashMap.get(POWER_AMBIENT_DISPLAY);
        boolean legacy = false;
        if (deprecatedAmbientDisplay != null && this.mNumDisplays == 0) {
            String key = getOrdinalPowerType(POWER_GROUP_DISPLAY_AMBIENT, 0);
            Slog.w(TAG, "ambient.on is deprecated! Use " + key + " instead.");
            hashMap.put(key, deprecatedAmbientDisplay);
            legacy = true;
        }
        Double deprecatedScreenOn = hashMap.get(POWER_SCREEN_ON);
        if (deprecatedScreenOn != null && this.mNumDisplays == 0) {
            String key2 = getOrdinalPowerType(POWER_GROUP_DISPLAY_SCREEN_ON, 0);
            Slog.w(TAG, "screen.on is deprecated! Use " + key2 + " instead.");
            hashMap.put(key2, deprecatedScreenOn);
            legacy = true;
        }
        Double deprecatedScreenFull = hashMap.get(POWER_SCREEN_FULL);
        if (deprecatedScreenFull != null && this.mNumDisplays == 0) {
            String key3 = getOrdinalPowerType(POWER_GROUP_DISPLAY_SCREEN_FULL, 0);
            Slog.w(TAG, "screen.full is deprecated! Use " + key3 + " instead.");
            hashMap.put(key3, deprecatedScreenFull);
            legacy = true;
        }
        if (legacy) {
            this.mNumDisplays = 1;
        }
    }

    public int getNumDisplays() {
        return this.mNumDisplays;
    }

    private void initModem() {
        handleDeprecatedModemConstant(0, POWER_MODEM_CONTROLLER_SLEEP, 0);
        handleDeprecatedModemConstant(268435456, POWER_MODEM_CONTROLLER_IDLE, 0);
        handleDeprecatedModemConstant(536870912, POWER_MODEM_CONTROLLER_RX, 0);
        handleDeprecatedModemConstant(ModemPowerProfile.MODEM_DRAIN_TYPE_TX, POWER_MODEM_CONTROLLER_TX, 0);
        handleDeprecatedModemConstant(822083584, POWER_MODEM_CONTROLLER_TX, 1);
        handleDeprecatedModemConstant(838860800, POWER_MODEM_CONTROLLER_TX, 2);
        handleDeprecatedModemConstant(855638016, POWER_MODEM_CONTROLLER_TX, 3);
        handleDeprecatedModemConstant(872415232, POWER_MODEM_CONTROLLER_TX, 4);
    }

    private void handleDeprecatedModemConstant(int key, String deprecatedKey, int level) {
        ModemPowerProfile modemPowerProfile = sModemPowerProfile;
        double drain = modemPowerProfile.getAverageBatteryDrainMa(key);
        if (Double.isNaN(drain)) {
            double deprecatedDrain = getAveragePower(deprecatedKey, level);
            modemPowerProfile.setPowerConstant(key, Double.toString(deprecatedDrain));
        }
    }

    public int getNumElements(String key) {
        if (sPowerItemMap.containsKey(key)) {
            return 1;
        }
        HashMap<String, Double[]> hashMap = sPowerArrayMap;
        if (hashMap.containsKey(key)) {
            return hashMap.get(key).length;
        }
        return 0;
    }

    public double getAveragePowerOrDefault(String type, double defaultValue) {
        HashMap<String, Double> hashMap = sPowerItemMap;
        if (hashMap.containsKey(type)) {
            return hashMap.get(type).doubleValue();
        }
        HashMap<String, Double[]> hashMap2 = sPowerArrayMap;
        if (hashMap2.containsKey(type)) {
            return hashMap2.get(type)[0].doubleValue();
        }
        return defaultValue;
    }

    public double getAveragePower(String type) {
        return getAveragePowerOrDefault(type, ShadowDrawableWrapper.COS_45);
    }

    public double getAverageBatteryDrainOrDefaultMa(long key, double defaultValue) {
        double value;
        long subsystemType = SUBSYSTEM_MASK & key;
        int subsystemFields = (int) ((-1) & key);
        if (subsystemType == SUBSYSTEM_MODEM) {
            value = sModemPowerProfile.getAverageBatteryDrainMa(subsystemFields);
        } else {
            value = Double.NaN;
        }
        return Double.isNaN(value) ? defaultValue : value;
    }

    public double getAverageBatteryDrainMa(long key) {
        return getAverageBatteryDrainOrDefaultMa(key, ShadowDrawableWrapper.COS_45);
    }

    public double getAveragePower(String type, int level) {
        HashMap<String, Double> hashMap = sPowerItemMap;
        if (hashMap.containsKey(type)) {
            return hashMap.get(type).doubleValue();
        }
        HashMap<String, Double[]> hashMap2 = sPowerArrayMap;
        if (!hashMap2.containsKey(type)) {
            return ShadowDrawableWrapper.COS_45;
        }
        Double[] values = hashMap2.get(type);
        if (values.length <= level || level < 0) {
            return (level < 0 || values.length == 0) ? ShadowDrawableWrapper.COS_45 : values[values.length - 1].doubleValue();
        }
        return values[level].doubleValue();
    }

    public double getAveragePowerForOrdinal(String group, int ordinal, double defaultValue) {
        String type = getOrdinalPowerType(group, ordinal);
        return getAveragePowerOrDefault(type, defaultValue);
    }

    public double getAveragePowerForOrdinal(String group, int ordinal) {
        return getAveragePowerForOrdinal(group, ordinal, ShadowDrawableWrapper.COS_45);
    }

    public double getBatteryCapacity() {
        return getAveragePower(POWER_BATTERY_CAPACITY);
    }

    public void dumpDebug(ProtoOutputStream proto) {
        writePowerConstantToProto(proto, POWER_CPU_SUSPEND, PowerProfileProto.CPU_SUSPEND);
        writePowerConstantToProto(proto, POWER_CPU_IDLE, 1103806595074L);
        writePowerConstantToProto(proto, POWER_CPU_ACTIVE, PowerProfileProto.CPU_ACTIVE);
        for (int cluster = 0; cluster < this.mCpuClusters.length; cluster++) {
            long token = proto.start(PowerProfileProto.CPU_CLUSTER);
            proto.write(1120986464257L, cluster);
            proto.write(1103806595074L, sPowerItemMap.get(this.mCpuClusters[cluster].clusterPowerKey).doubleValue());
            proto.write(1120986464259L, this.mCpuClusters[cluster].numCpus);
            for (Double speed : sPowerArrayMap.get(this.mCpuClusters[cluster].freqKey)) {
                proto.write(PowerProfileProto.CpuCluster.SPEED, speed.doubleValue());
            }
            for (Double corePower : sPowerArrayMap.get(this.mCpuClusters[cluster].corePowerKey)) {
                proto.write(PowerProfileProto.CpuCluster.CORE_POWER, corePower.doubleValue());
            }
            proto.end(token);
        }
        writePowerConstantToProto(proto, POWER_WIFI_SCAN, PowerProfileProto.WIFI_SCAN);
        writePowerConstantToProto(proto, POWER_WIFI_ON, PowerProfileProto.WIFI_ON);
        writePowerConstantToProto(proto, POWER_WIFI_ACTIVE, PowerProfileProto.WIFI_ACTIVE);
        writePowerConstantToProto(proto, POWER_WIFI_CONTROLLER_IDLE, PowerProfileProto.WIFI_CONTROLLER_IDLE);
        writePowerConstantToProto(proto, POWER_WIFI_CONTROLLER_RX, PowerProfileProto.WIFI_CONTROLLER_RX);
        writePowerConstantToProto(proto, POWER_WIFI_CONTROLLER_TX, PowerProfileProto.WIFI_CONTROLLER_TX);
        writePowerConstantArrayToProto(proto, POWER_WIFI_CONTROLLER_TX_LEVELS, PowerProfileProto.WIFI_CONTROLLER_TX_LEVELS);
        writePowerConstantToProto(proto, POWER_WIFI_CONTROLLER_OPERATING_VOLTAGE, PowerProfileProto.WIFI_CONTROLLER_OPERATING_VOLTAGE);
        writePowerConstantToProto(proto, POWER_BLUETOOTH_CONTROLLER_IDLE, PowerProfileProto.BLUETOOTH_CONTROLLER_IDLE);
        writePowerConstantToProto(proto, POWER_BLUETOOTH_CONTROLLER_RX, PowerProfileProto.BLUETOOTH_CONTROLLER_RX);
        writePowerConstantToProto(proto, POWER_BLUETOOTH_CONTROLLER_TX, PowerProfileProto.BLUETOOTH_CONTROLLER_TX);
        writePowerConstantToProto(proto, POWER_BLUETOOTH_CONTROLLER_OPERATING_VOLTAGE, PowerProfileProto.BLUETOOTH_CONTROLLER_OPERATING_VOLTAGE);
        writePowerConstantToProto(proto, POWER_MODEM_CONTROLLER_SLEEP, PowerProfileProto.MODEM_CONTROLLER_SLEEP);
        writePowerConstantToProto(proto, POWER_MODEM_CONTROLLER_IDLE, PowerProfileProto.MODEM_CONTROLLER_IDLE);
        writePowerConstantToProto(proto, POWER_MODEM_CONTROLLER_RX, PowerProfileProto.MODEM_CONTROLLER_RX);
        writePowerConstantArrayToProto(proto, POWER_MODEM_CONTROLLER_TX, PowerProfileProto.MODEM_CONTROLLER_TX);
        writePowerConstantToProto(proto, POWER_MODEM_CONTROLLER_OPERATING_VOLTAGE, PowerProfileProto.MODEM_CONTROLLER_OPERATING_VOLTAGE);
        writePowerConstantToProto(proto, POWER_GPS_ON, PowerProfileProto.GPS_ON);
        writePowerConstantArrayToProto(proto, POWER_GPS_SIGNAL_QUALITY_BASED, PowerProfileProto.GPS_SIGNAL_QUALITY_BASED);
        writePowerConstantToProto(proto, POWER_GPS_OPERATING_VOLTAGE, PowerProfileProto.GPS_OPERATING_VOLTAGE);
        writePowerConstantToProto(proto, POWER_BLUETOOTH_ON, PowerProfileProto.BLUETOOTH_ON);
        writePowerConstantToProto(proto, POWER_BLUETOOTH_ACTIVE, PowerProfileProto.BLUETOOTH_ACTIVE);
        writePowerConstantToProto(proto, POWER_BLUETOOTH_AT_CMD, PowerProfileProto.BLUETOOTH_AT_CMD);
        writePowerConstantToProto(proto, POWER_AMBIENT_DISPLAY, PowerProfileProto.AMBIENT_DISPLAY);
        writePowerConstantToProto(proto, POWER_SCREEN_ON, PowerProfileProto.SCREEN_ON);
        writePowerConstantToProto(proto, POWER_RADIO_ON, PowerProfileProto.RADIO_ON);
        writePowerConstantToProto(proto, POWER_RADIO_SCANNING, PowerProfileProto.RADIO_SCANNING);
        writePowerConstantToProto(proto, POWER_RADIO_ACTIVE, PowerProfileProto.RADIO_ACTIVE);
        writePowerConstantToProto(proto, POWER_SCREEN_FULL, PowerProfileProto.SCREEN_FULL);
        writePowerConstantToProto(proto, POWER_AUDIO, PowerProfileProto.AUDIO);
        writePowerConstantToProto(proto, "video", PowerProfileProto.VIDEO);
        writePowerConstantToProto(proto, POWER_FLASHLIGHT, PowerProfileProto.FLASHLIGHT);
        writePowerConstantToProto(proto, POWER_MEMORY, PowerProfileProto.MEMORY);
        writePowerConstantToProto(proto, POWER_CAMERA, PowerProfileProto.CAMERA);
        writePowerConstantToProto(proto, POWER_WIFI_BATCHED_SCAN, PowerProfileProto.WIFI_BATCHED_SCAN);
        writePowerConstantToProto(proto, POWER_BATTERY_CAPACITY, PowerProfileProto.BATTERY_CAPACITY);
    }

    public void dump(PrintWriter pw) {
        final PrintWriter indentingPrintWriter = new IndentingPrintWriter(pw);
        sPowerItemMap.forEach(new BiConsumer() { // from class: com.android.internal.os.PowerProfile$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                PowerProfile.lambda$dump$0(indentingPrintWriter, (String) obj, (Double) obj2);
            }
        });
        sPowerArrayMap.forEach(new BiConsumer() { // from class: com.android.internal.os.PowerProfile$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                PowerProfile.lambda$dump$1(indentingPrintWriter, (String) obj, (Double[]) obj2);
            }
        });
        indentingPrintWriter.println("Modem values:");
        indentingPrintWriter.increaseIndent();
        sModemPowerProfile.dump(indentingPrintWriter);
        indentingPrintWriter.decreaseIndent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$dump$0(IndentingPrintWriter ipw, String key, Double value) {
        ipw.print(key, value);
        ipw.println();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$dump$1(IndentingPrintWriter ipw, String key, Double[] value) {
        ipw.print(key, Arrays.toString(value));
        ipw.println();
    }

    private void writePowerConstantToProto(ProtoOutputStream proto, String key, long fieldId) {
        HashMap<String, Double> hashMap = sPowerItemMap;
        if (hashMap.containsKey(key)) {
            proto.write(fieldId, hashMap.get(key).doubleValue());
        }
    }

    private void writePowerConstantArrayToProto(ProtoOutputStream proto, String key, long fieldId) {
        HashMap<String, Double[]> hashMap = sPowerArrayMap;
        if (hashMap.containsKey(key)) {
            for (Double d10 : hashMap.get(key)) {
                proto.write(fieldId, d10.doubleValue());
            }
        }
    }

    private static String getOrdinalPowerType(String group, int ordinal) {
        return group + ordinal;
    }
}
