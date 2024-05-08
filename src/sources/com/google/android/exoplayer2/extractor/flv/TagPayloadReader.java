package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class TagPayloadReader {

    /* renamed from: a, reason: collision with root package name */
    public final TrackOutput f20048a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(TrackOutput trackOutput) {
        this.f20048a = trackOutput;
    }

    public final boolean a(ParsableByteArray parsableByteArray, long j10) throws ParserException {
        return b(parsableByteArray) && c(parsableByteArray, j10);
    }

    public abstract boolean b(ParsableByteArray parsableByteArray) throws ParserException;

    public abstract boolean c(ParsableByteArray parsableByteArray, long j10) throws ParserException;
}
