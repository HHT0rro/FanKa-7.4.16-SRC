package com.wangmai.ad.dex.allmodules.api.reward;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wangmai.ad.dex.allmodules.R$id;
import com.wangmai.ad.dex.allmodules.R$layout;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.utils.appy;
import com.wangmai.common.Ilistener.XAdRewardVideoListener;
import com.wangmai.common.WMAdActListener;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.WMResources;
import com.wangmai.common.view.CustomWebView;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.BitmapCallback;
import com.wangmai.okhttp.model.Response;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class WMRewardLadingViewGroup extends ViewGroup implements WMAdActListener {

    /* renamed from: a, reason: collision with root package name */
    private int f46595a;

    /* renamed from: appa, reason: collision with root package name */
    private String f46596appa;
    private final ApiBean appb;
    private int appc;
    private int appd;
    private TextView appe;
    private TextView appf;
    private ImageView appg;
    private ImageView apph;
    private ImageView appi;
    private ImageView appj;
    private ImageView appk;
    private String appl;
    private String appm;
    private String appn;
    private String appo;
    public float appp;
    public float appq;
    public float appr;
    public float apps;
    private XAdRewardVideoListener appt;
    private CustomWebView appu;
    private RelativeLayout appv;
    private RelativeLayout appw;
    private RelativeLayout appx;
    private LinearLayout appy;
    private View appz;

    /* renamed from: b, reason: collision with root package name */
    private int f46597b;

    /* renamed from: c, reason: collision with root package name */
    private int f46598c;

    /* renamed from: d, reason: collision with root package name */
    private com.wangmai.ad.dex.allmodules.appf.appe f46599d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f46600e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f46601f;

    /* renamed from: g, reason: collision with root package name */
    private int f46602g;

    /* renamed from: h, reason: collision with root package name */
    private String f46603h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f46604i;

    /* renamed from: j, reason: collision with root package name */
    private Context f46605j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements DownloadListener {
        appa() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.wangmai.ad.dex.allmodules.utils.appf.appa(WMRewardLadingViewGroup.this.getContext(), str, str2, str3, str4, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ ApiBean.DownloadAppInfo f46607appa;

        appb(ApiBean.DownloadAppInfo downloadAppInfo) {
            this.f46607appa = downloadAppInfo;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            com.wangmai.ad.dex.allmodules.utils.appf.appc(WMRewardLadingViewGroup.this.f46605j, this.f46607appa.getPrivacy());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46608appa;
        final /* synthetic */ String appb;

        appc(String str, String str2) {
            this.f46608appa = str;
            this.appb = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f46608appa)) {
                com.wangmai.ad.dex.allmodules.utils.appf.appc(WMRewardLadingViewGroup.this.f46605j, this.f46608appa);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<html>");
            stringBuffer.append("<head><style>body{margin:0;padding:50 15 30 15;font-size:38;color:#666666}div{font-size:50;padding-bottom:30;color:#333333;font-weight:bold}</style></head>");
            stringBuffer.append("<body>");
            stringBuffer.append("<center><div>功能介绍</div></center>");
            stringBuffer.append(this.appb);
            stringBuffer.append("</body></html>");
            com.wangmai.ad.dex.allmodules.utils.appf.appc(WMRewardLadingViewGroup.this.f46605j, "wmText://" + ((Object) stringBuffer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46609appa;
        final /* synthetic */ List appb;

        appd(String str, List list) {
            this.f46609appa = str;
            this.appb = list;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f46609appa)) {
                com.wangmai.ad.dex.allmodules.utils.appf.appc(WMRewardLadingViewGroup.this.f46605j, this.f46609appa);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<html>");
            stringBuffer.append("<head><style>body{margin:0;padding:50 15 30 15;font-size:34;color:#999999}</style></head>");
            stringBuffer.append("<body>");
            stringBuffer.append("<center><div style=font-size:46;padding-bottom:30;color:#333333;font-weight:bold>应用权限</div></center>");
            StringBuffer stringBuffer2 = new StringBuffer();
            for (ApiBean.Permission permission : this.appb) {
                stringBuffer2.append("<div style=font-size:40;color:#666666;font-weight:bold;padding-bottom:20>");
                stringBuffer2.append(permission.getTitle());
                stringBuffer2.append("</div>");
                stringBuffer2.append("<div style=padding-bottom:50>");
                stringBuffer2.append(permission.getDescription());
                stringBuffer2.append("</div>");
            }
            stringBuffer.append(stringBuffer2);
            stringBuffer.append("</body></html>");
            com.wangmai.ad.dex.allmodules.utils.appf.appc(WMRewardLadingViewGroup.this.f46605j, "wmText://" + ((Object) stringBuffer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe implements View.OnTouchListener {
        appe() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                WMRewardLadingViewGroup.this.appp = motionEvent.getX();
                WMRewardLadingViewGroup.this.appq = motionEvent.getY();
                WMRewardLadingViewGroup.this.appr = motionEvent.getX();
                WMRewardLadingViewGroup.this.apps = motionEvent.getY();
                WMRewardLadingViewGroup wMRewardLadingViewGroup = WMRewardLadingViewGroup.this;
                ConstantInfo.downX = wMRewardLadingViewGroup.appp;
                ConstantInfo.downY = wMRewardLadingViewGroup.appq;
                try {
                    if (wMRewardLadingViewGroup.appt != null) {
                        WMRewardLadingViewGroup.this.appt.onClick();
                    }
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe(WMRewardLadingViewGroup.this.f46596appa, "激励视频落地页点击预处理错误(layoutMain)：" + th.toString());
                }
                WMRewardLadingViewGroup.this.appa();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appf implements View.OnClickListener {
        appf() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                int nextInt = new Random().nextInt(100) + 1;
                if (WMRewardLadingViewGroup.this.f46602g <= 0 || nextInt > WMRewardLadingViewGroup.this.f46602g) {
                    if (WMRewardLadingViewGroup.this.appt != null) {
                        WMRewardLadingViewGroup.this.appt.onAdClose();
                    }
                    if (WMRewardLadingViewGroup.this.f46599d != null) {
                        WMRewardLadingViewGroup.this.f46599d.appa();
                        return;
                    }
                    return;
                }
                try {
                    if (WMRewardLadingViewGroup.this.appt != null) {
                        WMRewardLadingViewGroup.this.appt.onClick();
                    }
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe(WMRewardLadingViewGroup.this.f46596appa, "激励视频落地页点击预处理错误(imageClear)：" + th);
                }
                WMRewardLadingViewGroup.this.appa();
            } catch (Throwable th2) {
                appa.appa.appf.appd.appe(WMRewardLadingViewGroup.this.f46596appa, "激励视频落地页点击预处理错误(imageClear)：" + th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appg extends BitmapCallback {
        appg() {
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            if (response != null) {
                WMRewardLadingViewGroup.this.apph.setImageBitmap(response.body());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class apph extends BitmapCallback {
        apph() {
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            if (response != null) {
                WMRewardLadingViewGroup.this.appg.setImageBitmap(response.body());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appi extends WebChromeClient {
        appi(WMRewardLadingViewGroup wMRewardLadingViewGroup) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appj implements View.OnTouchListener {
        appj() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                WMRewardLadingViewGroup.this.f46600e = true;
                WMRewardLadingViewGroup.this.f46601f = true;
                try {
                    if (WMRewardLadingViewGroup.this.appt != null) {
                        WMRewardLadingViewGroup.this.appt.onAdClose();
                    }
                    if (WMRewardLadingViewGroup.this.f46599d != null) {
                        WMRewardLadingViewGroup.this.f46599d.appa();
                    }
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe(WMRewardLadingViewGroup.this.f46596appa, "imageWebClearBg onTouch error:" + th);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appk implements View.OnTouchListener {
        appk() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                try {
                    if (WMRewardLadingViewGroup.this.appt != null) {
                        WMRewardLadingViewGroup.this.appt.onAdClose();
                    }
                    if (WMRewardLadingViewGroup.this.f46599d != null) {
                        WMRewardLadingViewGroup.this.f46599d.appa();
                    }
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe(WMRewardLadingViewGroup.this.f46596appa, "imageWebClear onTouch error:" + th);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appl implements View.OnTouchListener {
        appl() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                WMRewardLadingViewGroup.this.f46600e = true;
                if (!WMRewardLadingViewGroup.this.f46601f) {
                    WMRewardLadingViewGroup.this.appp = motionEvent.getX();
                    WMRewardLadingViewGroup.this.appq = motionEvent.getY();
                    WMRewardLadingViewGroup.this.appr = motionEvent.getX();
                    WMRewardLadingViewGroup.this.apps = motionEvent.getY();
                    WMRewardLadingViewGroup wMRewardLadingViewGroup = WMRewardLadingViewGroup.this;
                    ConstantInfo.downX = wMRewardLadingViewGroup.appp;
                    ConstantInfo.downY = wMRewardLadingViewGroup.appq;
                    try {
                        if (wMRewardLadingViewGroup.appt != null) {
                            WMRewardLadingViewGroup.this.appt.onClick();
                        }
                        if (WMRewardLadingViewGroup.this.f46599d != null) {
                            WMRewardLadingViewGroup.this.f46599d.appa();
                        }
                    } catch (Throwable th) {
                        appa.appa.appf.appd.appe(WMRewardLadingViewGroup.this.f46596appa, "激励视频落地页点击预处理错误(layoutWebviewBg)：" + th.toString());
                    }
                    WMRewardLadingViewGroup.this.appa();
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appm implements View.OnTouchListener {
        appm() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && !WMRewardLadingViewGroup.this.f46600e) {
                try {
                    if (WMRewardLadingViewGroup.this.appt != null) {
                        WMRewardLadingViewGroup.this.appt.onClick();
                    }
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe(WMRewardLadingViewGroup.this.f46596appa, "激励视频落地页点击预处理错误(webView)：" + th.toString());
                }
                WMRewardLadingViewGroup.this.appa();
            }
            return false;
        }
    }

    public WMRewardLadingViewGroup(Context context, String str, String str2, String str3, String str4, String str5, ApiBean apiBean, int i10, int i11, XAdRewardVideoListener xAdRewardVideoListener, int i12, com.wangmai.ad.dex.allmodules.appf.appe appeVar) {
        super(context);
        this.f46596appa = "WMRewardLadingViewGroup";
        this.appc = 1;
        this.appd = 0;
        this.appp = -999.0f;
        this.appq = -999.0f;
        this.appr = -999.0f;
        this.apps = -999.0f;
        this.f46605j = context;
        this.appl = str;
        this.appm = str2;
        this.appn = str3;
        this.appo = str4;
        this.appc = i10;
        this.appd = i11;
        this.appt = xAdRewardVideoListener;
        this.f46602g = i12;
        this.f46599d = appeVar;
        this.appb = apiBean;
        appb();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:4:0x0003, B:6:0x0035, B:7:0x003d, B:9:0x0043, B:10:0x004b, B:12:0x0051, B:13:0x0059, B:15:0x0062, B:16:0x0077, B:18:0x007d, B:22:0x0099, B:25:0x00a1, B:27:0x00ba, B:29:0x00c4, B:31:0x00cf, B:33:0x00d6, B:35:0x00dd, B:36:0x00e2, B:40:0x00a7, B:41:0x0086), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:4:0x0003, B:6:0x0035, B:7:0x003d, B:9:0x0043, B:10:0x004b, B:12:0x0051, B:13:0x0059, B:15:0x0062, B:16:0x0077, B:18:0x007d, B:22:0x0099, B:25:0x00a1, B:27:0x00ba, B:29:0x00c4, B:31:0x00cf, B:33:0x00d6, B:35:0x00dd, B:36:0x00e2, B:40:0x00a7, B:41:0x0086), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d6 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:4:0x0003, B:6:0x0035, B:7:0x003d, B:9:0x0043, B:10:0x004b, B:12:0x0051, B:13:0x0059, B:15:0x0062, B:16:0x0077, B:18:0x007d, B:22:0x0099, B:25:0x00a1, B:27:0x00ba, B:29:0x00c4, B:31:0x00cf, B:33:0x00d6, B:35:0x00dd, B:36:0x00e2, B:40:0x00a7, B:41:0x0086), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dd A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:4:0x0003, B:6:0x0035, B:7:0x003d, B:9:0x0043, B:10:0x004b, B:12:0x0051, B:13:0x0059, B:15:0x0062, B:16:0x0077, B:18:0x007d, B:22:0x0099, B:25:0x00a1, B:27:0x00ba, B:29:0x00c4, B:31:0x00cf, B:33:0x00d6, B:35:0x00dd, B:36:0x00e2, B:40:0x00a7, B:41:0x0086), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setDownloadInfo(com.wangmai.ad.dex.allmodules.bean.ApiBean.DownloadAppInfo r12) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.api.reward.WMRewardLadingViewGroup.setDownloadInfo(com.wangmai.ad.dex.allmodules.bean.ApiBean$DownloadAppInfo):void");
    }

    @Override // com.wangmai.common.WMAdActListener
    public void adOnActivityResult(int i10, int i11, Intent intent) {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void adOnConfigurationChanged(Configuration configuration) {
    }

    @Override // com.wangmai.common.WMAdActListener
    public boolean adOnKeyDown(int i10, KeyEvent keyEvent) {
        return i10 == 4;
    }

    @Override // com.wangmai.common.WMAdActListener
    public Resources getAdResources() {
        return null;
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdCreate(Bundle bundle) {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdDestroy() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdPause() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdRestart() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdResume() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdStart() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdStop() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (z10) {
            int i14 = 0;
            for (int i15 = 0; i15 < this.f46595a; i15++) {
                getChildAt(i15).layout(i14, 0, this.f46598c + i14, this.f46597b);
                i14 += this.f46598c;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f46595a = getChildCount();
        if (this.f46595a == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        measureChildren(i10, i11);
        View childAt = getChildAt(0);
        this.f46597b = childAt.getMeasuredHeight();
        this.f46598c = childAt.getMeasuredWidth();
        setMeasuredDimension(this.f46598c * this.f46595a, this.f46597b);
    }

    private void appc() {
        try {
            this.appu.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.appu.getSettings().setUseWideViewPort(true);
            this.appu.getSettings().setDisplayZoomControls(false);
            this.appu.getSettings().setJavaScriptEnabled(true);
            this.appu.getSettings().setAllowFileAccess(true);
            this.appu.getSettings().setBuiltInZoomControls(true);
            this.appu.getSettings().setSupportZoom(true);
            this.appu.getSettings().setLoadWithOverviewMode(true);
            this.appu.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            this.appu.getSettings().setBlockNetworkImage(false);
            this.appu.getSettings().setDefaultTextEncodingName("UTF-8");
            this.appu.setWebChromeClient(new appi(this));
            this.appu.getSettings().setCacheMode(2);
            this.appu.setHorizontalScrollBarEnabled(false);
            this.appu.setVerticalScrollBarEnabled(false);
            this.appu.getSettings().setDomStorageEnabled(false);
            if (Build.VERSION.SDK_INT >= 21) {
                this.appu.getSettings().setMixedContentMode(0);
            }
            int i10 = new DisplayMetrics().densityDpi;
            if (i10 == 240) {
                this.appu.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
            } else if (i10 == 160) {
                this.appu.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
            } else if (i10 == 120) {
                this.appu.getSettings().setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
            } else if (i10 == 320) {
                this.appu.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
            } else if (i10 == 213) {
                this.appu.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
            } else {
                this.appu.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
            }
            this.appk.setOnTouchListener(new appj());
            this.appj.setOnTouchListener(new appk());
            this.appx.setOnTouchListener(new appl());
            this.appu.setOnTouchListener(new appm());
            this.appu.setWebViewClient(new appy(getContext(), this.f46596appa));
            this.appu.setDownloadListener(new appa());
        } catch (Throwable th) {
            appa.appa.appf.appd.appb(this.f46596appa, "Api Reward init webView:" + th.toString());
        }
    }

    private void appd() {
        appa.appa.appf.appd.appa(this.f46596appa, "Api Reward htmlData：" + this.appl);
        if (this.appl.startsWith("<html>")) {
            this.appu.loadDataWithBaseURL(null, this.appl, "text/html", "utf-8", null);
            return;
        }
        String str = "<html><head><style>* body{font-size:15px;margin:0;padding:0}{color:#212121;}img{max-width: 100%; width:auto; height: auto;}</style></head><body>" + this.appl + "</body></html>";
        this.appu.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        appa.appa.appf.appd.appa(this.f46596appa, "Api Reward resultStr：" + str);
    }

    private void appe() {
        try {
            try {
                com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appb.getRespObj().getWxad().getClick_url(), this.appb.getRespObj().getWxad().getDp_try_track_urls(), com.wangmai.ad.dex.allmodules.utils.appf.appl, this.appp, this.appq, this.appr, this.apps);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(this.f46596appa, "RewardLading clickUpEventReport error:" + ((Object) th));
                com.wangmai.ad.dex.allmodules.utils.appf.appa(this.f46605j, "", "RewardLading clickUpEventReport error:" + Log.getStackTraceString(th));
            }
            appa(this.appb.getRespObj().getWxad().getDeep_link(), this.appb.getRespObj().getWxad().getLanding_page_url());
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe(this.f46596appa, "RewardLading openLinkAddress error:" + ((Object) th2));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.f46605j, "", "RewardLading openLinkAddress error:" + Log.getStackTraceString(th2));
        }
    }

    private void appf() {
        try {
            this.appe.setText(this.appo);
            this.appf.setText(this.appn);
            if (!TextUtils.isEmpty(this.appm)) {
                OkHttp.get(this.appm).execute(new appg());
            }
            if (TextUtils.isEmpty(this.appl)) {
                return;
            }
            OkHttp.get(this.appl).execute(new apph());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(this.f46596appa, "upLoadIcon error：" + th.toString());
        }
    }

    private void appg() {
        appd();
    }

    private void apph() {
        appf();
        this.appy.setOnTouchListener(new appe());
        this.appi.setOnClickListener(new appf());
    }

    private void appb() {
        this.appz = LayoutInflater.from(appa.appa.appf.appa.appa(this.f46605j, WMResources.resources)).inflate(R$layout.wm_reward_lading_layout, (ViewGroup) this, false);
        this.appy = (LinearLayout) this.appz.findViewById(R$id.wm_layout_main);
        this.appv = (RelativeLayout) this.appz.findViewById(R$id.wm_layout_landing);
        this.appe = (TextView) this.appz.findViewById(R$id.wm_tv_title);
        this.appf = (TextView) this.appz.findViewById(R$id.wm_text_esc);
        this.apph = (ImageView) this.appz.findViewById(R$id.wm_image_icon);
        this.appi = (ImageView) this.appz.findViewById(R$id.wm_image_clear);
        this.appg = (ImageView) this.appz.findViewById(1879179309);
        this.appw = (RelativeLayout) this.appz.findViewById(R$id.wm_layout_webview);
        this.appu = (CustomWebView) this.appz.findViewById(R$id.wm_webview);
        this.appj = (ImageView) this.appz.findViewById(R$id.wm_image_web_clear);
        this.appx = (RelativeLayout) this.appz.findViewById(R$id.wm_webview_bg);
        this.appk = (ImageView) this.appz.findViewById(R$id.wm_image_web_clear_bg);
        this.f46604i = (TextView) this.appz.findViewById(R$id.wm_download_info);
        addView(this.appz);
        invalidate();
        try {
            if (TextUtils.isEmpty(this.appl)) {
                this.appl = "";
            }
            appa.appa.appf.appd.appa(this.f46596appa, "Api Reward endImgUrl：" + this.appl);
            if (this.appl.startsWith("http")) {
                this.appu.setVisibility(8);
                this.appw.setVisibility(8);
                this.appj.setVisibility(8);
                this.appv.setVisibility(0);
                apph();
            } else {
                appa.appa.appf.appd.appa(this.f46596appa, this.appl);
                appc();
                this.appu.setVisibility(0);
                this.appw.setVisibility(0);
                this.appj.setVisibility(0);
                this.appv.setVisibility(8);
                if (!TextUtils.isEmpty(this.appb.getRespObj().getWxad().getLanding_page_url())) {
                    appa.appa.appf.appd.appa(this.f46596appa, "Api Reward clickPage:" + this.appb.getRespObj().getWxad().getLanding_page_url());
                    this.appx.setVisibility(0);
                    this.appj.setVisibility(8);
                } else {
                    this.appx.setVisibility(8);
                    this.appj.setVisibility(0);
                }
                appg();
            }
            setDownloadInfo(this.appb.getRespObj().getWxad().getDownload_app_info());
        } catch (Throwable th) {
            appa.appa.appf.appd.appb(this.f46596appa, "Api Reward init view:" + th.toString());
        }
    }

    void appa() {
        appa.appa.appf.appd.appe(this.f46596appa, "RewardLading onClick", Thread.currentThread().getName());
        appe();
    }

    private void appa(String str, String str2) {
        try {
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.f46603h, false, str, str2, this.f46605j, this.appp, this.appq, this.appr, this.apps, this.appb, this.appc, this.appd);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(this.f46596appa, "RewardLading clickLoadPage error:" + ((Object) th));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.f46605j, "", "RewardLading clickLoadPage error:" + Log.getStackTraceString(th));
        }
    }
}
