package com.bytedance.android.openliveplugin.stub.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.bytedance.android.live.base.api.JavaCallsUtils;
import com.bytedance.pangle.plugin.PluginManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DouyinAuthorizeActivityProxy extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.auth.impl.auth.LiveAuthCallStub", "onAuthActivityBack", PluginManager.getInstance().getPlugin("com.byted.live.lite").mClassLoader, getIntent(), this);
        } catch (Throwable th) {
            th.printStackTrace();
            Toast.makeText(this, "抖音授权失败-界面启动失败", 1).show();
        }
    }
}
