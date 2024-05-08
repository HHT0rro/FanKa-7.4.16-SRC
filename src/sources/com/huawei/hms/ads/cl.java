package com.huawei.hms.ads;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.huawei.hms.ads.template.DTManager;
import com.huawei.hms.ads.template.b;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cl extends cq<ImageView> {
    private String B;
    private String C;
    private String D;
    private String F;
    private String I;
    private String L;
    private String S;
    private String Z;

    /* renamed from: a, reason: collision with root package name */
    private int f29073a;

    public cl(ImageView imageView) {
        super(imageView);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Code(java.lang.String r4, java.lang.Runnable r5) {
        /*
            r3 = this;
            java.lang.String r0 = "http"
            boolean r0 = r4.startsWith(r0)
            if (r0 == 0) goto L54
            com.huawei.hms.ads.template.DTManager r5 = com.huawei.hms.ads.template.DTManager.getInstance()
            com.huawei.hms.ads.template.IImageLoader r5 = r5.Code()
            java.lang.String r0 = r3.L
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "checkSha256FlagData format exception"
            java.lang.String r2 = "ImageSrcHandler"
            if (r0 != 0) goto L2e
            r0 = 0
            r3.f29073a = r0
            java.lang.String r0 = r3.D
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L46
            java.lang.String r0 = r3.D     // Catch: java.lang.NumberFormatException -> L3f
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L3f
            goto L3c
        L2e:
            java.lang.String r0 = r3.D
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L43
            java.lang.String r0 = r3.D     // Catch: java.lang.NumberFormatException -> L3f
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L3f
        L3c:
            r3.f29073a = r0     // Catch: java.lang.NumberFormatException -> L3f
            goto L46
        L3f:
            com.huawei.hms.ads.gl.I(r2, r1)
            goto L46
        L43:
            r0 = 1
            r3.f29073a = r0
        L46:
            if (r5 == 0) goto L8a
            V extends android.view.View r0 = r3.Code
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r1 = r3.L
            int r2 = r3.f29073a
            r5.load(r0, r4, r1, r2)
            goto L8a
        L54:
            com.huawei.openalliance.ad.constant.bq r0 = com.huawei.openalliance.ad.constant.bq.ASSET
            java.lang.String r0 = r0.toString()
            boolean r0 = r4.startsWith(r0)
            if (r0 == 0) goto L64
            r3.V(r4, r5)
            goto L8a
        L64:
            java.lang.String r0 = "@drawable/"
            boolean r0 = r4.startsWith(r0)
            if (r0 == 0) goto L85
            V extends android.view.View r0 = r3.Code
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.content.Context r0 = r0.getContext()
            android.graphics.drawable.Drawable r4 = com.huawei.hms.ads.template.util.b.Code(r0, r4)
            if (r4 == 0) goto L82
            V extends android.view.View r5 = r3.Code
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r5.setImageDrawable(r4)
            goto L8a
        L82:
            if (r5 == 0) goto L8a
            goto L87
        L85:
            if (r5 == 0) goto L8a
        L87:
            r5.run()
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.cl.Code(java.lang.String, java.lang.Runnable):void");
    }

    private void Code(JSONObject jSONObject, Runnable runnable) {
        String str;
        if (!TextUtils.isEmpty(this.Z)) {
            Code(this.Z, runnable);
            return;
        }
        if (TextUtils.isEmpty(this.I) || jSONObject == null) {
            return;
        }
        try {
            String Code = DTManager.getInstance().Code(this.I, jSONObject);
            if (!TextUtils.isEmpty(Code)) {
                Code(Code, runnable);
            } else if (runnable != null) {
                runnable.run();
            }
        } catch (b unused) {
            str = "bindDataForNormalSrc PlacementParseException";
            gl.I("ImageSrcHandler", str);
        } catch (JSONException unused2) {
            str = "bindDataForNormalSrc json exception";
            gl.I("ImageSrcHandler", str);
        } catch (Exception e2) {
            str = "bindDataForNormalSrc " + e2.getClass().getSimpleName();
            gl.I("ImageSrcHandler", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(JSONObject jSONObject) {
        String str;
        if (!TextUtils.isEmpty(this.C)) {
            Code(this.C, (Runnable) null);
            return;
        }
        if (TextUtils.isEmpty(this.B) || jSONObject == null) {
            return;
        }
        try {
            Code(DTManager.getInstance().Code(this.B, jSONObject), (Runnable) null);
        } catch (b unused) {
            str = "bindDataForDefaultSrc PlacementParseException";
            gl.I("ImageSrcHandler", str);
        } catch (JSONException unused2) {
            str = "bindDataForDefaultSrc json exception";
            gl.I("ImageSrcHandler", str);
        } catch (Exception e2) {
            str = "bindDataForDefaultSrc " + e2.getClass().getSimpleName();
            gl.I("ImageSrcHandler", str);
        }
    }

    private void V(String str, final Runnable runnable) {
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(str);
        com.huawei.openalliance.ad.utils.y.Code(((ImageView) this.Code).getContext(), sourceParam, new com.huawei.openalliance.ad.utils.aj() { // from class: com.huawei.hms.ads.cl.2
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                if (runnable != null) {
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.cl.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            runnable.run();
                        }
                    });
                }
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str2, final Drawable drawable) {
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.cl.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((ImageView) cl.this.Code).setImageDrawable(drawable);
                    }
                });
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void V(org.json.JSONObject r5) {
        /*
            r4 = this;
            java.lang.String r0 = "ImageSrcHandler"
            java.lang.String r1 = r4.S
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L7f
            java.lang.String r1 = r4.F
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L13
            goto L7f
        L13:
            com.huawei.hms.ads.template.DTManager r1 = com.huawei.hms.ads.template.DTManager.getInstance()     // Catch: java.lang.Exception -> L20 org.json.JSONException -> L3b com.huawei.hms.ads.template.b -> L3e
            java.lang.String r2 = r4.F     // Catch: java.lang.Exception -> L20 org.json.JSONException -> L3b com.huawei.hms.ads.template.b -> L3e
            java.lang.String r1 = r1.Code(r2, r5)     // Catch: java.lang.Exception -> L20 org.json.JSONException -> L3b com.huawei.hms.ads.template.b -> L3e
            r4.D = r1     // Catch: java.lang.Exception -> L20 org.json.JSONException -> L3b com.huawei.hms.ads.template.b -> L3e
            goto L43
        L20:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "bindDataForSha256Flag "
            r2.append(r3)
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L40
        L3b:
            java.lang.String r1 = "bindDataForSha256Flag json exception"
            goto L40
        L3e:
            java.lang.String r1 = "bindDataForSha256Flag PlacementParseException"
        L40:
            com.huawei.hms.ads.gl.I(r0, r1)
        L43:
            java.lang.String r1 = r4.D
            if (r1 == 0) goto L4f
            int r1 = java.lang.Integer.parseInt(r1)
            r2 = 1
            if (r1 != r2) goto L4f
            return
        L4f:
            com.huawei.hms.ads.template.DTManager r1 = com.huawei.hms.ads.template.DTManager.getInstance()     // Catch: java.lang.Exception -> L5c org.json.JSONException -> L77 com.huawei.hms.ads.template.b -> L7a
            java.lang.String r2 = r4.S     // Catch: java.lang.Exception -> L5c org.json.JSONException -> L77 com.huawei.hms.ads.template.b -> L7a
            java.lang.String r5 = r1.Code(r2, r5)     // Catch: java.lang.Exception -> L5c org.json.JSONException -> L77 com.huawei.hms.ads.template.b -> L7a
            r4.L = r5     // Catch: java.lang.Exception -> L5c org.json.JSONException -> L77 com.huawei.hms.ads.template.b -> L7a
            goto L7f
        L5c:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "bindDataForSha256 "
            r1.append(r2)
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            goto L7c
        L77:
            java.lang.String r5 = "bindDataForSha256 json exception"
            goto L7c
        L7a:
            java.lang.String r5 = "bindDataForSha256 PlacementParseException"
        L7c:
            com.huawei.hms.ads.gl.I(r0, r5)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.cl.V(org.json.JSONObject):void");
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(AttributeSet attributeSet) {
        String attributeValue = attributeSet.getAttributeValue(null, "src");
        String attributeValue2 = attributeSet.getAttributeValue(null, "defaultSrc");
        if (TextUtils.isEmpty(attributeValue) && TextUtils.isEmpty(attributeValue2)) {
            return;
        }
        String I = com.huawei.hms.ads.template.util.a.I(attributeValue);
        this.I = I;
        if (I == null) {
            this.Z = attributeValue;
        }
        String I2 = com.huawei.hms.ads.template.util.a.I(attributeValue2);
        this.B = I2;
        if (I2 == null) {
            this.C = attributeValue2;
        }
        String attributeValue3 = attributeSet.getAttributeValue(null, com.huawei.openalliance.ad.constant.ax.aq);
        String attributeValue4 = attributeSet.getAttributeValue(null, "checkSha256Flag");
        this.S = com.huawei.hms.ads.template.util.a.I(attributeValue3);
        this.F = com.huawei.hms.ads.template.util.a.I(attributeValue4);
    }

    @Override // com.huawei.hms.ads.cq, com.huawei.hms.ads.cf
    public void Code(final JSONObject jSONObject) {
        V(jSONObject);
        if (TextUtils.isEmpty(this.Z) && TextUtils.isEmpty(this.I)) {
            I(jSONObject);
        } else {
            Code(jSONObject, new Runnable() { // from class: com.huawei.hms.ads.cl.1
                @Override // java.lang.Runnable
                public void run() {
                    cl.this.I(jSONObject);
                }
            });
        }
    }
}
