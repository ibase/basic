package cn.wxper.basic.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by basic on 2016/4/11.
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView("/50x");

        String errMsg;
        if(ex instanceof CustomException){
            CustomException cex = (CustomException) ex;
            errMsg = cex.getMessage();
        } else {
            errMsg = ex.getMessage();
        }

        logger.error("error message --> "+errMsg);
        mv.addObject("errMsg",errMsg);
        return mv;
    }
}
