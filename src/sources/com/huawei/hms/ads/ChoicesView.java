package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ChoicesView extends ImageView {

    /* renamed from: com.huawei.hms.ads.ChoicesView$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ String Code;

        /* renamed from: com.huawei.hms.ads.ChoicesView$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public class C02801 implements RemoteCallResultCallback<String> {
            public C02801() {
            }

            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                String data = callResult.getData();
                SourceParam sourceParam = new SourceParam();
                sourceParam.I(data);
                com.huawei.openalliance.ad.utils.y.Code(ChoicesView.this.getContext(), sourceParam, new com.huawei.openalliance.ad.utils.aj() { // from class: com.huawei.hms.ads.ChoicesView.1.1.1
                    @Override // com.huawei.openalliance.ad.utils.aj
                    public void Code() {
                        gl.Code("ChoicesView", "download icon fail, use local icon");
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ChoicesView.1.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ChoicesView.this.I();
                            }
                        });
                    }

                    @Override // com.huawei.openalliance.ad.utils.aj
                    public void Code(String str2, final Drawable drawable) {
                        if (drawable != null) {
                            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ChoicesView.1.1.1.1
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
            sourceParam.Code(com.huawei.openalliance.ad.constant.u.f32375i);
            sourceParam.I(this.Code);
            sourceParam.I(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("content", com.huawei.openalliance.ad.utils.z.V(sourceParam));
                com.huawei.openalliance.ad.ipc.g.V(ChoicesView.this.getContext()).Code(com.huawei.openalliance.ad.constant.q.L, jSONObject.toString(), new C02801(), String.class);
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
        int i10 = R.dimen.hiad_24_dp;
        int dimensionPixelSize = resources.getDimensionPixelSize(i10);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i10);
        gl.Code("ChoicesView", "adChoiceViewWidth = %s", Integer.valueOf(dimensionPixelSize));
        setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2));
        setImageResource(R.drawable.hiad_hm_info);
    }

    public void Code(int i10) {
        gl.Code("ChoicesView", "changeChoiceViewSize dp = %s", Integer.valueOf(i10));
        Resources resources = getContext().getResources();
        setLayoutParams(new RelativeLayout.LayoutParams(resources.getDimensionPixelSize(i10), resources.getDimensionPixelSize(i10)));
    }

    public void I() {
        setImageResource(R.drawable.hiad_choices_adchoice);
    }

    public void V() {
        setImageResource(R.drawable.hiad_hm_close_btn);
    }

    public void setAdChoiceIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        gl.Code("ChoicesView", "updateIcon from server.");
        com.huawei.openalliance.ad.utils.f.V(new AnonymousClass1(str));
    }
}
