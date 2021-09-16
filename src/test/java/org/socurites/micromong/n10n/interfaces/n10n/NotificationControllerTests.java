package org.socurites.micromong.n10n.interfaces.n10n;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.socurites.micromong.n10n.common.response.CommonResponse;
import org.socurites.micromong.n10n.domain.n10n.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NotificationControllerTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void sendEmailSuccess() {
        final String requestUrl = String.format("http://localhost:%d/api/v1/notifications", port);

        NotificationDto.SendRequest request = NotificationDto.SendRequest.builder()
                .type("EMAIL")
                .sender("kmong-official@kmong.com")
                .receiver("you@hotmail.com")
                .body("Thank you for joining kmong...")
                .title("You got email")
                .build();

        CommonResponse<Void> commonResponse = restTemplate.exchange(requestUrl,
                HttpMethod.POST,
                new HttpEntity<>(request),
                new ParameterizedTypeReference<CommonResponse<Void>>() {
                }).getBody();

        assertThat(commonResponse.getResult()).isEqualTo(CommonResponse.Result.SUCCESS);
    }

    @Test
    public void sendSmsFailureBcausePhoneIsNotCorrect() {
        final String requestUrl = String.format("http://localhost:%d/api/v1/notifications", port);

        NotificationDto.SendRequest request = NotificationDto.SendRequest.builder()
                .type("EMAIL")
                .sender("kmong-official@kmong.com")
                .receiver("111-1-1111")
                .body("Thank you for joining kmong...")
                .title("You got email")
                .build();

        CommonResponse<Void> commonResponse = restTemplate.exchange(requestUrl,
                HttpMethod.POST,
                new HttpEntity<>(request),
                new ParameterizedTypeReference<CommonResponse<Void>>() {
                }).getBody();

        assertThat(commonResponse.getResult()).isEqualTo(CommonResponse.Result.FAIL);
    }

}
