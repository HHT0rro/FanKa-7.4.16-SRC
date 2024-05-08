package com.bytedance.sdk.openadsdk.api.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadController;
import o0.a;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private DownloadController f11093m;

    public m(DownloadController downloadController) {
        this.f11093m = downloadController;
    }

    public Object c() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.getExtraObject();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 == 223317) {
            if (valueSet == null) {
                return null;
            }
            dk(((Boolean) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_ENABLE_NEW_ACTIVITY, Boolean.class)).booleanValue());
            return null;
        }
        switch (i10) {
            case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_DOWNLOAD_MODE /* 223311 */:
                if (valueSet == null) {
                    return null;
                }
                m(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_MODE, Integer.class)).intValue());
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_LINK_MODE /* 223312 */:
                if (valueSet == null) {
                    return null;
                }
                dk(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_LINK_MODE, Integer.class)).intValue());
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_ENABLE_SHOW_COMPLIANCE_DIALOG /* 223313 */:
                if (valueSet == null) {
                    return null;
                }
                m(((Boolean) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_ENABLE_SHOW_COMPLIANCE_DIALOG, Boolean.class)).booleanValue());
                return null;
            default:
                return null;
        }
    }

    public int dk() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.getDownloadMode();
        }
        return 0;
    }

    public boolean e() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.shouldUseNewWebView();
        }
        return false;
    }

    public boolean ej() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.isEnableBackDialog();
        }
        return false;
    }

    public Object hc() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.getExtraClickOperation();
        }
        return null;
    }

    public boolean k() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.enableAM();
        }
        return false;
    }

    public boolean l() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.isAddToDownloadManage();
        }
        return false;
    }

    public int m() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.getLinkMode();
        }
        return 0;
    }

    public int n() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.getDowloadChunkCount();
        }
        return 0;
    }

    public boolean np() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.isEnableMultipleDownload();
        }
        return false;
    }

    public JSONObject oa() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.getExtraJson();
        }
        return null;
    }

    public boolean q() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.enableAH();
        }
        return false;
    }

    public boolean r() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.enableNewActivity();
        }
        return false;
    }

    public boolean sy() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.isAutoDownloadOnCardShow();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return a.b().f(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_LINK_MODE, m()).f(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_DOWNLOAD_MODE, dk()).j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ENABLE_BACK_DIALOG, ej()).j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ADD_TO_DOWNLOAD_MANAGE, l()).j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ENABLE_MULTIPLE_DOWNLOAD, np()).f(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_DOWNLOAD_CHUNK_COUNT, n()).h(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_CLICK_OPERATION, hc()).j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SHOULD_USE_NEW_WEB_VIEW, e()).f(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_INTERCEPT_FLAG, w()).h(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_JSON, oa()).h(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_OBJECT, c()).h(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_JSON, oa()).j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_SHOW_COMPLIANCE_DIALOG, ve()).j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_AUTO_DOWNLOAD_ON_CARD_SHOW, sy()).j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_NEW_ACTIVITY, r()).j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_AH, q()).j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_AM, k()).a();
    }

    public boolean ve() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.enableShowComplianceDialog();
        }
        return false;
    }

    public int w() {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            return downloadController.getInterceptFlag();
        }
        return 0;
    }

    public void dk(int i10) {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            downloadController.setLinkMode(i10);
        }
    }

    public void m(int i10) {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            downloadController.setDownloadMode(i10);
        }
    }

    public void dk(boolean z10) {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            downloadController.setEnableNewActivity(z10);
        }
    }

    public void m(boolean z10) {
        DownloadController downloadController = this.f11093m;
        if (downloadController != null) {
            downloadController.setEnableShowComplianceDialog(z10);
        }
    }
}
