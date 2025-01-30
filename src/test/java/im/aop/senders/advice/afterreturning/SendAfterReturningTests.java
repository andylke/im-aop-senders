package im.aop.senders.advice.afterreturning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link SendAfterReturning}.
 *
 * @author Andy Lian
 */
class SendAfterReturningTests {

  @Test
  void payload_defaultValue() {
    @SendAfterReturning
    class Local {}

    final SendAfterReturning annotation = Local.class.getAnnotation(SendAfterReturning.class);
    assertThat(annotation.payload()).isEmpty();
  }

  @Test
  void payload_givenAttributeValue() {
    @SendAfterReturning(payload = "foo")
    class Local {}
    ;

    final SendAfterReturning annotation = Local.class.getAnnotation(SendAfterReturning.class);
    assertThat(annotation.payload()).isEqualTo("foo");
  }

  @Test
  void condition_defaultValue() {
    @SendAfterReturning
    class Local {}

    final SendAfterReturning annotation = Local.class.getAnnotation(SendAfterReturning.class);
    assertThat(annotation.condition()).isEmpty();
  }

  @Test
  void condition_givenAttributeValue() {
    @SendAfterReturning(condition = "foo")
    class Local {}
    ;

    final SendAfterReturning annotation = Local.class.getAnnotation(SendAfterReturning.class);
    assertThat(annotation.condition()).isEqualTo("foo");
  }

  @Test
  void unless_defaultValue() {
    @SendAfterReturning
    class Local {}

    final SendAfterReturning annotation = Local.class.getAnnotation(SendAfterReturning.class);
    assertThat(annotation.unless()).isEmpty();
  }

  @Test
  void unless_givenAttributeValue() {
    @SendAfterReturning(unless = "foo")
    class Local {}
    ;

    final SendAfterReturning annotation = Local.class.getAnnotation(SendAfterReturning.class);
    assertThat(annotation.unless()).isEqualTo("foo");
  }
}
