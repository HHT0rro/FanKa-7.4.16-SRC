package com.kwad.components.offline.api.tk.model.report;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TKPerformMsg extends BaseOfflineCompoJsonParse<TKPerformMsg> implements Serializable {
    public static final int ENTER_SCENE = -1;
    public static final int OTHER_FAIL = 3;
    public static final int PAGE_STATUS_FAIL = 2;
    public static final int START = 0;
    public static final int SUCCESS = 1;
    public static final int TK_NOT_READY = 4;
    private static final long serialVersionUID = -5293371882532982729L;
    public String errorDetail;
    public String errorReason;
    public long initTime;
    public long loadTime;
    public int renderState;
    public long renderTime;
    public int source;
    public String templateId;
    public String versionCode;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public @interface ERROR_REASON {
        public static final String KSAD_TK_CONFIG_LOST = "config_lost";
        public static final String KSAD_TK_CONFIG_PARSE_FAIL = "config_parse_fail";
        public static final String KSAD_TK_JS_EMPTY = "js_empty";
        public static final String KSAD_TK_MD5_NOT_MATCH = "md5_not_match";
        public static final String KSAD_TK_NO_FILE = "no_file";
        public static final String KSAD_TK_NO_TEMPLATE = "no_template";
        public static final String KSAD_TK_OFFLINE_FAILED = "offline_failed";
        public static final String KSAD_TK_SO_FAIL = "so_fail";
    }

    public TKPerformMsg(int i10) {
        setSource(i10);
    }

    public TKPerformMsg setErrorDetail(String str) {
        this.errorDetail = str;
        return this;
    }

    public TKPerformMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public TKPerformMsg setInitTime(long j10) {
        this.initTime = j10;
        return this;
    }

    public TKPerformMsg setLoadTime(long j10) {
        this.loadTime = j10;
        return this;
    }

    public TKPerformMsg setRenderState(int i10) {
        this.renderState = i10;
        return this;
    }

    public TKPerformMsg setRenderTime(long j10) {
        this.renderTime = j10;
        return this;
    }

    public TKPerformMsg setSource(int i10) {
        this.source = i10;
        return this;
    }

    public TKPerformMsg setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public TKPerformMsg setVersionCode(String str) {
        this.versionCode = str;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TKPerformMsg tKPerformMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKPerformMsg.source = jSONObject.optInt("source");
        tKPerformMsg.renderState = jSONObject.optInt("render_state");
        tKPerformMsg.errorReason = jSONObject.optString("error_reason");
        if (jSONObject.opt("error_reason") == JSONObject.NULL) {
            tKPerformMsg.errorReason = "";
        }
        tKPerformMsg.renderTime = jSONObject.optLong("render_time");
        tKPerformMsg.templateId = jSONObject.optString(ExposeManager.UtArgsNames.templateId);
        if (jSONObject.opt(ExposeManager.UtArgsNames.templateId) == JSONObject.NULL) {
            tKPerformMsg.templateId = "";
        }
        tKPerformMsg.versionCode = jSONObject.optString("version_code");
        if (jSONObject.opt("version_code") == JSONObject.NULL) {
            tKPerformMsg.versionCode = "";
        }
        tKPerformMsg.loadTime = jSONObject.optLong("load_time");
        tKPerformMsg.initTime = jSONObject.optLong("init_time");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKPerformMsg tKPerformMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JsonHelper.putValue(jSONObject, "render_state", tKPerformMsg.renderState);
        int i10 = tKPerformMsg.source;
        if (i10 != 0) {
            JsonHelper.putValue(jSONObject, "source", i10);
        }
        String str = tKPerformMsg.errorReason;
        if (str != null && !str.equals("")) {
            JsonHelper.putValue(jSONObject, "error_reason", tKPerformMsg.errorReason);
        }
        String str2 = tKPerformMsg.errorDetail;
        if (str2 != null && !str2.equals("")) {
            JsonHelper.putValue(jSONObject, "error_detail", tKPerformMsg.errorDetail);
        }
        long j10 = tKPerformMsg.renderTime;
        if (j10 != 0) {
            JsonHelper.putValue(jSONObject, "render_time", j10);
        }
        String str3 = tKPerformMsg.templateId;
        if (str3 != null && !str3.equals("")) {
            JsonHelper.putValue(jSONObject, ExposeManager.UtArgsNames.templateId, tKPerformMsg.templateId);
        }
        String str4 = tKPerformMsg.versionCode;
        if (str4 != null && !str4.equals("")) {
            JsonHelper.putValue(jSONObject, "version_code", tKPerformMsg.versionCode);
        }
        long j11 = tKPerformMsg.loadTime;
        if (j11 != 0) {
            JsonHelper.putValue(jSONObject, "load_time", j11);
        }
        long j12 = tKPerformMsg.initTime;
        if (j12 != 0) {
            JsonHelper.putValue(jSONObject, "init_time", j12);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKPerformMsg tKPerformMsg) {
        return toJson(tKPerformMsg, (JSONObject) null);
    }
}
