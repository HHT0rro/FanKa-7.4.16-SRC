package com.bytedance.pangle.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.bytedance.pangle.plugin.Plugin;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IPluginActivity {
    void _requestPermissions(String[] strArr, int i10);

    void attachBaseContext(Context context);

    String getPluginPkgName();

    void onCreate(Bundle bundle);

    void setPluginProxyActivity(b bVar, Plugin plugin);

    void setProxyTheme2Plugin(int i10);
}
