package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class OutputStub implements IOutput {
    private final IOutput output;
    private final IOutput target;

    public OutputStub(IOutput iOutput, IOutput iOutput2) {
        this.output = iOutput;
        this.target = iOutput2;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(@NonNull Buffer buffer) throws IOException {
        buffer.output = this.target;
        this.output.write(buffer);
    }
}
