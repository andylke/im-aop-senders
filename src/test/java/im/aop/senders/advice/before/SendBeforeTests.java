package im.aop.senders.advice.before;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link SendBefore}.
 *
 * @author Andy Lian
 */
class SendBeforeTests {

  @Test
  void payload_defaultValue() {
    @SendBefore
    class Local {}

    final SendBefore annotation = Local.class.getAnnotation(SendBefore.class);
    assertThat(annotation.payload()).isEmpty();
  }

  @Test
  void payload_givenAttributeValue() {
    @SendBefore(payload = "foo")
    class Local {}
    ;

    final SendBefore annotation = Local.class.getAnnotation(SendBefore.class);
    assertThat(annotation.payload()).isEqualTo("foo");
  }

  @Test
  void condition_defaultValue() {
    @SendBefore
    class Local {}

    final SendBefore annotation = Local.class.getAnnotation(SendBefore.class);
    assertThat(annotation.condition()).isEmpty();
  }

  @Test
  void condition_givenAttributeValue() {
    @SendBefore(condition = "foo")
    class Local {}
    ;

    final SendBefore annotation = Local.class.getAnnotation(SendBefore.class);
    assertThat(annotation.condition()).isEqualTo("foo");
  }

  @Test
  void unless_defaultValue() {
    @SendBefore
    class Local {}

    final SendBefore annotation = Local.class.getAnnotation(SendBefore.class);
    assertThat(annotation.unless()).isEmpty();
  }

  @Test
  void unless_givenAttributeValue() {
    @SendBefore(unless = "foo")
    class Local {}
    ;

    final SendBefore annotation = Local.class.getAnnotation(SendBefore.class);
    assertThat(annotation.unless()).isEqualTo("foo");
  }
}
