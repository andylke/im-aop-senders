package im.aop.senders.advice.beforecommit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link SendBeforeCommit}.
 *
 * @author Andy Lian
 */
class SendBeforeCommitTests {

  @Test
  void payload_defaultValue() {
    @SendBeforeCommit
    class Local {}

    final SendBeforeCommit annotation = Local.class.getAnnotation(SendBeforeCommit.class);
    assertThat(annotation.payload()).isEmpty();
  }

  @Test
  void payload_givenAttributeValue() {
    @SendBeforeCommit(payload = "foo")
    class Local {}
    ;

    final SendBeforeCommit annotation = Local.class.getAnnotation(SendBeforeCommit.class);
    assertThat(annotation.payload()).isEqualTo("foo");
  }

  @Test
  void condition_defaultValue() {
    @SendBeforeCommit
    class Local {}

    final SendBeforeCommit annotation = Local.class.getAnnotation(SendBeforeCommit.class);
    assertThat(annotation.condition()).isEmpty();
  }

  @Test
  void condition_givenAttributeValue() {
    @SendBeforeCommit(condition = "foo")
    class Local {}
    ;

    final SendBeforeCommit annotation = Local.class.getAnnotation(SendBeforeCommit.class);
    assertThat(annotation.condition()).isEqualTo("foo");
  }

  @Test
  void unless_defaultValue() {
    @SendBeforeCommit
    class Local {}

    final SendBeforeCommit annotation = Local.class.getAnnotation(SendBeforeCommit.class);
    assertThat(annotation.unless()).isEmpty();
  }

  @Test
  void unless_givenAttributeValue() {
    @SendBeforeCommit(unless = "foo")
    class Local {}
    ;

    final SendBeforeCommit annotation = Local.class.getAnnotation(SendBeforeCommit.class);
    assertThat(annotation.unless()).isEqualTo("foo");
  }
}
