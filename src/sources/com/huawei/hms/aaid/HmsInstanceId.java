package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.a;
import com.huawei.hms.opendevice.b;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.g;
import com.huawei.hms.opendevice.h;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";

    /* renamed from: a, reason: collision with root package name */
    private Context f28915a;

    /* renamed from: b, reason: collision with root package name */
    private PushPreferences f28916b;

    /* renamed from: c, reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f28917c;

    private HmsInstanceId(Context context) {
        this.f28915a = context.getApplicationContext();
        this.f28916b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f28917c = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f28917c = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f28917c.setKitSdkVersion(61200300);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (e.e(this.f28915a)) {
            String string = i.a(this.f28915a).getString("subjectId");
            if (TextUtils.isEmpty(string)) {
                i.a(this.f28915a).saveString("subjectId", str);
                return;
            }
            if (string.contains(str)) {
                return;
            }
            i.a(this.f28915a).saveString("subjectId", string + "," + str);
            return;
        }
        i.a(this.f28915a).removeKey("subjectId");
    }

    private void b() throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        l.c(context);
        return new HmsInstanceId(context);
    }

    public void deleteAAID() throws ApiException {
        b();
        try {
            if (this.f28916b.containsKey("aaid")) {
                this.f28916b.removeKey("aaid");
                this.f28916b.removeKey("creationTime");
                if (b.d(this.f28915a)) {
                    if (ProxyCenter.getProxy() != null) {
                        HMSLog.i(TAG, "use proxy delete all token after delete AaId.");
                        ProxyCenter.getProxy().deleteAllToken(this.f28915a);
                        return;
                    }
                    DeleteTokenReq a10 = b.a(this.f28915a);
                    a10.setDeleteType(1);
                    a10.setMultiSender(false);
                    a(a10, 1);
                    BaseUtils.deleteAllTokenCache(this.f28915a);
                }
            }
        } catch (ApiException e2) {
            throw e2;
        } catch (Exception unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        b();
        a();
        DeleteTokenReq a10 = b.a(this.f28915a, str, str2);
        a10.setMultiSender(false);
        a(a10, 1);
    }

    public Task<AAIDResult> getAAID() {
        try {
            return Tasks.callInBackground(new a(this.f28915a.getApplicationContext()));
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return taskCompletionSource.getTask();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.f28916b.containsKey("creationTime")) {
                getAAID();
            }
            return this.f28916b.getLong("creationTime");
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String getId() {
        return b.b(this.f28915a);
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        b();
        a();
        TokenReq b4 = b.b(this.f28915a, null, str2);
        b4.setAaid(getId());
        b4.setMultiSender(false);
        i.a(this.f28915a).saveString(this.f28915a.getPackageName(), "1");
        return a(b4, 1);
    }

    public void deleteToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String c4 = b.c(this.f28915a);
            if (!TextUtils.isEmpty(c4)) {
                if (str.equals(c4)) {
                    deleteToken(null, null);
                    return;
                }
                DeleteTokenReq a10 = b.a(this.f28915a, str);
                a10.setMultiSender(true);
                a(a10, 2);
                return;
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public String getToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String c4 = b.c(this.f28915a);
            if (!TextUtils.isEmpty(c4)) {
                if (str.equals(c4)) {
                    return getToken(null, null);
                }
                TokenReq b4 = b.b(this.f28915a, str);
                b4.setAaid(getId());
                b4.setMultiSender(true);
                return a(b4, 2);
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    private String a(TokenReq tokenReq, int i10) throws ApiException {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            ProxyCenter.getProxy().getToken(this.f28915a, tokenReq.getSubjectId(), null);
            return null;
        }
        a(tokenReq.getSubjectId());
        String a10 = h.a(this.f28915a, "push.gettoken");
        try {
            HMSLog.d(TAG, "getToken req :" + tokenReq.toString());
            g gVar = new g("push.gettoken", tokenReq, this.f28915a, a10);
            gVar.setApiLevel(i10);
            return ((TokenResult) Tasks.await(this.f28917c.doWrite(gVar))).getToken();
        } catch (Exception e2) {
            if (e2.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e2.getCause();
                h.a(this.f28915a, "push.gettoken", a10, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f28915a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            h.a(context, "push.gettoken", a10, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    private void a(DeleteTokenReq deleteTokenReq, int i10) throws ApiException {
        String subjectId = deleteTokenReq.getSubjectId();
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy delete token");
            ProxyCenter.getProxy().deleteToken(this.f28915a, subjectId, null);
            return;
        }
        String a10 = h.a(this.f28915a, "push.deletetoken");
        try {
            String b4 = i.a(this.f28915a).b(subjectId);
            if (deleteTokenReq.isMultiSender() && (TextUtils.isEmpty(b4) || b4.equals(i.a(this.f28915a).b(null)))) {
                i.a(this.f28915a).removeKey(subjectId);
                HMSLog.i(TAG, "The local subject token is null");
                return;
            }
            deleteTokenReq.setToken(b4);
            f fVar = new f("push.deletetoken", deleteTokenReq, a10);
            fVar.setApiLevel(i10);
            Tasks.await(this.f28917c.doWrite(fVar));
            i.a(this.f28915a).c(subjectId);
        } catch (Exception e2) {
            if (e2.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e2.getCause();
                h.a(this.f28915a, "push.deletetoken", a10, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f28915a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            h.a(context, "push.deletetoken", a10, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    private void a() throws ApiException {
        if (BaseUtils.getProxyInit(this.f28915a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.f28915a)) {
            HMSLog.e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }
}
