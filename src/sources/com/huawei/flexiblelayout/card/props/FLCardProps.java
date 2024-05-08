package com.huawei.flexiblelayout.card.props;

import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.u;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLCardProps {

    /* renamed from: d, reason: collision with root package name */
    private static final int f27881d = 120;

    /* renamed from: e, reason: collision with root package name */
    private static final int f27882e = 160;

    /* renamed from: f, reason: collision with root package name */
    private static final int f27883f = 213;

    /* renamed from: g, reason: collision with root package name */
    private static final int f27884g = 240;

    /* renamed from: h, reason: collision with root package name */
    private static final int f27885h = 320;

    /* renamed from: i, reason: collision with root package name */
    private static final int f27886i = 480;

    /* renamed from: j, reason: collision with root package name */
    private static final int f27887j = 640;

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, DirectionProps> f27888a = new TreeMap(Collections.reverseOrder());

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, DirectionProps> f27889b = new TreeMap(Collections.reverseOrder());

    /* renamed from: c, reason: collision with root package name */
    private CustomPropsGetter f27890c = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class CardNumbersPerLine {

        /* renamed from: a, reason: collision with root package name */
        private FLCardProps f27891a;

        public CardNumbersPerLine anyDpi(int i10, int i11, int i12) {
            this.f27891a.a(i10, i11, i12);
            return this;
        }

        public FLCardProps build() {
            return this.f27891a;
        }

        public CardNumbersPerLine custom(CustomPropsGetter customPropsGetter) {
            this.f27891a.f27890c = customPropsGetter;
            return this;
        }

        public CardNumbersPerLine hdpi(int i10, int i11) {
            this.f27891a.a(240, i10, i11);
            return this;
        }

        public CardNumbersPerLine ldpi(int i10, int i11) {
            this.f27891a.a(120, i10, i11);
            return this;
        }

        public CardNumbersPerLine mdpi(int i10, int i11) {
            this.f27891a.a(160, i10, i11);
            return this;
        }

        public CardNumbersPerLine tvdpi(int i10, int i11) {
            this.f27891a.a(213, i10, i11);
            return this;
        }

        public CardNumbersPerLine wDp(int i10, int i11) {
            this.f27891a.b(i10, i11);
            return this;
        }

        public CardNumbersPerLine xhdpi(int i10, int i11) {
            this.f27891a.a(320, i10, i11);
            return this;
        }

        public CardNumbersPerLine xxhdpi(int i10, int i11) {
            this.f27891a.a(480, i10, i11);
            return this;
        }

        public CardNumbersPerLine xxxhdpi(int i10, int i11) {
            this.f27891a.a(640, i10, i11);
            return this;
        }

        private CardNumbersPerLine() {
            this.f27891a = new FLCardProps();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i10, int i11) {
        this.f27889b.put(Integer.valueOf(i10), new DirectionProps(i11, i11));
    }

    public static CardNumbersPerLine numbersPerLine() {
        return new CardNumbersPerLine();
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<Integer, DirectionProps> entry : this.f27889b.entrySet()) {
            sb2.append((Object) entry.getKey());
            sb2.append(u.bD);
            sb2.append((Object) entry.getValue());
            sb2.append(";");
        }
        for (Map.Entry<Integer, DirectionProps> entry2 : this.f27888a.entrySet()) {
            sb2.append((Object) entry2.getKey());
            sb2.append(u.bD);
            sb2.append((Object) entry2.getValue());
            sb2.append(";");
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, int i11, int i12) {
        this.f27888a.put(Integer.valueOf(i10), new DirectionProps(i11, i12));
    }

    public DirectionProps a(int i10, int i11) {
        for (Map.Entry<Integer, DirectionProps> entry : this.f27889b.entrySet()) {
            if (i10 >= entry.getKey().intValue()) {
                return entry.getValue();
            }
        }
        for (Map.Entry<Integer, DirectionProps> entry2 : this.f27888a.entrySet()) {
            if (i11 >= entry2.getKey().intValue()) {
                return entry2.getValue();
            }
        }
        return null;
    }

    public CustomPropsGetter a() {
        return this.f27890c;
    }
}
