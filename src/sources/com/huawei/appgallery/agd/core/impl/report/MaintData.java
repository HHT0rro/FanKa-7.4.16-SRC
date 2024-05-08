package com.huawei.appgallery.agd.core.impl.report;

import android.text.TextUtils;
import java.util.LinkedHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MaintData {

    /* renamed from: a, reason: collision with root package name */
    private String f27432a;

    /* renamed from: b, reason: collision with root package name */
    private String f27433b;

    /* renamed from: c, reason: collision with root package name */
    private String f27434c;

    /* renamed from: d, reason: collision with root package name */
    private String f27435d;

    /* renamed from: e, reason: collision with root package name */
    private String f27436e;

    /* renamed from: f, reason: collision with root package name */
    private String f27437f;

    /* renamed from: g, reason: collision with root package name */
    private String f27438g;

    /* renamed from: h, reason: collision with root package name */
    private String f27439h;

    /* renamed from: i, reason: collision with root package name */
    private String f27440i;

    /* renamed from: j, reason: collision with root package name */
    private String f27441j;

    /* renamed from: k, reason: collision with root package name */
    private String f27442k;

    /* renamed from: l, reason: collision with root package name */
    private String f27443l;

    /* renamed from: m, reason: collision with root package name */
    private String f27444m;

    /* renamed from: n, reason: collision with root package name */
    private String f27445n;

    /* renamed from: o, reason: collision with root package name */
    private String f27446o;

    /* renamed from: p, reason: collision with root package name */
    private String f27447p;

    /* renamed from: q, reason: collision with root package name */
    private String f27448q;

    /* renamed from: r, reason: collision with root package name */
    private String f27449r;

    /* renamed from: s, reason: collision with root package name */
    private String f27450s;

    /* renamed from: t, reason: collision with root package name */
    private String f27451t;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public MaintData f27452a;

        public Builder(String str) {
            MaintData maintData = new MaintData();
            this.f27452a = maintData;
            maintData.f27432a = str;
        }

        public MaintData build() {
            return this.f27452a;
        }

        public Builder setAdId(String str) {
            this.f27452a.f27449r = str;
            return this;
        }

        public Builder setAgdCode(long j10) {
            this.f27452a.f27445n = String.valueOf(j10);
            return this;
        }

        public Builder setCountry(String str) {
            this.f27452a.f27442k = str;
            return this;
        }

        public Builder setErrorCode(long j10) {
            this.f27452a.f27434c = String.valueOf(j10);
            return this;
        }

        public Builder setEventType(String str) {
            this.f27452a.f27451t = str;
            return this;
        }

        public Builder setInstallType(String str) {
            this.f27452a.f27450s = str;
            return this;
        }

        public Builder setLayoutName(String str) {
            this.f27452a.f27444m = str;
            return this;
        }

        public Builder setMsg(String str) {
            this.f27452a.f27438g = str;
            return this;
        }

        public Builder setReason(String str) {
            this.f27452a.f27435d = str;
            return this;
        }

        public Builder setRequestId(String str) {
            this.f27452a.f27446o = str;
            return this;
        }

        public Builder setResponseCode(long j10) {
            this.f27452a.f27433b = String.valueOf(j10);
            return this;
        }

        public Builder setSlotId(String str) {
            this.f27452a.f27439h = str;
            return this;
        }

        public Builder setSource(String str) {
            this.f27452a.f27448q = str;
            return this;
        }

        public Builder setStatus(String str) {
            this.f27452a.f27441j = str;
            return this;
        }

        public Builder setTaskPackageName(String str) {
            this.f27452a.f27443l = str;
            return this;
        }

        public Builder setTotalTime(long j10) {
            this.f27452a.f27436e = String.valueOf(j10);
            return this;
        }

        public Builder setType(long j10) {
            this.f27452a.f27440i = String.valueOf(j10);
            return this;
        }

        public Builder setUniqueId(String str) {
            this.f27452a.f27447p = str;
            return this;
        }

        public Builder setUri(String str) {
            this.f27452a.f27437f = str;
            return this;
        }
    }

    public String getEventId() {
        return this.f27432a;
    }

    public LinkedHashMap<String, String> getLinkedHashMap() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (!TextUtils.isEmpty(this.f27432a)) {
            linkedHashMap.put("eventId", this.f27432a);
        }
        if (!TextUtils.isEmpty(this.f27434c)) {
            linkedHashMap.put("errorCode", this.f27434c);
        }
        if (!TextUtils.isEmpty(this.f27435d)) {
            linkedHashMap.put("reason", this.f27435d);
        }
        if (!TextUtils.isEmpty(this.f27436e)) {
            linkedHashMap.put(MaintKey.TOTAL_TIME, this.f27436e);
        }
        if (!TextUtils.isEmpty(this.f27437f)) {
            linkedHashMap.put("uri", this.f27437f);
        }
        if (!TextUtils.isEmpty(this.f27438g)) {
            linkedHashMap.put("msg", this.f27438g);
        }
        if (!TextUtils.isEmpty(this.f27439h)) {
            linkedHashMap.put("slotId", this.f27439h);
        }
        if (TextUtils.isEmpty(this.f27440i)) {
            this.f27440i = String.valueOf(0);
        }
        linkedHashMap.put("type", this.f27440i);
        if (!TextUtils.isEmpty(this.f27441j)) {
            linkedHashMap.put("status", this.f27441j);
        }
        if (!TextUtils.isEmpty(this.f27442k)) {
            linkedHashMap.put("country", this.f27442k);
        }
        if (!TextUtils.isEmpty(this.f27443l)) {
            linkedHashMap.put(MaintKey.TASK_PACKAGE_NAME, this.f27443l);
        }
        if (!TextUtils.isEmpty(this.f27444m)) {
            linkedHashMap.put("layoutName", this.f27444m);
        }
        if (!TextUtils.isEmpty(this.f27445n)) {
            linkedHashMap.put(MaintKey.AGD_CODE, this.f27445n);
        }
        if (!TextUtils.isEmpty(this.f27446o)) {
            linkedHashMap.put("requestId", this.f27446o);
        }
        if (!TextUtils.isEmpty(this.f27447p)) {
            linkedHashMap.put("uniqueId", this.f27447p);
        }
        if (!TextUtils.isEmpty(this.f27448q)) {
            linkedHashMap.put("source", this.f27448q);
        }
        if (!TextUtils.isEmpty(this.f27433b)) {
            linkedHashMap.put(MaintKey.RESPONSE_CODE, this.f27433b);
        }
        if (!TextUtils.isEmpty(this.f27449r)) {
            linkedHashMap.put("adId", this.f27449r);
        }
        if (!TextUtils.isEmpty(this.f27450s)) {
            linkedHashMap.put("installType", this.f27450s);
        }
        if (!TextUtils.isEmpty(this.f27451t)) {
            linkedHashMap.put(MaintKey.EVENT_TYPE, this.f27451t);
        }
        return linkedHashMap;
    }

    private MaintData() {
        this.f27432a = "";
        this.f27433b = "";
        this.f27434c = "";
        this.f27435d = "";
        this.f27436e = "";
        this.f27437f = "";
        this.f27438g = "";
        this.f27439h = "";
        this.f27440i = "";
        this.f27441j = "";
        this.f27442k = "";
        this.f27443l = "";
        this.f27444m = "";
        this.f27445n = "";
        this.f27446o = "";
        this.f27447p = "";
        this.f27448q = "";
        this.f27449r = "";
        this.f27450s = "";
        this.f27451t = "";
    }
}
