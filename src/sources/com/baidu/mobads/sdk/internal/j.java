package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.huawei.quickcard.base.Attributes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum j {
    NEWS("news", 0),
    IMAGE(Attributes.Component.IMAGE, 1),
    VIDEO("video", 2),
    TOPIC("topic", 3),
    AD("ad", 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);


    /* renamed from: j, reason: collision with root package name */
    public String f10270j;

    /* renamed from: k, reason: collision with root package name */
    public int f10271k;

    j(String str, int i10) {
        this.f10270j = str;
        this.f10271k = i10;
    }

    public String b() {
        return this.f10270j;
    }

    public int c() {
        return this.f10271k;
    }

    public static j b(String str) {
        for (j jVar : values()) {
            if (jVar != null && TextUtils.isEmpty(jVar.f10270j) && jVar.f10270j.equals(str)) {
                return jVar;
            }
        }
        return null;
    }
}
