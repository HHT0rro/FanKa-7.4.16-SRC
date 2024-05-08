package com.bytedance.sdk.openadsdk.api.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadEventConfig;
import o0.a;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private DownloadEventConfig f11078m;

    public dk(DownloadEventConfig downloadEventConfig) {
        this.f11078m = downloadEventConfig;
    }

    public int c() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getDownloadScene();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 == 223515) {
            if (valueSet == null) {
                return null;
            }
            m(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_DOWNLOAD_SCENE_PARAMETER, Integer.class)).intValue());
            return null;
        }
        if (i10 != 223517 || valueSet == null) {
            return null;
        }
        m((String) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_REFER_PARAMETER, String.class));
        return null;
    }

    public String dk() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickButtonTag();
        }
        return null;
    }

    public String e() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickInstallLabel();
        }
        return null;
    }

    public String ej() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickItemTag();
        }
        return null;
    }

    public String hc() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickContinueLabel();
        }
        return null;
    }

    public String l() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickLabel();
        }
        return null;
    }

    public String m() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getRefer();
        }
        return null;
    }

    public String n() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickPauseLabel();
        }
        return null;
    }

    public String np() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickStartLabel();
        }
        return null;
    }

    public Object oa() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraEventObject();
        }
        return null;
    }

    public JSONObject q() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getParamsJson();
        }
        return null;
    }

    public JSONObject r() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraJson();
        }
        return null;
    }

    public boolean sy() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableV3Event();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return a.b().i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_REFER, m()).i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_BUTTON_TAG, dk()).i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_ITEM_TAG, ej()).i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_LABEL, l()).i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_START_LABEL, np()).i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_PAUSE_LABEL, n()).i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_CONTINUE_LABEL, hc()).i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_INSTALL_LABEL, e()).i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_STORAGE_DENY_LABEL, w()).h(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_EXTRA_EVENT_OBJECT, oa()).f(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_DOWNLOAD_SCENE, c()).j(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_IS_ENABLE_CLICK_EVENT, ve()).j(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_IS_ENABLE_V3_EVENT, sy()).h(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_EXTRA_JSON, r()).h(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_PARAMS_JSON, q()).a();
    }

    public boolean ve() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableClickEvent();
        }
        return false;
    }

    public String w() {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getStorageDenyLabel();
        }
        return null;
    }

    public void m(int i10) {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            downloadEventConfig.setDownloadScene(i10);
        }
    }

    public void m(String str) {
        DownloadEventConfig downloadEventConfig = this.f11078m;
        if (downloadEventConfig != null) {
            downloadEventConfig.setRefer(str);
        }
    }
}
