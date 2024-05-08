package com.kwad.sdk.core.adlog;

import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AdLogRequestResult extends BaseResultData {
    private static final int CODE_RESULT_CHEATING_FLOW = 110009;
    private static final long serialVersionUID = 497410051317861756L;

    public boolean isCheatingFlow() {
        return this.result == CODE_RESULT_CHEATING_FLOW;
    }

    public void parseResult(String str) {
        try {
            parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }
}
