package com.github.gbaso.gateway.backend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResult;

@WebMvcTest(RedirectController.class)
class RedirectControllerTest {

  @Autowired
  MockMvcTester mvcTester;

  @Test
  void testRedirect() {
    MvcTestResult result = mvcTester.get().uri("/redirect").exchange();

    assertThat(result).hasStatus3xxRedirection().hasRedirectedUrl("/redirected");
  }

}
