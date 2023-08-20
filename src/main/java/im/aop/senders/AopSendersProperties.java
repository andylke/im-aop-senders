package im.aop.senders;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Configuration properties for AOP Senders.
 *
 * @author Andy Lian
 */
@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = AopSendersProperties.PREFIX)
public class AopSendersProperties {

  public static final String PREFIX = "im.aop.senders";

  /**
   * Whether to enable AOP Senders
   */
  private boolean enabled = true;
}
