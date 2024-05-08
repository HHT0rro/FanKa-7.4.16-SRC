package com.huawei.hmf.orb.tbis;

import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.orb.tbis.type.IntentRef;
import com.huawei.hmf.services.ui.Launcher;
import com.huawei.hmf.services.ui.UIModule;
import com.huawei.hmf.services.ui.activity.ActivityCallback;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TBUIModule {
    private static final String TAG = "TBUIModule";
    private Intent mFillInIntent;
    private final UIModule mUiModule;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Callback {
        void onResult(String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Callback2 {
        void onResult(Object obj);
    }

    public TBUIModule(UIModule uIModule) {
        this.mUiModule = uIModule;
    }

    private static void copy(Object obj, Object obj2) {
        for (Method method : obj2.getClass().getMethods()) {
            try {
                if (method.getName().startsWith("set")) {
                    method.invoke(obj2, obj.getClass().getMethod(MonitorConstants.CONNECT_TYPE_GET + method.getName().substring(3), new Class[0]).invoke(obj, new Object[0]));
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void onActivityResult(int i10, int i11, Intent intent) {
    }

    public Intent createFillInIntent() {
        Intent intent = new Intent();
        this.mFillInIntent = intent;
        return intent;
    }

    public <T> T createProtocol() {
        return (T) this.mUiModule.createProtocol();
    }

    public void startActivity(Context context, String str, final Callback callback) {
        TextCodec create = TextCodecFactory.create(str);
        Object object = create.getObject("protocol", this.mUiModule.getUIModuleSpec().getProtocol());
        IntentRef intentRef = (IntentRef) create.getObject("intent", IntentRef.class);
        Intent unboxing2 = intentRef != null ? intentRef.unboxing2() : null;
        copy(object, this.mUiModule.createProtocol());
        if (callback == null) {
            Launcher.getLauncher().startActivity(context, this.mUiModule, unboxing2);
        } else {
            Launcher.getLauncher().startActivity(context, this.mUiModule, unboxing2, new ActivityCallback() { // from class: com.huawei.hmf.orb.tbis.TBUIModule.1
                @Override // com.huawei.hmf.services.ui.activity.ActivityCallback
                public void onResult(int i10, Object obj) {
                    TextCodec create2 = TextCodecFactory.create();
                    create2.put("code", Integer.valueOf(i10));
                    create2.put("result", obj);
                    callback.onResult(create2.toString());
                }
            });
        }
    }

    public void startActivity(Context context, final Callback2 callback2) {
        if (callback2 == null) {
            Launcher.getLauncher().startActivity(context, this.mUiModule, this.mFillInIntent);
        } else {
            Launcher.getLauncher().startActivity(context, this.mUiModule, this.mFillInIntent, new ActivityCallback() { // from class: com.huawei.hmf.orb.tbis.TBUIModule.2
                @Override // com.huawei.hmf.services.ui.activity.ActivityCallback
                public void onResult(int i10, Object obj) {
                    callback2.onResult(new Object[]{Integer.valueOf(i10), obj});
                }
            });
        }
    }
}
