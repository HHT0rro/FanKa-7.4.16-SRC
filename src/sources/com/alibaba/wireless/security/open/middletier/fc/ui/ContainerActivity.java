package com.alibaba.wireless.security.open.middletier.fc.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alibaba.wireless.security.open.middletier.R;
import com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview;
import com.alipay.sdk.util.i;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ContainerActivity extends Activity {
    private static ActivityManager F;
    private IntentFilter C;

    /* renamed from: f, reason: collision with root package name */
    public long f4097f;

    /* renamed from: a, reason: collision with root package name */
    public IBXWebview f4092a = null;

    /* renamed from: b, reason: collision with root package name */
    public Handler f4093b = null;

    /* renamed from: c, reason: collision with root package name */
    public long f4094c = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f4095d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f4096e = "?action=close";

    /* renamed from: g, reason: collision with root package name */
    public String f4098g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f4099h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f4100i = null;

    /* renamed from: j, reason: collision with root package name */
    public String f4101j = null;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4102k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4103l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4104m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4105n = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4106o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4107p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4108q = true;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4109r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4110s = true;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4111t = true;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4112u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4113v = false;

    /* renamed from: w, reason: collision with root package name */
    public int f4114w = 0;

    /* renamed from: x, reason: collision with root package name */
    public int f4115x = 0;

    /* renamed from: y, reason: collision with root package name */
    public volatile int f4116y = 0;

    /* renamed from: z, reason: collision with root package name */
    public volatile int f4117z = 0;
    public volatile int A = 0;
    public volatile int B = 0;
    private DownloadCompleteReceiver D = null;
    private long E = -1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class DownloadCompleteReceiver extends BroadcastReceiver {
        private DownloadCompleteReceiver() {
        }

        private File a(Context context, long j10) {
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            File file = null;
            if (j10 != -1) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(j10);
                query.setFilterByStatus(8);
                Cursor query2 = downloadManager.query(query);
                if (query2 != null) {
                    if (query2.moveToFirst()) {
                        String string = query2.getString(query2.getColumnIndex("local_uri"));
                        if (!TextUtils.isEmpty(string)) {
                            file = new File(Uri.parse(string).getPath());
                        }
                    }
                    query2.close();
                }
            }
            return file;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Uri uri;
            if (intent != null) {
                try {
                    long longExtra = intent.getLongExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, -1L);
                    if (longExtra == ContainerActivity.this.E && "android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
                        ContainerActivity containerActivity = ContainerActivity.this;
                        if (containerActivity.f4109r) {
                            containerActivity.startActivity(new Intent("android.intent.action.VIEW_DOWNLOADS"));
                        } else if (containerActivity.f4112u) {
                            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
                            String mimeTypeForDownloadedFile = downloadManager.getMimeTypeForDownloadedFile(longExtra);
                            if (TextUtils.isEmpty(mimeTypeForDownloadedFile)) {
                                mimeTypeForDownloadedFile = "*/*";
                            }
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.addFlags(268435456);
                            int i10 = Build.VERSION.SDK_INT;
                            if (i10 < 23) {
                                uri = downloadManager.getUriForDownloadedFile(longExtra);
                            } else if (i10 < 24) {
                                uri = Uri.fromFile(a(context, longExtra));
                            } else {
                                ContainerActivity.this.startActivity(new Intent("android.intent.action.VIEW_DOWNLOADS"));
                                uri = null;
                            }
                            if (uri != null) {
                                intent2.setDataAndType(uri, mimeTypeForDownloadedFile);
                                ContainerActivity.this.startActivity(intent2);
                            }
                        }
                    }
                } catch (Exception e2) {
                    ContainerActivity.this.a(true, 2305, "", 0L, e2.getMessage(), "");
                }
            }
            ContainerActivity containerActivity2 = ContainerActivity.this;
            containerActivity2.a(containerActivity2.f4102k, 0, "", 0L, "onReceive", "" + ContainerActivity.this.E);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class DownloadSerice implements IBXWebview.IBXDownloadService {
        private DownloadSerice() {
        }

        @Override // com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview.IBXDownloadService
        public long startDownload(String str, String str2) {
            int i10;
            int i11;
            ContainerActivity containerActivity;
            AlertDialog.Builder positiveButton;
            int i12 = 0;
            try {
                containerActivity = ContainerActivity.this;
                containerActivity.f4100i = str;
                containerActivity.f4101j = str2;
            } catch (Exception e2) {
                e = e2;
                i10 = 0;
            }
            if (!containerActivity.f4105n) {
                if (containerActivity.f4106o) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setData(Uri.parse(str));
                    ContainerActivity.this.startActivity(intent);
                } else if (containerActivity.f4107p) {
                    i10 = 0;
                }
                i11 = 0;
                ContainerActivity containerActivity2 = ContainerActivity.this;
                containerActivity2.a(containerActivity2.f4102k, 0, "", 0L, "startDownload", ContainerActivity.this.E + "|" + i12 + "|" + i11 + "|" + ContainerActivity.this.f4105n + "|" + ContainerActivity.this.f4106o + "|" + ContainerActivity.this.f4107p);
                return ContainerActivity.this.E;
            }
            final HashMap<String, String> installedMarketPackageName = AppStoreUtils.getInstalledMarketPackageName(containerActivity);
            i10 = installedMarketPackageName.size();
            try {
            } catch (Exception e10) {
                e = e10;
                ContainerActivity.this.a(true, 2304, "", 0L, e.getMessage(), "");
                i12 = i10;
                i11 = 0;
                ContainerActivity containerActivity22 = ContainerActivity.this;
                containerActivity22.a(containerActivity22.f4102k, 0, "", 0L, "startDownload", ContainerActivity.this.E + "|" + i12 + "|" + i11 + "|" + ContainerActivity.this.f4105n + "|" + ContainerActivity.this.f4106o + "|" + ContainerActivity.this.f4107p);
                return ContainerActivity.this.E;
            }
            if (installedMarketPackageName.size() > 1) {
                final String[] strArr = new String[installedMarketPackageName.size()];
                Iterator<String> iterator2 = installedMarketPackageName.h().iterator2();
                int i13 = 0;
                while (iterator2.hasNext()) {
                    strArr[i13] = iterator2.next();
                    i13++;
                }
                positiveButton = new AlertDialog.Builder(ContainerActivity.this).setTitle(R.string.sg_app_store_select).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.alibaba.wireless.security.open.middletier.fc.ui.ContainerActivity.DownloadSerice.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i14) {
                        ContainerActivity containerActivity3 = ContainerActivity.this;
                        AppStoreUtils.toMarket(containerActivity3, ContainerActivity.getPackageNameWrapper(containerActivity3), (String) installedMarketPackageName.get(strArr[i14]));
                    }
                });
            } else {
                if (installedMarketPackageName.size() == 1) {
                    ContainerActivity containerActivity3 = ContainerActivity.this;
                    AppStoreUtils.toMarket(containerActivity3, ContainerActivity.getPackageNameWrapper(containerActivity3), installedMarketPackageName.get(installedMarketPackageName.h().iterator2().next()));
                    i12 = i10;
                    i11 = 0;
                    ContainerActivity containerActivity222 = ContainerActivity.this;
                    containerActivity222.a(containerActivity222.f4102k, 0, "", 0L, "startDownload", ContainerActivity.this.E + "|" + i12 + "|" + i11 + "|" + ContainerActivity.this.f4105n + "|" + ContainerActivity.this.f4106o + "|" + ContainerActivity.this.f4107p);
                    return ContainerActivity.this.E;
                }
                containerActivity = ContainerActivity.this;
                if (!containerActivity.f4107p) {
                    positiveButton = new AlertDialog.Builder(ContainerActivity.this).setMessage(R.string.sg_app_store_not_exist).setPositiveButton(R.string.sg_dialog_ok, (DialogInterface.OnClickListener) null);
                }
            }
            positiveButton.create().show();
            i12 = i10;
            i11 = 0;
            ContainerActivity containerActivity2222 = ContainerActivity.this;
            containerActivity2222.a(containerActivity2222.f4102k, 0, "", 0L, "startDownload", ContainerActivity.this.E + "|" + i12 + "|" + i11 + "|" + ContainerActivity.this.f4105n + "|" + ContainerActivity.this.f4106o + "|" + ContainerActivity.this.f4107p);
            return ContainerActivity.this.E;
            i11 = containerActivity.a(str, str2);
            i12 = i10;
            ContainerActivity containerActivity22222 = ContainerActivity.this;
            containerActivity22222.a(containerActivity22222.f4102k, 0, "", 0L, "startDownload", ContainerActivity.this.E + "|" + i12 + "|" + i11 + "|" + ContainerActivity.this.f4105n + "|" + ContainerActivity.this.f4106o + "|" + ContainerActivity.this.f4107p);
            return ContainerActivity.this.E;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, String str2) {
        if (ContextCompat.checkSelfPermission(getApplication(), g.f36124j) == 0) {
            b(str, str2);
            return 1;
        }
        if (this.f4110s) {
            ActivityCompat.requestPermissions(this, new String[]{g.f36124j}, 1139);
            return 2;
        }
        new AlertDialog.Builder(this).setMessage(R.string.sg_permission_failed).setPositiveButton(R.string.sg_dialog_ok, (DialogInterface.OnClickListener) null).create().show();
        return 3;
    }

    private String a(String str) throws MalformedURLException {
        String query = new URL(str).getQuery();
        StringBuilder sb2 = new StringBuilder();
        if (TextUtils.isEmpty(query)) {
            sb2.append(str);
            if (!str.endsWith(SymbolValues.QUESTION_EN_SYMBOL)) {
                sb2.append(SymbolValues.QUESTION_EN_SYMBOL);
            }
            sb2.append("tmd_nc=1");
            return sb2.toString();
        }
        String str2 = null;
        for (String str3 : query.split("&")) {
            if (str3.startsWith("http_referer=")) {
                this.f4095d = str3.substring(13);
                str2 = str3;
            } else if (!str3.equalsIgnoreCase("native=1")) {
                sb2.append(str3);
                sb2.append("&");
            }
        }
        sb2.append("tmd_nc=1");
        if (str2 != null) {
            sb2.append("&");
            sb2.append(str2);
        }
        return str.replace(query, sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f4113v = true;
        if (isFinishing()) {
            return;
        }
        a(0, "", "finishActivity", "", false, this.f4102k, 23);
        if (isTaskRoot()) {
            finishAndRemoveTask();
        } else {
            finish();
        }
    }

    private long b(String str, String str2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        request.setVisibleInDownloadsUi(true);
        request.setAllowedOverRoaming(true);
        request.setAllowedNetworkTypes(2);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(str, str2, getMIMEType(str)));
        DownloadManager downloadManager = (DownloadManager) getSystemService("download");
        if (this.f4108q) {
            Toast.makeText(this, "开始下载更新包", 0).show();
        }
        long enqueue = downloadManager.enqueue(request);
        this.E = enqueue;
        return enqueue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (isFinishing()) {
            return;
        }
        a(0, "", "finishCurrentActivity", "", false, this.f4102k, 23);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context) {
        try {
            if (F == null) {
                F = (ActivityManager) context.getSystemService("activity");
            }
            ActivityManager activityManager = F;
            if (activityManager != null) {
                String packageName = context.getPackageName();
                List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                if (runningTasks != null && runningTasks.size() > 0) {
                    ComponentName componentName = runningTasks.get(0).topActivity;
                    if (!packageName.equals(componentName.getPackageName()) || !context.getPackageManager().getActivityInfo(componentName, 0).processName.equals(context.getApplicationInfo().processName)) {
                        return false;
                    }
                    if (!ContainerActivity.class.getName().equals(componentName.getClassName())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String getMIMEType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public static String getPackageNameWrapper(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception unused) {
            return null;
        }
    }

    public void a(int i10, String str, String str2, String str3, boolean z10, boolean z11, int i11) {
        long currentTimeMillis = System.currentTimeMillis() - this.f4097f;
        if (z11) {
            a(z11, 0, str, currentTimeMillis, str2, str3);
        }
        String str4 = "{mn:100155,ec:" + i10 + ",msg:" + str + ",tc:" + currentTimeMillis + ",cp:" + str2 + ",ext:" + str3 + ",sid:" + this.f4094c + ",bxuid:" + this.f4099h + i.f4738d;
        Intent intent = new Intent(IUIBridge.INTENT_SEND_LOG);
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra(IUIBridge.KEY_UI_LOG, str4);
        intent.putExtra(IUIBridge.KEY_UI_LOG_WAY, 6);
        intent.putExtra(IUIBridge.KEY_UI_LOG_SEND, z10);
        intent.putExtra(IUIBridge.KEY_UI_INFO, i11 + "&" + this.f4099h);
        intent.putExtra(IUIBridge.KEY_IS_SAMPLE, this.f4103l);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void a(long j10, String str, int i10) {
        Intent intent = new Intent(str);
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra(IUIBridge.KEY_SESSION_ID, j10);
        intent.putExtra(IUIBridge.KEY_UI_RESULT, i10);
        intent.putExtra(IUIBridge.KEY_IS_SAMPLE, this.f4103l);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void a(boolean z10, int i10, String str, long j10, String str2, String str3) {
        if (z10) {
            UserTrackMethodJniBridge.addUtRecord(Integer.toString(100155), i10, 7, this.f4098g, j10, str, str2, str3, "" + this.f4094c, this.f4099h);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f4103l && this.f4117z == 0) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && this.A == 0) {
                        this.A = 1;
                    }
                } else if (this.f4117z == 0) {
                    this.f4117z = 1;
                    a(0, "", "Dispatchtouchevent", "" + this.f4116y + "" + this.A + "" + this.f4117z, false, true, 21);
                }
            } else if (this.f4116y == 0) {
                this.f4116y = 1;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f4104m) {
            return;
        }
        super.onBackPressed();
        this.B = 4;
        a();
        a(this.f4094c, IUIBridge.INTENT_ACTIVITY_RESULT, 4);
        a(0, "", "Onbackpressed", "" + this.f4104m, false, this.f4102k, 19);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e0  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r16) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.open.middletier.fc.ui.ContainerActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.f4113v = true;
        super.onDestroy();
        IBXWebview iBXWebview = this.f4092a;
        if (iBXWebview != null) {
            try {
                iBXWebview.bxDestroy();
                this.f4092a = null;
            } catch (Exception unused) {
            }
        }
        if (this.f4111t) {
            try {
                if (this.D != null) {
                    getApplication().unregisterReceiver(this.D);
                }
            } catch (Exception unused2) {
            }
        }
        a(0, "", "", "Ondestroy" + this.B, this.B == 0, true, 22);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        a(0, "", "onPause", "onPause", false, this.f4102k, 14);
        if ((this.f4114w & 1) == 1) {
            return;
        }
        this.f4093b.postDelayed(new Runnable() { // from class: com.alibaba.wireless.security.open.middletier.fc.ui.ContainerActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ContainerActivity containerActivity = ContainerActivity.this;
                if (!containerActivity.f4113v && ContainerActivity.b((Context) containerActivity)) {
                    ContainerActivity containerActivity2 = ContainerActivity.this;
                    containerActivity2.B = 5;
                    containerActivity2.a(containerActivity2.f4094c, IUIBridge.INTENT_ACTIVITY_RESULT, 1);
                    ContainerActivity.this.b();
                    ContainerActivity containerActivity3 = ContainerActivity.this;
                    containerActivity3.a(0, "", "onPause", "", false, containerActivity3.f4102k, 20);
                }
            }
        }, 1000L);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        int i11;
        if (i10 == 1139) {
            if (iArr.length > 0 && iArr[0] == 0) {
                b(this.f4100i, this.f4101j);
                i11 = 1;
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, g.f36124j)) {
                new AlertDialog.Builder(this).setMessage("应用更新需要授予存储权限，请到设置中开启存储权限").setPositiveButton("确定", (DialogInterface.OnClickListener) null).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
                i11 = 2;
            } else {
                new AlertDialog.Builder(this).setMessage("应用更新需要授予存储权限，请到设置中开启存储权限").setPositiveButton("确定", (DialogInterface.OnClickListener) null).create().show();
                i11 = 3;
            }
            a(this.f4102k, 0, "", 0L, "onRequestPermissionsResult", "" + i11);
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        a(0, "", "onRestart", "onRestart", false, this.f4102k, 25);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (((this.f4114w >> 1) & 1) != 1) {
            a(this.f4094c, IUIBridge.INTENT_ACTIVITY_CREATE, 1);
        }
        a(0, "", "onResume", "onResume", false, this.f4102k, 13);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        a(0, "", "onStart", "onStart", false, this.f4102k, 24);
    }
}
