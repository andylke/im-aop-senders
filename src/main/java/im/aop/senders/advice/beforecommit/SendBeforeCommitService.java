package im.aop.senders.advice.beforecommit;

import im.aop.senders.AopSendersProperties;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;

/**
 * Spring's Service for {@link SendBeforeCommit}.
 *
 * @author Andy Lian
 */
@RequiredArgsConstructor
public class SendBeforeCommitService {

  private final AopSendersProperties aopExecutorsProperties;

  public void sendBeforeCommit(JoinPoint joinPoint, SendBeforeCommit sendBeforeCommit) {}
}
