package im.aop.senders.advice.aftercommit;

import im.aop.senders.AopSendersProperties;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;

/**
 * Spring's Service for {@link SendAfterCommit}.
 *
 * @author Andy Lian
 */
@RequiredArgsConstructor
public class SendAfterCommitService {

  private final AopSendersProperties aopExecutorsProperties;

  public void sendAfterCommit(
      JoinPoint joinPoint, SendAfterCommit sendAfterCommit, Object returnValue) {}
}
