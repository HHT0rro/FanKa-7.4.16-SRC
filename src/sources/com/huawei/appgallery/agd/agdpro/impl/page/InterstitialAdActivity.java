package com.huawei.appgallery.agd.agdpro.impl.page;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.huawei.appgallery.agd.agdpro.R$id;
import com.huawei.appgallery.agd.agdpro.R$layout;
import com.huawei.appgallery.agd.agdpro.api.InterstitialInteractionListener;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.IAgdAd;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.OperationBi;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.appgallery.agd.pageframe.api.FLFragment;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.secure.android.common.intent.SafeIntent;
import e9.a;
import e9.e;
import e9.i;
import e9.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class InterstitialAdActivity extends FragmentActivity implements FLFragment.Callback {

    /* renamed from: b, reason: collision with root package name */
    public i f27234b;

    /* renamed from: c, reason: collision with root package name */
    public String f27235c;

    /* renamed from: d, reason: collision with root package name */
    public int f27236d;

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.Callback
    @Nullable
    public JSONArray getLayoutData() {
        i iVar = this.f27234b;
        if (iVar != null) {
            return iVar.f48963f;
        }
        return null;
    }

    public final String m0() {
        i iVar = this.f27234b;
        return iVar == null ? "" : iVar.g();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i10;
        i iVar;
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R$layout.activity_intertistial_base);
        if (ApplicationWrapper.getInstance() != null && ApplicationWrapper.getInstance().getContext() != null) {
            SafeIntent safeIntent = new SafeIntent(getIntent());
            if (!safeIntent.hasExtra("uniqueId")) {
                e.f48945d.e("InterstitialAdActivity", "onCreate, intent null or uniqueId null ");
                finish();
                MaintBi.reportAdShow(2002, 0L, m0());
                return;
            }
            if (safeIntent.hasExtra(CardConstants.PAGE_ORIENTATION)) {
                i10 = safeIntent.getIntExtra(CardConstants.PAGE_ORIENTATION, 2) < 0 ? safeIntent.getIntExtra(CardConstants.PAGE_ROTATION_DEGREE, 1) : 1;
                if (safeIntent.getIntExtra(CardConstants.PAGE_ORIENTATION, 2) == 1) {
                    i10 = 0;
                }
            } else {
                i10 = 1;
            }
            try {
                setRequestedOrientation(i10);
            } catch (IllegalStateException e2) {
                e eVar = e.f48945d;
                StringBuilder b4 = a.b("init orientation error: ");
                b4.append(e2.getMessage());
                eVar.e("InterstitialAdActivity", b4.toString());
            }
            this.f27236d = safeIntent.getIntExtra(CardConstants.KEY_SCREEN_TYPE, 2);
            this.f27235c = safeIntent.getStringExtra("uniqueId");
            e eVar2 = e.f48945d;
            a.d(a.b("onCreate, intertistialAd mUniqueId="), this.f27235c, eVar2, "InterstitialAdActivity");
            String str = this.f27235c;
            eVar2.d("InterstitialAdActivity", "fromAdId uniqueId=" + str);
            IAgdAd ad2 = AgdAdManager.getAd(str);
            if (ad2 instanceof i) {
                iVar = (i) ad2;
            } else {
                eVar2.e("InterstitialAdActivity", "fromAdId ad null");
                iVar = null;
            }
            this.f27234b = iVar;
            if (iVar == null) {
                eVar2.e("InterstitialAdActivity", "onCreate, intertistialAd null");
                finish();
                MaintBi.reportAdShow(2010, 0L, m0());
                return;
            }
            if (this.f27236d == 1) {
                p0();
            }
            if (bundle == null) {
                FLFragment fLFragment = new FLFragment();
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                beginTransaction.replace(R$id.fl_layout, fLFragment);
                beginTransaction.commit();
                return;
            }
            return;
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        InterstitialInteractionListener interstitialInteractionListener;
        super.onDestroy();
        if (isFinishing()) {
            AgdAdManager.removeAd(this.f27235c);
        }
        e.f48945d.i("InterstitialAdActivity", "reportAdClose");
        i iVar = this.f27234b;
        if (iVar != null && (interstitialInteractionListener = iVar.f48964g) != null) {
            interstitialInteractionListener.onAdClose();
        }
        MaintBi.reportAdClose(m0(), this.f27235c, "");
        OperationBi.reportAdCallBackOperate("close", m0());
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.Callback
    public void onParseNode(String str, @NonNull FLMap fLMap) {
        AdSlot adSlot;
        int i10;
        i iVar = this.f27234b;
        if (iVar != null && (adSlot = iVar.f48961d) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("slotId", adSlot.getSlotId());
                jSONObject.put(CardConstants.KEY_MEDIA_EXTRA, adSlot.getMediaExtra());
                jSONObject.put("ver", adSlot.getVer());
                jSONObject.put("layoutName", str);
            } catch (JSONException unused) {
                e.f48945d.e("InterstitialAdActivity", "toJsonString: JSONException");
            }
            fLMap.put(CardConstants.KEY_REQUEST_DATA, jSONObject);
            fLMap.put(CardConstants.KEY_SOUND_STATE, Integer.valueOf(this.f27234b.f48961d.getSoundStatus()));
            fLMap.put(CardConstants.KEY_DARK_MODE, Integer.valueOf(this.f27234b.f48961d.getDarkMode()));
            fLMap.put("orientation", Integer.valueOf(this.f27234b.f48961d.getOrientation()));
            fLMap.put(CardConstants.KEY_ROTATION_TIME, Integer.valueOf(this.f27234b.f48961d.getRotationTime()));
            fLMap.put(CardConstants.KEY_DISABLE_COUNTDOWN, this.f27234b.f48961d.getDisableSdkCountDown());
            int i11 = 0;
            if (ApplicationWrapper.getInstance() == null || ApplicationWrapper.getInstance().getContext() == null) {
                i10 = 0;
            } else {
                Context context = ApplicationWrapper.getInstance().getContext();
                t.d(context);
                i10 = t.a(context.getApplicationContext(), t.f48986a.heightPixels);
            }
            fLMap.put(CardConstants.KEY_SCREEN_HEIGHT_REAL, Integer.valueOf(i10));
            if (ApplicationWrapper.getInstance() != null && ApplicationWrapper.getInstance().getContext() != null) {
                Context context2 = ApplicationWrapper.getInstance().getContext();
                t.d(context2);
                i11 = t.a(context2.getApplicationContext(), t.f48986a.widthPixels);
            }
            fLMap.put(CardConstants.KEY_SCREEN_WIDTH_REAL, Integer.valueOf(i11));
        }
        if (this.f27234b != null) {
            fLMap.put("slotId", m0());
            fLMap.put("uniqueId", this.f27235c);
        }
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.Callback
    public void onParseResult(boolean z10, String str) {
        e eVar = e.f48945d;
        eVar.i("InterstitialAdActivity", "onParseResult#reason is " + str);
        if (!z10) {
            eVar.e("InterstitialAdActivity", "layout parse result error #reason is " + str);
            MaintBi.reportAdShow(10001, 0L, m0());
            finish();
        }
        i iVar = this.f27234b;
        if (iVar != null) {
            iVar.f(z10, str);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f27235c = bundle.getString("uniqueId");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f27236d == 1) {
            p0();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("uniqueId", this.f27235c);
    }

    public final void p0() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        getWindow().setAttributes(attributes);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }
}
