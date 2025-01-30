package im.aop.senders.advice.afterthrowing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link SendAfterThrowing}.
 *
 * @author Andy Lian
 */
class SendAfterThrowingTests {

  @Test
  void payload_defaultValue() {
    @SendAfterThrowing
    class Local {}

    final SendAfterThrowing annotation = Local.class.getAnnotation(SendAfterThrowing.class);
    assertThat(annotation.payload()).isEmpty();
  }

  @Test
  void payload_givenAttributeValue() {
    @SendAfterThrowing(payload = "foo")
    class Local {}
    ;

    final SendAfterThrowing annotation = Local.class.getAnnotation(SendAfterThrowing.class);
    assertThat(annotation.payload()).isEqualTo("foo");
  }

  @Test
  void condition_defaultValue() {
    @SendAfterThrowing
    class Local {}

    final SendAfterThrowing annotation = Local.class.getAnnotation(SendAfterThrowing.class);
    assertThat(annotation.condition()).isEmpty();
  }

  @Test
  void condition_givenAttributeValue() {
    @SendAfterThrowing(condition = "foo")
    class Local {}
    ;

    final SendAfterThrowing annotation = Local.class.getAnnotation(SendAfterThrowing.class);
    assertThat(annotation.condition()).isEqualTo("foo");
  }

  @Test
  void unless_defaultValue() {
    @SendAfterThrowing
    class Local {}

    final SendAfterThrowing annotation = Local.class.getAnnotation(SendAfterThrowing.class);
    assertThat(annotation.unless()).isEmpty();
  }

  @Test
  void unless_givenAttributeValue() {
    @SendAfterThrowing(unless = "foo")
    class Local {}
    ;

    final SendAfterThrowing annotation = Local.class.getAnnotation(SendAfterThrowing.class);
    assertThat(annotation.unless()).isEqualTo("foo");
  }
}
