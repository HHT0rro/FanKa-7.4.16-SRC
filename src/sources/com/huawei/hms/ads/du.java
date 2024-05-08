package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.ku;
import com.huawei.hms.ads.uiengine.c;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.b;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class du extends c.b {

    /* renamed from: g, reason: collision with root package name */
    private Context f29078g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<PPSNativeView> f29079h;

    /* renamed from: i, reason: collision with root package name */
    private AdContentData f29080i;

    /* renamed from: j, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.data.n f29081j;

    public du(Context context, PPSNativeView pPSNativeView, com.huawei.openalliance.ad.inter.data.n nVar) {
        this.f29078g = context;
        this.f29079h = new WeakReference<>(pPSNativeView);
        this.f29081j = nVar;
        this.f29080i = nVar != null ? nVar.l() : null;
    }

    private dk Code(int i10, com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        return 1 == i10 ? new dn(this.f29078g, appDownloadButton) : 2 == i10 ? new dm(this.f29078g, appDownloadButton) : new dl(this.f29078g, appDownloadButton);
    }

    private void Code(IObjectWrapper iObjectWrapper, String str, int i10) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            if (view instanceof com.huawei.openalliance.ad.views.AppDownloadButton) {
                gl.V("NativeProxy", "registerDownloadBtn");
                final com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton = (com.huawei.openalliance.ad.views.AppDownloadButton) view;
                final PPSNativeView pPSNativeView = this.f29079h.get();
                dk Code = Code(i10, appDownloadButton);
                if (pPSNativeView != null) {
                    if (!Z()) {
                        if (this.f29081j.i_() != 0) {
                            gl.Code("NativeProxy", "show btn");
                            appDownloadButton.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.hms.ads.du.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    PPSNativeView pPSNativeView2 = pPSNativeView;
                                    if (pPSNativeView2 != null) {
                                        pPSNativeView2.Code(appDownloadButton, 1);
                                    }
                                }
                            });
                            Code.Code(str);
                            appDownloadButton.Code();
                            return;
                        }
                        view.setVisibility(8);
                    }
                    if (pPSNativeView.Code((lg) appDownloadButton)) {
                        gl.Code("NativeProxy", "register succ");
                        if (V(str)) {
                            appDownloadButton.setAfDlBtnText(str);
                        }
                        appDownloadButton.setNeedAppendProgress(true);
                        Code.Code(this.f29078g);
                        appDownloadButton.Code();
                        return;
                    }
                    view.setVisibility(8);
                }
            }
        }
    }

    private boolean V(String str) {
        return this.f29081j.v() != null && (this.f29081j.i_() == 4 || this.f29081j.i_() == 8) && !TextUtils.isEmpty(str);
    }

    private boolean Z() {
        return this.f29081j.i_() == 2 || this.f29081j.i_() == 5 || this.f29081j.i_() == 4 || this.f29081j.i_() == 8;
    }

    public void Code(long j10) {
        AdContentData adContentData = this.f29080i;
        if (adContentData == null) {
            return;
        }
        adContentData.Z(j10);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(long j10, long j11) {
        eo.Code(this.f29078g, this.f29080i, j10, j11);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            PPSNativeView pPSNativeView = this.f29079h.get();
            if (view == null || pPSNativeView == null) {
                return;
            }
            pPSNativeView.showFeedback(view);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper, int i10) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            PPSNativeView pPSNativeView = this.f29079h.get();
            if (pPSNativeView != null) {
                pPSNativeView.Code(view, i10);
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper, String str) {
        Code(iObjectWrapper, str, 0);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
        Code(iObjectWrapper, str, bundle.getInt(bg.a.Code));
    }

    public void Code(String str) {
        AdContentData adContentData = this.f29080i;
        if (adContentData == null) {
            return;
        }
        adContentData.V(str);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(String str, int i10) {
        PPSNativeView pPSNativeView = this.f29079h.get();
        if (!com.huawei.openalliance.ad.constant.ae.f32218e.equals(str)) {
            if (pPSNativeView != null) {
                pPSNativeView.Code(Integer.valueOf(i10), false);
            }
        } else {
            ku.a aVar = new ku.a();
            aVar.V(Integer.valueOf(i10));
            if (pPSNativeView != null) {
                aVar.Code(b.Code(pPSNativeView));
            }
            kv.Code(this.f29078g, this.f29080i, aVar.Code(), com.huawei.openalliance.ad.constant.ae.f32218e);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x003e. Please report as an issue. */
    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(String str, long j10, long j11, int i10, int i11) {
        Context context;
        AdContentData adContentData;
        Long valueOf;
        Long valueOf2;
        Integer valueOf3;
        Integer valueOf4;
        String str2;
        Context context2;
        AdContentData adContentData2;
        Long l10;
        Long l11;
        Integer num;
        Integer num2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1891923166:
                if (str.equals(com.huawei.openalliance.ad.constant.ae.C)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1888605810:
                if (str.equals(com.huawei.openalliance.ad.constant.ae.B)) {
                    c4 = 1;
                    break;
                }
                break;
            case -493598457:
                if (str.equals(com.huawei.openalliance.ad.constant.ae.Z)) {
                    c4 = 2;
                    break;
                }
                break;
            case 1540819073:
                if (str.equals(com.huawei.openalliance.ad.constant.ae.S)) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                context = this.f29078g;
                adContentData = this.f29080i;
                valueOf = Long.valueOf(j10);
                valueOf2 = Long.valueOf(j11);
                valueOf3 = Integer.valueOf(i10);
                valueOf4 = Integer.valueOf(i11);
                str2 = com.huawei.openalliance.ad.constant.ae.C;
                kv.Code(context, adContentData, str2, valueOf, valueOf2, valueOf3, valueOf4);
                return;
            case 1:
                context2 = this.f29078g;
                adContentData2 = this.f29080i;
                l10 = null;
                l11 = null;
                num = null;
                num2 = null;
                str3 = com.huawei.openalliance.ad.constant.ae.B;
                kv.Code(context2, adContentData2, str3, l10, l11, num, num2);
                return;
            case 2:
                context = this.f29078g;
                adContentData = this.f29080i;
                valueOf = Long.valueOf(j10);
                valueOf2 = Long.valueOf(j11);
                valueOf3 = Integer.valueOf(i10);
                valueOf4 = Integer.valueOf(i11);
                str2 = com.huawei.openalliance.ad.constant.ae.Z;
                kv.Code(context, adContentData, str2, valueOf, valueOf2, valueOf3, valueOf4);
                return;
            case 3:
                context2 = this.f29078g;
                adContentData2 = this.f29080i;
                l10 = null;
                l11 = null;
                num = null;
                num2 = null;
                str3 = com.huawei.openalliance.ad.constant.ae.S;
                kv.Code(context2, adContentData2, str3, l10, l11, num, num2);
                return;
            default:
                return;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(boolean z10) {
        kv.Code(this.f29078g, this.f29080i, z10);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public boolean Code() {
        return this.f29081j.R();
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void V(String str, long j10, long j11, int i10, int i11) {
        kv.Code(this.f29078g, this.f29080i, com.huawei.openalliance.ad.constant.ae.f32219f, Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf(i10), Integer.valueOf(i11), str);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public boolean V() {
        try {
            boolean booleanValue = ((Boolean) com.huawei.openalliance.ad.utils.aw.Code(new Callable<Boolean>() { // from class: com.huawei.hms.ads.du.1
                @Override // java.util.concurrent.Callable
                /* renamed from: Code, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    if (du.this.f29080i == null) {
                        return Boolean.FALSE;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("apiVer", du.this.f29080i.aA());
                        jSONObject.put("content_id", du.this.f29080i.S());
                        jSONObject.put("templateId", du.this.f29080i.az());
                        jSONObject.put("slotid", du.this.f29080i.C());
                    } catch (Throwable th) {
                        gl.V("NativeProxy", "construct json err: %s", th.getClass().getSimpleName());
                    }
                    return Boolean.valueOf(Boolean.TRUE.toString().equals(com.huawei.openalliance.ad.ipc.b.Code(du.this.f29078g).Code(com.huawei.openalliance.ad.constant.q.f32342y, jSONObject.toString(), String.class).getData()));
                }
            }, Boolean.FALSE)).booleanValue();
            gl.Code("NativeProxy", "result = %s", Boolean.valueOf(booleanValue));
            return booleanValue;
        } catch (Throwable th) {
            gl.V("NativeProxy", "downloadVideos err: %s", th.getClass().getSimpleName());
            return false;
        }
    }
}
