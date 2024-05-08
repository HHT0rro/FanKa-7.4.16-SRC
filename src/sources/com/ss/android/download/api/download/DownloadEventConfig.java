package com.ss.android.download.api.download;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface DownloadEventConfig {
    String getClickButtonTag();

    String getClickContinueLabel();

    String getClickInstallLabel();

    String getClickItemTag();

    String getClickLabel();

    String getClickPauseLabel();

    String getClickStartLabel();

    int getDownloadScene();

    Object getExtraEventObject();

    JSONObject getExtraJson();

    JSONObject getParamsJson();

    String getRefer();

    String getStorageDenyLabel();

    boolean isEnableClickEvent();

    boolean isEnableV3Event();

    void setDownloadScene(int i10);

    void setRefer(String str);
}
