package com.huawei.hms.push;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.push.task.SubscribeNotificationTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeNotificationReq;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NotificationSubscription {
    public static final int NOTIFICATION_SUBSCRIBE_REQUEST_CODE = 1001;

    /* renamed from: d, reason: collision with root package name */
    private static final String f30366d = "NotificationSubscription";

    /* renamed from: a, reason: collision with root package name */
    private Activity f30367a;

    /* renamed from: b, reason: collision with root package name */
    private Context f30368b;

    /* renamed from: c, reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f30369c;

    private NotificationSubscription(Activity activity) {
        Preconditions.checkNotNull(activity);
        this.f30368b = activity.getApplicationContext();
        this.f30367a = activity;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(activity, (Api<Api.ApiOptions>) new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        this.f30369c = huaweiApi;
        huaweiApi.setKitSdkVersion(61200300);
    }

    private Task<SubscribeResult> a(List<String> list) {
        String reportEntry = PushBiUtil.reportEntry(this.f30368b, PushNaming.SUBSCRIBE_NOTIFICATION);
        if (list != null && !list.isEmpty() && list.size() <= 3) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                Context context = this.f30368b;
                ErrorEnum errorEnum = ErrorEnum.ERROR_MAIN_THREAD;
                PushBiUtil.reportExit(context, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, errorEnum);
                return a(errorEnum.toApiException());
            }
            if (!((NotificationManager) this.f30368b.getSystemService("notification")).areNotificationsEnabled()) {
                HMSLog.i(f30366d, "App disabled notification");
                Context context2 = this.f30368b;
                ErrorEnum errorEnum2 = ErrorEnum.ERROR_NOTIFICATION_DISABLED;
                PushBiUtil.reportExit(context2, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, errorEnum2);
                return a(errorEnum2.toApiException());
            }
            try {
                if (v.a(this.f30368b) != ErrorEnum.SUCCESS) {
                    return a(ErrorEnum.ERROR_NO_TOKEN.toApiException());
                }
                if (-1 != this.f30368b.getPackageManager().checkPermission(com.kuaishou.weapon.p0.g.f36116b, this.f30368b.getPackageName()) && g.a(this.f30368b) == -1) {
                    HMSLog.e(f30366d, "no network");
                    return a(ErrorEnum.ERROR_NO_NETWORK.toApiException());
                }
                Task doWrite = this.f30369c.doWrite(new SubscribeNotificationTask(this.f30367a, PushNaming.SUBSCRIBE_NOTIFICATION, b(list), reportEntry));
                Tasks.await(doWrite);
                return doWrite;
            } catch (Exception e2) {
                if (e2.getCause() instanceof ApiException) {
                    ApiException apiException = (ApiException) e2.getCause();
                    PushBiUtil.reportExit(this.f30368b, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, apiException.getStatusCode());
                    return a(apiException);
                }
                Context context3 = this.f30368b;
                ErrorEnum errorEnum3 = ErrorEnum.ERROR_INTERNAL_ERROR;
                PushBiUtil.reportExit(context3, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, errorEnum3);
                return a(errorEnum3.toApiException());
            }
        }
        Context context4 = this.f30368b;
        ErrorEnum errorEnum4 = ErrorEnum.ERROR_ARGUMENTS_INVALID;
        PushBiUtil.reportExit(context4, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, errorEnum4);
        HMSLog.e(f30366d, "Invalid entityIds: entityId list should not be empty or more than max size");
        return a(errorEnum4.toApiException());
    }

    private SubscribeNotificationReq b(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            jSONArray.put(iterator2.next());
        }
        SubscribeNotificationReq subscribeNotificationReq = new SubscribeNotificationReq();
        subscribeNotificationReq.setEntityIds(jSONArray.toString());
        subscribeNotificationReq.setToken(BaseUtils.getLocalToken(this.f30368b, null));
        return subscribeNotificationReq;
    }

    public static NotificationSubscription getInstance(Activity activity) {
        return new NotificationSubscription(activity);
    }

    public static SubscribeResult getSubscribeResult(Intent intent) {
        String stringExtra;
        if (intent == null) {
            return null;
        }
        try {
            stringExtra = intent.getStringExtra("errorMsg");
        } catch (Throwable unused) {
            HMSLog.e(f30366d, "get subscribe result occurs exception");
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            SubscribeResult subscribeResult = new SubscribeResult();
            subscribeResult.setErrorMsg(stringExtra);
            HMSLog.e(f30366d, "get subscribe error msg:" + stringExtra);
            return subscribeResult;
        }
        String stringExtra2 = intent.getStringExtra("subscribedItems");
        if (!TextUtils.isEmpty(stringExtra2)) {
            List<SubscribedItem> a10 = b.a(stringExtra2);
            SubscribeResult subscribeResult2 = new SubscribeResult();
            subscribeResult2.setSubscribedItems(a10);
            return subscribeResult2;
        }
        return null;
    }

    public Task<SubscribeResult> requestSubscribeNotification(List<String> list) {
        HMSLog.i(f30366d, "invoke request subscribe notification");
        return a(list);
    }

    private Task<SubscribeResult> a(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }
}
