package com.bytedance.sdk.openadsdk.mediation;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationTTLiveTokenInjectionAuthImpl implements Bridge, ITTLiveTokenInjectionAuth {

    /* renamed from: m, reason: collision with root package name */
    private ITTLiveTokenInjectionAuth f11240m;

    public MediationTTLiveTokenInjectionAuthImpl(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f11240m = iTTLiveTokenInjectionAuth;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        ValueSet valueSet2;
        if (i10 == 8518) {
            return (T) Boolean.valueOf(isLogin());
        }
        if (i10 != 8519) {
            if (i10 != 8525 || (valueSet2 = (ValueSet) valueSet.objectValue(8526, ValueSet.class)) == null) {
                return null;
            }
            onTokenInvalid(new TTLiveToken(valueSet2.stringValue(8520), valueSet2.stringValue(8521), valueSet2.stringValue(8522), valueSet2.longValue(8523), valueSet2.stringValue(8524)), new MediationTTLiveAuthCallBackImpl((Bridge) valueSet2.objectValue(8319, Bridge.class)), (Activity) valueSet2.objectValue(20033, Activity.class), (Map) valueSet2.objectValue(8075, Map.class));
            return null;
        }
        TTLiveToken tokenInfo = getTokenInfo();
        if (tokenInfo == null) {
            return null;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8520, tokenInfo.name);
        create.add(8521, tokenInfo.accessToken);
        create.add(8522, tokenInfo.openId);
        create.add(8523, tokenInfo.expireAt);
        create.add(8524, tokenInfo.refreshToken);
        return (T) create.build();
    }

    @Override // com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth
    public TTLiveToken getTokenInfo() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f11240m;
        if (iTTLiveTokenInjectionAuth != null) {
            return iTTLiveTokenInjectionAuth.getTokenInfo();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth
    public boolean isLogin() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f11240m;
        if (iTTLiveTokenInjectionAuth != null) {
            return iTTLiveTokenInjectionAuth.isLogin();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth
    public void onTokenInvalid(TTLiveToken tTLiveToken, TTLiveAuthCallback tTLiveAuthCallback, Activity activity, Map<String, String> map) {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f11240m;
        if (iTTLiveTokenInjectionAuth != null) {
            iTTLiveTokenInjectionAuth.onTokenInvalid(tTLiveToken, tTLiveAuthCallback, activity, map);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
