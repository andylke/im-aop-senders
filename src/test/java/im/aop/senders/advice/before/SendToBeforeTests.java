package im.aop.senders.advice.before;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link SendToBefore}.
 *
 * @author Andy Lian
 */
class SendToBeforeTests {

  @Test
  void payload_defaultValue() {
    @SendToBefore
    class Local {

    }

    final SendToBefore annotation = Local.class.getAnnotation(SendToBefore.class);
    assertThat(annotation.payload()).isEmpty();
  }

  @Test
  void payload_givenAttributeValue() {
    @SendToBefore(payload = "foo")
    class Local {

    }
    ;

    final SendToBefore annotation = Local.class.getAnnotation(SendToBefore.class);
    assertThat(annotation.payload()).isEqualTo("foo");
  }

  @Test
  void condition_defaultValue() {
    @SendToBefore
    class Local {

    }

    final SendToBefore annotation = Local.class.getAnnotation(SendToBefore.class);
    assertThat(annotation.condition()).isEmpty();
  }

  @Test
  void condition_givenAttributeValue() {
    @SendToBefore(condition = "foo")
    class Local {

    }
    ;

    final SendToBefore annotation = Local.class.getAnnotation(SendToBefore.class);
    assertThat(annotation.condition()).isEqualTo("foo");
  }

  @Test
  void unless_defaultValue() {
    @SendToBefore
    class Local {

    }

    final SendToBefore annotation = Local.class.getAnnotation(SendToBefore.class);
    assertThat(annotation.unless()).isEmpty();
  }

  @Test
  void unless_givenAttributeValue() {
    @SendToBefore(unless = "foo")
    class Local {

    }
    ;

    final SendToBefore annotation = Local.class.getAnnotation(SendToBefore.class);
    assertThat(annotation.unless()).isEqualTo("foo");
  }

}
