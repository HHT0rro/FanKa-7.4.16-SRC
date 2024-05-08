package com.cupidapp.live.mediapicker.model;

/* compiled from: PublishViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum UploadState {
    Success(0),
    Uploading(2),
    Error(1);

    private final int value;

    UploadState(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
