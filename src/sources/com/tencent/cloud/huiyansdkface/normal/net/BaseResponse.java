package com.tencent.cloud.huiyansdkface.normal.net;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class BaseResponse<T extends Serializable> implements Serializable {
    public String bizSeqNo;
    public String code;
    public String csrfToken;
    public String ecifNo;
    public String msg;
    public T result;
    public ArrayList<RetList> retList;
    public String status;
    public String submitKey;
    public String transactionTime;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class RetList implements Serializable {
        public String retCode;
        public String retMessage;
    }
}
