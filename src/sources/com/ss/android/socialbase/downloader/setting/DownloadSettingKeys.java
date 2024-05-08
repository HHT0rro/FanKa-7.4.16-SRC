package com.ss.android.socialbase.downloader.setting;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface DownloadSettingKeys {
    public static final String BUG_FIX = "bugfix";
    public static final String CANCEL_WITH_NET_OPT = "cancel_with_net_opt";
    public static final String DEBUG = "debug";
    public static final String DEFAULT_304_MAX_AGE = "default_304_max_age";
    public static final String DISABLED_TASK_KEYS = "disabled_task_keys";
    public static final String DISABLE_SQLITE_WAL = "disable_sqlite_wal";
    public static final String DISABLE_TASK_SETTING = "disable_task_setting";
    public static final String DIVIDE_PLUGIN = "divide_plugin";
    public static final String DNS_EXPIRE_MIN = "dns_expire_min";
    public static final String DOWNLOAD_FAILED_CHECK_NET = "download_failed_check_net";
    public static final String DOWNLOAD_FINISH_CHECK_TTMD5 = "download_finish_check_ttmd5";
    public static final String DOWNLOAD_SERVICE_FOREGROUND = "download_service_foreground";
    public static final String DOWNLOAD_WHEN_SPACE_NEGATIVE = "download_when_space_negative";
    public static final String ENABLE_REFLECT_SYSTEM_PROPERTIES = "enable_reflect_system_properties";
    public static final String FLUSH_BUFFER_SIZE_BYTE = "flush_buffer_size_byte";
    public static final String FORCE_CHECK_FILE_LENGTH = "force_check_file_length";
    public static final String FORCE_CLOSE_DOWNLOAD_CACHE_CHECK = "force_close_download_cache_check";
    public static final String GLOBAL_KEY_PRECONNECT_CONNECTION_OUTDATE_TIME = "preconnect_connection_outdate_time";
    public static final String GLOBAL_KEY_PRECONNECT_HEAD_INFO_OUTDATE_TIME = "preconnect_head_info_outdate_time";
    public static final String GLOBAL_KEY_PRECONNECT_MAX_CACHE_SIZE = "preconnect_max_cache_size";
    public static final String KEY_AH_PLANS = "ah_plans";
    public static final String KEY_ANTI_HIJACK_DIR = "download_dir";
    public static final String KEY_APP_INSTALL_RETURN_RESULT = "app_install_return_result";
    public static final String KEY_EXCEPTION_MSG_LENGTH = "exception_msg_length";
    public static final String KEY_PAUSE_RESERVE_ON_WIFI = "pause_reserve_on_wifi";
    public static final String KEY_SET_NOTIFICATION_GROUP = "set_notification_group";
    public static final String MONITOR_DOWNLOAD_CONNECT = "monitor_download_connect";
    public static final String MONITOR_DOWNLOAD_IO = "monitor_download_io";
    public static final String MONITOR_RW = "monitor_rw";
    public static final String MONITOR_SEGMENT_IO = "monitor_segment_io";
    public static final String MONITOR_SLA = "monitor_sla";
    public static final String NET_LIB_STRATEGY = "net_lib_strategy";
    public static final String NOTIFICATION_TEXT_OPT = "notification_text_opt";
    public static final String NOTIFICATION_TIME_WINDOW = "notification_time_window";
    public static final String NO_HIDE_NOTIFICATION = "no_hide_notification";
    public static final String NO_NET_OPT = "no_net_opt";
    public static final String OPT_MKDIR_FAILED = "opt_mkdir_failed";
    public static final String OPT_NOTIFICATION_UI = "enable_notification_ui";
    public static final String PACKAGE_FLAG_CONFIG = "package_flag_config";
    public static final String RESET_RETAIN_RETRY_TIMES = "reset_retain_retry_times";
    public static final String RETRY_SCHEDULE = "retry_schedule";
    public static final String RETRY_SCHEDULE_CONFIG = "retry_schedule_config";
    public static final String RW_CONCURRENT = "rw_concurrent";
    public static final String RW_CONCURRENT_MAX_BUFFER_COUNT = "rw_concurrent_max_buffer_count";
    public static final String SAVE_PATH_SECURITY = "save_path_security";
    public static final String SEGMENT_CONFIG = "segment_config";
    public static final String SETTING_TAG = "setting_tag";
    public static final String SPACE_FILL_MIN_KEEP_MB = "space_fill_min_keep_mb";
    public static final String SPACE_FILL_PART_DOWNLOAD = "space_fill_part_download";
    public static final String SYNC_INTERVAL_MS_BG = "sync_interval_ms_bg";
    public static final String SYNC_INTERVAL_MS_FG = "sync_interval_ms_fg";
    public static final String SYNC_STRATEGY = "sync_strategy";
    public static final String USE_HOST_DNS = "use_host_dns";
    public static final String USE_NETWORK_CALLBACK = "use_network_callback";
    public static final String oppo = "kllk";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface AhPlans {
        public static final String KEY_AH_DEVICE_PLANS = "device_plans";
        public static final String KEY_AH_DEVICE_REQUIREMENTS = "device_requirements";
        public static final String KEY_AH_DEVICE_ROM = "device_rom";
        public static final String KEY_AH_PLAN_TYPE = "type";
        public static final String KEY_ALLOW_OS_API_RANGE = "allow_os_api_range";
        public static final String KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP = "show_unknown_source_on_startup";
        public static final String KEY_JUMP_INTERVAL = "jump_interval";
        public static final String KEY_JUMP_UNKNOWN_SOURCE_ENABLE_FOR_ALL = "enable_for_all";
        public static final String KEY_JUMP_UNKNOWN_SOURCE_TIPS = "jump_unknown_source_tips";
        public static final String KEY_JUMP_UNKNWON_SOURCE_QUERY_INTERVAL = "query_interval";
        public static final String KEY_JUMP_UNKNWON_SOURCE_WAIT_TIME_OUT = "time_out_second";
        public static final String KEY_MIN_OS_API = "min_os_api";
        public static final String KEY_SECURITY_MODE = "scy_mode";
        public static final String KEY_SHOW_TIPS = "show_tips";
        public static final String KEY_SHOW_UNKNOWN_SOURCE_DIALOG = "show_unknown_source_dialog";

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public interface DeviceRequirements {
            public static final String KEY_ALLOW_VERSION_RANGE = "allow_version_range";
            public static final String KEY_ANTI_HIJACK_PACKAGE_NAMES = "package_names";
            public static final String KEY_ANTI_HIJACK_VERSION_ALLOW = "version_allow";
            public static final String KEY_ANTI_HIJACK_VERSION_BLOCK = "version_block";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface AntiHijackDir {
        public static final String KEY_ANTI_HIJACK_DIR_NAME = "dir_name";
        public static final String KEY_ANTI_HIJACK_INSTALL_DESC = "ins_desc";
        public static final String KEY_IGNORE_TASK_SAVE_PATH = "ignore_task_save_path";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface BugFix {
        public static final String BUGFIX_CLEAR_INVALID_TASK_ERROR = "clear_invalid_task_error";
        public static final String BUGFIX_FIX_GET_HTTP_RESP_HEAD_IGNORE_CASE = "fix_get_http_resp_head_ignore_case";
        public static final String BUGFIX_FIX_START_WITH_FILE_EXIST_UPDATE_ERROR = "fix_start_with_file_exist_update_error";
        public static final String BUGFIX_GET_DOWNLOAD_INFO_BY_LIST = "get_download_info_by_list";
        public static final String BUGFIX_PAUSE_WITH_INTERRUPT = "pause_with_interrupt";
        public static final String BUGFIX_SIGBUS_DOWNLOADER_DB = "fix_sigbus_downloader_db";
        public static final String DEFAULT = "default";
        public static final String FIX_END_FOR_FILE_EXIST_ERROR = "fix_end_for_file_exist_error";
        public static final String FIX_FILE_DATA_VALID = "fix_file_data_valid";
        public static final String FIX_FILE_EXIST_UPDATE_DOWNLOAD_INFO = "fix_file_exist_update_download_info";
        public static final String FIX_FILE_RENAME_FAILED = "fix_file_rename_failed";
        public static final String FIX_GET_TOTAL_BYTES = "fix_get_total_bytes";
        public static final String FIX_NOTIFY_TOO_FAST = "notify_too_fast";
        public static final String FIX_ON_CANCEL_CALL_TWICE = "fix_on_cancel_call_twice";
        public static final String FIX_RESUME_TASK_OVERRIDE_SETTINGS = "resume_task_override_settings";
        public static final String FIX_TASK_RESUME_DELAY = "task_resume_delay";
        public static final String IGNORE_BASE_EX_ON_STOP_STATUS = "ignore_base_ex_on_stop_status";
        public static final String NON_GOING_NOTIFICATION_FOREGROUND = "non_going_notification_foreground";
        public static final String NOT_AUTO_BOOT_SERVICE = "switch_not_auto_boot_service";
        public static final String NOT_DELETE_WHEN_CLEAN_SPACE = "not_delete_when_clean_space";
        public static final String SERVICE_ALIVE = "service_alive";
        public static final String STATUS_NOT_UPDATE_TO_DB = "status_not_update_to_db";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface OptimizeForError {
        public static final String OPTIMIZE_ADD_LISTENER = "optimize_add_listener";
        public static final String OPTIMIZE_HEAD_REQUEST = "optimize_head_request";
        public static final String OPTIMIZE_SAVE_PATH = "optimize_save_path";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface RetryScheduleConfig {
        public static final String ALLOW_ERROR_CODE = "allow_error_code";
        public static final String INTERVAL_SEC = "interval_sec";
        public static final String INTERVAL_SEC_ACCELERATION = "interval_sec_acceleration";
        public static final String MAX_COUNT = "max_count";
        public static final String USE_JOB_SCHEDULER = "use_job_scheduler";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface SegmentConfig {
        public static final String BUFFER_COUNT = "buffer_count";
        public static final String BUFFER_SIZE = "buffer_size";
        public static final String CONNECT_TIMEOUT = "connect_timeout";
        public static final String IP_STRATEGY = "ip_strategy";
        public static final String MAIN_RATIO = "main_ratio";
        public static final String POOR_SPEED_RATIO = "poor_speed_ratio";
        public static final String RATIO_SEGMENT = "ratio_segment";
        public static final String READ_TIMEOUT = "read_timeout";
        public static final String SEGMENT_MAX_KB = "segment_max_kb";
        public static final String SEGMENT_MIN_INIT_MB = "segment_min_init_mb";
        public static final String SEGMENT_MIN_KB = "segment_min_kb";
        public static final String SEGMENT_MODE = "segment_mode";
        public static final String THREAD_COUNT = "thread_count";
        public static final String URL_BALANCE = "url_balance";
    }
}
