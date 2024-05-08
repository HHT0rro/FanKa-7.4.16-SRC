package com.huawei.qcardsupport.qcard.cardmanager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flrequest.api.FLCardUrisLoader;
import com.huawei.flrequest.api.FLCardUrisResponse;
import com.huawei.flrequest.api.FLRequestException;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.qcardsupport.qcard.cardmanager.impl.LayoutLoader;
import com.huawei.qcardsupport.qcard.cardmanager.impl.e;
import com.huawei.quickcard.cardmanager.bean.BatchResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardDownloader {

    /* renamed from: c, reason: collision with root package name */
    private static final String f33164c = "CardDownloader";

    /* renamed from: d, reason: collision with root package name */
    private static final int f33165d = 512;

    /* renamed from: e, reason: collision with root package name */
    private static volatile CardDownloader f33166e;

    /* renamed from: a, reason: collision with root package name */
    private final FLEngine f33167a;

    /* renamed from: b, reason: collision with root package name */
    private final LayoutLoader f33168b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Executor f33169a = Executors.newFixedThreadPool(2);

        private a() {
        }
    }

    public CardDownloader(@NonNull FLEngine fLEngine) {
        e.a(fLEngine);
        this.f33167a = fLEngine;
        this.f33168b = new LayoutLoader(fLEngine.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TaskCompletionSource taskCompletionSource, FLCardUrisResponse fLCardUrisResponse) {
        if (fLCardUrisResponse != null) {
            JSONArray uris = fLCardUrisResponse.getUris();
            if (uris != null) {
                a(uris, (TaskCompletionSource<Void>) taskCompletionSource);
            } else {
                taskCompletionSource.setException(new FLRequestException(8, "FLCardUrisLoader get cardUris is empty"));
            }
        }
    }

    private void b(List<String> list) {
        Iterator<CardMetadata> iterator2 = CloudCardProvider.getInstance(this.f33167a).getMetadataList().iterator2();
        while (iterator2.hasNext()) {
            String str = iterator2.next().uri;
            if (!TextUtils.isEmpty(str)) {
                ListIterator<String> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (listIterator.next().startsWith(str)) {
                        listIterator.remove();
                    }
                }
            }
        }
    }

    public static CardDownloader getInstance(FLEngine fLEngine) {
        if (f33166e == null) {
            synchronized (CardDownloader.class) {
                if (f33166e == null) {
                    f33166e = new CardDownloader(fLEngine);
                }
            }
        }
        return f33166e;
    }

    public Task<Void> loadCard(@Nullable List<String> list, @Nullable String str) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FLCardUrisLoader.load(this.f33167a.getContext(), list, str).addOnSuccessListener(a.f33169a, new OnSuccessListener() { // from class: com.huawei.qcardsupport.qcard.cardmanager.c
            @Override // com.huawei.hmf.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                CardDownloader.this.a(taskCompletionSource, (FLCardUrisResponse) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.huawei.qcardsupport.qcard.cardmanager.b
            @Override // com.huawei.hmf.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                TaskCompletionSource.this.setException(exc);
            }
        });
        return taskCompletionSource.getTask();
    }

    private void a(@NonNull JSONArray jSONArray, TaskCompletionSource<Void> taskCompletionSource) {
        List<String> a10 = a(jSONArray);
        b(a10);
        while (a10.size() != 0) {
            try {
                a10 = a(a10);
            } catch (FLRequestException e2) {
                taskCompletionSource.setException(e2);
            }
        }
        taskCompletionSource.setResult(null);
    }

    @NonNull
    private List<String> a(@NonNull JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            String optString = jSONArray.optString(i10);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        return arrayList;
    }

    @NonNull
    private List<String> a(@NonNull List<String> list) throws FLRequestException {
        BatchResult a10 = this.f33168b.a(list, 512);
        if (a10.getFailedUris().length > 0) {
            Log.w(f33164c, "downloadCards failed: " + Arrays.toString(a10.getFailedUris()));
        }
        if (a10.getCode() == 0) {
            try {
                CloudCardProvider.getInstance(this.f33167a).addFromArray(a(a10.getInfo()));
            } catch (Exception unused) {
                Log.w(f33164c, "Failed to add card-layout to CloudCardProvider.");
            }
            int nextIndex = a10.getNextIndex();
            if (nextIndex > 0 && nextIndex <= list.size()) {
                if (nextIndex == list.size()) {
                    Log.i(f33164c, "Batch download card-layout completed.");
                    return Collections.emptyList();
                }
                return list.subList(nextIndex, list.size());
            }
            throw new FLRequestException(-1, "Invalid nextIndex: " + nextIndex + ", size: " + list.size());
        }
        throw new FLRequestException(-1, a10.getCode(), "Failed to batch download card-layout, errMsg: " + a10.getErrMsg());
    }

    private JSONArray a(BatchResult.CardInfo[] cardInfoArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (BatchResult.CardInfo cardInfo : cardInfoArr) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uri", cardInfo.getUri());
            jSONObject.put("type", cardInfo.getType());
            jSONObject.put("content", cardInfo.getContent());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
