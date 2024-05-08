package com.wangmai.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.wangmai.common.bean.SdkTrackEventBean;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SDKTrackUtils {
    public static final String TAG = "TrackUtils";
    public static volatile SDKTrackUtils sdkTrackUtils;

    public static SDKTrackUtils getInstance() {
        if (sdkTrackUtils == null) {
            synchronized (SDKTrackUtils.class) {
                if (sdkTrackUtils == null) {
                    sdkTrackUtils = new SDKTrackUtils();
                }
            }
        }
        return sdkTrackUtils;
    }

    public synchronized void addSdkTrackReportBean(final Context context, final String str, final SdkTrackEventBean sdkTrackEventBean, String str2) {
        if (ConstantInfo.sdkTrackEventMap == null) {
            ConstantInfo.sdkTrackEventMap = new ConcurrentHashMap<>();
        }
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.wangmai.common.utils.SDKTrackUtils.1
            @Override // java.lang.Runnable
            public void run() {
                if (ConstantInfo.sdkTrackEventMap.containsKey(str)) {
                    return;
                }
                ConstantInfo.sdkTrackEventMap.put(str, sdkTrackEventBean);
                SharedPreferencesHelper.getInstance(context).savePreferencesString(ConstantInfo.SP_KEY_SDK_TRACK, GsonUtils.getInstance().toJson(ConstantInfo.sdkTrackEventMap));
            }
        });
    }

    public synchronized void addTrackBean(Context context, String str, SdkTrackEventBean.EventBean eventBean, String str2) {
        if (ConstantInfo.sdkTrackEventMap == null) {
            ConstantInfo.sdkTrackEventMap = new ConcurrentHashMap<>();
        }
        if (ConstantInfo.sdkTrackEventMap.containsKey(str)) {
            ConstantInfo.sdkTrackEventMap.get(str).addEvent(eventBean);
            SharedPreferencesHelper.getInstance(context).savePreferencesString(ConstantInfo.SP_KEY_SDK_TRACK, GsonUtils.getInstance().toJson(ConstantInfo.sdkTrackEventMap));
        } else {
            DebugLog.W(TAG, "[addTrackBean requestId not exits] ：" + str);
        }
    }

    public void cleanSdkTrackReportBean(Context context) {
        SharedPreferencesHelper.getInstance(context).savePreferencesString(ConstantInfo.SP_KEY_SDK_TRACK, "");
    }

    public ConcurrentHashMap<String, SdkTrackEventBean> getSdkTrackReportBeanMap(Context context) {
        try {
            String preferencesString = SharedPreferencesHelper.getInstance(context).getPreferencesString(ConstantInfo.SP_KEY_SDK_TRACK, "");
            if (!TextUtils.isEmpty(preferencesString)) {
                return (ConcurrentHashMap) GsonUtils.getInstance().fromJson(preferencesString, new TypeToken<ConcurrentHashMap<String, SdkTrackEventBean>>() { // from class: com.wangmai.common.utils.SDKTrackUtils.2
                });
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, "fetch trackInfo error:" + th.toString());
        }
        return null;
    }

    public boolean queryAlreadyTrackEvent(String str, SdkTrackEventBean.TrackEventEnum trackEventEnum) {
        List<SdkTrackEventBean.EventBean> track_event;
        if (!ConstantInfo.sdkTrackEventMap.containsKey(str) || (track_event = ConstantInfo.sdkTrackEventMap.get(str).getTrack_event()) == null || track_event.isEmpty()) {
            return false;
        }
        Iterator<SdkTrackEventBean.EventBean> iterator2 = track_event.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().getType() == trackEventEnum) {
                return true;
            }
        }
        return false;
    }
}
