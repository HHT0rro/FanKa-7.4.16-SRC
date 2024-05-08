package com.cupidapp.live;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.baidu.mobads.sdk.internal.bk;
import com.cupidapp.live.databinding.ActivitySearchLocationBindingImpl;
import com.cupidapp.live.databinding.FragmentEditStoryLabelBindingImpl;
import com.cupidapp.live.databinding.FragmentShareMenuBindingImpl;
import com.cupidapp.live.databinding.FragmentStoryLabelBindingImpl;
import com.cupidapp.live.databinding.FragmentStoryLabelDetailBindingImpl;
import com.cupidapp.live.databinding.HashtagListFragmentBindingImpl;
import com.cupidapp.live.databinding.ItemClassifyHashtagBindingImpl;
import com.cupidapp.live.databinding.ItemHashtagContentBindingImpl;
import com.cupidapp.live.databinding.ItemPasterBindingImpl;
import com.cupidapp.live.databinding.ViewHolderStoryLabelBindingImpl;
import com.cupidapp.live.databinding.ViewHolderStoryLabelDetailItemBindingImpl;
import com.cupidapp.live.databinding.ViewHolderStoryLabelTipsBindingImpl;
import com.cupidapp.live.databinding.ViewHolderStoryLabelTitleBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f11620a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f11621a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(9);
            f11621a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "classify");
            sparseArray.put(2, "hashtag");
            sparseArray.put(3, bk.f9900i);
            sparseArray.put(4, "storyLabel");
            sparseArray.put(5, "storyLabelTips");
            sparseArray.put(6, "storyLabelTitle");
            sparseArray.put(7, "viewModel");
            sparseArray.put(8, "viewmodel");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f11622a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(13);
            f11622a = hashMap;
            hashMap.put("layout/activity_search_location_0", Integer.valueOf(R$layout.activity_search_location));
            hashMap.put("layout/fragment_edit_story_label_0", Integer.valueOf(R$layout.fragment_edit_story_label));
            hashMap.put("layout/fragment_share_menu_0", Integer.valueOf(R$layout.fragment_share_menu));
            hashMap.put("layout/fragment_story_label_0", Integer.valueOf(R$layout.fragment_story_label));
            hashMap.put("layout/fragment_story_label_detail_0", Integer.valueOf(R$layout.fragment_story_label_detail));
            hashMap.put("layout/hashtag_list_fragment_0", Integer.valueOf(R$layout.hashtag_list_fragment));
            hashMap.put("layout/item_classify_hashtag_0", Integer.valueOf(R$layout.item_classify_hashtag));
            hashMap.put("layout/item_hashtag_content_0", Integer.valueOf(R$layout.item_hashtag_content));
            hashMap.put("layout/item_paster_0", Integer.valueOf(R$layout.item_paster));
            hashMap.put("layout/view_holder_story_label_0", Integer.valueOf(R$layout.view_holder_story_label));
            hashMap.put("layout/view_holder_story_label_detail_item_0", Integer.valueOf(R$layout.view_holder_story_label_detail_item));
            hashMap.put("layout/view_holder_story_label_tips_0", Integer.valueOf(R$layout.view_holder_story_label_tips));
            hashMap.put("layout/view_holder_story_label_title_0", Integer.valueOf(R$layout.view_holder_story_label_title));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(13);
        f11620a = sparseIntArray;
        sparseIntArray.put(R$layout.activity_search_location, 1);
        sparseIntArray.put(R$layout.fragment_edit_story_label, 2);
        sparseIntArray.put(R$layout.fragment_share_menu, 3);
        sparseIntArray.put(R$layout.fragment_story_label, 4);
        sparseIntArray.put(R$layout.fragment_story_label_detail, 5);
        sparseIntArray.put(R$layout.hashtag_list_fragment, 6);
        sparseIntArray.put(R$layout.item_classify_hashtag, 7);
        sparseIntArray.put(R$layout.item_hashtag_content, 8);
        sparseIntArray.put(R$layout.item_paster, 9);
        sparseIntArray.put(R$layout.view_holder_story_label, 10);
        sparseIntArray.put(R$layout.view_holder_story_label_detail_item, 11);
        sparseIntArray.put(R$layout.view_holder_story_label_tips, 12);
        sparseIntArray.put(R$layout.view_holder_story_label_title, 13);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i10) {
        return a.f11621a.get(i10);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i10) {
        int i11 = f11620a.get(i10);
        if (i11 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i11) {
                case 1:
                    if ("layout/activity_search_location_0".equals(tag)) {
                        return new ActivitySearchLocationBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_search_location is invalid. Received: " + tag);
                case 2:
                    if ("layout/fragment_edit_story_label_0".equals(tag)) {
                        return new FragmentEditStoryLabelBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_edit_story_label is invalid. Received: " + tag);
                case 3:
                    if ("layout/fragment_share_menu_0".equals(tag)) {
                        return new FragmentShareMenuBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_share_menu is invalid. Received: " + tag);
                case 4:
                    if ("layout/fragment_story_label_0".equals(tag)) {
                        return new FragmentStoryLabelBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_story_label is invalid. Received: " + tag);
                case 5:
                    if ("layout/fragment_story_label_detail_0".equals(tag)) {
                        return new FragmentStoryLabelDetailBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_story_label_detail is invalid. Received: " + tag);
                case 6:
                    if ("layout/hashtag_list_fragment_0".equals(tag)) {
                        return new HashtagListFragmentBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for hashtag_list_fragment is invalid. Received: " + tag);
                case 7:
                    if ("layout/item_classify_hashtag_0".equals(tag)) {
                        return new ItemClassifyHashtagBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_classify_hashtag is invalid. Received: " + tag);
                case 8:
                    if ("layout/item_hashtag_content_0".equals(tag)) {
                        return new ItemHashtagContentBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_hashtag_content is invalid. Received: " + tag);
                case 9:
                    if ("layout/item_paster_0".equals(tag)) {
                        return new ItemPasterBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_paster is invalid. Received: " + tag);
                case 10:
                    if ("layout/view_holder_story_label_0".equals(tag)) {
                        return new ViewHolderStoryLabelBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for view_holder_story_label is invalid. Received: " + tag);
                case 11:
                    if ("layout/view_holder_story_label_detail_item_0".equals(tag)) {
                        return new ViewHolderStoryLabelDetailItemBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for view_holder_story_label_detail_item is invalid. Received: " + tag);
                case 12:
                    if ("layout/view_holder_story_label_tips_0".equals(tag)) {
                        return new ViewHolderStoryLabelTipsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for view_holder_story_label_tips is invalid. Received: " + tag);
                case 13:
                    if ("layout/view_holder_story_label_title_0".equals(tag)) {
                        return new ViewHolderStoryLabelTitleBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for view_holder_story_label_title is invalid. Received: " + tag);
                default:
                    return null;
            }
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f11622a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f11620a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
