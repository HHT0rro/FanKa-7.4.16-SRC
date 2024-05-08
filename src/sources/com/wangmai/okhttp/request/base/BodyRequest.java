package com.wangmai.okhttp.request.base;

import android.text.TextUtils;
import com.wangmai.okhttp.model.HttpParams;
import com.wangmai.okhttp.request.base.BodyRequest;
import com.wangmai.okhttp.utils.HttpUtils;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class BodyRequest<T, R extends BodyRequest> extends Request<T, R> implements HasBody<R> {
    public static final String TAG = "WM_BodyRequest";
    public static final long serialVersionUID = -6459175248476927501L;
    public byte[] bs;
    public String content;
    public transient File file;
    public boolean isMultipart;
    public boolean isSpliceUrl;
    public transient MediaType mediaType;
    public RequestBody requestBody;

    public BodyRequest(String str) {
        super(str);
        this.isMultipart = false;
        this.isSpliceUrl = false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mediaType = MediaType.parse(str);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        MediaType mediaType = this.mediaType;
        objectOutputStream.writeObject(mediaType == null ? "" : mediaType.toString());
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public /* bridge */ /* synthetic */ Object addFileParams(String str, List list) {
        return addFileParams(str, (List<File>) list);
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public /* bridge */ /* synthetic */ Object addFileWrapperParams(String str, List list) {
        return addFileWrapperParams(str, (List<HttpParams.FileWrapper>) list);
    }

    @Override // com.wangmai.okhttp.request.base.Request
    public RequestBody generateRequestBody() {
        MediaType mediaType;
        MediaType mediaType2;
        MediaType mediaType3;
        if (this.isSpliceUrl) {
            this.url = HttpUtils.createUrlFromParams(this.baseUrl, this.params.urlParamsMap);
        }
        RequestBody requestBody = this.requestBody;
        if (requestBody != null) {
            return requestBody;
        }
        String str = this.content;
        if (str != null && (mediaType3 = this.mediaType) != null) {
            return RequestBody.create(mediaType3, str);
        }
        byte[] bArr = this.bs;
        if (bArr != null && (mediaType2 = this.mediaType) != null) {
            return RequestBody.create(mediaType2, bArr);
        }
        File file = this.file;
        return (file == null || (mediaType = this.mediaType) == null) ? HttpUtils.generateMultipartRequestBody(this.params, this.isMultipart) : RequestBody.create(mediaType, file);
    }

    public Request.Builder generateRequestBuilder(RequestBody requestBody) {
        try {
            headers("Content-Length", String.valueOf(requestBody.contentLength()));
        } catch (IOException unused) {
        }
        return HttpUtils.appendHeaders(new Request.Builder(), this.headers);
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R addFileParams(String str, List<File> list) {
        this.params.putFileParams(str, list);
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R addFileWrapperParams(String str, List<HttpParams.FileWrapper> list) {
        this.params.putFileWrapperParams(str, list);
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R isMultipart(boolean z10) {
        this.isMultipart = z10;
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R isSpliceUrl(boolean z10) {
        this.isSpliceUrl = z10;
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R upRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R upBytes(byte[] bArr) {
        this.bs = bArr;
        this.mediaType = HttpParams.MEDIA_TYPE_STREAM;
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R upFile(File file) {
        this.file = file;
        this.mediaType = HttpUtils.guessMimeType(file.getName());
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R upString(String str) {
        this.content = str;
        this.mediaType = HttpParams.MEDIA_TYPE_PLAIN;
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R params(String str, File file) {
        this.params.put(str, file);
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R upJson(String str) {
        this.content = str;
        this.mediaType = HttpParams.MEDIA_TYPE_JSON;
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R params(String str, File file, String str2) {
        this.params.put(str, file, str2);
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R upBytes(byte[] bArr, MediaType mediaType) {
        this.bs = bArr;
        this.mediaType = mediaType;
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R upFile(File file, MediaType mediaType) {
        this.file = file;
        this.mediaType = mediaType;
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R upString(String str, MediaType mediaType) {
        this.content = str;
        this.mediaType = mediaType;
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R params(String str, File file, String str2, MediaType mediaType) {
        this.params.put(str, file, str2, mediaType);
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R upJson(JSONObject jSONObject) {
        this.content = jSONObject.toString();
        this.mediaType = HttpParams.MEDIA_TYPE_JSON;
        return this;
    }

    @Override // com.wangmai.okhttp.request.base.HasBody
    public R upJson(JSONArray jSONArray) {
        this.content = jSONArray.toString();
        this.mediaType = HttpParams.MEDIA_TYPE_JSON;
        return this;
    }
}
