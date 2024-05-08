package io.microshow.rxffmpeg;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class RxFFmpegProgress {
    public int progress;
    public long progressTime;
    public int state;

    public RxFFmpegProgress(int i10, int i11, long j10) {
        this.state = i10;
        this.progress = i11;
        this.progressTime = j10;
    }

    public RxFFmpegProgress(int i10) {
        this(i10, 0, 0L);
    }
}
