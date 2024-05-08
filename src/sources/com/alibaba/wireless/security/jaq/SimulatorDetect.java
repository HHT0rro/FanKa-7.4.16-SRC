package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.simulatordetect.ISimulatorDetectComponent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SimulatorDetect {
    private Context context;

    public SimulatorDetect(Context context) {
        if (context != null) {
            this.context = context.getApplicationContext();
        }
    }

    public boolean isSimulator() throws JAQException {
        try {
            ISimulatorDetectComponent simulatorDetectComp = SecurityGuardManager.getInstance(this.context).getSimulatorDetectComp();
            if (simulatorDetectComp != null) {
                return simulatorDetectComp.isSimulator();
            }
            throw new SecException(1598);
        } catch (SecException e2) {
            throw new JAQException(e2.getErrorCode());
        }
    }
}
