package com.cavehosting.users.Auth;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AuthConsumer {
  private final AuthService authService;

  public AuthConsumer(AuthService authService) {
    this.authService = authService;
  }

  @RabbitListener(queues = "users.queues")
  public void onUserReceived(String username) {
    authService.register(username);
  }
}
