package com.huawei.openalliance.ad.msgnotify;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.constant.q;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.an;
import com.huawei.openalliance.ad.utils.v;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {
    private static final String Code = "MessageNotifyManager";

    private static Object Code() {
        try {
            return an.Code(null, Class.forName("com.huawei.openalliance.ad.ppskit.msgnotify.PersistentMessageCenter"), "getInstance", null, null);
        } catch (Throwable unused) {
            gl.V(Code, "get inner msg notify");
            return a.Code();
        }
    }

    public static void Code(Context context, String str) {
        I(context, str);
        if (v.B(context)) {
            return;
        }
        V(context, str);
    }

    public static void Code(Context context, String str, Intent intent) {
        gl.V(Code, "notifyMessage via hard link");
        Object Code2 = Code();
        if (Code2 != null) {
            if (Code2 instanceof a) {
                ((a) Code2).Code(str, intent);
            } else {
                an.Code(Code2, Code2.getClass(), "notifyMessage", new Class[]{String.class, String.class, Intent.class}, new Object[]{context.getPackageName(), str, intent});
            }
        }
    }

    public static void Code(Context context, String str, NotifyCallback notifyCallback) {
        I(context, str, notifyCallback);
    }

    public static void Code(Context context, String str, String str2, Intent intent) {
        if (!v.B(context)) {
            Code(context, str2, intent);
            return;
        }
        gl.V(Code, "notifyMessage via aidl");
        String Code2 = c.Code(str, str2, intent);
        if (TextUtils.isEmpty(Code2)) {
            return;
        }
        g.V(context).Code(q.f32324g, Code2, null, null);
    }

    private static void I(Context context, String str) {
        gl.V(Code, "unregisterAllNotify via aidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(ax.f32277t, str);
            jSONObject.putOpt(ax.f32279v, u.aE);
            g.V(context).Code(q.f32323f, jSONObject.toString(), null, null);
        } catch (JSONException e2) {
            gl.I(Code, "unregisterAllNotify " + e2.getClass().getSimpleName());
        }
    }

    private static void I(Context context, String str, final NotifyCallback notifyCallback) {
        gl.V(Code, "registerNotifyViaAidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(ax.f32277t, str);
            jSONObject.putOpt(ax.f32279v, u.aD);
            g.V(context).Code(q.f32323f, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.msgnotify.b.1
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str2, CallResult<String> callResult) {
                    Intent Code2;
                    if (NotifyCallback.this == null || callResult == null || callResult.getCode() != 200 || (Code2 = c.Code(callResult.getData())) == null) {
                        return;
                    }
                    SafeIntent safeIntent = new SafeIntent(Code2);
                    String stringExtra = safeIntent.getStringExtra(ax.f32277t);
                    gl.V(b.Code, "receive msg: " + stringExtra);
                    NotifyCallback.this.onMessageNotify(stringExtra, safeIntent);
                }
            }, String.class);
        } catch (JSONException e2) {
            gl.Code(5, Code, "registerNotify ", e2);
        }
    }

    public static void V(Context context, String str) {
        gl.V(Code, "unregisterAllNotify via hard link");
        Object Code2 = Code();
        if (Code2 != null) {
            if (Code2 instanceof a) {
                ((a) Code2).Code(str);
            } else {
                an.Code(Code2, Code2.getClass(), "unregisterAll", new Class[]{String.class, String.class}, new Object[]{context.getPackageName(), str});
            }
        }
    }

    public static void V(Context context, String str, NotifyCallback notifyCallback) {
        if (context == null || TextUtils.isEmpty(str) || notifyCallback == null) {
            gl.V(Code, "registerNotifyViaHardLink some param is empty");
            return;
        }
        gl.V(Code, "registerNotifyViaHardLink");
        Object Code2 = Code();
        if (Code2 != null) {
            if (Code2 instanceof a) {
                ((a) Code2).Code(str, notifyCallback);
            } else {
                an.Code(Code2, Code2.getClass(), "registerNotifyCallbackFromSdk", new Class[]{String.class, String.class, Object.class}, new Object[]{context.getPackageName(), str, notifyCallback});
            }
        }
    }
}
