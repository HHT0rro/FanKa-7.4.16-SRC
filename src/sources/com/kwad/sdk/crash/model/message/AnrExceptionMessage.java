package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class AnrExceptionMessage extends ExceptionMessage {
    private static final long serialVersionUID = 2116476830162477947L;
    public String mReason = "";
    public String mMessageQueueDetail = "";
    public String mThreadDetail = "";
    public String mThreadStatus = "";
    public int mIndex = -1;

    public AnrExceptionMessage() {
        this.mExceptionType = 3;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public final String getTypePrefix() {
        return "ANR_";
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mReason = jSONObject.optString("mReason");
        this.mMessageQueueDetail = jSONObject.optString("mMessageQueueDetail");
        this.mThreadDetail = jSONObject.optString("mThreadDetail");
        this.mThreadStatus = jSONObject.optString("mThreadStatus");
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject json = super.toJson();
        t.putValue(json, "mReason", this.mReason);
        t.putValue(json, "mMessageQueueDetail", this.mMessageQueueDetail);
        t.putValue(json, "mThreadDetail", this.mThreadDetail);
        t.putValue(json, "mThreadStatus", this.mThreadStatus);
        return json;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public final String toString() {
        StringBuilder sb2 = new StringBuilder(super.toString());
        try {
            if (!TextUtils.isEmpty(this.mReason)) {
                sb2.append("ANR 原因:\n");
                sb2.append(this.mReason);
                sb2.append("\n");
            }
            if (!TextUtils.isEmpty(this.mThreadStatus)) {
                sb2.append("线程状态: \n");
                sb2.append(this.mThreadStatus);
                sb2.append("\n");
            }
            if (!TextUtils.isEmpty(this.mThreadDetail)) {
                sb2.append("线程状态: \n");
                sb2.append(this.mThreadDetail);
                sb2.append("\n");
            }
            if (!TextUtils.isEmpty(this.mMessageQueueDetail)) {
                sb2.append("消息队列: \n");
                sb2.append(this.mMessageQueueDetail);
                sb2.append("\n");
            }
        } catch (Exception e2) {
            c.printStackTraceOnly(e2);
        }
        return sb2.substring(0);
    }
}
