package com.android.internal.org.bouncycastle.crypto.params;

import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DSAParameterGenerationParameters {
    public static final int DIGITAL_SIGNATURE_USAGE = 1;
    public static final int KEY_ESTABLISHMENT_USAGE = 2;
    private final int certainty;

    /* renamed from: l, reason: collision with root package name */
    private final int f9218l;

    /* renamed from: n, reason: collision with root package name */
    private final int f9219n;
    private final SecureRandom random;
    private final int usageIndex;

    public DSAParameterGenerationParameters(int L, int N, int certainty, SecureRandom random) {
        this(L, N, certainty, random, -1);
    }

    public DSAParameterGenerationParameters(int L, int N, int certainty, SecureRandom random, int usageIndex) {
        this.f9218l = L;
        this.f9219n = N;
        this.certainty = certainty;
        this.usageIndex = usageIndex;
        this.random = random;
    }

    public int getL() {
        return this.f9218l;
    }

    public int getN() {
        return this.f9219n;
    }

    public int getCertainty() {
        return this.certainty;
    }

    public SecureRandom getRandom() {
        return this.random;
    }

    public int getUsageIndex() {
        return this.usageIndex;
    }
}
