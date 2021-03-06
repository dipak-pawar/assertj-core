/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2017 the original author or authors.
 */
package org.assertj.core.error;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.error.ClassModifierShouldBe.shouldBeFinal;
import static org.assertj.core.error.ClassModifierShouldBe.shouldNotBeFinal;

import org.assertj.core.internal.TestDescription;
import org.junit.Test;

public class ClassModifierShouldBe_create_Test {

  @Test
  public void should_create_error_message_for_is_final() {
    String error = shouldBeFinal(Object.class).create(new TestDescription("TEST"));

    assertThat(error).isEqualTo(format("[TEST] %n" +
                                       "Expecting:%n" +
                                       "  <java.lang.Object>%n" +
                                       "to be a \"final\" class but was \"public\"."));
  }

  @Test
  public void should_create_error_message_for_is_not_final() {
    String error = shouldNotBeFinal(String.class).create(new TestDescription("TEST"));

    assertThat(error).isEqualTo(format("[TEST] %n" +
                                       "Expecting:%n" +
                                       "  <java.lang.String>%n" +
                                       "not to be a \"final\" class but was \"public final\"."));
  }
}
