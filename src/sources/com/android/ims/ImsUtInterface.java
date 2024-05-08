package com.android.ims;

import android.os.Handler;
import android.os.Message;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ImsUtInterface {
    public static final int ACTION_ACTIVATION = 1;
    public static final int ACTION_DEACTIVATION = 0;
    public static final int ACTION_ERASURE = 4;
    public static final int ACTION_INTERROGATION = 5;
    public static final int ACTION_REGISTRATION = 3;
    public static final int CB_BAIC = 1;
    public static final int CB_BAOC = 2;
    public static final int CB_BA_ALL = 7;
    public static final int CB_BA_MO = 8;
    public static final int CB_BA_MT = 9;
    public static final int CB_BIC_ACR = 6;
    public static final int CB_BIC_WR = 5;
    public static final int CB_BOIC = 3;
    public static final int CB_BOIC_EXHC = 4;
    public static final int CB_BS_MT = 10;
    public static final int CDIV_CF_ALL = 4;
    public static final int CDIV_CF_ALL_CONDITIONAL = 5;
    public static final int CDIV_CF_BUSY = 1;
    public static final int CDIV_CF_NOT_LOGGED_IN = 6;
    public static final int CDIV_CF_NOT_REACHABLE = 3;
    public static final int CDIV_CF_NO_REPLY = 2;
    public static final int CDIV_CF_UNCONDITIONAL = 0;
    public static final int INVALID = -1;
    public static final int OIR_DEFAULT = 0;
    public static final int OIR_PRESENTATION_NOT_RESTRICTED = 2;
    public static final int OIR_PRESENTATION_RESTRICTED = 1;

    void queryCLIP(Message message);

    void queryCLIR(Message message);

    void queryCOLP(Message message);

    void queryCOLR(Message message);

    void queryCallBarring(int i10, Message message);

    void queryCallBarring(int i10, Message message, int i11);

    void queryCallForward(int i10, String str, int i11, Message message);

    void queryCallForward(int i10, String str, Message message);

    void queryCallWaiting(Message message);

    void registerForSuppServiceIndication(Handler handler, int i10, Object obj);

    void unregisterForSuppServiceIndication(Handler handler);

    void updateCLIP(boolean z10, Message message);

    void updateCLIR(int i10, Message message);

    void updateCOLP(boolean z10, Message message);

    void updateCOLR(int i10, Message message);

    void updateCallBarring(int i10, int i11, Message message, String[] strArr);

    void updateCallBarring(int i10, int i11, Message message, String[] strArr, int i12);

    void updateCallBarring(int i10, int i11, Message message, String[] strArr, int i12, String str);

    void updateCallForward(int i10, int i11, String str, int i12, int i13, Message message);

    void updateCallWaiting(boolean z10, int i10, Message message);
}
