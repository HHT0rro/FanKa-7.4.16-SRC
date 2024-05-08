package com.heytap.msp.push;

import android.content.Context;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.mode.MessageStat;
import java.util.List;
import org.json.JSONObject;
import t8.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HeytapPushManager {
    public static final String EVENT_ID_APP_BLACK_LIST = "app_black_list";
    public static final String EVENT_ID_PUSH_ADD_MESSAGE_NO_DISTURBING = "add_message_no_disturbing";
    public static final String EVENT_ID_PUSH_ADD_MESSAGE_TOP = "add_message_top";
    public static final String EVENT_ID_PUSH_CLICK = "push_click";
    public static final String EVENT_ID_PUSH_DELETE = "push_delete";
    public static final String EVENT_ID_PUSH_EXCEPTION = "push_exception";
    public static final String EVENT_ID_PUSH_MESSAGE_REPEAT = "message_repeat";
    public static final String EVENT_ID_PUSH_NO_IMSI = "imsi_not_exist";
    public static final String EVENT_ID_PUSH_NO_SHOW = "push_no_show";
    public static final String EVENT_ID_PUSH_REVOKE = "push_revoke";
    public static final String EVENT_ID_PUSH_REVOKE_DELETE = "push_revoke_delete";
    public static final String EVENT_ID_PUSH_SHOW = "push_show";
    public static final String EVENT_ID_READ_MESSAGE = "push_read_message";

    public static void clearNotificationType() {
        clearNotificationType(null);
    }

    public static void clearNotificationType(JSONObject jSONObject) {
        b.C().x(jSONObject);
    }

    public static void clearNotifications() {
        clearNotifications(null);
    }

    public static void clearNotifications(JSONObject jSONObject) {
        b.C().x(jSONObject);
    }

    public static String getMcsPackageName() {
        return b.C().D();
    }

    public static void getNotificationStatus() {
        getNotificationStatus(null);
    }

    public static void getNotificationStatus(JSONObject jSONObject) {
        b.C().w(jSONObject);
    }

    public static ICallBackResultService getPushCallback() {
        return b.C().I();
    }

    public static void getPushStatus() {
        b.C().J();
    }

    public static int getPushVersionCode() {
        return b.C().M();
    }

    public static String getPushVersionName() {
        return b.C().L();
    }

    public static String getReceiveSdkAction() {
        return b.C().E();
    }

    public static void getRegister() {
        getRegister(null);
    }

    public static void getRegister(JSONObject jSONObject) {
        b.C().o(jSONObject);
    }

    public static String getRegisterID() {
        return b.C().b();
    }

    public static String getSDKVersion() {
        return b.K();
    }

    public static void init(Context context, boolean z10) {
        b.C().d(context, z10);
    }

    public static boolean isSupportPush() {
        return b.C().F();
    }

    public static void openNotificationSettings() {
        openNotificationSettings(null);
    }

    public static void openNotificationSettings(JSONObject jSONObject) {
        b.C().y(jSONObject);
    }

    public static void pausePush() {
        pausePush(null);
    }

    public static void pausePush(JSONObject jSONObject) {
        b.C().z(jSONObject);
    }

    public static void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        register(context, str, str2, null, iCallBackResultService);
    }

    public static void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        b.C().h(context, str, str2, jSONObject, iCallBackResultService);
    }

    public static void requestNotificationPermission() {
        b.C().B();
    }

    public static void resumePush() {
        resumePush(null);
    }

    public static void resumePush(JSONObject jSONObject) {
        b.C().A(jSONObject);
    }

    public static void setAppKeySecret(String str, String str2) {
        b.C().m(str, str2);
    }

    public static void setNotificationType(int i10) {
        setNotificationType(i10, null);
    }

    public static void setNotificationType(int i10, JSONObject jSONObject) {
        b.C().f(i10, jSONObject);
    }

    public static void setPushCallback(ICallBackResultService iCallBackResultService) {
        b.C().j(iCallBackResultService);
    }

    public static void setPushTime(List<Integer> list, int i10, int i11, int i12, int i13) {
        setPushTime(list, i10, i11, i12, i13, null);
    }

    public static void setPushTime(List<Integer> list, int i10, int i11, int i12, int i13, JSONObject jSONObject) {
        b.C().n(list, i10, i11, i12, i13, jSONObject);
    }

    public static void setRegisterID(String str) {
        b.C().l(str);
    }

    public static void statisticMessage(Context context, MessageStat messageStat) {
        b.g(context, messageStat);
    }

    public static void statisticMessage(Context context, List<MessageStat> list) {
        b.i(context, list);
    }

    public static void unRegister() {
        unRegister(null);
    }

    public static void unRegister(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        b.C().u(context, str, str2, jSONObject, iCallBackResultService);
    }

    public static void unRegister(JSONObject jSONObject) {
        b.C().v(jSONObject);
    }
}
