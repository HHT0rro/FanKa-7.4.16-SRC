package com.huawei.appgallery.agd.agdpro.impl.web;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import com.huawei.appgallery.agd.core.R$id;
import com.huawei.appgallery.agd.core.internalapi.IntentKey;
import com.huawei.appgallery.agd.pageframe.api.FLFragment;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.hmf.md.spec.jmessage;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.jmessage.api.EventQueue;
import e9.e;
import e9.w;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wa.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class VideoPageActivity extends WebPageActivity implements FLFragment.Callback {

    /* renamed from: f, reason: collision with root package name */
    public String f27273f;

    /* renamed from: g, reason: collision with root package name */
    public long f27274g;

    /* renamed from: h, reason: collision with root package name */
    public long f27275h;

    /* renamed from: i, reason: collision with root package name */
    public int f27276i;

    /* renamed from: j, reason: collision with root package name */
    public EventQueue f27277j;

    public final void a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("progress", this.f27274g);
            jSONObject.put("uniqueId", this.mUniqueId);
            jSONObject.put("duration", this.f27275h);
            this.f27277j.publish("nofifyVideoCurrenttime", jSONObject);
        } catch (JSONException unused) {
            e.f48945d.d("VideoPageActivity", "dispatch message error");
        }
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.Callback
    public JSONArray getLayoutData() {
        try {
            return new JSONArray(new b(getIntent().getExtras()).d(IntentKey.INTENT_KEY_CARD_DATA));
        } catch (JSONException unused) {
            e.f48945d.e("VideoPageActivity", "get data error");
            return null;
        }
    }

    @Override // com.huawei.appgallery.agd.core.impl.webview.WebViewActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        a();
        super.onBackPressed();
    }

    @Override // com.huawei.appgallery.agd.agdpro.impl.web.WebPageActivity, com.huawei.appgallery.agd.core.impl.webview.WebViewActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.imv_back) {
            e.f48945d.d("VideoPageActivity", "onClick imv_back");
            a();
            super.onClick(view);
        }
    }

    @Override // com.huawei.appgallery.agd.agdpro.impl.web.WebPageActivity, com.huawei.appgallery.agd.core.impl.webview.WebViewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            z0();
            if (bundle == null) {
                FLFragment fLFragment = new FLFragment();
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                beginTransaction.replace(com.huawei.appgallery.agd.agdpro.R$id.custom_content, fLFragment);
                beginTransaction.commit();
            }
        } catch (Exception unused) {
            e.f48945d.e("VideoPageActivity", "onCreate error");
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq")).unsubscribe(this.f27276i);
    }

    @Override // com.huawei.appgallery.agd.core.impl.webview.WebViewActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            a();
            return super.onKeyDown(i10, keyEvent);
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.Callback
    public void onParseNode(String str, @NonNull FLMap fLMap) {
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.Callback
    public void onParseResult(boolean z10, String str) {
        e.f48945d.i("VideoPageActivity", "isSuccess = " + z10 + " ,reason = " + str);
    }

    public final void z0() {
        b bVar = new b(getIntent().getExtras());
        this.f27273f = bVar.d(IntentKey.INTENT_KEY_VIDEO_URL);
        this.f27274g = bVar.c(IntentKey.INTENT_KEY_VIDEO_PROGRESS, 0L);
        this.mUrl = bVar.d(IntentKey.INTENT_KEY_WEB_URL);
        if (!TextUtils.isEmpty(this.f27273f) && !TextUtils.isEmpty(this.mUrl)) {
            EventQueue eventQueue = (EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq");
            this.f27277j = eventQueue;
            this.f27276i = eventQueue.subscribe("syncVideoCurrenttime", new w(this));
            return;
        }
        e.f48945d.e("VideoPageActivity", "intent param error");
    }
}
