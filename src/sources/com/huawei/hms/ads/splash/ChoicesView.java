package com.huawei.hms.ads.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.constant.q;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.aj;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.f;
import com.huawei.openalliance.ad.utils.y;
import com.huawei.openalliance.ad.utils.z;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ChoicesView extends ImageView {

    /* renamed from: com.huawei.hms.ads.splash.ChoicesView$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ String Code;

        /* renamed from: com.huawei.hms.ads.splash.ChoicesView$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public class C03121 implements RemoteCallResultCallback<String> {
            public C03121() {
            }

            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                String data = callResult.getData();
                SourceParam sourceParam = new SourceParam();
                sourceParam.I(data);
                y.Code(ChoicesView.this.getContext(), sourceParam, new aj() { // from class: com.huawei.hms.ads.splash.ChoicesView.1.1.1
                    @Override // com.huawei.openalliance.ad.utils.aj
                    public void Code() {
                        gl.Code("ChoicesView", "download icon fail, use local icon");
                        ba.Code(new Runnable() { // from class: com.huawei.hms.ads.splash.ChoicesView.1.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ChoicesView.this.I();
                            }
                        });
                    }

                    @Override // com.huawei.openalliance.ad.utils.aj
                    public void Code(String str2, final Drawable drawable) {
                        if (drawable != null) {
                            ba.Code(new Runnable() { // from class: com.huawei.hms.ads.splash.ChoicesView.1.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChoicesView.this.setImageDrawable(drawable);
                                }
                            });
                        }
                    }
                });
            }
        }

        public AnonymousClass1(String str) {
            this.Code = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SourceParam sourceParam = new SourceParam();
            sourceParam.V(false);
            sourceParam.I(true);
            sourceParam.Code(u.f32375i);
            sourceParam.I(this.Code);
            sourceParam.I(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("content", z.V(sourceParam));
                g.V(ChoicesView.this.getContext()).Code(q.L, jSONObject.toString(), new C03121(), String.class);
            } catch (JSONException unused) {
                gl.I("ChoicesView", "load ad choice icon jsonex");
            }
        }
    }

    public ChoicesView(Context context) {
        super(context, null);
        Code();
    }

    @GlobalApi
    public ChoicesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code();
    }

    @GlobalApi
    public ChoicesView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code();
    }

    @GlobalApi
    public ChoicesView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        Code();
    }

    public void Code() {
        Resources resources = getContext().getResources();
        int i10 = com.huawei.hms.ads.base.R.dimen.hiad_24_dp;
        int dimensionPixelSize = resources.getDimensionPixelSize(i10);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i10);
        gl.Code("ChoicesView", "adChoiceViewWidth = %s", Integer.valueOf(dimensionPixelSize));
        setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2));
        setImageResource(com.huawei.hms.ads.base.R.drawable.hiad_hm_info);
    }

    public void I() {
        setImageResource(com.huawei.hms.ads.base.R.drawable.hiad_choices_adchoice);
    }

    public void setAdChoiceIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        gl.Code("ChoicesView", "updateIcon from server.");
        f.V(new AnonymousClass1(str));
    }
}
