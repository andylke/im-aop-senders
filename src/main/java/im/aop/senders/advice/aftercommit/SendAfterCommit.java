package im.aop.senders.advice.aftercommit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that indicates a method's return value or, together with the arguments value should be
 * sent to the specified destination after transaction have been successfully committed.
 *
 * @author Andy Lian
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface SendAfterCommit {

  /**
   * SpEL expression to be evaluated against the returned value and method parameters, then used as
   * the content of the message to be delivered.
   */
  String payload() default "";

  /**
   * SpEL expression to be evaluated against the returned value and method parameters, then used to
   * make execution conditional.
   */
  String condition() default "";

  /**
   * SpEL expression to be evaluated against the return value and method parameters, then used to
   * veto execution.
   */
  String unless() default "";
}
