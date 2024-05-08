package e9;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.utils.AESUtil;
import com.huawei.appgallery.agd.common.utils.FileUtil;
import com.huawei.appgallery.agd.pageframe.api.AgdGlideImageLoader;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.flexiblelayout.parser.DataItem;
import com.huawei.flexiblelayout.parser.FLDataDelegate;
import com.huawei.flexiblelayout.services.imageloader.ImageOptions;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g implements FLDataDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final String f48947a;

    /* renamed from: b, reason: collision with root package name */
    public final String f48948b;

    /* renamed from: c, reason: collision with root package name */
    public int f48949c;

    /* renamed from: d, reason: collision with root package name */
    public int f48950d;

    /* renamed from: e, reason: collision with root package name */
    public int f48951e;

    /* renamed from: f, reason: collision with root package name */
    public int f48952f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f48953g;

    /* renamed from: h, reason: collision with root package name */
    public int f48954h;

    /* renamed from: i, reason: collision with root package name */
    public int f48955i;

    /* renamed from: j, reason: collision with root package name */
    public int f48956j;

    /* renamed from: k, reason: collision with root package name */
    public List<String> f48957k;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements OnSuccessListener<Drawable> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f48958a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f48959b;

        public a(CountDownLatch countDownLatch, String str) {
            this.f48958a = countDownLatch;
            this.f48959b = str;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public void onSuccess(Drawable drawable) {
            Drawable drawable2 = drawable;
            if (drawable2 == null) {
                return;
            }
            try {
                String sha256EncryptStr = AESUtil.sha256EncryptStr(this.f48959b);
                e.f48945d.d("ApplyDelegateImpl", "downLoadImages imageUrl " + this.f48959b + " sha256:" + sha256EncryptStr);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(FileUtil.getImagesResourceRootDir());
                sb2.append(sha256EncryptStr);
                String sb3 = sb2.toString();
                if (FileUtil.saveFile(sb3, FileUtil.drawable2InputStream(drawable2))) {
                    g.this.f48957k.add(sb3);
                }
            } catch (Exception e2) {
                e.f48945d.e("ApplyDelegateImpl", "downLoadImages error:" + e2.getMessage());
            } finally {
                this.f48958a.countDown();
            }
        }
    }

    public g(@NonNull l lVar) {
        this.f48947a = lVar.f48971e;
        this.f48948b = lVar.f48970d.getSlotId();
        this.f48949c = lVar.f48970d.getDarkMode();
        this.f48950d = lVar.f48970d.getRotationTime();
        this.f48951e = lVar.f48970d.getSoundStatus();
        this.f48952f = lVar.f48970d.getOrientation();
        this.f48953g = lVar.f48970d.getDisableSdkCountDown();
        this.f48954h = lVar.f48970d.getAcceptedSizeWidth();
        this.f48955i = lVar.f48970d.getAcceptedSizeHeight();
        this.f48956j = lVar.f48977k;
        this.f48957k = lVar.f48981o;
    }

    public final int a(Context context, int i10) {
        return (int) (TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public final void b(@NonNull DataItem dataItem) {
        FLArray optArray;
        if (this.f48956j != 4 || (optArray = dataItem.getData().optArray(CardConstants.KEY_IMAGES)) == null || optArray.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < optArray.size(); i10++) {
            FLImmutableMap optMap = optArray.optMap(i10);
            if (optMap == null || optMap.isEmpty()) {
                return;
            }
            String optString = optMap.optString("imageUrl");
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
        AgdGlideImageLoader agdGlideImageLoader = new AgdGlideImageLoader(this.f48948b);
        Iterator iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            String str = (String) iterator2.next();
            ImageOptions imageOptions = new ImageOptions();
            imageOptions.setUrl(str);
            Task<Drawable> load = agdGlideImageLoader.load(ApplicationWrapper.getInstance().getContext(), imageOptions);
            load.addOnSuccessListener(new a(countDownLatch, str));
            load.addOnFailureListener(new OnFailureListener() { // from class: e9.f
                @Override // com.huawei.hmf.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    CountDownLatch.this.countDown();
                }
            });
        }
        try {
            boolean await = countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
            e.f48945d.d("ApplyDelegateImpl", "downLoadImages await " + await);
        } catch (InterruptedException e2) {
            e eVar = e.f48945d;
            StringBuilder b4 = e9.a.b("downLoadImages Exception = ");
            b4.append(e2.getMessage());
            eVar.e("ApplyDelegateImpl", b4.toString());
        }
        e.f48945d.i("ApplyDelegateImpl", "downLoadImages end");
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataDelegate
    @Nullable
    public FLDataGroup onApplyGroup(FLDataSource fLDataSource, FLDataGroup fLDataGroup, DataItem dataItem) {
        return fLDataGroup;
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataDelegate
    @Nullable
    public FLNodeData onApplyNode(FLDataGroup fLDataGroup, FLNodeData fLNodeData, DataItem dataItem) {
        e.f48945d.i("ApplyDelegateImpl", "onApplyNode, " + ((Object) fLNodeData) + " - " + fLDataGroup.getData().optString(CardConstants.KEY_LAYOUT_ID) + ", " + dataItem.getData().optString("nextPage"));
        return fLNodeData;
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataDelegate
    @Nullable
    public DataItem onParseGroup(@NonNull DataItem dataItem, @NonNull DataItem dataItem2) {
        e eVar = e.f48945d;
        StringBuilder b4 = e9.a.b("onParseGroup, ");
        b4.append(dataItem2.getData().optString(CardConstants.KEY_LAYOUT_ID));
        eVar.i("ApplyDelegateImpl", b4.toString());
        return dataItem2;
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataDelegate
    @Nullable
    public DataItem onParseNode(@NonNull DataItem dataItem, @NonNull DataItem dataItem2) {
        e eVar = e.f48945d;
        eVar.i("ApplyDelegateImpl", "onParseNode, " + ((Object) dataItem2) + " - " + dataItem2.getData().optString(CardConstants.KEY_LAYOUT_ID));
        String optString = dataItem.getData().optString(CardConstants.KEY_LAYOUT_ID);
        if (TextUtils.isEmpty(optString)) {
            optString = String.valueOf(dataItem.getId());
        }
        dataItem2.getData().put(CardConstants.KEY_LAYOUT_ID, optString);
        String optString2 = dataItem.getData().optString(CardConstants.KEY_QUICK_URI);
        if (!TextUtils.isEmpty(optString2) && optString2.startsWith(CardConstants.KEY_FAST_VIEW)) {
            dataItem2.getData().put("quickCard", optString2);
            dataItem2.getData().put("layoutName", CardConstants.VALUE_QLAYOUT);
        }
        b(dataItem2);
        if (ApplicationWrapper.getInstance() != null || ApplicationWrapper.getInstance().getContext() != null) {
            Context context = ApplicationWrapper.getInstance().getContext();
            int a10 = a(context, this.f48954h);
            int a11 = a(context, this.f48955i);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i10 = displayMetrics.widthPixels;
            int i11 = displayMetrics.heightPixels;
            if (a10 > i10) {
                eVar.e("ApplyDelegateImpl", "mAcceptedSizeWidth > screenWidth");
                this.f48954h = (int) ((i10 / context.getResources().getDisplayMetrics().density) + 0.5f);
            }
            if (a11 > i11) {
                eVar.e("ApplyDelegateImpl", "mAcceptedSizeHeight > screenHeight");
                this.f48955i = (int) ((i11 / context.getResources().getDisplayMetrics().density) + 0.5f);
            }
        }
        dataItem2.getData().put("uniqueId", this.f48947a);
        dataItem2.getData().put("slotId", this.f48948b);
        dataItem2.getData().put(CardConstants.KEY_DARK_MODE, Integer.valueOf(this.f48949c));
        dataItem2.getData().put(CardConstants.KEY_DISABLE_COUNTDOWN, this.f48953g);
        dataItem2.getData().put(CardConstants.KEY_ACCEPTEDSIZE_WIDTH, Integer.valueOf(this.f48954h));
        dataItem2.getData().put(CardConstants.KEY_ACCEPTEDSIZE_HEIGHT, Integer.valueOf(this.f48955i));
        dataItem2.getData().put(CardConstants.KEY_ROTATION_TIME, Integer.valueOf(this.f48950d));
        dataItem2.getData().put("orientation", Integer.valueOf(this.f48952f));
        dataItem2.getData().put(CardConstants.KEY_SOUND_STATE, Integer.valueOf(this.f48951e));
        dataItem2.getData().put(CardConstants.KEY_API_LEVEL, Integer.valueOf(Build.VERSION.SDK_INT));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", "inherit");
            dataItem2.setStyle(jSONObject);
        } catch (JSONException unused) {
            e.f48945d.i("ApplyDelegateImpl", "onParseNode exception");
        }
        return dataItem2;
    }
}
