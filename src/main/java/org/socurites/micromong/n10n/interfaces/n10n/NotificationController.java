package org.socurites.micromong.n10n.interfaces.n10n;

import lombok.RequiredArgsConstructor;
import org.socurites.micromong.n10n.application.n10n.NotificationFacade;
import org.socurites.micromong.n10n.common.response.CommonResponse;
import org.socurites.micromong.n10n.domain.n10n.NotificationCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notifications")
public class NotificationController {
    private final NotificationFacade notificationFacade;

    @PostMapping
    public CommonResponse<Void> send(
            @RequestBody @Valid NotificationDto.SendRequest request
    ) {
        NotificationCommand notificationCommand = request.toCommand();
        notificationFacade.send(notificationCommand);

        return CommonResponse.success();
    }

}
