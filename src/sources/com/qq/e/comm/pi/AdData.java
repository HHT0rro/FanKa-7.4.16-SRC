package com.qq.e.comm.pi;

import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface AdData {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface VideoPlayer {
        int getCurrentPosition();

        int getDuration();

        int getVideoState();
    }

    boolean equalsAdData(AdData adData);

    int getAdPatternType();

    String getDesc();

    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    <T> T getProperty(Class<T> cls);

    String getProperty(String str);

    String getTitle();

    int getVideoDuration();

    void setECPMLevel(String str);
}
