package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AdSlot implements SlotType {

    /* renamed from: c, reason: collision with root package name */
    private int f11004c;
    private String dh;
    private int dk;

    /* renamed from: e, reason: collision with root package name */
    private boolean f11005e;
    private int ej;

    /* renamed from: f, reason: collision with root package name */
    private String f11006f;
    private String fr;

    /* renamed from: hc, reason: collision with root package name */
    private boolean f11007hc;

    /* renamed from: k, reason: collision with root package name */
    private int f11008k;

    /* renamed from: l, reason: collision with root package name */
    private float f11009l;
    private String li;

    /* renamed from: m, reason: collision with root package name */
    private String f11010m;
    private String mj;

    /* renamed from: n, reason: collision with root package name */
    private int f11011n;
    private float np;

    /* renamed from: oa, reason: collision with root package name */
    private String f11012oa;

    /* renamed from: q, reason: collision with root package name */
    private int[] f11013q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f11014r;

    /* renamed from: s, reason: collision with root package name */
    private IMediationAdSlot f11015s;
    private int sy;

    /* renamed from: t, reason: collision with root package name */
    private String f11016t;

    /* renamed from: u, reason: collision with root package name */
    private int f11017u;

    /* renamed from: v, reason: collision with root package name */
    private TTAdLoadType f11018v;
    private int ve;

    /* renamed from: w, reason: collision with root package name */
    private String f11019w;

    /* renamed from: x, reason: collision with root package name */
    private String f11020x;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Builder {

        /* renamed from: c, reason: collision with root package name */
        private int f11021c;
        private String dh;

        /* renamed from: f, reason: collision with root package name */
        private String f11023f;
        private String fr;

        /* renamed from: hc, reason: collision with root package name */
        private String f11024hc;

        /* renamed from: k, reason: collision with root package name */
        private int f11025k;
        private String li;

        /* renamed from: m, reason: collision with root package name */
        private String f11027m;

        /* renamed from: oa, reason: collision with root package name */
        private int f11029oa;

        /* renamed from: q, reason: collision with root package name */
        private int[] f11030q;

        /* renamed from: s, reason: collision with root package name */
        private IMediationAdSlot f11032s;
        private float sy;

        /* renamed from: t, reason: collision with root package name */
        private String f11033t;

        /* renamed from: u, reason: collision with root package name */
        private int f11034u;

        /* renamed from: v, reason: collision with root package name */
        private String f11035v;
        private float ve;

        /* renamed from: x, reason: collision with root package name */
        private String f11037x;
        private int dk = 640;
        private int ej = 320;

        /* renamed from: l, reason: collision with root package name */
        private boolean f11026l = true;
        private boolean np = false;

        /* renamed from: n, reason: collision with root package name */
        private int f11028n = 1;

        /* renamed from: e, reason: collision with root package name */
        private String f11022e = "defaultUser";

        /* renamed from: w, reason: collision with root package name */
        private int f11036w = 2;

        /* renamed from: r, reason: collision with root package name */
        private boolean f11031r = true;
        private TTAdLoadType mj = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f11010m = this.f11027m;
            adSlot.f11011n = this.f11028n;
            adSlot.f11007hc = this.f11026l;
            adSlot.f11005e = this.np;
            adSlot.dk = this.dk;
            adSlot.ej = this.ej;
            adSlot.fr = this.fr;
            adSlot.f11017u = this.f11034u;
            float f10 = this.ve;
            if (f10 <= 0.0f) {
                adSlot.f11009l = this.dk;
                adSlot.np = this.ej;
            } else {
                adSlot.f11009l = f10;
                adSlot.np = this.sy;
            }
            adSlot.f11019w = this.f11024hc;
            adSlot.f11012oa = this.f11022e;
            adSlot.f11004c = this.f11036w;
            adSlot.sy = this.f11029oa;
            adSlot.f11014r = this.f11031r;
            adSlot.f11013q = this.f11030q;
            adSlot.f11008k = this.f11025k;
            adSlot.f11016t = this.f11033t;
            adSlot.f11020x = this.dh;
            adSlot.mj = this.li;
            adSlot.dh = this.f11035v;
            adSlot.ve = this.f11021c;
            adSlot.f11006f = this.f11023f;
            adSlot.li = this.f11037x;
            adSlot.f11018v = this.mj;
            adSlot.f11015s = this.f11032s;
            return adSlot;
        }

        public Builder setAdCount(int i10) {
            if (i10 <= 0) {
                i10 = 1;
            }
            if (i10 > 20) {
                i10 = 20;
            }
            this.f11028n = i10;
            return this;
        }

        public Builder setAdId(String str) {
            this.dh = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.mj = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i10) {
            this.f11021c = i10;
            return this;
        }

        public Builder setAdloadSeq(int i10) {
            this.f11025k = i10;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f11027m = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.li = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f10, float f11) {
            this.ve = f10;
            this.sy = f11;
            return this;
        }

        public Builder setExt(String str) {
            this.f11035v = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.f11030q = iArr;
            return this;
        }

        public Builder setImageAcceptedSize(int i10, int i11) {
            this.dk = i10;
            this.ej = i11;
            return this;
        }

        public Builder setIsAutoPlay(boolean z10) {
            this.f11031r = z10;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.f11024hc = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.f11032s = iMediationAdSlot;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i10) {
            this.f11029oa = i10;
            return this;
        }

        public Builder setOrientation(int i10) {
            this.f11036w = i10;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.f11033t = str;
            return this;
        }

        public Builder setRewardAmount(int i10) {
            this.f11034u = i10;
            return this;
        }

        public Builder setRewardName(String str) {
            this.fr = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z10) {
            this.f11026l = z10;
            return this;
        }

        public Builder setUserData(String str) {
            this.f11037x = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f11022e = str;
            return this;
        }

        public Builder supportRenderControl() {
            this.np = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.f11023f = str;
            return this;
        }
    }

    public int getAdCount() {
        return this.f11011n;
    }

    public String getAdId() {
        return this.f11020x;
    }

    public TTAdLoadType getAdLoadType() {
        return this.f11018v;
    }

    public int getAdType() {
        return this.ve;
    }

    public int getAdloadSeq() {
        return this.f11008k;
    }

    public String getBidAdm() {
        return this.f11006f;
    }

    public String getCodeId() {
        return this.f11010m;
    }

    public String getCreativeId() {
        return this.mj;
    }

    public float getExpressViewAcceptedHeight() {
        return this.np;
    }

    public float getExpressViewAcceptedWidth() {
        return this.f11009l;
    }

    public String getExt() {
        return this.dh;
    }

    public int[] getExternalABVid() {
        return this.f11013q;
    }

    public int getImgAcceptedHeight() {
        return this.ej;
    }

    public int getImgAcceptedWidth() {
        return this.dk;
    }

    public String getMediaExtra() {
        return this.f11019w;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.f11015s;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.sy;
    }

    public int getOrientation() {
        return this.f11004c;
    }

    public String getPrimeRit() {
        String str = this.f11016t;
        return str == null ? "" : str;
    }

    public int getRewardAmount() {
        return this.f11017u;
    }

    public String getRewardName() {
        return this.fr;
    }

    public String getUserData() {
        return this.li;
    }

    public String getUserID() {
        return this.f11012oa;
    }

    public boolean isAutoPlay() {
        return this.f11014r;
    }

    public boolean isSupportDeepLink() {
        return this.f11007hc;
    }

    public boolean isSupportRenderConrol() {
        return this.f11005e;
    }

    public void setAdCount(int i10) {
        this.f11011n = i10;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.f11018v = tTAdLoadType;
    }

    public void setExternalABVid(int... iArr) {
        this.f11013q = iArr;
    }

    public void setGroupLoadMore(int i10) {
        this.f11019w = m(this.f11019w, i10);
    }

    public void setNativeAdType(int i10) {
        this.sy = i10;
    }

    public void setUserData(String str) {
        this.li = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f11010m);
            jSONObject.put("mIsAutoPlay", this.f11014r);
            jSONObject.put("mImgAcceptedWidth", this.dk);
            jSONObject.put("mImgAcceptedHeight", this.ej);
            jSONObject.put("mExpressViewAcceptedWidth", this.f11009l);
            jSONObject.put("mExpressViewAcceptedHeight", this.np);
            jSONObject.put("mAdCount", this.f11011n);
            jSONObject.put("mSupportDeepLink", this.f11007hc);
            jSONObject.put("mSupportRenderControl", this.f11005e);
            jSONObject.put("mMediaExtra", this.f11019w);
            jSONObject.put("mUserID", this.f11012oa);
            jSONObject.put("mOrientation", this.f11004c);
            jSONObject.put("mNativeAdType", this.sy);
            jSONObject.put("mAdloadSeq", this.f11008k);
            jSONObject.put("mPrimeRit", this.f11016t);
            jSONObject.put("mAdId", this.f11020x);
            jSONObject.put("mCreativeId", this.mj);
            jSONObject.put("mExt", this.dh);
            jSONObject.put("mBidAdm", this.f11006f);
            jSONObject.put("mUserData", this.li);
            jSONObject.put("mAdLoadType", this.f11018v);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.f11010m + "', mImgAcceptedWidth=" + this.dk + ", mImgAcceptedHeight=" + this.ej + ", mExpressViewAcceptedWidth=" + this.f11009l + ", mExpressViewAcceptedHeight=" + this.np + ", mAdCount=" + this.f11011n + ", mSupportDeepLink=" + this.f11007hc + ", mSupportRenderControl=" + this.f11005e + ", mMediaExtra='" + this.f11019w + "', mUserID='" + this.f11012oa + "', mOrientation=" + this.f11004c + ", mNativeAdType=" + this.sy + ", mIsAutoPlay=" + this.f11014r + ", mPrimeRit" + this.f11016t + ", mAdloadSeq" + this.f11008k + ", mAdId" + this.f11020x + ", mCreativeId" + this.mj + ", mExt" + this.dh + ", mUserData" + this.li + ", mAdLoadType" + ((Object) this.f11018v) + '}';
    }

    private AdSlot() {
        this.f11004c = 2;
        this.f11014r = true;
    }

    private String m(String str, int i10) {
        JSONObject jSONObject;
        if (i10 < 1) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_tt_group_load_more", i10);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return str;
        }
    }
}
