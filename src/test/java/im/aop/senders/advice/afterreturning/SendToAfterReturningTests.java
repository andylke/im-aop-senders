package im.aop.senders.advice.afterreturning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link SendToAfterCommit}.
 *
 * @author Andy Lian
 */
class SendToAfterReturningTests {

  @Test
  void payload_defaultValue() {
    @SendToAfterReturning
    class Local {

    }

    final SendToAfterReturning annotation = Local.class.getAnnotation(SendToAfterReturning.class);
    assertThat(annotation.payload()).isEmpty();
  }

  @Test
  void payload_givenAttributeValue() {
    @SendToAfterReturning(payload = "foo")
    class Local {

    }
    ;

    final SendToAfterReturning annotation = Local.class.getAnnotation(SendToAfterReturning.class);
    assertThat(annotation.payload()).isEqualTo("foo");
  }

  @Test
  void condition_defaultValue() {
    @SendToAfterReturning
    class Local {

    }

    final SendToAfterReturning annotation = Local.class.getAnnotation(SendToAfterReturning.class);
    assertThat(annotation.condition()).isEmpty();
  }

  @Test
  void condition_givenAttributeValue() {
    @SendToAfterReturning(condition = "foo")
    class Local {

    }
    ;

    final SendToAfterReturning annotation = Local.class.getAnnotation(SendToAfterReturning.class);
    assertThat(annotation.condition()).isEqualTo("foo");
  }

  @Test
  void unless_defaultValue() {
    @SendToAfterReturning
    class Local {

    }

    final SendToAfterReturning annotation = Local.class.getAnnotation(SendToAfterReturning.class);
    assertThat(annotation.unless()).isEmpty();
  }

  @Test
  void unless_givenAttributeValue() {
    @SendToAfterReturning(unless = "foo")
    class Local {

    }
    ;

    final SendToAfterReturning annotation = Local.class.getAnnotation(SendToAfterReturning.class);
    assertThat(annotation.unless()).isEqualTo("foo");
  }

}
