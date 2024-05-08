package kc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class n {
    public static String A = "sig";
    public static String B = "ext_notify_title";
    public static String C = "ext_notify_description";
    public static String D = "ext_messenger";
    public static String E = "title";
    public static String F = "description";
    public static String G = "notifyId";

    /* renamed from: a, reason: collision with root package name */
    public static String f50819a = "1";

    /* renamed from: b, reason: collision with root package name */
    public static String f50820b = "2";

    /* renamed from: c, reason: collision with root package name */
    public static String f50821c = "3";

    /* renamed from: d, reason: collision with root package name */
    public static String f50822d = "com.xiaomi.push.OPEN_CHANNEL";

    /* renamed from: e, reason: collision with root package name */
    public static String f50823e = "com.xiaomi.push.SEND_MESSAGE";

    /* renamed from: f, reason: collision with root package name */
    public static String f50824f = "com.xiaomi.push.SEND_IQ";

    /* renamed from: g, reason: collision with root package name */
    public static String f50825g = "com.xiaomi.push.BATCH_SEND_MESSAGE";

    /* renamed from: h, reason: collision with root package name */
    public static String f50826h = "com.xiaomi.push.SEND_PRES";

    /* renamed from: i, reason: collision with root package name */
    public static String f50827i = "com.xiaomi.push.CLOSE_CHANNEL";

    /* renamed from: j, reason: collision with root package name */
    public static String f50828j = "com.xiaomi.push.FORCE_RECONN";

    /* renamed from: k, reason: collision with root package name */
    public static String f50829k = "com.xiaomi.push.RESET_CONN";

    /* renamed from: l, reason: collision with root package name */
    public static String f50830l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";

    /* renamed from: m, reason: collision with root package name */
    public static String f50831m = "com.xiaomi.push.PING_TIMER";

    /* renamed from: n, reason: collision with root package name */
    public static String f50832n = "ext_user_id";

    /* renamed from: o, reason: collision with root package name */
    public static String f50833o = "ext_user_res";

    /* renamed from: p, reason: collision with root package name */
    public static String f50834p = "ext_chid";

    /* renamed from: q, reason: collision with root package name */
    public static String f50835q = "ext_token";

    /* renamed from: r, reason: collision with root package name */
    public static String f50836r = "ext_auth_method";

    /* renamed from: s, reason: collision with root package name */
    public static String f50837s = "ext_security";

    /* renamed from: t, reason: collision with root package name */
    public static String f50838t = "ext_kick";

    /* renamed from: u, reason: collision with root package name */
    public static String f50839u = "ext_client_attr";

    /* renamed from: v, reason: collision with root package name */
    public static String f50840v = "ext_cloud_attr";

    /* renamed from: w, reason: collision with root package name */
    public static String f50841w = "ext_pkg_name";

    /* renamed from: x, reason: collision with root package name */
    public static String f50842x = "ext_notify_id";

    /* renamed from: y, reason: collision with root package name */
    public static String f50843y = "ext_notify_type";

    /* renamed from: z, reason: collision with root package name */
    public static String f50844z = "ext_session";

    public static String a(int i10) {
        switch (i10) {
            case 0:
                return "ERROR_OK";
            case 1:
                return "ERROR_SERVICE_NOT_INSTALLED";
            case 2:
                return "ERROR_NETWORK_NOT_AVAILABLE";
            case 3:
                return "ERROR_NETWORK_FAILED";
            case 4:
                return "ERROR_ACCESS_DENIED";
            case 5:
                return "ERROR_AUTH_FAILED";
            case 6:
                return "ERROR_MULTI_LOGIN";
            case 7:
                return "ERROR_SERVER_ERROR";
            case 8:
                return "ERROR_RECEIVE_TIMEOUT";
            case 9:
                return "ERROR_READ_ERROR";
            case 10:
                return "ERROR_SEND_ERROR";
            case 11:
                return "ERROR_RESET";
            case 12:
                return "ERROR_NO_CLIENT";
            case 13:
                return "ERROR_SERVER_STREAM";
            case 14:
                return "ERROR_THREAD_BLOCK";
            case 15:
                return "ERROR_SERVICE_DESTROY";
            case 16:
                return "ERROR_SESSION_CHANGED";
            case 17:
                return "ERROR_READ_TIMEOUT";
            case 18:
                return "ERROR_CONNECTIING_TIMEOUT";
            case 19:
                return "ERROR_USER_BLOCKED";
            case 20:
                return "ERROR_REDIRECT";
            case 21:
                return "ERROR_BIND_TIMEOUT";
            case 22:
                return "ERROR_PING_TIMEOUT";
            default:
                return String.valueOf(i10);
        }
    }
}
