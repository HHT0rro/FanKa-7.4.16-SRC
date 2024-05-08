package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SegmentOutput implements IOutput {
    private final RandomAccessOutputStream output;
    private final Segment segment;
    private final IOutput stub;

    public SegmentOutput(DownloadInfo downloadInfo, BufferQueue bufferQueue, Segment segment) throws BaseException {
        this.segment = segment;
        this.output = createOutStream(downloadInfo, segment);
        this.stub = new OutputStub(bufferQueue, this);
    }

    private RandomAccessOutputStream createOutStream(DownloadInfo downloadInfo, Segment segment) throws BaseException {
        RandomAccessOutputStream createOutputStream = DownloadUtils.createOutputStream(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.FLUSH_BUFFER_SIZE_BYTE, -1));
        try {
            createOutputStream.seek(segment.getCurrentOffsetRead());
            return createOutputStream;
        } catch (IOException e2) {
            throw new BaseException(1054, e2);
        }
    }

    public void close() {
        DownloadUtils.safeClose(this.output);
    }

    public void flush() throws IOException {
        this.output.flush();
    }

    public Segment getSegment() {
        return this.segment;
    }

    public IOutput getStub() {
        return this.stub;
    }

    public void sync() throws IOException {
        this.output.sync();
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(@NonNull Buffer buffer) throws IOException {
        this.output.write(buffer.data, 0, buffer.size);
        this.segment.increaseCurrentOffset(buffer.size);
    }
}
