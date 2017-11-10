package club.zenyuca.eee.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author yuca
 * 日期：2017-08-10 17:30:35
 */
@Aspect
@Component
public class ControllerAspect {

	private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

	@Pointcut(value = "execution(public * club.zenyuca.eee.controller.*.*(..))")
	public void log() {
	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		logger.info("url = {}", request.getRequestURL());
		logger.info("ip = {}", request.getRemoteAddr());
		logger.info("method = {}", request.getMethod());
		logger.info("class method = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.info("param = {}", joinPoint.getArgs());
	}

	@After("log()")
	public void doAfter(JoinPoint joinPoint) {
		logger.info("离开方法： {}", joinPoint);
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		logger.info("url = {}", request.getRequestURL());
		logger.info("ip = {}", request.getRemoteAddr());
		logger.info("method = {}", request.getMethod());
		logger.info("class method = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.info("param = {}", joinPoint.getArgs());
	}

	@AfterReturning(returning = "object", pointcut = "log()")
	public void afterReturning(Object object) {
		logger.info("returning = {}", object);
	}
}
