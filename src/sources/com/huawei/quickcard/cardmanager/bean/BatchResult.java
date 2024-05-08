package com.huawei.quickcard.cardmanager.bean;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BatchResult {

    /* renamed from: a, reason: collision with root package name */
    private CardInfo[] f33497a;

    /* renamed from: b, reason: collision with root package name */
    private String[] f33498b;

    /* renamed from: c, reason: collision with root package name */
    private int f33499c = -1;

    /* renamed from: d, reason: collision with root package name */
    private String f33500d;

    /* renamed from: e, reason: collision with root package name */
    private int f33501e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class CardInfo {

        /* renamed from: a, reason: collision with root package name */
        private String f33502a;

        /* renamed from: b, reason: collision with root package name */
        private String f33503b;

        /* renamed from: c, reason: collision with root package name */
        private String f33504c;

        public String getContent() {
            return this.f33504c;
        }

        public String getType() {
            return this.f33503b;
        }

        public String getUri() {
            return this.f33502a;
        }

        public void setContent(String str) {
            this.f33504c = str;
        }

        public void setType(String str) {
            this.f33503b = str;
        }

        public void setUri(String str) {
            this.f33502a = str;
        }
    }

    public int getCode() {
        return this.f33499c;
    }

    public String getErrMsg() {
        return this.f33500d;
    }

    public String[] getFailedUris() {
        String[] strArr = this.f33498b;
        return strArr == null ? new String[0] : (String[]) strArr.clone();
    }

    public CardInfo[] getInfo() {
        CardInfo[] cardInfoArr = this.f33497a;
        return cardInfoArr == null ? new CardInfo[0] : (CardInfo[]) cardInfoArr.clone();
    }

    public int getNextIndex() {
        return this.f33501e;
    }

    public void setCode(int i10) {
        this.f33499c = i10;
    }

    public void setErrMsg(String str) {
        this.f33500d = str;
    }

    public void setFailedUris(@NonNull String[] strArr) {
        this.f33498b = (String[]) strArr.clone();
    }

    public void setInfo(@NonNull CardInfo[] cardInfoArr) {
        this.f33497a = (CardInfo[]) cardInfoArr.clone();
    }

    public void setNextIndex(int i10) {
        this.f33501e = i10;
    }
}
