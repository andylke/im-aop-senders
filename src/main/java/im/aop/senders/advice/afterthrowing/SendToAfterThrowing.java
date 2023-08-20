package im.aop.senders.advice.afterthrowing;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that indicates a method's thrown exception or, together with the arguments value
 * should be sent to the specified destination after leaving the method.
 *
 * @author Andy Lian
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface SendToAfterThrowing {

  /**
   * SpEL expression to be evaluated against the thrown exception and method parameters, then used
   * as the content of the message to be delivered.
   */
  String payload() default "";

  /**
   * SpEL expression to be evaluated against the thrown exception and method parameters, then used
   * to make execution conditional.
   */
  String condition() default "";

  /**
   * SpEL expression to be evaluated against the thrown exception and method parameters, then used
   * to veto execution.
   */
  String unless() default "";

}
