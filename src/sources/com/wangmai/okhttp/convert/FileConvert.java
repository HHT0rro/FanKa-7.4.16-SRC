package com.wangmai.okhttp.convert;

import android.os.Environment;
import android.text.TextUtils;
import com.wangmai.okhttp.callback.Callback;
import com.wangmai.okhttp.model.Progress;
import com.wangmai.okhttp.utils.HttpUtils;
import com.wangmai.okhttp.utils.IOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FileConvert implements Converter<File> {
    public static final String DM_TARGET_FOLDER;
    public Callback<File> callback;
    public String fileName;
    public String folder;

    static {
        StringBuilder sb2 = new StringBuilder();
        String str = File.separator;
        sb2.append(str);
        sb2.append("download");
        sb2.append(str);
        DM_TARGET_FOLDER = sb2.toString();
    }

    public FileConvert() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgress(final Progress progress) {
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.convert.FileConvert.2
            @Override // java.lang.Runnable
            public void run() {
                FileConvert.this.callback.downloadProgress(progress);
            }
        });
    }

    public void setCallback(Callback<File> callback) {
        this.callback = callback;
    }

    public FileConvert(String str) {
        this(((Object) Environment.getExternalStorageDirectory()) + DM_TARGET_FOLDER, str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.okhttp.convert.Converter
    public File convertResponse(Response response) throws Throwable {
        Throwable th;
        InputStream inputStream;
        String httpUrl = response.request().url().toString();
        if (TextUtils.isEmpty(this.folder)) {
            this.folder = ((Object) Environment.getExternalStorageDirectory()) + DM_TARGET_FOLDER;
        }
        if (TextUtils.isEmpty(this.fileName)) {
            this.fileName = HttpUtils.getNetFileName(response, httpUrl);
        }
        File file = new File(this.folder);
        IOUtils.createFolder(file);
        File file2 = new File(file, this.fileName);
        IOUtils.delFileOrFolder(file2);
        byte[] bArr = new byte[8192];
        FileOutputStream fileOutputStream = null;
        try {
            ResponseBody body = response.body();
            if (body == null) {
                IOUtils.closeQuietly(null);
                IOUtils.closeQuietly(null);
                return null;
            }
            inputStream = body.byteStream();
            try {
                Progress progress = new Progress();
                progress.totalSize = body.contentLength();
                progress.fileName = this.fileName;
                progress.filePath = file2.getAbsolutePath();
                progress.status = 2;
                progress.url = httpUrl;
                progress.tag = httpUrl;
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                            if (this.callback != null) {
                                Progress.changeProgress(progress, read, new Progress.Action() { // from class: com.wangmai.okhttp.convert.FileConvert.1
                                    @Override // com.wangmai.okhttp.model.Progress.Action
                                    public void call(Progress progress2) {
                                        FileConvert.this.onProgress(progress2);
                                    }
                                });
                            }
                        } else {
                            fileOutputStream2.flush();
                            IOUtils.closeQuietly(inputStream);
                            IOUtils.closeQuietly(fileOutputStream2);
                            return file2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    public FileConvert(String str, String str2) {
        this.folder = str;
        this.fileName = str2;
    }
}
