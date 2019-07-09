package com.uppfind.util.log;

/**
 * 基础的常量类
 *
 */
public interface ConstCommonString {

    /**
     * 日志跟踪ID
     */
    String TRACE_ID = "traceId";

    String STRING_ENCODING_UTF8 = "UTF-8";

    String APPLICATION_XML = "application/xml";

    String APPLICATION_JSON = "application/json";

    String APP_JSON_UTF_8 = APPLICATION_JSON + ConstPunctuation.SEMICOLON + "charset=" + STRING_ENCODING_UTF8;

    String APP_XML_UTF_8 = APPLICATION_XML + ConstPunctuation.SEMICOLON + "charset=" + STRING_ENCODING_UTF8;

    String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";

    String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
}
