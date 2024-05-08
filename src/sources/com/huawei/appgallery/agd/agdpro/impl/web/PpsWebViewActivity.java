package com.huawei.appgallery.agd.agdpro.impl.web;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import com.huawei.appgallery.agd.agdpro.R$drawable;
import com.huawei.appgallery.agd.agdpro.R$id;
import com.huawei.appgallery.agd.core.impl.webview.WebViewActivity;
import com.huawei.appgallery.agd.core.internalapi.IntentKey;
import com.huawei.appgallery.agd.core.internalapi.PpsWebJsObject;
import com.huawei.appgallery.agd.pageframe.api.FLFragment;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import e9.e;
import org.json.JSONArray;
import org.json.JSONException;
import wa.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class PpsWebViewActivity extends WebViewActivity implements FLFragment.Callback {
    @Override // com.huawei.appgallery.agd.core.impl.webview.WebViewActivity
    public void checkDarkTheme() {
        boolean isDarkTheme = isDarkTheme();
        e.f48945d.i("PpsWebViewActivity", "WebPageActivity#checkDarkTheme  isDarkTheme=" + isDarkTheme);
        if (isDarkTheme) {
            this.imgBack.setImageResource(R$drawable.ic_close_no_circle_white);
        } else {
            this.imgBack.setImageResource(R$drawable.ic_close_no_circle_black);
        }
    }

    @Override // com.huawei.appgallery.agd.core.impl.webview.WebViewActivity
    public Object getJsObject() {
        return new PpsWebJsObject(this, this.mWebview);
    }

    @Override // com.huawei.appgallery.agd.core.impl.webview.WebViewActivity
    public String getJsObjectName() {
        return "HwPPS";
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.Callback
    public JSONArray getLayoutData() {
        try {
            return new JSONArray(new b(getIntent().getExtras()).d(IntentKey.INTENT_KEY_CARD_DATA));
        } catch (JSONException unused) {
            e.f48945d.e("PpsWebViewActivity", "get data error");
            return null;
        }
    }

    @Override // com.huawei.appgallery.agd.core.impl.webview.WebViewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            FLFragment fLFragment = new FLFragment();
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R$id.bottom_content, fLFragment);
            beginTransaction.commit();
        }
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.Callback
    public void onParseNode(String str, @NonNull FLMap fLMap) {
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.Callback
    public void onParseResult(boolean z10, String str) {
        e.f48945d.i("PpsWebViewActivity", "isSuccess = " + z10 + " ,reason = " + str);
    }
}
