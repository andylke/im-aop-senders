package im.aop.senders.advice.afterrollback;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link SendAfterRollback}.
 *
 * @author Andy Lian
 */
class SendAfterRollbackTests {

  @Test
  void payload_defaultValue() {
    @SendAfterRollback
    class Local {}

    final SendAfterRollback annotation = Local.class.getAnnotation(SendAfterRollback.class);
    assertThat(annotation.payload()).isEmpty();
  }

  @Test
  void payload_givenAttributeValue() {
    @SendAfterRollback(payload = "foo")
    class Local {}
    ;

    final SendAfterRollback annotation = Local.class.getAnnotation(SendAfterRollback.class);
    assertThat(annotation.payload()).isEqualTo("foo");
  }

  @Test
  void condition_defaultValue() {
    @SendAfterRollback
    class Local {}

    final SendAfterRollback annotation = Local.class.getAnnotation(SendAfterRollback.class);
    assertThat(annotation.condition()).isEmpty();
  }

  @Test
  void condition_givenAttributeValue() {
    @SendAfterRollback(condition = "foo")
    class Local {}
    ;

    final SendAfterRollback annotation = Local.class.getAnnotation(SendAfterRollback.class);
    assertThat(annotation.condition()).isEqualTo("foo");
  }

  @Test
  void unless_defaultValue() {
    @SendAfterRollback
    class Local {}

    final SendAfterRollback annotation = Local.class.getAnnotation(SendAfterRollback.class);
    assertThat(annotation.unless()).isEmpty();
  }

  @Test
  void unless_givenAttributeValue() {
    @SendAfterRollback(unless = "foo")
    class Local {}
    ;

    final SendAfterRollback annotation = Local.class.getAnnotation(SendAfterRollback.class);
    assertThat(annotation.unless()).isEqualTo("foo");
  }
}
