package com.irisdt.client.others;

import com.android.internal.logging.nano.MetricsProto;
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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class OthersProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012OthersProtos.proto\u0012\u0018com.irisdt.client.others\"È\u0007\n\u000bOthersProto\u0012.\n\u0005event\u0018\u0001 \u0001(\u000e2\u001f.com.irisdt.client.others.Event\u0012\u000b\n\u0003url\u0018\u0002 \u0001(\t\u0012\u0012\n\ntarget_url\u0018\u0003 \u0001(\t\u0012\f\n\u0004type\u0018\u0004 \u0001(\t\u0012\u000f\n\u0007content\u0018\u0005 \u0001(\t\u0012\r\n\u0005scene\u0018\u0006 \u0001(\t\u0012\n\n\u0002id\u0018\u0007 \u0001(\t\u0012\u000f\n\u0007channel\u0018\t \u0001(\t\u0012\r\n\u0005stage\u0018\n \u0001(\t\u0012\f\n\u0004name\u0018\u000b \u0001(\t\u0012\u0012\n\ntarget_uid\u0018\f \u0001(\t\u0012\u000f\n\u0007live_id\u0018\r \u0001(\t\u0012\u0012\n\nanchor_uid\u0018\u000e \u0001(\t\u0012\u000f\n\u0007post_id\u0018\u000f \u0001(\t\u0012\u0010\n\bposition\u0018\u0010 \u0001(\t\u0012\u000f\n\u0007is_true\u0018\u0011 \u0001(\b\u0012\u0011\n\tis_active\u0018\u0012 \u0001(\b\u0012\u0010\n\bis_first\u0018\u0013 \u0001(\b\u0012\f\n\u0004mode\u0018\u0014 \u0001(\t\u0012\u000e\n\u0006reason\u0018\u0015 \u0001(\t\u0012\u000b\n\u0003num\u0018\u0016 \u0001(\u0005\u00126\n\tenum_type\u0018\u0017 \u0001(\u000e2#.com.irisdt.client.others.Enum_type\u0012\f\n\u0004page\u0018\u0018 \u0001(\t\u0012\u0010\n\bcampaign\u0018\u0019 \u0001(\t\u00125\n\tsort_type\u0018\u001a \u0001(\u000e2\".com.irisdt.client.others.SortType\u0012\f\n\u0004from\u0018\u001b \u0001(\t\u0012\f\n\u0004time\u0018\u001c \u0001(\u0005\u0012\u000e\n\u0006source\u0018\u001d \u0001(\t\u0012\u000e\n\u0006agency\u0018\u001e \u0001(\t\u0012\u0013\n\u000bchannel_num\u0018\u001f \u0001(\t\u0012\u0011\n\ttask_type\u0018  \u0001(\u0005\u0012\u0015\n\ris_bought_vip\u0018! \u0001(\b\u0012\u0011\n\tcost_time\u0018\" \u0001(\u0003\u0012\u0015\n\roriginal_page\u0018# \u0001(\t\u0012\u000e\n\u0006status\u0018$ \u0001(\t\u0012\f\n\u0004num2\u0018% \u0001(\u0005\u0012\u0011\n\tad_result\u0018& \u0001(\t\u0012\f\n\u0004num3\u0018' \u0001(\u0005\u0012\r\n\u0005width\u0018( \u0001(\u0005\u0012\f\n\u0004high\u0018) \u0001(\u0005\u0012\u000f\n\u0007lon_lat\u0018* \u0001(\t\u0012\u0011\n\tdevice_id\u0018+ \u0001(\t\u0012\u0015\n\rlocation_type\u0018, \u0001(\u0005\u0012\u0011\n\tprecision\u0018- \u0001(\t\u0012\u0010\n\bprovider\u0018. \u0001(\t\u0012\u0015\n\rlocation_time\u0018/ \u0001(\t\u0012\u0016\n\u000ecall_back_time\u00180 \u0001(\t\u0012\u000f\n\u0007address\u00181 \u0001(\t\u0012\u0013\n\u000bdescription\u00182 \u0001(\t*Å\n\n\u0005Event\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\u0014\n\u0010CLIENT_PAGE_LOAD\u0010\u0001\u0012\u0013\n\u000fSHARE_BTN_CLICK\u0010\u0002\u0012\u0014\n\u0010CHOICE_SHARE_WAY\u0010\u0003\u0012\u0011\n\rSHARE_SUCCESS\u0010\u0004\u0012\u000e\n\nPOPUP_SHOW\u0010\u0005\u0012\u0013\n\u000fPOPUP_BTN_CLICK\u0010\u0006\u0012\u0012\n\u000eMAIN_BTN_CLICK\u0010\u0007\u0012\u0012\n\u000eAPP_SCREENSHOT\u0010\b\u0012\u0011\n\rSWITCH_STATUS\u0010\t\u0012+\n'SYSTEM_PERMISSIONS_SWITCH_STATUS_CHANGE\u0010\n\u0012\u0017\n\u0013START_RECORD_SCREEN\u0010\u000b\u0012\u0015\n\u0011END_RECORD_SCREEN\u0010\f\u0012\u0016\n\u0012TURN_OVER_FAIL_MSG\u0010\r\u0012\u0018\n\u0014APP_SCORE_POPUP_SHOW\u0010\u000e\u0012\u0019\n\u0015APP_SCORE_POPUP_CLICK\u0010\u000f\u0012\u0013\n\u000fAPP_BROWSE_PAGE\u0010\u0010\u0012\u0018\n\u0014APP_BROWSE_PAGE_TIME\u0010\u0011\u0012\u0010\n\fEDIT_PROFILE\u0010\u0012\u0012\u0018\n\u0014WAKE_UP_APP_BUY_LINK\u0010\u0013\u0012\u0013\n\u000fINBOX_MSG_CLICK\u0010\u0014\u0012)\n%NOTICE_CENTER_FOLLOW_PAGE_NOTICE_SHOW\u0010\u0015\u0012\u001a\n\u0016ACTIVITY_ENTRANCE_SHOW\u0010\u0016\u0012\u001b\n\u0017ACTIVITY_ENTRANCE_CLICK\u0010\u0017\u0012\u000e\n\nGUIDE_SHOW\u0010\u0018\u0012\u001d\n\u0019WECHAT_PUSH_AUTHOR_STATUS\u0010\u0019\u0012\u0015\n\u0011PICK_SHOW_PICTURE\u0010\u001a\u0012\u0011\n\rSELECT_PHOTOS\u0010\u001b\u0012\u0015\n\u0011EDIT_ICON_PROFILE\u0010\u001c\u0012\u0010\n\fUPLOAD_FILES\u0010\u001d\u0012\u000f\n\u000bBUBBLE_SHOW\u0010\u001e\u0012\u0010\n\fBUBBLE_CLICK\u0010\u001f\u0012\r\n\tTIPS_SHOW\u0010 \u0012\u000e\n\nTIPS_CLICK\u0010!\u0012\u0014\n\u0010APP_ERROR_REPORT\u0010\"\u0012\u001a\n\u0016USER_RELATED_BTN_CLICK\u0010%\u0012\u001a\n\u0016PLACE_HOLDER_PAGE_SHOW\u0010&\u0012\u0019\n\u0015CHOOSE_VIDEO_PORTRAIT\u0010'\u0012 \n\u001cBEHAVIOR_REMINDER_POPUP_SHOW\u0010(\u0012%\n!BEHAVIOR_REMINDER_POPUP_BTN_CLICK\u0010)\u0012\u0012\n\u000eGOODS_IN_STOCK\u0010*\u0012\u000f\n\u000bGUIDE_CLICK\u0010+\u0012\u0012\n\u000eTASK_BTN_CLICK\u0010,\u0012\u0014\n\u0010SPREAD_ITEM_SHOW\u0010-\u0012\u0015\n\u0011SPREAD_ITEM_CLICK\u0010.\u0012\u0019\n\u0015COMMON_ENTRANCE_CLICK\u0010/\u0012\u0018\n\u0014SPREAD_POSITION_SHOW\u00100\u0012\u000f\n\u000bBANNER_SHOW\u00101\u0012\u0010\n\fBANNER_CLICK\u00102\u0012\u0013\n\u000fFLIP_CARD_CLICK\u00103\u0012\u0011\n\rSEARCH_RECORD\u00104\u0012\u0018\n\u0014SEARCH_KEYWORD_CLICK\u00105\u0012\u0016\n\u0012PAGE_LOAD_COMPLETE\u00106\u0012\u0015\n\u0011FACE_IDENTIFY_USE\u00107\u0012\u0018\n\u0014FACE_IDENTIFY_RESULT\u00108\u0012\u0011\n\rMAIN_BTN_SHOW\u00109\u0012\u0015\n\u0011APP_LAUNCH_RESULT\u0010:\u0012\u0014\n\u0010LOCATION_SUCCESS\u0010;*è\b\n\tEnum_type\u0012\u0015\n\u0011UNKNOWN_ENUM_TYPE\u0010\u0000\u0012\r\n\tANM_GUIDE\u0010\u0001\u0012\u001c\n\u0018FIND_PAGE_NEW_USER_GUIDE\u0010\u0002\u0012\u0010\n\fNEW_USER_ANM\u0010\u0003\u0012\u0010\n\fHE_LIKES_YOU\u0010\u0004\u0012\u000b\n\u0007CONFIRM\u0010\u0005\u0012\n\n\u0006CANCEL\u0010\u0006\u0012\u000b\n\u0007PICTURE\u0010\u0007\u0012\t\n\u0005VIDEO\u0010\b\u0012\u0015\n\u0011PICTURE_AND_VIDEO\u0010\t\u0012\n\n\u0006DELETE\u0010\n\u0012\b\n\u0004OPEN\u0010\u000b\u0012\t\n\u0005CLOSE\u0010\f\u0012\u0011\n\rNEARBY_BUBBLE\u0010\r\u0012\u0010\n\fFIND_RED_DOT\u0010\u000e\u0012\u001f\n\u001bNEARBY_SEARCH_ON_MAP_BUBBLE\u0010\u000f\u0012\u0017\n\u0013DELETE_VISIT_RECORD\u0010\u0010\u0012\u0014\n\u0010LUCK_DRAW_BUBBLE\u0010\u0011\u0012\u001f\n\u001bLUCK_DRAW_START_TIPS_BUBBLE\u0010\u0012\u0012\u0015\n\u0011LUCK_DRAW_RED_DOT\u0010\u0013\u0012\u0016\n\u0012MSG_PAGE_OPEN_PUSH\u0010\u0014\u0012\u001c\n\u0018MANAGE_SPECIAL_ATTENTION\u0010\u001e\u0012$\n CHAT_OPEN_SPECIAL_ATTENTION_PUSH\u0010\u001f\u0012\u000f\n\u000bREMAIN_TIPS\u0010 \u0012\u0010\n\fGUIDE_BUBBLE\u0010!\u0012\u001c\n\u0018GUIDE_BUBBLE_REMAIN_TIPS\u0010\"\u0012\u0014\n\u0010PUSH_HAS_PROBLEM\u0010#\u0012\u0018\n\u0014MANAGE_CLOSE_FRIENDS\u0010$\u0012\u0016\n\u0012GRPC_DISCONNECTION\u0010%\u0012\u0012\n\u000eTICKET_INVALID\u0010&\u0012\u0013\n\u000fPROFILE_RED_DOT\u0010'\u0012\u0019\n\u0015LIVE_ENTRANCE_RED_DOT\u0010(\u0012\u0017\n\u0013LIVE_FOLLOW_RED_DOT\u0010)\u0012\u0012\n\u000eENTRANCE_FLOAT\u0010*\u0012\u0015\n\u0011DAILY_HEART_GUIDE\u0010+\u0012\u000f\n\u000bLIVE_EXTEND\u0010,\u0012\u000f\n\u000bLIVE_AVATAR\u0010-\u0012\u0012\n\u000eSUPER_BOOST_AE\u0010.\u0012\r\n\tLIVE_MORE\u0010/\u0012\u0013\n\u000fLIVE_RED_PACKET\u00100\u0012\u0019\n\u0015UPLOAD_AVATAR_NO_FAKE\u00101\u0012\u001a\n\u0016CLICK_TO_UPLOAD_AVATAR\u00102\u0012\u0011\n\rNO_CLEAR_FACE\u00103\u0012\u0015\n\u0011WHY_GET_FAKE_LIKE\u00104\u0012\r\n\tFINKA_TAB\u00105\u0012\u0013\n\u000fNEW_USER_ANM_AE\u00106\u0012\u000e\n\nSPEED_CARD\u00107\u0012 \n\u001cNEW_USER_UNION_PACKAGE_GUIDE\u00108\u0012\u001b\n\u0017CHANNEL_FIRST_BUY_GUIDE\u00109\u0012\u000e\n\nPRIDE_2023\u0010:\u0012\u0011\n\rNEARBY_PEOPLE\u0010;\u0012\u001f\n\u001bLIVE_ENTRANCE_SOLID_RED_DOT\u0010<*a\n\bSortType\u0012\u0015\n\u0011UNKNOWN_SORT_TYPE\u0010\u0000\u0012\n\n\u0006FOLLOW\u0010\u0001\u0012\b\n\u0004TIME\u0010\u0002\u0012\u0011\n\rCLOSE_FRIENDS\u0010\u0003\u0012\u0015\n\u0011SPECIAL_ATTENTION\u0010\u0004B\t¢\u0002\u0006OTHERSb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_irisdt_client_others_OthersProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_client_others_OthersProto_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Enum_type implements ProtocolMessageEnum {
        UNKNOWN_ENUM_TYPE(0),
        ANM_GUIDE(1),
        FIND_PAGE_NEW_USER_GUIDE(2),
        NEW_USER_ANM(3),
        HE_LIKES_YOU(4),
        CONFIRM(5),
        CANCEL(6),
        PICTURE(7),
        VIDEO(8),
        PICTURE_AND_VIDEO(9),
        DELETE(10),
        OPEN(11),
        CLOSE(12),
        NEARBY_BUBBLE(13),
        FIND_RED_DOT(14),
        NEARBY_SEARCH_ON_MAP_BUBBLE(15),
        DELETE_VISIT_RECORD(16),
        LUCK_DRAW_BUBBLE(17),
        LUCK_DRAW_START_TIPS_BUBBLE(18),
        LUCK_DRAW_RED_DOT(19),
        MSG_PAGE_OPEN_PUSH(20),
        MANAGE_SPECIAL_ATTENTION(30),
        CHAT_OPEN_SPECIAL_ATTENTION_PUSH(31),
        REMAIN_TIPS(32),
        GUIDE_BUBBLE(33),
        GUIDE_BUBBLE_REMAIN_TIPS(34),
        PUSH_HAS_PROBLEM(35),
        MANAGE_CLOSE_FRIENDS(36),
        GRPC_DISCONNECTION(37),
        TICKET_INVALID(38),
        PROFILE_RED_DOT(39),
        LIVE_ENTRANCE_RED_DOT(40),
        LIVE_FOLLOW_RED_DOT(41),
        ENTRANCE_FLOAT(42),
        DAILY_HEART_GUIDE(43),
        LIVE_EXTEND(44),
        LIVE_AVATAR(45),
        SUPER_BOOST_AE(46),
        LIVE_MORE(47),
        LIVE_RED_PACKET(48),
        UPLOAD_AVATAR_NO_FAKE(49),
        CLICK_TO_UPLOAD_AVATAR(50),
        NO_CLEAR_FACE(51),
        WHY_GET_FAKE_LIKE(52),
        FINKA_TAB(53),
        NEW_USER_ANM_AE(54),
        SPEED_CARD(55),
        NEW_USER_UNION_PACKAGE_GUIDE(56),
        CHANNEL_FIRST_BUY_GUIDE(57),
        PRIDE_2023(58),
        NEARBY_PEOPLE(59),
        LIVE_ENTRANCE_SOLID_RED_DOT(60),
        UNRECOGNIZED(-1);

        public static final int ANM_GUIDE_VALUE = 1;
        public static final int CANCEL_VALUE = 6;
        public static final int CHANNEL_FIRST_BUY_GUIDE_VALUE = 57;
        public static final int CHAT_OPEN_SPECIAL_ATTENTION_PUSH_VALUE = 31;
        public static final int CLICK_TO_UPLOAD_AVATAR_VALUE = 50;
        public static final int CLOSE_VALUE = 12;
        public static final int CONFIRM_VALUE = 5;
        public static final int DAILY_HEART_GUIDE_VALUE = 43;
        public static final int DELETE_VALUE = 10;
        public static final int DELETE_VISIT_RECORD_VALUE = 16;
        public static final int ENTRANCE_FLOAT_VALUE = 42;
        public static final int FIND_PAGE_NEW_USER_GUIDE_VALUE = 2;
        public static final int FIND_RED_DOT_VALUE = 14;
        public static final int FINKA_TAB_VALUE = 53;
        public static final int GRPC_DISCONNECTION_VALUE = 37;
        public static final int GUIDE_BUBBLE_REMAIN_TIPS_VALUE = 34;
        public static final int GUIDE_BUBBLE_VALUE = 33;
        public static final int HE_LIKES_YOU_VALUE = 4;
        public static final int LIVE_AVATAR_VALUE = 45;
        public static final int LIVE_ENTRANCE_RED_DOT_VALUE = 40;
        public static final int LIVE_ENTRANCE_SOLID_RED_DOT_VALUE = 60;
        public static final int LIVE_EXTEND_VALUE = 44;
        public static final int LIVE_FOLLOW_RED_DOT_VALUE = 41;
        public static final int LIVE_MORE_VALUE = 47;
        public static final int LIVE_RED_PACKET_VALUE = 48;
        public static final int LUCK_DRAW_BUBBLE_VALUE = 17;
        public static final int LUCK_DRAW_RED_DOT_VALUE = 19;
        public static final int LUCK_DRAW_START_TIPS_BUBBLE_VALUE = 18;
        public static final int MANAGE_CLOSE_FRIENDS_VALUE = 36;
        public static final int MANAGE_SPECIAL_ATTENTION_VALUE = 30;
        public static final int MSG_PAGE_OPEN_PUSH_VALUE = 20;
        public static final int NEARBY_BUBBLE_VALUE = 13;
        public static final int NEARBY_PEOPLE_VALUE = 59;
        public static final int NEARBY_SEARCH_ON_MAP_BUBBLE_VALUE = 15;
        public static final int NEW_USER_ANM_AE_VALUE = 54;
        public static final int NEW_USER_ANM_VALUE = 3;
        public static final int NEW_USER_UNION_PACKAGE_GUIDE_VALUE = 56;
        public static final int NO_CLEAR_FACE_VALUE = 51;
        public static final int OPEN_VALUE = 11;
        public static final int PICTURE_AND_VIDEO_VALUE = 9;
        public static final int PICTURE_VALUE = 7;
        public static final int PRIDE_2023_VALUE = 58;
        public static final int PROFILE_RED_DOT_VALUE = 39;
        public static final int PUSH_HAS_PROBLEM_VALUE = 35;
        public static final int REMAIN_TIPS_VALUE = 32;
        public static final int SPEED_CARD_VALUE = 55;
        public static final int SUPER_BOOST_AE_VALUE = 46;
        public static final int TICKET_INVALID_VALUE = 38;
        public static final int UNKNOWN_ENUM_TYPE_VALUE = 0;
        public static final int UPLOAD_AVATAR_NO_FAKE_VALUE = 49;
        public static final int VIDEO_VALUE = 8;
        public static final int WHY_GET_FAKE_LIKE_VALUE = 52;
        private final int value;
        private static final Internal.EnumLiteMap<Enum_type> internalValueMap = new Internal.EnumLiteMap<Enum_type>() { // from class: com.irisdt.client.others.OthersProtos.Enum_type.1
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
                    return ANM_GUIDE;
                case 2:
                    return FIND_PAGE_NEW_USER_GUIDE;
                case 3:
                    return NEW_USER_ANM;
                case 4:
                    return HE_LIKES_YOU;
                case 5:
                    return CONFIRM;
                case 6:
                    return CANCEL;
                case 7:
                    return PICTURE;
                case 8:
                    return VIDEO;
                case 9:
                    return PICTURE_AND_VIDEO;
                case 10:
                    return DELETE;
                case 11:
                    return OPEN;
                case 12:
                    return CLOSE;
                case 13:
                    return NEARBY_BUBBLE;
                case 14:
                    return FIND_RED_DOT;
                case 15:
                    return NEARBY_SEARCH_ON_MAP_BUBBLE;
                case 16:
                    return DELETE_VISIT_RECORD;
                case 17:
                    return LUCK_DRAW_BUBBLE;
                case 18:
                    return LUCK_DRAW_START_TIPS_BUBBLE;
                case 19:
                    return LUCK_DRAW_RED_DOT;
                case 20:
                    return MSG_PAGE_OPEN_PUSH;
                default:
                    switch (i10) {
                        case 30:
                            return MANAGE_SPECIAL_ATTENTION;
                        case 31:
                            return CHAT_OPEN_SPECIAL_ATTENTION_PUSH;
                        case 32:
                            return REMAIN_TIPS;
                        case 33:
                            return GUIDE_BUBBLE;
                        case 34:
                            return GUIDE_BUBBLE_REMAIN_TIPS;
                        case 35:
                            return PUSH_HAS_PROBLEM;
                        case 36:
                            return MANAGE_CLOSE_FRIENDS;
                        case 37:
                            return GRPC_DISCONNECTION;
                        case 38:
                            return TICKET_INVALID;
                        case 39:
                            return PROFILE_RED_DOT;
                        case 40:
                            return LIVE_ENTRANCE_RED_DOT;
                        case 41:
                            return LIVE_FOLLOW_RED_DOT;
                        case 42:
                            return ENTRANCE_FLOAT;
                        case 43:
                            return DAILY_HEART_GUIDE;
                        case 44:
                            return LIVE_EXTEND;
                        case 45:
                            return LIVE_AVATAR;
                        case 46:
                            return SUPER_BOOST_AE;
                        case 47:
                            return LIVE_MORE;
                        case 48:
                            return LIVE_RED_PACKET;
                        case 49:
                            return UPLOAD_AVATAR_NO_FAKE;
                        case 50:
                            return CLICK_TO_UPLOAD_AVATAR;
                        case 51:
                            return NO_CLEAR_FACE;
                        case 52:
                            return WHY_GET_FAKE_LIKE;
                        case 53:
                            return FINKA_TAB;
                        case 54:
                            return NEW_USER_ANM_AE;
                        case 55:
                            return SPEED_CARD;
                        case 56:
                            return NEW_USER_UNION_PACKAGE_GUIDE;
                        case 57:
                            return CHANNEL_FIRST_BUY_GUIDE;
                        case 58:
                            return PRIDE_2023;
                        case 59:
                            return NEARBY_PEOPLE;
                        case 60:
                            return LIVE_ENTRANCE_SOLID_RED_DOT;
                        default:
                            return null;
                    }
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return OthersProtos.getDescriptor().getEnumTypes().get(1);
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
        CLIENT_PAGE_LOAD(1),
        SHARE_BTN_CLICK(2),
        CHOICE_SHARE_WAY(3),
        SHARE_SUCCESS(4),
        POPUP_SHOW(5),
        POPUP_BTN_CLICK(6),
        MAIN_BTN_CLICK(7),
        APP_SCREENSHOT(8),
        SWITCH_STATUS(9),
        SYSTEM_PERMISSIONS_SWITCH_STATUS_CHANGE(10),
        START_RECORD_SCREEN(11),
        END_RECORD_SCREEN(12),
        TURN_OVER_FAIL_MSG(13),
        APP_SCORE_POPUP_SHOW(14),
        APP_SCORE_POPUP_CLICK(15),
        APP_BROWSE_PAGE(16),
        APP_BROWSE_PAGE_TIME(17),
        EDIT_PROFILE(18),
        WAKE_UP_APP_BUY_LINK(19),
        INBOX_MSG_CLICK(20),
        NOTICE_CENTER_FOLLOW_PAGE_NOTICE_SHOW(21),
        ACTIVITY_ENTRANCE_SHOW(22),
        ACTIVITY_ENTRANCE_CLICK(23),
        GUIDE_SHOW(24),
        WECHAT_PUSH_AUTHOR_STATUS(25),
        PICK_SHOW_PICTURE(26),
        SELECT_PHOTOS(27),
        EDIT_ICON_PROFILE(28),
        UPLOAD_FILES(29),
        BUBBLE_SHOW(30),
        BUBBLE_CLICK(31),
        TIPS_SHOW(32),
        TIPS_CLICK(33),
        APP_ERROR_REPORT(34),
        USER_RELATED_BTN_CLICK(37),
        PLACE_HOLDER_PAGE_SHOW(38),
        CHOOSE_VIDEO_PORTRAIT(39),
        BEHAVIOR_REMINDER_POPUP_SHOW(40),
        BEHAVIOR_REMINDER_POPUP_BTN_CLICK(41),
        GOODS_IN_STOCK(42),
        GUIDE_CLICK(43),
        TASK_BTN_CLICK(44),
        SPREAD_ITEM_SHOW(45),
        SPREAD_ITEM_CLICK(46),
        COMMON_ENTRANCE_CLICK(47),
        SPREAD_POSITION_SHOW(48),
        BANNER_SHOW(49),
        BANNER_CLICK(50),
        FLIP_CARD_CLICK(51),
        SEARCH_RECORD(52),
        SEARCH_KEYWORD_CLICK(53),
        PAGE_LOAD_COMPLETE(54),
        FACE_IDENTIFY_USE(55),
        FACE_IDENTIFY_RESULT(56),
        MAIN_BTN_SHOW(57),
        APP_LAUNCH_RESULT(58),
        LOCATION_SUCCESS(59),
        UNRECOGNIZED(-1);

        public static final int ACTIVITY_ENTRANCE_CLICK_VALUE = 23;
        public static final int ACTIVITY_ENTRANCE_SHOW_VALUE = 22;
        public static final int APP_BROWSE_PAGE_TIME_VALUE = 17;
        public static final int APP_BROWSE_PAGE_VALUE = 16;
        public static final int APP_ERROR_REPORT_VALUE = 34;
        public static final int APP_LAUNCH_RESULT_VALUE = 58;
        public static final int APP_SCORE_POPUP_CLICK_VALUE = 15;
        public static final int APP_SCORE_POPUP_SHOW_VALUE = 14;
        public static final int APP_SCREENSHOT_VALUE = 8;
        public static final int BANNER_CLICK_VALUE = 50;
        public static final int BANNER_SHOW_VALUE = 49;
        public static final int BEHAVIOR_REMINDER_POPUP_BTN_CLICK_VALUE = 41;
        public static final int BEHAVIOR_REMINDER_POPUP_SHOW_VALUE = 40;
        public static final int BUBBLE_CLICK_VALUE = 31;
        public static final int BUBBLE_SHOW_VALUE = 30;
        public static final int CHOICE_SHARE_WAY_VALUE = 3;
        public static final int CHOOSE_VIDEO_PORTRAIT_VALUE = 39;
        public static final int CLIENT_PAGE_LOAD_VALUE = 1;
        public static final int COMMON_ENTRANCE_CLICK_VALUE = 47;
        public static final int EDIT_ICON_PROFILE_VALUE = 28;
        public static final int EDIT_PROFILE_VALUE = 18;
        public static final int END_RECORD_SCREEN_VALUE = 12;
        public static final int FACE_IDENTIFY_RESULT_VALUE = 56;
        public static final int FACE_IDENTIFY_USE_VALUE = 55;
        public static final int FLIP_CARD_CLICK_VALUE = 51;
        public static final int GOODS_IN_STOCK_VALUE = 42;
        public static final int GUIDE_CLICK_VALUE = 43;
        public static final int GUIDE_SHOW_VALUE = 24;
        public static final int INBOX_MSG_CLICK_VALUE = 20;
        public static final int LOCATION_SUCCESS_VALUE = 59;
        public static final int MAIN_BTN_CLICK_VALUE = 7;
        public static final int MAIN_BTN_SHOW_VALUE = 57;
        public static final int NOTICE_CENTER_FOLLOW_PAGE_NOTICE_SHOW_VALUE = 21;
        public static final int PAGE_LOAD_COMPLETE_VALUE = 54;
        public static final int PICK_SHOW_PICTURE_VALUE = 26;
        public static final int PLACE_HOLDER_PAGE_SHOW_VALUE = 38;
        public static final int POPUP_BTN_CLICK_VALUE = 6;
        public static final int POPUP_SHOW_VALUE = 5;
        public static final int SEARCH_KEYWORD_CLICK_VALUE = 53;
        public static final int SEARCH_RECORD_VALUE = 52;
        public static final int SELECT_PHOTOS_VALUE = 27;
        public static final int SHARE_BTN_CLICK_VALUE = 2;
        public static final int SHARE_SUCCESS_VALUE = 4;
        public static final int SPREAD_ITEM_CLICK_VALUE = 46;
        public static final int SPREAD_ITEM_SHOW_VALUE = 45;
        public static final int SPREAD_POSITION_SHOW_VALUE = 48;
        public static final int START_RECORD_SCREEN_VALUE = 11;
        public static final int SWITCH_STATUS_VALUE = 9;
        public static final int SYSTEM_PERMISSIONS_SWITCH_STATUS_CHANGE_VALUE = 10;
        public static final int TASK_BTN_CLICK_VALUE = 44;
        public static final int TIPS_CLICK_VALUE = 33;
        public static final int TIPS_SHOW_VALUE = 32;
        public static final int TURN_OVER_FAIL_MSG_VALUE = 13;
        public static final int UNKNOWN_VALUE = 0;
        public static final int UPLOAD_FILES_VALUE = 29;
        public static final int USER_RELATED_BTN_CLICK_VALUE = 37;
        public static final int WAKE_UP_APP_BUY_LINK_VALUE = 19;
        public static final int WECHAT_PUSH_AUTHOR_STATUS_VALUE = 25;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.irisdt.client.others.OthersProtos.Event.1
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
                    return CLIENT_PAGE_LOAD;
                case 2:
                    return SHARE_BTN_CLICK;
                case 3:
                    return CHOICE_SHARE_WAY;
                case 4:
                    return SHARE_SUCCESS;
                case 5:
                    return POPUP_SHOW;
                case 6:
                    return POPUP_BTN_CLICK;
                case 7:
                    return MAIN_BTN_CLICK;
                case 8:
                    return APP_SCREENSHOT;
                case 9:
                    return SWITCH_STATUS;
                case 10:
                    return SYSTEM_PERMISSIONS_SWITCH_STATUS_CHANGE;
                case 11:
                    return START_RECORD_SCREEN;
                case 12:
                    return END_RECORD_SCREEN;
                case 13:
                    return TURN_OVER_FAIL_MSG;
                case 14:
                    return APP_SCORE_POPUP_SHOW;
                case 15:
                    return APP_SCORE_POPUP_CLICK;
                case 16:
                    return APP_BROWSE_PAGE;
                case 17:
                    return APP_BROWSE_PAGE_TIME;
                case 18:
                    return EDIT_PROFILE;
                case 19:
                    return WAKE_UP_APP_BUY_LINK;
                case 20:
                    return INBOX_MSG_CLICK;
                case 21:
                    return NOTICE_CENTER_FOLLOW_PAGE_NOTICE_SHOW;
                case 22:
                    return ACTIVITY_ENTRANCE_SHOW;
                case 23:
                    return ACTIVITY_ENTRANCE_CLICK;
                case 24:
                    return GUIDE_SHOW;
                case 25:
                    return WECHAT_PUSH_AUTHOR_STATUS;
                case 26:
                    return PICK_SHOW_PICTURE;
                case 27:
                    return SELECT_PHOTOS;
                case 28:
                    return EDIT_ICON_PROFILE;
                case 29:
                    return UPLOAD_FILES;
                case 30:
                    return BUBBLE_SHOW;
                case 31:
                    return BUBBLE_CLICK;
                case 32:
                    return TIPS_SHOW;
                case 33:
                    return TIPS_CLICK;
                case 34:
                    return APP_ERROR_REPORT;
                case 35:
                case 36:
                default:
                    return null;
                case 37:
                    return USER_RELATED_BTN_CLICK;
                case 38:
                    return PLACE_HOLDER_PAGE_SHOW;
                case 39:
                    return CHOOSE_VIDEO_PORTRAIT;
                case 40:
                    return BEHAVIOR_REMINDER_POPUP_SHOW;
                case 41:
                    return BEHAVIOR_REMINDER_POPUP_BTN_CLICK;
                case 42:
                    return GOODS_IN_STOCK;
                case 43:
                    return GUIDE_CLICK;
                case 44:
                    return TASK_BTN_CLICK;
                case 45:
                    return SPREAD_ITEM_SHOW;
                case 46:
                    return SPREAD_ITEM_CLICK;
                case 47:
                    return COMMON_ENTRANCE_CLICK;
                case 48:
                    return SPREAD_POSITION_SHOW;
                case 49:
                    return BANNER_SHOW;
                case 50:
                    return BANNER_CLICK;
                case 51:
                    return FLIP_CARD_CLICK;
                case 52:
                    return SEARCH_RECORD;
                case 53:
                    return SEARCH_KEYWORD_CLICK;
                case 54:
                    return PAGE_LOAD_COMPLETE;
                case 55:
                    return FACE_IDENTIFY_USE;
                case 56:
                    return FACE_IDENTIFY_RESULT;
                case 57:
                    return MAIN_BTN_SHOW;
                case 58:
                    return APP_LAUNCH_RESULT;
                case 59:
                    return LOCATION_SUCCESS;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return OthersProtos.getDescriptor().getEnumTypes().get(0);
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
    public static final class OthersProto extends GeneratedMessageV3 implements OthersProtoOrBuilder {
        public static final int ADDRESS_FIELD_NUMBER = 49;
        public static final int AD_RESULT_FIELD_NUMBER = 38;
        public static final int AGENCY_FIELD_NUMBER = 30;
        public static final int ANCHOR_UID_FIELD_NUMBER = 14;
        public static final int CALL_BACK_TIME_FIELD_NUMBER = 48;
        public static final int CAMPAIGN_FIELD_NUMBER = 25;
        public static final int CHANNEL_FIELD_NUMBER = 9;
        public static final int CHANNEL_NUM_FIELD_NUMBER = 31;
        public static final int CONTENT_FIELD_NUMBER = 5;
        public static final int COST_TIME_FIELD_NUMBER = 34;
        public static final int DESCRIPTION_FIELD_NUMBER = 50;
        public static final int DEVICE_ID_FIELD_NUMBER = 43;
        public static final int ENUM_TYPE_FIELD_NUMBER = 23;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int FROM_FIELD_NUMBER = 27;
        public static final int HIGH_FIELD_NUMBER = 41;
        public static final int ID_FIELD_NUMBER = 7;
        public static final int IS_ACTIVE_FIELD_NUMBER = 18;
        public static final int IS_BOUGHT_VIP_FIELD_NUMBER = 33;
        public static final int IS_FIRST_FIELD_NUMBER = 19;
        public static final int IS_TRUE_FIELD_NUMBER = 17;
        public static final int LIVE_ID_FIELD_NUMBER = 13;
        public static final int LOCATION_TIME_FIELD_NUMBER = 47;
        public static final int LOCATION_TYPE_FIELD_NUMBER = 44;
        public static final int LON_LAT_FIELD_NUMBER = 42;
        public static final int MODE_FIELD_NUMBER = 20;
        public static final int NAME_FIELD_NUMBER = 11;
        public static final int NUM2_FIELD_NUMBER = 37;
        public static final int NUM3_FIELD_NUMBER = 39;
        public static final int NUM_FIELD_NUMBER = 22;
        public static final int ORIGINAL_PAGE_FIELD_NUMBER = 35;
        public static final int PAGE_FIELD_NUMBER = 24;
        public static final int POSITION_FIELD_NUMBER = 16;
        public static final int POST_ID_FIELD_NUMBER = 15;
        public static final int PRECISION_FIELD_NUMBER = 45;
        public static final int PROVIDER_FIELD_NUMBER = 46;
        public static final int REASON_FIELD_NUMBER = 21;
        public static final int SCENE_FIELD_NUMBER = 6;
        public static final int SORT_TYPE_FIELD_NUMBER = 26;
        public static final int SOURCE_FIELD_NUMBER = 29;
        public static final int STAGE_FIELD_NUMBER = 10;
        public static final int STATUS_FIELD_NUMBER = 36;
        public static final int TARGET_UID_FIELD_NUMBER = 12;
        public static final int TARGET_URL_FIELD_NUMBER = 3;
        public static final int TASK_TYPE_FIELD_NUMBER = 32;
        public static final int TIME_FIELD_NUMBER = 28;
        public static final int TYPE_FIELD_NUMBER = 4;
        public static final int URL_FIELD_NUMBER = 2;
        public static final int WIDTH_FIELD_NUMBER = 40;
        private static final long serialVersionUID = 0;
        private volatile Object adResult_;
        private volatile Object address_;
        private volatile Object agency_;
        private volatile Object anchorUid_;
        private volatile Object callBackTime_;
        private volatile Object campaign_;
        private volatile Object channelNum_;
        private volatile Object channel_;
        private volatile Object content_;
        private long costTime_;
        private volatile Object description_;
        private volatile Object deviceId_;
        private int enumType_;
        private int event_;
        private volatile Object from_;
        private int high_;
        private volatile Object id_;
        private boolean isActive_;
        private boolean isBoughtVip_;
        private boolean isFirst_;
        private boolean isTrue_;
        private volatile Object liveId_;
        private volatile Object locationTime_;
        private int locationType_;
        private volatile Object lonLat_;
        private byte memoizedIsInitialized;
        private volatile Object mode_;
        private volatile Object name_;
        private int num2_;
        private int num3_;
        private int num_;
        private volatile Object originalPage_;
        private volatile Object page_;
        private volatile Object position_;
        private volatile Object postId_;
        private volatile Object precision_;
        private volatile Object provider_;
        private volatile Object reason_;
        private volatile Object scene_;
        private int sortType_;
        private volatile Object source_;
        private volatile Object stage_;
        private volatile Object status_;
        private volatile Object targetUid_;
        private volatile Object targetUrl_;
        private int taskType_;
        private int time_;
        private volatile Object type_;
        private volatile Object url_;
        private int width_;
        private static final OthersProto DEFAULT_INSTANCE = new OthersProto();
        private static final Parser<OthersProto> PARSER = new AbstractParser<OthersProto>() { // from class: com.irisdt.client.others.OthersProtos.OthersProto.1
            @Override // com.google.protobuf.Parser
            public OthersProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new OthersProto(codedInputStream, extensionRegistryLite);
            }
        };

        private OthersProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static OthersProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return OthersProtos.internal_static_com_irisdt_client_others_OthersProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static OthersProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OthersProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static OthersProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<OthersProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OthersProto)) {
                return super.equals(obj);
            }
            OthersProto othersProto = (OthersProto) obj;
            return this.event_ == othersProto.event_ && getUrl().equals(othersProto.getUrl()) && getTargetUrl().equals(othersProto.getTargetUrl()) && getType().equals(othersProto.getType()) && getContent().equals(othersProto.getContent()) && getScene().equals(othersProto.getScene()) && getId().equals(othersProto.getId()) && getChannel().equals(othersProto.getChannel()) && getStage().equals(othersProto.getStage()) && getName().equals(othersProto.getName()) && getTargetUid().equals(othersProto.getTargetUid()) && getLiveId().equals(othersProto.getLiveId()) && getAnchorUid().equals(othersProto.getAnchorUid()) && getPostId().equals(othersProto.getPostId()) && getPosition().equals(othersProto.getPosition()) && getIsTrue() == othersProto.getIsTrue() && getIsActive() == othersProto.getIsActive() && getIsFirst() == othersProto.getIsFirst() && getMode().equals(othersProto.getMode()) && getReason().equals(othersProto.getReason()) && getNum() == othersProto.getNum() && this.enumType_ == othersProto.enumType_ && getPage().equals(othersProto.getPage()) && getCampaign().equals(othersProto.getCampaign()) && this.sortType_ == othersProto.sortType_ && getFrom().equals(othersProto.getFrom()) && getTime() == othersProto.getTime() && getSource().equals(othersProto.getSource()) && getAgency().equals(othersProto.getAgency()) && getChannelNum().equals(othersProto.getChannelNum()) && getTaskType() == othersProto.getTaskType() && getIsBoughtVip() == othersProto.getIsBoughtVip() && getCostTime() == othersProto.getCostTime() && getOriginalPage().equals(othersProto.getOriginalPage()) && getStatus().equals(othersProto.getStatus()) && getNum2() == othersProto.getNum2() && getAdResult().equals(othersProto.getAdResult()) && getNum3() == othersProto.getNum3() && getWidth() == othersProto.getWidth() && getHigh() == othersProto.getHigh() && getLonLat().equals(othersProto.getLonLat()) && getDeviceId().equals(othersProto.getDeviceId()) && getLocationType() == othersProto.getLocationType() && getPrecision().equals(othersProto.getPrecision()) && getProvider().equals(othersProto.getProvider()) && getLocationTime().equals(othersProto.getLocationTime()) && getCallBackTime().equals(othersProto.getCallBackTime()) && getAddress().equals(othersProto.getAddress()) && getDescription().equals(othersProto.getDescription()) && this.unknownFields.equals(othersProto.unknownFields);
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getAdResult() {
            Object obj = this.adResult_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.adResult_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getAdResultBytes() {
            Object obj = this.adResult_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.adResult_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getAddress() {
            Object obj = this.address_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.address_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getAddressBytes() {
            Object obj = this.address_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.address_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getAgency() {
            Object obj = this.agency_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.agency_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getAgencyBytes() {
            Object obj = this.agency_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.agency_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getAnchorUid() {
            Object obj = this.anchorUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.anchorUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getAnchorUidBytes() {
            Object obj = this.anchorUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.anchorUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getCallBackTime() {
            Object obj = this.callBackTime_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.callBackTime_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getCallBackTimeBytes() {
            Object obj = this.callBackTime_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.callBackTime_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getCampaign() {
            Object obj = this.campaign_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.campaign_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getCampaignBytes() {
            Object obj = this.campaign_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.campaign_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getChannel() {
            Object obj = this.channel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.channel_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getChannelBytes() {
            Object obj = this.channel_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.channel_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getChannelNum() {
            Object obj = this.channelNum_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.channelNum_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getChannelNumBytes() {
            Object obj = this.channelNum_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.channelNum_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public long getCostTime() {
            return this.costTime_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.description_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getDescriptionBytes() {
            Object obj = this.description_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.description_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public Enum_type getEnumType() {
            Enum_type valueOf = Enum_type.valueOf(this.enumType_);
            return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public int getEnumTypeValue() {
            return this.enumType_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            return valueOf == null ? Event.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getFrom() {
            Object obj = this.from_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.from_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getFromBytes() {
            Object obj = this.from_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.from_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public int getHigh() {
            return this.high_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public boolean getIsActive() {
            return this.isActive_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public boolean getIsBoughtVip() {
            return this.isBoughtVip_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public boolean getIsFirst() {
            return this.isFirst_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public boolean getIsTrue() {
            return this.isTrue_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getLiveId() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liveId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getLiveIdBytes() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liveId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getLocationTime() {
            Object obj = this.locationTime_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.locationTime_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getLocationTimeBytes() {
            Object obj = this.locationTime_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.locationTime_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public int getLocationType() {
            return this.locationType_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getLonLat() {
            Object obj = this.lonLat_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.lonLat_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getLonLatBytes() {
            Object obj = this.lonLat_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lonLat_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getMode() {
            Object obj = this.mode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getModeBytes() {
            Object obj = this.mode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public int getNum() {
            return this.num_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public int getNum2() {
            return this.num2_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public int getNum3() {
            return this.num3_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getOriginalPage() {
            Object obj = this.originalPage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.originalPage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getOriginalPageBytes() {
            Object obj = this.originalPage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.originalPage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getPage() {
            Object obj = this.page_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.page_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getPageBytes() {
            Object obj = this.page_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.page_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<OthersProto> getParserForType() {
            return PARSER;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getPosition() {
            Object obj = this.position_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.position_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getPositionBytes() {
            Object obj = this.position_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.position_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getPostId() {
            Object obj = this.postId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.postId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getPostIdBytes() {
            Object obj = this.postId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.postId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getPrecision() {
            Object obj = this.precision_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.precision_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getPrecisionBytes() {
            Object obj = this.precision_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.precision_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getProvider() {
            Object obj = this.provider_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.provider_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getProviderBytes() {
            Object obj = this.provider_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.provider_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getReason() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reason_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getReasonBytes() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reason_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getScene() {
            Object obj = this.scene_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.scene_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
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
            if (!getUrlBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(2, this.url_);
            }
            if (!getTargetUrlBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(3, this.targetUrl_);
            }
            if (!getTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(4, this.type_);
            }
            if (!getContentBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(5, this.content_);
            }
            if (!getSceneBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(6, this.scene_);
            }
            if (!getIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(7, this.id_);
            }
            if (!getChannelBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(9, this.channel_);
            }
            if (!getStageBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(10, this.stage_);
            }
            if (!getNameBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(11, this.name_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(12, this.targetUid_);
            }
            if (!getLiveIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(13, this.liveId_);
            }
            if (!getAnchorUidBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(14, this.anchorUid_);
            }
            if (!getPostIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(15, this.postId_);
            }
            if (!getPositionBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(16, this.position_);
            }
            boolean z10 = this.isTrue_;
            if (z10) {
                computeEnumSize += CodedOutputStream.computeBoolSize(17, z10);
            }
            boolean z11 = this.isActive_;
            if (z11) {
                computeEnumSize += CodedOutputStream.computeBoolSize(18, z11);
            }
            boolean z12 = this.isFirst_;
            if (z12) {
                computeEnumSize += CodedOutputStream.computeBoolSize(19, z12);
            }
            if (!getModeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(20, this.mode_);
            }
            if (!getReasonBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(21, this.reason_);
            }
            int i11 = this.num_;
            if (i11 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(22, i11);
            }
            if (this.enumType_ != Enum_type.UNKNOWN_ENUM_TYPE.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(23, this.enumType_);
            }
            if (!getPageBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(24, this.page_);
            }
            if (!getCampaignBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(25, this.campaign_);
            }
            if (this.sortType_ != SortType.UNKNOWN_SORT_TYPE.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(26, this.sortType_);
            }
            if (!getFromBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(27, this.from_);
            }
            int i12 = this.time_;
            if (i12 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(28, i12);
            }
            if (!getSourceBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(29, this.source_);
            }
            if (!getAgencyBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(30, this.agency_);
            }
            if (!getChannelNumBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(31, this.channelNum_);
            }
            int i13 = this.taskType_;
            if (i13 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(32, i13);
            }
            boolean z13 = this.isBoughtVip_;
            if (z13) {
                computeEnumSize += CodedOutputStream.computeBoolSize(33, z13);
            }
            long j10 = this.costTime_;
            if (j10 != 0) {
                computeEnumSize += CodedOutputStream.computeInt64Size(34, j10);
            }
            if (!getOriginalPageBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(35, this.originalPage_);
            }
            if (!getStatusBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(36, this.status_);
            }
            int i14 = this.num2_;
            if (i14 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(37, i14);
            }
            if (!getAdResultBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(38, this.adResult_);
            }
            int i15 = this.num3_;
            if (i15 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(39, i15);
            }
            int i16 = this.width_;
            if (i16 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(40, i16);
            }
            int i17 = this.high_;
            if (i17 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(41, i17);
            }
            if (!getLonLatBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(42, this.lonLat_);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(43, this.deviceId_);
            }
            int i18 = this.locationType_;
            if (i18 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(44, i18);
            }
            if (!getPrecisionBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(45, this.precision_);
            }
            if (!getProviderBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(46, this.provider_);
            }
            if (!getLocationTimeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(47, this.locationTime_);
            }
            if (!getCallBackTimeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(48, this.callBackTime_);
            }
            if (!getAddressBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(49, this.address_);
            }
            if (!getDescriptionBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(50, this.description_);
            }
            int serializedSize = computeEnumSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public SortType getSortType() {
            SortType valueOf = SortType.valueOf(this.sortType_);
            return valueOf == null ? SortType.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public int getSortTypeValue() {
            return this.sortType_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getSource() {
            Object obj = this.source_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.source_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getSourceBytes() {
            Object obj = this.source_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.source_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getStage() {
            Object obj = this.stage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.stage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getStageBytes() {
            Object obj = this.stage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.stage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getStatus() {
            Object obj = this.status_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.status_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getStatusBytes() {
            Object obj = this.status_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.status_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getTargetUid() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getTargetUidBytes() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getTargetUrl() {
            Object obj = this.targetUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getTargetUrlBytes() {
            Object obj = this.targetUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public int getTaskType() {
            return this.taskType_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public int getTime() {
            return this.time_;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
        public int getWidth() {
            return this.width_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + getUrl().hashCode()) * 37) + 3) * 53) + getTargetUrl().hashCode()) * 37) + 4) * 53) + getType().hashCode()) * 37) + 5) * 53) + getContent().hashCode()) * 37) + 6) * 53) + getScene().hashCode()) * 37) + 7) * 53) + getId().hashCode()) * 37) + 9) * 53) + getChannel().hashCode()) * 37) + 10) * 53) + getStage().hashCode()) * 37) + 11) * 53) + getName().hashCode()) * 37) + 12) * 53) + getTargetUid().hashCode()) * 37) + 13) * 53) + getLiveId().hashCode()) * 37) + 14) * 53) + getAnchorUid().hashCode()) * 37) + 15) * 53) + getPostId().hashCode()) * 37) + 16) * 53) + getPosition().hashCode()) * 37) + 17) * 53) + Internal.hashBoolean(getIsTrue())) * 37) + 18) * 53) + Internal.hashBoolean(getIsActive())) * 37) + 19) * 53) + Internal.hashBoolean(getIsFirst())) * 37) + 20) * 53) + getMode().hashCode()) * 37) + 21) * 53) + getReason().hashCode()) * 37) + 22) * 53) + getNum()) * 37) + 23) * 53) + this.enumType_) * 37) + 24) * 53) + getPage().hashCode()) * 37) + 25) * 53) + getCampaign().hashCode()) * 37) + 26) * 53) + this.sortType_) * 37) + 27) * 53) + getFrom().hashCode()) * 37) + 28) * 53) + getTime()) * 37) + 29) * 53) + getSource().hashCode()) * 37) + 30) * 53) + getAgency().hashCode()) * 37) + 31) * 53) + getChannelNum().hashCode()) * 37) + 32) * 53) + getTaskType()) * 37) + 33) * 53) + Internal.hashBoolean(getIsBoughtVip())) * 37) + 34) * 53) + Internal.hashLong(getCostTime())) * 37) + 35) * 53) + getOriginalPage().hashCode()) * 37) + 36) * 53) + getStatus().hashCode()) * 37) + 37) * 53) + getNum2()) * 37) + 38) * 53) + getAdResult().hashCode()) * 37) + 39) * 53) + getNum3()) * 37) + 40) * 53) + getWidth()) * 37) + 41) * 53) + getHigh()) * 37) + 42) * 53) + getLonLat().hashCode()) * 37) + 43) * 53) + getDeviceId().hashCode()) * 37) + 44) * 53) + getLocationType()) * 37) + 45) * 53) + getPrecision().hashCode()) * 37) + 46) * 53) + getProvider().hashCode()) * 37) + 47) * 53) + getLocationTime().hashCode()) * 37) + 48) * 53) + getCallBackTime().hashCode()) * 37) + 49) * 53) + getAddress().hashCode()) * 37) + 50) * 53) + getDescription().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return OthersProtos.internal_static_com_irisdt_client_others_OthersProto_fieldAccessorTable.ensureFieldAccessorsInitialized(OthersProto.class, Builder.class);
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
            return new OthersProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.event_ != Event.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(1, this.event_);
            }
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.url_);
            }
            if (!getTargetUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.targetUrl_);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.type_);
            }
            if (!getContentBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.content_);
            }
            if (!getSceneBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.scene_);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.id_);
            }
            if (!getChannelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.channel_);
            }
            if (!getStageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.stage_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.name_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.targetUid_);
            }
            if (!getLiveIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.liveId_);
            }
            if (!getAnchorUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 14, this.anchorUid_);
            }
            if (!getPostIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 15, this.postId_);
            }
            if (!getPositionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 16, this.position_);
            }
            boolean z10 = this.isTrue_;
            if (z10) {
                codedOutputStream.writeBool(17, z10);
            }
            boolean z11 = this.isActive_;
            if (z11) {
                codedOutputStream.writeBool(18, z11);
            }
            boolean z12 = this.isFirst_;
            if (z12) {
                codedOutputStream.writeBool(19, z12);
            }
            if (!getModeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 20, this.mode_);
            }
            if (!getReasonBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 21, this.reason_);
            }
            int i10 = this.num_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(22, i10);
            }
            if (this.enumType_ != Enum_type.UNKNOWN_ENUM_TYPE.getNumber()) {
                codedOutputStream.writeEnum(23, this.enumType_);
            }
            if (!getPageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 24, this.page_);
            }
            if (!getCampaignBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 25, this.campaign_);
            }
            if (this.sortType_ != SortType.UNKNOWN_SORT_TYPE.getNumber()) {
                codedOutputStream.writeEnum(26, this.sortType_);
            }
            if (!getFromBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 27, this.from_);
            }
            int i11 = this.time_;
            if (i11 != 0) {
                codedOutputStream.writeInt32(28, i11);
            }
            if (!getSourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 29, this.source_);
            }
            if (!getAgencyBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 30, this.agency_);
            }
            if (!getChannelNumBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 31, this.channelNum_);
            }
            int i12 = this.taskType_;
            if (i12 != 0) {
                codedOutputStream.writeInt32(32, i12);
            }
            boolean z13 = this.isBoughtVip_;
            if (z13) {
                codedOutputStream.writeBool(33, z13);
            }
            long j10 = this.costTime_;
            if (j10 != 0) {
                codedOutputStream.writeInt64(34, j10);
            }
            if (!getOriginalPageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 35, this.originalPage_);
            }
            if (!getStatusBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 36, this.status_);
            }
            int i13 = this.num2_;
            if (i13 != 0) {
                codedOutputStream.writeInt32(37, i13);
            }
            if (!getAdResultBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 38, this.adResult_);
            }
            int i14 = this.num3_;
            if (i14 != 0) {
                codedOutputStream.writeInt32(39, i14);
            }
            int i15 = this.width_;
            if (i15 != 0) {
                codedOutputStream.writeInt32(40, i15);
            }
            int i16 = this.high_;
            if (i16 != 0) {
                codedOutputStream.writeInt32(41, i16);
            }
            if (!getLonLatBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 42, this.lonLat_);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 43, this.deviceId_);
            }
            int i17 = this.locationType_;
            if (i17 != 0) {
                codedOutputStream.writeInt32(44, i17);
            }
            if (!getPrecisionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 45, this.precision_);
            }
            if (!getProviderBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 46, this.provider_);
            }
            if (!getLocationTimeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 47, this.locationTime_);
            }
            if (!getCallBackTimeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 48, this.callBackTime_);
            }
            if (!getAddressBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 49, this.address_);
            }
            if (!getDescriptionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 50, this.description_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OthersProtoOrBuilder {
            private Object adResult_;
            private Object address_;
            private Object agency_;
            private Object anchorUid_;
            private Object callBackTime_;
            private Object campaign_;
            private Object channelNum_;
            private Object channel_;
            private Object content_;
            private long costTime_;
            private Object description_;
            private Object deviceId_;
            private int enumType_;
            private int event_;
            private Object from_;
            private int high_;
            private Object id_;
            private boolean isActive_;
            private boolean isBoughtVip_;
            private boolean isFirst_;
            private boolean isTrue_;
            private Object liveId_;
            private Object locationTime_;
            private int locationType_;
            private Object lonLat_;
            private Object mode_;
            private Object name_;
            private int num2_;
            private int num3_;
            private int num_;
            private Object originalPage_;
            private Object page_;
            private Object position_;
            private Object postId_;
            private Object precision_;
            private Object provider_;
            private Object reason_;
            private Object scene_;
            private int sortType_;
            private Object source_;
            private Object stage_;
            private Object status_;
            private Object targetUid_;
            private Object targetUrl_;
            private int taskType_;
            private int time_;
            private Object type_;
            private Object url_;
            private int width_;

            private Builder() {
                this.event_ = 0;
                this.url_ = "";
                this.targetUrl_ = "";
                this.type_ = "";
                this.content_ = "";
                this.scene_ = "";
                this.id_ = "";
                this.channel_ = "";
                this.stage_ = "";
                this.name_ = "";
                this.targetUid_ = "";
                this.liveId_ = "";
                this.anchorUid_ = "";
                this.postId_ = "";
                this.position_ = "";
                this.mode_ = "";
                this.reason_ = "";
                this.enumType_ = 0;
                this.page_ = "";
                this.campaign_ = "";
                this.sortType_ = 0;
                this.from_ = "";
                this.source_ = "";
                this.agency_ = "";
                this.channelNum_ = "";
                this.originalPage_ = "";
                this.status_ = "";
                this.adResult_ = "";
                this.lonLat_ = "";
                this.deviceId_ = "";
                this.precision_ = "";
                this.provider_ = "";
                this.locationTime_ = "";
                this.callBackTime_ = "";
                this.address_ = "";
                this.description_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return OthersProtos.internal_static_com_irisdt_client_others_OthersProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAdResult() {
                this.adResult_ = OthersProto.getDefaultInstance().getAdResult();
                onChanged();
                return this;
            }

            public Builder clearAddress() {
                this.address_ = OthersProto.getDefaultInstance().getAddress();
                onChanged();
                return this;
            }

            public Builder clearAgency() {
                this.agency_ = OthersProto.getDefaultInstance().getAgency();
                onChanged();
                return this;
            }

            public Builder clearAnchorUid() {
                this.anchorUid_ = OthersProto.getDefaultInstance().getAnchorUid();
                onChanged();
                return this;
            }

            public Builder clearCallBackTime() {
                this.callBackTime_ = OthersProto.getDefaultInstance().getCallBackTime();
                onChanged();
                return this;
            }

            public Builder clearCampaign() {
                this.campaign_ = OthersProto.getDefaultInstance().getCampaign();
                onChanged();
                return this;
            }

            public Builder clearChannel() {
                this.channel_ = OthersProto.getDefaultInstance().getChannel();
                onChanged();
                return this;
            }

            public Builder clearChannelNum() {
                this.channelNum_ = OthersProto.getDefaultInstance().getChannelNum();
                onChanged();
                return this;
            }

            public Builder clearContent() {
                this.content_ = OthersProto.getDefaultInstance().getContent();
                onChanged();
                return this;
            }

            public Builder clearCostTime() {
                this.costTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearDescription() {
                this.description_ = OthersProto.getDefaultInstance().getDescription();
                onChanged();
                return this;
            }

            public Builder clearDeviceId() {
                this.deviceId_ = OthersProto.getDefaultInstance().getDeviceId();
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

            public Builder clearFrom() {
                this.from_ = OthersProto.getDefaultInstance().getFrom();
                onChanged();
                return this;
            }

            public Builder clearHigh() {
                this.high_ = 0;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = OthersProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearIsActive() {
                this.isActive_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsBoughtVip() {
                this.isBoughtVip_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsFirst() {
                this.isFirst_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTrue() {
                this.isTrue_ = false;
                onChanged();
                return this;
            }

            public Builder clearLiveId() {
                this.liveId_ = OthersProto.getDefaultInstance().getLiveId();
                onChanged();
                return this;
            }

            public Builder clearLocationTime() {
                this.locationTime_ = OthersProto.getDefaultInstance().getLocationTime();
                onChanged();
                return this;
            }

            public Builder clearLocationType() {
                this.locationType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearLonLat() {
                this.lonLat_ = OthersProto.getDefaultInstance().getLonLat();
                onChanged();
                return this;
            }

            public Builder clearMode() {
                this.mode_ = OthersProto.getDefaultInstance().getMode();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = OthersProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.num_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNum2() {
                this.num2_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNum3() {
                this.num3_ = 0;
                onChanged();
                return this;
            }

            public Builder clearOriginalPage() {
                this.originalPage_ = OthersProto.getDefaultInstance().getOriginalPage();
                onChanged();
                return this;
            }

            public Builder clearPage() {
                this.page_ = OthersProto.getDefaultInstance().getPage();
                onChanged();
                return this;
            }

            public Builder clearPosition() {
                this.position_ = OthersProto.getDefaultInstance().getPosition();
                onChanged();
                return this;
            }

            public Builder clearPostId() {
                this.postId_ = OthersProto.getDefaultInstance().getPostId();
                onChanged();
                return this;
            }

            public Builder clearPrecision() {
                this.precision_ = OthersProto.getDefaultInstance().getPrecision();
                onChanged();
                return this;
            }

            public Builder clearProvider() {
                this.provider_ = OthersProto.getDefaultInstance().getProvider();
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = OthersProto.getDefaultInstance().getReason();
                onChanged();
                return this;
            }

            public Builder clearScene() {
                this.scene_ = OthersProto.getDefaultInstance().getScene();
                onChanged();
                return this;
            }

            public Builder clearSortType() {
                this.sortType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.source_ = OthersProto.getDefaultInstance().getSource();
                onChanged();
                return this;
            }

            public Builder clearStage() {
                this.stage_ = OthersProto.getDefaultInstance().getStage();
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.status_ = OthersProto.getDefaultInstance().getStatus();
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = OthersProto.getDefaultInstance().getTargetUid();
                onChanged();
                return this;
            }

            public Builder clearTargetUrl() {
                this.targetUrl_ = OthersProto.getDefaultInstance().getTargetUrl();
                onChanged();
                return this;
            }

            public Builder clearTaskType() {
                this.taskType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = OthersProto.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = OthersProto.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            public Builder clearWidth() {
                this.width_ = 0;
                onChanged();
                return this;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getAdResult() {
                Object obj = this.adResult_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.adResult_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getAdResultBytes() {
                Object obj = this.adResult_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.adResult_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getAddress() {
                Object obj = this.address_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.address_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getAddressBytes() {
                Object obj = this.address_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.address_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getAgency() {
                Object obj = this.agency_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.agency_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getAgencyBytes() {
                Object obj = this.agency_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.agency_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getAnchorUid() {
                Object obj = this.anchorUid_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.anchorUid_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getAnchorUidBytes() {
                Object obj = this.anchorUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.anchorUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getCallBackTime() {
                Object obj = this.callBackTime_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.callBackTime_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getCallBackTimeBytes() {
                Object obj = this.callBackTime_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.callBackTime_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getCampaign() {
                Object obj = this.campaign_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.campaign_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getCampaignBytes() {
                Object obj = this.campaign_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.campaign_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getChannel() {
                Object obj = this.channel_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.channel_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getChannelBytes() {
                Object obj = this.channel_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.channel_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getChannelNum() {
                Object obj = this.channelNum_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.channelNum_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getChannelNumBytes() {
                Object obj = this.channelNum_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.channelNum_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getContent() {
                Object obj = this.content_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.content_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getContentBytes() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.content_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public long getCostTime() {
                return this.costTime_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getDescription() {
                Object obj = this.description_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.description_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getDescriptionBytes() {
                Object obj = this.description_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.description_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return OthersProtos.internal_static_com_irisdt_client_others_OthersProto_descriptor;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getDeviceId() {
                Object obj = this.deviceId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.deviceId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getDeviceIdBytes() {
                Object obj = this.deviceId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.deviceId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public Enum_type getEnumType() {
                Enum_type valueOf = Enum_type.valueOf(this.enumType_);
                return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public int getEnumTypeValue() {
                return this.enumType_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                return valueOf == null ? Event.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getFrom() {
                Object obj = this.from_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.from_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getFromBytes() {
                Object obj = this.from_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.from_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public int getHigh() {
                return this.high_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.id_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public boolean getIsActive() {
                return this.isActive_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public boolean getIsBoughtVip() {
                return this.isBoughtVip_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public boolean getIsFirst() {
                return this.isFirst_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public boolean getIsTrue() {
                return this.isTrue_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getLiveId() {
                Object obj = this.liveId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.liveId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getLiveIdBytes() {
                Object obj = this.liveId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.liveId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getLocationTime() {
                Object obj = this.locationTime_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.locationTime_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getLocationTimeBytes() {
                Object obj = this.locationTime_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.locationTime_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public int getLocationType() {
                return this.locationType_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getLonLat() {
                Object obj = this.lonLat_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.lonLat_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getLonLatBytes() {
                Object obj = this.lonLat_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.lonLat_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getMode() {
                Object obj = this.mode_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.mode_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getModeBytes() {
                Object obj = this.mode_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mode_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.name_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public int getNum() {
                return this.num_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public int getNum2() {
                return this.num2_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public int getNum3() {
                return this.num3_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getOriginalPage() {
                Object obj = this.originalPage_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.originalPage_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getOriginalPageBytes() {
                Object obj = this.originalPage_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.originalPage_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getPage() {
                Object obj = this.page_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.page_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getPageBytes() {
                Object obj = this.page_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.page_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getPosition() {
                Object obj = this.position_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.position_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getPositionBytes() {
                Object obj = this.position_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.position_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getPostId() {
                Object obj = this.postId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.postId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getPostIdBytes() {
                Object obj = this.postId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.postId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getPrecision() {
                Object obj = this.precision_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.precision_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getPrecisionBytes() {
                Object obj = this.precision_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.precision_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getProvider() {
                Object obj = this.provider_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.provider_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getProviderBytes() {
                Object obj = this.provider_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.provider_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getReason() {
                Object obj = this.reason_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.reason_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getReasonBytes() {
                Object obj = this.reason_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reason_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getScene() {
                Object obj = this.scene_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.scene_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getSceneBytes() {
                Object obj = this.scene_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.scene_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public SortType getSortType() {
                SortType valueOf = SortType.valueOf(this.sortType_);
                return valueOf == null ? SortType.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public int getSortTypeValue() {
                return this.sortType_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getSource() {
                Object obj = this.source_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.source_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getSourceBytes() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.source_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getStage() {
                Object obj = this.stage_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.stage_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getStageBytes() {
                Object obj = this.stage_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.stage_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getStatus() {
                Object obj = this.status_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.status_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getStatusBytes() {
                Object obj = this.status_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.status_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getTargetUid() {
                Object obj = this.targetUid_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.targetUid_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getTargetUidBytes() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getTargetUrl() {
                Object obj = this.targetUrl_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.targetUrl_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getTargetUrlBytes() {
                Object obj = this.targetUrl_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUrl_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public int getTaskType() {
                return this.taskType_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public int getTime() {
                return this.time_;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.type_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.url_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.others.OthersProtos.OthersProtoOrBuilder
            public int getWidth() {
                return this.width_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return OthersProtos.internal_static_com_irisdt_client_others_OthersProto_fieldAccessorTable.ensureFieldAccessorsInitialized(OthersProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAdResult(String str) {
                Objects.requireNonNull(str);
                this.adResult_ = str;
                onChanged();
                return this;
            }

            public Builder setAdResultBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.adResult_ = byteString;
                onChanged();
                return this;
            }

            public Builder setAddress(String str) {
                Objects.requireNonNull(str);
                this.address_ = str;
                onChanged();
                return this;
            }

            public Builder setAddressBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.address_ = byteString;
                onChanged();
                return this;
            }

            public Builder setAgency(String str) {
                Objects.requireNonNull(str);
                this.agency_ = str;
                onChanged();
                return this;
            }

            public Builder setAgencyBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.agency_ = byteString;
                onChanged();
                return this;
            }

            public Builder setAnchorUid(String str) {
                Objects.requireNonNull(str);
                this.anchorUid_ = str;
                onChanged();
                return this;
            }

            public Builder setAnchorUidBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.anchorUid_ = byteString;
                onChanged();
                return this;
            }

            public Builder setCallBackTime(String str) {
                Objects.requireNonNull(str);
                this.callBackTime_ = str;
                onChanged();
                return this;
            }

            public Builder setCallBackTimeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.callBackTime_ = byteString;
                onChanged();
                return this;
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

            public Builder setChannel(String str) {
                Objects.requireNonNull(str);
                this.channel_ = str;
                onChanged();
                return this;
            }

            public Builder setChannelBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.channel_ = byteString;
                onChanged();
                return this;
            }

            public Builder setChannelNum(String str) {
                Objects.requireNonNull(str);
                this.channelNum_ = str;
                onChanged();
                return this;
            }

            public Builder setChannelNumBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.channelNum_ = byteString;
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

            public Builder setDescription(String str) {
                Objects.requireNonNull(str);
                this.description_ = str;
                onChanged();
                return this;
            }

            public Builder setDescriptionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.description_ = byteString;
                onChanged();
                return this;
            }

            public Builder setDeviceId(String str) {
                Objects.requireNonNull(str);
                this.deviceId_ = str;
                onChanged();
                return this;
            }

            public Builder setDeviceIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.deviceId_ = byteString;
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

            public Builder setHigh(int i10) {
                this.high_ = i10;
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

            public Builder setIsActive(boolean z10) {
                this.isActive_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsBoughtVip(boolean z10) {
                this.isBoughtVip_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsFirst(boolean z10) {
                this.isFirst_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsTrue(boolean z10) {
                this.isTrue_ = z10;
                onChanged();
                return this;
            }

            public Builder setLiveId(String str) {
                Objects.requireNonNull(str);
                this.liveId_ = str;
                onChanged();
                return this;
            }

            public Builder setLiveIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.liveId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setLocationTime(String str) {
                Objects.requireNonNull(str);
                this.locationTime_ = str;
                onChanged();
                return this;
            }

            public Builder setLocationTimeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.locationTime_ = byteString;
                onChanged();
                return this;
            }

            public Builder setLocationType(int i10) {
                this.locationType_ = i10;
                onChanged();
                return this;
            }

            public Builder setLonLat(String str) {
                Objects.requireNonNull(str);
                this.lonLat_ = str;
                onChanged();
                return this;
            }

            public Builder setLonLatBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.lonLat_ = byteString;
                onChanged();
                return this;
            }

            public Builder setMode(String str) {
                Objects.requireNonNull(str);
                this.mode_ = str;
                onChanged();
                return this;
            }

            public Builder setModeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.mode_ = byteString;
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

            public Builder setNum2(int i10) {
                this.num2_ = i10;
                onChanged();
                return this;
            }

            public Builder setNum3(int i10) {
                this.num3_ = i10;
                onChanged();
                return this;
            }

            public Builder setOriginalPage(String str) {
                Objects.requireNonNull(str);
                this.originalPage_ = str;
                onChanged();
                return this;
            }

            public Builder setOriginalPageBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.originalPage_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPage(String str) {
                Objects.requireNonNull(str);
                this.page_ = str;
                onChanged();
                return this;
            }

            public Builder setPageBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.page_ = byteString;
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

            public Builder setPrecision(String str) {
                Objects.requireNonNull(str);
                this.precision_ = str;
                onChanged();
                return this;
            }

            public Builder setPrecisionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.precision_ = byteString;
                onChanged();
                return this;
            }

            public Builder setProvider(String str) {
                Objects.requireNonNull(str);
                this.provider_ = str;
                onChanged();
                return this;
            }

            public Builder setProviderBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.provider_ = byteString;
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

            public Builder setSortType(SortType sortType) {
                Objects.requireNonNull(sortType);
                this.sortType_ = sortType.getNumber();
                onChanged();
                return this;
            }

            public Builder setSortTypeValue(int i10) {
                this.sortType_ = i10;
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

            public Builder setStage(String str) {
                Objects.requireNonNull(str);
                this.stage_ = str;
                onChanged();
                return this;
            }

            public Builder setStageBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.stage_ = byteString;
                onChanged();
                return this;
            }

            public Builder setStatus(String str) {
                Objects.requireNonNull(str);
                this.status_ = str;
                onChanged();
                return this;
            }

            public Builder setStatusBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.status_ = byteString;
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

            public Builder setTargetUrl(String str) {
                Objects.requireNonNull(str);
                this.targetUrl_ = str;
                onChanged();
                return this;
            }

            public Builder setTargetUrlBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.targetUrl_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTaskType(int i10) {
                this.taskType_ = i10;
                onChanged();
                return this;
            }

            public Builder setTime(int i10) {
                this.time_ = i10;
                onChanged();
                return this;
            }

            public Builder setType(String str) {
                Objects.requireNonNull(str);
                this.type_ = str;
                onChanged();
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.type_ = byteString;
                onChanged();
                return this;
            }

            public Builder setUrl(String str) {
                Objects.requireNonNull(str);
                this.url_ = str;
                onChanged();
                return this;
            }

            public Builder setUrlBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.url_ = byteString;
                onChanged();
                return this;
            }

            public Builder setWidth(int i10) {
                this.width_ = i10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OthersProto build() {
                OthersProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OthersProto buildPartial() {
                OthersProto othersProto = new OthersProto(this);
                othersProto.event_ = this.event_;
                othersProto.url_ = this.url_;
                othersProto.targetUrl_ = this.targetUrl_;
                othersProto.type_ = this.type_;
                othersProto.content_ = this.content_;
                othersProto.scene_ = this.scene_;
                othersProto.id_ = this.id_;
                othersProto.channel_ = this.channel_;
                othersProto.stage_ = this.stage_;
                othersProto.name_ = this.name_;
                othersProto.targetUid_ = this.targetUid_;
                othersProto.liveId_ = this.liveId_;
                othersProto.anchorUid_ = this.anchorUid_;
                othersProto.postId_ = this.postId_;
                othersProto.position_ = this.position_;
                othersProto.isTrue_ = this.isTrue_;
                othersProto.isActive_ = this.isActive_;
                othersProto.isFirst_ = this.isFirst_;
                othersProto.mode_ = this.mode_;
                othersProto.reason_ = this.reason_;
                othersProto.num_ = this.num_;
                othersProto.enumType_ = this.enumType_;
                othersProto.page_ = this.page_;
                othersProto.campaign_ = this.campaign_;
                othersProto.sortType_ = this.sortType_;
                othersProto.from_ = this.from_;
                othersProto.time_ = this.time_;
                othersProto.source_ = this.source_;
                othersProto.agency_ = this.agency_;
                othersProto.channelNum_ = this.channelNum_;
                othersProto.taskType_ = this.taskType_;
                othersProto.isBoughtVip_ = this.isBoughtVip_;
                othersProto.costTime_ = this.costTime_;
                othersProto.originalPage_ = this.originalPage_;
                othersProto.status_ = this.status_;
                othersProto.num2_ = this.num2_;
                othersProto.adResult_ = this.adResult_;
                othersProto.num3_ = this.num3_;
                othersProto.width_ = this.width_;
                othersProto.high_ = this.high_;
                othersProto.lonLat_ = this.lonLat_;
                othersProto.deviceId_ = this.deviceId_;
                othersProto.locationType_ = this.locationType_;
                othersProto.precision_ = this.precision_;
                othersProto.provider_ = this.provider_;
                othersProto.locationTime_ = this.locationTime_;
                othersProto.callBackTime_ = this.callBackTime_;
                othersProto.address_ = this.address_;
                othersProto.description_ = this.description_;
                onBuilt();
                return othersProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public OthersProto getDefaultInstanceForType() {
                return OthersProto.getDefaultInstance();
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
                this.url_ = "";
                this.targetUrl_ = "";
                this.type_ = "";
                this.content_ = "";
                this.scene_ = "";
                this.id_ = "";
                this.channel_ = "";
                this.stage_ = "";
                this.name_ = "";
                this.targetUid_ = "";
                this.liveId_ = "";
                this.anchorUid_ = "";
                this.postId_ = "";
                this.position_ = "";
                this.isTrue_ = false;
                this.isActive_ = false;
                this.isFirst_ = false;
                this.mode_ = "";
                this.reason_ = "";
                this.num_ = 0;
                this.enumType_ = 0;
                this.page_ = "";
                this.campaign_ = "";
                this.sortType_ = 0;
                this.from_ = "";
                this.time_ = 0;
                this.source_ = "";
                this.agency_ = "";
                this.channelNum_ = "";
                this.taskType_ = 0;
                this.isBoughtVip_ = false;
                this.costTime_ = 0L;
                this.originalPage_ = "";
                this.status_ = "";
                this.num2_ = 0;
                this.adResult_ = "";
                this.num3_ = 0;
                this.width_ = 0;
                this.high_ = 0;
                this.lonLat_ = "";
                this.deviceId_ = "";
                this.locationType_ = 0;
                this.precision_ = "";
                this.provider_ = "";
                this.locationTime_ = "";
                this.callBackTime_ = "";
                this.address_ = "";
                this.description_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof OthersProto) {
                    return mergeFrom((OthersProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(OthersProto othersProto) {
                if (othersProto == OthersProto.getDefaultInstance()) {
                    return this;
                }
                if (othersProto.event_ != 0) {
                    setEventValue(othersProto.getEventValue());
                }
                if (!othersProto.getUrl().isEmpty()) {
                    this.url_ = othersProto.url_;
                    onChanged();
                }
                if (!othersProto.getTargetUrl().isEmpty()) {
                    this.targetUrl_ = othersProto.targetUrl_;
                    onChanged();
                }
                if (!othersProto.getType().isEmpty()) {
                    this.type_ = othersProto.type_;
                    onChanged();
                }
                if (!othersProto.getContent().isEmpty()) {
                    this.content_ = othersProto.content_;
                    onChanged();
                }
                if (!othersProto.getScene().isEmpty()) {
                    this.scene_ = othersProto.scene_;
                    onChanged();
                }
                if (!othersProto.getId().isEmpty()) {
                    this.id_ = othersProto.id_;
                    onChanged();
                }
                if (!othersProto.getChannel().isEmpty()) {
                    this.channel_ = othersProto.channel_;
                    onChanged();
                }
                if (!othersProto.getStage().isEmpty()) {
                    this.stage_ = othersProto.stage_;
                    onChanged();
                }
                if (!othersProto.getName().isEmpty()) {
                    this.name_ = othersProto.name_;
                    onChanged();
                }
                if (!othersProto.getTargetUid().isEmpty()) {
                    this.targetUid_ = othersProto.targetUid_;
                    onChanged();
                }
                if (!othersProto.getLiveId().isEmpty()) {
                    this.liveId_ = othersProto.liveId_;
                    onChanged();
                }
                if (!othersProto.getAnchorUid().isEmpty()) {
                    this.anchorUid_ = othersProto.anchorUid_;
                    onChanged();
                }
                if (!othersProto.getPostId().isEmpty()) {
                    this.postId_ = othersProto.postId_;
                    onChanged();
                }
                if (!othersProto.getPosition().isEmpty()) {
                    this.position_ = othersProto.position_;
                    onChanged();
                }
                if (othersProto.getIsTrue()) {
                    setIsTrue(othersProto.getIsTrue());
                }
                if (othersProto.getIsActive()) {
                    setIsActive(othersProto.getIsActive());
                }
                if (othersProto.getIsFirst()) {
                    setIsFirst(othersProto.getIsFirst());
                }
                if (!othersProto.getMode().isEmpty()) {
                    this.mode_ = othersProto.mode_;
                    onChanged();
                }
                if (!othersProto.getReason().isEmpty()) {
                    this.reason_ = othersProto.reason_;
                    onChanged();
                }
                if (othersProto.getNum() != 0) {
                    setNum(othersProto.getNum());
                }
                if (othersProto.enumType_ != 0) {
                    setEnumTypeValue(othersProto.getEnumTypeValue());
                }
                if (!othersProto.getPage().isEmpty()) {
                    this.page_ = othersProto.page_;
                    onChanged();
                }
                if (!othersProto.getCampaign().isEmpty()) {
                    this.campaign_ = othersProto.campaign_;
                    onChanged();
                }
                if (othersProto.sortType_ != 0) {
                    setSortTypeValue(othersProto.getSortTypeValue());
                }
                if (!othersProto.getFrom().isEmpty()) {
                    this.from_ = othersProto.from_;
                    onChanged();
                }
                if (othersProto.getTime() != 0) {
                    setTime(othersProto.getTime());
                }
                if (!othersProto.getSource().isEmpty()) {
                    this.source_ = othersProto.source_;
                    onChanged();
                }
                if (!othersProto.getAgency().isEmpty()) {
                    this.agency_ = othersProto.agency_;
                    onChanged();
                }
                if (!othersProto.getChannelNum().isEmpty()) {
                    this.channelNum_ = othersProto.channelNum_;
                    onChanged();
                }
                if (othersProto.getTaskType() != 0) {
                    setTaskType(othersProto.getTaskType());
                }
                if (othersProto.getIsBoughtVip()) {
                    setIsBoughtVip(othersProto.getIsBoughtVip());
                }
                if (othersProto.getCostTime() != 0) {
                    setCostTime(othersProto.getCostTime());
                }
                if (!othersProto.getOriginalPage().isEmpty()) {
                    this.originalPage_ = othersProto.originalPage_;
                    onChanged();
                }
                if (!othersProto.getStatus().isEmpty()) {
                    this.status_ = othersProto.status_;
                    onChanged();
                }
                if (othersProto.getNum2() != 0) {
                    setNum2(othersProto.getNum2());
                }
                if (!othersProto.getAdResult().isEmpty()) {
                    this.adResult_ = othersProto.adResult_;
                    onChanged();
                }
                if (othersProto.getNum3() != 0) {
                    setNum3(othersProto.getNum3());
                }
                if (othersProto.getWidth() != 0) {
                    setWidth(othersProto.getWidth());
                }
                if (othersProto.getHigh() != 0) {
                    setHigh(othersProto.getHigh());
                }
                if (!othersProto.getLonLat().isEmpty()) {
                    this.lonLat_ = othersProto.lonLat_;
                    onChanged();
                }
                if (!othersProto.getDeviceId().isEmpty()) {
                    this.deviceId_ = othersProto.deviceId_;
                    onChanged();
                }
                if (othersProto.getLocationType() != 0) {
                    setLocationType(othersProto.getLocationType());
                }
                if (!othersProto.getPrecision().isEmpty()) {
                    this.precision_ = othersProto.precision_;
                    onChanged();
                }
                if (!othersProto.getProvider().isEmpty()) {
                    this.provider_ = othersProto.provider_;
                    onChanged();
                }
                if (!othersProto.getLocationTime().isEmpty()) {
                    this.locationTime_ = othersProto.locationTime_;
                    onChanged();
                }
                if (!othersProto.getCallBackTime().isEmpty()) {
                    this.callBackTime_ = othersProto.callBackTime_;
                    onChanged();
                }
                if (!othersProto.getAddress().isEmpty()) {
                    this.address_ = othersProto.address_;
                    onChanged();
                }
                if (!othersProto.getDescription().isEmpty()) {
                    this.description_ = othersProto.description_;
                    onChanged();
                }
                mergeUnknownFields(othersProto.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.url_ = "";
                this.targetUrl_ = "";
                this.type_ = "";
                this.content_ = "";
                this.scene_ = "";
                this.id_ = "";
                this.channel_ = "";
                this.stage_ = "";
                this.name_ = "";
                this.targetUid_ = "";
                this.liveId_ = "";
                this.anchorUid_ = "";
                this.postId_ = "";
                this.position_ = "";
                this.mode_ = "";
                this.reason_ = "";
                this.enumType_ = 0;
                this.page_ = "";
                this.campaign_ = "";
                this.sortType_ = 0;
                this.from_ = "";
                this.source_ = "";
                this.agency_ = "";
                this.channelNum_ = "";
                this.originalPage_ = "";
                this.status_ = "";
                this.adResult_ = "";
                this.lonLat_ = "";
                this.deviceId_ = "";
                this.precision_ = "";
                this.provider_ = "";
                this.locationTime_ = "";
                this.callBackTime_ = "";
                this.address_ = "";
                this.description_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.irisdt.client.others.OthersProtos.OthersProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.client.others.OthersProtos.OthersProto.H0()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.client.others.OthersProtos$OthersProto r3 = (com.irisdt.client.others.OthersProtos.OthersProto) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.irisdt.client.others.OthersProtos$OthersProto r4 = (com.irisdt.client.others.OthersProtos.OthersProto) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.client.others.OthersProtos.OthersProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.client.others.OthersProtos$OthersProto$Builder");
            }
        }

        public static Builder newBuilder(OthersProto othersProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(othersProto);
        }

        public static OthersProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private OthersProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.url_ = "";
            this.targetUrl_ = "";
            this.type_ = "";
            this.content_ = "";
            this.scene_ = "";
            this.id_ = "";
            this.channel_ = "";
            this.stage_ = "";
            this.name_ = "";
            this.targetUid_ = "";
            this.liveId_ = "";
            this.anchorUid_ = "";
            this.postId_ = "";
            this.position_ = "";
            this.mode_ = "";
            this.reason_ = "";
            this.enumType_ = 0;
            this.page_ = "";
            this.campaign_ = "";
            this.sortType_ = 0;
            this.from_ = "";
            this.source_ = "";
            this.agency_ = "";
            this.channelNum_ = "";
            this.originalPage_ = "";
            this.status_ = "";
            this.adResult_ = "";
            this.lonLat_ = "";
            this.deviceId_ = "";
            this.precision_ = "";
            this.provider_ = "";
            this.locationTime_ = "";
            this.callBackTime_ = "";
            this.address_ = "";
            this.description_ = "";
        }

        public static OthersProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OthersProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static OthersProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public OthersProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static OthersProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static OthersProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static OthersProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static OthersProto parseFrom(InputStream inputStream) throws IOException {
            return (OthersProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static OthersProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OthersProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static OthersProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OthersProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static OthersProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OthersProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
        private OthersProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.url_ = codedInputStream.readStringRequireUtf8();
                            case 26:
                                this.targetUrl_ = codedInputStream.readStringRequireUtf8();
                            case 34:
                                this.type_ = codedInputStream.readStringRequireUtf8();
                            case 42:
                                this.content_ = codedInputStream.readStringRequireUtf8();
                            case 50:
                                this.scene_ = codedInputStream.readStringRequireUtf8();
                            case 58:
                                this.id_ = codedInputStream.readStringRequireUtf8();
                            case 74:
                                this.channel_ = codedInputStream.readStringRequireUtf8();
                            case 82:
                                this.stage_ = codedInputStream.readStringRequireUtf8();
                            case 90:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            case 98:
                                this.targetUid_ = codedInputStream.readStringRequireUtf8();
                            case 106:
                                this.liveId_ = codedInputStream.readStringRequireUtf8();
                            case 114:
                                this.anchorUid_ = codedInputStream.readStringRequireUtf8();
                            case 122:
                                this.postId_ = codedInputStream.readStringRequireUtf8();
                            case 130:
                                this.position_ = codedInputStream.readStringRequireUtf8();
                            case 136:
                                this.isTrue_ = codedInputStream.readBool();
                            case 144:
                                this.isActive_ = codedInputStream.readBool();
                            case 152:
                                this.isFirst_ = codedInputStream.readBool();
                            case 162:
                                this.mode_ = codedInputStream.readStringRequireUtf8();
                            case 170:
                                this.reason_ = codedInputStream.readStringRequireUtf8();
                            case 176:
                                this.num_ = codedInputStream.readInt32();
                            case 184:
                                this.enumType_ = codedInputStream.readEnum();
                            case 194:
                                this.page_ = codedInputStream.readStringRequireUtf8();
                            case 202:
                                this.campaign_ = codedInputStream.readStringRequireUtf8();
                            case 208:
                                this.sortType_ = codedInputStream.readEnum();
                            case 218:
                                this.from_ = codedInputStream.readStringRequireUtf8();
                            case 224:
                                this.time_ = codedInputStream.readInt32();
                            case 234:
                                this.source_ = codedInputStream.readStringRequireUtf8();
                            case 242:
                                this.agency_ = codedInputStream.readStringRequireUtf8();
                            case 250:
                                this.channelNum_ = codedInputStream.readStringRequireUtf8();
                            case 256:
                                this.taskType_ = codedInputStream.readInt32();
                            case 264:
                                this.isBoughtVip_ = codedInputStream.readBool();
                            case 272:
                                this.costTime_ = codedInputStream.readInt64();
                            case 282:
                                this.originalPage_ = codedInputStream.readStringRequireUtf8();
                            case 290:
                                this.status_ = codedInputStream.readStringRequireUtf8();
                            case 296:
                                this.num2_ = codedInputStream.readInt32();
                            case 306:
                                this.adResult_ = codedInputStream.readStringRequireUtf8();
                            case 312:
                                this.num3_ = codedInputStream.readInt32();
                            case 320:
                                this.width_ = codedInputStream.readInt32();
                            case 328:
                                this.high_ = codedInputStream.readInt32();
                            case 338:
                                this.lonLat_ = codedInputStream.readStringRequireUtf8();
                            case 346:
                                this.deviceId_ = codedInputStream.readStringRequireUtf8();
                            case 352:
                                this.locationType_ = codedInputStream.readInt32();
                            case MetricsProto.MetricsEvent.ACTION_QS_EDIT_ADD_SPEC /* 362 */:
                                this.precision_ = codedInputStream.readStringRequireUtf8();
                            case 370:
                                this.provider_ = codedInputStream.readStringRequireUtf8();
                            case 378:
                                this.locationTime_ = codedInputStream.readStringRequireUtf8();
                            case 386:
                                this.callBackTime_ = codedInputStream.readStringRequireUtf8();
                            case 394:
                                this.address_ = codedInputStream.readStringRequireUtf8();
                            case 402:
                                this.description_ = codedInputStream.readStringRequireUtf8();
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
    public interface OthersProtoOrBuilder extends MessageOrBuilder {
        String getAdResult();

        ByteString getAdResultBytes();

        String getAddress();

        ByteString getAddressBytes();

        String getAgency();

        ByteString getAgencyBytes();

        String getAnchorUid();

        ByteString getAnchorUidBytes();

        String getCallBackTime();

        ByteString getCallBackTimeBytes();

        String getCampaign();

        ByteString getCampaignBytes();

        String getChannel();

        ByteString getChannelBytes();

        String getChannelNum();

        ByteString getChannelNumBytes();

        String getContent();

        ByteString getContentBytes();

        long getCostTime();

        String getDescription();

        ByteString getDescriptionBytes();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        Enum_type getEnumType();

        int getEnumTypeValue();

        Event getEvent();

        int getEventValue();

        String getFrom();

        ByteString getFromBytes();

        int getHigh();

        String getId();

        ByteString getIdBytes();

        boolean getIsActive();

        boolean getIsBoughtVip();

        boolean getIsFirst();

        boolean getIsTrue();

        String getLiveId();

        ByteString getLiveIdBytes();

        String getLocationTime();

        ByteString getLocationTimeBytes();

        int getLocationType();

        String getLonLat();

        ByteString getLonLatBytes();

        String getMode();

        ByteString getModeBytes();

        String getName();

        ByteString getNameBytes();

        int getNum();

        int getNum2();

        int getNum3();

        String getOriginalPage();

        ByteString getOriginalPageBytes();

        String getPage();

        ByteString getPageBytes();

        String getPosition();

        ByteString getPositionBytes();

        String getPostId();

        ByteString getPostIdBytes();

        String getPrecision();

        ByteString getPrecisionBytes();

        String getProvider();

        ByteString getProviderBytes();

        String getReason();

        ByteString getReasonBytes();

        String getScene();

        ByteString getSceneBytes();

        SortType getSortType();

        int getSortTypeValue();

        String getSource();

        ByteString getSourceBytes();

        String getStage();

        ByteString getStageBytes();

        String getStatus();

        ByteString getStatusBytes();

        String getTargetUid();

        ByteString getTargetUidBytes();

        String getTargetUrl();

        ByteString getTargetUrlBytes();

        int getTaskType();

        int getTime();

        String getType();

        ByteString getTypeBytes();

        String getUrl();

        ByteString getUrlBytes();

        int getWidth();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum SortType implements ProtocolMessageEnum {
        UNKNOWN_SORT_TYPE(0),
        FOLLOW(1),
        TIME(2),
        CLOSE_FRIENDS(3),
        SPECIAL_ATTENTION(4),
        UNRECOGNIZED(-1);

        public static final int CLOSE_FRIENDS_VALUE = 3;
        public static final int FOLLOW_VALUE = 1;
        public static final int SPECIAL_ATTENTION_VALUE = 4;
        public static final int TIME_VALUE = 2;
        public static final int UNKNOWN_SORT_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<SortType> internalValueMap = new Internal.EnumLiteMap<SortType>() { // from class: com.irisdt.client.others.OthersProtos.SortType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public SortType findValueByNumber(int i10) {
                return SortType.forNumber(i10);
            }
        };
        private static final SortType[] VALUES = values();

        SortType(int i10) {
            this.value = i10;
        }

        public static SortType forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_SORT_TYPE;
            }
            if (i10 == 1) {
                return FOLLOW;
            }
            if (i10 == 2) {
                return TIME;
            }
            if (i10 == 3) {
                return CLOSE_FRIENDS;
            }
            if (i10 != 4) {
                return null;
            }
            return SPECIAL_ATTENTION;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return OthersProtos.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<SortType> internalGetValueMap() {
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
        public static SortType valueOf(int i10) {
            return forNumber(i10);
        }

        public static SortType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
        internal_static_com_irisdt_client_others_OthersProto_descriptor = descriptor2;
        internal_static_com_irisdt_client_others_OthersProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{com.huawei.hianalytics.core.storage.Event.TAG, "Url", "TargetUrl", "Type", "Content", "Scene", "Id", "Channel", "Stage", "Name", "TargetUid", "LiveId", "AnchorUid", "PostId", "Position", "IsTrue", "IsActive", "IsFirst", "Mode", "Reason", "Num", "EnumType", "Page", "Campaign", "SortType", "From", "Time", "Source", "Agency", "ChannelNum", "TaskType", "IsBoughtVip", "CostTime", "OriginalPage", "Status", "Num2", "AdResult", "Num3", "Width", "High", "LonLat", "DeviceId", "LocationType", "Precision", "Provider", "LocationTime", "CallBackTime", "Address", "Description"});
    }

    private OthersProtos() {
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
