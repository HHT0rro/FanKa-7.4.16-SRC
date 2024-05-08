package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.provider.FontsContractCompat;
import com.huawei.flexiblelayout.card.FLPNode;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk {
    private static ej dk = null;
    private static m ej = null;

    /* renamed from: m, reason: collision with root package name */
    private static final String f38840m = "dk";

    /* renamed from: com.ss.android.socialbase.appdownloader.dk$dk, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0588dk {
        boolean m(@NonNull Context context);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ej {
        void m(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.m mVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class l implements Callable<Boolean> {
        private final InterfaceC0588dk dk;
        private final Handler ej;

        /* renamed from: l, reason: collision with root package name */
        private final long f38841l;

        /* renamed from: m, reason: collision with root package name */
        private final Context f38842m;

        public l(Handler handler, Context context, InterfaceC0588dk interfaceC0588dk, long j10) {
            this.f38842m = context;
            this.dk = interfaceC0588dk;
            this.ej = handler;
            this.f38841l = j10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterfaceC0588dk interfaceC0588dk;
            try {
                interfaceC0588dk = this.dk;
            } catch (Throwable unused) {
            }
            if (interfaceC0588dk != null) {
                long j10 = this.f38841l;
                if (j10 > 0 && j10 <= 10000) {
                    Context context = this.f38842m;
                    boolean m10 = context != null ? interfaceC0588dk.m(context) : false;
                    Message obtain = Message.obtain();
                    if (m10) {
                        obtain.what = 2;
                        this.ej.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.ej.sendMessageDelayed(obtain, this.f38841l);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m implements AppStatusManager.AppStatusChangeListener {
        private final int dk;
        private JSONObject ej;

        /* renamed from: m, reason: collision with root package name */
        private final np f38844m;

        public m(Context context, Intent intent, int i10, JSONObject jSONObject, InterfaceC0588dk interfaceC0588dk) {
            this.ej = jSONObject;
            int optInt = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_QUERY_INTERVAL, 1000);
            this.dk = optInt;
            this.f38844m = new np(context, intent, i10, interfaceC0588dk, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
            int optInt = this.ej.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_WAIT_TIME_OUT, 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f38844m.f38849n.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.f38844m.f38849n.sendMessageDelayed(obtain2, optInt * 1000);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            if (!this.f38844m.f38850w) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.f38844m.f38849n.sendMessage(obtain);
            }
            AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            m unused = dk.ej = null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class np implements WeakDownloadHandler.IHandler {
        private static int dk;

        /* renamed from: m, reason: collision with root package name */
        public static int f38845m;

        /* renamed from: e, reason: collision with root package name */
        private Future<Boolean> f38846e;
        private final Context ej;

        /* renamed from: hc, reason: collision with root package name */
        private final long f38847hc;

        /* renamed from: l, reason: collision with root package name */
        private final Intent f38848l;

        /* renamed from: n, reason: collision with root package name */
        private final Handler f38849n;
        private final InterfaceC0588dk np;

        /* renamed from: w, reason: collision with root package name */
        private boolean f38850w = false;

        public np(Context context, Intent intent, int i10, InterfaceC0588dk interfaceC0588dk, long j10) {
            this.ej = context;
            this.f38848l = intent;
            dk = i10;
            this.np = interfaceC0588dk;
            this.f38849n = new WeakDownloadHandler(Looper.getMainLooper(), this);
            this.f38847hc = j10;
        }

        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(Message message) {
            if (message != null) {
                int i10 = message.what;
                if (i10 == 1) {
                    long j10 = this.f38847hc;
                    if (j10 <= 0 || j10 > 10000) {
                        return;
                    }
                    f38845m = 1;
                    this.f38846e = DownloadComponentManager.getCPUThreadExecutor().submit(new l(this.f38849n, this.ej, this.np, this.f38847hc));
                    return;
                }
                if (i10 == 2) {
                    f38845m = 2;
                    this.f38849n.removeMessages(2);
                    this.f38849n.removeMessages(1);
                    Future<Boolean> future = this.f38846e;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.f38850w && (Build.VERSION.SDK_INT < 29 || AppStatusManager.getInstance().isAppForeground())) {
                        Intent intent = this.f38848l;
                        if (intent != null) {
                            dk.dk(this.ej, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.ej).getDownloadInfo(dk);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.ej.dk(this.ej, dk, false);
                            }
                        }
                        this.f38850w = true;
                    }
                    dk.dk(dk, this.f38848l == null, dk.m(this.ej));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public static boolean np(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean dk(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.m mVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            mVar.f38892l = "custom";
            com.ss.android.socialbase.appdownloader.m.m m10 = com.ss.android.socialbase.appdownloader.m.l.m(context, "custom", jSONObject, downloadInfo);
            if (m10 != null && m10.m()) {
                Intent dk2 = m10.dk();
                if (dk2 == null) {
                    return false;
                }
                if (m(new File(savePath), downloadInfo, jSONObject)) {
                    if (dk(context, dk2)) {
                        mVar.dk = 0;
                        return true;
                    }
                    mVar.dk = 1;
                } else {
                    mVar.dk = 6;
                }
                return false;
            }
            mVar.dk = 3;
        }
        return false;
    }

    public static void ej(int i10, JSONObject jSONObject) {
        int i11 = 1;
        boolean z10 = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z10) {
            i11 = 2;
        }
        try {
            jSONObject2.put("scene", i11);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i10, MonitorConstants.UnityLabel.GUIDE_AUTH_OPEN_SETTING, jSONObject2);
    }

    private static void l(int i10, JSONObject jSONObject) {
        int i11 = 1;
        boolean z10 = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z10) {
            i11 = 2;
        }
        try {
            jSONObject2.put("scene", i11);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i10, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_SHOW, jSONObject2);
    }

    public static boolean m(Context context, DownloadInfo downloadInfo, Intent intent, boolean z10) {
        JSONArray optJSONArray = DownloadSetting.obtain(downloadInfo.getId()).optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        if (optJSONArray == null) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (com.ss.android.socialbase.appdownloader.n.m.m(optJSONObject) && m(context, downloadInfo, intent, optJSONObject, z10)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0085. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m(android.content.Context r11, com.ss.android.socialbase.downloader.model.DownloadInfo r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.dk.m(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    public static com.ss.android.socialbase.appdownloader.m dk(JSONObject jSONObject, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.m mVar = new com.ss.android.socialbase.appdownloader.m();
        if (jSONObject == null) {
            return mVar;
        }
        mVar.f38893m = jSONObject.optString("type");
        mVar.np = "vbi";
        if (com.ss.android.socialbase.appdownloader.m.l.m(DownloadComponentManager.getAppContext(), "vbi", jSONObject, downloadSetting)) {
            mVar.dk = 0;
        } else {
            m(mVar, 3);
        }
        return mVar;
    }

    public static void dk(int i10, JSONObject jSONObject) {
        int i11 = 1;
        boolean z10 = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z10) {
            i11 = 2;
        }
        try {
            jSONObject2.put("scene", i11);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i10, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CANCEL, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dk(int i10, boolean z10, boolean z11) {
        JSONObject jSONObject = new JSONObject();
        int i11 = 1;
        try {
            jSONObject.put("scene", z10 ? 1 : 2);
            if (!z11) {
                i11 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i11);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i10, MonitorConstants.UnityLabel.GUIDE_AUTH_RESULT, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean dk(Context context, Intent intent) {
        return m(context, intent, true);
    }

    private static boolean m(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.m mVar, DownloadSetting downloadSetting) {
        boolean z10;
        String optString = jSONObject.optString("type");
        mVar.f38893m = optString;
        Intent dk2 = com.ss.android.socialbase.appdownloader.m.l.m(context, "vbi", jSONObject, downloadInfo).dk();
        StringBuilder sb2 = new StringBuilder();
        try {
            z10 = dk(context, dk2);
        } catch (Throwable th) {
            sb2.append(optString);
            sb2.append(" startActivity failed : ");
            sb2.append(m(th));
            m(mVar, 1);
            z10 = false;
        }
        if (!z10) {
            mVar.ej = sb2.toString();
        } else {
            mVar.dk = 0;
        }
        return true;
    }

    private static boolean m(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.m mVar) {
        boolean z10;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS);
            mVar.np = optString;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb2 = new StringBuilder();
                String str = null;
                int length = split.length;
                int i10 = 0;
                while (true) {
                    z10 = true;
                    if (i10 >= length) {
                        z10 = false;
                        break;
                    }
                    String str2 = split[i10];
                    com.ss.android.socialbase.appdownloader.m.m m10 = com.ss.android.socialbase.appdownloader.m.l.m(context, str2, jSONObject, downloadInfo);
                    if (m10 != null) {
                        Intent dk2 = m10.dk();
                        if (dk2 != null) {
                            if (m(file, downloadInfo, jSONObject)) {
                                try {
                                    m(context, dk2, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb2.append(str2);
                                    sb2.append(" startActivity failed : ");
                                    sb2.append(m(th));
                                    m(mVar, 1);
                                }
                            } else {
                                m(mVar, 6);
                                sb2.append(str2);
                                sb2.append(" createDescFile failed! ");
                            }
                        } else {
                            m(mVar, 3);
                            sb2.append(str2);
                            sb2.append(" resolveActivity failed! ");
                        }
                    }
                    sb2.append("  ");
                    i10++;
                }
                if (!z10) {
                    mVar.ej = sb2.toString();
                } else {
                    mVar.f38892l = str;
                    mVar.dk = 0;
                }
                return z10;
            }
        }
        return false;
    }

    public static int m(@NonNull DownloadSetting downloadSetting) {
        if (!(downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR) != null ? !TextUtils.isEmpty(r0.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME)) : false)) {
            return 5;
        }
        if (!DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_GET_DOWNLOAD_INFO_BY_LIST)) {
            return 4;
        }
        JSONArray optJSONArray = downloadSetting.optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        int i10 = -1;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                if (com.ss.android.socialbase.appdownloader.n.m.m(optJSONObject)) {
                    String optString = optJSONObject.optString("type");
                    if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                        if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i10 = dk(optJSONObject, downloadSetting).dk) == 0)) {
                            return 0;
                        }
                    } else {
                        i10 = m(optJSONObject, downloadSetting).dk;
                        if (i10 == 0) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i10;
    }

    @NonNull
    public static com.ss.android.socialbase.appdownloader.m m(JSONObject jSONObject, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.m mVar = new com.ss.android.socialbase.appdownloader.m();
        if (jSONObject == null) {
            return mVar;
        }
        String optString = jSONObject.optString("type");
        mVar.f38893m = optString;
        if ("plan_b".equals(optString)) {
            mVar.np = "custom";
            if (com.ss.android.socialbase.appdownloader.m.l.m(DownloadComponentManager.getAppContext(), "custom", jSONObject, downloadSetting)) {
                mVar.dk = 0;
                return mVar;
            }
            m(mVar, 3);
        } else {
            String optString2 = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS);
            mVar.np = optString2;
            if (!TextUtils.isEmpty(optString2)) {
                for (String str : optString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.m.l.m(DownloadComponentManager.getAppContext(), str, jSONObject, downloadSetting)) {
                        mVar.dk = 0;
                        return mVar;
                    }
                    m(mVar, 3);
                }
            }
        }
        return mVar;
    }

    public static com.ss.android.socialbase.appdownloader.m m(JSONObject jSONObject, String str, Context context, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.m mVar = new com.ss.android.socialbase.appdownloader.m();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.n.np.ej()) {
            mVar.f38893m = jSONObject.optString("type");
            if (downloadSetting.optInt("bi", 0) == 1) {
                mVar.dk = 0;
                return mVar;
            }
            if (m(context)) {
                mVar.dk = 2;
            } else if (com.ss.android.socialbase.appdownloader.n.m.m(str) != null) {
                mVar.dk = 0;
            } else {
                mVar.dk = 9;
            }
        }
        return mVar;
    }

    private static void m(com.ss.android.socialbase.appdownloader.m mVar, int i10) {
        int i11 = mVar.dk;
        if (i11 != -1) {
            mVar.dk = (i11 * 10) + i10;
        } else {
            mVar.dk = i10;
        }
    }

    private static boolean m(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject optJSONObject = DownloadSetting.obtain(downloadInfo.getId()).optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        File file2 = null;
        String optString = optJSONObject != null ? optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC) : null;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
            file2 = new File(path + File.separator + optString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean m(Context context, @Nullable Intent intent, JSONObject jSONObject, int i10, @Nullable com.ss.android.socialbase.appdownloader.m mVar) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong(DownloadSettingKeys.AhPlans.KEY_JUMP_INTERVAL, 0L);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(DownloadConstants.SP_ANTI_HIJACK_CONFIG, 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, 0L)) / 60000 >= optLong && !m(context)) {
                sharedPreferences.edit().putLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, System.currentTimeMillis()).apply();
                if (jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_SHOW_UNKNOWN_SOURCE_DIALOG, 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra(FLPNode.KEY_CONFIG, jSONObject.toString());
                    intent2.putExtra("id", i10);
                    try {
                        if (m(context, intent2, false)) {
                            l(i10, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (mVar != null) {
                            mVar.dk = 1;
                            mVar.ej = "tryShowUnknownSourceDialog" + m(th);
                        }
                        return false;
                    }
                }
                if (m(context, intent, i10, jSONObject)) {
                    ej(i10, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean m(Context context, @Nullable Intent intent, int i10, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.n.np.ej() && Build.VERSION.SDK_INT < 26 && !l(context)) {
                com.ss.android.socialbase.appdownloader.m.n nVar = new com.ss.android.socialbase.appdownloader.m.n(context);
                if (nVar.m()) {
                    m(context, intent, i10, jSONObject, new InterfaceC0588dk() { // from class: com.ss.android.socialbase.appdownloader.dk.1
                        @Override // com.ss.android.socialbase.appdownloader.dk.InterfaceC0588dk
                        public boolean m(@NonNull Context context2) {
                            return dk.l(context2);
                        }
                    });
                    return dk(context, nVar.dk());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !np(context)) {
                com.ss.android.socialbase.appdownloader.m.dk dkVar = new com.ss.android.socialbase.appdownloader.m.dk(context);
                if (dkVar.m()) {
                    m(context, intent, i10, jSONObject, new InterfaceC0588dk() { // from class: com.ss.android.socialbase.appdownloader.dk.2
                        @Override // com.ss.android.socialbase.appdownloader.dk.InterfaceC0588dk
                        public boolean m(@NonNull Context context2) {
                            return dk.np(context2);
                        }
                    });
                    return dk(context, dkVar.dk());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean m(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.n.np.ej() && Build.VERSION.SDK_INT < 26) {
            return l(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return np(context);
        }
        return true;
    }

    public static boolean m() {
        return np.f38845m == 1;
    }

    public static void m(int i10, JSONObject jSONObject) {
        int i11 = 1;
        boolean z10 = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z10) {
            i11 = 2;
        }
        try {
            jSONObject2.put("scene", i11);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i10, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CONFIRM, jSONObject2);
    }

    private static void m(Context context, Intent intent, int i10, JSONObject jSONObject, InterfaceC0588dk interfaceC0588dk) {
        if (ej != null) {
            AppStatusManager.getInstance().unregisterAppSwitchListener(ej);
            ej = null;
        }
        ej = new m(context, intent, i10, jSONObject, interfaceC0588dk);
        AppStatusManager.getInstance().registerAppSwitchListener(ej);
    }

    public static boolean m(Context context, Intent intent, boolean z10) {
        if (context == null || intent == null) {
            return false;
        }
        if (z10) {
            try {
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra("start_only_for_android", true);
        context.startActivity(intent);
        return true;
    }

    public static String m(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, 500) : th2;
    }

    public static void m(ej ejVar) {
        dk = ejVar;
    }
}
