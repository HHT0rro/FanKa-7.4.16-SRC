package com.huawei.appgallery.agd.agdpro.impl.web;

import android.os.Bundle;
import android.view.View;
import com.huawei.appgallery.agd.agdpro.R$drawable;
import com.huawei.appgallery.agd.agdpro.impl.reward.AgdRewardAd;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.MaintData;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.huawei.appgallery.agd.core.impl.report.OperationBi;
import com.huawei.appgallery.agd.core.impl.webview.WebViewActivity;
import com.huawei.appgallery.agd.core.internalapi.IntentKey;
import e9.a;
import e9.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class WebPageActivity extends WebViewActivity {

    /* renamed from: e, reason: collision with root package name */
    public int f27278e = 0;

    @Override // com.huawei.appgallery.agd.core.impl.webview.WebViewActivity
    public void checkDarkTheme() {
        boolean isDarkTheme = isDarkTheme();
        e eVar = e.f48945d;
        StringBuilder b4 = a.b("WebPageActivity#checkDarkTheme jumpType=");
        b4.append(this.f27278e);
        b4.append(",isDarkTheme=");
        b4.append(isDarkTheme);
        eVar.i("WebPageActivity", b4.toString());
        if (this.f27278e != 1) {
            super.checkDarkTheme();
        } else if (isDarkTheme) {
            this.imgBack.setImageResource(R$drawable.ic_close_white);
        } else {
            this.imgBack.setImageResource(R$drawable.ic_close_black);
        }
    }

    @Override // com.huawei.appgallery.agd.core.impl.webview.WebViewActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        AgdRewardAd e2;
        super.onClick(view);
        if (this.f27278e != 1 || (e2 = AgdRewardAd.e(this.adid)) == null || e2.g() == null) {
            return;
        }
        e.f48945d.i("WebPageActivity", "onAdClose");
        e2.g().onAdClose();
        MaintBi.reportAdClose(e2.j(), e2.getUniqueId(), this.adid);
        OperationBi.reportAdCallBackOperate("close", e2.j());
        MaintBi.report(new MaintData.Builder(MaintKey.EVENT_VIDEO_PLAY_COMPLETED).setUniqueId(this.mUniqueId).setAdId(this.adid).setUri(this.mUrl).setTaskPackageName(this.mPackageName).setType(6L).build());
    }

    @Override // com.huawei.appgallery.agd.core.impl.webview.WebViewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            this.f27278e = getIntent().getIntExtra(IntentKey.INTENT_KEY_JUMP_TYPE, 0);
            checkDarkTheme();
        } catch (Exception e2) {
            e eVar = e.f48945d;
            StringBuilder b4 = a.b("onCreate error ");
            b4.append(e2.getMessage());
            eVar.e("WebPageActivity", b4.toString());
            finish();
        }
    }
}
