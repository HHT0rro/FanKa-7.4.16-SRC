package com.huawei.appgallery.agd.core.api;

import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AdSlot {

    /* renamed from: a, reason: collision with root package name */
    public String f27381a;

    /* renamed from: d, reason: collision with root package name */
    public int f27384d;

    /* renamed from: e, reason: collision with root package name */
    public JSONObject f27385e;

    /* renamed from: f, reason: collision with root package name */
    public String f27386f;

    /* renamed from: g, reason: collision with root package name */
    public String f27387g;

    /* renamed from: b, reason: collision with root package name */
    public int f27382b = 2;

    /* renamed from: c, reason: collision with root package name */
    public int f27383c = 2;

    /* renamed from: h, reason: collision with root package name */
    public int f27388h = 1;

    /* renamed from: i, reason: collision with root package name */
    public int f27389i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f27390j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f27391k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f27392l = 0;

    /* renamed from: m, reason: collision with root package name */
    public Boolean f27393m = Boolean.FALSE;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public AdSlot f27394a = new AdSlot();

        public Builder acceptedSize(int i10, int i11) {
            this.f27394a.f27391k = i10;
            this.f27394a.f27392l = i11;
            return this;
        }

        public Builder adCount(int i10) {
            this.f27394a.f27388h = Math.min(Math.max(i10, 1), 3);
            return this;
        }

        public AdSlot build() {
            return this.f27394a;
        }

        public Builder channelId(String str) {
            this.f27394a.f27386f = str;
            return this;
        }

        public Builder darkMode(int i10) {
            if ((i10 != 1 && i10 != 0) || Build.VERSION.SDK_INT < 29) {
                i10 = -1;
            }
            this.f27394a.f27390j = i10;
            return this;
        }

        public Builder disableSdkCountDown(Boolean bool) {
            this.f27394a.f27393m = bool;
            return this;
        }

        public Builder mediaExtra(JSONObject jSONObject) {
            this.f27394a.f27385e = jSONObject;
            return this;
        }

        public Builder orientation(int i10) {
            if (i10 != 1) {
                i10 = 2;
            }
            this.f27394a.f27382b = i10;
            return this;
        }

        public Builder referrer(String str) {
            this.f27394a.f27387g = str;
            return this;
        }

        public Builder rotationTime(int i10) {
            int min = Math.min(120, i10);
            if (min != 0) {
                min = Math.max(30, min);
            }
            this.f27394a.f27389i = min;
            return this;
        }

        public Builder slotId(String str) {
            this.f27394a.f27381a = str;
            return this;
        }

        public Builder soundStatus(int i10) {
            this.f27394a.f27383c = i10;
            return this;
        }

        public Builder ver(int i10) {
            this.f27394a.f27384d = i10;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public @interface OrientationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public @interface SoundStatus {
    }

    public int getAcceptedSizeHeight() {
        return this.f27392l;
    }

    public int getAcceptedSizeWidth() {
        return this.f27391k;
    }

    public int getAdCount() {
        return this.f27388h;
    }

    public String getChannelId() {
        return this.f27386f;
    }

    public int getDarkMode() {
        return this.f27390j;
    }

    public Boolean getDisableSdkCountDown() {
        return this.f27393m;
    }

    public JSONObject getMediaExtra() {
        return this.f27385e;
    }

    public int getOrientation() {
        return this.f27382b;
    }

    public String getReferrer() {
        return this.f27387g;
    }

    public int getRotationTime() {
        return this.f27389i;
    }

    public String getSlotId() {
        return this.f27381a;
    }

    public int getSoundStatus() {
        return this.f27383c;
    }

    public int getVer() {
        return this.f27384d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdSlot{slotId = ");
        sb2.append(this.f27381a);
        sb2.append(", orientation = ");
        sb2.append(this.f27382b == 1 ? "HORIZONTAL" : "VERTICAL");
        sb2.append(", adCount= ");
        sb2.append(this.f27388h);
        sb2.append(", channelId= ");
        sb2.append(this.f27386f);
        sb2.append(", referrer= ");
        sb2.append(this.f27387g);
        sb2.append(", rotationTime = ");
        sb2.append(this.f27389i);
        sb2.append(", darkMode = ");
        sb2.append(this.f27390j);
        sb2.append(", acceptedSizeWidth = ");
        sb2.append(this.f27391k);
        sb2.append(", acceptedSizeHeight = ");
        sb2.append(this.f27392l);
        sb2.append("disableSdkCountDown = ");
        sb2.append((Object) this.f27393m);
        sb2.append('}');
        return sb2.toString();
    }
}
