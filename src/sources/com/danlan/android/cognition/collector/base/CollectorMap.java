package com.danlan.android.cognition.collector.base;

import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.AppCollector;
import com.danlan.android.cognition.collector.AudioCollector;
import com.danlan.android.cognition.collector.BatteryCollector;
import com.danlan.android.cognition.collector.CameraCollector;
import com.danlan.android.cognition.collector.CpuCollector;
import com.danlan.android.cognition.collector.DisplayCollector;
import com.danlan.android.cognition.collector.HardwareCollector;
import com.danlan.android.cognition.collector.MemoryCollector;
import com.danlan.android.cognition.collector.NetworkCollector;
import com.danlan.android.cognition.collector.RiskCollector;
import com.danlan.android.cognition.collector.SensorCollector;
import com.danlan.android.cognition.collector.SimCardCollector;
import com.danlan.android.cognition.collector.SystemCollector;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum CollectorMap {
    HARDARE(StringFog.decrypt("SUJWR1ZCVkQ="), HardwareCollector.class),
    SYSTEM(StringFog.decrypt("UlpXV0RO"), SystemCollector.class),
    NETWORK(StringFog.decrypt("T0ZQVE5RTw=="), NetworkCollector.class),
    APP(StringFog.decrypt("QFNUT0hARVVITEo="), AppCollector.class),
    SIM(StringFog.decrypt("UkpJ"), SimCardCollector.class),
    BATTERY(StringFog.decrypt("Q0JQV0RRXQ=="), BatteryCollector.class),
    DISPLAY(StringFog.decrypt("RUpXU01CXQ=="), DisplayCollector.class),
    CPU(StringFog.decrypt("QlNR"), CpuCollector.class),
    MEMORY(StringFog.decrypt("TEZJTFNa"), MemoryCollector.class),
    CAMEAR(StringFog.decrypt("QkJJRlNC"), CameraCollector.class),
    AUDIO(StringFog.decrypt("QFZASk4="), AudioCollector.class),
    RISK(StringFog.decrypt("U0pXSA=="), RiskCollector.class),
    SENSOR(StringFog.decrypt("UkZKUE5R"), SensorCollector.class);

    private Class<? extends SubCollector> mClazz;
    private String mType;

    CollectorMap(String str, Class cls) {
        this.mType = str;
        this.mClazz = cls;
    }

    public Class<? extends SubCollector> getClazz() {
        return this.mClazz;
    }

    public String getType() {
        return this.mType;
    }
}
