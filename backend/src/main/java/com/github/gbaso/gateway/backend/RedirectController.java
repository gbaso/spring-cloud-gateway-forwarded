package com.github.gbaso.gateway.backend;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RedirectController {

  @GetMapping("/redirect")
  void redirect(HttpServletResponse response) throws IOException {
    response.sendRedirect("/redirected");
  }
}
