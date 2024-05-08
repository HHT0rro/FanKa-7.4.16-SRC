package com.qq.e.ads.banner2;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ADListenerAdapter implements ADListener {

    /* renamed from: a, reason: collision with root package name */
    private final UnifiedBannerADListener f38105a;

    /* renamed from: b, reason: collision with root package name */
    private NegativeFeedbackListener f38106b;

    /* renamed from: c, reason: collision with root package name */
    private ADRewardListener f38107c;

    public ADListenerAdapter(UnifiedBannerADListener unifiedBannerADListener) {
        this.f38105a = unifiedBannerADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedBannerADListener unifiedBannerADListener;
        String str;
        if (aDEvent == null) {
            return;
        }
        int type = aDEvent.getType();
        if (type == 100) {
            UnifiedBannerADListener unifiedBannerADListener2 = this.f38105a;
            if (unifiedBannerADListener2 != null) {
                unifiedBannerADListener2.onADReceive();
                return;
            }
            return;
        }
        if (type == 101) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            if (num == null || (unifiedBannerADListener = this.f38105a) == null) {
                return;
            }
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
            return;
        }
        if (type == 303) {
            UnifiedBannerADListener unifiedBannerADListener3 = this.f38105a;
            if (unifiedBannerADListener3 != null) {
                unifiedBannerADListener3.onADLeftApplication();
                return;
            }
            return;
        }
        if (type == 304) {
            NegativeFeedbackListener negativeFeedbackListener = this.f38106b;
            if (negativeFeedbackListener != null) {
                negativeFeedbackListener.onComplainSuccess();
                return;
            }
            return;
        }
        switch (type) {
            case 103:
                UnifiedBannerADListener unifiedBannerADListener4 = this.f38105a;
                if (unifiedBannerADListener4 != null) {
                    unifiedBannerADListener4.onADExposure();
                    return;
                }
                return;
            case 104:
                if (this.f38107c == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("transId", str);
                this.f38107c.onReward(hashMap);
                return;
            case 105:
                UnifiedBannerADListener unifiedBannerADListener5 = this.f38105a;
                if (unifiedBannerADListener5 != null) {
                    unifiedBannerADListener5.onADClicked();
                    return;
                }
                return;
            case 106:
                UnifiedBannerADListener unifiedBannerADListener6 = this.f38105a;
                if (unifiedBannerADListener6 != null) {
                    unifiedBannerADListener6.onADClosed();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setAdRewardListener(ADRewardListener aDRewardListener) {
        this.f38107c = aDRewardListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f38106b = negativeFeedbackListener;
    }
}
