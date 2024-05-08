package com.wangmai.okhttp.model;

import com.alipay.sdk.util.i;
import com.wangmai.okhttp.utils.HttpUtils;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HttpParams implements Serializable {
    public static final boolean IS_REPLACE = true;
    public static final long serialVersionUID = 7369819159227055048L;
    public LinkedHashMap<String, List<FileWrapper>> fileParamsMap;
    public LinkedHashMap<String, List<String>> urlParamsMap;
    public static final MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain;charset=utf-8");
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");
    public static final MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class FileWrapper implements Serializable {
        public static final long serialVersionUID = -2356139899636767776L;
        public transient MediaType contentType;
        public File file;
        public String fileName;
        public long fileSize;

        public FileWrapper(File file, String str, MediaType mediaType) {
            this.file = file;
            this.fileName = str;
            this.contentType = mediaType;
            this.fileSize = file.length();
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.contentType = MediaType.parse((String) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.contentType.toString());
        }

        public String toString() {
            return "FileWrapper{file=" + ((Object) this.file) + ", fileName=" + this.fileName + ", contentType=" + ((Object) this.contentType) + ", fileSize=" + this.fileSize + i.f4738d;
        }
    }

    public HttpParams() {
        init();
    }

    private void init() {
        this.urlParamsMap = new LinkedHashMap<>();
        this.fileParamsMap = new LinkedHashMap<>();
    }

    public void clear() {
        this.urlParamsMap.clear();
        this.fileParamsMap.clear();
    }

    public void put(HttpParams httpParams) {
        if (httpParams != null) {
            LinkedHashMap<String, List<String>> linkedHashMap = httpParams.urlParamsMap;
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                this.urlParamsMap.putAll(httpParams.urlParamsMap);
            }
            LinkedHashMap<String, List<FileWrapper>> linkedHashMap2 = httpParams.fileParamsMap;
            if (linkedHashMap2 == null || linkedHashMap2.isEmpty()) {
                return;
            }
            this.fileParamsMap.putAll(httpParams.fileParamsMap);
        }
    }

    public void putFileParams(String str, List<File> list) {
        if (str == null || list == null || list.isEmpty()) {
            return;
        }
        Iterator<File> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            put(str, iterator2.next());
        }
    }

    public void putFileWrapperParams(String str, List<FileWrapper> list) {
        if (str == null || list == null || list.isEmpty()) {
            return;
        }
        Iterator<FileWrapper> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            put(str, iterator2.next());
        }
    }

    public void putUrlParams(String str, List<String> list) {
        if (str == null || list == null || list.isEmpty()) {
            return;
        }
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            put(str, iterator2.next(), false);
        }
    }

    public void remove(String str) {
        removeUrl(str);
        removeFile(str);
    }

    public void removeFile(String str) {
        this.fileParamsMap.remove(str);
    }

    public void removeUrl(String str) {
        this.urlParamsMap.remove(str);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : this.urlParamsMap.entrySet()) {
            if (sb2.length() > 0) {
                sb2.append("&");
            }
            sb2.append(entry.getKey());
            sb2.append("=");
            sb2.append((Object) entry.getValue());
        }
        for (Map.Entry<String, List<FileWrapper>> entry2 : this.fileParamsMap.entrySet()) {
            if (sb2.length() > 0) {
                sb2.append("&");
            }
            sb2.append(entry2.getKey());
            sb2.append("=");
            sb2.append((Object) entry2.getValue());
        }
        return sb2.toString();
    }

    public HttpParams(String str, String str2) {
        init();
        put(str, str2, true);
    }

    public void put(Map<String, String> map, boolean... zArr) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue(), zArr);
        }
    }

    public HttpParams(String str, File file) {
        init();
        put(str, file);
    }

    public void put(String str, String str2, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            put(str, str2, zArr[0]);
        } else {
            put(str, str2, true);
        }
    }

    public void put(String str, int i10, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            put(str, String.valueOf(i10), zArr[0]);
        } else {
            put(str, String.valueOf(i10), true);
        }
    }

    public void put(String str, long j10, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            put(str, String.valueOf(j10), zArr[0]);
        } else {
            put(str, String.valueOf(j10), true);
        }
    }

    public void put(String str, float f10, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            put(str, String.valueOf(f10), zArr[0]);
        } else {
            put(str, String.valueOf(f10), true);
        }
    }

    public void put(String str, double d10, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            put(str, String.valueOf(d10), zArr[0]);
        } else {
            put(str, String.valueOf(d10), true);
        }
    }

    public void put(String str, char c4, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            put(str, String.valueOf(c4), zArr[0]);
        } else {
            put(str, String.valueOf(c4), true);
        }
    }

    public void put(String str, boolean z10, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            put(str, String.valueOf(z10), zArr[0]);
        } else {
            put(str, String.valueOf(z10), true);
        }
    }

    private void put(String str, String str2, boolean z10) {
        if (str == null || str2 == null) {
            return;
        }
        List<String> list = this.urlParamsMap.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.urlParamsMap.put(str, list);
        }
        if (z10) {
            list.clear();
        }
        list.add(str2);
    }

    public void put(String str, File file) {
        put(str, file, file.getName());
    }

    public void put(String str, File file, String str2) {
        put(str, file, str2, HttpUtils.guessMimeType(str2));
    }

    public void put(String str, FileWrapper fileWrapper) {
        if (str == null || fileWrapper == null) {
            return;
        }
        put(str, fileWrapper.file, fileWrapper.fileName, fileWrapper.contentType);
    }

    public void put(String str, File file, String str2, MediaType mediaType) {
        if (str != null) {
            List<FileWrapper> list = this.fileParamsMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.fileParamsMap.put(str, list);
            }
            list.add(new FileWrapper(file, str2, mediaType));
        }
    }
}
