package com.huawei.hms.ads;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.template.DTManager;
import com.huawei.hms.ads.template.IImageLoader;
import com.huawei.hms.ads.template.util.b;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.constant.bq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ce {
    private Drawable B;
    private View C;
    private Drawable Z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements com.huawei.openalliance.ad.utils.aj {
        private dp Code;

        public a(dp dpVar) {
            this.Code = dpVar;
        }

        @Override // com.huawei.openalliance.ad.utils.aj
        public void Code() {
            gl.I("BackgroundAttrHandler", "asset img load failed");
        }

        @Override // com.huawei.openalliance.ad.utils.aj
        public void Code(String str, final Drawable drawable) {
            gl.V("BackgroundAttrHandler", "asset img load success");
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ce.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.Code.setDrawable(drawable);
                }
            });
        }
    }

    public ce(View view) {
        this.C = view;
    }

    private Drawable Code(Object obj) {
        if (obj != null) {
            if (obj instanceof JSONObject) {
                return new Cdo(this.C.getContext(), (JSONObject) obj);
            }
            if (obj instanceof String) {
                return I((String) obj);
            }
        }
        return null;
    }

    private void Code(Drawable drawable) {
        if (drawable == null || !(drawable instanceof dp)) {
            return;
        }
        dp dpVar = (dp) drawable;
        if (dpVar.V() != null) {
            gl.V("BackgroundAttrHandler", "actual drawable is already loaded");
            return;
        }
        String Code = dpVar.Code();
        if (Code != null) {
            if (Code.startsWith("http")) {
                V(dpVar);
            } else if (Code.startsWith(bq.ASSET.toString())) {
                Code(dpVar);
            }
        }
    }

    private void Code(dp dpVar) {
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(dpVar.Code());
        com.huawei.openalliance.ad.utils.y.Code(this.C.getContext(), sourceParam, new a(dpVar));
    }

    private Drawable I(String str) {
        if (!str.startsWith("#")) {
            if (str.startsWith("http") || str.startsWith(bq.ASSET.toString())) {
                return new dp(this.C, str);
            }
            if (str.startsWith("@")) {
                return b.Code(this.C.getContext(), str);
            }
            return null;
        }
        try {
            return new ColorDrawable(Color.parseColor(str));
        } catch (IllegalArgumentException e2) {
            gl.I("BackgroundAttrHandler", "parse color error " + e2.getClass().getSimpleName());
            return null;
        }
    }

    private void V(dp dpVar) {
        IImageLoader Code = DTManager.getInstance().Code();
        if (Code != null) {
            Code.loadDrawable(dpVar, dpVar.Code());
        }
    }

    private boolean V(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.Z = Code(jSONObject.opt("normal"));
            Drawable Code = Code(jSONObject.opt("pressed"));
            this.B = Code;
            Drawable drawable = this.Z;
            if (drawable == null && Code == null) {
                return false;
            }
            StateListDrawable stateListDrawable = null;
            if (drawable instanceof StateListDrawable) {
                stateListDrawable = (StateListDrawable) drawable;
            } else if (Code instanceof StateListDrawable) {
                stateListDrawable = (StateListDrawable) Code;
            }
            if (stateListDrawable == null) {
                stateListDrawable = new StateListDrawable();
                Drawable drawable2 = this.B;
                if (drawable2 != null) {
                    stateListDrawable.addState(new int[]{16842919}, drawable2);
                }
                Drawable drawable3 = this.Z;
                if (drawable3 != null) {
                    stateListDrawable.addState(new int[0], drawable3);
                }
            }
            this.C.setBackground(stateListDrawable);
            return true;
        } catch (JSONException unused) {
            gl.I("BackgroundAttrHandler", "parseStateBackground is not valid json");
            return false;
        }
    }

    public void Code(JSONObject jSONObject) {
        Code(this.Z);
        Code(this.B);
    }

    public boolean Code(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.Z = null;
        this.B = null;
        if (str.startsWith("#")) {
            try {
                this.C.setBackgroundColor(Color.parseColor(str));
                return true;
            } catch (IllegalArgumentException e2) {
                gl.I("BackgroundAttrHandler", "parse color error " + e2.getClass().getSimpleName());
                return false;
            }
        }
        if (str.startsWith("http") || str.startsWith(bq.ASSET.toString())) {
            dp dpVar = new dp(this.C, str);
            this.Z = dpVar;
            this.C.setBackground(dpVar);
            return true;
        }
        if (!str.startsWith("@")) {
            if (str.length() > 2 && str.startsWith("{") && str.endsWith(com.alipay.sdk.util.i.f4738d)) {
                return V(str);
            }
            return false;
        }
        Drawable Code = b.Code(this.C.getContext(), str);
        this.Z = Code;
        if (Code == null) {
            return false;
        }
        this.C.setBackground(Code);
        return true;
    }
}
