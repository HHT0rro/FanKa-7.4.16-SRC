package com.alibaba.fastjson;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class JSONStreamContext {
    public static final int ArrayValue = 1005;
    public static final int PropertyKey = 1002;
    public static final int PropertyValue = 1003;
    public static final int StartArray = 1004;
    public static final int StartObject = 1001;
    public final JSONStreamContext parent;
    public int state;

    public JSONStreamContext(JSONStreamContext jSONStreamContext, int i10) {
        this.parent = jSONStreamContext;
        this.state = i10;
    }
}
