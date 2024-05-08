package com.irisdt.client.post;

import com.android.internal.logging.nano.MetricsProto;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import com.huawei.openalliance.ad.constant.ad;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class PostAndSocialProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019PostAndSocialProtos.proto\u0012\u0016com.irisdt.client.post\"á\u000b\n\u0012PostAndSocialProto\u0012,\n\u0005event\u0018\u0001 \u0001(\u000e2\u001d.com.irisdt.client.post.Event\u0012\f\n\u0004name\u0018\u0002 \u0001(\t\u0012\f\n\u0004from\u0018\u0003 \u0001(\t\u0012\u0012\n\ntarget_uid\u0018\u0004 \u0001(\t\u0012\u000f\n\u0007is_true\u0018\u0005 \u0001(\b\u0012\u000f\n\u0007content\u0018\u0006 \u0001(\t\u0012\r\n\u0005topic\u0018\u0007 \u0001(\t\u0012\u000f\n\u0007post_id\u0018\b \u0001(\t\u0012\r\n\u0005scene\u0018\t \u0001(\t\u0012\u0010\n\bposition\u0018\n \u0001(\t\u0012\u000b\n\u0003num\u0018\u000b \u0001(\u0005\u0012\r\n\u0005index\u0018\f \u0001(\u0005\u0012\n\n\u0002id\u0018\r \u0001(\t\u0012*\n\u0004type\u0018\u000e \u0001(\u000e2\u001c.com.irisdt.client.post.Type\u0012\u0010\n\bsub_type\u0018\u000f \u0001(\t\u0012\u000e\n\u0006exp_id\u0018\u0010 \u0001(\t\u0012\u0013\n\u000bretrieve_id\u0018\u0011 \u0001(\t\u0012\f\n\u0004time\u0018\u0012 \u0001(\u0005\u0012\u0010\n\bdistance\u0018\u0013 \u0001(\t\u0012\f\n\u0004high\u0018\u0014 \u0001(\t\u0012\u000e\n\u0006weight\u0018\u0015 \u0001(\t\u0012\u0014\n\fis_recommend\u0018\u0016 \u0001(\b\u0012\u0011\n\towner_uid\u0018\u0017 \u0001(\t\u0012\u000f\n\u0007is_show\u0018\u0018 \u0001(\b\u0012\u000f\n\u0007mode_id\u0018\u0019 \u0001(\t\u0012\u0011\n\tis_follow\u0018\u001a \u0001(\b\u0012\u000e\n\u0006source\u0018\u001b \u0001(\t\u0012\u0010\n\bcampaign\u0018\u001c \u0001(\t\u0012\u0015\n\ris_super_like\u0018\u001d \u0001(\b\u0012\u0014\n\fmatch_exp_id\u0018\u001e \u0001(\t\u0012\u0019\n\u0011match_retrieve_id\u0018\u001f \u0001(\t\u0012\u0019\n\u0011match_strategy_id\u0018  \u0001(\t\u0012\u0011\n\tcover_num\u0018! \u0001(\u0005\u0012\u0010\n\bimage_id\u0018\" \u0001(\t\u00124\n\tenum_type\u0018# \u0001(\u000e2!.com.irisdt.client.post.Enum_type\u0012\f\n\u0004info\u0018$ \u0001(\t\u0012\u0012\n\npermission\u0018% \u0001(\u0005\u0012\u0011\n\tvideo_num\u0018& \u0001(\u0005\u0012\u0010\n\bvideo_id\u0018' \u0001(\t\u0012\u0018\n\u0010online_show_type\u0018( \u0001(\t\u0012\u0012\n\nis_like_me\u0018) \u0001(\b\u0012\u0011\n\tcost_time\u0018* \u0001(\u0003\u0012\u0010\n\bmask_num\u0018+ \u0001(\u0005\u0012\u0011\n\tvoice_num\u0018, \u0001(\u0005\u0012\u0014\n\fis_live_show\u0018- \u0001(\b\u0012\u0011\n\tcard_type\u0018. \u0001(\t\u0012\u0010\n\bcard_num\u0018/ \u0001(\u0005\u0012\u0011\n\trole_type\u00180 \u0001(\t\u0012\u0013\n\u000bhas_picture\u00181 \u0001(\b\u0012\u0010\n\bhas_text\u00182 \u0001(\b\u0012\u0012\n\nhas_status\u00183 \u0001(\b\u0012\u000e\n\u0006reason\u00184 \u0001(\t\u0012\u0010\n\brelation\u00185 \u0001(\t\u0012\u001c\n\u0014is_special_attention\u00186 \u0001(\b\u0012\u0017\n\u000fis_close_friend\u00187 \u0001(\b\u0012\u0012\n\nis_success\u00188 \u0001(\b\u0012\u0010\n\bmsg_type\u00189 \u0001(\t\u0012\u0016\n\u000eis_super_boost\u0018: \u0001(\b\u0012\r\n\u0005count\u0018; \u0001(\u0005\u0012\u0011\n\tgame_type\u0018< \u0001(\t\u0012\u0011\n\tshow_type\u0018= \u0001(\t\u0012\u0016\n\u000eis_wealth_show\u0018> \u0001(\b\u0012\u0016\n\u000eis_post_spread\u0018? \u0001(\b\u0012\u0013\n\u000bcancel_type\u0018@ \u0001(\t\u0012\u0016\n\u000esuper_like_cnt\u0018A \u0001(\u0005\u0012\u0013\n\u000bis_post_top\u0018B \u0001(\b\u0012\u001d\n\u0015constellation_content\u0018C \u0001(\t\u0012\u0019\n\u0011is_ssvip_exposure\u0018D \u0001(\b\u0012\u000e\n\u0006result\u0018E \u0001(\t\u0012\u0015\n\ris_limit_time\u0018F \u0001(\b\u0012\r\n\u0005title\u0018G \u0001(\t\u0012\f\n\u0004mbti\u0018H \u0001(\t\u0012\u0011\n\tis_travel\u0018I \u0001(\b*\u008b\u0011\n\u0005Event\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\u000f\n\u000bAVATAR_DRAW\u0010\u0001\u0012\u0010\n\fAVATAR_CLICK\u0010\u0002\u0012\u0015\n\u0011MINI_PROFILE_SHOW\u0010\u0003\u0012\u0019\n\u0015PERSONAL_PROFILE_SHOW\u0010\u0004\u0012\u0016\n\u0012MATCH_PAGE_DISLIKE\u0010\u0005\u0012\u0013\n\u000fMATCH_PAGE_LIKE\u0010\u0006\u0012\u0011\n\rCANCEL_FOLLOW\u0010\u0007\u0012\u0011\n\rMATCH_SUCCESS\u0010\b\u0012\u0011\n\rADD_BLACKLIST\u0010\t\u0012\u0015\n\u0011PUBLISH_BTN_CLICK\u0010\n\u0012\u0017\n\u0013POST_SELECT_PICTURE\u0010\u000b\u0012\u001f\n\u001bCONTENT_EDIT_PAGE_BTN_CLICK\u0010\f\u0012\u001f\n\u001bCONTENT_EDIT_PUSH_BTN_CLICK\u0010\r\u0012\r\n\tPOST_DRAW\u0010\u000e\u0012\u0014\n\u0010POST_DETAIL_SHOW\u0010\u000f\u0012\r\n\tPOST_LIKE\u0010\u0010\u0012\u0014\n\u0010POST_CANCEL_LIKE\u0010\u0011\u0012\u0010\n\fPOST_COMMENT\u0010\u0012\u0012\u0017\n\u0013POST_COMMENT_DELETE\u0010\u0013\u0012\u0018\n\u0014TOPIC_ENTRANCE_CLICK\u0010\u0014\u0012\u0013\n\u000fTOPIC_PAGE_SHOW\u0010\u0015\u0012\u0018\n\u0014TOPIC_PAGE_BTN_CLICK\u0010\u0016\u0012\u0013\n\u000fENTER_CHAT_PAGE\u0010\u0017\u0012\u0010\n\fPHOTOS_SLIDE\u0010\u0018\u0012\u0012\n\u000ePOST_PAGE_SHOW\u0010\u001a\u0012\u0014\n\u0010POST_TOPIC_CLICK\u0010\u001b\u0012\u0016\n\u0012CLICK_MINI_PICTURE\u0010\u001c\u0012\u0018\n\u0014NEW_MATCH_POPUP_SHOW\u0010\u001d\u0012\u0018\n\u0014MATCH_POPUP_SEND_MSG\u0010\u001e\u0012\u0013\n\u000fMSG_SEND_FAILED\u0010\u001f\u0012\u001c\n\u0018POST_CONTENT_LOAD_FAILED\u0010 \u0012\u0019\n\u0015NEW_MATCH_AVATAR_SHOW\u0010!\u0012\u0016\n\u0012MAX_FEED_DRAW_DEEP\u0010\"\u0012#\n\u001fFEED_CONTENT_READ_COMPLETE_SHOW\u0010#\u0012\u0015\n\u0011IGNORE_POST_CLICK\u0010$\u0012\u001b\n\u0017RECOVER_LOOK_POST_CLICK\u0010%\u0012\r\n\tSHOW_POST\u0010&\u0012\r\n\tHIDE_POST\u0010'\u0012\u001a\n\u0016PRIVATE_POST_PAGE_SHOW\u0010(\u0012\u0019\n\u0015STICKER_ACT_BTN_CLICK\u0010)\u0012\u001c\n\u0018CONTENT_INVALID_TIP_SHOW\u0010*\u0012\u0019\n\u0015STORY_TAG_SELECT_SHOW\u0010+\u0012\u0019\n\u0015STORY_TAG_DETAIL_SHOW\u0010,\u0012\u001b\n\u0017STORY_TAG_FILL_COMPLETE\u0010-\u0012\u0012\n\u000eSTORY_TAG_SHOW\u0010.\u0012\u001f\n\u001bPROFILE_STORY_TAG_PAGE_SHOW\u0010/\u0012 \n\u001cPROFILE_STORY_TAG_PAGE_CLICK\u00100\u0012\u001e\n\u001aPOST_DETAIL_ENTRANCE_CLICK\u00101\u0012\u001d\n\u0019SUPER_LIKE_SEND_MSG_CLICK\u00102\u0012\u0019\n\u0015SWITCH_POST_SORT_MODE\u00103\u0012\u0015\n\u0011SEARCH_SOMEONE_AT\u00104\u0012\u000e\n\nAT_SOMEONE\u00105\u0012#\n\u001fSPECIAL_ATTENTION_SWITCH_STATUS\u00107\u0012\u001f\n\u001bCLOSE_FRIENDS_SWITCH_STATUS\u00108\u0012\u0015\n\u0011CONTACT_SORT_SHOW\u00109\u0012\u001f\n\u001bSECRET_LOUNGE_FLOW_COMPLETE\u0010:\u0012\u0010\n\fSESSION_SHOW\u0010<\u0012\u0011\n\rSESSION_CLICK\u0010=\u0012\u0017\n\u0013SEND_EMOJI_TO_GREET\u0010>\u0012\u001c\n\u0018FIND_PAGE_CLASSIFY_CLICK\u0010?\u0012\u001d\n\u0019PERSONAL_ICON_SUCESS_SAVE\u0010@\u0012\u0016\n\u0012MASK_PARTY_SURPLUS\u0010A\u0012\u0019\n\u0015POST_MATCH_GUIDE_SHOW\u0010B\u0012\u001a\n\u0016POST_MATCH_GUIDE_CLICK\u0010C\u0012\u0017\n\u0013VOICE_FLOW_COMPLETE\u0010D\u0012&\n\"MESSAGE_DETAIL_VOICE_FLOW_COMPLETE\u0010E\u0012\u001b\n\u0017TIME_LIMIT_FEED_PUBLISH\u0010F\u0012\u001f\n\u001bTIME_LIMIT_FEED_AVATAR_DRAW\u0010G\u0012\"\n\u001eTIME_LIMIT_FEED_ENTRANCE_CLICK\u0010H\u0012\u0016\n\u0012SEND_INBOX_MESSAGE\u0010I\u0012\u000f\n\u000bPRAISE_LIKE\u0010J\u0012!\n\u001dPERSON_INTRODUCE_SAVE_SUCCESS\u0010K\u0012(\n$CONTACT_MANAGE_CANCEL_FOLLOW_SUCCESS\u0010L\u0012\f\n\bPOST_TOP\u0010M\u0012\u0013\n\u000fCANCEL_POST_TOP\u0010N\u0012\u0011\n\rPRAISE_DELETE\u0010O\u0012\u001b\n\u0017CLUB_ACTIVITY_CARD_SHOW\u0010P\u0012\u001c\n\u0018CLUB_ACTIVITY_CARD_CLICK\u0010Q\u0012\u0019\n\u0015CLUB_RICH_SCAN_RESULT\u0010R\u0012\u0016\n\u0012CLUB_ACTIVITY_DRAW\u0010S\u0012\u0017\n\u0013CLUB_ACTIVITY_CLICK\u0010T\u0012\u001c\n\u0018MATCH_RECOMMEND_PIC_SHOW\u0010U\u0012\u001d\n\u0019MATCH_RECOMMEND_PIC_CLICK\u0010V\u0012\u0019\n\u0015POST_BOOST_BOARD_SHOW\u0010W\u0012\u001a\n\u0016POST_BOOST_BOARD_CLICK\u0010X*\u008a\u0007\n\u0004Type\u0012\u0010\n\fUNKNOWN_TYPE\u0010\u0000\u0012\t\n\u0005TOPIC\u0010\u0001\u0012\f\n\bLOCATION\u0010\u0002\u0012\u0016\n\u0012LOCATION_RECOMMEND\u0010\u0003\u0012\u0010\n\fLOOK_UP_POST\u0010\u0004\u0012\u0013\n\u000fLOOK_UP_PROFILE\u0010\u0005\u0012\b\n\u0004PUSH\u0010\u0006\u0012\b\n\u0004SAVE\u0010\u0007\u0012\u000b\n\u0007STICKER\u0010\b\u0012\u000b\n\u0007ABANDON\u0010\t\u0012\u0007\n\u0003CUT\u0010\n\u0012\u000b\n\u0007PROFILE\u0010\u000b\u0012\r\n\tSTORY_TAG\u0010\f\u0012\f\n\bFILL_TOO\u0010\r\u0012\u0010\n\fEDIT_PROFILE\u0010\u000e\u0012\u000f\n\u000bCOMMENT_BTN\u0010\u000f\u0012\f\n\bDESCRIBE\u0010\u0010\u0012\u000b\n\u0007COMMENT\u0010\u0011\u0012\n\n\u0006FOLLOW\u0010\u0012\u0012\b\n\u0004TIME\u0010\u0013\u0012\u0014\n\u0010PROFILE_PORTRAIT\u0010\u0014\u0012\u0010\n\fPROFILE_NAME\u0010\u0015\u0012\u0011\n\rPROFILE_PHOTO\u0010\u0016\u0012\t\n\u0005WRITE\u0010\u0017\u0012\t\n\u0005CLICK\u0010\u0018\u0012\t\n\u0005MATCH\u0010\u0019\u0012\r\n\tBE_FOLLOW\u0010\u001a\u0012\u000e\n\nSUPER_LIKE\u0010\u001b\u0012\u0011\n\rBE_SUPER_LIKE\u0010\u001c\u0012\b\n\u0004NONE\u0010\u001d\u0012\u0011\n\rCLOSE_FRIENDS\u0010\u001e\u0012\u0015\n\u0011SPECIAL_ATTENTION\u0010\u001f\u0012\b\n\u0004FANS\u0010 \u0012\b\n\u0004LIKE\u0010!\u0012\b\n\u0004SHOT\u0010\"\u0012\u0010\n\fASK_QUESTION\u0010#\u0012\u0013\n\u000fANSWER_QUESTION\u0010$\u0012\u0010\n\fANOTHER_SHOT\u0010%\u0012\u0010\n\fSHOW_PROFILE\u0010&\u0012\u0014\n\u0010RECOMMENDED_CHAT\u0010'\u0012\t\n\u0005START\u0010(\u0012\b\n\u0004STOP\u0010)\u0012\u0012\n\u000eCHOOSE_PROBLEM\u0010*\u0012\u0014\n\u0010ENTER_VOICE_ROOM\u0010+\u0012\u0014\n\u0010ENTER_VOICE_GAME\u0010,\u0012\f\n\bRING_OFF\u0010-\u0012\f\n\bCALL_END\u0010.\u0012\u000f\n\u000bREACH_MATCH\u0010/\u0012\u0018\n\u0014ENTER_VOICE_ROOM_SDK\u00100\u0012\u000f\n\u000bCOMMON_CHAT\u00101\u0012\u0014\n\u0010VOICE_PARTY_CHAT\u00102\u0012\u000f\n\u000bPLAY_ACTION\u00103\u0012\u000f\n\u000bCHOOSE_ROLE\u00104\u0012\u0012\n\u000eGUESS_IDENTITY\u00105\u0012\u0011\n\rTASK_COMPLETE\u00106\u0012\u0016\n\u0012SHOW_PROFILE_GUIDE\u00107*§\u0001\n\tEnum_type\u0012\u0015\n\u0011UNKNOWN_ENUM_TYPE\u0010\u0000\u0012\f\n\bRECENTLY\u0010\u0001\u0012\f\n\bPROBABLY\u0010\u0002\u0012\n\n\u0006SEARCH\u0010\u0003\u0012\f\n\bDISTANCE\u0010\u0004\u0012\u000f\n\u000bCREATE_TIME\u0010\u0005\u0012\f\n\bACT_TIME\u0010\u0006\u0012\r\n\tRECOMMEND\u0010\u0007\u0012\t\n\u0005SCORE\u0010\b\u0012\u0007\n\u0003ALL\u0010\t\u0012\u000b\n\u0007UN_JOIN\u0010\nB\u0012¢\u0002\u000fPOST_AND_SOCIALb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_irisdt_client_post_PostAndSocialProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_client_post_PostAndSocialProto_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Enum_type implements ProtocolMessageEnum {
        UNKNOWN_ENUM_TYPE(0),
        RECENTLY(1),
        PROBABLY(2),
        SEARCH(3),
        DISTANCE(4),
        CREATE_TIME(5),
        ACT_TIME(6),
        RECOMMEND(7),
        SCORE(8),
        ALL(9),
        UN_JOIN(10),
        UNRECOGNIZED(-1);

        public static final int ACT_TIME_VALUE = 6;
        public static final int ALL_VALUE = 9;
        public static final int CREATE_TIME_VALUE = 5;
        public static final int DISTANCE_VALUE = 4;
        public static final int PROBABLY_VALUE = 2;
        public static final int RECENTLY_VALUE = 1;
        public static final int RECOMMEND_VALUE = 7;
        public static final int SCORE_VALUE = 8;
        public static final int SEARCH_VALUE = 3;
        public static final int UNKNOWN_ENUM_TYPE_VALUE = 0;
        public static final int UN_JOIN_VALUE = 10;
        private final int value;
        private static final Internal.EnumLiteMap<Enum_type> internalValueMap = new Internal.EnumLiteMap<Enum_type>() { // from class: com.irisdt.client.post.PostAndSocialProtos.Enum_type.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Enum_type findValueByNumber(int i10) {
                return Enum_type.forNumber(i10);
            }
        };
        private static final Enum_type[] VALUES = values();

        Enum_type(int i10) {
            this.value = i10;
        }

        public static Enum_type forNumber(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN_ENUM_TYPE;
                case 1:
                    return RECENTLY;
                case 2:
                    return PROBABLY;
                case 3:
                    return SEARCH;
                case 4:
                    return DISTANCE;
                case 5:
                    return CREATE_TIME;
                case 6:
                    return ACT_TIME;
                case 7:
                    return RECOMMEND;
                case 8:
                    return SCORE;
                case 9:
                    return ALL;
                case 10:
                    return UN_JOIN;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return PostAndSocialProtos.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<Enum_type> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Enum_type valueOf(int i10) {
            return forNumber(i10);
        }

        public static Enum_type valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN(0),
        AVATAR_DRAW(1),
        AVATAR_CLICK(2),
        MINI_PROFILE_SHOW(3),
        PERSONAL_PROFILE_SHOW(4),
        MATCH_PAGE_DISLIKE(5),
        MATCH_PAGE_LIKE(6),
        CANCEL_FOLLOW(7),
        MATCH_SUCCESS(8),
        ADD_BLACKLIST(9),
        PUBLISH_BTN_CLICK(10),
        POST_SELECT_PICTURE(11),
        CONTENT_EDIT_PAGE_BTN_CLICK(12),
        CONTENT_EDIT_PUSH_BTN_CLICK(13),
        POST_DRAW(14),
        POST_DETAIL_SHOW(15),
        POST_LIKE(16),
        POST_CANCEL_LIKE(17),
        POST_COMMENT(18),
        POST_COMMENT_DELETE(19),
        TOPIC_ENTRANCE_CLICK(20),
        TOPIC_PAGE_SHOW(21),
        TOPIC_PAGE_BTN_CLICK(22),
        ENTER_CHAT_PAGE(23),
        PHOTOS_SLIDE(24),
        POST_PAGE_SHOW(26),
        POST_TOPIC_CLICK(27),
        CLICK_MINI_PICTURE(28),
        NEW_MATCH_POPUP_SHOW(29),
        MATCH_POPUP_SEND_MSG(30),
        MSG_SEND_FAILED(31),
        POST_CONTENT_LOAD_FAILED(32),
        NEW_MATCH_AVATAR_SHOW(33),
        MAX_FEED_DRAW_DEEP(34),
        FEED_CONTENT_READ_COMPLETE_SHOW(35),
        IGNORE_POST_CLICK(36),
        RECOVER_LOOK_POST_CLICK(37),
        SHOW_POST(38),
        HIDE_POST(39),
        PRIVATE_POST_PAGE_SHOW(40),
        STICKER_ACT_BTN_CLICK(41),
        CONTENT_INVALID_TIP_SHOW(42),
        STORY_TAG_SELECT_SHOW(43),
        STORY_TAG_DETAIL_SHOW(44),
        STORY_TAG_FILL_COMPLETE(45),
        STORY_TAG_SHOW(46),
        PROFILE_STORY_TAG_PAGE_SHOW(47),
        PROFILE_STORY_TAG_PAGE_CLICK(48),
        POST_DETAIL_ENTRANCE_CLICK(49),
        SUPER_LIKE_SEND_MSG_CLICK(50),
        SWITCH_POST_SORT_MODE(51),
        SEARCH_SOMEONE_AT(52),
        AT_SOMEONE(53),
        SPECIAL_ATTENTION_SWITCH_STATUS(55),
        CLOSE_FRIENDS_SWITCH_STATUS(56),
        CONTACT_SORT_SHOW(57),
        SECRET_LOUNGE_FLOW_COMPLETE(58),
        SESSION_SHOW(60),
        SESSION_CLICK(61),
        SEND_EMOJI_TO_GREET(62),
        FIND_PAGE_CLASSIFY_CLICK(63),
        PERSONAL_ICON_SUCESS_SAVE(64),
        MASK_PARTY_SURPLUS(65),
        POST_MATCH_GUIDE_SHOW(66),
        POST_MATCH_GUIDE_CLICK(67),
        VOICE_FLOW_COMPLETE(68),
        MESSAGE_DETAIL_VOICE_FLOW_COMPLETE(69),
        TIME_LIMIT_FEED_PUBLISH(70),
        TIME_LIMIT_FEED_AVATAR_DRAW(71),
        TIME_LIMIT_FEED_ENTRANCE_CLICK(72),
        SEND_INBOX_MESSAGE(73),
        PRAISE_LIKE(74),
        PERSON_INTRODUCE_SAVE_SUCCESS(75),
        CONTACT_MANAGE_CANCEL_FOLLOW_SUCCESS(76),
        POST_TOP(77),
        CANCEL_POST_TOP(78),
        PRAISE_DELETE(79),
        CLUB_ACTIVITY_CARD_SHOW(80),
        CLUB_ACTIVITY_CARD_CLICK(81),
        CLUB_RICH_SCAN_RESULT(82),
        CLUB_ACTIVITY_DRAW(83),
        CLUB_ACTIVITY_CLICK(84),
        MATCH_RECOMMEND_PIC_SHOW(85),
        MATCH_RECOMMEND_PIC_CLICK(86),
        POST_BOOST_BOARD_SHOW(87),
        POST_BOOST_BOARD_CLICK(88),
        UNRECOGNIZED(-1);

        public static final int ADD_BLACKLIST_VALUE = 9;
        public static final int AT_SOMEONE_VALUE = 53;
        public static final int AVATAR_CLICK_VALUE = 2;
        public static final int AVATAR_DRAW_VALUE = 1;
        public static final int CANCEL_FOLLOW_VALUE = 7;
        public static final int CANCEL_POST_TOP_VALUE = 78;
        public static final int CLICK_MINI_PICTURE_VALUE = 28;
        public static final int CLOSE_FRIENDS_SWITCH_STATUS_VALUE = 56;
        public static final int CLUB_ACTIVITY_CARD_CLICK_VALUE = 81;
        public static final int CLUB_ACTIVITY_CARD_SHOW_VALUE = 80;
        public static final int CLUB_ACTIVITY_CLICK_VALUE = 84;
        public static final int CLUB_ACTIVITY_DRAW_VALUE = 83;
        public static final int CLUB_RICH_SCAN_RESULT_VALUE = 82;
        public static final int CONTACT_MANAGE_CANCEL_FOLLOW_SUCCESS_VALUE = 76;
        public static final int CONTACT_SORT_SHOW_VALUE = 57;
        public static final int CONTENT_EDIT_PAGE_BTN_CLICK_VALUE = 12;
        public static final int CONTENT_EDIT_PUSH_BTN_CLICK_VALUE = 13;
        public static final int CONTENT_INVALID_TIP_SHOW_VALUE = 42;
        public static final int ENTER_CHAT_PAGE_VALUE = 23;
        public static final int FEED_CONTENT_READ_COMPLETE_SHOW_VALUE = 35;
        public static final int FIND_PAGE_CLASSIFY_CLICK_VALUE = 63;
        public static final int HIDE_POST_VALUE = 39;
        public static final int IGNORE_POST_CLICK_VALUE = 36;
        public static final int MASK_PARTY_SURPLUS_VALUE = 65;
        public static final int MATCH_PAGE_DISLIKE_VALUE = 5;
        public static final int MATCH_PAGE_LIKE_VALUE = 6;
        public static final int MATCH_POPUP_SEND_MSG_VALUE = 30;
        public static final int MATCH_RECOMMEND_PIC_CLICK_VALUE = 86;
        public static final int MATCH_RECOMMEND_PIC_SHOW_VALUE = 85;
        public static final int MATCH_SUCCESS_VALUE = 8;
        public static final int MAX_FEED_DRAW_DEEP_VALUE = 34;
        public static final int MESSAGE_DETAIL_VOICE_FLOW_COMPLETE_VALUE = 69;
        public static final int MINI_PROFILE_SHOW_VALUE = 3;
        public static final int MSG_SEND_FAILED_VALUE = 31;
        public static final int NEW_MATCH_AVATAR_SHOW_VALUE = 33;
        public static final int NEW_MATCH_POPUP_SHOW_VALUE = 29;
        public static final int PERSONAL_ICON_SUCESS_SAVE_VALUE = 64;
        public static final int PERSONAL_PROFILE_SHOW_VALUE = 4;
        public static final int PERSON_INTRODUCE_SAVE_SUCCESS_VALUE = 75;
        public static final int PHOTOS_SLIDE_VALUE = 24;
        public static final int POST_BOOST_BOARD_CLICK_VALUE = 88;
        public static final int POST_BOOST_BOARD_SHOW_VALUE = 87;
        public static final int POST_CANCEL_LIKE_VALUE = 17;
        public static final int POST_COMMENT_DELETE_VALUE = 19;
        public static final int POST_COMMENT_VALUE = 18;
        public static final int POST_CONTENT_LOAD_FAILED_VALUE = 32;
        public static final int POST_DETAIL_ENTRANCE_CLICK_VALUE = 49;
        public static final int POST_DETAIL_SHOW_VALUE = 15;
        public static final int POST_DRAW_VALUE = 14;
        public static final int POST_LIKE_VALUE = 16;
        public static final int POST_MATCH_GUIDE_CLICK_VALUE = 67;
        public static final int POST_MATCH_GUIDE_SHOW_VALUE = 66;
        public static final int POST_PAGE_SHOW_VALUE = 26;
        public static final int POST_SELECT_PICTURE_VALUE = 11;
        public static final int POST_TOPIC_CLICK_VALUE = 27;
        public static final int POST_TOP_VALUE = 77;
        public static final int PRAISE_DELETE_VALUE = 79;
        public static final int PRAISE_LIKE_VALUE = 74;
        public static final int PRIVATE_POST_PAGE_SHOW_VALUE = 40;
        public static final int PROFILE_STORY_TAG_PAGE_CLICK_VALUE = 48;
        public static final int PROFILE_STORY_TAG_PAGE_SHOW_VALUE = 47;
        public static final int PUBLISH_BTN_CLICK_VALUE = 10;
        public static final int RECOVER_LOOK_POST_CLICK_VALUE = 37;
        public static final int SEARCH_SOMEONE_AT_VALUE = 52;
        public static final int SECRET_LOUNGE_FLOW_COMPLETE_VALUE = 58;
        public static final int SEND_EMOJI_TO_GREET_VALUE = 62;
        public static final int SEND_INBOX_MESSAGE_VALUE = 73;
        public static final int SESSION_CLICK_VALUE = 61;
        public static final int SESSION_SHOW_VALUE = 60;
        public static final int SHOW_POST_VALUE = 38;
        public static final int SPECIAL_ATTENTION_SWITCH_STATUS_VALUE = 55;
        public static final int STICKER_ACT_BTN_CLICK_VALUE = 41;
        public static final int STORY_TAG_DETAIL_SHOW_VALUE = 44;
        public static final int STORY_TAG_FILL_COMPLETE_VALUE = 45;
        public static final int STORY_TAG_SELECT_SHOW_VALUE = 43;
        public static final int STORY_TAG_SHOW_VALUE = 46;
        public static final int SUPER_LIKE_SEND_MSG_CLICK_VALUE = 50;
        public static final int SWITCH_POST_SORT_MODE_VALUE = 51;
        public static final int TIME_LIMIT_FEED_AVATAR_DRAW_VALUE = 71;
        public static final int TIME_LIMIT_FEED_ENTRANCE_CLICK_VALUE = 72;
        public static final int TIME_LIMIT_FEED_PUBLISH_VALUE = 70;
        public static final int TOPIC_ENTRANCE_CLICK_VALUE = 20;
        public static final int TOPIC_PAGE_BTN_CLICK_VALUE = 22;
        public static final int TOPIC_PAGE_SHOW_VALUE = 21;
        public static final int UNKNOWN_VALUE = 0;
        public static final int VOICE_FLOW_COMPLETE_VALUE = 68;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.irisdt.client.post.PostAndSocialProtos.Event.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Event findValueByNumber(int i10) {
                return Event.forNumber(i10);
            }
        };
        private static final Event[] VALUES = values();

        Event(int i10) {
            this.value = i10;
        }

        public static Event forNumber(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN;
                case 1:
                    return AVATAR_DRAW;
                case 2:
                    return AVATAR_CLICK;
                case 3:
                    return MINI_PROFILE_SHOW;
                case 4:
                    return PERSONAL_PROFILE_SHOW;
                case 5:
                    return MATCH_PAGE_DISLIKE;
                case 6:
                    return MATCH_PAGE_LIKE;
                case 7:
                    return CANCEL_FOLLOW;
                case 8:
                    return MATCH_SUCCESS;
                case 9:
                    return ADD_BLACKLIST;
                case 10:
                    return PUBLISH_BTN_CLICK;
                case 11:
                    return POST_SELECT_PICTURE;
                case 12:
                    return CONTENT_EDIT_PAGE_BTN_CLICK;
                case 13:
                    return CONTENT_EDIT_PUSH_BTN_CLICK;
                case 14:
                    return POST_DRAW;
                case 15:
                    return POST_DETAIL_SHOW;
                case 16:
                    return POST_LIKE;
                case 17:
                    return POST_CANCEL_LIKE;
                case 18:
                    return POST_COMMENT;
                case 19:
                    return POST_COMMENT_DELETE;
                case 20:
                    return TOPIC_ENTRANCE_CLICK;
                case 21:
                    return TOPIC_PAGE_SHOW;
                case 22:
                    return TOPIC_PAGE_BTN_CLICK;
                case 23:
                    return ENTER_CHAT_PAGE;
                case 24:
                    return PHOTOS_SLIDE;
                case 25:
                case 54:
                case 59:
                default:
                    return null;
                case 26:
                    return POST_PAGE_SHOW;
                case 27:
                    return POST_TOPIC_CLICK;
                case 28:
                    return CLICK_MINI_PICTURE;
                case 29:
                    return NEW_MATCH_POPUP_SHOW;
                case 30:
                    return MATCH_POPUP_SEND_MSG;
                case 31:
                    return MSG_SEND_FAILED;
                case 32:
                    return POST_CONTENT_LOAD_FAILED;
                case 33:
                    return NEW_MATCH_AVATAR_SHOW;
                case 34:
                    return MAX_FEED_DRAW_DEEP;
                case 35:
                    return FEED_CONTENT_READ_COMPLETE_SHOW;
                case 36:
                    return IGNORE_POST_CLICK;
                case 37:
                    return RECOVER_LOOK_POST_CLICK;
                case 38:
                    return SHOW_POST;
                case 39:
                    return HIDE_POST;
                case 40:
                    return PRIVATE_POST_PAGE_SHOW;
                case 41:
                    return STICKER_ACT_BTN_CLICK;
                case 42:
                    return CONTENT_INVALID_TIP_SHOW;
                case 43:
                    return STORY_TAG_SELECT_SHOW;
                case 44:
                    return STORY_TAG_DETAIL_SHOW;
                case 45:
                    return STORY_TAG_FILL_COMPLETE;
                case 46:
                    return STORY_TAG_SHOW;
                case 47:
                    return PROFILE_STORY_TAG_PAGE_SHOW;
                case 48:
                    return PROFILE_STORY_TAG_PAGE_CLICK;
                case 49:
                    return POST_DETAIL_ENTRANCE_CLICK;
                case 50:
                    return SUPER_LIKE_SEND_MSG_CLICK;
                case 51:
                    return SWITCH_POST_SORT_MODE;
                case 52:
                    return SEARCH_SOMEONE_AT;
                case 53:
                    return AT_SOMEONE;
                case 55:
                    return SPECIAL_ATTENTION_SWITCH_STATUS;
                case 56:
                    return CLOSE_FRIENDS_SWITCH_STATUS;
                case 57:
                    return CONTACT_SORT_SHOW;
                case 58:
                    return SECRET_LOUNGE_FLOW_COMPLETE;
                case 60:
                    return SESSION_SHOW;
                case 61:
                    return SESSION_CLICK;
                case 62:
                    return SEND_EMOJI_TO_GREET;
                case 63:
                    return FIND_PAGE_CLASSIFY_CLICK;
                case 64:
                    return PERSONAL_ICON_SUCESS_SAVE;
                case 65:
                    return MASK_PARTY_SURPLUS;
                case 66:
                    return POST_MATCH_GUIDE_SHOW;
                case 67:
                    return POST_MATCH_GUIDE_CLICK;
                case 68:
                    return VOICE_FLOW_COMPLETE;
                case 69:
                    return MESSAGE_DETAIL_VOICE_FLOW_COMPLETE;
                case 70:
                    return TIME_LIMIT_FEED_PUBLISH;
                case 71:
                    return TIME_LIMIT_FEED_AVATAR_DRAW;
                case 72:
                    return TIME_LIMIT_FEED_ENTRANCE_CLICK;
                case 73:
                    return SEND_INBOX_MESSAGE;
                case 74:
                    return PRAISE_LIKE;
                case 75:
                    return PERSON_INTRODUCE_SAVE_SUCCESS;
                case 76:
                    return CONTACT_MANAGE_CANCEL_FOLLOW_SUCCESS;
                case 77:
                    return POST_TOP;
                case 78:
                    return CANCEL_POST_TOP;
                case 79:
                    return PRAISE_DELETE;
                case 80:
                    return CLUB_ACTIVITY_CARD_SHOW;
                case 81:
                    return CLUB_ACTIVITY_CARD_CLICK;
                case 82:
                    return CLUB_RICH_SCAN_RESULT;
                case 83:
                    return CLUB_ACTIVITY_DRAW;
                case 84:
                    return CLUB_ACTIVITY_CLICK;
                case 85:
                    return MATCH_RECOMMEND_PIC_SHOW;
                case 86:
                    return MATCH_RECOMMEND_PIC_CLICK;
                case 87:
                    return POST_BOOST_BOARD_SHOW;
                case 88:
                    return POST_BOOST_BOARD_CLICK;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return PostAndSocialProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Event> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Event valueOf(int i10) {
            return forNumber(i10);
        }

        public static Event valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class PostAndSocialProto extends GeneratedMessageV3 implements PostAndSocialProtoOrBuilder {
        public static final int CAMPAIGN_FIELD_NUMBER = 28;
        public static final int CANCEL_TYPE_FIELD_NUMBER = 64;
        public static final int CARD_NUM_FIELD_NUMBER = 47;
        public static final int CARD_TYPE_FIELD_NUMBER = 46;
        public static final int CONSTELLATION_CONTENT_FIELD_NUMBER = 67;
        public static final int CONTENT_FIELD_NUMBER = 6;
        public static final int COST_TIME_FIELD_NUMBER = 42;
        public static final int COUNT_FIELD_NUMBER = 59;
        public static final int COVER_NUM_FIELD_NUMBER = 33;
        public static final int DISTANCE_FIELD_NUMBER = 19;
        public static final int ENUM_TYPE_FIELD_NUMBER = 35;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int EXP_ID_FIELD_NUMBER = 16;
        public static final int FROM_FIELD_NUMBER = 3;
        public static final int GAME_TYPE_FIELD_NUMBER = 60;
        public static final int HAS_PICTURE_FIELD_NUMBER = 49;
        public static final int HAS_STATUS_FIELD_NUMBER = 51;
        public static final int HAS_TEXT_FIELD_NUMBER = 50;
        public static final int HIGH_FIELD_NUMBER = 20;
        public static final int ID_FIELD_NUMBER = 13;
        public static final int IMAGE_ID_FIELD_NUMBER = 34;
        public static final int INDEX_FIELD_NUMBER = 12;
        public static final int INFO_FIELD_NUMBER = 36;
        public static final int IS_CLOSE_FRIEND_FIELD_NUMBER = 55;
        public static final int IS_FOLLOW_FIELD_NUMBER = 26;
        public static final int IS_LIKE_ME_FIELD_NUMBER = 41;
        public static final int IS_LIMIT_TIME_FIELD_NUMBER = 70;
        public static final int IS_LIVE_SHOW_FIELD_NUMBER = 45;
        public static final int IS_POST_SPREAD_FIELD_NUMBER = 63;
        public static final int IS_POST_TOP_FIELD_NUMBER = 66;
        public static final int IS_RECOMMEND_FIELD_NUMBER = 22;
        public static final int IS_SHOW_FIELD_NUMBER = 24;
        public static final int IS_SPECIAL_ATTENTION_FIELD_NUMBER = 54;
        public static final int IS_SSVIP_EXPOSURE_FIELD_NUMBER = 68;
        public static final int IS_SUCCESS_FIELD_NUMBER = 56;
        public static final int IS_SUPER_BOOST_FIELD_NUMBER = 58;
        public static final int IS_SUPER_LIKE_FIELD_NUMBER = 29;
        public static final int IS_TRAVEL_FIELD_NUMBER = 73;
        public static final int IS_TRUE_FIELD_NUMBER = 5;
        public static final int IS_WEALTH_SHOW_FIELD_NUMBER = 62;
        public static final int MASK_NUM_FIELD_NUMBER = 43;
        public static final int MATCH_EXP_ID_FIELD_NUMBER = 30;
        public static final int MATCH_RETRIEVE_ID_FIELD_NUMBER = 31;
        public static final int MATCH_STRATEGY_ID_FIELD_NUMBER = 32;
        public static final int MBTI_FIELD_NUMBER = 72;
        public static final int MODE_ID_FIELD_NUMBER = 25;
        public static final int MSG_TYPE_FIELD_NUMBER = 57;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NUM_FIELD_NUMBER = 11;
        public static final int ONLINE_SHOW_TYPE_FIELD_NUMBER = 40;
        public static final int OWNER_UID_FIELD_NUMBER = 23;
        public static final int PERMISSION_FIELD_NUMBER = 37;
        public static final int POSITION_FIELD_NUMBER = 10;
        public static final int POST_ID_FIELD_NUMBER = 8;
        public static final int REASON_FIELD_NUMBER = 52;
        public static final int RELATION_FIELD_NUMBER = 53;
        public static final int RESULT_FIELD_NUMBER = 69;
        public static final int RETRIEVE_ID_FIELD_NUMBER = 17;
        public static final int ROLE_TYPE_FIELD_NUMBER = 48;
        public static final int SCENE_FIELD_NUMBER = 9;
        public static final int SHOW_TYPE_FIELD_NUMBER = 61;
        public static final int SOURCE_FIELD_NUMBER = 27;
        public static final int SUB_TYPE_FIELD_NUMBER = 15;
        public static final int SUPER_LIKE_CNT_FIELD_NUMBER = 65;
        public static final int TARGET_UID_FIELD_NUMBER = 4;
        public static final int TIME_FIELD_NUMBER = 18;
        public static final int TITLE_FIELD_NUMBER = 71;
        public static final int TOPIC_FIELD_NUMBER = 7;
        public static final int TYPE_FIELD_NUMBER = 14;
        public static final int VIDEO_ID_FIELD_NUMBER = 39;
        public static final int VIDEO_NUM_FIELD_NUMBER = 38;
        public static final int VOICE_NUM_FIELD_NUMBER = 44;
        public static final int WEIGHT_FIELD_NUMBER = 21;
        private static final long serialVersionUID = 0;
        private volatile Object campaign_;
        private volatile Object cancelType_;
        private int cardNum_;
        private volatile Object cardType_;
        private volatile Object constellationContent_;
        private volatile Object content_;
        private long costTime_;
        private int count_;
        private int coverNum_;
        private volatile Object distance_;
        private int enumType_;
        private int event_;
        private volatile Object expId_;
        private volatile Object from_;
        private volatile Object gameType_;
        private boolean hasPicture_;
        private boolean hasStatus_;
        private boolean hasText_;
        private volatile Object high_;
        private volatile Object id_;
        private volatile Object imageId_;
        private int index_;
        private volatile Object info_;
        private boolean isCloseFriend_;
        private boolean isFollow_;
        private boolean isLikeMe_;
        private boolean isLimitTime_;
        private boolean isLiveShow_;
        private boolean isPostSpread_;
        private boolean isPostTop_;
        private boolean isRecommend_;
        private boolean isShow_;
        private boolean isSpecialAttention_;
        private boolean isSsvipExposure_;
        private boolean isSuccess_;
        private boolean isSuperBoost_;
        private boolean isSuperLike_;
        private boolean isTravel_;
        private boolean isTrue_;
        private boolean isWealthShow_;
        private int maskNum_;
        private volatile Object matchExpId_;
        private volatile Object matchRetrieveId_;
        private volatile Object matchStrategyId_;
        private volatile Object mbti_;
        private byte memoizedIsInitialized;
        private volatile Object modeId_;
        private volatile Object msgType_;
        private volatile Object name_;
        private int num_;
        private volatile Object onlineShowType_;
        private volatile Object ownerUid_;
        private int permission_;
        private volatile Object position_;
        private volatile Object postId_;
        private volatile Object reason_;
        private volatile Object relation_;
        private volatile Object result_;
        private volatile Object retrieveId_;
        private volatile Object roleType_;
        private volatile Object scene_;
        private volatile Object showType_;
        private volatile Object source_;
        private volatile Object subType_;
        private int superLikeCnt_;
        private volatile Object targetUid_;
        private int time_;
        private volatile Object title_;
        private volatile Object topic_;
        private int type_;
        private volatile Object videoId_;
        private int videoNum_;
        private int voiceNum_;
        private volatile Object weight_;
        private static final PostAndSocialProto DEFAULT_INSTANCE = new PostAndSocialProto();
        private static final Parser<PostAndSocialProto> PARSER = new AbstractParser<PostAndSocialProto>() { // from class: com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProto.1
            @Override // com.google.protobuf.Parser
            public PostAndSocialProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PostAndSocialProto(codedInputStream, extensionRegistryLite);
            }
        };

        private PostAndSocialProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static PostAndSocialProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PostAndSocialProtos.internal_static_com_irisdt_client_post_PostAndSocialProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static PostAndSocialProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PostAndSocialProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PostAndSocialProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<PostAndSocialProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PostAndSocialProto)) {
                return super.equals(obj);
            }
            PostAndSocialProto postAndSocialProto = (PostAndSocialProto) obj;
            return this.event_ == postAndSocialProto.event_ && getName().equals(postAndSocialProto.getName()) && getFrom().equals(postAndSocialProto.getFrom()) && getTargetUid().equals(postAndSocialProto.getTargetUid()) && getIsTrue() == postAndSocialProto.getIsTrue() && getContent().equals(postAndSocialProto.getContent()) && getTopic().equals(postAndSocialProto.getTopic()) && getPostId().equals(postAndSocialProto.getPostId()) && getScene().equals(postAndSocialProto.getScene()) && getPosition().equals(postAndSocialProto.getPosition()) && getNum() == postAndSocialProto.getNum() && getIndex() == postAndSocialProto.getIndex() && getId().equals(postAndSocialProto.getId()) && this.type_ == postAndSocialProto.type_ && getSubType().equals(postAndSocialProto.getSubType()) && getExpId().equals(postAndSocialProto.getExpId()) && getRetrieveId().equals(postAndSocialProto.getRetrieveId()) && getTime() == postAndSocialProto.getTime() && getDistance().equals(postAndSocialProto.getDistance()) && getHigh().equals(postAndSocialProto.getHigh()) && getWeight().equals(postAndSocialProto.getWeight()) && getIsRecommend() == postAndSocialProto.getIsRecommend() && getOwnerUid().equals(postAndSocialProto.getOwnerUid()) && getIsShow() == postAndSocialProto.getIsShow() && getModeId().equals(postAndSocialProto.getModeId()) && getIsFollow() == postAndSocialProto.getIsFollow() && getSource().equals(postAndSocialProto.getSource()) && getCampaign().equals(postAndSocialProto.getCampaign()) && getIsSuperLike() == postAndSocialProto.getIsSuperLike() && getMatchExpId().equals(postAndSocialProto.getMatchExpId()) && getMatchRetrieveId().equals(postAndSocialProto.getMatchRetrieveId()) && getMatchStrategyId().equals(postAndSocialProto.getMatchStrategyId()) && getCoverNum() == postAndSocialProto.getCoverNum() && getImageId().equals(postAndSocialProto.getImageId()) && this.enumType_ == postAndSocialProto.enumType_ && getInfo().equals(postAndSocialProto.getInfo()) && getPermission() == postAndSocialProto.getPermission() && getVideoNum() == postAndSocialProto.getVideoNum() && getVideoId().equals(postAndSocialProto.getVideoId()) && getOnlineShowType().equals(postAndSocialProto.getOnlineShowType()) && getIsLikeMe() == postAndSocialProto.getIsLikeMe() && getCostTime() == postAndSocialProto.getCostTime() && getMaskNum() == postAndSocialProto.getMaskNum() && getVoiceNum() == postAndSocialProto.getVoiceNum() && getIsLiveShow() == postAndSocialProto.getIsLiveShow() && getCardType().equals(postAndSocialProto.getCardType()) && getCardNum() == postAndSocialProto.getCardNum() && getRoleType().equals(postAndSocialProto.getRoleType()) && getHasPicture() == postAndSocialProto.getHasPicture() && getHasText() == postAndSocialProto.getHasText() && getHasStatus() == postAndSocialProto.getHasStatus() && getReason().equals(postAndSocialProto.getReason()) && getRelation().equals(postAndSocialProto.getRelation()) && getIsSpecialAttention() == postAndSocialProto.getIsSpecialAttention() && getIsCloseFriend() == postAndSocialProto.getIsCloseFriend() && getIsSuccess() == postAndSocialProto.getIsSuccess() && getMsgType().equals(postAndSocialProto.getMsgType()) && getIsSuperBoost() == postAndSocialProto.getIsSuperBoost() && getCount() == postAndSocialProto.getCount() && getGameType().equals(postAndSocialProto.getGameType()) && getShowType().equals(postAndSocialProto.getShowType()) && getIsWealthShow() == postAndSocialProto.getIsWealthShow() && getIsPostSpread() == postAndSocialProto.getIsPostSpread() && getCancelType().equals(postAndSocialProto.getCancelType()) && getSuperLikeCnt() == postAndSocialProto.getSuperLikeCnt() && getIsPostTop() == postAndSocialProto.getIsPostTop() && getConstellationContent().equals(postAndSocialProto.getConstellationContent()) && getIsSsvipExposure() == postAndSocialProto.getIsSsvipExposure() && getResult().equals(postAndSocialProto.getResult()) && getIsLimitTime() == postAndSocialProto.getIsLimitTime() && getTitle().equals(postAndSocialProto.getTitle()) && getMbti().equals(postAndSocialProto.getMbti()) && getIsTravel() == postAndSocialProto.getIsTravel() && this.unknownFields.equals(postAndSocialProto.unknownFields);
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getCampaign() {
            Object obj = this.campaign_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.campaign_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getCampaignBytes() {
            Object obj = this.campaign_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.campaign_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getCancelType() {
            Object obj = this.cancelType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.cancelType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getCancelTypeBytes() {
            Object obj = this.cancelType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cancelType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getCardNum() {
            return this.cardNum_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getCardType() {
            Object obj = this.cardType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.cardType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getCardTypeBytes() {
            Object obj = this.cardType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cardType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getConstellationContent() {
            Object obj = this.constellationContent_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.constellationContent_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getConstellationContentBytes() {
            Object obj = this.constellationContent_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.constellationContent_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public long getCostTime() {
            return this.costTime_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getCoverNum() {
            return this.coverNum_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getDistance() {
            Object obj = this.distance_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.distance_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getDistanceBytes() {
            Object obj = this.distance_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.distance_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public Enum_type getEnumType() {
            Enum_type valueOf = Enum_type.valueOf(this.enumType_);
            return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getEnumTypeValue() {
            return this.enumType_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            return valueOf == null ? Event.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getExpId() {
            Object obj = this.expId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.expId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getExpIdBytes() {
            Object obj = this.expId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.expId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getFrom() {
            Object obj = this.from_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.from_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getFromBytes() {
            Object obj = this.from_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.from_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getGameType() {
            Object obj = this.gameType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.gameType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getGameTypeBytes() {
            Object obj = this.gameType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.gameType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getHasPicture() {
            return this.hasPicture_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getHasStatus() {
            return this.hasStatus_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getHasText() {
            return this.hasText_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getHigh() {
            Object obj = this.high_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.high_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getHighBytes() {
            Object obj = this.high_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.high_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getImageId() {
            Object obj = this.imageId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imageId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getImageIdBytes() {
            Object obj = this.imageId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imageId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getInfo() {
            Object obj = this.info_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.info_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getInfoBytes() {
            Object obj = this.info_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.info_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsCloseFriend() {
            return this.isCloseFriend_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsFollow() {
            return this.isFollow_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsLikeMe() {
            return this.isLikeMe_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsLimitTime() {
            return this.isLimitTime_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsLiveShow() {
            return this.isLiveShow_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsPostSpread() {
            return this.isPostSpread_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsPostTop() {
            return this.isPostTop_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsRecommend() {
            return this.isRecommend_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsShow() {
            return this.isShow_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsSpecialAttention() {
            return this.isSpecialAttention_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsSsvipExposure() {
            return this.isSsvipExposure_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsSuperBoost() {
            return this.isSuperBoost_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsSuperLike() {
            return this.isSuperLike_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsTravel() {
            return this.isTravel_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsTrue() {
            return this.isTrue_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public boolean getIsWealthShow() {
            return this.isWealthShow_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getMaskNum() {
            return this.maskNum_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getMatchExpId() {
            Object obj = this.matchExpId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.matchExpId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getMatchExpIdBytes() {
            Object obj = this.matchExpId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.matchExpId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getMatchRetrieveId() {
            Object obj = this.matchRetrieveId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.matchRetrieveId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getMatchRetrieveIdBytes() {
            Object obj = this.matchRetrieveId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.matchRetrieveId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getMatchStrategyId() {
            Object obj = this.matchStrategyId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.matchStrategyId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getMatchStrategyIdBytes() {
            Object obj = this.matchStrategyId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.matchStrategyId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getMbti() {
            Object obj = this.mbti_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mbti_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getMbtiBytes() {
            Object obj = this.mbti_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mbti_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getModeId() {
            Object obj = this.modeId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.modeId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getModeIdBytes() {
            Object obj = this.modeId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.modeId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getMsgType() {
            Object obj = this.msgType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.msgType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getMsgTypeBytes() {
            Object obj = this.msgType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.msgType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getNum() {
            return this.num_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getOnlineShowType() {
            Object obj = this.onlineShowType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.onlineShowType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getOnlineShowTypeBytes() {
            Object obj = this.onlineShowType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.onlineShowType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getOwnerUid() {
            Object obj = this.ownerUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.ownerUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getOwnerUidBytes() {
            Object obj = this.ownerUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ownerUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PostAndSocialProto> getParserForType() {
            return PARSER;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getPermission() {
            return this.permission_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getPosition() {
            Object obj = this.position_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.position_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getPositionBytes() {
            Object obj = this.position_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.position_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getPostId() {
            Object obj = this.postId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.postId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getPostIdBytes() {
            Object obj = this.postId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.postId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getReason() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reason_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getReasonBytes() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reason_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getRelation() {
            Object obj = this.relation_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.relation_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getRelationBytes() {
            Object obj = this.relation_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.relation_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getResult() {
            Object obj = this.result_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.result_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getResultBytes() {
            Object obj = this.result_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.result_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getRetrieveId() {
            Object obj = this.retrieveId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.retrieveId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getRetrieveIdBytes() {
            Object obj = this.retrieveId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.retrieveId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getRoleType() {
            Object obj = this.roleType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.roleType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getRoleTypeBytes() {
            Object obj = this.roleType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roleType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getScene() {
            Object obj = this.scene_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.scene_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getSceneBytes() {
            Object obj = this.scene_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.scene_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeEnumSize = this.event_ != Event.UNKNOWN.getNumber() ? 0 + CodedOutputStream.computeEnumSize(1, this.event_) : 0;
            if (!getNameBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(2, this.name_);
            }
            if (!getFromBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(3, this.from_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(4, this.targetUid_);
            }
            boolean z10 = this.isTrue_;
            if (z10) {
                computeEnumSize += CodedOutputStream.computeBoolSize(5, z10);
            }
            if (!getContentBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(6, this.content_);
            }
            if (!getTopicBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(7, this.topic_);
            }
            if (!getPostIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(8, this.postId_);
            }
            if (!getSceneBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(9, this.scene_);
            }
            if (!getPositionBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(10, this.position_);
            }
            int i11 = this.num_;
            if (i11 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(11, i11);
            }
            int i12 = this.index_;
            if (i12 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(12, i12);
            }
            if (!getIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(13, this.id_);
            }
            if (this.type_ != Type.UNKNOWN_TYPE.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(14, this.type_);
            }
            if (!getSubTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(15, this.subType_);
            }
            if (!getExpIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(16, this.expId_);
            }
            if (!getRetrieveIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(17, this.retrieveId_);
            }
            int i13 = this.time_;
            if (i13 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(18, i13);
            }
            if (!getDistanceBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(19, this.distance_);
            }
            if (!getHighBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(20, this.high_);
            }
            if (!getWeightBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(21, this.weight_);
            }
            boolean z11 = this.isRecommend_;
            if (z11) {
                computeEnumSize += CodedOutputStream.computeBoolSize(22, z11);
            }
            if (!getOwnerUidBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(23, this.ownerUid_);
            }
            boolean z12 = this.isShow_;
            if (z12) {
                computeEnumSize += CodedOutputStream.computeBoolSize(24, z12);
            }
            if (!getModeIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(25, this.modeId_);
            }
            boolean z13 = this.isFollow_;
            if (z13) {
                computeEnumSize += CodedOutputStream.computeBoolSize(26, z13);
            }
            if (!getSourceBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(27, this.source_);
            }
            if (!getCampaignBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(28, this.campaign_);
            }
            boolean z14 = this.isSuperLike_;
            if (z14) {
                computeEnumSize += CodedOutputStream.computeBoolSize(29, z14);
            }
            if (!getMatchExpIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(30, this.matchExpId_);
            }
            if (!getMatchRetrieveIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(31, this.matchRetrieveId_);
            }
            if (!getMatchStrategyIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(32, this.matchStrategyId_);
            }
            int i14 = this.coverNum_;
            if (i14 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(33, i14);
            }
            if (!getImageIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(34, this.imageId_);
            }
            if (this.enumType_ != Enum_type.UNKNOWN_ENUM_TYPE.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(35, this.enumType_);
            }
            if (!getInfoBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(36, this.info_);
            }
            int i15 = this.permission_;
            if (i15 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(37, i15);
            }
            int i16 = this.videoNum_;
            if (i16 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(38, i16);
            }
            if (!getVideoIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(39, this.videoId_);
            }
            if (!getOnlineShowTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(40, this.onlineShowType_);
            }
            boolean z15 = this.isLikeMe_;
            if (z15) {
                computeEnumSize += CodedOutputStream.computeBoolSize(41, z15);
            }
            long j10 = this.costTime_;
            if (j10 != 0) {
                computeEnumSize += CodedOutputStream.computeInt64Size(42, j10);
            }
            int i17 = this.maskNum_;
            if (i17 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(43, i17);
            }
            int i18 = this.voiceNum_;
            if (i18 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(44, i18);
            }
            boolean z16 = this.isLiveShow_;
            if (z16) {
                computeEnumSize += CodedOutputStream.computeBoolSize(45, z16);
            }
            if (!getCardTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(46, this.cardType_);
            }
            int i19 = this.cardNum_;
            if (i19 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(47, i19);
            }
            if (!getRoleTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(48, this.roleType_);
            }
            boolean z17 = this.hasPicture_;
            if (z17) {
                computeEnumSize += CodedOutputStream.computeBoolSize(49, z17);
            }
            boolean z18 = this.hasText_;
            if (z18) {
                computeEnumSize += CodedOutputStream.computeBoolSize(50, z18);
            }
            boolean z19 = this.hasStatus_;
            if (z19) {
                computeEnumSize += CodedOutputStream.computeBoolSize(51, z19);
            }
            if (!getReasonBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(52, this.reason_);
            }
            if (!getRelationBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(53, this.relation_);
            }
            boolean z20 = this.isSpecialAttention_;
            if (z20) {
                computeEnumSize += CodedOutputStream.computeBoolSize(54, z20);
            }
            boolean z21 = this.isCloseFriend_;
            if (z21) {
                computeEnumSize += CodedOutputStream.computeBoolSize(55, z21);
            }
            boolean z22 = this.isSuccess_;
            if (z22) {
                computeEnumSize += CodedOutputStream.computeBoolSize(56, z22);
            }
            if (!getMsgTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(57, this.msgType_);
            }
            boolean z23 = this.isSuperBoost_;
            if (z23) {
                computeEnumSize += CodedOutputStream.computeBoolSize(58, z23);
            }
            int i20 = this.count_;
            if (i20 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(59, i20);
            }
            if (!getGameTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(60, this.gameType_);
            }
            if (!getShowTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(61, this.showType_);
            }
            boolean z24 = this.isWealthShow_;
            if (z24) {
                computeEnumSize += CodedOutputStream.computeBoolSize(62, z24);
            }
            boolean z25 = this.isPostSpread_;
            if (z25) {
                computeEnumSize += CodedOutputStream.computeBoolSize(63, z25);
            }
            if (!getCancelTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(64, this.cancelType_);
            }
            int i21 = this.superLikeCnt_;
            if (i21 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(65, i21);
            }
            boolean z26 = this.isPostTop_;
            if (z26) {
                computeEnumSize += CodedOutputStream.computeBoolSize(66, z26);
            }
            if (!getConstellationContentBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(67, this.constellationContent_);
            }
            boolean z27 = this.isSsvipExposure_;
            if (z27) {
                computeEnumSize += CodedOutputStream.computeBoolSize(68, z27);
            }
            if (!getResultBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(69, this.result_);
            }
            boolean z28 = this.isLimitTime_;
            if (z28) {
                computeEnumSize += CodedOutputStream.computeBoolSize(70, z28);
            }
            if (!getTitleBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(71, this.title_);
            }
            if (!getMbtiBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(72, this.mbti_);
            }
            boolean z29 = this.isTravel_;
            if (z29) {
                computeEnumSize += CodedOutputStream.computeBoolSize(73, z29);
            }
            int serializedSize = computeEnumSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getShowType() {
            Object obj = this.showType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.showType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getShowTypeBytes() {
            Object obj = this.showType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.showType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getSource() {
            Object obj = this.source_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.source_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getSourceBytes() {
            Object obj = this.source_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.source_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getSubType() {
            Object obj = this.subType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.subType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getSubTypeBytes() {
            Object obj = this.subType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.subType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getSuperLikeCnt() {
            return this.superLikeCnt_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getTargetUid() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getTargetUidBytes() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getTime() {
            return this.time_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.title_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getTopic() {
            Object obj = this.topic_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.topic_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getTopicBytes() {
            Object obj = this.topic_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.topic_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public Type getType() {
            Type valueOf = Type.valueOf(this.type_);
            return valueOf == null ? Type.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getVideoId() {
            Object obj = this.videoId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.videoId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getVideoIdBytes() {
            Object obj = this.videoId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.videoId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getVideoNum() {
            return this.videoNum_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public int getVoiceNum() {
            return this.voiceNum_;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public String getWeight() {
            Object obj = this.weight_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.weight_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
        public ByteString getWeightBytes() {
            Object obj = this.weight_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.weight_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + getFrom().hashCode()) * 37) + 4) * 53) + getTargetUid().hashCode()) * 37) + 5) * 53) + Internal.hashBoolean(getIsTrue())) * 37) + 6) * 53) + getContent().hashCode()) * 37) + 7) * 53) + getTopic().hashCode()) * 37) + 8) * 53) + getPostId().hashCode()) * 37) + 9) * 53) + getScene().hashCode()) * 37) + 10) * 53) + getPosition().hashCode()) * 37) + 11) * 53) + getNum()) * 37) + 12) * 53) + getIndex()) * 37) + 13) * 53) + getId().hashCode()) * 37) + 14) * 53) + this.type_) * 37) + 15) * 53) + getSubType().hashCode()) * 37) + 16) * 53) + getExpId().hashCode()) * 37) + 17) * 53) + getRetrieveId().hashCode()) * 37) + 18) * 53) + getTime()) * 37) + 19) * 53) + getDistance().hashCode()) * 37) + 20) * 53) + getHigh().hashCode()) * 37) + 21) * 53) + getWeight().hashCode()) * 37) + 22) * 53) + Internal.hashBoolean(getIsRecommend())) * 37) + 23) * 53) + getOwnerUid().hashCode()) * 37) + 24) * 53) + Internal.hashBoolean(getIsShow())) * 37) + 25) * 53) + getModeId().hashCode()) * 37) + 26) * 53) + Internal.hashBoolean(getIsFollow())) * 37) + 27) * 53) + getSource().hashCode()) * 37) + 28) * 53) + getCampaign().hashCode()) * 37) + 29) * 53) + Internal.hashBoolean(getIsSuperLike())) * 37) + 30) * 53) + getMatchExpId().hashCode()) * 37) + 31) * 53) + getMatchRetrieveId().hashCode()) * 37) + 32) * 53) + getMatchStrategyId().hashCode()) * 37) + 33) * 53) + getCoverNum()) * 37) + 34) * 53) + getImageId().hashCode()) * 37) + 35) * 53) + this.enumType_) * 37) + 36) * 53) + getInfo().hashCode()) * 37) + 37) * 53) + getPermission()) * 37) + 38) * 53) + getVideoNum()) * 37) + 39) * 53) + getVideoId().hashCode()) * 37) + 40) * 53) + getOnlineShowType().hashCode()) * 37) + 41) * 53) + Internal.hashBoolean(getIsLikeMe())) * 37) + 42) * 53) + Internal.hashLong(getCostTime())) * 37) + 43) * 53) + getMaskNum()) * 37) + 44) * 53) + getVoiceNum()) * 37) + 45) * 53) + Internal.hashBoolean(getIsLiveShow())) * 37) + 46) * 53) + getCardType().hashCode()) * 37) + 47) * 53) + getCardNum()) * 37) + 48) * 53) + getRoleType().hashCode()) * 37) + 49) * 53) + Internal.hashBoolean(getHasPicture())) * 37) + 50) * 53) + Internal.hashBoolean(getHasText())) * 37) + 51) * 53) + Internal.hashBoolean(getHasStatus())) * 37) + 52) * 53) + getReason().hashCode()) * 37) + 53) * 53) + getRelation().hashCode()) * 37) + 54) * 53) + Internal.hashBoolean(getIsSpecialAttention())) * 37) + 55) * 53) + Internal.hashBoolean(getIsCloseFriend())) * 37) + 56) * 53) + Internal.hashBoolean(getIsSuccess())) * 37) + 57) * 53) + getMsgType().hashCode()) * 37) + 58) * 53) + Internal.hashBoolean(getIsSuperBoost())) * 37) + 59) * 53) + getCount()) * 37) + 60) * 53) + getGameType().hashCode()) * 37) + 61) * 53) + getShowType().hashCode()) * 37) + 62) * 53) + Internal.hashBoolean(getIsWealthShow())) * 37) + 63) * 53) + Internal.hashBoolean(getIsPostSpread())) * 37) + 64) * 53) + getCancelType().hashCode()) * 37) + 65) * 53) + getSuperLikeCnt()) * 37) + 66) * 53) + Internal.hashBoolean(getIsPostTop())) * 37) + 67) * 53) + getConstellationContent().hashCode()) * 37) + 68) * 53) + Internal.hashBoolean(getIsSsvipExposure())) * 37) + 69) * 53) + getResult().hashCode()) * 37) + 70) * 53) + Internal.hashBoolean(getIsLimitTime())) * 37) + 71) * 53) + getTitle().hashCode()) * 37) + 72) * 53) + getMbti().hashCode()) * 37) + 73) * 53) + Internal.hashBoolean(getIsTravel())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PostAndSocialProtos.internal_static_com_irisdt_client_post_PostAndSocialProto_fieldAccessorTable.ensureFieldAccessorsInitialized(PostAndSocialProto.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new PostAndSocialProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.event_ != Event.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(1, this.event_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
            }
            if (!getFromBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.from_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.targetUid_);
            }
            boolean z10 = this.isTrue_;
            if (z10) {
                codedOutputStream.writeBool(5, z10);
            }
            if (!getContentBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.content_);
            }
            if (!getTopicBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.topic_);
            }
            if (!getPostIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.postId_);
            }
            if (!getSceneBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.scene_);
            }
            if (!getPositionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.position_);
            }
            int i10 = this.num_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(11, i10);
            }
            int i11 = this.index_;
            if (i11 != 0) {
                codedOutputStream.writeInt32(12, i11);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.id_);
            }
            if (this.type_ != Type.UNKNOWN_TYPE.getNumber()) {
                codedOutputStream.writeEnum(14, this.type_);
            }
            if (!getSubTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 15, this.subType_);
            }
            if (!getExpIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 16, this.expId_);
            }
            if (!getRetrieveIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 17, this.retrieveId_);
            }
            int i12 = this.time_;
            if (i12 != 0) {
                codedOutputStream.writeInt32(18, i12);
            }
            if (!getDistanceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 19, this.distance_);
            }
            if (!getHighBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 20, this.high_);
            }
            if (!getWeightBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 21, this.weight_);
            }
            boolean z11 = this.isRecommend_;
            if (z11) {
                codedOutputStream.writeBool(22, z11);
            }
            if (!getOwnerUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 23, this.ownerUid_);
            }
            boolean z12 = this.isShow_;
            if (z12) {
                codedOutputStream.writeBool(24, z12);
            }
            if (!getModeIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 25, this.modeId_);
            }
            boolean z13 = this.isFollow_;
            if (z13) {
                codedOutputStream.writeBool(26, z13);
            }
            if (!getSourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 27, this.source_);
            }
            if (!getCampaignBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 28, this.campaign_);
            }
            boolean z14 = this.isSuperLike_;
            if (z14) {
                codedOutputStream.writeBool(29, z14);
            }
            if (!getMatchExpIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 30, this.matchExpId_);
            }
            if (!getMatchRetrieveIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 31, this.matchRetrieveId_);
            }
            if (!getMatchStrategyIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 32, this.matchStrategyId_);
            }
            int i13 = this.coverNum_;
            if (i13 != 0) {
                codedOutputStream.writeInt32(33, i13);
            }
            if (!getImageIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 34, this.imageId_);
            }
            if (this.enumType_ != Enum_type.UNKNOWN_ENUM_TYPE.getNumber()) {
                codedOutputStream.writeEnum(35, this.enumType_);
            }
            if (!getInfoBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 36, this.info_);
            }
            int i14 = this.permission_;
            if (i14 != 0) {
                codedOutputStream.writeInt32(37, i14);
            }
            int i15 = this.videoNum_;
            if (i15 != 0) {
                codedOutputStream.writeInt32(38, i15);
            }
            if (!getVideoIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 39, this.videoId_);
            }
            if (!getOnlineShowTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 40, this.onlineShowType_);
            }
            boolean z15 = this.isLikeMe_;
            if (z15) {
                codedOutputStream.writeBool(41, z15);
            }
            long j10 = this.costTime_;
            if (j10 != 0) {
                codedOutputStream.writeInt64(42, j10);
            }
            int i16 = this.maskNum_;
            if (i16 != 0) {
                codedOutputStream.writeInt32(43, i16);
            }
            int i17 = this.voiceNum_;
            if (i17 != 0) {
                codedOutputStream.writeInt32(44, i17);
            }
            boolean z16 = this.isLiveShow_;
            if (z16) {
                codedOutputStream.writeBool(45, z16);
            }
            if (!getCardTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 46, this.cardType_);
            }
            int i18 = this.cardNum_;
            if (i18 != 0) {
                codedOutputStream.writeInt32(47, i18);
            }
            if (!getRoleTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 48, this.roleType_);
            }
            boolean z17 = this.hasPicture_;
            if (z17) {
                codedOutputStream.writeBool(49, z17);
            }
            boolean z18 = this.hasText_;
            if (z18) {
                codedOutputStream.writeBool(50, z18);
            }
            boolean z19 = this.hasStatus_;
            if (z19) {
                codedOutputStream.writeBool(51, z19);
            }
            if (!getReasonBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 52, this.reason_);
            }
            if (!getRelationBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 53, this.relation_);
            }
            boolean z20 = this.isSpecialAttention_;
            if (z20) {
                codedOutputStream.writeBool(54, z20);
            }
            boolean z21 = this.isCloseFriend_;
            if (z21) {
                codedOutputStream.writeBool(55, z21);
            }
            boolean z22 = this.isSuccess_;
            if (z22) {
                codedOutputStream.writeBool(56, z22);
            }
            if (!getMsgTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 57, this.msgType_);
            }
            boolean z23 = this.isSuperBoost_;
            if (z23) {
                codedOutputStream.writeBool(58, z23);
            }
            int i19 = this.count_;
            if (i19 != 0) {
                codedOutputStream.writeInt32(59, i19);
            }
            if (!getGameTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 60, this.gameType_);
            }
            if (!getShowTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 61, this.showType_);
            }
            boolean z24 = this.isWealthShow_;
            if (z24) {
                codedOutputStream.writeBool(62, z24);
            }
            boolean z25 = this.isPostSpread_;
            if (z25) {
                codedOutputStream.writeBool(63, z25);
            }
            if (!getCancelTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 64, this.cancelType_);
            }
            int i20 = this.superLikeCnt_;
            if (i20 != 0) {
                codedOutputStream.writeInt32(65, i20);
            }
            boolean z26 = this.isPostTop_;
            if (z26) {
                codedOutputStream.writeBool(66, z26);
            }
            if (!getConstellationContentBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 67, this.constellationContent_);
            }
            boolean z27 = this.isSsvipExposure_;
            if (z27) {
                codedOutputStream.writeBool(68, z27);
            }
            if (!getResultBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 69, this.result_);
            }
            boolean z28 = this.isLimitTime_;
            if (z28) {
                codedOutputStream.writeBool(70, z28);
            }
            if (!getTitleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 71, this.title_);
            }
            if (!getMbtiBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 72, this.mbti_);
            }
            boolean z29 = this.isTravel_;
            if (z29) {
                codedOutputStream.writeBool(73, z29);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PostAndSocialProtoOrBuilder {
            private Object campaign_;
            private Object cancelType_;
            private int cardNum_;
            private Object cardType_;
            private Object constellationContent_;
            private Object content_;
            private long costTime_;
            private int count_;
            private int coverNum_;
            private Object distance_;
            private int enumType_;
            private int event_;
            private Object expId_;
            private Object from_;
            private Object gameType_;
            private boolean hasPicture_;
            private boolean hasStatus_;
            private boolean hasText_;
            private Object high_;
            private Object id_;
            private Object imageId_;
            private int index_;
            private Object info_;
            private boolean isCloseFriend_;
            private boolean isFollow_;
            private boolean isLikeMe_;
            private boolean isLimitTime_;
            private boolean isLiveShow_;
            private boolean isPostSpread_;
            private boolean isPostTop_;
            private boolean isRecommend_;
            private boolean isShow_;
            private boolean isSpecialAttention_;
            private boolean isSsvipExposure_;
            private boolean isSuccess_;
            private boolean isSuperBoost_;
            private boolean isSuperLike_;
            private boolean isTravel_;
            private boolean isTrue_;
            private boolean isWealthShow_;
            private int maskNum_;
            private Object matchExpId_;
            private Object matchRetrieveId_;
            private Object matchStrategyId_;
            private Object mbti_;
            private Object modeId_;
            private Object msgType_;
            private Object name_;
            private int num_;
            private Object onlineShowType_;
            private Object ownerUid_;
            private int permission_;
            private Object position_;
            private Object postId_;
            private Object reason_;
            private Object relation_;
            private Object result_;
            private Object retrieveId_;
            private Object roleType_;
            private Object scene_;
            private Object showType_;
            private Object source_;
            private Object subType_;
            private int superLikeCnt_;
            private Object targetUid_;
            private int time_;
            private Object title_;
            private Object topic_;
            private int type_;
            private Object videoId_;
            private int videoNum_;
            private int voiceNum_;
            private Object weight_;

            private Builder() {
                this.event_ = 0;
                this.name_ = "";
                this.from_ = "";
                this.targetUid_ = "";
                this.content_ = "";
                this.topic_ = "";
                this.postId_ = "";
                this.scene_ = "";
                this.position_ = "";
                this.id_ = "";
                this.type_ = 0;
                this.subType_ = "";
                this.expId_ = "";
                this.retrieveId_ = "";
                this.distance_ = "";
                this.high_ = "";
                this.weight_ = "";
                this.ownerUid_ = "";
                this.modeId_ = "";
                this.source_ = "";
                this.campaign_ = "";
                this.matchExpId_ = "";
                this.matchRetrieveId_ = "";
                this.matchStrategyId_ = "";
                this.imageId_ = "";
                this.enumType_ = 0;
                this.info_ = "";
                this.videoId_ = "";
                this.onlineShowType_ = "";
                this.cardType_ = "";
                this.roleType_ = "";
                this.reason_ = "";
                this.relation_ = "";
                this.msgType_ = "";
                this.gameType_ = "";
                this.showType_ = "";
                this.cancelType_ = "";
                this.constellationContent_ = "";
                this.result_ = "";
                this.title_ = "";
                this.mbti_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PostAndSocialProtos.internal_static_com_irisdt_client_post_PostAndSocialProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearCampaign() {
                this.campaign_ = PostAndSocialProto.getDefaultInstance().getCampaign();
                onChanged();
                return this;
            }

            public Builder clearCancelType() {
                this.cancelType_ = PostAndSocialProto.getDefaultInstance().getCancelType();
                onChanged();
                return this;
            }

            public Builder clearCardNum() {
                this.cardNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearCardType() {
                this.cardType_ = PostAndSocialProto.getDefaultInstance().getCardType();
                onChanged();
                return this;
            }

            public Builder clearConstellationContent() {
                this.constellationContent_ = PostAndSocialProto.getDefaultInstance().getConstellationContent();
                onChanged();
                return this;
            }

            public Builder clearContent() {
                this.content_ = PostAndSocialProto.getDefaultInstance().getContent();
                onChanged();
                return this;
            }

            public Builder clearCostTime() {
                this.costTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
                onChanged();
                return this;
            }

            public Builder clearCoverNum() {
                this.coverNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearDistance() {
                this.distance_ = PostAndSocialProto.getDefaultInstance().getDistance();
                onChanged();
                return this;
            }

            public Builder clearEnumType() {
                this.enumType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            public Builder clearExpId() {
                this.expId_ = PostAndSocialProto.getDefaultInstance().getExpId();
                onChanged();
                return this;
            }

            public Builder clearFrom() {
                this.from_ = PostAndSocialProto.getDefaultInstance().getFrom();
                onChanged();
                return this;
            }

            public Builder clearGameType() {
                this.gameType_ = PostAndSocialProto.getDefaultInstance().getGameType();
                onChanged();
                return this;
            }

            public Builder clearHasPicture() {
                this.hasPicture_ = false;
                onChanged();
                return this;
            }

            public Builder clearHasStatus() {
                this.hasStatus_ = false;
                onChanged();
                return this;
            }

            public Builder clearHasText() {
                this.hasText_ = false;
                onChanged();
                return this;
            }

            public Builder clearHigh() {
                this.high_ = PostAndSocialProto.getDefaultInstance().getHigh();
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = PostAndSocialProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearImageId() {
                this.imageId_ = PostAndSocialProto.getDefaultInstance().getImageId();
                onChanged();
                return this;
            }

            public Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public Builder clearInfo() {
                this.info_ = PostAndSocialProto.getDefaultInstance().getInfo();
                onChanged();
                return this;
            }

            public Builder clearIsCloseFriend() {
                this.isCloseFriend_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsFollow() {
                this.isFollow_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsLikeMe() {
                this.isLikeMe_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsLimitTime() {
                this.isLimitTime_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsLiveShow() {
                this.isLiveShow_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsPostSpread() {
                this.isPostSpread_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsPostTop() {
                this.isPostTop_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsRecommend() {
                this.isRecommend_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsShow() {
                this.isShow_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsSpecialAttention() {
                this.isSpecialAttention_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsSsvipExposure() {
                this.isSsvipExposure_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsSuccess() {
                this.isSuccess_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsSuperBoost() {
                this.isSuperBoost_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsSuperLike() {
                this.isSuperLike_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTravel() {
                this.isTravel_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTrue() {
                this.isTrue_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsWealthShow() {
                this.isWealthShow_ = false;
                onChanged();
                return this;
            }

            public Builder clearMaskNum() {
                this.maskNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMatchExpId() {
                this.matchExpId_ = PostAndSocialProto.getDefaultInstance().getMatchExpId();
                onChanged();
                return this;
            }

            public Builder clearMatchRetrieveId() {
                this.matchRetrieveId_ = PostAndSocialProto.getDefaultInstance().getMatchRetrieveId();
                onChanged();
                return this;
            }

            public Builder clearMatchStrategyId() {
                this.matchStrategyId_ = PostAndSocialProto.getDefaultInstance().getMatchStrategyId();
                onChanged();
                return this;
            }

            public Builder clearMbti() {
                this.mbti_ = PostAndSocialProto.getDefaultInstance().getMbti();
                onChanged();
                return this;
            }

            public Builder clearModeId() {
                this.modeId_ = PostAndSocialProto.getDefaultInstance().getModeId();
                onChanged();
                return this;
            }

            public Builder clearMsgType() {
                this.msgType_ = PostAndSocialProto.getDefaultInstance().getMsgType();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = PostAndSocialProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.num_ = 0;
                onChanged();
                return this;
            }

            public Builder clearOnlineShowType() {
                this.onlineShowType_ = PostAndSocialProto.getDefaultInstance().getOnlineShowType();
                onChanged();
                return this;
            }

            public Builder clearOwnerUid() {
                this.ownerUid_ = PostAndSocialProto.getDefaultInstance().getOwnerUid();
                onChanged();
                return this;
            }

            public Builder clearPermission() {
                this.permission_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPosition() {
                this.position_ = PostAndSocialProto.getDefaultInstance().getPosition();
                onChanged();
                return this;
            }

            public Builder clearPostId() {
                this.postId_ = PostAndSocialProto.getDefaultInstance().getPostId();
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = PostAndSocialProto.getDefaultInstance().getReason();
                onChanged();
                return this;
            }

            public Builder clearRelation() {
                this.relation_ = PostAndSocialProto.getDefaultInstance().getRelation();
                onChanged();
                return this;
            }

            public Builder clearResult() {
                this.result_ = PostAndSocialProto.getDefaultInstance().getResult();
                onChanged();
                return this;
            }

            public Builder clearRetrieveId() {
                this.retrieveId_ = PostAndSocialProto.getDefaultInstance().getRetrieveId();
                onChanged();
                return this;
            }

            public Builder clearRoleType() {
                this.roleType_ = PostAndSocialProto.getDefaultInstance().getRoleType();
                onChanged();
                return this;
            }

            public Builder clearScene() {
                this.scene_ = PostAndSocialProto.getDefaultInstance().getScene();
                onChanged();
                return this;
            }

            public Builder clearShowType() {
                this.showType_ = PostAndSocialProto.getDefaultInstance().getShowType();
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.source_ = PostAndSocialProto.getDefaultInstance().getSource();
                onChanged();
                return this;
            }

            public Builder clearSubType() {
                this.subType_ = PostAndSocialProto.getDefaultInstance().getSubType();
                onChanged();
                return this;
            }

            public Builder clearSuperLikeCnt() {
                this.superLikeCnt_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = PostAndSocialProto.getDefaultInstance().getTargetUid();
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTitle() {
                this.title_ = PostAndSocialProto.getDefaultInstance().getTitle();
                onChanged();
                return this;
            }

            public Builder clearTopic() {
                this.topic_ = PostAndSocialProto.getDefaultInstance().getTopic();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVideoId() {
                this.videoId_ = PostAndSocialProto.getDefaultInstance().getVideoId();
                onChanged();
                return this;
            }

            public Builder clearVideoNum() {
                this.videoNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVoiceNum() {
                this.voiceNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearWeight() {
                this.weight_ = PostAndSocialProto.getDefaultInstance().getWeight();
                onChanged();
                return this;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getCampaign() {
                Object obj = this.campaign_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.campaign_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getCampaignBytes() {
                Object obj = this.campaign_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.campaign_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getCancelType() {
                Object obj = this.cancelType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.cancelType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getCancelTypeBytes() {
                Object obj = this.cancelType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.cancelType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getCardNum() {
                return this.cardNum_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getCardType() {
                Object obj = this.cardType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.cardType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getCardTypeBytes() {
                Object obj = this.cardType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.cardType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getConstellationContent() {
                Object obj = this.constellationContent_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.constellationContent_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getConstellationContentBytes() {
                Object obj = this.constellationContent_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.constellationContent_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getContent() {
                Object obj = this.content_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.content_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getContentBytes() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.content_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public long getCostTime() {
                return this.costTime_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getCount() {
                return this.count_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getCoverNum() {
                return this.coverNum_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PostAndSocialProtos.internal_static_com_irisdt_client_post_PostAndSocialProto_descriptor;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getDistance() {
                Object obj = this.distance_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.distance_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getDistanceBytes() {
                Object obj = this.distance_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.distance_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public Enum_type getEnumType() {
                Enum_type valueOf = Enum_type.valueOf(this.enumType_);
                return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getEnumTypeValue() {
                return this.enumType_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                return valueOf == null ? Event.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getExpId() {
                Object obj = this.expId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.expId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getExpIdBytes() {
                Object obj = this.expId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.expId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getFrom() {
                Object obj = this.from_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.from_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getFromBytes() {
                Object obj = this.from_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.from_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getGameType() {
                Object obj = this.gameType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.gameType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getGameTypeBytes() {
                Object obj = this.gameType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.gameType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getHasPicture() {
                return this.hasPicture_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getHasStatus() {
                return this.hasStatus_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getHasText() {
                return this.hasText_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getHigh() {
                Object obj = this.high_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.high_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getHighBytes() {
                Object obj = this.high_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.high_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.id_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getImageId() {
                Object obj = this.imageId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.imageId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getImageIdBytes() {
                Object obj = this.imageId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.imageId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getIndex() {
                return this.index_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getInfo() {
                Object obj = this.info_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.info_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getInfoBytes() {
                Object obj = this.info_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.info_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsCloseFriend() {
                return this.isCloseFriend_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsFollow() {
                return this.isFollow_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsLikeMe() {
                return this.isLikeMe_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsLimitTime() {
                return this.isLimitTime_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsLiveShow() {
                return this.isLiveShow_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsPostSpread() {
                return this.isPostSpread_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsPostTop() {
                return this.isPostTop_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsRecommend() {
                return this.isRecommend_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsShow() {
                return this.isShow_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsSpecialAttention() {
                return this.isSpecialAttention_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsSsvipExposure() {
                return this.isSsvipExposure_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsSuccess() {
                return this.isSuccess_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsSuperBoost() {
                return this.isSuperBoost_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsSuperLike() {
                return this.isSuperLike_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsTravel() {
                return this.isTravel_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsTrue() {
                return this.isTrue_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public boolean getIsWealthShow() {
                return this.isWealthShow_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getMaskNum() {
                return this.maskNum_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getMatchExpId() {
                Object obj = this.matchExpId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.matchExpId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getMatchExpIdBytes() {
                Object obj = this.matchExpId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.matchExpId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getMatchRetrieveId() {
                Object obj = this.matchRetrieveId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.matchRetrieveId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getMatchRetrieveIdBytes() {
                Object obj = this.matchRetrieveId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.matchRetrieveId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getMatchStrategyId() {
                Object obj = this.matchStrategyId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.matchStrategyId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getMatchStrategyIdBytes() {
                Object obj = this.matchStrategyId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.matchStrategyId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getMbti() {
                Object obj = this.mbti_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.mbti_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getMbtiBytes() {
                Object obj = this.mbti_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mbti_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getModeId() {
                Object obj = this.modeId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.modeId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getModeIdBytes() {
                Object obj = this.modeId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.modeId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getMsgType() {
                Object obj = this.msgType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.msgType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getMsgTypeBytes() {
                Object obj = this.msgType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.msgType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.name_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getNum() {
                return this.num_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getOnlineShowType() {
                Object obj = this.onlineShowType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.onlineShowType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getOnlineShowTypeBytes() {
                Object obj = this.onlineShowType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.onlineShowType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getOwnerUid() {
                Object obj = this.ownerUid_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.ownerUid_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getOwnerUidBytes() {
                Object obj = this.ownerUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ownerUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getPermission() {
                return this.permission_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getPosition() {
                Object obj = this.position_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.position_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getPositionBytes() {
                Object obj = this.position_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.position_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getPostId() {
                Object obj = this.postId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.postId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getPostIdBytes() {
                Object obj = this.postId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.postId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getReason() {
                Object obj = this.reason_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.reason_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getReasonBytes() {
                Object obj = this.reason_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reason_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getRelation() {
                Object obj = this.relation_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.relation_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getRelationBytes() {
                Object obj = this.relation_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.relation_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getResult() {
                Object obj = this.result_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.result_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getResultBytes() {
                Object obj = this.result_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.result_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getRetrieveId() {
                Object obj = this.retrieveId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.retrieveId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getRetrieveIdBytes() {
                Object obj = this.retrieveId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.retrieveId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getRoleType() {
                Object obj = this.roleType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.roleType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getRoleTypeBytes() {
                Object obj = this.roleType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.roleType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getScene() {
                Object obj = this.scene_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.scene_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getSceneBytes() {
                Object obj = this.scene_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.scene_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getShowType() {
                Object obj = this.showType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.showType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getShowTypeBytes() {
                Object obj = this.showType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.showType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getSource() {
                Object obj = this.source_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.source_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getSourceBytes() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.source_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getSubType() {
                Object obj = this.subType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.subType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getSubTypeBytes() {
                Object obj = this.subType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.subType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getSuperLikeCnt() {
                return this.superLikeCnt_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getTargetUid() {
                Object obj = this.targetUid_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.targetUid_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getTargetUidBytes() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getTime() {
                return this.time_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getTitle() {
                Object obj = this.title_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.title_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getTitleBytes() {
                Object obj = this.title_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.title_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getTopic() {
                Object obj = this.topic_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.topic_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getTopicBytes() {
                Object obj = this.topic_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.topic_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public Type getType() {
                Type valueOf = Type.valueOf(this.type_);
                return valueOf == null ? Type.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getVideoId() {
                Object obj = this.videoId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.videoId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getVideoIdBytes() {
                Object obj = this.videoId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.videoId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getVideoNum() {
                return this.videoNum_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public int getVoiceNum() {
                return this.voiceNum_;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public String getWeight() {
                Object obj = this.weight_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.weight_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProtoOrBuilder
            public ByteString getWeightBytes() {
                Object obj = this.weight_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.weight_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PostAndSocialProtos.internal_static_com_irisdt_client_post_PostAndSocialProto_fieldAccessorTable.ensureFieldAccessorsInitialized(PostAndSocialProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setCampaign(String str) {
                Objects.requireNonNull(str);
                this.campaign_ = str;
                onChanged();
                return this;
            }

            public Builder setCampaignBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.campaign_ = byteString;
                onChanged();
                return this;
            }

            public Builder setCancelType(String str) {
                Objects.requireNonNull(str);
                this.cancelType_ = str;
                onChanged();
                return this;
            }

            public Builder setCancelTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.cancelType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setCardNum(int i10) {
                this.cardNum_ = i10;
                onChanged();
                return this;
            }

            public Builder setCardType(String str) {
                Objects.requireNonNull(str);
                this.cardType_ = str;
                onChanged();
                return this;
            }

            public Builder setCardTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.cardType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setConstellationContent(String str) {
                Objects.requireNonNull(str);
                this.constellationContent_ = str;
                onChanged();
                return this;
            }

            public Builder setConstellationContentBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.constellationContent_ = byteString;
                onChanged();
                return this;
            }

            public Builder setContent(String str) {
                Objects.requireNonNull(str);
                this.content_ = str;
                onChanged();
                return this;
            }

            public Builder setContentBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.content_ = byteString;
                onChanged();
                return this;
            }

            public Builder setCostTime(long j10) {
                this.costTime_ = j10;
                onChanged();
                return this;
            }

            public Builder setCount(int i10) {
                this.count_ = i10;
                onChanged();
                return this;
            }

            public Builder setCoverNum(int i10) {
                this.coverNum_ = i10;
                onChanged();
                return this;
            }

            public Builder setDistance(String str) {
                Objects.requireNonNull(str);
                this.distance_ = str;
                onChanged();
                return this;
            }

            public Builder setDistanceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.distance_ = byteString;
                onChanged();
                return this;
            }

            public Builder setEnumType(Enum_type enum_type) {
                Objects.requireNonNull(enum_type);
                this.enumType_ = enum_type.getNumber();
                onChanged();
                return this;
            }

            public Builder setEnumTypeValue(int i10) {
                this.enumType_ = i10;
                onChanged();
                return this;
            }

            public Builder setEvent(Event event) {
                Objects.requireNonNull(event);
                this.event_ = event.getNumber();
                onChanged();
                return this;
            }

            public Builder setEventValue(int i10) {
                this.event_ = i10;
                onChanged();
                return this;
            }

            public Builder setExpId(String str) {
                Objects.requireNonNull(str);
                this.expId_ = str;
                onChanged();
                return this;
            }

            public Builder setExpIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.expId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFrom(String str) {
                Objects.requireNonNull(str);
                this.from_ = str;
                onChanged();
                return this;
            }

            public Builder setFromBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.from_ = byteString;
                onChanged();
                return this;
            }

            public Builder setGameType(String str) {
                Objects.requireNonNull(str);
                this.gameType_ = str;
                onChanged();
                return this;
            }

            public Builder setGameTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.gameType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setHasPicture(boolean z10) {
                this.hasPicture_ = z10;
                onChanged();
                return this;
            }

            public Builder setHasStatus(boolean z10) {
                this.hasStatus_ = z10;
                onChanged();
                return this;
            }

            public Builder setHasText(boolean z10) {
                this.hasText_ = z10;
                onChanged();
                return this;
            }

            public Builder setHigh(String str) {
                Objects.requireNonNull(str);
                this.high_ = str;
                onChanged();
                return this;
            }

            public Builder setHighBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.high_ = byteString;
                onChanged();
                return this;
            }

            public Builder setId(String str) {
                Objects.requireNonNull(str);
                this.id_ = str;
                onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.id_ = byteString;
                onChanged();
                return this;
            }

            public Builder setImageId(String str) {
                Objects.requireNonNull(str);
                this.imageId_ = str;
                onChanged();
                return this;
            }

            public Builder setImageIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.imageId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setIndex(int i10) {
                this.index_ = i10;
                onChanged();
                return this;
            }

            public Builder setInfo(String str) {
                Objects.requireNonNull(str);
                this.info_ = str;
                onChanged();
                return this;
            }

            public Builder setInfoBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.info_ = byteString;
                onChanged();
                return this;
            }

            public Builder setIsCloseFriend(boolean z10) {
                this.isCloseFriend_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsFollow(boolean z10) {
                this.isFollow_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsLikeMe(boolean z10) {
                this.isLikeMe_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsLimitTime(boolean z10) {
                this.isLimitTime_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsLiveShow(boolean z10) {
                this.isLiveShow_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsPostSpread(boolean z10) {
                this.isPostSpread_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsPostTop(boolean z10) {
                this.isPostTop_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsRecommend(boolean z10) {
                this.isRecommend_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsShow(boolean z10) {
                this.isShow_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsSpecialAttention(boolean z10) {
                this.isSpecialAttention_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsSsvipExposure(boolean z10) {
                this.isSsvipExposure_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsSuccess(boolean z10) {
                this.isSuccess_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsSuperBoost(boolean z10) {
                this.isSuperBoost_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsSuperLike(boolean z10) {
                this.isSuperLike_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsTravel(boolean z10) {
                this.isTravel_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsTrue(boolean z10) {
                this.isTrue_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsWealthShow(boolean z10) {
                this.isWealthShow_ = z10;
                onChanged();
                return this;
            }

            public Builder setMaskNum(int i10) {
                this.maskNum_ = i10;
                onChanged();
                return this;
            }

            public Builder setMatchExpId(String str) {
                Objects.requireNonNull(str);
                this.matchExpId_ = str;
                onChanged();
                return this;
            }

            public Builder setMatchExpIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.matchExpId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setMatchRetrieveId(String str) {
                Objects.requireNonNull(str);
                this.matchRetrieveId_ = str;
                onChanged();
                return this;
            }

            public Builder setMatchRetrieveIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.matchRetrieveId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setMatchStrategyId(String str) {
                Objects.requireNonNull(str);
                this.matchStrategyId_ = str;
                onChanged();
                return this;
            }

            public Builder setMatchStrategyIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.matchStrategyId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setMbti(String str) {
                Objects.requireNonNull(str);
                this.mbti_ = str;
                onChanged();
                return this;
            }

            public Builder setMbtiBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.mbti_ = byteString;
                onChanged();
                return this;
            }

            public Builder setModeId(String str) {
                Objects.requireNonNull(str);
                this.modeId_ = str;
                onChanged();
                return this;
            }

            public Builder setModeIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.modeId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setMsgType(String str) {
                Objects.requireNonNull(str);
                this.msgType_ = str;
                onChanged();
                return this;
            }

            public Builder setMsgTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.msgType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setName(String str) {
                Objects.requireNonNull(str);
                this.name_ = str;
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }

            public Builder setNum(int i10) {
                this.num_ = i10;
                onChanged();
                return this;
            }

            public Builder setOnlineShowType(String str) {
                Objects.requireNonNull(str);
                this.onlineShowType_ = str;
                onChanged();
                return this;
            }

            public Builder setOnlineShowTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.onlineShowType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setOwnerUid(String str) {
                Objects.requireNonNull(str);
                this.ownerUid_ = str;
                onChanged();
                return this;
            }

            public Builder setOwnerUidBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.ownerUid_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPermission(int i10) {
                this.permission_ = i10;
                onChanged();
                return this;
            }

            public Builder setPosition(String str) {
                Objects.requireNonNull(str);
                this.position_ = str;
                onChanged();
                return this;
            }

            public Builder setPositionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.position_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPostId(String str) {
                Objects.requireNonNull(str);
                this.postId_ = str;
                onChanged();
                return this;
            }

            public Builder setPostIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.postId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setReason(String str) {
                Objects.requireNonNull(str);
                this.reason_ = str;
                onChanged();
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.reason_ = byteString;
                onChanged();
                return this;
            }

            public Builder setRelation(String str) {
                Objects.requireNonNull(str);
                this.relation_ = str;
                onChanged();
                return this;
            }

            public Builder setRelationBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.relation_ = byteString;
                onChanged();
                return this;
            }

            public Builder setResult(String str) {
                Objects.requireNonNull(str);
                this.result_ = str;
                onChanged();
                return this;
            }

            public Builder setResultBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.result_ = byteString;
                onChanged();
                return this;
            }

            public Builder setRetrieveId(String str) {
                Objects.requireNonNull(str);
                this.retrieveId_ = str;
                onChanged();
                return this;
            }

            public Builder setRetrieveIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.retrieveId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setRoleType(String str) {
                Objects.requireNonNull(str);
                this.roleType_ = str;
                onChanged();
                return this;
            }

            public Builder setRoleTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.roleType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setScene(String str) {
                Objects.requireNonNull(str);
                this.scene_ = str;
                onChanged();
                return this;
            }

            public Builder setSceneBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.scene_ = byteString;
                onChanged();
                return this;
            }

            public Builder setShowType(String str) {
                Objects.requireNonNull(str);
                this.showType_ = str;
                onChanged();
                return this;
            }

            public Builder setShowTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.showType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSource(String str) {
                Objects.requireNonNull(str);
                this.source_ = str;
                onChanged();
                return this;
            }

            public Builder setSourceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.source_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSubType(String str) {
                Objects.requireNonNull(str);
                this.subType_ = str;
                onChanged();
                return this;
            }

            public Builder setSubTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.subType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSuperLikeCnt(int i10) {
                this.superLikeCnt_ = i10;
                onChanged();
                return this;
            }

            public Builder setTargetUid(String str) {
                Objects.requireNonNull(str);
                this.targetUid_ = str;
                onChanged();
                return this;
            }

            public Builder setTargetUidBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.targetUid_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTime(int i10) {
                this.time_ = i10;
                onChanged();
                return this;
            }

            public Builder setTitle(String str) {
                Objects.requireNonNull(str);
                this.title_ = str;
                onChanged();
                return this;
            }

            public Builder setTitleBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.title_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTopic(String str) {
                Objects.requireNonNull(str);
                this.topic_ = str;
                onChanged();
                return this;
            }

            public Builder setTopicBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.topic_ = byteString;
                onChanged();
                return this;
            }

            public Builder setType(Type type) {
                Objects.requireNonNull(type);
                this.type_ = type.getNumber();
                onChanged();
                return this;
            }

            public Builder setTypeValue(int i10) {
                this.type_ = i10;
                onChanged();
                return this;
            }

            public Builder setVideoId(String str) {
                Objects.requireNonNull(str);
                this.videoId_ = str;
                onChanged();
                return this;
            }

            public Builder setVideoIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.videoId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setVideoNum(int i10) {
                this.videoNum_ = i10;
                onChanged();
                return this;
            }

            public Builder setVoiceNum(int i10) {
                this.voiceNum_ = i10;
                onChanged();
                return this;
            }

            public Builder setWeight(String str) {
                Objects.requireNonNull(str);
                this.weight_ = str;
                onChanged();
                return this;
            }

            public Builder setWeightBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.weight_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PostAndSocialProto build() {
                PostAndSocialProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PostAndSocialProto buildPartial() {
                PostAndSocialProto postAndSocialProto = new PostAndSocialProto(this);
                postAndSocialProto.event_ = this.event_;
                postAndSocialProto.name_ = this.name_;
                postAndSocialProto.from_ = this.from_;
                postAndSocialProto.targetUid_ = this.targetUid_;
                postAndSocialProto.isTrue_ = this.isTrue_;
                postAndSocialProto.content_ = this.content_;
                postAndSocialProto.topic_ = this.topic_;
                postAndSocialProto.postId_ = this.postId_;
                postAndSocialProto.scene_ = this.scene_;
                postAndSocialProto.position_ = this.position_;
                postAndSocialProto.num_ = this.num_;
                postAndSocialProto.index_ = this.index_;
                postAndSocialProto.id_ = this.id_;
                postAndSocialProto.type_ = this.type_;
                postAndSocialProto.subType_ = this.subType_;
                postAndSocialProto.expId_ = this.expId_;
                postAndSocialProto.retrieveId_ = this.retrieveId_;
                postAndSocialProto.time_ = this.time_;
                postAndSocialProto.distance_ = this.distance_;
                postAndSocialProto.high_ = this.high_;
                postAndSocialProto.weight_ = this.weight_;
                postAndSocialProto.isRecommend_ = this.isRecommend_;
                postAndSocialProto.ownerUid_ = this.ownerUid_;
                postAndSocialProto.isShow_ = this.isShow_;
                postAndSocialProto.modeId_ = this.modeId_;
                postAndSocialProto.isFollow_ = this.isFollow_;
                postAndSocialProto.source_ = this.source_;
                postAndSocialProto.campaign_ = this.campaign_;
                postAndSocialProto.isSuperLike_ = this.isSuperLike_;
                postAndSocialProto.matchExpId_ = this.matchExpId_;
                postAndSocialProto.matchRetrieveId_ = this.matchRetrieveId_;
                postAndSocialProto.matchStrategyId_ = this.matchStrategyId_;
                postAndSocialProto.coverNum_ = this.coverNum_;
                postAndSocialProto.imageId_ = this.imageId_;
                postAndSocialProto.enumType_ = this.enumType_;
                postAndSocialProto.info_ = this.info_;
                postAndSocialProto.permission_ = this.permission_;
                postAndSocialProto.videoNum_ = this.videoNum_;
                postAndSocialProto.videoId_ = this.videoId_;
                postAndSocialProto.onlineShowType_ = this.onlineShowType_;
                postAndSocialProto.isLikeMe_ = this.isLikeMe_;
                postAndSocialProto.costTime_ = this.costTime_;
                postAndSocialProto.maskNum_ = this.maskNum_;
                postAndSocialProto.voiceNum_ = this.voiceNum_;
                postAndSocialProto.isLiveShow_ = this.isLiveShow_;
                postAndSocialProto.cardType_ = this.cardType_;
                postAndSocialProto.cardNum_ = this.cardNum_;
                postAndSocialProto.roleType_ = this.roleType_;
                postAndSocialProto.hasPicture_ = this.hasPicture_;
                postAndSocialProto.hasText_ = this.hasText_;
                postAndSocialProto.hasStatus_ = this.hasStatus_;
                postAndSocialProto.reason_ = this.reason_;
                postAndSocialProto.relation_ = this.relation_;
                postAndSocialProto.isSpecialAttention_ = this.isSpecialAttention_;
                postAndSocialProto.isCloseFriend_ = this.isCloseFriend_;
                postAndSocialProto.isSuccess_ = this.isSuccess_;
                postAndSocialProto.msgType_ = this.msgType_;
                postAndSocialProto.isSuperBoost_ = this.isSuperBoost_;
                postAndSocialProto.count_ = this.count_;
                postAndSocialProto.gameType_ = this.gameType_;
                postAndSocialProto.showType_ = this.showType_;
                postAndSocialProto.isWealthShow_ = this.isWealthShow_;
                postAndSocialProto.isPostSpread_ = this.isPostSpread_;
                postAndSocialProto.cancelType_ = this.cancelType_;
                postAndSocialProto.superLikeCnt_ = this.superLikeCnt_;
                postAndSocialProto.isPostTop_ = this.isPostTop_;
                postAndSocialProto.constellationContent_ = this.constellationContent_;
                postAndSocialProto.isSsvipExposure_ = this.isSsvipExposure_;
                postAndSocialProto.result_ = this.result_;
                postAndSocialProto.isLimitTime_ = this.isLimitTime_;
                postAndSocialProto.title_ = this.title_;
                postAndSocialProto.mbti_ = this.mbti_;
                postAndSocialProto.isTravel_ = this.isTravel_;
                onBuilt();
                return postAndSocialProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PostAndSocialProto getDefaultInstanceForType() {
                return PostAndSocialProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.name_ = "";
                this.from_ = "";
                this.targetUid_ = "";
                this.isTrue_ = false;
                this.content_ = "";
                this.topic_ = "";
                this.postId_ = "";
                this.scene_ = "";
                this.position_ = "";
                this.num_ = 0;
                this.index_ = 0;
                this.id_ = "";
                this.type_ = 0;
                this.subType_ = "";
                this.expId_ = "";
                this.retrieveId_ = "";
                this.time_ = 0;
                this.distance_ = "";
                this.high_ = "";
                this.weight_ = "";
                this.isRecommend_ = false;
                this.ownerUid_ = "";
                this.isShow_ = false;
                this.modeId_ = "";
                this.isFollow_ = false;
                this.source_ = "";
                this.campaign_ = "";
                this.isSuperLike_ = false;
                this.matchExpId_ = "";
                this.matchRetrieveId_ = "";
                this.matchStrategyId_ = "";
                this.coverNum_ = 0;
                this.imageId_ = "";
                this.enumType_ = 0;
                this.info_ = "";
                this.permission_ = 0;
                this.videoNum_ = 0;
                this.videoId_ = "";
                this.onlineShowType_ = "";
                this.isLikeMe_ = false;
                this.costTime_ = 0L;
                this.maskNum_ = 0;
                this.voiceNum_ = 0;
                this.isLiveShow_ = false;
                this.cardType_ = "";
                this.cardNum_ = 0;
                this.roleType_ = "";
                this.hasPicture_ = false;
                this.hasText_ = false;
                this.hasStatus_ = false;
                this.reason_ = "";
                this.relation_ = "";
                this.isSpecialAttention_ = false;
                this.isCloseFriend_ = false;
                this.isSuccess_ = false;
                this.msgType_ = "";
                this.isSuperBoost_ = false;
                this.count_ = 0;
                this.gameType_ = "";
                this.showType_ = "";
                this.isWealthShow_ = false;
                this.isPostSpread_ = false;
                this.cancelType_ = "";
                this.superLikeCnt_ = 0;
                this.isPostTop_ = false;
                this.constellationContent_ = "";
                this.isSsvipExposure_ = false;
                this.result_ = "";
                this.isLimitTime_ = false;
                this.title_ = "";
                this.mbti_ = "";
                this.isTravel_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof PostAndSocialProto) {
                    return mergeFrom((PostAndSocialProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(PostAndSocialProto postAndSocialProto) {
                if (postAndSocialProto == PostAndSocialProto.getDefaultInstance()) {
                    return this;
                }
                if (postAndSocialProto.event_ != 0) {
                    setEventValue(postAndSocialProto.getEventValue());
                }
                if (!postAndSocialProto.getName().isEmpty()) {
                    this.name_ = postAndSocialProto.name_;
                    onChanged();
                }
                if (!postAndSocialProto.getFrom().isEmpty()) {
                    this.from_ = postAndSocialProto.from_;
                    onChanged();
                }
                if (!postAndSocialProto.getTargetUid().isEmpty()) {
                    this.targetUid_ = postAndSocialProto.targetUid_;
                    onChanged();
                }
                if (postAndSocialProto.getIsTrue()) {
                    setIsTrue(postAndSocialProto.getIsTrue());
                }
                if (!postAndSocialProto.getContent().isEmpty()) {
                    this.content_ = postAndSocialProto.content_;
                    onChanged();
                }
                if (!postAndSocialProto.getTopic().isEmpty()) {
                    this.topic_ = postAndSocialProto.topic_;
                    onChanged();
                }
                if (!postAndSocialProto.getPostId().isEmpty()) {
                    this.postId_ = postAndSocialProto.postId_;
                    onChanged();
                }
                if (!postAndSocialProto.getScene().isEmpty()) {
                    this.scene_ = postAndSocialProto.scene_;
                    onChanged();
                }
                if (!postAndSocialProto.getPosition().isEmpty()) {
                    this.position_ = postAndSocialProto.position_;
                    onChanged();
                }
                if (postAndSocialProto.getNum() != 0) {
                    setNum(postAndSocialProto.getNum());
                }
                if (postAndSocialProto.getIndex() != 0) {
                    setIndex(postAndSocialProto.getIndex());
                }
                if (!postAndSocialProto.getId().isEmpty()) {
                    this.id_ = postAndSocialProto.id_;
                    onChanged();
                }
                if (postAndSocialProto.type_ != 0) {
                    setTypeValue(postAndSocialProto.getTypeValue());
                }
                if (!postAndSocialProto.getSubType().isEmpty()) {
                    this.subType_ = postAndSocialProto.subType_;
                    onChanged();
                }
                if (!postAndSocialProto.getExpId().isEmpty()) {
                    this.expId_ = postAndSocialProto.expId_;
                    onChanged();
                }
                if (!postAndSocialProto.getRetrieveId().isEmpty()) {
                    this.retrieveId_ = postAndSocialProto.retrieveId_;
                    onChanged();
                }
                if (postAndSocialProto.getTime() != 0) {
                    setTime(postAndSocialProto.getTime());
                }
                if (!postAndSocialProto.getDistance().isEmpty()) {
                    this.distance_ = postAndSocialProto.distance_;
                    onChanged();
                }
                if (!postAndSocialProto.getHigh().isEmpty()) {
                    this.high_ = postAndSocialProto.high_;
                    onChanged();
                }
                if (!postAndSocialProto.getWeight().isEmpty()) {
                    this.weight_ = postAndSocialProto.weight_;
                    onChanged();
                }
                if (postAndSocialProto.getIsRecommend()) {
                    setIsRecommend(postAndSocialProto.getIsRecommend());
                }
                if (!postAndSocialProto.getOwnerUid().isEmpty()) {
                    this.ownerUid_ = postAndSocialProto.ownerUid_;
                    onChanged();
                }
                if (postAndSocialProto.getIsShow()) {
                    setIsShow(postAndSocialProto.getIsShow());
                }
                if (!postAndSocialProto.getModeId().isEmpty()) {
                    this.modeId_ = postAndSocialProto.modeId_;
                    onChanged();
                }
                if (postAndSocialProto.getIsFollow()) {
                    setIsFollow(postAndSocialProto.getIsFollow());
                }
                if (!postAndSocialProto.getSource().isEmpty()) {
                    this.source_ = postAndSocialProto.source_;
                    onChanged();
                }
                if (!postAndSocialProto.getCampaign().isEmpty()) {
                    this.campaign_ = postAndSocialProto.campaign_;
                    onChanged();
                }
                if (postAndSocialProto.getIsSuperLike()) {
                    setIsSuperLike(postAndSocialProto.getIsSuperLike());
                }
                if (!postAndSocialProto.getMatchExpId().isEmpty()) {
                    this.matchExpId_ = postAndSocialProto.matchExpId_;
                    onChanged();
                }
                if (!postAndSocialProto.getMatchRetrieveId().isEmpty()) {
                    this.matchRetrieveId_ = postAndSocialProto.matchRetrieveId_;
                    onChanged();
                }
                if (!postAndSocialProto.getMatchStrategyId().isEmpty()) {
                    this.matchStrategyId_ = postAndSocialProto.matchStrategyId_;
                    onChanged();
                }
                if (postAndSocialProto.getCoverNum() != 0) {
                    setCoverNum(postAndSocialProto.getCoverNum());
                }
                if (!postAndSocialProto.getImageId().isEmpty()) {
                    this.imageId_ = postAndSocialProto.imageId_;
                    onChanged();
                }
                if (postAndSocialProto.enumType_ != 0) {
                    setEnumTypeValue(postAndSocialProto.getEnumTypeValue());
                }
                if (!postAndSocialProto.getInfo().isEmpty()) {
                    this.info_ = postAndSocialProto.info_;
                    onChanged();
                }
                if (postAndSocialProto.getPermission() != 0) {
                    setPermission(postAndSocialProto.getPermission());
                }
                if (postAndSocialProto.getVideoNum() != 0) {
                    setVideoNum(postAndSocialProto.getVideoNum());
                }
                if (!postAndSocialProto.getVideoId().isEmpty()) {
                    this.videoId_ = postAndSocialProto.videoId_;
                    onChanged();
                }
                if (!postAndSocialProto.getOnlineShowType().isEmpty()) {
                    this.onlineShowType_ = postAndSocialProto.onlineShowType_;
                    onChanged();
                }
                if (postAndSocialProto.getIsLikeMe()) {
                    setIsLikeMe(postAndSocialProto.getIsLikeMe());
                }
                if (postAndSocialProto.getCostTime() != 0) {
                    setCostTime(postAndSocialProto.getCostTime());
                }
                if (postAndSocialProto.getMaskNum() != 0) {
                    setMaskNum(postAndSocialProto.getMaskNum());
                }
                if (postAndSocialProto.getVoiceNum() != 0) {
                    setVoiceNum(postAndSocialProto.getVoiceNum());
                }
                if (postAndSocialProto.getIsLiveShow()) {
                    setIsLiveShow(postAndSocialProto.getIsLiveShow());
                }
                if (!postAndSocialProto.getCardType().isEmpty()) {
                    this.cardType_ = postAndSocialProto.cardType_;
                    onChanged();
                }
                if (postAndSocialProto.getCardNum() != 0) {
                    setCardNum(postAndSocialProto.getCardNum());
                }
                if (!postAndSocialProto.getRoleType().isEmpty()) {
                    this.roleType_ = postAndSocialProto.roleType_;
                    onChanged();
                }
                if (postAndSocialProto.getHasPicture()) {
                    setHasPicture(postAndSocialProto.getHasPicture());
                }
                if (postAndSocialProto.getHasText()) {
                    setHasText(postAndSocialProto.getHasText());
                }
                if (postAndSocialProto.getHasStatus()) {
                    setHasStatus(postAndSocialProto.getHasStatus());
                }
                if (!postAndSocialProto.getReason().isEmpty()) {
                    this.reason_ = postAndSocialProto.reason_;
                    onChanged();
                }
                if (!postAndSocialProto.getRelation().isEmpty()) {
                    this.relation_ = postAndSocialProto.relation_;
                    onChanged();
                }
                if (postAndSocialProto.getIsSpecialAttention()) {
                    setIsSpecialAttention(postAndSocialProto.getIsSpecialAttention());
                }
                if (postAndSocialProto.getIsCloseFriend()) {
                    setIsCloseFriend(postAndSocialProto.getIsCloseFriend());
                }
                if (postAndSocialProto.getIsSuccess()) {
                    setIsSuccess(postAndSocialProto.getIsSuccess());
                }
                if (!postAndSocialProto.getMsgType().isEmpty()) {
                    this.msgType_ = postAndSocialProto.msgType_;
                    onChanged();
                }
                if (postAndSocialProto.getIsSuperBoost()) {
                    setIsSuperBoost(postAndSocialProto.getIsSuperBoost());
                }
                if (postAndSocialProto.getCount() != 0) {
                    setCount(postAndSocialProto.getCount());
                }
                if (!postAndSocialProto.getGameType().isEmpty()) {
                    this.gameType_ = postAndSocialProto.gameType_;
                    onChanged();
                }
                if (!postAndSocialProto.getShowType().isEmpty()) {
                    this.showType_ = postAndSocialProto.showType_;
                    onChanged();
                }
                if (postAndSocialProto.getIsWealthShow()) {
                    setIsWealthShow(postAndSocialProto.getIsWealthShow());
                }
                if (postAndSocialProto.getIsPostSpread()) {
                    setIsPostSpread(postAndSocialProto.getIsPostSpread());
                }
                if (!postAndSocialProto.getCancelType().isEmpty()) {
                    this.cancelType_ = postAndSocialProto.cancelType_;
                    onChanged();
                }
                if (postAndSocialProto.getSuperLikeCnt() != 0) {
                    setSuperLikeCnt(postAndSocialProto.getSuperLikeCnt());
                }
                if (postAndSocialProto.getIsPostTop()) {
                    setIsPostTop(postAndSocialProto.getIsPostTop());
                }
                if (!postAndSocialProto.getConstellationContent().isEmpty()) {
                    this.constellationContent_ = postAndSocialProto.constellationContent_;
                    onChanged();
                }
                if (postAndSocialProto.getIsSsvipExposure()) {
                    setIsSsvipExposure(postAndSocialProto.getIsSsvipExposure());
                }
                if (!postAndSocialProto.getResult().isEmpty()) {
                    this.result_ = postAndSocialProto.result_;
                    onChanged();
                }
                if (postAndSocialProto.getIsLimitTime()) {
                    setIsLimitTime(postAndSocialProto.getIsLimitTime());
                }
                if (!postAndSocialProto.getTitle().isEmpty()) {
                    this.title_ = postAndSocialProto.title_;
                    onChanged();
                }
                if (!postAndSocialProto.getMbti().isEmpty()) {
                    this.mbti_ = postAndSocialProto.mbti_;
                    onChanged();
                }
                if (postAndSocialProto.getIsTravel()) {
                    setIsTravel(postAndSocialProto.getIsTravel());
                }
                mergeUnknownFields(postAndSocialProto.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.name_ = "";
                this.from_ = "";
                this.targetUid_ = "";
                this.content_ = "";
                this.topic_ = "";
                this.postId_ = "";
                this.scene_ = "";
                this.position_ = "";
                this.id_ = "";
                this.type_ = 0;
                this.subType_ = "";
                this.expId_ = "";
                this.retrieveId_ = "";
                this.distance_ = "";
                this.high_ = "";
                this.weight_ = "";
                this.ownerUid_ = "";
                this.modeId_ = "";
                this.source_ = "";
                this.campaign_ = "";
                this.matchExpId_ = "";
                this.matchRetrieveId_ = "";
                this.matchStrategyId_ = "";
                this.imageId_ = "";
                this.enumType_ = 0;
                this.info_ = "";
                this.videoId_ = "";
                this.onlineShowType_ = "";
                this.cardType_ = "";
                this.roleType_ = "";
                this.reason_ = "";
                this.relation_ = "";
                this.msgType_ = "";
                this.gameType_ = "";
                this.showType_ = "";
                this.cancelType_ = "";
                this.constellationContent_ = "";
                this.result_ = "";
                this.title_ = "";
                this.mbti_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProto.k1()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.client.post.PostAndSocialProtos$PostAndSocialProto r3 = (com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProto) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.irisdt.client.post.PostAndSocialProtos$PostAndSocialProto r4 = (com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProto) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.client.post.PostAndSocialProtos.PostAndSocialProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.client.post.PostAndSocialProtos$PostAndSocialProto$Builder");
            }
        }

        public static Builder newBuilder(PostAndSocialProto postAndSocialProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(postAndSocialProto);
        }

        public static PostAndSocialProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private PostAndSocialProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.name_ = "";
            this.from_ = "";
            this.targetUid_ = "";
            this.content_ = "";
            this.topic_ = "";
            this.postId_ = "";
            this.scene_ = "";
            this.position_ = "";
            this.id_ = "";
            this.type_ = 0;
            this.subType_ = "";
            this.expId_ = "";
            this.retrieveId_ = "";
            this.distance_ = "";
            this.high_ = "";
            this.weight_ = "";
            this.ownerUid_ = "";
            this.modeId_ = "";
            this.source_ = "";
            this.campaign_ = "";
            this.matchExpId_ = "";
            this.matchRetrieveId_ = "";
            this.matchStrategyId_ = "";
            this.imageId_ = "";
            this.enumType_ = 0;
            this.info_ = "";
            this.videoId_ = "";
            this.onlineShowType_ = "";
            this.cardType_ = "";
            this.roleType_ = "";
            this.reason_ = "";
            this.relation_ = "";
            this.msgType_ = "";
            this.gameType_ = "";
            this.showType_ = "";
            this.cancelType_ = "";
            this.constellationContent_ = "";
            this.result_ = "";
            this.title_ = "";
            this.mbti_ = "";
        }

        public static PostAndSocialProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PostAndSocialProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PostAndSocialProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PostAndSocialProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static PostAndSocialProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static PostAndSocialProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static PostAndSocialProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PostAndSocialProto parseFrom(InputStream inputStream) throws IOException {
            return (PostAndSocialProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static PostAndSocialProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PostAndSocialProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PostAndSocialProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PostAndSocialProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static PostAndSocialProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PostAndSocialProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
        private PostAndSocialProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z10 = true;
                            case 8:
                                this.event_ = codedInputStream.readEnum();
                            case 18:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            case 26:
                                this.from_ = codedInputStream.readStringRequireUtf8();
                            case 34:
                                this.targetUid_ = codedInputStream.readStringRequireUtf8();
                            case 40:
                                this.isTrue_ = codedInputStream.readBool();
                            case 50:
                                this.content_ = codedInputStream.readStringRequireUtf8();
                            case 58:
                                this.topic_ = codedInputStream.readStringRequireUtf8();
                            case 66:
                                this.postId_ = codedInputStream.readStringRequireUtf8();
                            case 74:
                                this.scene_ = codedInputStream.readStringRequireUtf8();
                            case 82:
                                this.position_ = codedInputStream.readStringRequireUtf8();
                            case 88:
                                this.num_ = codedInputStream.readInt32();
                            case 96:
                                this.index_ = codedInputStream.readInt32();
                            case 106:
                                this.id_ = codedInputStream.readStringRequireUtf8();
                            case 112:
                                this.type_ = codedInputStream.readEnum();
                            case 122:
                                this.subType_ = codedInputStream.readStringRequireUtf8();
                            case 130:
                                this.expId_ = codedInputStream.readStringRequireUtf8();
                            case 138:
                                this.retrieveId_ = codedInputStream.readStringRequireUtf8();
                            case 144:
                                this.time_ = codedInputStream.readInt32();
                            case 154:
                                this.distance_ = codedInputStream.readStringRequireUtf8();
                            case 162:
                                this.high_ = codedInputStream.readStringRequireUtf8();
                            case 170:
                                this.weight_ = codedInputStream.readStringRequireUtf8();
                            case 176:
                                this.isRecommend_ = codedInputStream.readBool();
                            case 186:
                                this.ownerUid_ = codedInputStream.readStringRequireUtf8();
                            case 192:
                                this.isShow_ = codedInputStream.readBool();
                            case 202:
                                this.modeId_ = codedInputStream.readStringRequireUtf8();
                            case 208:
                                this.isFollow_ = codedInputStream.readBool();
                            case 218:
                                this.source_ = codedInputStream.readStringRequireUtf8();
                            case 226:
                                this.campaign_ = codedInputStream.readStringRequireUtf8();
                            case 232:
                                this.isSuperLike_ = codedInputStream.readBool();
                            case 242:
                                this.matchExpId_ = codedInputStream.readStringRequireUtf8();
                            case 250:
                                this.matchRetrieveId_ = codedInputStream.readStringRequireUtf8();
                            case 258:
                                this.matchStrategyId_ = codedInputStream.readStringRequireUtf8();
                            case 264:
                                this.coverNum_ = codedInputStream.readInt32();
                            case 274:
                                this.imageId_ = codedInputStream.readStringRequireUtf8();
                            case 280:
                                this.enumType_ = codedInputStream.readEnum();
                            case 290:
                                this.info_ = codedInputStream.readStringRequireUtf8();
                            case 296:
                                this.permission_ = codedInputStream.readInt32();
                            case 304:
                                this.videoNum_ = codedInputStream.readInt32();
                            case 314:
                                this.videoId_ = codedInputStream.readStringRequireUtf8();
                            case 322:
                                this.onlineShowType_ = codedInputStream.readStringRequireUtf8();
                            case 328:
                                this.isLikeMe_ = codedInputStream.readBool();
                            case 336:
                                this.costTime_ = codedInputStream.readInt64();
                            case 344:
                                this.maskNum_ = codedInputStream.readInt32();
                            case 352:
                                this.voiceNum_ = codedInputStream.readInt32();
                            case 360:
                                this.isLiveShow_ = codedInputStream.readBool();
                            case 370:
                                this.cardType_ = codedInputStream.readStringRequireUtf8();
                            case 376:
                                this.cardNum_ = codedInputStream.readInt32();
                            case 386:
                                this.roleType_ = codedInputStream.readStringRequireUtf8();
                            case 392:
                                this.hasPicture_ = codedInputStream.readBool();
                            case 400:
                                this.hasText_ = codedInputStream.readBool();
                            case 408:
                                this.hasStatus_ = codedInputStream.readBool();
                            case TTAdConstant.DEEPLINK_FALL_BACK_CODE /* 418 */:
                                this.reason_ = codedInputStream.readStringRequireUtf8();
                            case 426:
                                this.relation_ = codedInputStream.readStringRequireUtf8();
                            case ad.f32206s /* 432 */:
                                this.isSpecialAttention_ = codedInputStream.readBool();
                            case 440:
                                this.isCloseFriend_ = codedInputStream.readBool();
                            case 448:
                                this.isSuccess_ = codedInputStream.readBool();
                            case MetricsProto.MetricsEvent.STORAGE_MANAGER_SETTINGS /* 458 */:
                                this.msgType_ = codedInputStream.readStringRequireUtf8();
                            case MetricsProto.MetricsEvent.ACTION_DELETION_APPS_COLLAPSED /* 464 */:
                                this.isSuperBoost_ = codedInputStream.readBool();
                            case MetricsProto.MetricsEvent.ACTION_DELETION_HELPER_DOWNLOADS_DELETION_FAIL /* 472 */:
                                this.count_ = codedInputStream.readInt32();
                            case MetricsProto.MetricsEvent.ACTION_SUPPORT_CHAT /* 482 */:
                                this.gameType_ = codedInputStream.readStringRequireUtf8();
                            case 490:
                                this.showType_ = codedInputStream.readStringRequireUtf8();
                            case 496:
                                this.isWealthShow_ = codedInputStream.readBool();
                            case 504:
                                this.isPostSpread_ = codedInputStream.readBool();
                            case MetricsProto.MetricsEvent.USER_DICTIONARY_SETTINGS /* 514 */:
                                this.cancelType_ = codedInputStream.readStringRequireUtf8();
                            case MetricsProto.MetricsEvent.PROVISIONING_PREPROVISIONING_ACTIVITY_TIME_MS /* 520 */:
                                this.superLikeCnt_ = codedInputStream.readInt32();
                            case MetricsProto.MetricsEvent.DIALOG_FRP /* 528 */:
                                this.isPostTop_ = codedInputStream.readBool();
                            case MetricsProto.MetricsEvent.DIALOG_BLUETOOTH_RENAME /* 538 */:
                                this.constellationContent_ = codedInputStream.readStringRequireUtf8();
                            case MetricsProto.MetricsEvent.DIALOG_WIFI_SKIP /* 544 */:
                                this.isSsvipExposure_ = codedInputStream.readBool();
                            case MetricsProto.MetricsEvent.DIALOG_ZEN_ACCESS_GRANT /* 554 */:
                                this.result_ = codedInputStream.readStringRequireUtf8();
                            case MetricsProto.MetricsEvent.DIALOG_VOLUME_SLOW_WARNING /* 560 */:
                                this.isLimitTime_ = codedInputStream.readBool();
                            case MetricsProto.MetricsEvent.DIALOG_FINGERPINT_EDIT /* 570 */:
                                this.title_ = codedInputStream.readStringRequireUtf8();
                            case MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_DELETE_GROUP /* 578 */:
                                this.mbti_ = codedInputStream.readStringRequireUtf8();
                            case MetricsProto.MetricsEvent.DIALOG_ACCESSIBILITY_SERVICE_DISABLE /* 584 */:
                                this.isTravel_ = codedInputStream.readBool();
                            default:
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    z10 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e10) {
                        throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface PostAndSocialProtoOrBuilder extends MessageOrBuilder {
        String getCampaign();

        ByteString getCampaignBytes();

        String getCancelType();

        ByteString getCancelTypeBytes();

        int getCardNum();

        String getCardType();

        ByteString getCardTypeBytes();

        String getConstellationContent();

        ByteString getConstellationContentBytes();

        String getContent();

        ByteString getContentBytes();

        long getCostTime();

        int getCount();

        int getCoverNum();

        String getDistance();

        ByteString getDistanceBytes();

        Enum_type getEnumType();

        int getEnumTypeValue();

        Event getEvent();

        int getEventValue();

        String getExpId();

        ByteString getExpIdBytes();

        String getFrom();

        ByteString getFromBytes();

        String getGameType();

        ByteString getGameTypeBytes();

        boolean getHasPicture();

        boolean getHasStatus();

        boolean getHasText();

        String getHigh();

        ByteString getHighBytes();

        String getId();

        ByteString getIdBytes();

        String getImageId();

        ByteString getImageIdBytes();

        int getIndex();

        String getInfo();

        ByteString getInfoBytes();

        boolean getIsCloseFriend();

        boolean getIsFollow();

        boolean getIsLikeMe();

        boolean getIsLimitTime();

        boolean getIsLiveShow();

        boolean getIsPostSpread();

        boolean getIsPostTop();

        boolean getIsRecommend();

        boolean getIsShow();

        boolean getIsSpecialAttention();

        boolean getIsSsvipExposure();

        boolean getIsSuccess();

        boolean getIsSuperBoost();

        boolean getIsSuperLike();

        boolean getIsTravel();

        boolean getIsTrue();

        boolean getIsWealthShow();

        int getMaskNum();

        String getMatchExpId();

        ByteString getMatchExpIdBytes();

        String getMatchRetrieveId();

        ByteString getMatchRetrieveIdBytes();

        String getMatchStrategyId();

        ByteString getMatchStrategyIdBytes();

        String getMbti();

        ByteString getMbtiBytes();

        String getModeId();

        ByteString getModeIdBytes();

        String getMsgType();

        ByteString getMsgTypeBytes();

        String getName();

        ByteString getNameBytes();

        int getNum();

        String getOnlineShowType();

        ByteString getOnlineShowTypeBytes();

        String getOwnerUid();

        ByteString getOwnerUidBytes();

        int getPermission();

        String getPosition();

        ByteString getPositionBytes();

        String getPostId();

        ByteString getPostIdBytes();

        String getReason();

        ByteString getReasonBytes();

        String getRelation();

        ByteString getRelationBytes();

        String getResult();

        ByteString getResultBytes();

        String getRetrieveId();

        ByteString getRetrieveIdBytes();

        String getRoleType();

        ByteString getRoleTypeBytes();

        String getScene();

        ByteString getSceneBytes();

        String getShowType();

        ByteString getShowTypeBytes();

        String getSource();

        ByteString getSourceBytes();

        String getSubType();

        ByteString getSubTypeBytes();

        int getSuperLikeCnt();

        String getTargetUid();

        ByteString getTargetUidBytes();

        int getTime();

        String getTitle();

        ByteString getTitleBytes();

        String getTopic();

        ByteString getTopicBytes();

        Type getType();

        int getTypeValue();

        String getVideoId();

        ByteString getVideoIdBytes();

        int getVideoNum();

        int getVoiceNum();

        String getWeight();

        ByteString getWeightBytes();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Type implements ProtocolMessageEnum {
        UNKNOWN_TYPE(0),
        TOPIC(1),
        LOCATION(2),
        LOCATION_RECOMMEND(3),
        LOOK_UP_POST(4),
        LOOK_UP_PROFILE(5),
        PUSH(6),
        SAVE(7),
        STICKER(8),
        ABANDON(9),
        CUT(10),
        PROFILE(11),
        STORY_TAG(12),
        FILL_TOO(13),
        EDIT_PROFILE(14),
        COMMENT_BTN(15),
        DESCRIBE(16),
        COMMENT(17),
        FOLLOW(18),
        TIME(19),
        PROFILE_PORTRAIT(20),
        PROFILE_NAME(21),
        PROFILE_PHOTO(22),
        WRITE(23),
        CLICK(24),
        MATCH(25),
        BE_FOLLOW(26),
        SUPER_LIKE(27),
        BE_SUPER_LIKE(28),
        NONE(29),
        CLOSE_FRIENDS(30),
        SPECIAL_ATTENTION(31),
        FANS(32),
        LIKE(33),
        SHOT(34),
        ASK_QUESTION(35),
        ANSWER_QUESTION(36),
        ANOTHER_SHOT(37),
        SHOW_PROFILE(38),
        RECOMMENDED_CHAT(39),
        START(40),
        STOP(41),
        CHOOSE_PROBLEM(42),
        ENTER_VOICE_ROOM(43),
        ENTER_VOICE_GAME(44),
        RING_OFF(45),
        CALL_END(46),
        REACH_MATCH(47),
        ENTER_VOICE_ROOM_SDK(48),
        COMMON_CHAT(49),
        VOICE_PARTY_CHAT(50),
        PLAY_ACTION(51),
        CHOOSE_ROLE(52),
        GUESS_IDENTITY(53),
        TASK_COMPLETE(54),
        SHOW_PROFILE_GUIDE(55),
        UNRECOGNIZED(-1);

        public static final int ABANDON_VALUE = 9;
        public static final int ANOTHER_SHOT_VALUE = 37;
        public static final int ANSWER_QUESTION_VALUE = 36;
        public static final int ASK_QUESTION_VALUE = 35;
        public static final int BE_FOLLOW_VALUE = 26;
        public static final int BE_SUPER_LIKE_VALUE = 28;
        public static final int CALL_END_VALUE = 46;
        public static final int CHOOSE_PROBLEM_VALUE = 42;
        public static final int CHOOSE_ROLE_VALUE = 52;
        public static final int CLICK_VALUE = 24;
        public static final int CLOSE_FRIENDS_VALUE = 30;
        public static final int COMMENT_BTN_VALUE = 15;
        public static final int COMMENT_VALUE = 17;
        public static final int COMMON_CHAT_VALUE = 49;
        public static final int CUT_VALUE = 10;
        public static final int DESCRIBE_VALUE = 16;
        public static final int EDIT_PROFILE_VALUE = 14;
        public static final int ENTER_VOICE_GAME_VALUE = 44;
        public static final int ENTER_VOICE_ROOM_SDK_VALUE = 48;
        public static final int ENTER_VOICE_ROOM_VALUE = 43;
        public static final int FANS_VALUE = 32;
        public static final int FILL_TOO_VALUE = 13;
        public static final int FOLLOW_VALUE = 18;
        public static final int GUESS_IDENTITY_VALUE = 53;
        public static final int LIKE_VALUE = 33;
        public static final int LOCATION_RECOMMEND_VALUE = 3;
        public static final int LOCATION_VALUE = 2;
        public static final int LOOK_UP_POST_VALUE = 4;
        public static final int LOOK_UP_PROFILE_VALUE = 5;
        public static final int MATCH_VALUE = 25;
        public static final int NONE_VALUE = 29;
        public static final int PLAY_ACTION_VALUE = 51;
        public static final int PROFILE_NAME_VALUE = 21;
        public static final int PROFILE_PHOTO_VALUE = 22;
        public static final int PROFILE_PORTRAIT_VALUE = 20;
        public static final int PROFILE_VALUE = 11;
        public static final int PUSH_VALUE = 6;
        public static final int REACH_MATCH_VALUE = 47;
        public static final int RECOMMENDED_CHAT_VALUE = 39;
        public static final int RING_OFF_VALUE = 45;
        public static final int SAVE_VALUE = 7;
        public static final int SHOT_VALUE = 34;
        public static final int SHOW_PROFILE_GUIDE_VALUE = 55;
        public static final int SHOW_PROFILE_VALUE = 38;
        public static final int SPECIAL_ATTENTION_VALUE = 31;
        public static final int START_VALUE = 40;
        public static final int STICKER_VALUE = 8;
        public static final int STOP_VALUE = 41;
        public static final int STORY_TAG_VALUE = 12;
        public static final int SUPER_LIKE_VALUE = 27;
        public static final int TASK_COMPLETE_VALUE = 54;
        public static final int TIME_VALUE = 19;
        public static final int TOPIC_VALUE = 1;
        public static final int UNKNOWN_TYPE_VALUE = 0;
        public static final int VOICE_PARTY_CHAT_VALUE = 50;
        public static final int WRITE_VALUE = 23;
        private final int value;
        private static final Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: com.irisdt.client.post.PostAndSocialProtos.Type.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Type findValueByNumber(int i10) {
                return Type.forNumber(i10);
            }
        };
        private static final Type[] VALUES = values();

        Type(int i10) {
            this.value = i10;
        }

        public static Type forNumber(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN_TYPE;
                case 1:
                    return TOPIC;
                case 2:
                    return LOCATION;
                case 3:
                    return LOCATION_RECOMMEND;
                case 4:
                    return LOOK_UP_POST;
                case 5:
                    return LOOK_UP_PROFILE;
                case 6:
                    return PUSH;
                case 7:
                    return SAVE;
                case 8:
                    return STICKER;
                case 9:
                    return ABANDON;
                case 10:
                    return CUT;
                case 11:
                    return PROFILE;
                case 12:
                    return STORY_TAG;
                case 13:
                    return FILL_TOO;
                case 14:
                    return EDIT_PROFILE;
                case 15:
                    return COMMENT_BTN;
                case 16:
                    return DESCRIBE;
                case 17:
                    return COMMENT;
                case 18:
                    return FOLLOW;
                case 19:
                    return TIME;
                case 20:
                    return PROFILE_PORTRAIT;
                case 21:
                    return PROFILE_NAME;
                case 22:
                    return PROFILE_PHOTO;
                case 23:
                    return WRITE;
                case 24:
                    return CLICK;
                case 25:
                    return MATCH;
                case 26:
                    return BE_FOLLOW;
                case 27:
                    return SUPER_LIKE;
                case 28:
                    return BE_SUPER_LIKE;
                case 29:
                    return NONE;
                case 30:
                    return CLOSE_FRIENDS;
                case 31:
                    return SPECIAL_ATTENTION;
                case 32:
                    return FANS;
                case 33:
                    return LIKE;
                case 34:
                    return SHOT;
                case 35:
                    return ASK_QUESTION;
                case 36:
                    return ANSWER_QUESTION;
                case 37:
                    return ANOTHER_SHOT;
                case 38:
                    return SHOW_PROFILE;
                case 39:
                    return RECOMMENDED_CHAT;
                case 40:
                    return START;
                case 41:
                    return STOP;
                case 42:
                    return CHOOSE_PROBLEM;
                case 43:
                    return ENTER_VOICE_ROOM;
                case 44:
                    return ENTER_VOICE_GAME;
                case 45:
                    return RING_OFF;
                case 46:
                    return CALL_END;
                case 47:
                    return REACH_MATCH;
                case 48:
                    return ENTER_VOICE_ROOM_SDK;
                case 49:
                    return COMMON_CHAT;
                case 50:
                    return VOICE_PARTY_CHAT;
                case 51:
                    return PLAY_ACTION;
                case 52:
                    return CHOOSE_ROLE;
                case 53:
                    return GUESS_IDENTITY;
                case 54:
                    return TASK_COMPLETE;
                case 55:
                    return SHOW_PROFILE_GUIDE;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return PostAndSocialProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<Type> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Type valueOf(int i10) {
            return forNumber(i10);
        }

        public static Type valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_irisdt_client_post_PostAndSocialProto_descriptor = descriptor2;
        internal_static_com_irisdt_client_post_PostAndSocialProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{com.huawei.hianalytics.core.storage.Event.TAG, "Name", "From", "TargetUid", "IsTrue", "Content", "Topic", "PostId", "Scene", "Position", "Num", "Index", "Id", "Type", "SubType", "ExpId", "RetrieveId", "Time", "Distance", "High", "Weight", "IsRecommend", "OwnerUid", "IsShow", "ModeId", "IsFollow", "Source", "Campaign", "IsSuperLike", "MatchExpId", "MatchRetrieveId", "MatchStrategyId", "CoverNum", "ImageId", "EnumType", "Info", "Permission", "VideoNum", "VideoId", "OnlineShowType", "IsLikeMe", "CostTime", "MaskNum", "VoiceNum", "IsLiveShow", "CardType", "CardNum", "RoleType", "HasPicture", "HasText", "HasStatus", "Reason", "Relation", "IsSpecialAttention", "IsCloseFriend", "IsSuccess", "MsgType", "IsSuperBoost", "Count", "GameType", "ShowType", "IsWealthShow", "IsPostSpread", "CancelType", "SuperLikeCnt", "IsPostTop", "ConstellationContent", "IsSsvipExposure", "Result", "IsLimitTime", "Title", "Mbti", "IsTravel"});
    }

    private PostAndSocialProtos() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
