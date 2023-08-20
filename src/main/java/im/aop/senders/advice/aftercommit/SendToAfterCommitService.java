package im.aop.senders.advice.aftercommit;


import im.aop.senders.AopSendersProperties;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;

/**
 * Spring's Service for {@link SendToAfterCommit}.
 *
 * @author Andy Lian
 */
@RequiredArgsConstructor
public class SendToAfterCommitService {

  private final AopSendersProperties aopExecutorsProperties;

  public void sendToAfterCommit(JoinPoint joinPoint,
      SendToAfterCommit sendToAfterCommit, Object returnValue) {
  }
}
