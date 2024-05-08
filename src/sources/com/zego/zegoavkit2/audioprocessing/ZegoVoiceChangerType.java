package com.zego.zegoavkit2.audioprocessing;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum ZegoVoiceChangerType {
    CHANGER_OFF(0),
    OPTIMUS_PRIME(1),
    AI_ROBOT(2),
    FOREIGNER(3),
    ELUSIVE(4),
    MALE_MAGNETIC(5),
    FEMALE_FRESH(6),
    MEN_TO_CHILD(7),
    MEN_TO_WOMEN(8),
    WOMEN_TO_CHILD(9),
    WOMEN_TO_MEN(10),
    FEMALE_ENERGETIC(11),
    RICHNESS(12),
    MUFFLED(13),
    ROUNDNESS(14),
    DICTIONARIES(15),
    FULLNESS(16),
    CLEAR(17),
    HIGHLY_RESONANT(18),
    LOUD_CLEAR(19),
    MINIONS(20),
    MAJOR_C(21),
    MINOR_A(22),
    HARMONIC_MINOR(23);

    private int mCode;

    ZegoVoiceChangerType(int i10) {
        this.mCode = i10;
    }

    public int getCode() {
        return this.mCode;
    }
}
