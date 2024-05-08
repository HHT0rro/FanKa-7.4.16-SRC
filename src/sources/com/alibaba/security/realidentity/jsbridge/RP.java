package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.alibaba.security.realidentity.build.ax;
import com.alibaba.security.realidentity.build.ay;
import com.alibaba.security.realidentity.build.bd;
import com.alibaba.security.realidentity.build.bf;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RP extends WVApiPlugin {
    public boolean execute(String str, String str2, final WVCallBackContext wVCallBackContext) {
        return ax.a(this.mContext, str, str2, new ay() { // from class: com.alibaba.security.realidentity.jsbridge.RP.1
            @Override // com.alibaba.security.realidentity.build.ay
            public final void a(bf bfVar) {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.error(bd.a(bfVar));
                }
            }

            @Override // com.alibaba.security.realidentity.build.ay
            public final void b(bf bfVar) {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.success(bd.a(bfVar));
                }
            }

            @Override // com.alibaba.security.realidentity.build.ay
            public final void a(String str3) {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.error(str3);
                }
            }

            @Override // com.alibaba.security.realidentity.build.ay
            public final void b() {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.success();
                }
            }

            @Override // com.alibaba.security.realidentity.build.ay
            public final void a() {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.error();
                }
            }

            @Override // com.alibaba.security.realidentity.build.ay
            public final void b(String str3) {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.success(str3);
                }
            }

            @Override // com.alibaba.security.realidentity.build.ay
            public final void a(String str3, String str4) {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.fireEvent(str3, str4);
                }
            }
        });
    }
}
