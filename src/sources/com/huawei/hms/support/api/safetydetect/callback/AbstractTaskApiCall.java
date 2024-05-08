package com.huawei.hms.support.api.safetydetect.callback;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.safetydetect.SafetyDetectHmsClient;
import com.huawei.hms.support.api.safetydetect.exception.SafetyDetectException;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import e9.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class AbstractTaskApiCall<T> extends TaskApiCall<SafetyDetectHmsClient, T> {
    public static final int HMS_VERSION_MIN_402 = 40002000;
    public static final String PATH = "path";
    public static final String STATUS_CODE = "statusCode";
    public static final String TAG = "AbstractTaskApiCall";
    public Context context;
    public boolean isReport;

    public AbstractTaskApiCall(Context context, String str, String str2, boolean z10) {
        super(str, str2, z10 ? HiAnalyticsClient.reportEntry(context, str, 5003301) : null);
        this.context = context;
        this.isReport = z10;
    }

    private Status genFailStatus(int i10, String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return new Status(i10, str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return new Status(jSONObject.getInt("statusCode"), jSONObject.getString("statusMsg"));
        } catch (JSONException unused) {
            return new Status(i10, str);
        }
    }

    private void processResponseIntent(Parcelable parcelable) {
        if (parcelable instanceof Intent) {
            Intent intent = (Intent) parcelable;
            String stringExtra = intent.getStringExtra("path");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            HMSLog.i(TAG, "Response intent path " + stringExtra);
            Uri parse = Uri.parse(stringExtra);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            intent.setFlags(268435456);
            try {
                this.context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                StringBuilder b4 = a.b("Response intent path start activity fail ");
                b4.append(e2.getMessage());
                HMSLog.i(TAG, b4.toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[SYNTHETIC] */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doExecute(com.huawei.hms.support.api.safetydetect.SafetyDetectHmsClient r7, com.huawei.hms.common.internal.ResponseErrorCode r8, java.lang.String r9, com.huawei.hmf.tasks.TaskCompletionSource<T> r10) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.safetydetect.callback.AbstractTaskApiCall.doExecute(com.huawei.hms.support.api.safetydetect.SafetyDetectHmsClient, com.huawei.hms.common.internal.ResponseErrorCode, java.lang.String, com.huawei.hmf.tasks.TaskCompletionSource):void");
    }

    public abstract T newResponse(String str, int i10, String str2) throws SafetyDetectException;
}
