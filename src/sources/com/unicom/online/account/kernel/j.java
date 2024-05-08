package com.unicom.online.account.kernel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum j {
    E10104("-10104", "Unauthorized access."),
    E10108("-10108", "Bad file path."),
    E10109("-10109", "Not Found file."),
    E10200("-10200", "Failed to encrypt data using SM2 public key."),
    E10201("-10201", "Failed to decrypt data using SM2 private key."),
    E10202("-10202", "Failed to signature data using SM2 private key."),
    E10203("-10203", "Failed to verify data using SM2 public key."),
    E10204("-10204", "Failed to encrypt data using SM4 algorithm."),
    E10205("-10205", "Failed to decrypt data using SM4 algorithm."),
    E10400("-10400", "Illegal Argument: cannot be NULL."),
    E10403("-10403", "Illegal Argument: SM2 public key error, must be 65 bytes and in the format 04||X||Y."),
    E10405("-10405", "Illegal Argument: SM2 signature error, must be 64 bytes and in the format r||s."),
    E10406("-10406", "Illegal Argument: SM2 cipher text error, must be more than 96 bytes and in the format C1||C3||C2."),
    E10408("-10408", "Illegal Argument: The plaintext data length error, The data length must be a multiple of 16."),
    E10409("-10409", "Illegal Argument: The cipher text length error, The data length must be a multiple of 16."),
    E10410("-10410", "Illegal Argument: SM4 secret key error, must be 16 bytes."),
    E10411("-10411", "Illegal Argument: The size of IV error, must be 16 bytes."),
    E10415("-10415", "Illegal Argument: The size of msg too small."),
    E10416("-10416", "Illegal Argument: SM2 public key error."),
    E10417("-10417", "Illegal Argument: SM2 public key error, must be 65 bytes."),
    E10418("-10418", "Illegal Argument: SM2 private key error, must be 32 bytes."),
    E10419("-10419", "Illegal Argument: SM2 cipher text error, must be more than 97 bytes."),
    E10421("-10421", "Illegal Argument: Wrong public key."),
    E10424("-10424", "Illegal Argument: SM2 cipher text format error, must be start with 04."),
    E10501("-10501", "DER encoded data encoding or decoding error.");

    public final String A;

    /* renamed from: z, reason: collision with root package name */
    public final String f46067z;

    j(String str, String str2) {
        this.f46067z = str;
        this.A = str2;
    }
}
