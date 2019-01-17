package com.jkle.springboot.exception;

import com.jkle.springboot.util.ExceptionData;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: xujiale
 * @create: 2018/03/30
 * @description: 全局异常捕捉
 **/
@ControllerAdvice //注解定义全局异常处理类
public class GlobalExcepionHandler {

    private static String PARAMETER_ERROR = "参数错误:";
    private static String REQUIRED_PARAMETER = "必填字段";
    private static String PARAMETER = "字段";
    private static String IS_NOT_EMPTY = "不能为空";
    private static String INVALID_TYPE = "类型错误";
    private static String REQUIRE = "正确类型为";
    private static String NUMBER = "个数";
    private static String LENGTH = "长度";
    private static String CURRENT_LENGTH = "当前长度为";

    /*
     * 返回json数据或者String数据：
     * 那么需要在方法上加上注解：@ResponseBody
     * 添加return即可。
     */

    /*
     * 返回视图：
     * 定义一个ModelAndView即可，
     * 然后return;
     * 定义视图文件(比如：error.html,error.ftl,error.jsp);
     *
     */
    /**
     * 全局异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ExceptionData exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        ExceptionData exceptionData = new ExceptionData()
                .setStatus(-500)
                .setMessage(e.getMessage())
                .setTrace(e.getStackTrace());
        e.printStackTrace();
        return exceptionData;
    }

    /**
     * 主动抛业务异常
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ExceptionData myExceptionHandler(HttpServletRequest request, MyException e) throws Exception {
        ExceptionData exceptionData = new ExceptionData()
                .setStatus(-100)
                .setMessage(e.getMessage())
                .setTrace(e.getStackTrace());
        e.printStackTrace();
        return exceptionData;
    }

    /**
     * Valid校验异常 - @RequestParam注解:必填参数为空
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ExceptionData requestParameterExceptionHandler(HttpServletRequest request, MissingServletRequestParameterException e) throws Exception {
        String parameter = e.getParameterName();
        String message = PARAMETER_ERROR + REQUIRED_PARAMETER + parameter + IS_NOT_EMPTY;
        ExceptionData exceptionData = new ExceptionData()
                .setStatus(-200)
                .setMessage(message)
                .setTrace(e.getStackTrace());
        e.printStackTrace();
        return exceptionData;
    }

    /**
     * Valid校验异常 - @RequestParam注解:类型错误
     */
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ExceptionData methodArgumentTypeMismatchExceptionHandler(HttpServletRequest request, MethodArgumentTypeMismatchException e) throws Exception {
        String parameter = e.getName();
        String requireType = e.getRequiredType().getName();
        String message = PARAMETER_ERROR + PARAMETER + "'" + parameter + "'" + INVALID_TYPE + "," + REQUIRE + requireType;
        ExceptionData exceptionData = new ExceptionData()
                .setStatus(-201)
                .setMessage(message)
                .setTrace(e.getStackTrace());
        e.printStackTrace();
        return exceptionData;
    }

    /**
     * Valid校验异常 - @Valid注解 - GET
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ExceptionData bindExceptionHandler(HttpServletRequest request, BindException e) throws Exception {
        List<FieldError> errorList = e.getBindingResult().getFieldErrors();
        String exceptionMessage = null;
        if (errorList.size() != 0) {
            FieldError fieldError = errorList.get(0);
            String defaultMessage = fieldError.getDefaultMessage();
            String parameter = fieldError.getField();
            String errorCode = Arrays.toString(fieldError.getCodes());
            // 参数为空
            if (errorCode.contains("NotNull")) {
                exceptionMessage = REQUIRED_PARAMETER + "'" + parameter + "'" + IS_NOT_EMPTY;
            }
            // 取值错误
            else if (errorCode.contains("Min") || errorCode.contains("Max")) {
                exceptionMessage = PARAMETER + "'" + parameter + "'" + defaultMessage;
            }
            // 长度错误
            else if (errorCode.contains("Size")) {
                String rejectValue = fieldError.getRejectedValue().toString();
                int currentSize = rejectValue.length();
                exceptionMessage = PARAMETER + "'" + parameter + "'" + defaultMessage.replace(NUMBER,LENGTH) +
                        "," + CURRENT_LENGTH + currentSize;
            }
            // 类型错误
            else if (errorCode.contains("typeMismatch")) {
                String regex = "(?i)(?<=required type ').*?(?=')";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(defaultMessage);
                if (matcher.find()) {
                    defaultMessage = matcher.group();
                }
                exceptionMessage = PARAMETER + "'" + parameter + "'" + INVALID_TYPE  + "," + REQUIRE + defaultMessage;
            }
            else {
                exceptionMessage = defaultMessage;
            }
        }
        String message = PARAMETER_ERROR + exceptionMessage;
        ExceptionData exceptionData = new ExceptionData()
                .setStatus(-202)
                .setMessage(message)
                .setTrace(e.getStackTrace());
        e.printStackTrace();
        return exceptionData;
    }

    /**
     * Valid校验异常 - @Valid注解 - POST
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ExceptionData methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) throws Exception {
        List<FieldError> errorList = e.getBindingResult().getFieldErrors();
        String exceptionMessage = null;
        if (errorList.size() != 0) {
            FieldError fieldError = errorList.get(0);
            String defaultMessage = fieldError.getDefaultMessage();
            String parameter = fieldError.getField();
            String errorCode = Arrays.toString(fieldError.getCodes());
            // 参数为空
            if (errorCode.contains("NotNull")) {
                exceptionMessage = REQUIRED_PARAMETER + parameter + IS_NOT_EMPTY;
            }
            else {
                exceptionMessage = defaultMessage;
            }
        }
        String message = PARAMETER_ERROR + exceptionMessage;
        ExceptionData exceptionData = new ExceptionData()
                .setStatus(-203)
                .setMessage(message)
                .setTrace(e.getStackTrace());
        e.printStackTrace();
        return exceptionData;
    }
}
