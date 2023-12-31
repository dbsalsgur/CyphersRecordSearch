package com.cyphers.game.RecordSearch.controller.user;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyphers.game.RecordSearch.model.CrsUser;
import com.cyphers.game.RecordSearch.openapi.model.CyphersPlayerInfo;
import com.cyphers.game.RecordSearch.openapi.model.CyphersPlayerResponse;
import com.cyphers.game.RecordSearch.openapi.model.enumuration.CyphersPlayerWordType;
import com.cyphers.game.RecordSearch.openapi.service.CyphersApiService;
import com.cyphers.game.RecordSearch.service.user.CrsUserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final CrsUserService userService;
    private final CyphersApiService cyphersApiService;

    @Operation(summary = "사용자 추가", description = "사용자 추가를 위한 API를 지원")
    @GetMapping("/add/{userId}")
    public String add(@PathVariable("userId") String userId) {
        userService.register(userId, "test");
        return "사용자 생성이 완료되었습니다. ";
    }

    @GetMapping("/update/{userId}/{nickname}")
    public String update(@PathVariable("userId") String userId,
                         @PathVariable("nickname") String nickname) {
        Optional<CrsUser> user = userService.getUser(userId);
        if (user.isEmpty()) {
            return "사용자가 없습니다";
        }
        CrsUser crsUser = user.get();
        crsUser.setNickname(nickname);
        userService.upsertUser(crsUser);
        return "닉네임 설정이 완료되었습니다." ;
    }

    @GetMapping("/remove/{userId}")
    public String remove(@PathVariable("userId") String userId) {
        Optional<CrsUser> user = userService.getUser(userId);
        if (user.isEmpty()) {
            return "사용자가 없습니다";
        }
        CrsUser crsUser = user.get();
        userService.delete(crsUser);
        return "사용자 삭제가 완료되었습니다.";
    }

    @GetMapping("/all")
    public List<CrsUser> all() {
        return userService.getUserList();
    }

    @GetMapping("/get/{userId}")
    public CrsUser get(@PathVariable("userId") String userId) throws URISyntaxException, IOException {
        Optional<CrsUser> user = userService.getUser(userId);
        if (user.isEmpty()) {
            return null;
        }
        return user.get();
    }

    @GetMapping(value = {"/find/cyphers/{nickname}/{wordType}/{limit}", "/find/cyphers/{nickname}/{wordType}", "/find/cyphers/{nickname}"})
    public CyphersPlayerResponse findCyphersUsers(@PathVariable("nickname") String nickname,
                                                  @PathVariable(value = "wordType", required = false) CyphersPlayerWordType wordType,
                                                  @PathVariable(value = "limit", required = false) Integer limit) throws Exception {
        return cyphersApiService.searchPlayers(nickname, wordType, limit);
    }

    @GetMapping("/find/id/{playerId}")
    public CyphersPlayerInfo findCyphersUserInfo(@PathVariable("playerId") String playerId) throws Exception {
        CyphersPlayerInfo res = cyphersApiService.searchPlayerInfo(playerId);
        return res;
    }
}
