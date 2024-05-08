package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.appmarket.service.externalservice.activityresult.IActivityResult;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.download.app.c;
import com.huawei.openalliance.ad.download.app.d;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AgProtocolActivity extends Activity {
    public static final int B = 1005;
    public static final String C = "agd.extra.autofinish";
    public static final int Code = 1001;
    public static final String D = "agd.extra.bundle.binder";
    public static final String F = "agd.extra.bundle.requestcode";
    public static final int I = 1003;
    public static final int L = 1;
    public static final String S = "agd.extra.bundle";
    public static final int V = 1002;
    public static final int Z = 1004;

    /* renamed from: d, reason: collision with root package name */
    private static final int f32109d = 100;

    /* renamed from: e, reason: collision with root package name */
    private static final int f32110e = 101;

    /* renamed from: f, reason: collision with root package name */
    private static final int f32111f = 102;

    /* renamed from: g, reason: collision with root package name */
    private static final String f32112g = "resolution";

    /* renamed from: h, reason: collision with root package name */
    private static final List<String> f32113h;

    /* renamed from: a, reason: collision with root package name */
    public String f32114a;

    /* renamed from: b, reason: collision with root package name */
    public int f32115b;

    /* renamed from: c, reason: collision with root package name */
    public String f32116c;

    /* renamed from: i, reason: collision with root package name */
    private final IActivityResult f32117i = new a(this);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends IActivityResult.b {
        private WeakReference<AgProtocolActivity> V;

        public a(AgProtocolActivity agProtocolActivity) {
            this.V = new WeakReference<>(agProtocolActivity);
        }

        @Override // com.huawei.appmarket.service.externalservice.activityresult.IActivityResult
        public void onActivityCancel(final int i10) {
            gl.V("resolution", "onActivityCancel requestCode=" + i10);
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.activity.AgProtocolActivity.a.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    AgProtocolActivity agProtocolActivity = a.this.V == null ? null : (AgProtocolActivity) a.this.V.get();
                    if (agProtocolActivity != null) {
                        agProtocolActivity.onActivityResult(i10, 0, null);
                    }
                }
            });
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f32113h = arrayList;
        arrayList.add(u.co);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        eo.Code(getApplicationContext(), this.f32115b, this.f32114a, this.f32116c, com.huawei.openalliance.ad.download.app.a.V);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        int i12;
        super.onActivityResult(i10, i11, intent);
        gl.V("resolution", "requestCode=" + i10 + "resultCode=" + i11 + " appPackageName=" + this.f32114a);
        if (100 == i10) {
            i12 = 1001;
            if (1001 == i11) {
                gl.V("resolution", "AG agree protocol");
            } else {
                gl.V("resolution", "AG disagree protocol");
                i12 = 1002;
            }
        } else {
            if (101 != i10) {
                if (102 == i10) {
                    if (i11 == -1) {
                        gl.V("resolution", "install hiapp");
                        i12 = 1004;
                    } else {
                        gl.V("resolution", "install hiapp, user cancel");
                        i12 = 1005;
                    }
                }
                finish();
            }
            gl.V("resolution", "syncAgResolutionStatus:101");
            i12 = 1003;
        }
        c.Code(this, i12, this.f32114a, this.f32116c, (Class) null);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f.I(new Runnable() { // from class: com.huawei.openalliance.ad.activity.AgProtocolActivity.1
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = AgProtocolActivity.this.getIntent();
                if (intent != null) {
                    try {
                        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(d.f32414d);
                        AgProtocolActivity.this.f32115b = intent.getIntExtra(d.f32415e, 6);
                        AgProtocolActivity.this.f32114a = intent.getStringExtra(d.f32416f);
                        AgProtocolActivity.this.f32116c = intent.getStringExtra("ag_action_name");
                        AgProtocolActivity.this.V();
                        int i10 = AgProtocolActivity.this.f32115b;
                        int i11 = i10 == 6 ? 101 : i10 == 8888 ? 102 : 100;
                        Intent intent2 = new Intent();
                        Bundle bundle2 = new Bundle();
                        bundle2.putBinder("agd.extra.bundle.binder", AgProtocolActivity.this.f32117i.asBinder());
                        bundle2.putInt("agd.extra.bundle.requestcode", i11);
                        intent2.putExtra("agd.extra.bundle", bundle2);
                        if (AgProtocolActivity.f32113h.contains(AgProtocolActivity.this.getPackageName())) {
                            intent2.putExtra("agd.extra.autofinish", 1);
                        }
                        gl.V("resolution", "resolution type=" + AgProtocolActivity.this.f32115b);
                        AgProtocolActivity.this.startIntentSenderForResult(pendingIntent.getIntentSender(), i11, intent2, 0, 0, 0);
                    } catch (Throwable th) {
                        gl.V("resolution", "startIntentSenderForResult error:e=" + th.getClass().getName());
                        AgProtocolActivity.this.finish();
                    }
                }
            }
        });
    }
}
