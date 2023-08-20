package im.aop.senders.advice.afterthrowing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link SendToAfterThrowing}.
 *
 * @author Andy Lian
 */
class SendToAfterThrowingTests {

  @Test
  void payload_defaultValue() {
    @SendToAfterThrowing
    class Local {

    }

    final SendToAfterThrowing annotation = Local.class.getAnnotation(SendToAfterThrowing.class);
    assertThat(annotation.payload()).isEmpty();
  }

  @Test
  void payload_givenAttributeValue() {
    @SendToAfterThrowing(payload = "foo")
    class Local {

    }
    ;

    final SendToAfterThrowing annotation = Local.class.getAnnotation(SendToAfterThrowing.class);
    assertThat(annotation.payload()).isEqualTo("foo");
  }

  @Test
  void condition_defaultValue() {
    @SendToAfterThrowing
    class Local {

    }

    final SendToAfterThrowing annotation = Local.class.getAnnotation(
        SendToAfterThrowing.class);
    assertThat(annotation.condition()).isEmpty();
  }

  @Test
  void condition_givenAttributeValue() {
    @SendToAfterThrowing(condition = "foo")
    class Local {

    }
    ;

    final SendToAfterThrowing annotation = Local.class.getAnnotation(
        SendToAfterThrowing.class);
    assertThat(annotation.condition()).isEqualTo("foo");
  }

  @Test
  void unless_defaultValue() {
    @SendToAfterThrowing
    class Local {

    }

    final SendToAfterThrowing annotation = Local.class.getAnnotation(SendToAfterThrowing.class);
    assertThat(annotation.unless()).isEmpty();
  }

  @Test
  void unless_givenAttributeValue() {
    @SendToAfterThrowing(unless = "foo")
    class Local {

    }
    ;

    final SendToAfterThrowing annotation = Local.class.getAnnotation(SendToAfterThrowing.class);
    assertThat(annotation.unless()).isEqualTo("foo");
  }

}
