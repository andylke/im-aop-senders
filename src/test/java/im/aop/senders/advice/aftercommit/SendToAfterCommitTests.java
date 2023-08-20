package im.aop.senders.advice.aftercommit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link SendToAfterCommit}.
 *
 * @author Andy Lian
 */
class SendToAfterCommitTests {

  @Test
  void payload_defaultValue() {
    @SendToAfterCommit
    class Local {}

    final SendToAfterCommit annotation = Local.class.getAnnotation(SendToAfterCommit.class);
    assertThat(annotation.payload()).isEmpty();
  }

  @Test
  void payload_givenAttributeValue() {
    @SendToAfterCommit(payload = "foo")
    class Local {}
    ;

    final SendToAfterCommit annotation = Local.class.getAnnotation(SendToAfterCommit.class);
    assertThat(annotation.payload()).isEqualTo("foo");
  }

  @Test
  void condition_defaultValue() {
    @SendToAfterCommit
    class Local {}

    final SendToAfterCommit annotation = Local.class.getAnnotation(SendToAfterCommit.class);
    assertThat(annotation.condition()).isEmpty();
  }

  @Test
  void condition_givenAttributeValue() {
    @SendToAfterCommit(condition = "foo")
    class Local {}
    ;

    final SendToAfterCommit annotation = Local.class.getAnnotation(SendToAfterCommit.class);
    assertThat(annotation.condition()).isEqualTo("foo");
  }

  @Test
  void unless_defaultValue() {
    @SendToAfterCommit
    class Local {}

    final SendToAfterCommit annotation = Local.class.getAnnotation(SendToAfterCommit.class);
    assertThat(annotation.unless()).isEmpty();
  }

  @Test
  void unless_givenAttributeValue() {
    @SendToAfterCommit(unless = "foo")
    class Local {}
    ;

    final SendToAfterCommit annotation = Local.class.getAnnotation(SendToAfterCommit.class);
    assertThat(annotation.unless()).isEqualTo("foo");
  }
}
