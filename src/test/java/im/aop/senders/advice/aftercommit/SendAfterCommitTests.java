package im.aop.senders.advice.aftercommit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link SendAfterCommit}.
 *
 * @author Andy Lian
 */
class SendAfterCommitTests {

  @Test
  void payload_defaultValue() {
    @SendAfterCommit
    class Local {}

    final SendAfterCommit annotation = Local.class.getAnnotation(SendAfterCommit.class);
    assertThat(annotation.payload()).isEmpty();
  }

  @Test
  void payload_givenAttributeValue() {
    @SendAfterCommit(payload = "foo")
    class Local {}
    ;

    final SendAfterCommit annotation = Local.class.getAnnotation(SendAfterCommit.class);
    assertThat(annotation.payload()).isEqualTo("foo");
  }

  @Test
  void condition_defaultValue() {
    @SendAfterCommit
    class Local {}

    final SendAfterCommit annotation = Local.class.getAnnotation(SendAfterCommit.class);
    assertThat(annotation.condition()).isEmpty();
  }

  @Test
  void condition_givenAttributeValue() {
    @SendAfterCommit(condition = "foo")
    class Local {}
    ;

    final SendAfterCommit annotation = Local.class.getAnnotation(SendAfterCommit.class);
    assertThat(annotation.condition()).isEqualTo("foo");
  }

  @Test
  void unless_defaultValue() {
    @SendAfterCommit
    class Local {}

    final SendAfterCommit annotation = Local.class.getAnnotation(SendAfterCommit.class);
    assertThat(annotation.unless()).isEmpty();
  }

  @Test
  void unless_givenAttributeValue() {
    @SendAfterCommit(unless = "foo")
    class Local {}
    ;

    final SendAfterCommit annotation = Local.class.getAnnotation(SendAfterCommit.class);
    assertThat(annotation.unless()).isEqualTo("foo");
  }
}
