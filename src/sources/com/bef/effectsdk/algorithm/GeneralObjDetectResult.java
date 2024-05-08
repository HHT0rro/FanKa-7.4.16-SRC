package com.bef.effectsdk.algorithm;

import h0.a;

@a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GeneralObjDetectResult {
    public static final int DETECT_FAIL = -1;
    public static final int DETECT_SUCCESS = 0;
    private ObjectInfo[] obj_infos;
    private String obj_infos_data;
    private int obj_num;
    private int res = -1;

    public GeneralObjDetectResult() {
    }

    public void ObjectInfosData(String str) {
        this.obj_infos_data = str;
    }

    public ObjectInfo[] getObjectInfos() {
        return this.obj_infos;
    }

    public String getObjectInfosData() {
        return this.obj_infos_data;
    }

    public int getObjectNum() {
        return this.obj_num;
    }

    public int getResult() {
        return this.res;
    }

    public void logData() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("GeneralObjDetectResult res:");
        sb2.append(this.res);
        sb2.append(" obj_num:");
        sb2.append(this.obj_num);
        for (int i10 = 0; i10 < this.obj_num; i10++) {
            this.obj_infos[i10].a();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("GeneralObjDetectResult buffer:");
        sb3.append(this.obj_infos_data);
    }

    public void setObjectInfos(ObjectInfo[] objectInfoArr) {
        this.obj_infos = objectInfoArr;
    }

    public void setObjectNum(int i10) {
        this.obj_num = i10;
    }

    public void setResult(int i10) {
        this.res = i10;
    }

    public GeneralObjDetectResult(int i10, ObjectInfo[] objectInfoArr) {
        this.obj_num = i10;
        this.obj_infos = objectInfoArr;
    }

    public GeneralObjDetectResult(int i10, ObjectInfo[] objectInfoArr, String str) {
        this.obj_num = i10;
        this.obj_infos = objectInfoArr;
        this.obj_infos_data = str;
    }
}
