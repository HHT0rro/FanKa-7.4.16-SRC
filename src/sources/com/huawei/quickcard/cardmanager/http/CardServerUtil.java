package com.huawei.quickcard.cardmanager.http;

import android.content.Context;
import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardServerUtil {

    /* renamed from: a, reason: collision with root package name */
    private static CardServer f33548a;

    public static String getPostUrl(Context context) {
        CardServer cardServer = f33548a;
        if (cardServer == null) {
            ManagerLogUtil.w("CardServerUtil does not set cardServer");
            return null;
        }
        return cardServer.getPostUrl(context);
    }

    public static boolean isNetworkAccess() {
        CardServer cardServer = f33548a;
        if (cardServer == null) {
            ManagerLogUtil.w("CardServerUtil does not set cardServer");
            return false;
        }
        return cardServer.isNetworkAccess();
    }

    public static void setCardServer(CardServer cardServer) {
        f33548a = cardServer;
    }
}
