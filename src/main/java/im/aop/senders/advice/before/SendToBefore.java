package im.aop.senders.advice.before;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that indicates a method's arguments value should be sent to the specified destination
 * before entering the target method.
 *
 * @author Andy Lian
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface SendToBefore {

  /**
   * SpEL expression to be evaluated against the method parameters, then used as the content of the
   * message to be delivered.
   */
  String payload() default "";

  /**
   * SpEL expression to be evaluated against the method parameters, then used to make execution
   * conditional.
   */
  String condition() default "";

  /**
   * SpEL expression to be evaluated against the method parameters, then used to veto execution.
   */
  String unless() default "";
}
